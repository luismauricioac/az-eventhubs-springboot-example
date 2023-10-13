package com.luismauricioac.azeventhubsspringbootexample.producer;

import com.luismauricioac.azeventhubsspringbootexample.domain.EventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class EventProducer {

    private final StreamBridge streamBridge;

    public void publishEvent(EventMessage message) {
        log.info("Sending message: {}", message);
        streamBridge.send("supply-out-0", message);
        log.info("Sent {}.", message);
    }

    @ServiceActivator(inputChannel = "example-eventhub.errors")
    public void producerError(Message<?> message) {
        log.error("Handling Producer ERROR: " + message);
    }
}
