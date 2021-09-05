import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import com.mycompany.projetolocadora.model.Pessoa;

public class Pessoa_Tests {

    private Pessoa pessoaTest;

    @BeforeEach
    void setUp() {
        pessoaTest = new Pessoa();
    }

    @AfterEach
    void tearDown() {
        pessoaTest = null;
    }

    @Test
    void nome_valido_test() {
        pessoaTest.setNomeCompleto("João Pessoa");
        assertEquals("João Pessoa", pessoaTest.getNomeCompleto());
    }
    
    @Test
    void telefone_coloca_mascara_test() {
        pessoaTest.setTelefone("85987654321");
        assertEquals("85 98765-4321", pessoaTest.getTelefone());
    }

    @Test
    void telefone_aceita_mascara_test() {
        pessoaTest.setTelefone("85 98765-4321");
        assertEquals("85 98765-4321", pessoaTest.getTelefone());
    }

    @Test
    void cpf_coloca_mascara_test() {
        pessoaTest.setCpf("12345678900");
        assertEquals("123.456.789-00", pessoaTest.getCpf());
    }

    @Test
    void cpf_aceita_mascara_test() {
        pessoaTest.setCpf("123.456.789-00");
        assertEquals("123.456.789-00", pessoaTest.getCpf());
    }

    @Test
    void dataNasc_coloca_mascara_test() {
        pessoaTest.setDataNascimento("02052001");
        assertEquals("02/05/2001", pessoaTest.getDataNascimento());
    }

    @Test
    void dataNasc_aceita_mascara_test() {
        pessoaTest.setDataNascimento("02/05/2001");
        assertEquals("02/05/2001", pessoaTest.getDataNascimento());
    }

    @Test
    void dataNasc_corrige_ano_reduzido_test() { // Ano reduzido: 02/05/2001 = 02/05/01 ou 24/04/1965 = 24/04/65
        pessoaTest.setDataNascimento("020501");
        assertEquals("02/05/2001", pessoaTest.getDataNascimento());
        pessoaTest.setDataNascimento("24/04/65");
        assertEquals("24/04/1965", pessoaTest.getDataNascimento());
    }
    
    @Test
    void checa_email_valido_test() {
        pessoaTest.setEmail("joaoemailcom");
        assertNotEquals("joao@email.com", pessoaTest.getEmail());
    }
    
    Pessoa genericPessoa() {
        Pessoa p = new Pessoa();
        p.setNomeCompleto("João Pessoa");
        p.setTelefone("12345678");
        p.setCpf("12345678900");
        p.setSexo("M");
        p.setDataNascimento("02052001");
        p.setEndereco("Rua A");
        p.setEmail("joao@email.com");
        return p;
    }
}
