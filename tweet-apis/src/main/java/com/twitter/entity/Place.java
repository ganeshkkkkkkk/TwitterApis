package com.twitter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("place_type")
    private String placeType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("polylines")
    private String[] polyLines;
    @JsonProperty("bounding_box")
    private Map<String, Object> boundingBox;
    @JsonProperty("attributes")
    private Object attribute;

}
