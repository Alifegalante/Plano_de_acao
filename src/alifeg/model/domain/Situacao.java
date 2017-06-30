package alifeg.model.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Peterson
 */
public class Situacao {
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldString = this.descricao;
        this.descricao = descricao;
        pcs.firePropertyChange("descricao", oldString, "descricao");
    }
    
    private transient final PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        pcs.addPropertyChangeListener( listener );
    }

    public void removePropertyChangeListener(PropertyChangeListener listener )
    {
        pcs.removePropertyChangeListener( listener );
    }

}
