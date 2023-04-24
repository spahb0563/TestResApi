package com.igate.igateapi.model.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DataHeader {

    @JsonProperty("DataType")
    private String dataType;

    @JsonProperty("DataLength")
    private String dataLength;

    @JsonProperty("ServiceID")
    private String serviceId;

    @JsonProperty("ScreenID")
    private String screenId;
    @JsonProperty("FormCount")
    private String formCount;
}
