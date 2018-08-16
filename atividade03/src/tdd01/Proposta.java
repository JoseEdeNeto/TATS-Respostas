package tdd01;

public class Proposta {
    
    float total;
    int numeroParcelas;
    float valorParcela;
    
    public Proposta(){}

    public Proposta(float pTotal, int pNumeroParcelas) {
        this.total = pTotal;
        this.numeroParcelas = pNumeroParcelas;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public float getValorParcela() {
        return this.total/this.numeroParcelas;
       
    }
    
}
