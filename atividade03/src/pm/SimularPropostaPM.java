package pm;

import java.util.List;
import tdd01.Calculadora;
import tdd01.Proposta;

public class SimularPropostaPM {
    String nome;
    float salario;
    int idade;
    float valorEmprestimo;
    String msgDeErro;
    
    public MostrarPropostasPM pressionarBotaoElaborar(){
        validar();
        
        if(msgDeErro.equals("")){
            Calculadora c = new Calculadora();
            List<Proposta> propostas = c.calcular(salario, valorEmprestimo);
            return new MostrarPropostasPM(propostas);
        } else {
            return null;
        }
    }

    private void validar() {
        msgDeErro = "";
        if(nome.equals(""))
            msgDeErro += "Nome vazio\n";
                
        if(salario <= 0)
            msgDeErro += "Salario Vazio\n";
        
        if(idade <= 0)
            msgDeErro += "Idade Vazia\n";
        else if(idade < 18 || idade > 70)
            msgDeErro += "Idade Invalida\n";
        
        if(valorEmprestimo <= 0)
            msgDeErro += "Valor de Empréstimo Vazio";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(float valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public String getMensagemErro() {
        return msgDeErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.msgDeErro = mensagemErro;
    }
    
    
}
