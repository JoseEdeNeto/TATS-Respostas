package pm;

import java.util.List;
import tdd01.Proposta;

public class MostrarPropostasPM {
    
    List<Proposta> propostas;

    public MostrarPropostasPM(List<Proposta> propostas) {
        this.propostas = propostas;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }
    
}
