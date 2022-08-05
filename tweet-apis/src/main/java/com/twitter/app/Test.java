package com.twitter.app;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.entity.UserTweetsData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<Long, List<String>> map = new HashMap<>();
        List<UserTweetsData> tweets = mapper.readValue(new File("C:\\Users\\Kamma Ganesh\\Desktop\\tweets.json"), new TypeReference<List<UserTweetsData>>() {
        });
        tweets.stream().forEach(tw -> {
            try {
                map.put(tw.getTweetId(), extractURL(mapper.writeValueAsString(tw)));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(map);
    }
    public static List<String> extractURL(String str) {

        List<String> list = new ArrayList<>();
        String regex
                = "\\b((?:https?|ftp|file):"
                + "//[-a-zA-Z0-9+&@#/%?="
                + "~_|!:, .;]*[-a-zA-Z0-9+"
                + "&@#/%=~_|])";
        Pattern p = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(str);

        while (m.find()) {
            list.add(str.substring(
                    m.start(0), m.end(0)));
        }
    return list;
    }

}
