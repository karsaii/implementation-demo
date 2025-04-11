package net.implementation.demo.common.constants;

import com.neathorium.thorium.java.extensions.namespaces.utilities.StringUtilities;

public abstract class PathConstants {
    private static final String USER_DIRECTORY_PATH = System.getProperty("user.dir", "");
    public static final String PROJECT_BASE_RUN_DIRECTORY_PATH = (StringUtilities.endsWithCaseInsensitive(PathConstants.USER_DIRECTORY_PATH, "/") ? PathConstants.USER_DIRECTORY_PATH : PathConstants.USER_DIRECTORY_PATH + "/").replace("\\\\", "/").replace("\\", "/");
    public static final String TEST_RESOURCES_DIRECTORY_PATH = "src/test/resources/";
    public static final String CREDENTIALS_FILE_PATH = PathConstants.TEST_RESOURCES_DIRECTORY_PATH + "credential.json";

    public static final String TYPICODE_BASE_URL = "https://jsonplaceholder.typicode.com/";

}
