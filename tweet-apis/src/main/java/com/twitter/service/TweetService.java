package com.twitter.service;

import com.twitter.dto.GetTweetUsersResponse;
import com.twitter.dto.GetTweetsResponse;

import java.util.List;
import java.util.Map;

public interface TweetService {
    public List<GetTweetsResponse> getAllTweets();
    public List<GetTweetUsersResponse> getTweetUsers();
    public GetTweetsResponse getTweetDetails( String tweetId);
    public GetTweetUsersResponse getProfileData(String screenName);
    public Map<Long,List<String>> getAllTweetLinks();
}
