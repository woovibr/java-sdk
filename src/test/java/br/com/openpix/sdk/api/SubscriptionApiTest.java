/*
 * Woovi
 * A Woovi é uma Plataforma de Gestão de Pagamentos. Para utilizar nossa API você deve acessar  __[https://api.woovi.com/](https://api.woovi.com/)__ e somente o mesmo. A Woovi não aceita subdominios para a API.  Veja como configurar seu acesso a nossa API [aqui](https://developers.woovi.com/docs/apis/api-getting-started).
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package br.com.openpix.sdk.api;

import br.com.openpix.sdk.ApiException;
import br.com.openpix.sdk.model.ApiV1AccountAccountIdGet400Response;
import br.com.openpix.sdk.model.ApiV1SubscriptionsIdGet200Response;
import br.com.openpix.sdk.model.SubscriptionPayload;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SubscriptionApi
 */
@Disabled
public class SubscriptionApiTest {

    private final SubscriptionApi api = new SubscriptionApi();

    /**
     * Get one subscription
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void apiV1SubscriptionsIdGetTest() throws ApiException {
        String id = null;
        ApiV1SubscriptionsIdGet200Response response = api.apiV1SubscriptionsIdGet(id);
        // TODO: test validations
    }

    /**
     * Create a new Subscription
     *
     * Endpoint to create a new Subcription
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void apiV1SubscriptionsPostTest() throws ApiException {
        SubscriptionPayload subscriptionPayload = null;
        ApiV1SubscriptionsIdGet200Response response = api.apiV1SubscriptionsPost(subscriptionPayload);
        // TODO: test validations
    }

}
