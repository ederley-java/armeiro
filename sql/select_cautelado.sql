SELECT ca.id,
       ar.nome,
       gu.nome,
       ca.dia,
       pr.cod,
       ca.observacao,
       ca.dia1,
       ca.hora1,
       ca.cautelado,
       ca.dia2,
       ca.hora2
  FROM cargadiaria ca
  JOIN guardas ar ON (ar.id = ca.codArmeiro)
  JOIN guardas gu ON (gu.id = ca.codGuarda)
  JOIN produto pr ON (pr.id = ca.codProduto)
 WHERE ca.cautelado = 1;