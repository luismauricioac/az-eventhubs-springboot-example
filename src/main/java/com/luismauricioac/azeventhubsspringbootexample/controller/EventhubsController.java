package com.luismauricioac.azeventhubsspringbootexample.controller;

import com.luismauricioac.azeventhubsspringbootexample.domain.EventMessage;
import com.luismauricioac.azeventhubsspringbootexample.producer.EventProducer;
import com.luismauricioac.azeventhubsspringbootexample.service.EventhubsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EventhubsController {
    private final EventhubsService eventhubsService;
    private final EventProducer eventProducer;

    @PostMapping("/publishMessage")
    public Mono<ResponseEntity<EventMessage>> publishMessage() {
        return eventhubsService.doPublish()
                .publishOn(Schedulers.boundedElastic())
                .doOnSuccess(eventProducer::publishEvent)
                .map(ResponseEntity::ok);
    }
}
