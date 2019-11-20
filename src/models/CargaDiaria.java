package models;

import java.util.Date;

/**
 *
 * @author Lemes
 */
public class CargaDiaria {
    private int id;
    private String codproduto;
    private String armeiroControle;
    private String agenteControle;
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
