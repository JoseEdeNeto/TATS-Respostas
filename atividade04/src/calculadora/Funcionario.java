package calculadora;

public class Funcionario {
    
    private String nome, 
            email,
            cargo;
    private float salariobase;
    
    public Funcionario(String nome, String email, String cargo, float salario){
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.salariobase = salario;
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
    
}
