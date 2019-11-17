DELETE FROM carga_diaria WHERE id > 0;
DELETE FROM produto WHERE id > 0;
DELETE FROM guarda WHERE id > 0;

INSERT INTO guarda
    (matricula, nome, status)
VALUES
    ('1', 'Ezequias Albuquerque', 2),
    ('2', 'Marcio Lemes', 1),
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
    (dia, id_armeiro, id_guarda, id_produto, dia1, hora1, cautelado)
VALUES
    ('10/09/19', 2, 1, 1, '10/09/19', '08:00', true),
    ('10/09/19', 2, 1, 8, '10/09/19', '08:00', true),
    ('10/09/19', 2, 1, 10, '10/09/19', '08:00', true),
    ('10/09/19', 2, 4, 2, '10/09/19', '08:00', true),
    ('10/09/19', 2, 4, 11, '10/09/19', '08:00', true);

INSERT INTO carga_diaria
    (dia, id_armeiro, id_guarda, id_produto, dia1, hora1, cautelado)
VALUES
    ('10/09/19', 2, 4, 2, '10/09/19', '20:00', false),
    ('10/09/19', 2, 4, 11, '10/09/19', '20:00', false);

-- RESERVA DIA 15

INSERT INTO carga_diaria
    (dia, id_armeiro, id_guarda, id_produto, dia1, hora1, cautelado)
VALUES
    ('15/09/19', 6, 4, 2, '15/09/19', '08:00', true),
    ('15/09/19', 6, 4, 11, '15/09/19', '08:00', true);