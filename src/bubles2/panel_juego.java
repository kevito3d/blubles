/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubles2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author kevin
 */

public class panel_juego extends JPanel implements KeyListener {

    private lista l;
    //private ImageIcon parte0 = new ImageIcon(getClass().getResource("/imagenes/fondooo.png"));
    /*private static ImageIcon archivo = new ImageIcon(Bubles20.class.getClass().getResource("/imagenes/nombre.png")); 					//guardamos la imagen en un objeto ImageIcon
    private static Image archivo_modificado = archivo.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);// modificamos el archivo y
    private static Icon n = new ImageIcon(archivo_modificado);*/
    public static barra_salud b;
    private JPanel superior;
    private JPanel lamina;
    private JPanel[][] grilla;
    private fondoo f[][];
    private boolean[][] save = new boolean[3][3];
    Random r = new Random();

    public panel_juego() {
        this.setOpaque(true);
        this.setLayout(new BorderLayout());
        save = inicializarSave(save);
        instanciarLamina();
        instanciarPanelSuperior();
        addKeyListener(this);
        l = new lista();
        run();
    }

    public final void instanciarPanelSuperior() {
        JPanel top = new JPanel(new GridLayout(2, 2));
        top.setPreferredSize(new Dimension(300, 100));
        top.setOpaque(true);
        top.setBackground(Color.black);
        JLabel lb_score = new JLabel("Scrore");
        lb_score.setFont(new Font("comic kings", 0, 30));
        lb_score.setOpaque(false);
        lb_score.setForeground(Color.red);
        lb_score.setBackground(Color.magenta);
        lb_score.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lb_score.setVerticalAlignment((int) CENTER_ALIGNMENT);
        JLabel score = new JLabel("6332");
        score.setFont(new Font("comic kings", 0, 40));
        score.setOpaque(false);
        score.setForeground(Color.yellow);
        score.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        score.setVerticalAlignment((int) CENTER_ALIGNMENT);
        JPanel x = new JPanel();
        x.setLayout(new GridLayout());
        x.setOpaque(false);
        /*JLabel nombre=new JLabel(n);
        x.add(nombre);
        JLabel combo=new JLabel("combos");
        x.add(combo);*/
        b = new barra_salud();
        top.add(x);
        top.add(lb_score);
        top.add(b);
        top.add(score);

        add(top, BorderLayout.NORTH);
    }

    public final void instanciarLamina() {

        lamina = new JPanel();
        lamina.setOpaque(false);
        lamina.setLayout(new GridLayout(3, 3));
        f = new fondoo[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = new fondoo();
                f[i][j].setName("" + i + "" + j);
                lamina.add(f[i][j]);
            }
        }
        add(lamina);
    }

    public void pausa(int x) {
        try {
            Thread.sleep(x);
        } catch (Exception e) {
        }
    }

    public boolean[][] inicializarSave(boolean[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = new Boolean(false);

            }
        }
        return b;
    }

    public void generarFicha() {
        int i;
        int j;
        do {
            i = r.nextInt(3);//0,1,2
            j = r.nextInt(3);
        } while (save[i][j]);
        f[i][j].reiniciarValues();
        save[i][j] = true;
        f[i][j].instanciarLetra((char) (65 + r.nextInt(26)));
        f[i][j].updateUI();
        f[i][j].reiniciarPanel();
        save[i][j] = true;
        l.agregarAlFinal(f[i][j]);

    }

    public void run() {
        new Thread() {
            @Override
            public void run() {
                int delay = 1000;
                while (b.getEstado()) {
                    pausa(delay);
                    generarFicha();
                    repaint();
                }
            }
        }.start();
    }

    ;
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (l.buscar(ke.getKeyChar() + "")) {
            fondoo aux = l.eliminar_referencia(ke.getKeyChar() + "");
            //   aux.setReferencia(-aux.getReferencia());
            aux.setPulsado();
            int i = Integer.parseInt("" + aux.getName().charAt(0));
            int j = Integer.parseInt("" + aux.getName().charAt(1));
            save[i][j] = false;
            aux.setLetra("");
            aux.updateUI();
            b.setReferencia(2);

        } else {
            b.setReferencia(-2);
        }
    }

    @Override
    public void paint(Graphics g) {
        //g.drawImage(parte0.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        g.drawImage(null, 0, 0, this.getWidth(), this.getHeight(), this);
        setOpaque(false);
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

    }
}

