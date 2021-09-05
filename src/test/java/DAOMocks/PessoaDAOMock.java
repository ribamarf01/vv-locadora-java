package DAOMocks;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mycompany.projetolocadora.dao.PessoaDAO;
import com.mycompany.projetolocadora.model.Pessoa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaDAOMock {

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
    private Pessoa p;

    @BeforeAll
    public void setUp() throws Exception {
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

        p = genericPessoa();

        Mockito.when(rs.first()).thenReturn(true);
        
        Mockito.when(rs.getLong(1)).thenReturn(p.getId());
        Mockito.when(rs.getString(2)).thenReturn(p.getNomeCompleto());
        Mockito.when(rs.getString(3)).thenReturn(p.getCpf());
        Mockito.when(rs.getString(4)).thenReturn(p.getTelefone());
        Mockito.when(rs.getString(5)).thenReturn(p.getSexo());
        Mockito.when(rs.getString(6)).thenReturn(p.getDataNascimento());
        Mockito.when(rs.getString(7)).thenReturn(p.getEndereco());
        Mockito.when(rs.getString(8)).thenReturn(p.getEmail());

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
    public void tentarAdicionar() throws Exception{
        PessoaDAO dao = new PessoaDAO(ds);
        dao.adicionarPessoa(p);
        Mockito.verify(insert, Mockito.atLeastOnce()).execute();
    }

    @Test
    public void solicitarPorId() throws Exception {
        PessoaDAO dao = new PessoaDAO(ds);
        Pessoa person = dao.buscarPeloId(1);

        Mockito.verify(select, Mockito.atLeastOnce()).executeQuery();
    //    assertEquals(p, person);
    }

    @Test
    public void solicitarInexistente() throws Exception {
        PessoaDAO dao = new PessoaDAO(ds);
        Pessoa person = dao.buscarPeloId(2);
        Mockito.verify(select, Mockito.atLeastOnce()).executeQuery();
        assertNull(person);
    }

    @Test
    public void atualizarPessoa() throws Exception {
        PessoaDAO dao = new PessoaDAO(ds);
        dao.atualizarPessoa(p);
        Mockito.verify(update, Mockito.times(1)).execute();
    }

    @Test
    public void excluirPessoa() throws Exception {
        PessoaDAO dao = new PessoaDAO(ds);
        dao.excluirPessoa(p);
        Mockito.verify(delete, Mockito.times(1)).execute();
    }

    public Pessoa genericPessoa() {
        Pessoa p = new Pessoa();
        p.setId(1);
        p.setNomeCompleto("João Pessoa");
        p.setTelefone("85123456789");
        p.setCpf("12345678900");
        p.setSexo("M");
        p.setDataNascimento("02052001");
        p.setEndereco("Rua A");
        p.setEmail("joao@email.com");
        return p;
    }
}