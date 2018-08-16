/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd01;

/**
 *
 * @author Aluno
 */
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
