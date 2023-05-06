package fluxocaixa.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "caixas")
@Entity(name = "Caixa")
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcaixa")
    private Long idCaixa;

    @JsonIgnore
    @OneToMany(mappedBy="caixa")
    private List<Transacao> transacoes;

    @Column(name = "saldo", nullable= false)
    private double saldo;
    @Column(name = "flagativo")
    private boolean flagAtivo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacriacao")
    private Date dataCriacao;

    public Long getIdCaixa() {
        return idCaixa;
    }
    public void setIdCaixa(Long idCaixa) {
        this.idCaixa = idCaixa;
    }
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean isFlagAtivo() {
        return flagAtivo;
    }
    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCaixa == null) ? 0 : idCaixa.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Caixa other = (Caixa) obj;
        if (idCaixa == null) {
            if (other.idCaixa != null)
                return false;
        } else if (!idCaixa.equals(other.idCaixa))
            return false;
        return true;
    }

}
