CREATE TABLE producten
(
    id          INT 		AUTO_INCREMENT NOT NULL,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT        NOT NULL,
    price       FLOAT       NOT NULL,
    created_at  DATE        NOT NULL,
    updated_at  DATE        NOT NULL,
    primary key (id)
);