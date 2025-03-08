DROP DATABASE IF EXISTS migracao_dados;
CREATE DATABASE migracao_dados DEFAULT CHARACTER SET = 'utf8mb4';

use migracao_dados;

DROP TABLE IF EXISTS pessoa;
CREATE TABLE pessoa(id INT, nome VARCHAR(500),email VARCHAR(500),data_nascimento DATETIME,idade INT, PRIMARY KEY(id));

DROP TABLE IF EXISTS dados_bancarios;
CREATE TABLE dados_bancarios(id INT, pessoa_id INT,agencia INT, conta INT, banco INT , PRIMARY KEY(id));
