package net.implementation.demo.common.namespaces;

import com.neathorium.thorium.core.constants.validators.CoreFormatterConstants;
import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.factories.DataFactoryFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import com.neathorium.thorium.core.data.records.Data;
import com.neathorium.thorium.exceptions.constants.ExceptionConstants;
import com.neathorium.thorium.exceptions.namespaces.ExceptionFunctions;
import com.neathorium.thorium.java.extensions.namespaces.predicates.EqualsPredicates;
import com.neathorium.thorium.java.extensions.namespaces.utilities.BooleanUtilities;
import com.neathorium.thorium.java.extensions.namespaces.utilities.StringUtilities;
import net.implementation.demo.common.constants.PathConstants;
import net.implementation.demo.common.namespaces.validators.FileUtilsValidators;
import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileUtils {
    static Data<String> getCanonicalPath(String value) {
        final var nameof = "FileUtils.getCanonicalPath";
        final var errors = FileUtilsValidators.isValid(value);
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getWith("", false, nameof, errors);
        }

        final var path = Paths.get(value);
        Path canonicalPath = path;
        var exception = ExceptionConstants.EXCEPTION;
        try {
            canonicalPath = path.toRealPath().normalize();
        } catch (IOException ex) {
            exception = ex;
        }

        final var object = exception instanceof NoSuchFileException ? "" : canonicalPath.toString();
        final var exceptionStatus = ExceptionFunctions.isNonException(exception);
        final var status = StringUtils.isNotBlank(object);
        final var message = ((exceptionStatus ? "No " : "") + "Exception occurred during path handling" + CoreFormatterConstants.END_LINE) + ("Path canonicized to (\"" + object + "\")" + CoreFormatterConstants.END_LINE);

        return DataFactoryFunctions.getWith(object, status, nameof, message, exception);
    }

    static Data<Boolean> isCanonicalPath(String value) {
        final var nameof = "FileUtils.isCanonicalPath";
        final var errors = FileUtilsValidators.isValid(value);
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getInvalidWith(false, nameof, errors);
        }

        final var canonicalPathData = FileUtils.getCanonicalPath(value);
        final var exception = canonicalPathData.EXCEPTION();
        final var exceptionStatus = ExceptionFunctions.isNonException(exception);
        final var canonicalPath = DataFunctions.getObject(canonicalPathData);
        final var status = EqualsPredicates.isEqual(value, canonicalPath);
        final var message = exceptionStatus ? ("Path is " + (status ? "" : "non-") + "canonical") : "Exception occurred during path handling" + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getBoolean(status, nameof, message, exception);
    }

    static Data<Boolean> isAbsolutePath(String value) {
        final var nameof = "FileUtils.isAbsolutePath";
        final var errors = FileUtilsValidators.isValid(value);
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getInvalidWith(false, nameof, errors);
        }

        final var path = Paths.get(value);
        final var absolutePath = path.toAbsolutePath();
        final var status = EqualsPredicates.isEqual(absolutePath, path);
        final var message = "Path is " + (status ? "" : "non-") + "absolute";
        return DataFactoryFunctions.getBoolean(status, nameof, message);
    }

    static Data<Boolean> isRelativePath(String value) {
        final var nameof = "FileUtils.isRelativePath";
        final var errors = FileUtilsValidators.isValid(value);
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getInvalidWith(false, nameof, errors);
        }

        final var isCanonicalData = FileUtils.isCanonicalPath(value);
        final var isAbsoluteData = FileUtils.isAbsolutePath(value);

        final var canonicalException = isCanonicalData.EXCEPTION();
        final var exception = canonicalException instanceof NoSuchFileException ? ExceptionConstants.EXCEPTION : canonicalException;
        final var exceptionStatus = ExceptionFunctions.isNonException(exception);
        final var status = (
            (
                exceptionStatus &&
                BooleanUtilities.isFalse(DataFunctions.getStatus(isCanonicalData))
            ) &&
            BooleanUtilities.isFalse(DataFunctions.getStatus(isAbsoluteData))
        );
        final var message = exceptionStatus ? ("Path is " + (status ? "" : "non-") + "relative") : "Exception occurred during path handling" + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getBoolean(status, nameof, message, exception);
    }

    private static Path normalizePath(String path, boolean isRelativePath, boolean runningInJar) {
        Path finalPath = Paths.get(path);
        if (isRelativePath && runningInJar) {
            final var normalizedPath = path.substring(path.lastIndexOf("/"));
            finalPath = Paths.get(FileUtils.class.getClassLoader().getResource(normalizedPath).toString());
        }

        if (isRelativePath) {
            final var normalizedPath = StringUtilities.startsWithCaseInsensitive(path, "/") ? path.substring(1) : path;
            finalPath = Paths.get(PathConstants.PROJECT_BASE_RUN_DIRECTORY_PATH + normalizedPath);
        }

        return finalPath;
    }

    static Data<String> readFile(String path) {
        final var nameof = "FileUtils.readFile";
        final var errors = FileUtilsValidators.isValid(path);
        if (StringUtils.isNotBlank(errors)) {
            return DataFactoryFunctions.getInvalidWith("", nameof, errors);
        }

        final var runningInJar = JARUtilities.isInJar();
        final var isRelativePathData = FileUtils.isRelativePath(path);
        if (DataPredicates.isException(isRelativePathData)) {
            return DataFactoryFunctions.getWith("", DataFunctions.getStatus(isRelativePathData), nameof, DataFunctions.getMethodMessageData(isRelativePathData).MESSAGE(), isRelativePathData.EXCEPTION());
        }

        final var isRelativePath = DataFunctions.getStatus(isRelativePathData);
        final var normalizedPath = FileUtils.normalizePath(path, isRelativePath, runningInJar);
        var content = "";
        var exception = ExceptionConstants.EXCEPTION;
        try {
            content = String.join("", Files.readAllLines(normalizedPath, StandardCharsets.UTF_8));
        } catch (IOException ex) {
            content = "";
            exception = ex;
        }

        final var status = ExceptionFunctions.isNonException(exception);
        final var message = (status ? "No " : "") + "issues occurred during reading file(\"" + path + "\")" + CoreFormatterConstants.END_LINE;
        return DataFactoryFunctions.getWith(content, status, nameof, message, exception);
    }
}
