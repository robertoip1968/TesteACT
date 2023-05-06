package fluxocaixa.api.service;

import fluxocaixa.api.domain.Pessoa;
import fluxocaixa.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }
}
