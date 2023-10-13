package com.luismauricioac.azeventhubsspringbootexample.service;

import com.luismauricioac.azeventhubsspringbootexample.domain.EventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventhubsService {

    public Mono<EventMessage> doPublish() {
        EventMessage message = EventMessage.builder()
                .message("My message test")
                .uuid(UUID.randomUUID())
                .build();
        return Mono.just(message);
    }
}
