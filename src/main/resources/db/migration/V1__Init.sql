CREATE TABLE team
(
    id               BIGSERIAL    NOT NULL PRIMARY KEY,
    name             VARCHAR(100) NOT NULL,
    established_date DATE         NOT NULL,
    stadium          VARCHAR(100) NOT NULL,
    fight_song       VARCHAR(255),
    mascot           VARCHAR(100)
);

CREATE TABLE color
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE location
(
    team       INT PRIMARY KEY REFERENCES team (id),
    city       VARCHAR(100) NOT NULL,
    state      VARCHAR(100) NOT NULL,
    state_code VARCHAR(2)   NOT NULL,
    zip_code   VARCHAR(5)   NOT NULL
);

CREATE TABLE head_coach
(
    team       INT PRIMARY KEY REFERENCES team (id),
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    wins       INTEGER      NOT NULL,
    losses     INTEGER      NOT NULL,
    ties       INTEGER      NOT NULL,
    FOREIGN KEY (team)
        REFERENCES team (id)
);

CREATE TABLE team_color
(
    color INT,
    team  INT,
    PRIMARY KEY (color, team)
)