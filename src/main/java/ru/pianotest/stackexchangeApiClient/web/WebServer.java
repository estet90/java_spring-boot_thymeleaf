package ru.pianotest.stackexchangeApiClient.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by admin on 19.08.2016.
 */
@SpringBootApplication
public class WebServer  {

    private static final Logger LOGGER = Logger.getLogger(WebServer.class);

    public static void main (String[] args) {
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
