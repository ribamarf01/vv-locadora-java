package DAOMocks;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.sql.DataSource;

import com.mycompany.projetolocadora.dao.AluguelDAO;
import com.mycompany.projetolocadora.model.Aluguel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AluguelDAOMock {
    
    @Mock
    private final DataSource ds = Mockito.mock(DataSource.class);

    @InjectMocks
    private final Connection con = Mockito.mock(Connection.class);

    @InjectMocks
    private final PreparedStatement insert = Mockito.mock(PreparedStatement.class);

    @InjectMocks
    private final PreparedStatement select = Mockito.mock(PreparedStatement.class);

    @InjectMocks
    private final PreparedStatement update = Mockito.mock(PreparedStatement.class);

    @InjectMocks
    private final PreparedStatement delete = Mockito.mock(PreparedStatement.class);

    @InjectMocks
    private final ResultSet rs = Mockito.mock(ResultSet.class);

    @InjectMocks
    private final ResultSet nullSet = Mockito.mock(ResultSet.class);

    private long id;
    private Aluguel a;

    @BeforeAll
    public void setUp() throws Exception {
        Mockito.when(ds.getConnection()).thenReturn(con);
        
        Mockito.when(ds.getConnection()).thenReturn(con);
        
        Mockito.when(con.prepareStatement(Mockito.startsWith("INSERT"))).thenReturn(insert);
        Mockito.when(con.prepareStatement(Mockito.startsWith("SELECT"))).thenReturn(select);
        Mockito.when(con.prepareStatement(Mockito.startsWith("UPDATE"))).thenReturn(update);
        Mockito.when(con.prepareStatement(Mockito.startsWith("DELETE"))).thenReturn(delete);

        Mockito.when(insert.execute()).thenReturn(true);
        Mockito.doNothing().when(insert).close();

        Mockito.when(update.execute()).thenReturn(true);
        Mockito.doNothing().when(update).close();

        Mockito.when(delete.execute()).thenReturn(true);
        Mockito.doNothing().when(delete).close();

        a = new Aluguel();
        a.setId(1);
        a.setIdPessoa(1);
        a.setIdFilme(1);
        a.setEstaPago(false);
        a.setDataAluguel(LocalDate.now());
        a.setDataDevolucao(LocalDate.now().plusDays(3));
        a.setValorAluguel(3.30);
        a.setValorMulta(0);
        a.setEstaPago(false);

        Mockito.when(rs.first()).thenReturn(true);

        Mockito.when(rs.getLong(1)).thenReturn(a.getId());
        Mockito.when(rs.getLong(2)).thenReturn(a.getIdPessoa());
        Mockito.when(rs.getLong(3)).thenReturn(a.getIdFilme());
        Mockito.when(rs.getDate(4)).thenReturn(Date.valueOf(a.getDataAluguel()));
        Mockito.when(rs.getDate(5)).thenReturn(Date.valueOf(a.getDataDevolucao()));
        Mockito.when(rs.getDouble(6)).thenReturn(a.getValorAluguel());
        Mockito.when(rs.getDouble(7)).thenReturn(a.getValorMulta());
        Mockito.when(rs.getBoolean(8)).thenReturn(a.isEstaPago());

        Mockito.when(nullSet.first()).thenReturn(false);

        Mockito.doAnswer(new Answer<Void>(){
            @Override
            public Void answer(InvocationOnMock inv) {
                id = (long) inv.getArguments()[1];
                return null;
            }
        }).when(select).setLong(Mockito.eq(1), Mockito.anyLong());
        
        Mockito.when(select.executeQuery()).thenAnswer(new Answer<ResultSet>() {
            @Override
            public ResultSet answer(InvocationOnMock inv) {
                return id == 1 ? rs : nullSet;
            }
        });
        
    }

    @Test
    public void tentaAdicionar() throws Exception {
        AluguelDAO dao = new AluguelDAO(ds);
        dao.adicionarAluguel(a);
        Mockito.verify(insert, Mockito.atLeastOnce()).execute();
    }

    @Test
    public void solicitarPorId() throws Exception {
        AluguelDAO dao = new AluguelDAO(ds);
        Aluguel aluguel = dao.buscarPorId(1);
        Mockito.verify(select, Mockito.atLeastOnce()).executeQuery();
        //assertEquals(f, filme);
    }

    @Test
    public void solicitarInexistente() throws Exception {
        AluguelDAO dao = new AluguelDAO(ds);
        Aluguel al = dao.buscarPorId(2);
        Mockito.verify(select, Mockito.atLeastOnce()).executeQuery();
        assertNull(al);
    }

    @Test
    public void atualizarFilme() throws Exception {
        AluguelDAO dao = new AluguelDAO(ds);
        dao.atualizarAluguel(a);
        Mockito.verify(update, Mockito.atLeastOnce()).execute();
    }

    // Teria um excluir aqui, mas como o excluir é uma mudança de valor na tabela, é o mesmo comando de atualizar

}
