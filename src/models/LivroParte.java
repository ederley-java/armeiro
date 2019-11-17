package models;

/**
 *
 * @author Lemes
 */
public class LivroParte {
    private int id;
    private String nomeArmeiro;
    private String diaEntrada;
    private String horaEntrada;
    private String diaSaida;
    private String horaSaida;
    private String historico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeArmeiro() {
        return nomeArmeiro;
    }

    public void setNomeArmeiro(String nomeArmeiro) {
        this.nomeArmeiro = nomeArmeiro;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getDiaSaida() {
        return diaSaida;
    }

    public void setDiaSaida(String diaSaida) {
        this.diaSaida = diaSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
}
