package fluxocaixa.api.lancamento;

import fluxocaixa.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosCalculoSalso(
        @NotNull
        Long id,
        LocalDateTime datasaldo,
        BigDecimal totalCredito,
        BigDecimal totalDebito,
        BigDecimal saldo) {
}
