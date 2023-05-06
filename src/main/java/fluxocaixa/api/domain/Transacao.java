package fluxocaixa.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Table(name = "transacoes")
@Entity(name = "Transacao")
public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idtransacao")
    private Long idTransacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcaixa")
    @JsonProperty("idcaixa")
    private Caixa caixa;

    @Column(name = "valor")
    private double valor;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datatransacao")
    @JsonProperty("datatransacao")
    private Date datatransacao;

    public Long getIdTransacao() {

        return idTransacao;
    }
    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }
    public Caixa getCaixa() {
        return caixa;
    }
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Date getDatatransacao() {
        return datatransacao;
    }
    public void setDatatransacao(Date datatransacao) {
        this.datatransacao = datatransacao;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTransacao == null) ? 0 : idTransacao.hashCode());
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
        Transacao other = (Transacao) obj;
        if (idTransacao == null) {
            if (other.idTransacao != null)
                return false;
        } else if (!idTransacao.equals(other.idTransacao))
            return false;
        return true;
    }

}
