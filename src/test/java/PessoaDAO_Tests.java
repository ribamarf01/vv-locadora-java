import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.projetolocadora.dao.PessoaDAO;
import com.mycompany.projetolocadora.model.Pessoa;

import java.util.ArrayList;

import javax.sql.DataSource;

public class PessoaDAO_Tests {
    
    private PessoaDAO pessoaDAOTest;

    @Mock
    private DataSource ds = Mockito.mock(DataSource.class);

    @BeforeEach
    void setUp() {
        pessoaDAOTest = new PessoaDAO(ds);
    }

    @AfterEach
    void tearDown() {
        pessoaDAOTest = null;
    }

    Pessoa genericPessoa() {
        Pessoa p = new Pessoa();
        p.setNomeCompleto("João Pessoa");
        p.setTelefone("00123456789");
        p.setCpf("12345678900");
        p.setSexo("M");
        p.setDataNascimento("02052001");
        p.setEndereco("Rua A");
        p.setEmail("joao@email.com");
        return p;
    }

    @Test
    void insere_pessoa_corretamente() {
        Pessoa pessoa = new Pessoa();
        pessoa = genericPessoa();

        assertTrue(pessoaDAOTest.adicionarPessoa(pessoa));
    }

    @Test
    void insere_pessoa_corretamente_e_retorna_quantidade() {
        Pessoa pessoa = new Pessoa();
        pessoa = genericPessoa();

        assertTrue(pessoaDAOTest.adicionarPessoa(pessoa));

        assertEquals(1, pessoaDAOTest.numPessoas());
    }

    @Test
    void insere_sem_repeticoes() {
        Pessoa pessoa = genericPessoa();
        pessoaDAOTest.adicionarPessoa(pessoa);
        pessoa = genericPessoa();
        assertFalse(pessoaDAOTest.adicionarPessoa(pessoa));
    }

    @Test
    void listar_pessoas_corretamente() {
        Pessoa pessoa = new Pessoa();
        pessoa = genericPessoa();
        pessoaDAOTest.adicionarPessoa(pessoa);

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        assertEquals(pessoas, pessoaDAOTest.listarPessoas());
    }

    @Test
    void buscarPeloCpf_com_mascara_inclusa() {
        Pessoa pessoa = new Pessoa();
        pessoa = genericPessoa();
        pessoaDAOTest.adicionarPessoa(pessoa);

        Pessoa pessoaBuscarCpf = pessoaDAOTest.buscarPeloCpf(pessoa.getCpf());

        assertEquals(pessoa, pessoaBuscarCpf);
    }

    @Test
    void buscar_pessoa_pelo_id() {
        Pessoa pessoa = genericPessoa();
        pessoaDAOTest.adicionarPessoa(pessoa);

        assertEquals(pessoa, pessoaDAOTest.buscarPeloId(1));

        pessoa = genericPessoa();
        pessoa.setCpf("98765432111");
        pessoa.setNomeCompleto("Klebinho Furacão");
        pessoaDAOTest.adicionarPessoa(pessoa);

        assertEquals(pessoa, pessoaDAOTest.buscarPeloId(2));
    }

    @Test
    void buscarPeloCpf_sem_mascara() {
        Pessoa pessoa = new Pessoa();
        pessoa = genericPessoa();
        pessoaDAOTest.adicionarPessoa(pessoa);
        
        Pessoa pessoaBuscarCpf = pessoaDAOTest.buscarPeloCpf("12345678900");
        assertEquals(pessoa, pessoaBuscarCpf);
    }

    @Test
    void atualizarPessoa_corretamente() {
        Pessoa pessoa = new Pessoa();
        pessoa = genericPessoa();
        pessoaDAOTest.adicionarPessoa(pessoa);
        Pessoa pessoaEditar = genericPessoa();
        pessoaEditar.setNomeCompleto("João da Silva Sauro");

        assertTrue(pessoaDAOTest.atualizarPessoa(pessoaEditar));

        Pessoa pessoaBuscarCpf = pessoaDAOTest.buscarPeloCpf("12345678900");
        assertNotEquals("João Pessoa", pessoaBuscarCpf.getNomeCompleto());
    }

    @Test
    void excluirPessoa_corretamente() {
        Pessoa pessoa = genericPessoa();
        pessoaDAOTest.adicionarPessoa(pessoa);
        assertEquals(1, pessoaDAOTest.numPessoas());
        assertTrue(pessoaDAOTest.excluirPessoa(pessoa));
        assertEquals(0, pessoaDAOTest.numPessoas());
    }

}
