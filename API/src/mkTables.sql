CREATE TABLE producten
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT        NOT NULL,
    price       FLOAT       NOT NULL,
    spanish     BOOL        NOT NULL,
    warm        BOOL        NOT NULL,
    cold        BOOL        NOT NULL,
    vega        BOOL        NOT NULL
    created_at  DATE        NOT NULL,
    updated_at  DATE        NOT NULL,
);

CREATE TABLE gebruikers
(
    id         SERIAL      NOT NULL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    email      TEXT        NOT NULL UNIQUE,
    password   TEXT        NOT NULL,
    clocked    BOOL        NOT NULL DEFAULT FALSE
    created_at DATE        NOT NULL,
    updated_at DATE        NOT NULL,
);
