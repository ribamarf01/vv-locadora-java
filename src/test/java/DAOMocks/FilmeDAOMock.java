package DAOMocks;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mycompany.projetolocadora.dao.FilmeDAO;
import com.mycompany.projetolocadora.model.Filme;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FilmeDAOMock {

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
    private Filme f;

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
        
        f = new Filme();
        
        f.setId(1);
        f.setTitulo("A volta dos que nunca foram");
        f.setDescricao("A muito tempo atrás mas não muito distante, houve um rei que pasmem, reinava, então um dia ele decidiu invadir outro reino com seu exército, que não foi, e teve de inventar história sobre a volta dos que não foram.");
        f.setGenero("Comédia");
        f.setAno("1999");
        f.setDuracao("120");
        f.setDiretor("Steven Universo");
        f.setEstudio("Paramount");

        Mockito.when(rs.first()).thenReturn(true);

        Mockito.when(rs.getLong(1)).thenReturn(f.getId());
        Mockito.when(rs.getString(2)).thenReturn(f.getTitulo());
        Mockito.when(rs.getString(3)).thenReturn(f.getDescricao());
        Mockito.when(rs.getString(4)).thenReturn(f.getGenero());
        Mockito.when(rs.getString(5)).thenReturn(f.getAno());
        Mockito.when(rs.getString(6)).thenReturn(f.getDuracao());
        Mockito.when(rs.getString(7)).thenReturn(f.getDiretor());
        Mockito.when(rs.getString(8)).thenReturn(f.getEstudio());

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
        FilmeDAO dao = new FilmeDAO(ds);
        dao.adicionarFilme(f);
        Mockito.verify(insert, Mockito.atLeastOnce()).execute();
    }

    @Test
    public void solicitarPorId() throws Exception {
        FilmeDAO dao = new FilmeDAO(ds);
        dao.adicionarFilme(f);
        Filme filme = dao.buscarPeloId(1);
        Mockito.verify(select, Mockito.atLeastOnce()).executeQuery();
        //assertEquals(f, filme);
    }

    @Test
    public void solicitarInexistente() throws Exception {
        FilmeDAO dao = new FilmeDAO(ds);
        Filme filme = dao.buscarPeloId(2);
        Mockito.verify(select, Mockito.atLeastOnce()).executeQuery();
        assertNull(filme);
    }

    @Test
    public void atualizarFilme() throws Exception {
        FilmeDAO dao = new FilmeDAO(ds);
        dao.atualizarFilme(f.getId(), f);
        Mockito.verify(update, Mockito.atLeastOnce()).execute();
    }

    @Test
    public void excluir() throws Exception {
        FilmeDAO dao = new FilmeDAO(ds);
        dao.excluirFilme(f.getId());
        Mockito.verify(delete, Mockito.atLeastOnce()).execute();
    }

    public Filme genericFilme() {
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
    
}
