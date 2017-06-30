package alifeg.model.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author Peterson
 */
@Entity (name = "planodeacao")
public class PlanoDeAcao {
    
     @Column(name = "codigo")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Transient
    public static final String PROP_CODIGO = "codigo";

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }

    @Column(name = "tema")
    private String tema;
    @Transient
    public static final String PROP_TEMA = "tema";

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        String oldTema = this.tema;
        this.tema = tema;
        propertyChangeSupport.firePropertyChange(PROP_TEMA, oldTema, tema);
    }

    @Column(name = "descricao")
    private String descricao;
    @Transient
    public static final String PROP_DESCRICAO = "descricao";

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        propertyChangeSupport.firePropertyChange(PROP_DESCRICAO, oldDescricao, descricao);
    }

    @ManyToOne
    @JoinColumn(name = "acao_id")
    private Acao acao;
    @Transient
    public static final String PROP_ACAO = "acao";

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        Acao oldAcao = this.acao;
        this.acao = acao;
        propertyChangeSupport.firePropertyChange(PROP_ACAO, oldAcao, acao);
    }

    @Transient
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
