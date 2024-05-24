CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    gender VARCHAR,
    password VARCHAR,
    age INTEGER,
    email VARCHAR,
    phone VARCHAR,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE UNIQUE INDEX if not exists idx_users_email ON users(email);
CREATE INDEX if not exists idx_users_phone ON users(phone);
CREATE INDEX if not exists idx_users_last_name ON users(last_name);
CREATE INDEX if not exists idx_users_first_name ON users(first_name);
CREATE INDEX if not exists idx_users_created_at ON users(created_at);


CREATE TABLE IF NOT EXISTS movies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) UNIQUE,
    length_in_minutes INTEGER,
    description VARCHAR,
    rating DOUBLE PRECISION,
    age_limit INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    created_by BIGINT REFERENCES users(id),
    updated_by BIGINT REFERENCES users(id)
);

CREATE INDEX IF NOT EXISTS movies_name_idx ON movies(name);
CREATE INDEX IF NOT EXISTS movies_name_rating_idx ON movies(name, rating);



