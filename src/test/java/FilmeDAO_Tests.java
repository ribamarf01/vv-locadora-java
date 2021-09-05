import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.projetolocadora.dao.FilmeDAO;
import com.mycompany.projetolocadora.model.Filme;

import java.util.ArrayList;

import javax.sql.DataSource;

public class FilmeDAO_Tests {
    
    private FilmeDAO filmeDAOTest;
    
    @Mock
    private DataSource ds = Mockito.mock(DataSource.class);

    @BeforeEach
    void setUp() {
        filmeDAOTest = new FilmeDAO(ds);
    }

    @AfterEach
    void tearDown() {
        filmeDAOTest = null;
    }

    Filme genericFilme() {
        Filme filme = new Filme();

        filme.setTitulo("A volta dos que nunca foram");
        filme.setDescricao("A muito tempo atrás mas não muito distante, houve um rei que pasmem, reinava, então um dia ele decidiu invadir outro reino com seu exército, que não foi, e teve de inventar história sobre a volta dos que não foram.");
        filme.setGenero("Comédia");
        filme.setAno("1999");
        filme.setDuracao("120");
        filme.setDiretor("Steven Universo");
        filme.setEstudio("Paramount");
        
        return filme;
    }

    @Test
    void adicionar_filme_corretamente() {
        Filme filme = genericFilme();

        assertTrue(filmeDAOTest.adicionarFilme(filme));
    }

    @Test
    void adicionar_filme_e_retorna_quantidade_total() {
        Filme filme = genericFilme();
        filmeDAOTest.adicionarFilme(filme);
        assertEquals(1, filmeDAOTest.numFilmes());
        filme = genericFilme();
        filmeDAOTest.adicionarFilme(filme);
        assertEquals(2, filmeDAOTest.numFilmes());
    }

    @Test
    void insere_sem_repeticoes() {
        Filme filme = genericFilme();
        filmeDAOTest.adicionarFilme(filme);
        assertFalse(filmeDAOTest.adicionarFilme(filme));
    }

    @Test
    void listar_filme_corretamente() {
        Filme filme = genericFilme();
        filmeDAOTest.adicionarFilme(filme);
        
        ArrayList<Filme> filmes = new ArrayList<>();
        filmes.add(filme);

        assertEquals(filmes, filmeDAOTest.listarFilmes());
    }

    @Test
    void buscar_pelo_titulo_funcionando_corretamente() {
        Filme filme = genericFilme();   
        filmeDAOTest.adicionarFilme(filme);
        String titulo = "A volta dos que nunca foram";
        assertEquals(filme, filmeDAOTest.buscarPeloTitulo(titulo));
    }

    @Test
    void buscar_pelo_genero_funcionando_corretamente() {
        Filme filme = genericFilme();

        ArrayList<Filme> filmesComedia = new ArrayList<>();
        ArrayList<Filme> filmesAcao = new ArrayList<>();

        filmesComedia.add(filme);
        filmeDAOTest.adicionarFilme(filme);

        filme = genericFilme();
        filme.setTitulo("Gelo molhado");
        filmesComedia.add(filme);
        filmeDAOTest.adicionarFilme(filme);

        filme = genericFilme();
        filme.setTitulo("As tranças do rei careca");
        filme.setGenero("Ação");
        filmesAcao.add(filme);
        filmeDAOTest.adicionarFilme(filme);        

        assertEquals(filmesComedia, filmeDAOTest.buscarPeloGenero("Comédia"));
        assertEquals(filmesAcao, filmeDAOTest.buscarPeloGenero("Ação"));
    }

    @Test
    void buscar_por_diretor_funcionando_corretamente() {
        Filme filme = genericFilme();

        ArrayList<Filme> dirigidoPorSteven = new ArrayList<>();
        ArrayList<Filme> dirigidoPorPedrinho = new ArrayList<>();

        dirigidoPorSteven.add(filme);
        filmeDAOTest.adicionarFilme(filme);

        filme = genericFilme();
        filme.setTitulo("Gelo molhado");
        dirigidoPorSteven.add(filme);
        filmeDAOTest.adicionarFilme(filme);

        filme = genericFilme();
        filme.setTitulo("As tranças do rei careca");
        filme.setGenero("Ação");
        filme.setDiretor("Pedrinho Desgraçadão");
        dirigidoPorPedrinho.add(filme);
        filmeDAOTest.adicionarFilme(filme);        

        assertEquals(dirigidoPorSteven, filmeDAOTest.buscarPorDiretor("Steven Universo"));
        assertEquals(dirigidoPorPedrinho, filmeDAOTest.buscarPorDiretor("Pedrinho Desgraçadão"));
    }

    @Test
    void atualiza_filme_corretamente() {
        Filme filme1 = genericFilme();
        filmeDAOTest.adicionarFilme(filme1);
        
        Filme filme2 = genericFilme();
        filme2.setTitulo("Iceberg em chamas");
        
        assertTrue(filmeDAOTest.atualizarFilme(1, filme2));

        Filme filme3 = filmeDAOTest.buscarPeloTitulo("Iceberg em chamas");
    
        assertEquals("Iceberg em chamas", filme3.getTitulo());
        assertEquals(1, filme3.getId());
    }

    @Test
    void exclui_filme_corretamente() {
        Filme filme = genericFilme();
        filmeDAOTest.adicionarFilme(filme);
        assertEquals(1, filmeDAOTest.numFilmes());
        assertTrue(filmeDAOTest.excluirFilme(filme.getId()));
        assertEquals(0, filmeDAOTest.numFilmes());
    }

}
