package bubles2;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Nodo {
    private fondoo dato;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo() {
        siguiente = null;
        anterior=null;
    }

    public fondoo getDato() {
        return dato;
    }

    public void setDato(fondoo dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
    
}
