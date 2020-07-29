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
    private JPanel textPanel = new JPanel();
    private JPanel planePanel = new JPanel();
    private JPanel resultPanel = new JPanel();
    private JRadioButton TPX100Button;
    private JRadioButton TPX200Button;
    private JRadioButton TPX300Button;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JButton createButton = new JButton("Create");
    private JLabel selectText = new JLabel("Which plane do you want to produce?");
    private JLabel modelText = new JLabel();
    private JLabel purposeText = new JLabel();
    private JLabel skeletonText = new JLabel();
    private JLabel engineText = new JLabel();
    private JLabel seatText = new JLabel();

    /**
     * Bu method GUI ile ilgili islemleri yerine getirir.
     */

    public GUI(){
        BoxLayout mainBox = new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
        BoxLayout textBox = new BoxLayout(textPanel,BoxLayout.X_AXIS);

        mainPanel.setLayout(mainBox);
        textPanel.setLayout(textBox);
        planePanel.setLayout(new FlowLayout());
        resultPanel.setLayout(new GridLayout(5,1));

        mainPanel.add(textPanel);
        mainPanel.add(planePanel);
        mainPanel.add(resultPanel);

        selectText.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Default",Font.BOLD,18);
        selectText.setFont(font);

        textPanel.add(selectText);

        TPX100Button = new JRadioButton("TPX100");
        TPX200Button = new JRadioButton("TPX200");
        TPX300Button = new JRadioButton("TPX300");

        TPX100Button.setBounds(100,50,100, 30);
        TPX200Button.setBounds(100,50,100,30);
        TPX300Button.setBounds(100,50,100,30);

        buttonGroup.add(TPX100Button);
        buttonGroup.add(TPX200Button);
        buttonGroup.add(TPX300Button);

        createButton.setSize(30,40);

        planePanel.add(TPX100Button);
        planePanel.add(TPX200Button);
        planePanel.add(TPX300Button);
        planePanel.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlaneFactory factory = new PlaneFactory();
                if(TPX100Button.isSelected()){
                    Planes plane = factory.product("TPX100");
                    completeSteps(plane);
                }
                else if(TPX200Button.isSelected()){
                    Planes plane = factory.product("TPX200");
                    completeSteps(plane);
                }
                else if(TPX300Button.isSelected()){
                    Planes plane = factory.product("TPX300");
                    completeSteps(plane);
                }
                else
                    JOptionPane.showMessageDialog(null,"Wrong choice! Please try again");
            }
        });
    }

    /**
     * Bu method ucagin uretim asamasında neler yapıldıgını ekrana gosterir.
     * @param plane Ucak tipi(TPX100, TPX200, TPX300)
     */

    private void completeSteps(Planes plane){
        modelText.setText(plane.getModel() + " is creating...");
        purposeText.setText("Purpose: " + plane.getPurpose());
        skeletonText.setText("Skeleton of plane: " + plane.getSkeleton());
        engineText.setText("Engine of plane: " + plane.getEngine());
        seatText.setText("It has " + plane.getSeating() + " seats.");
        resultPanel.add(modelText);
        resultPanel.add(purposeText);
        resultPanel.add(skeletonText);
        resultPanel.add(engineText);
        resultPanel.add(seatText);
        mainPanel.updateUI();
    }

    /**
     * Bu method, programin calismasini saglar.
     * @param args Programin parametreleri
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Creating Plane Simulator");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 180);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
