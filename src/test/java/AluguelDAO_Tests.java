import com.mycompany.projetolocadora.dao.AluguelDAO;
import com.mycompany.projetolocadora.model.Aluguel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.sql.DataSource;

public class AluguelDAO_Tests {
    
    private AluguelDAO aluguelDAOTest;

    @Mock
    private final DataSource ds = Mockito.mock(DataSource.class);

    @BeforeEach
    void setUp() {
        aluguelDAOTest = new AluguelDAO(ds);
    }

    @AfterEach
    void tearDown() {
        aluguelDAOTest = null;
    }

    Aluguel genericAluguel() {
        Aluguel a = new Aluguel();

        a.setIdPessoa(1);
        a.setIdFilme(1);
        a.setEstaPago(false);

        return a;
    }

    @Test
    void adicionar_aluguel_corretamente() {
        Aluguel aluguel = genericAluguel();

        assertTrue(aluguelDAOTest.adicionarAluguel(aluguel));
    }

    // @Test
    // void adicionar_aluguel_e_retornar_quantidade_correta() {
    //     Aluguel aluguel = genericAluguel();
    //     aluguelDAOTest.adicionarAluguel(aluguel);
    //     assertEquals(1, aluguelDAOTest.numeroAlugueis());
    //     aluguel = genericAluguel();
    //     assertNotEquals(2, aluguelDAOTest.numeroAlugueis());
    //     aluguelDAOTest.adicionarAluguel(aluguel);
    //     assertEquals(2, aluguelDAOTest.numeroAlugueis());
    // }

    @Test
    void listar_alugueis_corretamente() {
        Aluguel aluguel = genericAluguel();
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        
        aluguelDAOTest.adicionarAluguel(aluguel);
        alugueis.add(aluguel);

        aluguel = genericAluguel();
        aluguelDAOTest.adicionarAluguel(aluguel);
        alugueis.add(aluguel);

        assertEquals(alugueis, aluguelDAOTest.listarAlugueis());
    }

    @Test
    void buscar_por_pessoa() {
        Aluguel aluguel = genericAluguel();
        ArrayList<Aluguel> alugueisId1 = new ArrayList<>();
        ArrayList<Aluguel> alugueisId2 = new ArrayList<>();


        aluguelDAOTest.adicionarAluguel(aluguel);
        alugueisId1.add(aluguel);

        aluguel = genericAluguel();
        aluguel.setIdPessoa(2);
        alugueisId2.add(aluguel);
        aluguelDAOTest.adicionarAluguel(aluguel);

        assertEquals(alugueisId1, aluguelDAOTest.buscarPorPessoa(1));
        assertEquals(alugueisId2, aluguelDAOTest.buscarPorPessoa(2));
    }

    @Test
    void buscar_por_filme() {
        Aluguel aluguel = genericAluguel();
        ArrayList<Aluguel> alugueisId1 = new ArrayList<>();
        ArrayList<Aluguel> alugueisId2 = new ArrayList<>();


        aluguelDAOTest.adicionarAluguel(aluguel);
        alugueisId1.add(aluguel);

        aluguel = genericAluguel();
        aluguel.setIdFilme(2);
        alugueisId2.add(aluguel);
        aluguelDAOTest.adicionarAluguel(aluguel);

        assertEquals(alugueisId1, aluguelDAOTest.buscarPorFilme(1));
        assertEquals(alugueisId2, aluguelDAOTest.buscarPorFilme(2));
    }

    @Test
    void atualizar_aluguel() {
        Aluguel aluguel = genericAluguel();
        aluguelDAOTest.adicionarAluguel(aluguel);

        Aluguel aluguel2 = genericAluguel();

        aluguel.setDataDevolucao(LocalDate.now().plusDays(3));
        aluguelDAOTest.atualizarAluguel(aluguel);

        assertEquals(aluguel, aluguelDAOTest.buscarPorId(1));
        assertNotEquals(aluguel2, aluguelDAOTest.buscarPorId(1));
    }

    @Test
    void excluir_aluguel() {
        Aluguel aluguel = genericAluguel();
        aluguelDAOTest.adicionarAluguel(aluguel);
        assertTrue(aluguelDAOTest.excluirAluguel(aluguel));
        assertNull(aluguelDAOTest.buscarPorId(1));
    }

}
