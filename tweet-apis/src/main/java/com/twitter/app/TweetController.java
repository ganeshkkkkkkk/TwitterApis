package com.twitter.app;

import com.twitter.dto.GetTweetUsersResponse;
import com.twitter.dto.GetTweetsResponse;
import com.twitter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TweetController {

    @Autowired
    private TweetService  tweetService;

    @GetMapping(value = "/tweets")
    public ResponseEntity<List<GetTweetsResponse>> getAllTweets() {
        return ResponseEntity.ok(tweetService.getAllTweets());
    }

    @GetMapping(value = "/tweet/users")
    public ResponseEntity<List<GetTweetUsersResponse>> getTweetUsers() {
        return ResponseEntity.ok(tweetService.getTweetUsers());
    }

    @GetMapping(value = "/tweet/links")
    public ResponseEntity<Map<Long,List<String>>> getAllTweetLinks() {
        return ResponseEntity.ok(tweetService.getAllTweetLinks());
    }

    @GetMapping(value = "/tweet/{id}")
    public ResponseEntity<GetTweetsResponse> getTweetDetails(@PathVariable("id") String tweetId) {
        return ResponseEntity.ok(tweetService.getTweetDetails(tweetId));
    }

    @GetMapping(value = "/tweet/user")
    public ResponseEntity<GetTweetUsersResponse> getProfileData(@RequestParam("screenName") String screenName) {
        return ResponseEntity.ok(tweetService.getProfileData(screenName));
    }

}
