CREATE TABLE Pacientes(
    id BIGINT NOT NULL AUTO_INCREMENT,
    ativo TINYINT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    uf CHAR(2),
    cidade VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
)