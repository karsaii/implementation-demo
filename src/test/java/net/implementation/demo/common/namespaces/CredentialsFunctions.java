package net.implementation.demo.common.namespaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neathorium.thorium.core.data.namespaces.DataFunctions;
import com.neathorium.thorium.core.data.namespaces.predicates.DataPredicates;
import net.implementation.demo.common.constants.CredentialsConstants;
import net.implementation.demo.common.constants.JSONConstants;
import net.implementation.demo.common.constants.PathConstants;
import net.implementation.demo.common.records.Credentials;

public interface CredentialsFunctions {
    static Credentials getCredentials(ObjectMapper mapper, String jsonPath) {
        final var jsonData = FileUtils.readFile(jsonPath);
        DataFunctions.throwIfException(jsonData);

        if (DataPredicates.isInvalidOrFalse(jsonData)) {
            return CredentialsConstants.NULL_CREDENTIALS;
        }

        final var json = DataFunctions.getObject(jsonData);
        final var credData = JSONFunctions.getCredentials(mapper, json);

        if (DataPredicates.isInvalidOrFalse(credData)) {
            return CredentialsConstants.NULL_CREDENTIALS;
        }

        return DataFunctions.getObject(credData);
    }

    static Credentials getCredentials() {
        return CredentialsFunctions.getCredentials(JSONConstants.MAPPER, PathConstants.CREDENTIALS_FILE_PATH);
    }
}
