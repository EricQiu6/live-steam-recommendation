package com.ericqiu.twitch.external.model;

import com.ericqiu.twitch.external.model.Game;
import java.util.List;

public record GameResponse(
        List<Game> data
) {
}
