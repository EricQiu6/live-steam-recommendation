package com.ericqiu.twitch.item;

import com.ericqiu.twitch.external.TwitchService;
import com.ericqiu.twitch.external.model.Clip;
import com.ericqiu.twitch.external.model.Stream;
import com.ericqiu.twitch.external.model.Video;
import com.ericqiu.twitch.model.TypeGroupedItemList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private static final int SEARCH_RESULT_SIZE = 20;

    private final TwitchService twitchService;

    public ItemService(TwitchService twitchService) {
        this.twitchService = twitchService;
    }

    /*
    converts data from twitch into itemEntityLists
     */
    public TypeGroupedItemList getItems(String gameId) {
        List<Video> videos = twitchService.getVideos(gameId, SEARCH_RESULT_SIZE);
        List<Clip> clips = twitchService.getClips(gameId, SEARCH_RESULT_SIZE);
        List<Stream> streams = twitchService.getStreams(List.of(gameId), SEARCH_RESULT_SIZE);
        return new TypeGroupedItemList(gameId, streams, videos, clips);
    }
}
