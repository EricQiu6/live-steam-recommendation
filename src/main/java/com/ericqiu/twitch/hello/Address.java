package com.ericqiu.twitch.hello;

public record Address(
        String street,
        String city,
        String state,
        String country
) {
}
