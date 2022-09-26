CREATE TABLE producten
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT        NOT NULL,
    price       FLOAT       NOT NULL,
    created_at  DATE        NOT NULL,
    updated_at  DATE        NOT NULL
);

CREATE TABLE gebruikers
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    email       TEXT        NOT NULL,
    password    TEXT        NOT NULL,
    created_at  DATE        NOT NULL,
    updated_at  DATE        NOT NULL
);