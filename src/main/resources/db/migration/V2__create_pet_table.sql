CREATE TABLE pet (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    age_years INT NOT NULL,
    age_months INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    photo_url VARCHAR(200),
    address VARCHAR(200) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    description TEXT,
    adopted BOOLEAN DEFAULT FALSE,
    phone VARCHAR(15) NOT NULL,
    user_id UUID NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW(),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);