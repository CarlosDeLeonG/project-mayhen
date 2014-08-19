# Student table, this is na for test table.

DROP TABLE IF EXISTS student;

CREATE TABLE IF NOT EXISTS student (
    id INT NOT NULL AUTO_INCREMENT  PRIMARY KEY,
    student_name                    VARCHAR(30),
    last_name                       VARCHAR(30),
    birthday                        DATE
);

SHOW TABLES;

DESCRIBE student;