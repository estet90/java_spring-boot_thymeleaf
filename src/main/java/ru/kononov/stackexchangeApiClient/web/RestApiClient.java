package ru.kononov.stackexchangeApiClient.web;

import ru.kononov.stackexchangeApiClient.entities.StackExchangeResponseItems;

import java.util.Map;

/**
 * интерфейс для работы с REST API StackExchange
 */
public interface RestApiClient {

    /**
     * поиск объектов
     * @param searchParameters поисковый запрос
     * @return найденные запросы
     * @throws Exception
     */
    StackExchangeResponseItems search(Map<String, Object> searchParameters) throws Exception;

}
