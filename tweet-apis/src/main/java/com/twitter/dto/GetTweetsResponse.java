package com.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTweetsResponse {

    private Long tweetId;
    private String createdDate;
    private String tweetText;

}
