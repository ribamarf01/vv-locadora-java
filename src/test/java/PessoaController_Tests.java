import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.projetolocadora.model.Pessoa;
import com.mycompany.projetolocadora.controller.PessoaController;

import java.util.ArrayList;

public class PessoaController_Tests {

    private PessoaController pessoaControllerTest;

    @BeforeEach
    void setUp() {
        this.pessoaControllerTest = new PessoaController();
    }

    @AfterEach
    void tearDown() {
        this.pessoaControllerTest = null;
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
        Pessoa pessoa = genericPessoa();
        assertTrue(pessoaControllerTest.adicionarCliente(pessoa));
    }

    @Test
    void retorna_numero_correto_insercoes() {
        // Primeira pessoa
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);
        
        assertEquals(1, pessoaControllerTest.numeroClientesCadastrados());
        // Segunda pessoa
        pessoa = genericPessoa();
        pessoa.setNomeCompleto("Joaozinho pessoinha");
        pessoa.setCpf("98765432100");
        pessoaControllerTest.adicionarCliente(pessoa);

        assertEquals(2, pessoaControllerTest.numeroClientesCadastrados());
    }

    @Test
    void retorna_falso_em_insercoes_repetidas_de_pessoas() {
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);
        pessoa = genericPessoa();
        assertFalse(pessoaControllerTest.adicionarCliente(pessoa));
    }

    @Test
    void listar_clientes_corretamente() {
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        assertEquals(pessoas, pessoaControllerTest.listarClientes());

        pessoa = genericPessoa();
        pessoa.setNomeCompleto("Klebinho Furacão");
        pessoa.setCpf("98765432100");

        pessoaControllerTest.adicionarCliente(pessoa);
        pessoas.add(pessoa);

        assertEquals(pessoas, pessoaControllerTest.listarClientes());
    }

    @Test
    void buscar_cliente_pelo_cpf_sem_mascara() {
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);

        assertEquals(pessoa, pessoaControllerTest.buscarCliente("12345678900"));
    }

    @Test
    void buscar_cliente_pelo_cpf_com_mascara() {
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);

        assertEquals(pessoa, pessoaControllerTest.buscarCliente("123.456.789-00"));
    }

    @Test
    void buscar_cliente_pelo_id() {
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);

        assertEquals(pessoa, pessoaControllerTest.buscarCliente(1));

        pessoa = genericPessoa(); 
        pessoa.setCpf("98765432100");
        pessoa.setNomeCompleto("Klebinho Furacão");
        pessoaControllerTest.adicionarCliente(pessoa);

        assertEquals(pessoa, pessoaControllerTest.buscarCliente(2));
    }

    @Test
    void atualizar_cliente() {
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);
        pessoa = genericPessoa();
        pessoa.setNomeCompleto("José da Silva Sauro");
        pessoaControllerTest.atualizarCliente(pessoa);

        assertEquals("José da Silva Sauro", pessoaControllerTest.buscarCliente(1).getNomeCompleto());
    }

    @Test
    void excluir_cliente() {
        Pessoa pessoa = genericPessoa();
        pessoaControllerTest.adicionarCliente(pessoa);

        assertEquals(1, pessoaControllerTest.numeroClientesCadastrados());

        assertTrue(pessoaControllerTest.excluirCliente(pessoa));
        assertEquals(0, pessoaControllerTest.numeroClientesCadastrados());
    }
}
