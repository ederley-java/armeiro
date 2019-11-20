SELECT ca.id,
       ar.nome,
       gu.nome,
       ca.dia,
       pr.cod,
       ca.observacao,
       ca.created_at,
       ca.cautelado,
       ca.dia2,
       ca.hora2
  FROM carga_diaria ca
  JOIN guarda ar ON (ar.id = ca.id_armeiro)
  JOIN guarda gu ON (gu.id = ca.id_guarda)
  JOIN produto pr ON (pr.id = ca.id_produto)
 WHERE ca.cautelado = 1;