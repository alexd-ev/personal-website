-- Experience Table
CREATE TABLE IF NOT EXISTS experience (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    company     TEXT    NOT NULL,
    role        TEXT    NOT NULL,
    start_date  TEXT    NOT NULL,
    end_date    TEXT,
    description TEXT    NOT NULL
);

-- Education Table
CREATE TABLE IF NOT EXISTS education (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    institution TEXT    NOT NULL,
    degree      TEXT,
    major       TEXT,
    start_date  TEXT    NOT NULL,
    end_date    TEXT
);

-- Projects Table
CREATE TABLE IF NOT EXISTS projects (
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    title         TEXT    NOT NULL,
    description   TEXT    NOT NULL,
    github_url    TEXT,
    experience_id INTEGER DEFAULT NULL,
    education_id  INTEGER DEFAULT NULL,
    FOREIGN KEY (
        experience_id
    )
    REFERENCES experience (id) ON DELETE SET NULL,
    FOREIGN KEY (
        education_id
    )
    REFERENCES education (id) ON DELETE SET NULL
);

-- Skills Table
CREATE TABLE IF NOT EXISTS skills (
    id       INTEGER PRIMARY KEY AUTOINCREMENT,
    name     TEXT    NOT NULL
                     UNIQUE,
    category TEXT    NOT NULL
);

-- Project-Skills Junction Table
CREATE TABLE IF NOT EXISTS project_skills (
    project_id INTEGER,
    skill_id   INTEGER,
    PRIMARY KEY (
        project_id,
        skill_id
    ),
    FOREIGN KEY (
        project_id
    )
    REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (
        skill_id
    )
    REFERENCES skills (id) ON DELETE CASCADE
);

-- Courses Table
CREATE TABLE IF NOT EXISTS courses (
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    education_id    INTEGER,
    course_name     TEXT    NOT NULL,
    course_code     TEXT,
    completion_date TEXT    NOT NULL,
    FOREIGN KEY (
        education_id
    )
    REFERENCES education (id) ON DELETE CASCADE
);

-- Contact Messages Table
CREATE TABLE IF NOT EXISTS contact_messages (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    name         TEXT    NOT NULL,
    email        TEXT    NOT NULL,
    subject      TEXT,
    message      TEXT    NOT NULL,
    submitted_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
