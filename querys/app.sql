-- Active: 1729814945779@@127.0.0.1@3306
DROP DATABASE IF EXISTS app;

CREATE DATABASE app DEFAULT CHARACTER SET = 'utf8mb4';

use app;

CREATE TABLE cliente (
    nome text,
    sobrenome text,
    idade text,
    email text
);

-- Active: 1729814945779@@127.0.0.1@3306@app
insert into cliente values ( "Joao", "Silva", "30", "joao@test.com" );

insert into cliente values ( "Maria", "Silva", "30", "maria@test.com" );

INSERT INTO cliente VALUES ("Zeca 1", "Silva", "30", "zeca1@test.com");
INSERT INTO cliente VALUES ("Zeca 2", "Silva", "30", "zeca2@test.com");
INSERT INTO cliente VALUES ("Zeca 3", "Silva", "30", "zeca3@test.com");
INSERT INTO cliente VALUES ("Zeca 4", "Silva", "30", "zeca4@test.com");
INSERT INTO cliente VALUES ("Zeca 5", "Silva", "30", "zeca5@test.com");
INSERT INTO cliente VALUES ("Zeca 6", "Silva", "30", "zeca6@test.com");
INSERT INTO cliente VALUES ("Zeca 7", "Silva", "30", "zeca7@test.com");
INSERT INTO cliente VALUES ("Zeca 8", "Silva", "30", "zeca8@test.com");
INSERT INTO cliente VALUES ("Zeca 9", "Silva", "30", "zeca9@test.com");
