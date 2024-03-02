package atividadepratica01p2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgressBarDemo extends JFrame {
    private JProgressBar progressBar;
    private JTextField textField;
    private JButton startButton;
    private Thread progressThread;
    private boolean running = false;

    public ProgressBarDemo() {
        setTitle("Progress Bar Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        progressBar = new JProgressBar(0, 100);
        textField = new JTextField(10);
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    startProgress();
                } else {
                    stopProgress();
                }
            }
        });

        add(progressBar);
        add(textField);
        add(startButton);

        setVisible(true);
    }

    private void startProgress() {
        running = true;
        startButton.setText("Stop");
        progressThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 100 && running; i++) {
                    try {
                        Thread.sleep(100); // Delay para simular uma operação demorada
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    final int progressValue = i;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            progressBar.setValue(progressValue);
                            textField.setText(progressValue + "%");
                        }
                    });
                }
                running = false;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        startButton.setText("Start");
                    }
                });
            }
        });
        progressThread.start();
    }

    private void stopProgress() {
        running = false;
        startButton.setText("Start");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProgressBarDemo();
            }
        });
    }
}
