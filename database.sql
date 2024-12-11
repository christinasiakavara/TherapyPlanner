CREATE DATABASE TherapyPlannerDB;

CREATE TABLE users
(
    id         INT PRIMARY KEY NOT NULL,
    first_name VARCHAR(15),
    last_name  VARCHAR(30),
    username   VARCHAR(10)     NOT NULL,
    password   VARCHAR(20)     NOT NULL,
    email      VARCHAR(30)     NOT NULL,
    phone      INT             NOT NULL,
    address    VARCHAR(50),
    birthdate  DATE,
    role       INT,
    CONSTRAINT CHK_Role CHECK (Role = 1 OR Role = 2)
);

CREATE TABLE psychologists
(
    id      INT PRIMARY KEY NOT NULL,
    bio     TEXT(5000),
    ratings DECIMAL(3, 2),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);


CREATE TABLE ratings
(
    id INT PRIMARY KEY NOT NULL,
    value DECIMAL(3,2),
    psychologist_id INT,
    FOREIGN KEY (psychologist_id) REFERENCES psychologists (id)
)

CREATE TABLE patient
(
    id      INT NOT NULL PRIMARY KEY,
    medical_history TEXT(5000),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE payments
(
    id           INT PRIMARY KEY NOT NULL,
    amount       FLOAT           NOT NULL,
    payment_date DATETIME,
    patient_id   INT,
    FOREIGN KEY (patient_id) REFERENCES patients (id)
);


