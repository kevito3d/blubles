/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubles2;

// import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author kevin
 */
public class vistaJuegoFrame extends JFrame{
    private panel_juego panel;
    public vistaJuegoFrame(){
        panel=new panel_juego();
        //this.setUndecorated(true);
        this.setVisible(true);
        this.setSize(600,700);
        //this.setOpacity(0.9f);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
        panel.requestFocusInWindow();
        
    }
    
}
