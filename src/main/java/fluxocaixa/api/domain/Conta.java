package fluxocaixa.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "contas")
@Entity(name = "Conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idconta")
    private Long idConta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idpessoa")
    @JsonProperty("idpessoa")
    private Pessoa pessoa;

    //@JsonIgnore
    //@OneToMany(mappedBy= "conta")
    //private List<Transacao> transacoes;

    @Column(name = "saldo", nullable= false)
    private double saldo;
    @Column(name = "limitesaquediario")
    private double limiteSaqueDiario;
    @Column(name = "flagativo")
    private boolean flagAtivo;
    @Column(name = "tipo")
    private String tipo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacriacao")
    private Date dataCriacao;

    public Long getIdConta() {
        return idConta;
    }
    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /*
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
    */
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }
    public void setLimiteSaqueDiario(double limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }
    public boolean isFlagAtivo() {
        return flagAtivo;
    }
    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
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
        Conta other = (Conta) obj;
        if (idConta == null) {
            if (other.idConta != null)
                return false;
        } else if (!idConta.equals(other.idConta))
            return false;
        return true;
    }

}
