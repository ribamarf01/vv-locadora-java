import com.mycompany.projetolocadora.model.Aluguel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class Aluguel_Tests {

    private Aluguel aluguelTest;

    Aluguel genericAluguel() {
        Aluguel a = new Aluguel();

        a.setIdPessoa(1);
        a.setIdFilme(1);
        a.setDataAluguel(LocalDate.now());
        a.setEstaPago(false);

        return a;
    }

    @BeforeEach
    void setUp() {
        aluguelTest = new Aluguel();
    }

    @AfterEach
    void tearDown() {
        aluguelTest = null;
    }

    @Test
    void data_aluguel_pega_o_dia_atual_corretamente() {
        assertEquals(aluguelTest.getDataAluguel(), LocalDate.now());
    }

    @Test
    void valor_aluguel_calcula_double() {
        Aluguel a = genericAluguel();
        a.setValorAluguel(1.10);
        assertEquals(1.10, a.getValorAluguel());
    }

    @Test
    void valor_multa_calcula_double() {
        Aluguel a = genericAluguel();
        a.setValorMulta(1.1);
        assertEquals(1.1, a.getValorMulta());
    }

}
