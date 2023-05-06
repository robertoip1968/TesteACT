package fluxocaixa.api.lancamento;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "lancamentos")
@Entity(name = "Lancamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private Long idcliente;
    private LocalDateTime datalancamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Tipolancamento tipolancamento;

    private BigDecimal valorlancamento;

    private boolean ativo = true;

    public Lancamento(DadosLancamento dados) {
        this.idcliente = dados.idcliente();
        this.datalancamento = dados.datalancamento();
        this.tipolancamento = dados.tipolancamento();
        this.valorlancamento = dados.valorlancamento();
    }

    public void calcularSaldo(DadosCalculoSalso dados) {
        /*
        if (dados.datasaldo() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        */
    }

    public void excluir() {
        this.ativo = false;
    }
}
