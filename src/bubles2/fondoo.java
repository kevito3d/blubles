/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubles2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kevin
 */
public  class fondoo extends JPanel {
    private boolean pulsado=false;
    private int referencia = 0;
    private JLabel letra;
    private String l="";
    private Color c[]= {Color.red,Color.green,Color.blue,Color.yellow,Color.magenta,Color.white,Color.orange};
    private ImageIcon[] partes = new ImageIcon[]{
        new ImageIcon(this.getClass().getResource("/imagenes/parte0.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte1.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte2.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte3.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte4.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte5.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte6.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte7.png")),
        new ImageIcon(this.getClass().getResource("/imagenes/parte8.png"))};

    public fondoo() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setSize(100, 100);
    }
    public void reiniciarValues(){
        pulsado=false;
        referencia=0;
        run();
    }

    public final void instanciarLetra(char c) {
        //int index = (int) (Math.random()* this.c.length-1);
        letra = new JLabel(c+""); 
        letra.setFont(new Font("comic kings", 0, 100));
        //letra.setForeground(this.c[index]);
        letra.setForeground(Color.BLACK);
        letra.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        letra.setVerticalAlignment((int) CENTER_ALIGNMENT);
        add(letra);
    }
    public void setLetra(String x){
        letra.setText(x);
         int index = (int) (Math.random()* this.c.length-1);
         letra.setForeground(this.c[index]);
    }
    public void reiniciarPanel(){
        run();
    }
    
    public JLabel getLetra() {
        return letra;
    }
    public void setPulsado(){
        referencia=0;
        pulsado=true;
    }
    public void run(){
        new Thread(){
            public void run(){
                while(!pulsado&&referencia<9){
                    
                    pausa(500);
                    if(referencia==partes.length-1){
                        panel_juego.b.setReferencia(-2);
                        setLetra("");
                        setPulsado();
                        repaint();
                        break;
                    }   
                    setReferencia(1);
                }
                
            }
        }.start();
    };
    
    public void pausa(int x){
        try {
            Thread.sleep(x);
        } catch (Exception e) {
        }
    }
    
    public void setReferencia(int x) {
        
        if(!pulsado){
            referencia += x;
            repaint();
        }
        
    }

    public int getReferencia() {
        return referencia;
    }

    @Override
    public void paint(Graphics g) {

        g.drawImage(partes[referencia].getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        setOpaque(false);
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

    }
}
