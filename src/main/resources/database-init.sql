-- reinitialize tables every start
DROP TABLE IF EXISTS favorite_records;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    enabled  TINYINT      NOT NULL DEFAULT 1
);

-- not really needed but here by default
CREATE TABLE authorities
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username  VARCHAR(255) NOT NULL,
    authority VARCHAR(255) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE
);

-- corresponds to storage of data in ItemEntity class in java
CREATE TABLE items
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    twitch_id VARCHAR(255) UNIQUE NOT NULL,
    title TEXT,
    url VARCHAR(255),
    thumbnail_url VARCHAR(255),
    broadcaster_name VARCHAR(255),
    game_id VARCHAR(255),
    type VARCHAR(255)
);

CREATE TABLE favorite_records
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    item_id INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    -- RELATES columns in this table to columns in another table,
    -- which ensures that db changes or errors are caught
    -- for example, deletes this row if other row is deleted
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (item_id) REFERENCES items(id) ON DELETE CASCADE,

    -- ensures that same user cannot like this same item multiple times
    UNIQUE KEY unique_item_and_user_combo (item_id, user_id)
);
