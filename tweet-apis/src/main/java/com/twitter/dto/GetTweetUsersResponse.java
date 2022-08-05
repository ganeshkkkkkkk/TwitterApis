package com.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTweetUsersResponse {
    private Long userId;
    private String name;
    private String location;
    private Boolean isVerified;
    private int friendsCount;
    private int followersCount;
}
