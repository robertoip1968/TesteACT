package fluxocaixa.api.service;

import fluxocaixa.api.domain.Caixa;
import fluxocaixa.api.domain.Transacao;
import fluxocaixa.api.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaixaService {
    @Autowired
    private CaixaRepository caixaRepository;
    @Autowired
    private TransacaoService transService;

    public Caixa salvar(Caixa conta) {
        return caixaRepository.save(conta);
    }

    public void deposita( double quantidade, Long id) {
        caixaRepository.setFixedSaldoFor(quantidade, id);
    }

    public void sacar( double quantidade, Long id) {
        caixaRepository.setFixedSaldo(quantidade, id);
    }

    public Caixa buscarSado(Long id) {
        return caixaRepository.findByIdCaixa(id);
    }

    public List<Caixa> listar() {
        return caixaRepository.findAll();
    }
    public Caixa verificarCaixa(Long id) {
        return caixaRepository.findByIdCaixa(id);
    }

    public List<Transacao> extratoCaixa(Long id) {
        Caixa c = verificarCaixa(id);
        return transService.buscarCaixas(c);

    }


}
