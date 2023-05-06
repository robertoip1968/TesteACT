package fluxocaixa.api.lancamento;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosLancamento(
        @NotNull
        Long idcliente,
        @NotNull
        LocalDateTime datalancamento,
        @NotNull
        Tipolancamento tipolancamento,

        @NotNull
        Boolean ativo,

        @NotNull
        BigDecimal valorlancamento){}

