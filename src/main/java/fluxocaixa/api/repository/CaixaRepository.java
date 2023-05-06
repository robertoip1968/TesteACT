package fluxocaixa.api.repository;

import fluxocaixa.api.domain.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CaixaRepository extends JpaRepository<Caixa, Long>{

    @Modifying
    @Query("update Caixa c set c.saldo = c.saldo + ?1 where c.idCaixa = ?2")
    void setFixedSaldoFor(double  quantidade, Long id);


    Caixa findByIdCaixa(Long id);

    @Modifying
    @Query("update Caixa c set c.saldo = c.saldo - ?1 where c.idCaixa = ?2")
    void setFixedSaldo(double  quant, Long id);
}