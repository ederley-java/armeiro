USE armeirobd4;

SELECT carga.id,
       carga.dia,
       
       armeiro.id   as id_armeiro,
       armeiro.nome as nome_armeiro,

       guarda.id   as id_guarda,
       guarda.nome as nome_guarda,

       prod.id     as id_produto,
       prod.cod    as cod_produto,
       
       carga.observacao,
       MAX(carga.created_at) as created_at,
       
       carga.dia2,
       carga.hora2
  FROM carga_diaria carga
  LEFT JOIN carga_diaria devolvido ON (
    devolvido.id_armeiro = carga.id_armeiro AND
    devolvido.id_guarda  = carga.id_guarda  AND
    devolvido.id_produto = carga.id_produto AND
    devolvido.cautelado  = 0
  )
  JOIN guarda armeiro         ON (armeiro.id = carga.id_armeiro)
  JOIN guarda guarda          ON (guarda.id = carga.id_guarda)
  JOIN produto prod           ON (prod.id = carga.id_produto)
 
WHERE carga.cautelado = 1
  AND devolvido.id IS NULL
 
GROUP BY 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12

ORDER BY 4, 10, 3, 6;