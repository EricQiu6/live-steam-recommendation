package com.ericqiu.twitch.external;

import com.ericqiu.twitch.external.model.ClipResponse;
import com.ericqiu.twitch.external.model.GameResponse;
import com.ericqiu.twitch.external.model.StreamResponse;
import com.ericqiu.twitch.external.model.VideoResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Declarative HTTP Client to request data from twitch api, maps REST Api to my java implementation
// NOTE: name must match configuration in application.yml
@FeignClient(name = "twitch-api")
public interface TwitchApiClient {

    @GetMapping("/games")
    GameResponse getGames(@RequestParam("name") String name);

    @GetMapping("/games/top")
    GameResponse getTopGames();

    @GetMapping("/videos/")
    VideoResponse getVideos(@RequestParam("game_id") String gameId, @RequestParam("first") int first);

    @GetMapping("/clips/")
    ClipResponse getClips(@RequestParam("game_id") String gameId, @RequestParam("first") int first);

    @GetMapping("/streams/")
    StreamResponse getStreams(@RequestParam("game_id") List<String> gameIds, @RequestParam("first") int first);
}
