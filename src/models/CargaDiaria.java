package models;

import java.util.Date;

import models.Produto;
import models.Usuario;

/**
 *
 * @author Lemes
 */
public class CargaDiaria {
    private int id;
    private Usuario armeiro;
    private Usuario guarda;
    private Produto produto;
    private String dataArmeiroControle;
    private String observacao;
    private Date createdAt;
    private boolean cautelado;
    private String dia2;
    private String hora2;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getArmeiro() {
        return armeiro;
    }

    public void setArmeiro(Usuario armeiro) {
        this.armeiro = armeiro;
    }

    public String getDataArmeiroControle() {
        return dataArmeiroControle;
    }

    public void setDataArmeiroControle(String dataArmeiroControle) {
        this.dataArmeiroControle = dataArmeiroControle;
    }

    public Usuario getGuarda() {
        return guarda;
    }

    public void setGuarda(Usuario guarda) {
        this.guarda = guarda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isCautelado() {
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
