CREATE TABLE payment (
                         id    BIGINT PRIMARY KEY,
                         price DECIMAL(30, 8) NOT NULL
);

INSERT INTO payment VALUES (1, 10.0);