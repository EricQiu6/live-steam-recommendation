package com.ericqiu.twitch.db.entity;

import com.ericqiu.twitch.external.model.Clip;
import com.ericqiu.twitch.external.model.Stream;
import com.ericqiu.twitch.external.model.Video;
import com.ericqiu.twitch.model.ItemType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//a generic item class that wraps different
// types of data (e.g. stream, video, clip) into one
@Table("items")
public record ItemEntity(
        @Id Long id,
        @JsonProperty("twitch_id") String twitchId,
        String title,
        String url,
        @JsonProperty("thumbnail_url") String thumbnailUrl,
        @JsonProperty("broadcaster_name") String broadcasterName,
        @JsonProperty("game_id") String gameId,
        @JsonProperty("item_type") ItemType type
) {
    //note: twitch api for video does not provide game ID
    public ItemEntity(String gameId, Video video) {
        this(null, video.id(), video.title(), video.url(), video.thumbnailUrl(), video.userName(), gameId, ItemType.VIDEO);
    }

    public ItemEntity(Clip clip) {
        this(null, clip.id(), clip.title(), clip.url(), clip.thumbnailUrl(), clip.broadcasterName(), clip.gameId(), ItemType.CLIP);
    }

    public ItemEntity(Stream stream) {
        this(null, stream.id(), stream.title(), null, stream.thumbnailUrl(), stream.userName(), stream.gameId(), ItemType.STREAM);
    }
}
