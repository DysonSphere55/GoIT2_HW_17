CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    enabled BOOLEAN
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled)
VALUES ('user', '{noop}jdbcDefault', TRUE),
       ('admin', '{noop}default', TRUE);

INSERT INTO authorities (username, authority)
VALUES  ('user', 'ROLE_USER'),
        ('admin', 'ROLE_ADMIN');