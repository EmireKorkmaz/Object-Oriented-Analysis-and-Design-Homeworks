package com.emire;

/**
 * @author Emire Korkmaz
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel mainPanel = new JPanel();
    private JPanel suitPanel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JPanel equipmentPanel = new JPanel();
    private JPanel resultPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JRadioButton decButton;
    private JRadioButton torButton;
    private JRadioButton oraButton;
    private JComboBox rocketCombo = new JComboBox();
    private JComboBox flameCombo = new JComboBox();
    private JComboBox autoCombo = new JComboBox();
    private JComboBox laserCombo = new JComboBox();
    private Integer[] numbers = new Integer[20];
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton calculateButton = new JButton("Calculate");
    private JLabel text1 = new JLabel("Select your suit type");
    private JLabel flamethrowerText = new JLabel("Number of flamethrower  ");
    private JLabel autorifleText = new JLabel("  Number of autorifle  ");
    private JLabel rocketlauncherText = new JLabel("  Number of rocketlauncher  ");
    private JLabel laserText = new JLabel("  Number of laser  ");
    private JLabel weightText = new JLabel();
    private JLabel costText = new JLabel();
    private int numofRocket = 1;
    private int numofFlame = 1;
    private int numofRifle = 1;
    private int numofLaser = 1;

    /**
     * Bu method GUI ile ilgili islemleri yerine getirir.
     */

    public GUI(){
        BoxLayout mainBox = new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
        BoxLayout textBox = new BoxLayout(textPanel,BoxLayout.X_AXIS);
        BoxLayout equipmentBox = new BoxLayout(equipmentPanel,BoxLayout.X_AXIS);
        BoxLayout buttonBox = new BoxLayout(buttonPanel,BoxLayout.X_AXIS);

        mainPanel.setLayout(mainBox);
        equipmentPanel.setLayout(equipmentBox);
        textPanel.setLayout(textBox);
        suitPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(buttonBox);
        resultPanel.setLayout(new GridLayout(1,2));

        mainPanel.add(textPanel);
        mainPanel.add(suitPanel);
        mainPanel.add(equipmentPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);

        text1.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Default",Font.BOLD,18);
        text1.setFont(font);
        textPanel.add(text1);

        decButton = new JRadioButton("Decsuit");
        oraButton = new JRadioButton("Orasuit");
        torButton = new JRadioButton("Torsuit");

        decButton.setBounds(100,50,100, 30);
        oraButton.setBounds(100,50,100,30);
        torButton.setBounds(100,50,100,30);

        buttonGroup.add(decButton);
        buttonGroup.add(oraButton);
        buttonGroup.add(torButton);

        suitPanel.add(decButton);
        suitPanel.add(oraButton);
        suitPanel.add(torButton);

        for (int i = 0; i < 20; i++){
            numbers[i] = i + 1;
        }
        for(int i = 0; i < numbers.length; i++) {
            flameCombo.addItem(numbers[i]);
            autoCombo.addItem(numbers[i]);
            rocketCombo.addItem(numbers[i]);
            laserCombo.addItem(numbers[i]);
        }

        equipmentPanel.add(flamethrowerText);
        equipmentPanel.add(flameCombo);
        equipmentPanel.add(autorifleText);
        equipmentPanel.add(autoCombo);
        equipmentPanel.add(rocketlauncherText);
        equipmentPanel.add(rocketCombo);
        equipmentPanel.add(laserText);
        equipmentPanel.add(laserCombo);

        calculateButton.setSize(30,40);
        buttonPanel.add(calculateButton);

        rocketCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numofRocket = (Integer)((JComboBox)e.getSource()).getSelectedItem();
            }
        });

        laserCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numofLaser = (Integer)((JComboBox)e.getSource()).getSelectedItem();
            }
        });

        autoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numofRifle = (Integer)((JComboBox)e.getSource()).getSelectedItem();
            }
        });

        flameCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numofFlame = (Integer)((JComboBox)e.getSource()).getSelectedItem();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double[] results;
                if(decButton.isSelected()){
                    Suits decSuit = new Decsuit();
                    results = calculateCostWeight(decSuit);
                    costText.setText("Total cost: " + results[0]);
                    costText.setHorizontalAlignment(SwingConstants.CENTER);
                    weightText.setText("Total weight: " + results[1]);
                    weightText.setHorizontalAlignment(SwingConstants.CENTER);
                    resultPanel.add(costText);
                    resultPanel.add(weightText);
                    mainPanel.updateUI();

                }
                else if(oraButton.isSelected()){
                    Suits oraSuit = new Orasuit();
                    results = calculateCostWeight(oraSuit);
                    costText.setText("Total cost: " + results[0]);
                    costText.setHorizontalAlignment(SwingConstants.CENTER);
                    weightText.setText("Total weight: " + results[1]);
                    weightText.setHorizontalAlignment(SwingConstants.CENTER);
                    resultPanel.add(costText);
                    resultPanel.add(weightText);
                    mainPanel.updateUI();
                }
                else if(torButton.isSelected()){
                    Suits torSuit = new Torsuit();
                    results = calculateCostWeight(torSuit);
                    costText.setText("Total cost: " + results[0]);
                    costText.setHorizontalAlignment(SwingConstants.CENTER);
                    weightText.setText("Total weight: " + results[1]);
                    weightText.setHorizontalAlignment(SwingConstants.CENTER);
                    resultPanel.add(costText);
                    resultPanel.add(weightText);
                    mainPanel.updateUI();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please choose one suit type.");
                    return;
                }
            }
        });
    }

    /**
     * Bu method giysinin maliyetini ve agirligini hesaplat
     * @param suit Giysi turu(Decsuit, Orasuit, Torsuit)
     * @return Giysinin maliyeti ve agirligini iceren double array
     */

    private Double[] calculateCostWeight(Suits suit){
        Double[] results = new Double[2];
        for (int i = 0; i < numofFlame; i++)
            suit = new FlameThrower(suit);
        for (int i = 0; i < numofRifle; i++)
            suit = new AutoRifle(suit);
        for (int i = 0; i < numofRocket; i++)
            suit = new RocketLauncher(suit);
        for(int i = 0; i < numofLaser; i++){
            suit = new Laser(suit);
        }
        results[0] = suit.cost();
        results[1] = suit.weight();

        return results;
    }

    /**
     * Bu method, programin calismasini saglar.
     * @param args Programin parametreleri
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Weight and Cost of Suit Calculation System");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 170);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

