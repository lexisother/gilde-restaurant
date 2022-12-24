# This file is kept and updated for posterity.
# It is not actually used anymore for creating the database tables.
# See L43-L66 of index.php for that.

CREATE TABLE IF NOT EXISTS products
(
    id          SERIAL      NOT NULL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description TEXT        NOT NULL,
    price       FLOAT       NOT NULL,
    spanish     BOOL        NOT NULL,
    warm        BOOL        NOT NULL,
    cold        BOOL        NOT NULL,
    vega        BOOL        NOT NULL,
    created_at  DATE        NOT NULL,
    updated_at  DATE        NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL      NOT NULL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    email      TEXT        NOT NULL UNIQUE,
    password   TEXT        NOT NULL,
    clocked    BOOL        NOT NULL DEFAULT FALSE,
    created_at DATE        NOT NULL,
    updated_at DATE        NOT NULL
);

INSERT INTO products
VALUES (1, 'Sangria', ' ', 10, TRUE, FALSE, TRUE, TRUE, NOW(), NOW()),
       (2, 'Crostini met tapenade en mozzarella', ' ', 10, TRUE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (3, 'Ciabatta met tomaten jam en ansjovis', ' ', 10, TRUE, FALSE, TRUE, FALSE, NOW(), NOW()),
       (4, 'Perzik met serranoham hapje', ' ', 10, TRUE, FALSE, TRUE, FALSE, NOW(), NOW()),
       (5, 'Gazpacho', ' ', 10, TRUE, FALSE, TRUE, TRUE, NOW(), NOW()),
       (6, 'Gemarineerde olijven', ' ', 10, TRUE, FALSE, TRUE, TRUE, NOW(), NOW()),
       (7, 'Pincho''s met geitenkaas', ' ', 10, TRUE, FALSE, TRUE, FALSE, NOW(), NOW()),
       (8, 'Calamaris (inktvisringen)', ' ', 10, TRUE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (9, 'Serranoham met mozzarella hapje', ' ', 10, TRUE, FALSE, TRUE, FALSE, NOW(), NOW()),
       (10, 'Spaanse Torlillia de Patatas', ' ', 10, TRUE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (11, 'Crema Catalana', ' ', 10, TRUE, FALSE, TRUE, FALSE, NOW(), NOW()),
       (12, 'Empanadillas', ' ', 10, TRUE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (13, 'Groene pepers met roomkaas', ' ', 10, TRUE, FALSE, TRUE, TRUE, NOW(), NOW()),
       (14, 'Albondigas', ' ', 10, TRUE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (15, 'Patatas Bravas', ' ', 10, TRUE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (16, 'Churros met kaneel', ' ', 10, TRUE, TRUE, FALSE, TRUE, NOW(), NOW()),
       (17, 'Kip teriyaki', ' ', 10, FALSE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (18, 'Kip fajitas', ' ', 10, FALSE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (19, 'Nacho''s met pulled pork', ' ', 10, FALSE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (20, 'Gnocchi di patata', ' ', 10, FALSE, TRUE, FALSE, TRUE, NOW(), NOW()),
       (21, 'Garnalen kroketten', ' ', 10, FALSE, TRUE, FALSE, FALSE, NOW(), NOW()),
       (22, 'Brushetta ', ' ', 10, FALSE, TRUE, TRUE, TRUE, NOW(), NOW()),
       (23, 'Caprese salade', ' ', 10, FALSE, FALSE, TRUE, TRUE, NOW(), NOW()),
       (24, 'Filodeeg pizzaatjes', ' ', 10, FALSE, TRUE, FALSE, TRUE, NOW(), NOW()),
       (25, 'Guacamole', ' ', 10, FALSE, FALSE, TRUE, TRUE, NOW(), NOW());
