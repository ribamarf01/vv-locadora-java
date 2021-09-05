import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.projetolocadora.controller.AluguelController;
import com.mycompany.projetolocadora.model.Aluguel;

import java.time.LocalDate;
import java.util.ArrayList;

public class AluguelController_Tests {

    private AluguelController aluguelControllerTest;

    @BeforeEach
    void setUp() {
        this.aluguelControllerTest = new AluguelController();
    }

    @AfterEach
    void tearDown() {
        this.aluguelControllerTest = null;
    }

    Aluguel gerarAluguel() {
        Aluguel a = new Aluguel();

        a.setIdPessoa(1);
        a.setIdFilme(1);
        a.setDataAluguel(LocalDate.now());
        a.setEstaPago(false);

        return a;
    }

    @Test
    void adicionar_aluguel_resposta() {
        Aluguel aluguel = gerarAluguel();
        assertTrue(aluguelControllerTest.adicionarAluguel(aluguel, 1));
    }

    @Test
    void adicionar_aluguel_data_correta_de_aluguel() {
        Aluguel aluguel = gerarAluguel();
        aluguelControllerTest.adicionarAluguel(aluguel, 1);
        assertEquals(LocalDate.now(), aluguel.getDataAluguel());
    }

    @Test
    void adicionar_aluguel_data_correta_de_devolucao() {
        Aluguel aluguel = gerarAluguel();
        aluguelControllerTest.adicionarAluguel(aluguel, 3);
        assertEquals(LocalDate.now().plusDays(3), aluguel.getDataDevolucao());
    }

    @Test
    void adicionar_aluguel_preco_correto() {
        Aluguel aluguel = gerarAluguel();
        aluguelControllerTest.adicionarAluguel(aluguel, 3);
        assertEquals(3.30, aluguel.getValorAluguel());
    }

    @Test
    void aluguel_retorna_falso_numero_dias_zero_ou_negativo() {
        Aluguel aluguel = gerarAluguel();
        assertFalse(aluguelControllerTest.adicionarAluguel(aluguel, 0));
        assertFalse(aluguelControllerTest.adicionarAluguel(aluguel, -5));
    }

    @Test
    void listar_alugueis() {
        Aluguel aluguel = gerarAluguel();
        ArrayList<Aluguel> alugueis = new ArrayList<>();

        aluguelControllerTest.adicionarAluguel(aluguel, 3);
        alugueis.add(aluguel);

        assertEquals(alugueis, aluguelControllerTest.listarAlugueis());

        aluguelControllerTest.adicionarAluguel(aluguel, 6);
        alugueis.add(aluguel);

        assertEquals(alugueis, aluguelControllerTest.listarAlugueis());
    }

    @Test
    void quitar_aluguel() {
        Aluguel aluguel = gerarAluguel();
        aluguelControllerTest.adicionarAluguel(aluguel, 3);

        assertFalse(aluguel.isEstaPago());

        aluguelControllerTest.quitarAluguel(aluguel);
        assertTrue(aluguel.isEstaPago());
    }

    @Test
    void buscar_alugueis_pelo_id() {
        Aluguel aluguel = gerarAluguel();

        aluguelControllerTest.adicionarAluguel(aluguel, 3);

        assertEquals(aluguel, aluguelControllerTest.buscarPorId(1));

        aluguel = gerarAluguel();
        aluguelControllerTest.adicionarAluguel(aluguel, 7);

        assertEquals(aluguel, aluguelControllerTest.buscarPorId(2));
    }

    @Test
    void buscar_alugueis_por_pessoa() {
        Aluguel aluguel = gerarAluguel();
        ArrayList<Aluguel> alugueisDe1 = new ArrayList<>();

        aluguelControllerTest.adicionarAluguel(aluguel, 3);
        alugueisDe1.add(aluguel);
        aluguelControllerTest.adicionarAluguel(aluguel, 6);
        alugueisDe1.add(aluguel);
        
        aluguel = gerarAluguel();
        ArrayList<Aluguel> alugueisDe2 = new ArrayList<>();

        aluguel.setIdPessoa(2);
        aluguelControllerTest.adicionarAluguel(aluguel, 2);
        alugueisDe2.add(aluguel);
        
        assertEquals(alugueisDe1, aluguelControllerTest.buscarAluguelPorPessoaOuFilme(1, 1));
        assertEquals(alugueisDe2, aluguelControllerTest.buscarAluguelPorPessoaOuFilme(1, 2));
    }

    @Test
    void buscar_alugueis_por_filmes() {
        Aluguel aluguel = gerarAluguel();
        ArrayList<Aluguel> alugueisDe1 = new ArrayList<>();

        aluguelControllerTest.adicionarAluguel(aluguel, 3);
        alugueisDe1.add(aluguel);
        aluguelControllerTest.adicionarAluguel(aluguel, 6);
        alugueisDe1.add(aluguel);
        
        aluguel = gerarAluguel();
        ArrayList<Aluguel> alugueisDe2 = new ArrayList<>();

        aluguel.setIdFilme(2);
        aluguelControllerTest.adicionarAluguel(aluguel, 2);
        alugueisDe2.add(aluguel);
        
        assertEquals(alugueisDe1, aluguelControllerTest.buscarAluguelPorPessoaOuFilme(2, 1));
        assertEquals(alugueisDe2, aluguelControllerTest.buscarAluguelPorPessoaOuFilme(2, 2));
    }

    @Test
    void atualizar_aluguel() {
        Aluguel aluguel = gerarAluguel();
        aluguelControllerTest.adicionarAluguel(aluguel, 3);

        aluguel = gerarAluguel();
        aluguel.setId(1);

        aluguel.setIdFilme(3);

        assertNotEquals(aluguel, aluguelControllerTest.buscarPorId(1));
        assertTrue(aluguelControllerTest.atualizarAluguel(aluguel));
    }
}
