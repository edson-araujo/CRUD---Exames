CREATE TABLE exame (id_exame bigint auto_increment, nm_exame VARCHAR(255), PRIMARY KEY (id_exame));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue'), ('Covid-19');


CREATE TABLE funcionario (id_funcionario bigint auto_increment, nm_funcionario VARCHAR(255), PRIMARY KEY (id_funcionario));
INSERT INTO funcionario (nm_funcionario) VALUES	('Maria'), ('Edson'), ('Felipe'), ('Carol');

CREATE TABLE consulta (id_consulta bigint auto_increment, id_exame_consulta bigint, id_funcionario_consulta bigint, dt_consulta date,
PRIMARY KEY (id_consulta, id_funcionario_consulta, id_exame_consulta),
CONSTRAINT fk_exame_consulta FOREIGN KEY (id_exame_consulta) REFERENCES exame(id_exame), 
CONSTRAINT fk_funcionario_consulta FOREIGN KEY (id_funcionario_consulta) REFERENCES funcionario(id_funcionario) 
ON DELETE CASCADE);

INSERT INTO consulta (id_exame_consulta, id_funcionario_consulta, dt_consulta) VALUES (1, 1, '2022-05-15'), (2, 2, '2022-05-16');
