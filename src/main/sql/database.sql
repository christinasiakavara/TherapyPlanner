CREATE DATABASE TherapyPlannerDB;

CREATE TABLE users
(
    id         INT AUTO_INCREMENT PRIMARY KEY NOT NULL , 
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
    id   INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    bio     TEXT(5000),
    ratings DECIMAL(3, 2),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE ratings
(
    id  INT AUTO_INCREMENT PRIMARY   KEY NOT NULL,
    value           DECIMAL(3, 2),
    psychologist_id INT,
    FOREIGN KEY (psychologist_id) REFERENCES psychologists (id)
);

CREATE TABLE patients
(
    id      INT  AUTO_INCREMENT NOT NULL PRIMARY KEY,
    medical_history TEXT(5000),
    user_id         INT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE therapysession
(
    thersessionID INT AUTO_INCREMENT PRIMARY KEY,
    sessionDateTime DATETIME,
    patientID INT,
    psychologistID INT,
    FOREIGN KEY (patientID) REFERENCES patient (id),
    FOREIGN KEY (psychologistID) REFERENCES psychologists (id)
);

CREATE TABLE payments
(
    paymentid           INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    amount       FLOAT           NOT NULL,
    paymentDate DATETIME,
    sessionID    INT             NOT NULL,
    patientid   INT,
    FOREIGN KEY (sessionID) REFERENCES therapysession (thersessionID) NOT NULL,
    FOREIGN KEY (patientid) REFERENCES patients (id) --Επίσης πρέπει μετά από κάθε ολοκληρωμένο session ή payment να διαγράφονται κάποια στοιχεία, πχ εδώ το patientID; Μιας και έγινε το payment και δεν είναι αναγκαστικό ότι θα ξανακάνει
);

CREATE TABLE admin
(
    adminid     INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    permissions VARCHAR(30) 
);

CREATE TABLE Chat
(
    chatid        INT AUTO_INCREMENT  PRIMARY KEY NOT NULL,
    participantpatient INT NOT NULL,
    participanttherapist INT NOT NULL,
    FOREIGN KEY (participantpatient) REFERENCES patients (id),
    FOREIGN KEY (participanttherapist) REFERENCES psychologists (id)
);

CREATE TABLE Message
(
    messageid  INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    chatid    INT NOT NULL,
    senderid   INT NOT NULL,
    receiverid INT NOT NULL,
    content    TEXT(2000),
    timestamp  DATETIME ,
    FOREIGN KEY (chatid) REFERENCES chat (chatid),
    FOREIGN KEY (senderid) REFERENCES users (id),
    FOREIGN KEY (receiverid) REFERENCES users (id)
);


