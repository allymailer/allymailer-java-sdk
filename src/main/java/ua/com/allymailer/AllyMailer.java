package ua.com.allymailer;

import ua.com.allymailer.client.Configuration;

/**
 * Shortcut to create the AllyMailer API client.
 * <p>
 * AllyMailerClient client = AllyMailer.client("YOUR_API_KEY");
 */
public final class AllyMailer {
    private AllyMailer() {
    }

    /** &#64;param apiKey user or project API key */
    public static AllyMailerClient client(String apiKey) {
        return new AllyMailerClient(apiKey);
    }

    /**
     * &#64;param apiKey user or project API key
     * &#64;param host API host (Configuration.HOST_CP, "cp.allymailer.com") or a full base URL
     */
    public static AllyMailerClient client(String apiKey, String host) {
        return new AllyMailerClient(new Configuration(apiKey).setBaseUrl(Configuration.baseUrlFor(host)));
    }

    /** &#64;param config API connection settings (base URL, timeout, ...) */
    public static AllyMailerClient client(Configuration config) {
        return new AllyMailerClient(config);
    }
}
