DROP DATABASE IF EXISTS devices;
CREATE DATABASE devices;
USE devices;

CREATE TABLE fridges(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    power INT,
    weight INT,
    plugIn BOOLEAN NOT NULL DEFAULT 0,
    noFrost BOOLEAN NOT NULL DEFAULT 0,
    shelfCount INT
);

CREATE TABLE irons(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    power INT,
    weight INT,
    plugIn BOOLEAN NOT NULL DEFAULT 0,
    steamOutput INT,
    waterCapacity INT
);

CREATE TABLE washers(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    power INT,
    weight INT,
    plugIn BOOLEAN NOT NULL DEFAULT 0,
    capacity INT,
    spinSpeed INT
);

INSERT INTO fridges VALUES (NULL, 'Fridge2', 1000, 40, 0, 0, 3);
INSERT INTO irons VALUES (NULL, 'Iron2', 1400, 5, 1, 120, 400);
INSERT INTO washers VALUES (NULL, 'Washer2', 400, 40, 0, 5, 800);