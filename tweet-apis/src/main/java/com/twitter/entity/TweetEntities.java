package com.twitter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetEntities {

    @JsonProperty("hashtags")
    private List<Hashtag> hashtags;

    @JsonProperty("urls")
    private List<Urls> url;

    @JsonProperty("user_mentions")
    private List<UserMentions> userMentions;


}
