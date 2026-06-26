INSERT INTO medico (id, nome, crm, especialidade) VALUES
('456707cb-0c46-4a9b-9e84-0e74a6f82e83', 'Dr. Roberto Santos', 'CRM123456', 'Cardiologista'),
('888807cb-0c46-4a9b-9e84-0e74a6f82e88', 'Dra. Ana Souza', 'CRM654321', 'Ortopedista')
ON CONFLICT (id) DO NOTHING;

INSERT INTO paciente (id, nome, cpf, data_nascimento, telefone) VALUES
('bc2eff48-0371-4152-a603-ca9b9f1bfedf', 'João Silva', '12345678901', '1980-05-15', '11999999999'),
('9999ff48-0371-4152-a603-ca9b9f1bfede', 'Maria Oliveira', '98765432109', '1990-08-20', '11888888888')
ON CONFLICT (id) DO NOTHING;

INSERT INTO consulta (id, data_consulta, observacoes, id_paciente, id_medico) VALUES
('aaaa0000-0000-4000-8000-000000000001', '2026-06-26 09:00:00', 'Consulta de rotina cardíaca', 'bc2eff48-0371-4152-a603-ca9b9f1bfedf', '456707cb-0c46-4a9b-9e84-0e74a6f82e83'),
('bbbb0000-0000-4000-8000-000000000002', '2026-06-26 10:30:00', 'Avaliação ortopédica inicial', '9999ff48-0371-4152-a603-ca9b9f1bfede', '888807cb-0c46-4a9b-9e84-0e74a6f82e88')
ON CONFLICT (id) DO NOTHING;

INSERT INTO internacao (id, data_entrada, data_alta, numero_quarto, id_paciente) VALUES
('cccc0000-0000-4000-8000-000000000001', '2026-06-26 14:00:00', NULL, 101, 'bc2eff48-0371-4152-a603-ca9b9f1bfedf'),
('dddd0000-0000-4000-8000-000000000002', '2026-06-26 15:30:00', NULL, 102, '9999ff48-0371-4152-a603-ca9b9f1bfede')
ON CONFLICT (id) DO NOTHING;