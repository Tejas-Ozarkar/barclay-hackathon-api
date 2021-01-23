
CREATE TABLE IF NOT EXISTS user
(
    id        int AUTO_INCREMENT,
    firstName varchar(255),
    lastName  varchar(255),
    username  varchar(255),
    email     varchar(255),
    password  varchar(255),
    PRIMARY KEY (id)
);
