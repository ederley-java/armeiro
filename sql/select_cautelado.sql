USE armeirobd4;

SELECT carga.id,
       armeiro.id   as id_armeiro,
       armeiro.nome as nome_armeiro,
       carga.dia,
       guarda.id   as id_guarda,
       guarda.nome as nome_guarda,
       prod.id     as id_produto,
       prod.cod    as cod_produto,
       carga.observacao,
       MAX(carga.created_at) as created_at,
       carga.dia2,
       carga.hora2
  FROM carga_diaria carga
  JOIN guarda armeiro ON (armeiro.id = carga.id_armeiro)
  JOIN guarda guarda  ON (guarda.id = carga.id_guarda)
  JOIN produto prod   ON (prod.id = carga.id_produto)
 
WHERE carga.cautelado = 1
 
GROUP BY 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12

ORDER BY 4, 10, 3, 6;