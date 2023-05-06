package fluxocaixa.api.lancamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DadosSaldo(Long id, Long idcliente, LocalDateTime datalancamento, Tipolancamento tipolancamento, BigDecimal valorlancamento, Boolean ativo) {

    public DadosSaldo(Lancamento lancamento) {
        this(lancamento.getId(), lancamento.getIdcliente(), lancamento.getDatalancamento(), lancamento.getTipolancamento(), lancamento.getValorlancamento(), lancamento.isAtivo());
    }

}
