package bubles2;
import javax.swing.JLabel;
public class lista {
    private Nodo inicio;
    private Nodo fin;
    private int tamanio;
    
    public lista() {
        inicio = null;
        fin=null;
        tamanio = 0;
    }
    
    public boolean esVacia() {
        return inicio == null;
    }
    
    public int getTamanio() {
        return tamanio;
    }
    
    public boolean buscar(String c) {
        Nodo q = inicio;
        while (q != null) {
            if (q.getDato().getLetra().getText().equals(c.toUpperCase())) {
                return true;
            }
            q = q.getSiguiente();
        }
        return false;
    } 
    
    public fondoo eliminar_referencia(String c){
        Nodo q=inicio,j=q;
        c=c.toUpperCase();
        if(q.getDato().getLetra().getText().equals(c)){
            return removerInicio();
        }
        while(!(q.getDato().getLetra().getText().equals(c))){
            j=q;
            q=q.getSiguiente();
        }
        j.setSiguiente(q.getSiguiente());
        if(j.getSiguiente()!=null)
            j.getSiguiente().setAnterior(j);
        else
            fin=j;
        q.setSiguiente(null);
        tamanio--;
        return q.getDato();
    }
    
    public void agregarAlFinal(fondoo b) {
        Nodo nuevo = new Nodo();
        nuevo.setDato(b);
        if (esVacia()) {
            inicio = nuevo;
            fin=inicio;
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin=fin.getSiguiente();
        }
        
        tamanio++;
    }
    public fondoo removerInicio() {
        Nodo q=inicio;
        inicio=inicio.getSiguiente();
        if(inicio!=null){
            inicio.setAnterior(null);
        }else
            fin=inicio;
        tamanio--;
        return q.getDato();
    }
    
    public void eliminar() {
        inicio = null;
        tamanio = 0;
    }
    public Nodo getInicio(){
        return inicio;
    }


}
