package com.twitter.util;

import com.twitter.dto.GetTweetUsersResponse;
import com.twitter.dto.GetTweetsResponse;
import com.twitter.entity.TweetUser;
import com.twitter.entity.UserTweetsData;
import org.springframework.stereotype.Component;

@Component
public class TweetMapper {

    public static GetTweetsResponse mapTweetsResponse(UserTweetsData tweetsData) {
        return GetTweetsResponse.builder()
                .tweetId(tweetsData.getTweetId())
                .createdDate(tweetsData.getCreatedAt())
                .tweetText(tweetsData.getText())
                .build();
    }

    public static GetTweetUsersResponse mapTweetUserResponse(TweetUser tweetUser) {
        return GetTweetUsersResponse.builder()
                .userId(tweetUser.getId())
                .name(tweetUser.getName())
                .location(tweetUser.getLocation())
                .followersCount(tweetUser.getFollowersCount())
                .friendsCount(tweetUser.getFriendsCount())
                .isVerified(tweetUser.isVerified())
                .build();
    }

}
