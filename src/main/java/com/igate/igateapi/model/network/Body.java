package com.igate.igateapi.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Body<T> {

    @JsonProperty("DataHeader")
    private DataHeader dataHeader; // "DataHeader"

    @JsonProperty("DataBody")
    private T dataBody;
}
