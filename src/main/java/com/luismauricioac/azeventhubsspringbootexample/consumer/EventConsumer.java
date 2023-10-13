package com.luismauricioac.azeventhubsspringbootexample.consumer;

import com.luismauricioac.azeventhubsspringbootexample.domain.EventMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class EventConsumer {

    @Bean
    public Consumer<EventMessage> consume() {
        return message -> {
            log.info("Message received : {}", message);
        };
    }

    @ServiceActivator(inputChannel = "example-eventhub.$Default.errors")
    public void consumerError(Message<?> message) {
        log.error("Handling consumer ERROR: " + message);
    }

}
