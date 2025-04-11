package net.implementation.demo.typicodejson.constants;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public abstract class RestConstants {
    public static final String FUNCTION_NAME = "RestFunctions.";
    public static final OkHttpClient CLIENT = new OkHttpClient.Builder().build();
    public static final Request.Builder DEFAULT_WRONG_BUILDER = new Request.Builder().addHeader("NOPE", "NOPE");
}
