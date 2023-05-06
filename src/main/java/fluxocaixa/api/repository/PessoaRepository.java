package fluxocaixa.api.repository;

import java.util.Optional;

import fluxocaixa.api.domain.Pessoa;
import fluxocaixa.api.lancamento.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByNome (String nome);
    Pessoa findByCpf(String cpf);
}
