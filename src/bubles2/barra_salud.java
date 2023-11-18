/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubles2;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public class barra_salud extends JPanel {
    private static int referencia = 16;
    private ImageIcon[] partes = new ImageIcon[]{new ImageIcon(this.getClass().getResource("/imagenes/bpart0.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart1.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart2.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart3.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart4.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart5.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart6.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart7.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart8.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart9.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart10.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart11.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart12.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart13.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart14.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart15.png")),
            new ImageIcon(this.getClass().getResource("/imagenes/bpart16.png"))};

    public barra_salud() {
        this.setLayout(null);
        
        run(500);
    }
    public void setReferencia(int referencia) { 
        int aux= this.referencia+referencia;
        if(aux>16)
            this.referencia=16;
        else if(aux<0)
            this.referencia=0;
        else
            this.referencia=aux;
        repaint();
        
    }

    public static int getReferencia() {
        return referencia;
    }
    public boolean getEstado(){
        return referencia>0;
    }

    public void run(int e) {
        new Thread() {
            @Override
            public void run() {
                do {
                    if(referencia<1){
                        break;
                    }
                    pausa(e);
                    setReferencia(-1);
                    
                } while (true);
                
            }
        }.start();
    }
    public void pausa(int x) {
        try {
            Thread.sleep(x);
        } catch (Exception e) {
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(partes[referencia].getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        setOpaque(false);
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

    }

}
