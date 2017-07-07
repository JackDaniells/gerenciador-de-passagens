# gerenciador-de-passagens

Implementação de um sistema de gerenciamento de passagens em Java. Projeto executado na disciplina de Desenvolvimento de Sistemas Orientado a Objeto II, da quarta fase do curso de Sistemas de Informação da Universidade Federal de Santa Catarina.
Utilize o SQL abaixo para a execução correta do programa:


create table clientes (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY
            (START WITH 1, INCREMENT BY 1), 
    nome VARCHAR(40) NOT NULL, 
    email VARCHAR(64),
    login VARCHAR(30), 
    senha VARCHAR(40),
    PRIMARY KEY (id)
);

create table viagem (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY
            (START WITH 1, INCREMENT BY 1), 
    origem VARCHAR(100),
    destino VARCHAR(100), 
    PRIMARY KEY (id)
);

create table passagem (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY
            (START WITH 1, INCREMENT BY 1), 
    valor INT,
    horario DATE, 
    assentos_disponiveis INT,
    id_viagem INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_viagem) references viagem (id)
);

create table reserva (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY
            (START WITH 1, INCREMENT BY 1), 
    id_cliente INT,
    id_passagem INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) references clientes (id),
    FOREIGN KEY (id_passagem) references passagem (id)
);
