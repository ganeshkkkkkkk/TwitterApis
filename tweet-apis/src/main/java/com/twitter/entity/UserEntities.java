package com.twitter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntities {

    @JsonProperty("url")
    private UserEntitiesUrl url;

    @JsonProperty("description")
    private Description description;

}
