package com.twitter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntitiesUrls {

    @JsonProperty("url")
    private String userEntityUrl;
    @JsonProperty("expanded_url")
    private String userEntityExpandedUrl;
    @JsonProperty("display_url")
    private String userEntityDisplayUrl;
    @JsonProperty("indices")
    private int[] userEntityIndices;

}
