INSERT INTO nota_fiscal (id, numero_nota_fiscal, nome_razao_social, cnpj, data_de_emissao, data_de_entrada_saida, descricao_produto_servico, valor_nota_fiscal, ativo, updated_at, created_at)
VALUES
(1, 123, 'Empresa ABC', '12345678000190', '2023-01-01', '2023-01-02', '[{"codigo": "A001", "descricaoProdutoServico": "Serviço de Consultoria", "valorUnitario": 1500.50, "desconto": 0}]', 1500.50, true, '2023-01-03T12:30:00', '2023-01-01T08:45:00'),

(2, 456, 'Empresa XYZ', '98765432000121', '2023-02-01', '2023-02-02', '[{"codigo": "B002", "descricaoProdutoServico": "Venda de Produtos Eletrônicos", "valorUnitario": 2500.75, "desconto": 0}]', 2500.75, true, '2023-02-03T15:20:00', '2023-02-01T09:15:00'),

(3, 789, 'Comércio ABC', '23456789000134', '2023-03-01', '2023-03-02', '[{"codigo": "C003", "descricaoProdutoServico": "Venda de Materiais de Construção", "valorUnitario": 3500.00, "desconto": 0}]', 3500.00, true, '2023-03-03T14:10:00', '2023-03-01T10:00:00'),

(4, 1111, 'Empresa ABC', '12345678000190', '2023-04-01', '2023-04-02', '[{"codigo": "D004", "descricaoProdutoServico": "Serviço de Manutenção", "valorUnitario": 1200.75, "desconto": 0}]', 1200.75, true, '2023-04-03T11:30:00', '2023-04-01T09:15:00'),

(5, 2222, 'Empresa XYZ', '98765432000121', '2023-05-01', '2023-05-02', '[{"codigo": "E005", "descricaoProdutoServico": "Venda de Roupas", "valorUnitario": 800.50, "desconto": 0}]', 800.50, true, '2023-05-03T13:45:00', '2023-05-01T10:20:00'),

(6, 3333, 'Comércio ABC', '23456789000134', '2023-06-01', '2023-06-02', '[{"codigo": "F006", "descricaoProdutoServico": "Venda de Eletrônicos", "valorUnitario": 3000.00, "desconto": 0}]', 3000.00, true, '2023-06-03T14:10:00', '2023-06-01T11:00:00'),

(7, 4444, 'Empresa Delta', '55555555000112', '2023-07-01', '2023-07-02', '[{"codigo": "G007", "descricaoProdutoServico": "Serviço de Consultoria Jurídica", "valorUnitario": 2500.25, "desconto": 0}]', 2500.25, true, '2023-07-03T12:45:00', '2023-07-01T08:30:00'),

(8, 5555, 'Comércio XYZ', '34567890000145', '2023-08-01', '2023-08-02', '[{"codigo": "H008", "descricaoProdutoServico": "Venda de Alimentos", "valorUnitario": 1800.00, "desconto": 0}]', 1800.00, true, '2023-08-03T10:20:00', '2023-08-01T09:45:00'),

(9, 6666, 'Empresa Gama', '87654321000178', '2023-09-01', '2023-09-02', '[{"codigo": "I009", "descricaoProdutoServico": "Manutenção de Equipamentos", "valorUnitario": 1600.75, "desconto": 0}]', 1600.75, true, '2023-09-03T11:30:00', '2023-09-01T08:15:00'),

(10, 7777, 'Comércio Delta', '11223344000156', '2023-10-01', '2023-10-02', '[{"codigo": "J010", "descricaoProdutoServico": "Venda de Ferramentas", "valorUnitario": 2200.50, "desconto": 0}]', 2200.50, true, '2023-10-03T14:00:00', '2023-10-01T09:30:00');
