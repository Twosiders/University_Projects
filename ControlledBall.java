import javax.swing.*;
import java.awt.*;;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexander on 03/08/2015.
 */
public class ControlledBall extends JPanel {
    int x = 200, y = 250;
    int width = 50, height = 50;
    int dx = 1, dy = 1;
    private volatile boolean isRunning = true;

    java.util.Timer move;
    static JFrame frame;

    JPanel pane = new JPanel();
    JButton jbtGo = new JButton("GO");
    JButton jbtStop = new JButton("STOP");

    ControlledBall(){
        frame = new JFrame("Bouncing Ball");
        frame.setLayout(new BorderLayout(0, 0));
        frame.setSize(400, 400);
        frame.setVisible(true);

        frame.add(pane, BorderLayout.SOUTH);
        pane.setBorder(BorderFactory.createLineBorder(Color.cyan));
        pane.setSize(200, 200);

        pane.add(jbtGo);
        pane.add(jbtStop);
        setForeground(Color.red);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbtGo.addActionListener(new goListener());
        jbtStop.addActionListener(new stopListener());
    }
    public void move() {
        if (isRunning) {
            move.cancel();
            move = new java.util.Timer();
            move.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (x < 0) dx = 1;
                    if (x >= getWidth() - 45) dx = -1;
                    if (y < 0) dy = 1;
                    if (y > getHeight() - 45) dy = -1;
                    x += dx;
                    y += dy;
                    repaint();
                }
            }, 0, 5);
        } else {
            move.cancel();
        }
    }
    public void start() {
        move = new java.util.Timer();
        move.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (x < 0) dx = 1;
                if (x >= getWidth() - 45) dx = -1;
                if (y < 0) dy = 1;
                if (y > getHeight() - 45) dy = -1;
                x += dx;
                y += dy;
                repaint();
            }
        }, 0, 5);
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, width, height);
    }
    class stopListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            stopBall();
            move();
        }
    }
    class goListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            goBall();
            move();
        }
    }
    public void stopBall() {
        isRunning = false;
    }
    public void goBall() {
        isRunning = true;
    }
    public static void main(String[] args) {
        ControlledBall ball = new ControlledBall();
        frame.add(ball);
        ball.start();
    }
}

