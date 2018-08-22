package pm;

import calculadora.Calculadora;
import calculadora.Funcionario;

public class CalcularSalarioPM {
    
    String nome, 
            email,
            cargo;
    float salariobase;
    String msgErro;
    
    public float pressionarBotaoCalcular(){
        validarCampos();
        Funcionario f = new Funcionario(nome.toUpperCase(), email.toUpperCase(), cargo.toUpperCase(), salariobase);
        Calculadora c = new Calculadora();
        float salarioLiquido = c.calcular(f.getSalarioBase(), f.getCargo());
        
        return salarioLiquido; 
    }

    private void validarCampos() {
        msgErro = "";
        if(nome.equals(""))
            msgErro += "Nome Vazio\n";
        if(email.equals(""))
            msgErro += "Email Vazio\n";
        if(cargo.equals(""))
            msgErro += "Cargo Vazio\n";
        else if(!cargo.equalsIgnoreCase("DESENVOLVEDOR") || 
                !cargo.equalsIgnoreCase("DBA") ||
                !cargo.equalsIgnoreCase("TESTADOR") ||
                !cargo.equalsIgnoreCase("GERENTE"))
            msgErro += "Cargo Invalido\n";
        
        if(salariobase <= 0f)
            msgErro += "Salario Vazio\n";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalarioBase() {
        return salariobase;
    }

    public void setSalarioBase(float salariobase) {
        this.salariobase = salariobase;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }
    
}
