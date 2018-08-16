package pm;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalcularSalarioPMTest {
    
    public CalcularSalarioPMTest() {
    }

    @Test
    public void testeDesenvolvedor5000() {
        CalcularSalarioPM pm = new CalcularSalarioPM();
        pm.setNome();
        pm.setEmail();
        pm.setSalarioBase();
        pm.setCargo();
        float salarioLiquido = pm.pressionarBotaoCalcular();
        assertEquals(salarioLiquido, 4000f, 0.01);
    }
}
