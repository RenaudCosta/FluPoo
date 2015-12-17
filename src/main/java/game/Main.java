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
    private int contagionType;

    private static final long ZZZ = 3000; // default sleep time in msecs
    private long zeroTime = 0;  // time of application launch

    public Main(){
        super("Virus Simulator");
        JPanel mainPanel = new JPanel();

        GridLayout experimentLayout = new GridLayout(7,1);
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

        JPanel contagionPanel = new JPanel();
        JLabel labelcontagion = new JLabel("Contagion neighbour type");
        //this.contagion = new JTextField("10");

        Integer[] contagion = new Integer[2];
        contagion[0] = 4;
        contagion[1] = 8;
        JComboBox contagionBox = new JComboBox(contagion);
        contagionBox.setSelectedIndex(0);
        contagionBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contagionBox.getSelectedIndex() == 0)
                    contagionType = 4;
                else
                    contagionType = 8;
            }
        });

        contagionPanel.add(labelcontagion);
        contagionPanel.add(contagionBox);

        JPanel speedPanel = new JPanel();
        JLabel labelSpeed = new JLabel("Speed of the simulation (milliseconds per day)");
        this.speed = new JTextField("10");

        speedPanel.add(labelSpeed);
        speedPanel.add(this.speed);

        JPanel launchPanel = new JPanel();
        this.launchButton = new JButton("Start Simulation");
        this.launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulator simulator = new Simulator(100, 100, Integer.parseInt(propHumans.getText()),
                                                              Integer.parseInt(propDucks.getText()),
                                                              Integer.parseInt(propChickens.getText()),
                                                              Integer.parseInt(propPigs.getText()),
                                                              contagionType,
                                                              Integer.parseInt(speed.getText()));
                setVisible(false);
                dispose();
            }
        });

        launchPanel.add(launchButton);

        mainPanel.add(humanPanel);
        mainPanel.add(chickenPanel);
        mainPanel.add(pigPanel);
        mainPanel.add(ducksPanel);
        mainPanel.add(contagionPanel);
        mainPanel.add(speedPanel);
        mainPanel.add(launchPanel);

        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
