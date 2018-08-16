package pm;

import calculadora.Calculadora;

public class CalcularSalarioPM {
    
    String nome, 
            email,
            cargo;
    float salariobase;
    String msgErro;
    
    public float pressionarBotaoCalcular(){
        validarCampos();

        Calculadora c = new Calculadora();
        float salarioLiquido = c.calcular(salariobase, cargo);
        
        return salarioLiquido; 
    }

    private void validarCampos() {
        msgErro = "";
        if(nome.equals(""))
            msgErro = "Nome Vazio\n";
        if(email.equals(""))
            msgErro = "Email Vazio\n";
        if(cargo.equals(""))
            msgErro = "Cargo Vazio\n";
        else if(!cargo.equals("DESENVOLVEDOR") || 
                !cargo.equals("DBA") ||
                !cargo.equals("TESTADOR") ||
                !cargo.equals("GERENTE"))
            msgErro += "Cargo Invalido\n";
        
        if(salariobase <= 0f)
            msgErro = "Salario Vazio\n";
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
