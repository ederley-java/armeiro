/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Lemes
 */
public class Produto {
    private int IdProduto;
    private String cod;
    private String marcaProduto;
    private String tipoProduto;
    private String numeroSerieProduto;
    private String descricaoProduto;
    private String observacaoProduto;
    private String localizacaoProduto;
    private String historicoManutencaoProduto;

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int IdProduto) {
        this.IdProduto = IdProduto;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
    

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getNumeroSerieProduto() {
        return numeroSerieProduto;
    }

    public void setNumeroSerieProduto(String numeroSerieProduto) {
        this.numeroSerieProduto = numeroSerieProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getObservacaoProduto() {
        return observacaoProduto;
    }

    public void setObservacaoProduto(String observacaoProduto) {
        this.observacaoProduto = observacaoProduto;
    }

    public String getLocalizacaoProduto() {
        return localizacaoProduto;
    }

    public void setLocalizacaoProduto(String localizacaoProduto) {
        this.localizacaoProduto = localizacaoProduto;
    }

    public String getHistoricoManutencaoProduto() {
        return historicoManutencaoProduto;
    }

    public void setHistoricoManutencaoProduto(String historicoManutencaoProduto) {
        this.historicoManutencaoProduto = historicoManutencaoProduto;
    }
    
    
    
    
}
