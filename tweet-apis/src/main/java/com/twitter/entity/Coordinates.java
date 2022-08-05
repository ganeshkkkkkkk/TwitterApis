package com.twitter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {

    @JsonProperty("type")
    private String type;
    @JsonProperty("coordinates")
    private Double[] coordinates;

}
