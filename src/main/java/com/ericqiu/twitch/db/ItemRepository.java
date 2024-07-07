package com.ericqiu.twitch.db;

import com.ericqiu.twitch.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ItemRepository extends ListCrudRepository<ItemEntity, Long> {

    //TODO: add more options for searches

    ItemEntity findByTwitchId(String twitchId);
}
