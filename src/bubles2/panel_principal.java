
package bubles2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panel_principal extends JPanel{
    private ImageIcon fondo=new ImageIcon(getClass().getResource("/imagenes/imagen_main.png"));
    private JLabel recuadro;
    private  ImageIcon archivo0 = new ImageIcon(Bubles20.class.getClass().getResource("/imagenes/recuadro_inicial.jpg")); 	
    private  Image archivo_modificado0 = archivo0.getImage();
    private Icon icon_recuadro = new ImageIcon(archivo_modificado0);
    private  ImageIcon archivo = new ImageIcon(Bubles20.class.getClass().getResource("/imagenes/jugar_seleccion.png")); 	
    private  Image archivo_modificado = archivo.getImage();
    private Icon play_seleccion = new ImageIcon(archivo_modificado);
    private  ImageIcon archivo2 = new ImageIcon(Bubles20.class.getClass().getResource("/imagenes/ayuda_seleccion.png")); 	
    private  Image archivo_modificado2 = archivo2.getImage();
    private Icon ayuda_seleccion = new ImageIcon(archivo_modificado2);
    private  ImageIcon archivo3 = new ImageIcon(Bubles20.class.getClass().getResource("/imagenes/salir_seleccion.png")); 	
    private  Image archivo_modificado3 = archivo3.getImage();
    private Icon salir_seleccion = new ImageIcon(archivo_modificado3);
    private JButton btn_play,btn_ayuda,btn_salir;
    private int posx=80,posy=328;
    private JPanel laminaPrincipal;
    private JLabel [][]letras;
    public panel_principal() {
        this.setLayout(null);
        instanciar_recuadro_inicial();
        instanciarbtn_play();
        instanciarbtn_ayuda();
        instanciarbtn_salir();
        
        
        
    }
    public final void instanciar_recuadro_inicial(){
        recuadro=new JLabel();
        this.recuadro.setIcon(icon_recuadro);
        this.recuadro.setBounds(402, 54, 335, 225);
        this.recuadro.setBackground(Color.yellow);
        this.recuadro.setOpaque(false);
        this.add(recuadro);
    }
    public final void instanciarbtn_play(){
        this.btn_play=new JButton();
        this.btn_play.setBounds(posx, posy+4, 153, 40);
        this.btn_play.setContentAreaFilled(false);
        this.btn_play.setBorder(null);
        MouseListener e=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {}

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_play.setIcon(play_seleccion);
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_play.setIcon(null);
            }
        };
        this.btn_play.addMouseListener(e);
        this.add(btn_play);
        
    }
    public final void instanciarbtn_ayuda(){
        this.btn_ayuda=new JButton();
        this.btn_ayuda.setBounds(posx, posy+59, 385, 40);
        this.btn_ayuda.setContentAreaFilled(false);
        this.btn_ayuda.setBorder(null);
        MouseListener e=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {}

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_ayuda.setIcon(ayuda_seleccion);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_ayuda.setIcon(null);
            }
        };
        this.btn_ayuda.addMouseListener(e);
        this.add(btn_ayuda);
    }
    public final void instanciarbtn_salir(){
        this.btn_salir=new JButton();
        this.btn_salir.setBounds(posx, posy+113, 123, 40);
        this.btn_salir.setContentAreaFilled(false);
        this.btn_salir.setBorder(null);
        this.btn_salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MouseListener e=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {
                btn_salir.setIcon(salir_seleccion);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btn_salir.setIcon(null);
            }
        };
        this.btn_salir.addMouseListener(e);
        this.add(btn_salir);
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(fondo.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        setOpaque(false);
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

    }
}

