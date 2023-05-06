package fluxocaixa.api.repository;

import java.util.List;

import fluxocaixa.api.domain.Conta;
import fluxocaixa.api.domain.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    // List<Transacao> findByContaIn(Conta conta);

}
