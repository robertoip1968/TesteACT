package fluxocaixa.api.repository;

import fluxocaixa.api.domain.Pessoa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;
    private static final String cpf = "38425580153";
    private static final String cpfInvalido = "3842558015";

    @Before
    public void setUp() throws Exception {
        Pessoa pessoa =  new Pessoa();
        pessoa.setNome("roberto iris");
        pessoa.setCpf(cpf);
        this.pessoaRepository.save(pessoa);
    }

    @Test
    public void testBuscarPorCpfValido() {
        Pessoa pessoa = this.pessoaRepository.findByCpf(cpf);
        assertEquals(cpf, pessoa.getCpf());
    }
    @Test
    public void testBuscarPorCpfInvalido() {
        Pessoa pessoa = this.pessoaRepository.findByCpf(cpf);
        assertNotEquals(cpfInvalido, pessoa);
    }

    /*
    @After
    public final void tearDown() {
        this.pessoaRepository.deleteAll();
    }
    */
}