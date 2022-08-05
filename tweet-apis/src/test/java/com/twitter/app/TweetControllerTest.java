package com.twitter.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.twitter.TweetFactory;
import com.twitter.dto.GetTweetUsersResponse;
import com.twitter.dto.GetTweetsResponse;
import com.twitter.service.TweetService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TweetControllerTest {

    @Mock
    private TweetService tweetService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getAllTweets() throws JsonProcessingException {
        Mockito.when(tweetService.getAllTweets()).thenReturn(TweetFactory.getTweetsResponses());
        ResponseEntity<List<GetTweetsResponse>> response = testRestTemplate.exchange("/tweets", HttpMethod.GET,null
                ,new ParameterizedTypeReference<List<GetTweetsResponse>>(){});

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).asString().contains("311975360667459585");
    }

    @Test
    void getTweetUsers() throws JsonProcessingException {
        Mockito.when(tweetService.getTweetUsers()).thenReturn(TweetFactory.getTweetsUsers());
        ResponseEntity<List<GetTweetUsersResponse>> response = testRestTemplate.exchange("/tweet/users", HttpMethod.GET,null
                ,new ParameterizedTypeReference<List<GetTweetUsersResponse>>(){});

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).asString().contains("userId=2384071");
    }

    @Test
    void getAllTweetLinks() throws JsonProcessingException {
        Mockito.when(tweetService.getAllTweetLinks()).thenReturn(TweetFactory.getTweetsLinks());
        ResponseEntity<Map<Long,List<String>>> response = testRestTemplate.exchange("/tweet/links", HttpMethod.GET,null
                ,new ParameterizedTypeReference<Map<Long,List<String>>>(){});

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).asString().contains("http://twitter.com/download/iphone");
        Assertions.assertThat(response.getBody()).asString().contains("http://our.risd.edu");
        Assertions.assertThat(response.getBody()).asString().contains("http://www.zephoria.org/thoughts");
    }

    @Test
    void getTweetDetails() throws JsonProcessingException {
        Mockito.when(tweetService.getTweetDetails(Mockito.anyString())).thenReturn(TweetFactory.getTweetsResponse());
        ResponseEntity<GetTweetsResponse> response = testRestTemplate.exchange("/tweet/{id}", HttpMethod.GET,null
                ,GetTweetsResponse.class,"311432631726264320");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).asString().contains("createdDate=Tue Mar 12 11:05:00 +0000 2013");
    }

    @Test
    void getProfileData() throws JsonProcessingException {
        Mockito.when(tweetService.getProfileData(Mockito.anyString())).thenReturn(TweetFactory.getTweetsUser());
        ResponseEntity<GetTweetUsersResponse> response = testRestTemplate.exchange("/tweet/user?screenName={name}", HttpMethod.GET,null
                ,GetTweetUsersResponse.class,"timoreilly");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).asString().contains("userId=2384071");
        Assertions.assertThat(response.getBody()).asString().contains("Sebastopol, CA");
    }
}