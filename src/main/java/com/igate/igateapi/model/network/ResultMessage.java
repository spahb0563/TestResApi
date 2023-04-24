package com.igate.igateapi.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
public class ResultMessage {

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "httpStatus")
    private HttpStatus httpStatus;

}
