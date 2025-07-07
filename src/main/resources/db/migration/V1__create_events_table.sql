CREATE TABLE calendar_event (
    id SERIAL PRIMARY KEY,
    summary VARCHAR(255) NOT NULL,
    start TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL
);
