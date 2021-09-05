import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.projetolocadora.model.Filme;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Filme_Tests {
    
    private Filme filmeTeste;
    
    public Filme_Tests() {
    }
    
    @BeforeEach
    void setUp() {
        filmeTeste = new Filme();
    }
    
    @AfterEach
    void tearDown() {
        filmeTeste = null;
    }

    @Test
    void titulo_e_valido() {
        filmeTeste.setTitulo("A volta dos que não foram!");
        assertEquals("A volta dos que não foram!", filmeTeste.getTitulo());
    }

    @Test
    void descricao_possui_ate_300_caracteres() {
        String desc = "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.";
        // 249 caracteres, teste passa
        filmeTeste.setDescricao(desc);
        assertEquals(desc, filmeTeste.getDescricao());
    }

    @Test
    void descricao_possui_mais_de_300_caracteres() {
        String desc = "Quando um de seus antigos colegas é assassinado, o vigilante mascarado Rorschach descobre um plano para matar e desacreditar todos os super-heróis do passado e do presente. À medida que ele se reconecta com sua antiga legião de combate ao crime, um grupo desorganizado de super-heróis aposentados, dentre os quais somente um possui verdadeiros poderes, Rorschach vislumbra uma ampla e perturbadora conspiração que está ligada ao passado deles e a catastróficas consequências para o futuro.";
        // 489 letras, não passa, o sistema corta a string para o máximo.
        filmeTeste.setDescricao(desc);
        assertNotEquals(desc, filmeTeste.getDescricao());
    }

    @Test
    void descricao_vazia() {
        // descricao = "Sem descrição disponível."
        String desc = "";
        filmeTeste.setDescricao(desc);
        assertEquals("Sem descrição disponível.", filmeTeste.getDescricao());
    }

    @Test
    void genero_e_valido() {
        String genero = "Comédia";
        filmeTeste.setGenero(genero);
        assertEquals(genero, filmeTeste.getGenero());
    }
    
    @Test
    void ano_e_valido() {
        String ano = "2021";
        filmeTeste.setAno(ano);
        assertEquals(ano, filmeTeste.getAno());
    }

    @Test
    void ano_corrige_formato_reduzido() {
        String ano = "21";
        filmeTeste.setAno(ano);
        assertEquals("2021", filmeTeste.getAno());

        ano = "65";
        filmeTeste.setAno(ano);
        assertEquals("1965", filmeTeste.getAno());
    }

}
