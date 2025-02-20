CREATE TABLE pets (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    age_years SMALLINT CHECK (age_years >= 0),
    age_months SMALLINT CHECK (age_months BETWEEN 0 AND 11),
    sex VARCHAR(10) CHECK (sex IN ('Macho', 'Fêmea')),
    photo_url TEXT,
    description TEXT,
    status VARCHAR(20) CHECK (status IN ('Para adoção', 'Adotado')),
    user_id UUID REFERENCES users(id) ON DELETE CASCADE,
    phone VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);
