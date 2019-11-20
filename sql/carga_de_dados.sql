DELETE FROM carga_diaria WHERE id > 0;
DELETE FROM produto WHERE id > 0;
DELETE FROM guarda WHERE id > 0;
DELETE FROM login WHERE id > 0;

INSERT INTO login
    (usuario, senha)
VALUES
    ('zeca', 'zeca'),
    ('lemes', 'lemes');

INSERT INTO guarda
    (id_login, matricula, nome, status)
VALUES
    (1, '1', 'Ezequias Albuquerque', 2),
    (2, '2', 'Marcio Lemes', 1);

INSERT INTO guarda
    (matricula, nome, status)
VALUES
    ('3', 'Jorge Bruno Batista', 2),
    ('4', 'Otávio Kauê Figueiredo', 2),
    ('5', 'Vicente Carlos Fernandes', 2),
    ('6', 'Pedro Paulo Barbosa', 2),
    ('7', 'Jorge Lacerda', 1);

INSERT INTO produto
    (cod, descricao, marca, tipo)
VALUES
    ('PT-1', 'Taurus .380', 'Taurus', 'Pistola'),
    ('PT-2', 'Taurus .380', 'Taurus', 'Pistola'),
    ('PT-3', 'Taurus .380', 'Taurus', 'Pistola'),
    ('PT-4', 'Taurus .380', 'Taurus', 'Pistola'),
    ('PT-5', 'Taurus .380', 'Taurus', 'Pistola'),
    ('PT-6', 'Taurus .380', 'Taurus', 'Pistola'),
    ('PT-7', 'Taurus .380', 'Taurus', 'Pistola'),
    
    ('VTR-1', 'Ford EcoSport MJK-1234', 'Ford', 'Viatura'),
    ('VTR-2', 'Chevrolet Spin QTT-1234', 'Chevrolet', 'Viatura'),

    ('PX-1', 'Motorola MPX-1', 'Motorola', 'Rádio Comunicador'),
    ('PX-2', 'Motorola MPX-1', 'Motorola', 'Rádio Comunicador'),
    ('PX-3', 'Motorola MPX-1', 'Motorola', 'Rádio Comunicador'),
    ('PX-4', 'Motorola MPX-1', 'Motorola', 'Rádio Comunicador'),
    ('PX-5', 'Motorola MPX-1', 'Motorola', 'Rádio Comunicador'),
    ('PX-6', 'Motorola MPX-1', 'Motorola', 'Rádio Comunicador'),
    ('PX-7', 'Motorola MPX-1', 'Motorola', 'Rádio Comunicador');

-- RESERVA DIA 10

INSERT INTO carga_diaria
    (dia, id_armeiro, id_guarda, id_produto, created_at, cautelado)
VALUES
    ('2019-09-10', 2, 1, 1, '2019-09-10 08:00', true),
    ('2019-09-10', 2, 1, 8, '2019-09-10 08:00', true),
    ('2019-09-10', 2, 1, 10, '2019-09-10 08:00', true),
    ('2019-09-10', 2, 4, 2, '2019-09-10 08:00', true),
    ('2019-09-10', 2, 4, 11, '2019-09-10 08:00', true);

INSERT INTO carga_diaria
    (dia, id_armeiro, id_guarda, id_produto, created_at, cautelado)
VALUES
    ('2019-09-10', 2, 4, 2, '2019-09-10 20:00', false),
    ('2019-09-10', 2, 4, 11, '2019-09-10 20:00', false);

-- RESERVA DIA 15

INSERT INTO carga_diaria
    (dia, id_armeiro, id_guarda, id_produto, created_at, cautelado)
VALUES
    ('2019-09-15', 6, 4, 2, '2019-09-15 08:00', true),
    ('2019-09-15', 6, 4, 11, '2019-09-15 08:00', true);