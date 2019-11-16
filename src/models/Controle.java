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
public class Controle {
    private int id;
    private String armeiroControle;
    private String dataArmeiroControle;
    private String agenteControle;
    private String codproduto;
    private String observacao;
    private String dia1;
    private String hora1;
    private boolean cautelado;
    private String dia2;
    private String hora2;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArmeiroControle() {
        return armeiroControle;
    }

    public void setArmeiroControle(String armeiroControle) {
        this.armeiroControle = armeiroControle;
    }

    public String getDataArmeiroControle() {
        return dataArmeiroControle;
    }

    public void setDataArmeiroControle(String dataArmeiroControle) {
        this.dataArmeiroControle = dataArmeiroControle;
    }

    public String getAgenteControle() {
        return agenteControle;
    }

    public void setAgenteControle(String agenteControle) {
        this.agenteControle = agenteControle;
    }

    public String getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(String codproduto) {
        this.codproduto = codproduto;
    }

    public String getDia1() {
        return dia1;
    }

    public void setDia1(String dia1) {
        this.dia1 = dia1;
    }

    public String getHora1() {
        return hora1;
    }

    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }

    public boolean getCautelado() {
        return cautelado;
    }

    public void setCautelado(boolean cautelado) {
        this.cautelado = cautelado;
    }

    public String getDia2() {
        return dia2;
    }

    public void setDia2(String dia2) {
        this.dia2 = dia2;
    }

    public String getHora2() {
        return hora2;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }
 
    
}
