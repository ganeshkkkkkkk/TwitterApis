package com.twitter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.dto.GetTweetUsersResponse;
import com.twitter.dto.GetTweetsResponse;
import com.twitter.entity.UserTweetsData;

import java.util.List;
import java.util.Map;

public class TweetFactory {

    public static List<GetTweetsResponse> getTweetsResponses() throws JsonProcessingException {
        String data= "[ {\n" +
                "        \"tweetId\": 311975360667459585,\n" +
                "        \"createdDate\": \"Wed Mar 13 23:01:36 +0000 2013\",\n" +
                "        \"tweetText\": \"Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm featured in it http://t.co/g6oSeEIEUr\"\n" +
                "    }]";
   return new ObjectMapper().readValue(data,new TypeReference<List<GetTweetsResponse>>() {});
    }

    public static List<GetTweetUsersResponse> getTweetsUsers() throws JsonProcessingException {
        String data= "[ {\n" +
                "        \"userId\": 2384071,\n" +
                "        \"name\": \"Tim O'Reilly\",\n" +
                "        \"location\": \"Sebastopol, CA\",\n" +
                "        \"isVerified\": true,\n" +
                "        \"friendsCount\": 1012,\n" +
                "        \"followersCount\": 1679016\n" +
                "    }]";
        return new ObjectMapper().readValue(data,new TypeReference<List<GetTweetUsersResponse>>() {});
    }

    public static GetTweetsResponse getTweetsResponse() throws JsonProcessingException {
        String data= " {\n" +
                "        \"tweetId\": 311975360667459585,\n" +
                "        \"createdDate\": \"Wed Mar 13 23:01:36 +0000 2013\",\n" +
                "        \"tweetText\": \"Was wondering why @billgates cc'd me on story abt @MSFTResearch cool viral search tool; discovered I'm featured in it http://t.co/g6oSeEIEUr\"\n" +
                "    }";
        return new ObjectMapper().readValue(data,GetTweetsResponse.class);
    }

    public static GetTweetUsersResponse getTweetsUser() throws JsonProcessingException {
        String data= "{\n" +
                "    \"userId\": 2384071,\n" +
                "    \"name\": \"Tim O'Reilly\",\n" +
                "    \"location\": \"Sebastopol, CA\",\n" +
                "    \"isVerified\": true,\n" +
                "    \"friendsCount\": 1012,\n" +
                "    \"followersCount\": 1679016\n" +
                "}";
        return new ObjectMapper().readValue(data,GetTweetUsersResponse.class);
    }

    public static Map<Long,List<String>> getTweetsLinks() throws JsonProcessingException {
        String data= "{ \"311432631726264320\": [\n" +
                "        \"http://t.co/QxDfp2GLcQ by @Jabaldaia http://t.co/CLcxKevjrY\",\n" +
                "        \"http://twitter.com/download/iphone\",\n" +
                "        \"http://our.risd.edu\",\n" +
                "        \"http://our.risd.edu\",\n" +
                "        \"http://a0.twimg.com/profile_background_images/704764772/1270a41ac6f3114c56aeec892ac3ed26.jpeg\",\n" +
                "        \"https://si0.twimg.com/profile_background_images/704764772/1270a41ac6f3114c56aeec892ac3ed26.jpeg\",\n" +
                "        \"http://a0.twimg.com/profile_images/1088325884/maedaicon2lg_normal.png\",\n" +
                "        \"https://si0.twimg.com/profile_images/1088325884/maedaicon2lg_normal.png\",\n" +
                "        \"https://api.twitter.com/1.1/geo/id/7b93be1d864cedbb.json\",\n" +
                "        \"http://t.co/QxDfp2GLcQ\",\n" +
                "        \"http://risd.cc/10H8XRE\"\n" +
                "    ]}";
        return new ObjectMapper().readValue(data,new TypeReference<Map<Long,List<String>>>() {});
    }
}
