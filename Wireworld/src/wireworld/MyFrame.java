package wireworld;

import wireworld.Wireworld;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

    public MyFrame() {
        super("Rysowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 50);
        setSize(700, 700);
        JPanel panel = new MyPanel();
        add(panel);
        pack();
        setVisible(true);
    }

    class MyPanel extends JPanel {

        public MyPanel() {
            setPreferredSize(new Dimension(700, 700));

        }

        @Override
        @SuppressWarnings("empty-statement")
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int piks = 40;
            //int[] plansza = {0, 1, 2, 3, 3, 2, 1, 0, 0, 1, 2, 3, 3, 2};
            for (int i = 0; i < Wireworld.wys; i++) {
                for (int j=0; j<Wireworld.szer; j++){

               if (Wireworld.plansza[i][j] == 0) {
                    g.setColor(Color.black);
                } else if (Wireworld.plansza[i][j] == 1) {
                    g.setColor(Color.red);
                } else if (Wireworld.plansza[i][j] == 2) {
                    g.setColor(Color.yellow);
                } else if (Wireworld.plansza[i][j] == 3) {
                    g.setColor(Color.white);
                }
                g2d.fillRect((j + 1) * piks, (i+1)*piks, piks, piks);
               repaint();
            }}
        }
    }
}