package game;

import enu.State;
import gui.Simulator;
import living.Human;
import living.Living;
import living.Pig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    private JButton launchButton;
    private JTextField propHumans, propDucks, propPigs, propChickens, speed;

    private static final long ZZZ = 3000; // default sleep time in msecs
    private long zeroTime = 0;  // time of application launch

    public Main(){
        super("Virus Simulator");
        JPanel mainPanel = new JPanel();

        GridLayout experimentLayout = new GridLayout(6,1);
        mainPanel.setLayout(experimentLayout);

        JPanel humanPanel = new JPanel();
        JLabel labelHuman = new JLabel("Proportion of Humans");
        this.propHumans = new JTextField("10");

        humanPanel.add(labelHuman);
        humanPanel.add(this.propHumans);

        JPanel chickenPanel = new JPanel();
        JLabel labelChicken = new JLabel("Proportion of Chickens");
        this.propChickens = new JTextField("10");

        chickenPanel.add(labelChicken);
        chickenPanel.add(this.propChickens);

        JPanel pigPanel = new JPanel();
        JLabel labelPig = new JLabel("Proportion of Pig");
        this.propPigs = new JTextField("10");

        pigPanel.add(labelPig);
        pigPanel.add(this.propPigs);

        JPanel ducksPanel = new JPanel();
        JLabel labelDucks = new JLabel("Proportion of Ducks");
        this.propDucks = new JTextField("10");

        ducksPanel.add(labelDucks);
        ducksPanel.add(this.propDucks);

        JPanel speedPanel = new JPanel();
        JLabel labelSpeed = new JLabel("Speed of the simulation (milliseconds per day)");
        this.speed = new JTextField("10");

        speedPanel.add(labelSpeed);
        speedPanel.add(this.speed);

        JPanel launchPanel = new JPanel();
        this.launchButton = new JButton("Start Simulation");
        this.launchButton.addActionListener(new BoutonListener());

        launchPanel.add(launchButton);

        mainPanel.add(humanPanel);
        mainPanel.add(chickenPanel);
        mainPanel.add(pigPanel);
        mainPanel.add(ducksPanel);
        mainPanel.add(speedPanel);
        mainPanel.add(launchPanel);

        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            SwingWorker<Busy, Object> worker = new SwingWorker<Busy, Object>() {
                // overrides the worker's abstract method to return the background object
                @Override
                protected Busy doInBackground() throws Exception {
                    return Main.this.new Busy();
                }

            };
            // starts running the busy process
            worker.execute();
        }
    }

    private class Busy {
        /**
         * Default constructor.
         * Launches busy process.
         */
        private Busy() {
            Simulator simulator = new Simulator(100, 100);
            simulator.simulate();
            zeroTime = System.currentTimeMillis();
            run();
        }

        /**
         * Busy process.
         * Infinite loop which periodically displays stuff on the GUI.
         */
        public void run() {
            while (true) {
                try {
                    long elapsedTime = System.currentTimeMillis() - zeroTime;
                    Thread.sleep(ZZZ);
                } catch (InterruptedException ie) {
                    System.out.println("WTF??!!?");
                }
            }
        }
    }

    public static void main(String[] args) {
        //Simulator simulator = new Simulator(100, 100, 10, 10, 10, 10);
        //simulator.simulate();

        Main main = new Main();
    }
}
