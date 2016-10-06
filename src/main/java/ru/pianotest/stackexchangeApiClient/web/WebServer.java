package ru.pianotest.stackexchangeApiClient.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс для запуска Jersey
 */
@SpringBootApplication
public class WebServer  {

private static final Logger LOGGER = LogManager.getLogger(WebServer.class);

    private static final String CONTEXT_PATH = "/stackexchangeApiClient";

    public static void main (String[] args) {
        System.setProperty("server.contextPath", CONTEXT_PATH);
        if (args.length == 1){
            try {
                int port = Integer.parseInt(args[0]);
                System.setProperty("server.port", String.valueOf(port));
                SpringApplication.run(WebServer.class, args);
            } catch (NumberFormatException e) {
                LOGGER.error("Номер порта должен иметь целочисленное значение");
            }
        } else
            SpringApplication.run(WebServer.class);
    }

}
