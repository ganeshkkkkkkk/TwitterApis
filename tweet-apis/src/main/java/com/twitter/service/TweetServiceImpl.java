package com.twitter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.dto.GetTweetUsersResponse;
import com.twitter.dto.GetTweetsResponse;
import com.twitter.entity.UserTweetsData;
import com.twitter.util.TweetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class TweetServiceImpl implements TweetService {

    private List<UserTweetsData> tweets;
    private ObjectMapper mapper;

    @PostConstruct
    public void setup() throws StreamReadException, DatabindException, IOException {
        mapper = new ObjectMapper();
        tweets = mapper.readValue(new File("C:\\Users\\Kamma Ganesh\\Desktop\\tweets.json"), new TypeReference<List<UserTweetsData>>() {
        });
    }

    @Override
    public List<GetTweetsResponse> getAllTweets() {
        return tweets.stream().map(TweetMapper::mapTweetsResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<GetTweetUsersResponse> getTweetUsers() {
        return tweets.stream().map(UserTweetsData::getUser)
                .map(TweetMapper::mapTweetUserResponse).collect(Collectors.toList());
    }

    @Override
    public GetTweetsResponse getTweetDetails(String tweetId) {
        return tweets.stream().filter(tw -> Objects.equals(tweetId, String.valueOf(tw.getTweetId())))
                .map(TweetMapper::mapTweetsResponse).findFirst().get();
    }

    @Override
    public GetTweetUsersResponse getProfileData(String screenName) {
        return tweets.stream().map(UserTweetsData::getUser)
                .filter(user -> Objects.equals(screenName, user.getScreenName()))
                .map(TweetMapper::mapTweetUserResponse).findFirst().get();
    }

    @Override
    public Map<Long, List<String>> getAllTweetLinks() {
        Map<Long, List<String>> map = new HashMap<>();
        tweets.stream().forEach(tw -> {
            try {
                map.put(tw.getTweetId(), extractURL(mapper.writeValueAsString(tw)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return map;
    }

    private List<String> extractURL(String str) {

        List<String> list = new ArrayList<>();
        String regex = "\\b((?:https?|ftp|file):" + "//[-a-zA-Z0-9+&@#/%?=" + "~_|!:, .;]*[-a-zA-Z0-9+" + "&@#/%=~_|])";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);

        while (m.find()) {
            list.add(str.substring(m.start(0), m.end(0)));
        }
        return list;
    }
}
