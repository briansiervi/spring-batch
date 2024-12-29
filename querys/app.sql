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

insert into cliente values ( "Maria", "Silva", "30", "joao@test.com" );
