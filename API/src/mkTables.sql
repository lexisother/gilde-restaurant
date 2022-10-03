CREATE TABLE producten
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    created_at  DATE        NOT NULL,
    updated_at  DATE        NOT NULL,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT        NOT NULL,
    price       FLOAT       NOT NULL,
    spanish     BOOL        NOT NULL,
    warm        BOOL        NOT NULL,
    cold        BOOL        NOT NULL,
    vega        BOOL        NOT NULL
);

CREATE TABLE gebruikers
(
    id         SERIAL      NOT NULL PRIMARY KEY,
    created_at DATE        NOT NULL,
    updated_at DATE        NOT NULL,
    name       VARCHAR(50) NOT NULL UNIQUE,
    email      TEXT        NOT NULL,
    password   TEXT        NOT NULL,
    clocked    BOOL        NOT NULL DEFAULT FALSE
);
