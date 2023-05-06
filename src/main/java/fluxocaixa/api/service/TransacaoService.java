package fluxocaixa.api.service;

import fluxocaixa.api.domain.Caixa;
import fluxocaixa.api.domain.Conta;
import fluxocaixa.api.domain.Transacao;
import fluxocaixa.api.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao salvar(Transacao trans) {
        return transacaoRepository.save(trans);
    }

    public List<Transacao> listar() {
        return transacaoRepository.findAll();
    }

    public void delete(Long id) {
        transacaoRepository.deleteById(id);
    }

    public void buscarPeloId(Long id) {
        transacaoRepository.findById(id);
    }

    public List<Transacao> buscarContas(Conta conta) {
        //return transacaoRepository.findByContaIn(conta);
        return transacaoRepository.findAll();
    }

    public List<Transacao> buscarCaixas(Caixa caixa) {
        //return transacaoRepository.findByContaIn(conta);
        return transacaoRepository.findAll();
    }

}
