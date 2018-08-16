package tdd01;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {
    
    public CalculadoraTest() {
    }

    @Test
    public void testeLimite1000() {
        Calculadora c = new Calculadora();
        List<Proposta> propostas = c.calcular(500, 800f);
        assertEquals(2, propostas.size());
        Proposta p1 = propostas.get(0);
        Proposta p2 = propostas.get(1);
        
        assertEquals(1600, p1.getTotal(), 0.01);
        assertEquals(2, p1.getNumeroParcelas());
        assertEquals(800, p1.getValorParcela(), 0.01);
        
        assertEquals(1600, p2.getTotal(), 0.01);
        assertEquals(3, p2.getNumeroParcelas());
        assertEquals(533.33, p2.getValorParcela(), 0.01);
    }
    
    @Test
    public void testeLimite1001a5000() {
        Calculadora c = new Calculadora();
        List<Proposta> propostas = c.calcular(2000, 1800f);
        assertEquals(3, propostas.size());
        Proposta p1 = propostas.get(0);
        Proposta p2 = propostas.get(1);
        Proposta p3 = propostas.get(2);
        
        assertEquals(2340, p1.getTotal(), 0.01);
        assertEquals(2, p1.getNumeroParcelas());
        assertEquals(1170, p1.getValorParcela(), 0.01);
        
        assertEquals(2700, p2.getTotal(), 0.01);
        assertEquals(4, p2.getNumeroParcelas());
        assertEquals(675, p2.getValorParcela(), 0.01);
        
        assertEquals(2700, p3.getTotal(), 0.01);
        assertEquals(10, p3.getNumeroParcelas());
        assertEquals(270, p3.getValorParcela(), 0.01);
    }
    
    @Test
    public void testeAcimade5000() {
        Calculadora c = new Calculadora();
        List<Proposta> propostas = c.calcular(10000, 5500f);
        assertEquals(4, propostas.size());
        Proposta p1 = propostas.get(0);
        Proposta p2 = propostas.get(1);
        Proposta p3 = propostas.get(2);
        Proposta p4 = propostas.get(3);
        
        assertEquals(6050, p1.getTotal(), 0.01);
        assertEquals(2, p1.getNumeroParcelas());
        assertEquals(3025, p1.getValorParcela(), 0.01);
        
        assertEquals(7150, p2.getTotal(), 0.01);
        assertEquals(4, p2.getNumeroParcelas());
        assertEquals(1787.50f, p2.getValorParcela(), 0.01);
        
        assertEquals(7150, p3.getTotal(), 0.01);
        assertEquals(10, p3.getNumeroParcelas());
        assertEquals(715, p3.getValorParcela(), 0.01);
        
        assertEquals(7700, p4.getTotal(), 0.01);
        assertEquals(20, p4.getNumeroParcelas());
        assertEquals(385, p4.getValorParcela(), 0.01);
    }
    
}
