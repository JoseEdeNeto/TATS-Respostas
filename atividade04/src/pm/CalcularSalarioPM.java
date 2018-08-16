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
        if(salariobase <= 0f)
            msgErro = "Salario Vazio\n";
    }
    
}
