package com.ericqiu.twitch.db.entity;

import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// the @ Table and Id annotations are needed to connect java entity objects to database
@Table("favorite_records")
public record FavoriteRecordEntity(
        @Id Long id,
        Long userId,
        Long itemId,
        Instant createdAt
) {
}
