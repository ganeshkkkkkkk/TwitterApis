package com.twitter.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTweetsData {
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("id")
    private Long tweetId;
    @JsonProperty("id_str")
    private String tweetIdStr;
    @JsonProperty("text")
    private String text;
    @JsonProperty("source")
    private String source;
    @JsonProperty("truncated")
    private boolean isTruncated;
    @JsonProperty("in_reply_to_status_id")
    private String inReplyToStatusId;
    @JsonProperty("in_reply_to_status_id_str")
    private String inReplyToStatusIdStr;
    @JsonProperty("in_reply_to_user_id")
    private String inReplyToUserId;
    @JsonProperty("in_reply_to_user_id_str")
    private String inReplyToUserIdStr;
    @JsonProperty("in_reply_to_screen_name")
    private String inReplyToScreenName;

    @JsonProperty("user")
    private TweetUser user;

    @JsonProperty("geo")
    private Geo geo;
    @JsonProperty("coordinates")
    private Coordinates coordinates;

    @JsonProperty("place")
    private Place place;

    @JsonProperty("contributors")
    private String contributors;
    @JsonProperty("retweet_count")
    private String retweetCount;

    @JsonProperty("entities")
    private TweetEntities tweetEntities;
    @JsonProperty("favorited")
    private boolean isFavorite;
    @JsonProperty("retweeted")
    private boolean isRetweeted;
    @JsonProperty("possibly_sensitive")
    private boolean isSensitive;

    @JsonProperty("lang")
    private String lang;

}
