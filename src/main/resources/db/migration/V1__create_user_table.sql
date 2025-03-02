CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cpf_cnpj VARCHAR(14) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    photo_url VARCHAR(200),
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    google_id VARCHAR(100),
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);