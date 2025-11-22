create table documentos (
id INT AUTO_INCREMENT PRIMARY KEY,
id_usuario INT NOT NULL,
rg VARCHAR(255) unique not null,
cpf VARCHAR(255) unique not null,
FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
) ENGINE=InnoDB;