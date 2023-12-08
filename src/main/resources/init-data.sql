INSERT INTO enderecos (cep, cidade, estado, numero, pais, rua) VALUES
('12345-678', 'São Paulo', 'SP', '123', 'Brasil', 'Avenida Paulista'),
('54321-987', 'Rio de Janeiro', 'RJ', '456', 'Brasil', 'Rua Copacabana'),
('98765-432', 'Belo Horizonte', 'MG', '789', 'Brasil', 'Avenida do Contorno'),
('11111-111', 'Porto Alegre', 'RS', '101', 'Brasil', 'Rua dos Andradas'),
('22222-222', 'Salvador', 'BA', '202', 'Brasil', 'Avenida Tancredo Neves'),
('33333-333', 'Curitiba', 'PR', '303', 'Brasil', 'Rua das Flores'),
('44444-444', 'Fortaleza', 'CE', '404', 'Brasil', 'Avenida da Liberdade'),
('55555-555', 'Manaus', 'AM', '505', 'Brasil', 'Rua Amazonas'),
('66666-666', 'Brasília', 'DF', '606', 'Brasil', 'Eixo Monumental'),
('77777-777', 'Florianópolis', 'SC', '707', 'Brasil', 'Avenida Beira Mar');
 
INSERT INTO alunos (cpf, curso, matricula, nome, endereco_id) VALUES
('123.456.789-00', 'Engenharia de Computação', '2023001', 'Maria Silva', 7),
('234.567.890-11', 'Ciência da Computação', '2023002', 'João Santos', 2),
('345.678.901-22', 'Administração', '2023003', 'Ana Oliveira', 9),
('456.789.012-33', 'Psicologia', '2023004', 'Carlos Pereira', 4),
('567.890.123-44', 'Economia', '2023005', 'Mariana Costa', 10),
('678.901.234-55', 'Engenharia Elétrica', '2023006', 'Roberto Almeida', 6),
('789.012.345-66', 'Arquitetura', '2023007', 'Amanda Souza', 3),
('890.123.456-77', 'Economia', '2023008', 'Lucas Oliveira', 8),
('901.234.567-88', 'Administração', '2023009', 'Fernanda Silva', 5),
('012.345.678-99', 'Biologia', '2023010', 'Ricardo Santos', 1);

INSERT INTO professores (curso, matricula, nome, endereco_id) VALUES
('Engenharia de Computação', 'P2023001', 'Prof. Silva', 7),
('Ciência da Computação', 'P2023002', 'Profa. Oliveira', 2),
('Administração', 'P2023003', 'Prof. Costa', 9),
('Psicologia', 'P2023004', 'Profa. Almeida', 4),
('Economia', 'P2023005', 'Prof. Santos', 10),
('Engenharia Elétrica', 'P2023006', 'Profa. Souza', 6),
('Arquitetura', 'P2023007', 'Prof. Oliveira', 3),
('Economia', 'P2023008', 'Profa. Almeida', 8),
('Administração', 'P2023009', 'Prof. Silva', 5),
('Biologia', 'P2023010', 'Profa. Santos', 1);

INSERT INTO projetos (area_projeto, id_aluno, id_professor, resumo, titulo_projeto, url) VALUES
('Tecnologia', 1, 1, 'Desenvolvimento de um Sistema de Gestão Escolar', 'Projeto 1', 'https://github.com/seuusuario/projeto1'),
('Engenharia', 2, 2, 'Estudo de Estruturas de Concreto Armado', 'Projeto 2', 'https://github.com/seuusuario/projeto2'),
('Administração', 3, 3, 'Análise de Mercado em Empresas de Tecnologia', 'Projeto 3', 'https://github.com/seuusuario/projeto3'),
('Psicologia', 4, 4, 'Impacto das Redes Sociais na Saúde Mental', 'Projeto 4', 'https://github.com/seuusuario/projeto4'),
('Economia', 5, 5, 'Análise do Mercado Financeiro Internacional', 'Projeto 5', 'https://github.com/seuusuario/projeto5'),
('Engenharia Elétrica', 6, 6, 'Desenvolvimento de um Sistema de Controle de Energia', 'Projeto 6', 'https://github.com/seuusuario/projeto6'),
('Arquitetura', 7, 7, 'Projeto Arquitetônico Sustentável', 'Projeto 7', 'https://github.com/seuusuario/projeto7'),
('Economia', 8, 8, 'Impacto Econômico das Mudanças Climáticas', 'Projeto 8', 'https://github.com/seuusuario/projeto8'),
('Administração', 9, 9, 'Gestão Eficiente de Recursos Humanos', 'Projeto 9', 'https://github.com/seuusuario/projeto9'),
('Biologia', 10, 10, 'Estudo da Biodiversidade na Amazônia', 'Projeto 10', 'https://github.com/seuusuario/projeto10');

