import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.projetolocadora.controller.FilmeController;
import com.mycompany.projetolocadora.model.Filme;

import java.util.ArrayList;

public class FilmeContoller_Tests {
    
    private FilmeController filmeControllerTest;

    @BeforeEach
    void setUp() {
        this.filmeControllerTest = new FilmeController();
    }

    @AfterEach
    void tearDown() {
        this.filmeControllerTest = null;
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
    void adicionar_filme() {
        Filme filme = genericFilme();
        assertTrue(filmeControllerTest.adicionarFilme(filme));
    }

    @Test
    void retorna_numero_correto_insercoes() {
        Filme filme = genericFilme();
        filmeControllerTest.adicionarFilme(filme);
        assertEquals(1, filmeControllerTest.numeroFilmesCadastrados());
        filme = genericFilme();
        filme.setTitulo("Poeira em alto mar");
        filmeControllerTest.adicionarFilme(filme);
        assertEquals(2, filmeControllerTest.numeroFilmesCadastrados());
    }

    @Test
    void retorna_falso_em_insercoes_repetidas() {
        Filme filme = genericFilme();
        filmeControllerTest.adicionarFilme(filme);

        filme = genericFilme();

        assertFalse(filmeControllerTest.adicionarFilme(filme));
    }

    @Test
    void listar_filmes() {
        Filme filme = genericFilme();
        ArrayList<Filme> filmes = new ArrayList<>();

        filmeControllerTest.adicionarFilme(filme);
        filmes.add(filme);

        filme = genericFilme();
        filme.setTitulo("As tranças do rei careca!");
        filmes.add(filme);
        filmeControllerTest.adicionarFilme(filme);

        assertEquals(filmes, filmeControllerTest.listarFilmes());
    }

    @Test
    void buscar_filme_pelo_id() {
        Filme filme = genericFilme();
        filmeControllerTest.adicionarFilme(filme);

        assertEquals(filme, filmeControllerTest.buscarFilmePorId(1));

        filme = genericFilme();
        filme.setTitulo("Água molhada: O retorno");
        filmeControllerTest.adicionarFilme(filme);

        assertEquals(filme, filmeControllerTest.buscarFilmePorId(2));
    }

    @Test
    void buscar_filme_pelo_titulo() {
        Filme filme = genericFilme();
        filmeControllerTest.adicionarFilme(filme);

        assertEquals(filme, filmeControllerTest.buscarFilmePorTitulo(filme.getTitulo()));
    }

    @Test
    void buscar_filme_pelo_genero() {
        Filme filmeComedia = genericFilme();
        filmeControllerTest.adicionarFilme(filmeComedia);
        ArrayList<Filme> resultadoComedia = new ArrayList<>();
        resultadoComedia.add(filmeComedia);

        Filme filmeAcao = genericFilme();
        filmeAcao.setTitulo("A 25 hora do dia");
        filmeAcao.setGenero("Ação");

        filmeControllerTest.adicionarFilme(filmeAcao);
        ArrayList<Filme> resultadoAcao = new ArrayList<>();
        resultadoAcao.add(filmeAcao);

        assertEquals(resultadoComedia, filmeControllerTest.buscarFilmePorGeneroOuDiretor(1, "Comédia"));
        assertEquals(resultadoAcao, filmeControllerTest.buscarFilmePorGeneroOuDiretor(1, "Ação"));
    }

    @Test
    void buscar_filme_pelo_diretor() {
        Filme filmeSteven = genericFilme();
        filmeControllerTest.adicionarFilme(filmeSteven);
        ArrayList<Filme> resultadoSteven = new ArrayList<>();
        resultadoSteven.add(filmeSteven);

        Filme filmeTangerino = genericFilme();
        filmeTangerino.setTitulo("A 25 hora do dia");
        filmeTangerino.setDiretor("Quentinhas Tangerino");

        filmeControllerTest.adicionarFilme(filmeTangerino);
        ArrayList<Filme> resultadoTangerino = new ArrayList<>();
        resultadoTangerino.add(filmeTangerino);

        assertEquals(resultadoSteven, filmeControllerTest.buscarFilmePorGeneroOuDiretor(2, "Steven Universo"));
        assertEquals(resultadoTangerino, filmeControllerTest.buscarFilmePorGeneroOuDiretor(2, "Quentinhas Tangerino"));
    }

    @Test
    void atualizar_filme() {
        Filme filme = genericFilme();
        filmeControllerTest.adicionarFilme(filme);

        filme = genericFilme();
        filme.setId(1);
        filme.setTitulo("Et bilu, o extraterrestre");

        assertNotEquals(filme, filmeControllerTest.buscarFilmePorId(1));
        assertTrue(filmeControllerTest.atualizarFilme(filme));
        assertEquals(filme.getTitulo(), filmeControllerTest.buscarFilmePorId(1).getTitulo());
    }

    @Test
    void excluir_filme() {
        Filme filme = genericFilme();
        filmeControllerTest.adicionarFilme(filme);
        
        assertEquals(1, filmeControllerTest.numeroFilmesCadastrados());

        assertTrue(filmeControllerTest.excluirFilme(filme));

        assertEquals(0, filmeControllerTest.numeroFilmesCadastrados());
    }

}
