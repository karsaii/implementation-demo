package net.implementation.demo.common.constants;

import net.implementation.demo.common.records.Credentials;

public abstract class CredentialsConstants {
    public static final Credentials NULL_CREDENTIALS = new Credentials("", "", "");
    public static final Credentials STANDARD_USER_CREDENTIALS = new Credentials("standard_user", "secret_sauce", "Test case 2 user credentials");
}
