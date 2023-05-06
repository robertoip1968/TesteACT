package fluxocaixa.api.service;

import fluxocaixa.api.domain.Conta;
import fluxocaixa.api.domain.Transacao;
import fluxocaixa.api.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private TransacaoService transService;

    public Conta salvar(Conta conta) {
        return contaRepository.save(conta);
    }

    public void deposita( double quantidade, Long id) {
        contaRepository.setFixedSaldoFor(quantidade, id);
    }

    public void sacar( double quantidade, Long id) {
        contaRepository.setFixedSaldo(quantidade, id);
    }

    public Conta buscarSado(Long id) {
        return contaRepository.findByIdConta(id);
    }

    public List<Conta> listar() {
        return contaRepository.findAll();
    }
    public Conta verificarConta(Long id) {
        return contaRepository.findByIdConta(id);
    }

    public List<Transacao> extratoConta(Long id) {
        Conta c = verificarConta(id);
        return transService.buscarContas(c);

    }


}
