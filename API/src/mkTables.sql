CREATE TABLE producten
(
    created_at  DATE        NOT NULL,
    updated_at  DATE        NOT NULL,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT        NOT NULL,
    price       INT         NOT NULL
);