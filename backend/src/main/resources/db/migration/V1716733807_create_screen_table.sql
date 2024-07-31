CREATE TABLE IF NOT EXISTS screen (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    theatre_id BIGINT REFERENCES theatre (id),
);

CREATE INDEX if not exists idx_screen_theatre_id ON screen(theatre_id);

CREATE TABLE IF NOT EXISTS display_type (
    id BIGINT PRIMARY KEY,
    name VARCHAR
)

INSERT INTO display_type (id, name) VALUES (1, '2D'), (2, '3D'), (3, '4DX');

CREATE TABLE IF NOT EXISTS screen_display_type (
    id BIGSERIAL PRIMARY KEY,
    screen_id  BIGINT REFERENCES screen(id),
    display_type_id BIGINT REFERENCES display_type(id)
)

CREATE INDEX if not exists idx_screen_display_type ON screen_display_type(screen_id);

