package br.com.openpix.sdk;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This is the Woovi SDK entrypoint class, whose implements the api calls to the Woovi HTTP API.
 */
public final class WooviSdk {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    @NotNull
    private final OkHttpClient httpClient;

    /**
     * Creates a new Woovi Sdk instance with the given http client.
     *
     * @param httpClient Http client instance
     */
    public WooviSdk(@NotNull final OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Creates a simple Woovi Sdk instance.
     */
    public WooviSdk() {
        this(new OkHttpClient());
    }
}