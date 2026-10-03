-- Banco de dados do projeto LeiloesTDSaT
CREATE DATABASE IF NOT EXISTS uc11
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE uc11;

CREATE TABLE IF NOT EXISTS produtos (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    valor INT NOT NULL,
    status VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);
