package alifeg.model.dao;

import alifeg.model.domain.Situacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peterson
 */
public class DaoSituacao {
    
    public final int PLANEJADA = 0;
    public final int ATRASADA = 1;
    public final int REPROGRAMADA = 2;
    public final int CONCLUIDA = 3;
    
    public List<String> getSituacoes() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Planejada");
        lista.add("Atrasada");
        lista.add("Reprogramada");
        lista.add("Concluída");
        return lista;
    }
    
    public Situacao getSituacao(int index) {
        Situacao sit = new Situacao();
        sit.setDescricao(this.getSituacoes().get(index));
        return sit;
    }
    public List <Situacao> getLista() {
        List<Situacao> lista = new ArrayList<Situacao>();
        for (int i = 0; i < this.getSituacoes().size(); i++) {
            lista.add(this.getSituacao(i));
        }
        return lista;
    }
}
