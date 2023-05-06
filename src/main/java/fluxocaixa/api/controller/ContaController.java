package fluxocaixa.api.controller;

import fluxocaixa.api.domain.Conta;
import fluxocaixa.api.service.ContaService;
import fluxocaixa.api.domain.Transacao;
import fluxocaixa.api.errors.ExceptionCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    //salva uma nova conta
    @RequestMapping(method=RequestMethod.POST, path="salvar" )
    public ResponseEntity<?> salvar(@RequestBody Conta conta ){
        Conta c = this.contaService.salvar(conta);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    //efetua um deposito (crétido) em uma determinada conta
    @RequestMapping(method=RequestMethod.PUT, path="depositar/{quantidade}/{id}" )
    public ResponseEntity<?> depositar(@PathVariable double quantidade, @PathVariable Long id){

        this.contaService.deposita(quantidade, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    //retorna um saldo de uma determinada conta
    @RequestMapping(method=RequestMethod.GET, path="saldo/{id}" )
    public ResponseEntity<?> saldo( @PathVariable Long id){

        Conta c = contaService.buscarSado(id);

        return new ResponseEntity<>(c.getSaldo(), HttpStatus.OK);
    }
    //efetua um saque (débito) em uma conta
    @RequestMapping(method=RequestMethod.PUT, path="sacar/{quantidade}/{id}" )
    public ResponseEntity<?> sacar(@PathVariable double quantidade, @PathVariable Long id){
        if (quantidade <= 0) {
            throw new ExceptionCustom("valor incorreto");
        }
        this.contaService.sacar(quantidade, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    //retorna todas as contas
    @RequestMapping(method=RequestMethod.GET, path="listar" )
    public ResponseEntity<?> listar(){

        List<Conta> contas = contaService.listar();

        return new ResponseEntity<>(contas, HttpStatus.OK);
    }
    //retorna uma lista de transacoes em uma determinada conta
    @RequestMapping(method=RequestMethod.GET, path="extratoConta/{id}" )
    public ResponseEntity<?> extratoConta(@PathVariable Long id){
        List<Transacao> transacoes = contaService.extratoConta(id);

        return new ResponseEntity<>(transacoes,HttpStatus.OK);
    }
    //retorna somente as contas ativas
    @RequestMapping(method=RequestMethod.GET, path="buscarConta/{id}" )
    public ResponseEntity<?> verificarContaAtiva(@PathVariable Long id){

        Conta conta = contaService.verificarConta(id) ;
        if (conta.isFlagAtivo() == false) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(conta.getPessoa(),HttpStatus.OK);
    }

}