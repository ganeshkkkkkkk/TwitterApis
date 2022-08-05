package com.twitter.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.dto.GetTweetUsersResponse;
import com.twitter.dto.GetTweetsResponse;
import com.twitter.entity.UserTweetsData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class TweetServiceImplTest {

    private List<UserTweetsData> tweets;
    private ObjectMapper mapper;

    private TweetService tweetService;

    @BeforeEach
    void setUp() throws IOException {
        tweetService = new TweetServiceImpl();
        mapper = new ObjectMapper();
        tweets = mapper.readValue(new File("C:\\Users\\Kamma Ganesh\\Desktop\\tweets.json"), new TypeReference<List<UserTweetsData>>() {
        });
        ReflectionTestUtils.setField(tweetService,"mapper",mapper);
        ReflectionTestUtils.setField(tweetService,"tweets",tweets);
    }

    @Test
    void getAllTweets() {
        List<GetTweetsResponse> responses= tweetService.getAllTweets();
        Assertions.assertThat(responses).isNotNull();
        Assertions.assertThat(responses).hasSize(5);
    }

    @Test
    void getTweetUsers() {
        List<GetTweetUsersResponse> responses= tweetService.getTweetUsers();
        Assertions.assertThat(responses).isNotNull();
        Assertions.assertThat(responses).hasSize(5);
    }

    @Test
    void getTweetDetails() {
        GetTweetsResponse responses= tweetService.getTweetDetails("311432631726264320");
        Assertions.assertThat(responses).isNotNull();
        Assertions.assertThat(responses).asString().contains("311432631726264320");
    }

    @Test
    void getProfileData() {
        GetTweetUsersResponse responses= tweetService.getProfileData("timoreilly");
        Assertions.assertThat(responses).isNotNull();
        Assertions.assertThat(responses).asString().contains("userId=2384071");
    }

    @Test
    void getAllTweetLinks() {
        Map<Long, List<String>> responses= tweetService.getAllTweetLinks();
        Assertions.assertThat(responses).isNotNull();
        Assertions.assertThat(responses).asString().contains("http://twitter.com/download/iphone");
    }
}