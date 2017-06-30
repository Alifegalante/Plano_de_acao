package alifeg.model.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Peterson
 */
@Entity (name = "tarefa")
public class Tarefa {

    public Tarefa() {
        this.setInicioPrevisto(new Date());
        this.setInicio(new Date());
    }
    
    
    @Column(name = "codigo")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @Transient
    public static final String PROP_CODIGO = "codigo";

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        int oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }
    
    @Column(name = "titulo")
    private String titulo;
    @Transient
    public static final String PROP_TITULO = "titulo";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        propertyChangeSupport.firePropertyChange(PROP_TITULO, oldTitulo, titulo);
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
    @Column(name = "incioPrevisto")
    @Temporal(TemporalType.DATE)
    private Date inicioPrevisto;
    @Transient
    public static final String PROP_INICIOPREVISTO = "inicioPrevisto";

    public Date getInicioPrevisto() {
        return inicioPrevisto;
    }

    public void setInicioPrevisto(Date inicioPrevisto) {
        Date oldInicioPrevisto = this.inicioPrevisto;
        this.inicioPrevisto = inicioPrevisto;
        propertyChangeSupport.firePropertyChange(PROP_INICIOPREVISTO, oldInicioPrevisto, inicioPrevisto);
    }
    @Column(name = "fimPrevisto")
    @Temporal(TemporalType.DATE)
    private Date fimPrevisto;
    @Transient
    public static final String PROP_FIMPREVISTO = "fimPrevisto";

    public Date getFimPrevisto() {
        return fimPrevisto;
    }

    public void setFimPrevisto(Date fimPrevisto) {
        Date oldFimPrevisto = this.fimPrevisto;
        this.fimPrevisto = fimPrevisto;
        propertyChangeSupport.firePropertyChange(PROP_FIMPREVISTO, oldFimPrevisto, fimPrevisto);
    }

    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Transient
    public static final String PROP_INICIO = "inicio";

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        Date oldInicio = this.inicio;
        this.inicio = inicio;
        propertyChangeSupport.firePropertyChange(PROP_INICIO, oldInicio, inicio);
    }
    
    @Column(name = "fim")
    @Temporal(TemporalType.DATE)
    private Date fim;
    @Transient
    public static final String PROP_FIM = "fim";

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        Date oldFim = this.fim;
        this.fim = fim;
        propertyChangeSupport.firePropertyChange(PROP_FIM, oldFim, fim);
    }

    @Column(name = "fimRenegociado")
    @Temporal(TemporalType.DATE)
    private Date fimRenegociado;
    @Transient
    public static final String PROP_FIMRENEGOCIADO = "fimRenegociado";

    public Date getFimRenegociado() {
        return fimRenegociado;
    }

    public void setFimRenegociado(Date fimRenegociado) {
        Date oldFimRenegociado = this.fimRenegociado;
        this.fimRenegociado = fimRenegociado;
        propertyChangeSupport.firePropertyChange(PROP_FIMRENEGOCIADO, oldFimRenegociado, fimRenegociado);
    }

    @Column(name = "observacao")
    private String observacao;
    @Transient
    public static final String PROP_OBSERVACAO = "observacao";

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        propertyChangeSupport.firePropertyChange(PROP_OBSERVACAO, oldObservacao, observacao);
    }

    @Column(name = "indice")
    private Float indice;
    @Transient
    public static final String PROP_INDICE = "indice";

    public Float getIndice() {
        return indice;
    }

    public void setIndice(Float indice) {
        Float oldIndice = this.indice;
        this.indice = indice;
        propertyChangeSupport.firePropertyChange(PROP_INDICE, oldIndice, indice);
    }

    @OneToMany(targetEntity = Acao.class,
            mappedBy = "tarefa_id",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @Transient
    private List<Acao> acoes;
    
    
    
    @Transient
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

    
}
