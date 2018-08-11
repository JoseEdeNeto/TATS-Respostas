import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Neto
 */
public class UsuarioValidatorTest {
    
    private UsuarioDAO mockUsuarioDAO;
    private UsuarioValidator usuarioValidator;
    private SenhaValidator mockSenhaValidator;
    private Usuario u;
    
    public UsuarioValidatorTest() {
    }
    
    @Before
    public void setUp() {
        u = new Usuario();
        mockUsuarioDAO = mock(UsuarioDAO.class);
        mockSenhaValidator = mock(SenhaValidator.class);
        usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
    }
    
    @Test(expected = Exception.class)
    public void nomeMenorQue5() throws Exception {
        u.setNome("nome");
        usuarioValidator.ehUsuarioValido(u);
    }
    
    @Test(expected = Exception.class)
    public void senhasDiferentes() throws Exception {
        u.setNome("valido");
        u.setSenha("senha");
        u.setSenhaConfirmada("diferente");
        usuarioValidator.ehUsuarioValido(u);
    }
    
    @Test(expected = Exception.class)
    public void senhaInvalida() throws Exception {
        u.setNome("valido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        when(mockSenhaValidator.verificar("abc")).thenReturn(true);
        usuarioValidator.ehUsuarioValido(u);
    }
    
    @Test
    public void nomeCaractereEspecial() throws Exception{
        u.setNome("val#####ido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        usuarioValidator.ehUsuarioValido(u);
        assertFalse(usuarioValidator.ehUsuarioValido(u));
   }
    
   @Test
    public void nomeComNumero() throws Exception{
        u.setNome("val3ido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        usuarioValidator.ehUsuarioValido(u);
        assertTrue(usuarioValidator.ehUsuarioValido(u));
   }
    
   @Test
   public void usuarioValido() throws Exception{
        u.setNome("valido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        when(mockUsuarioDAO.getByName(u.getNome())).thenReturn(null);
        usuarioValidator.ehUsuarioValido(u);
        assertTrue(usuarioValidator.ehUsuarioValido(u));
   }
   
   @Test(expected = Exception.class)
   public void usuarioExistente() throws Exception{
        u.setNome("valido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        when(mockUsuarioDAO.getByName(u.getNome())).thenReturn(u);
        usuarioValidator.ehUsuarioValido(u);
   }
}
