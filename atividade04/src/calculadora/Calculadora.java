package calculadora;

public class Calculadora {

    public Calculadora() {
    }
    
    public float calcular(float salarioB, String cargo){
        float salarioL = 0f;
        switch (cargo){
            case "DESENVOLVEDOR":
                if(salarioB >= 3000f){
                    salarioL = salarioB * 0.8f;
                    break;
                } else {
                    salarioL = salarioB * 0.9f;
                    break;
                }
            case "DBA":
                if(salarioB >= 2000f){
                    salarioL = salarioB * 0.75f;
                    break;
                } else {
                    salarioL = salarioB * 0.85f;
                    break;
                }
            case "TESTADOR":
                if(salarioB >= 2000f){
                    salarioL = salarioB * 0.75f;
                    break;
                } else {
                    salarioL = salarioB * 0.85f;
                    break;
                }
            case "GERENTE":
                if(salarioB >= 5000f){
                    salarioL = salarioB * 0.7f;
                    break;
                } else {
                    salarioL = salarioB * 0.8f;
                    break;
                }
        }
        return salarioL;
    }
}
