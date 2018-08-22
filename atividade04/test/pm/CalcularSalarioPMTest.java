package pm;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalcularSalarioPMTest {
    
    public CalcularSalarioPMTest() {
    }

    @Test
    public void testeDesenvolvedor5000() {
        CalcularSalarioPM pm = new CalcularSalarioPM();
        pm.setNome("Joao");
        pm.setEmail("joao@bol.com.br");
        pm.setSalarioBase(5000f);
        pm.setCargo("DESENVOLVEDOR");
        float salarioLiquido = pm.pressionarBotaoCalcular();
        assertEquals(4000f, salarioLiquido, 0.01);
    }
    
    @Test
    public void testeCargoInvalido(){
        CalcularSalarioPM pm = new CalcularSalarioPM();
        pm.setNome("Joao");
        pm.setEmail("joao@bol.com.br");
        pm.setSalarioBase(5000f);
        pm.setCargo("ARQUITETO");
        float salarioLiquido = pm.pressionarBotaoCalcular();
        assertEquals("Cargo Invalido\n", pm.getMsgErro());
    }
    
    @Test
    public void testeCamposVazios(){
        CalcularSalarioPM pm = new CalcularSalarioPM();
        pm.setNome("");
        pm.setEmail("");
        pm.setSalarioBase(0f);
        pm.setCargo("");
        float salarioLiquido = pm.pressionarBotaoCalcular();
        assertEquals("Nome Vazio\n" + "Email Vazio\n" + "Cargo Vazio\n" + "Salario Vazio\n", pm.getMsgErro());
    }
}
