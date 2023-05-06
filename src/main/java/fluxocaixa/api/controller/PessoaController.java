package fluxocaixa.api.controller;

import fluxocaixa.api.domain.Pessoa;
import fluxocaixa.api.repository.PessoaRepository;
import fluxocaixa.api.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;
    @Autowired
    PessoaRepository repository;


    @RequestMapping(method=RequestMethod.POST, path="salvar")
    public ResponseEntity<?> salvar(@RequestBody Pessoa pessoa){
        Pessoa p = pessoaService.salvar(pessoa);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.GET, path="listar")
    public ResponseEntity<?> listar(){
        List<Pessoa> pessoas = pessoaService.listar();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }


}
