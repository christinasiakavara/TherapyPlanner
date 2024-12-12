CREATE DATABASE TherapyPlannerDB;

CREATE TABLE users
(
    id         INT PRIMARY KEY NOT NULL, -- Μήπως στα id, βάζαμε AUTO_INCREMENT? Βρήκα στο w3 ότι φτιάχνει αυτόματα έναν κωδικό η βάση
    first_name VARCHAR(15),
    last_name  VARCHAR(30),
    username   VARCHAR(10)     NOT NULL,
    password   VARCHAR(20)     NOT NULL,
    email      VARCHAR(30)     NOT NULL UNIQUE,
    phone      INT             NOT NULL,
    address    VARCHAR(50),
    birthdate  DATE,
    role       INT,
    CONSTRAINT CHK_Role CHECK (Role = 1 OR Role = 2 OR Role = 3)
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
    id              INT PRIMARY KEY NOT NULL,
    value           DECIMAL(3, 2),
    psychologist_id INT,
    FOREIGN KEY (psychologist_id) REFERENCES psychologists (id)
);

CREATE TABLE patients
(
    id              INT NOT NULL PRIMARY KEY,
    medical_history TEXT(5000),
    user_id         INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE therapysession
(
    thersessionID   INT PRIMARY KEY,
    sessionDateTime DATETIME,
    patientID       INT,
    psychologistID  INT,
    FOREIGN KEY (patientID) REFERENCES patient (id),
    FOREIGN KEY (psychologistID) REFERENCES psychologists (id)
);

CREATE TABLE payments
(
    id           INT PRIMARY KEY NOT NULL,
    amount       FLOAT           NOT NULL,
    payment_date DATETIME,
    sessionID    INT             NOT NULL,
    patient_id   INT,
    FOREIGN KEY (sessionID) REFERENCES therapysession (thersessionID),
    FOREIGN KEY (patient_id) REFERENCES patients (id) -- Επίσης πρέπει μετά από κάθε ολοκληρωμένο session ή payment να διαγράφονται κάποια στοιχεία, πχ εδώ το patientID; Μιας και έγινε το payment και δεν είναι αναγκαστικό ότι θα ξανακάνει
);


