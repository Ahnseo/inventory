
CREATE TABLE main(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    brand VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    unit_per_BOX INT,
    boxEA INT,
    mainStorage INT,
    subStorage1 INT,
    subStorage2 INT,
    posStorage INT,
    drinkStorage INT
);
-- DROP TABLE main;

DESC main;
SELECT * FROM main;
