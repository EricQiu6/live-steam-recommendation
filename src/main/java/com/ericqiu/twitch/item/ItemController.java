package com.ericqiu.twitch.item;

import com.ericqiu.twitch.model.TypeGroupedItemList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;

    //Note that when running, we ourselves don't actually pass the itemService object (which then requires other objects...),
    //rather, this is done automatically by spring boot for convenience(e.g. dependency injection)
    //this is achieved by the various @ annotations to tell spring what to look for
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    /*
    connects url mapping to the getItems method
     */
    @GetMapping("/search")
    public TypeGroupedItemList search(@RequestParam("game_id") String gameId) {
        return itemService.getItems(gameId);
    }
}
