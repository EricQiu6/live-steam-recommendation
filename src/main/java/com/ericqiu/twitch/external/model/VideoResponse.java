package com.ericqiu.twitch.external.model;

import com.ericqiu.twitch.external.model.Video;
import java.util.List;

public record VideoResponse(
        List<Video> data
) {
}
