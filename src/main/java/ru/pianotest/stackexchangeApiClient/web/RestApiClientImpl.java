package ru.pianotest.stackexchangeApiClient.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.pianotest.stackexchangeApiClient.entities.StackExchangeResponseItems;

import java.util.Map;

/**
 * реализация клиента для работы с REST API StackExchange
 */
@Component("restApiClient")
@PropertySource("classpath:config.properties")
public class RestApiClientImpl implements RestApiClient{

    private static final Logger LOGGER = Logger.getLogger(RestApiClientImpl.class);

    @Value("${api.stackexchange.url}")
    private String url;

    private static Client client = Client.create();
    static
    {
        client.addFilter(new GZIPContentEncodingFilter());
    }
    private static ObjectMapper mapper = new ObjectMapper();

    public StackExchangeResponseItems search(Map<String, Object> searchParameters) throws Exception {

        WebResource webResource = client.resource(url);
        for (String key : searchParameters.keySet()){
            if (searchParameters.get(key) != null)
                webResource = webResource.queryParam(key, String.valueOf(searchParameters.get(key)));
        }
        StackExchangeResponseItems result;
        LOGGER.info(webResource.getURI().toString());
        String json = webResource.get(String.class);
        LOGGER.debug(json);
        result = mapper.readValue(json, StackExchangeResponseItems.class);
        return result;
    }
}