package fluxocaixa.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpessoa")
    private Long idpessoa;
    @Column(name = "nome", nullable=false)
    private String nome;
    @Length(min=11, max=11)
    @Column(name = "cpf", unique=true)
    private String cpf;
    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "datanascimento", nullable=false)
    private Date datanascimento;
    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
    private List<Conta> contas;

    public Long getIdpessoa() {
        return idpessoa;
    }
    public void setIdpessoa(Long idpessoa) {
        this.idpessoa = idpessoa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getDatanascimento() {
        return datanascimento;
    }
    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }
    public List<Conta> getContas() {
        return contas;
    }
    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}
