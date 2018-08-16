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
}
