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
    private JPanel factoryPanel = new JPanel();
    private JPanel factoryTextPanel = new JPanel();
    private JPanel resultPanel = new JPanel();
    private JRadioButton TPX100Button;
    private JRadioButton TPX200Button;
    private JRadioButton TPX300Button;
    private JRadioButton domesticButton;
    private JRadioButton eurasiaButton;
    private JRadioButton otherButton;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private ButtonGroup buttonGroup2 = new ButtonGroup();
    private JButton createButton = new JButton("Create");
    private JLabel selectText = new JLabel("Which plane do you want to produce?");
    private JLabel factoryText = new JLabel("Which factory would you like to produce plane?");
    private JLabel modelText = new JLabel();
    private JLabel purposeText = new JLabel();
    private JLabel skeletonText = new JLabel();
    private JLabel engineText = new JLabel();
    private JLabel injectionText = new JLabel();
    private JLabel seatCoverText = new JLabel();
    private JLabel seatText = new JLabel();

    /**
     * Bu method GUI ile ilgili islemleri yerine getirir.
     */

    public GUI() {
        BoxLayout mainBox = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        BoxLayout textBox = new BoxLayout(textPanel, BoxLayout.X_AXIS);
        BoxLayout factoryTextBox = new BoxLayout(factoryTextPanel, BoxLayout.X_AXIS);

        mainPanel.setLayout(mainBox);
        textPanel.setLayout(textBox);
        planePanel.setLayout(new FlowLayout());
        factoryTextPanel.setLayout(factoryTextBox);
        factoryPanel.setLayout(new FlowLayout());
        resultPanel.setLayout(new GridLayout(7, 1));

        mainPanel.add(factoryTextPanel);
        mainPanel.add(factoryPanel);
        mainPanel.add(textPanel);
        mainPanel.add(planePanel);
        mainPanel.add(resultPanel);

        selectText.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Default", Font.BOLD, 18);
        selectText.setFont(font);

        textPanel.add(selectText);

        factoryText.setHorizontalAlignment(SwingConstants.CENTER);
        Font font2 = new Font("Default", Font.BOLD, 18);
        factoryText.setFont(font2);

        factoryTextPanel.add(factoryText);

        TPX100Button = new JRadioButton("TPX100");
        TPX200Button = new JRadioButton("TPX200");
        TPX300Button = new JRadioButton("TPX300");

        domesticButton = new JRadioButton("Domestic Factory");
        eurasiaButton = new JRadioButton("Eurasia Factory");
        otherButton = new JRadioButton("Other Factory");


        TPX100Button.setBounds(100, 50, 100, 30);
        TPX200Button.setBounds(100, 50, 100, 30);
        TPX300Button.setBounds(100, 50, 100, 30);

        domesticButton.setBounds(100, 50, 100, 30);
        eurasiaButton.setBounds(100, 50, 100, 30);
        otherButton.setBounds(100, 50, 100, 30);

        buttonGroup.add(TPX100Button);
        buttonGroup.add(TPX200Button);
        buttonGroup.add(TPX300Button);

        buttonGroup2.add(domesticButton);
        buttonGroup2.add(eurasiaButton);
        buttonGroup2.add(otherButton);

        planePanel.add(TPX100Button);
        planePanel.add(TPX200Button);
        planePanel.add(TPX300Button);
        planePanel.add(createButton);

        createButton.setSize(30, 40);
        planePanel.add(createButton);

        factoryPanel.add(domesticButton);
        factoryPanel.add(eurasiaButton);
        factoryPanel.add(otherButton);



        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Planes plane = null;
                if(domesticButton.isSelected()){
                    DomesticFactory domesticFactory = new DomesticFactory();
                    plane = producePlane(domesticFactory);
                    if(plane == null){
                        return;
                    }
                    completeSteps(plane,domesticFactory);
                }
                else if(eurasiaButton.isSelected()){
                    EurasiaFactory eurasiaFactory = new EurasiaFactory();
                    plane = producePlane(eurasiaFactory);
                    if(plane == null){
                        return;
                    }
                    completeSteps(plane,eurasiaFactory);
                }
                else if(otherButton.isSelected()){
                    OtherFactory otherFactory = new OtherFactory();
                    plane = producePlane(otherFactory);
                    if(plane == null){
                        return;
                    }
                    completeSteps(plane,otherFactory);
                }
                else
                    JOptionPane.showMessageDialog(null, "Wrong choice! Please try again.");
            }
        });
    }

    /**
     * Bu method ucagin uretim asamasında neler yapıldıgını ekrana gosterir.
     * @param plane Ucak tipi(TPX100, TPX200, TPX300)
     * @param factory Ucagin hangi fabrikada uretilecegi
     */

    private void completeSteps(Planes plane, Factories factory){
        modelText.setText(plane.getModel() + " is creating...");
        purposeText.setText("Purpose: " + plane.getPurpose());
        skeletonText.setText("Skeleton of plane: " + plane.getSkeleton());
        injectionText.setText("Engine injection type:" + factory.getInjectionType());
        seatCoverText.setText("Seating cover: " + factory.getSeatingCover());
        engineText.setText("Engine of plane: " + plane.getEngine());
        seatText.setText("It has " + plane.getSeating() + " seats.");
        resultPanel.add(modelText);
        resultPanel.add(purposeText);
        resultPanel.add(injectionText);
        resultPanel.add(seatCoverText);
        resultPanel.add(skeletonText);
        resultPanel.add(engineText);
        resultPanel.add(seatText);
        mainPanel.updateUI();
    }

    /**
     * Bu method bir ucak uretir.
     * @param factory Ucagin hangi fabrikada uretilecegi
     * @return Ucak objesi
     */

    private Planes producePlane(Factories factory){
        Planes plane;
        if(TPX100Button.isSelected()){
            plane = factory.product("TPX100");
            return plane;
        }
        else if(TPX200Button.isSelected()){
            plane = factory.product("TPX200");
            return plane;
        }
        else if(TPX300Button.isSelected()){
            plane = factory.product("TPX300");
            return plane;
        }
        else {
            JOptionPane.showMessageDialog(null, "Wrong choice! Please try again");
            return null;
        }
    }

    /**
     * Bu method, programin calismasini saglar.
     * @param args Programin parametreleri
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Creating Plane Simulator");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 270);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
