

CREATE TABLE passenger (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE flight (
    id INT PRIMARY KEY,
    flight_number VARCHAR(255),
    flight_date DATE
);

CREATE TABLE booking (
    passenger_id INT,
    flight_id INT,
    PRIMARY KEY (passenger_id, flight_id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(id),
    FOREIGN KEY (flight_id) REFERENCES flight(id)
);

INSERT INTO passenger (id, name) VALUES (1, 'Alice');
INSERT INTO passenger (id, name) VALUES (2, 'Bob');
INSERT INTO passenger (id, name) VALUES (3, 'Charlie');

INSERT INTO flight (id, flight_number, flight_date) VALUES (1, 'AA123', '2020-01-01');
INSERT INTO flight (id, flight_number, flight_date) VALUES (2, 'BB456', '2020-01-02');
INSERT INTO flight (id, flight_number, flight_date) VALUES (3, 'CC789', '2020-01-03');

INSERT INTO booking (passenger_id, flight_id) VALUES (1, 1);
