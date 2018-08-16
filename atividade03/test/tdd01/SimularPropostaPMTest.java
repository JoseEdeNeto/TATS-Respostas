package tdd01;

import pm.SimularPropostaPM;
import pm.MostrarPropostasPM;
import org.junit.Test;
import static org.junit.Assert.*;


public class SimularPropostaPMTest {

    public void tearDown() {
    }

     @Test
     public void testeTodosCamposVazios() {
         SimularPropostaPM pm = new SimularPropostaPM();
         pm.setNome("");
         pm.setSalario(0f);
         pm.setIdade(0);
         pm.setValorEmprestimo(0f);
         assertNull(pm.pressionarBotaoElaborar());
         assertEquals("Nome vazio\nSalario Vazio\nIdade Vazia\nValor de Empréstimo Vazio", pm.getMensagemErro());
     }
     
     @Test
     public void testeSomenteIdadeVazia(){
         SimularPropostaPM pm = new SimularPropostaPM();
         pm.setNome("Joao");
         pm.setSalario(300f);
         pm.setIdade(0);
         pm.setValorEmprestimo(500f);
         assertNull(pm.pressionarBotaoElaborar());
         assertEquals("Idade Vazia\n", pm.getMensagemErro());
     }
     
     @Test
     public void testeDadosCorretos(){
         SimularPropostaPM pm = new SimularPropostaPM();
         pm.setNome("Joao");
         pm.setSalario(800f);
         pm.setIdade(25);
         pm.setValorEmprestimo(1000f);
         MostrarPropostasPM mostrarPm = pm.pressionarBotaoElaborar();
         assertEquals("", pm.getMensagemErro());
         assertEquals(2, mostrarPm.getPropostas().size());
     }
     
     @Test
     public void testeSomenteIdadeInvalida(){
         SimularPropostaPM pm = new SimularPropostaPM();
         pm.setNome("Joao");
         pm.setSalario(300f);
         pm.setIdade(15);
         pm.setValorEmprestimo(500f);
         assertNull(pm.pressionarBotaoElaborar());
         assertEquals("Idade Invalida\n", pm.getMensagemErro());
     }
}
