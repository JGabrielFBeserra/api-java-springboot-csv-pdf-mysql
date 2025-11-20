create table usuarios (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) not null,
email VARCHAR(255) unique not null,
senha VARCHAR(255) not null

)