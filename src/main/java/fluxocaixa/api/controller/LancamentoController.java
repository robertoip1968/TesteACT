package fluxocaixa.api.controller;

import fluxocaixa.api.lancamento.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosLancamento dados) {
        repository.save(new Lancamento(dados));
    }

    @GetMapping
    public Page<DadosSaldo> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosSaldo::new);
    }

    /*
    @GetMapping("/{id}")
    public Page<DadosSaldo> listarPorCliente(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.findbyAllById(paginacao).map(DadosSaldo::new);
    }
    */
    @PutMapping
    @Transactional
    public void calculaSaldo(@RequestBody @Valid DadosCalculoSalso dados) {
        var lancamento = repository.getReferenceById(dados.id());
        lancamento.calcularSaldo(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var lancamento = repository.getReferenceById(id);
        lancamento.excluir();
    }

}
