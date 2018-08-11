/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Neto
 */
public class UsuarioValidatorTest {
    
    public UsuarioValidatorTest() {
    }
    
    @Test(expected = Exception.class)
    public void nomeMenorQue5() throws Exception {
        UsuarioDAO mockUsuarioDAO = mock(UsuarioDAO.class);
        UsuarioValidator usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
        Usuario u = new Usuario();
        u.setNome("nome");
        usuarioValidator.ehUsuarioValido(u);
    }
    
    @Test(expected = Exception.class)
    public void senhasDiferentes() throws Exception {
        UsuarioDAO mockUsuarioDAO = mock(UsuarioDAO.class);
        UsuarioValidator usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
        Usuario u = new Usuario();
        u.setNome("valido");
        u.setSenha("senha");
        u.setSenhaConfirmada("diferente");
        usuarioValidator.ehUsuarioValido(u);
    }
    
    @Test(expected = Exception.class)
    public void senhaInvalida() throws Exception {
        UsuarioDAO mockUsuarioDAO = mock(UsuarioDAO.class);
        UsuarioValidator usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
        Usuario u = new Usuario();
        u.setNome("valido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        
        SenhaValidator mockSenhaValidator = mock(SenhaValidator.class);
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(true);
        usuarioValidator.ehUsuarioValido(u);
    }
    
    @Test
    public void nomeCaractereEspecial() throws Exception{
        UsuarioDAO mockUsuarioDAO = mock(UsuarioDAO.class);
        UsuarioValidator usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
        Usuario u = new Usuario();
        u.setNome("val#####ido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        
        SenhaValidator mockSenhaValidator = mock(SenhaValidator.class);
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        usuarioValidator.ehUsuarioValido(u);
        assertFalse(usuarioValidator.ehUsuarioValido(u));
   }
    
   @Test
    public void nomeComNumero() throws Exception{
        UsuarioDAO mockUsuarioDAO = mock(UsuarioDAO.class);
        UsuarioValidator usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
        Usuario u = new Usuario();
        u.setNome("val3ido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        
        SenhaValidator mockSenhaValidator = mock(SenhaValidator.class);
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        usuarioValidator.ehUsuarioValido(u);
        assertTrue(usuarioValidator.ehUsuarioValido(u));
   }
    
   @Test
   public void usuarioValido() throws Exception{
        UsuarioDAO mockUsuarioDAO = mock(UsuarioDAO.class);
        UsuarioValidator usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
        Usuario u = new Usuario();
        u.setNome("valido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        
        SenhaValidator mockSenhaValidator = mock(SenhaValidator.class);
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        usuarioValidator.ehUsuarioValido(u);
        assertTrue(usuarioValidator.ehUsuarioValido(u));
   }
   
   @Test(expected = Exception.class)
   public void usuarioExistente() throws Exception{
       UsuarioDAO mockUsuarioDAO = mock(UsuarioDAO.class);
        UsuarioValidator usuarioValidator = new UsuarioValidator(mockUsuarioDAO);
        Usuario u = new Usuario();
        u.setNome("valido");
        u.setSenha("abc");
        u.setSenhaConfirmada("abc");
        
        SenhaValidator mockSenhaValidator = mock(SenhaValidator.class);
        usuarioValidator.setSenhaValidator(mockSenhaValidator);
        
        when(mockSenhaValidator.verificar("abc")).thenReturn(false);
        when(mockUsuarioDAO.getByName(u.getNome())).thenReturn(u);
        usuarioValidator.ehUsuarioValido(u);
   }
}
