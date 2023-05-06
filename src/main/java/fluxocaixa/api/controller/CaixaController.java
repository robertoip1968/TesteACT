package fluxocaixa.api.controller;

import fluxocaixa.api.domain.Caixa;
import fluxocaixa.api.domain.Transacao;
import fluxocaixa.api.errors.ExceptionCustom;
import fluxocaixa.api.service.CaixaService;
import fluxocaixa.api.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("caixa")
public class CaixaController {

    @Autowired
    private CaixaService caixaService;

    //Abre um novo caixa
    @RequestMapping(method=RequestMethod.POST, path="salvar" )
    public ResponseEntity<?> salvar(@RequestBody Caixa caixa ){
        Caixa c = this.caixaService.salvar(caixa);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    //efetua um deposito (crétido) em uma determinada conta
    @RequestMapping(method=RequestMethod.PUT, path="depositar/{quantidade}/{id}" )
    public ResponseEntity<?> depositar(@PathVariable double quantidade, @PathVariable Long id){

        this.caixaService.deposita(quantidade, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    //retorna um saldo de uma determinada conta
    @RequestMapping(method=RequestMethod.GET, path="saldo/{id}" )
    public ResponseEntity<?> saldo( @PathVariable Long id){

        Caixa c = caixaService.buscarSado(id);

        return new ResponseEntity<>(c.getSaldo(), HttpStatus.OK);
    }
    //efetua um saque (débito) em uma conta
    @RequestMapping(method=RequestMethod.PUT, path="sacar/{quantidade}/{id}" )
    public ResponseEntity<?> sacar(@PathVariable double quantidade, @PathVariable Long id){
        if (quantidade <= 0) {
            throw new ExceptionCustom("valor incorreto");
        }
        this.caixaService.sacar(quantidade, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    //retorna todas as contas
    @RequestMapping(method=RequestMethod.GET, path="listar" )
    public ResponseEntity<?> listar(){

        List<Caixa> caixas = caixaService.listar();

        return new ResponseEntity<>(caixas, HttpStatus.OK);
    }
    //retorna uma lista de transacoes em uma determinada conta
    @RequestMapping(method=RequestMethod.GET, path="extratoCaixa/{id}" )
    public ResponseEntity<?> extratoConta(@PathVariable Long id){
        List<Transacao> transacoes = caixaService.extratoCaixa(id);

        return new ResponseEntity<>(transacoes,HttpStatus.OK);
    }
    //retorna somente os caixas ativos
    @RequestMapping(method=RequestMethod.GET, path="buscarCaixa/{id}" )
    public ResponseEntity<?> verificarCaixaAtivo(@PathVariable Long id){

        Caixa caixa = caixaService.verificarCaixa(id) ;
        if (caixa.isFlagAtivo() == false) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(caixa.isFlagAtivo(),HttpStatus.OK);
    }
}