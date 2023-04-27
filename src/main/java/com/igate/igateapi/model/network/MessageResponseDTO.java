package com.igate.igateapi.model.network;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Data
public class MessageResponseDTO {

    @JsonProperty(value = "MessageCode")
    private String messageCode;

    @JsonProperty(value = "MessageCount")
    private String messageCount;

    @JsonProperty(value = "MessageContent")
    private List<String> messageContent;

    public MessageResponseDTO() {
        messageCode = "test";
        messageCount = "1";
        messageContent = new ArrayList<>();
        messageContent.add("test message");
    }





}
