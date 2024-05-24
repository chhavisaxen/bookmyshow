DROP TABLE IF EXISTS theatre;

CREATE TABLE IF NOT EXISTS theatre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200),
    city VARCHAR(300)
);
CREATE INDEX IF NOT EXISTS theatre_name_idx ON theatre(name);
CREATE INDEX IF NOT EXISTS theatre_location_idx ON theatre(city);