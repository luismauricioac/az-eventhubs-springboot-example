package com.luismauricioac.azeventhubsspringbootexample.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@Builder
@ToString
public class EventMessage {
    private String message;
    private UUID uuid;
}
