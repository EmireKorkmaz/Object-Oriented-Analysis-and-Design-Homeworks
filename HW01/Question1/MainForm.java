package com.emire;

/**
 * @author Emire Korkmaz
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainForm{
    private JPanel mainPanel = new JPanel();
    private JPanel headingPanel = new JPanel();
    private JPanel selectionPanel = new JPanel();
    private JPanel equationPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel resultPanel = new JPanel();
    private JComboBox comboBox = new JComboBox();
    private Integer[] numbers = new Integer[50];
    private JTextField heading = new JTextField("Welcome to linear system equations calculator" );
    private JTextField exampleText = new JTextField("Example equations:For 4 unknowns, 3,4,-2,5 equals to 3x1 + 4x2 -2x3 = 5");
    private JButton selectButton = new JButton();
    private JButton calculateButton = new JButton();
    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton gauss;
    private JRadioButton matrixInv;
    private Integer selectNum = 1;
    private JTextField[] textFields;
    private JTextField[] equationTexts;
    private JFormattedTextField[] solutionTexts;

    /**
     * Bu method GUI ile ilgili islemleri yerine getirir.
     */

    public MainForm() {
        BoxLayout mainBox = new BoxLayout(mainPanel,BoxLayout.Y_AXIS);
        BoxLayout equationBox = new BoxLayout(equationPanel,BoxLayout.Y_AXIS);
        BoxLayout resultBox = new BoxLayout(resultPanel,BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainBox);
        headingPanel.setLayout(new GridLayout(2,1));
        selectionPanel.setLayout(new FlowLayout());
        equationPanel.setLayout(equationBox);
        buttonPanel.setLayout(new GridLayout(1,3));
        resultPanel.setLayout(resultBox);
        mainPanel.add(headingPanel);
        mainPanel.add(selectionPanel);
        mainPanel.add(equationPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);
        headingPanel.add(heading);
        headingPanel.add(exampleText);
        for (int i = 0; i < 50; i++){
            numbers[i] = i + 1;
        }
        for(int i = 0; i < numbers.length; i++) {
            comboBox.addItem(numbers[i]);
        }
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        exampleText.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Default",Font.BOLD,20);
        heading.setFont(font);
        heading.setEditable(false);
        exampleText.setEditable(false);
        selectionPanel.add(comboBox);
        selectButton.setText("Select");
        selectButton.setSize(30,40);
        selectionPanel.add(selectButton);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //selectedNumber.setText("You selected" + ((JComboBox)e.getSource()).getSelectedItem());
                selectNum = (Integer)((JComboBox)e.getSource()).getSelectedItem();
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFields != null && (textFields.length != selectNum || textFields.length == selectNum)){
                    for (int i = 0; i < textFields.length; i++) {
                        equationPanel.remove(textFields[i]);
                        equationPanel.remove(equationTexts[i]);
                    }
                }
                if(solutionTexts != null && (textFields.length != selectNum || textFields.length == selectNum)){
                    for (int i = 0; i < solutionTexts.length; i++)
                        resultPanel.remove(solutionTexts[i]);
                }
                if(gauss != null) {
                    buttonPanel.remove(gauss);
                    bg.remove(gauss);
                }
                if(matrixInv != null){
                    buttonPanel.remove(matrixInv);
                    bg.remove(matrixInv);
                }
                textFields = new JTextField[selectNum];
                equationTexts = new JTextField[selectNum];
                for (int i = 0; i < selectNum; i++){
                    textFields[i] = new JTextField(10);
                    equationTexts[i] = new JTextField("Equation-" + (i + 1));
                    equationTexts[i].setEditable(false);
                    equationPanel.add(equationTexts[i]);
                    equationPanel.add(textFields[i]);
                }
                gauss = new JRadioButton("Gauss Elimination");
                gauss.setBounds(100,50,100,30);
                matrixInv = new JRadioButton("Matrix Inversion");
                matrixInv.setBounds(100,100,100,30);
                bg.add(gauss);
                bg.add(matrixInv);
                calculateButton.setText("Solve");
                calculateButton.setSize(30,40);
                buttonPanel.add(gauss);
                buttonPanel.add(matrixInv);
                buttonPanel.add(calculateButton);
                mainPanel.updateUI();
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Double> a = new ArrayList<>();
                ArrayList<Double> b = new ArrayList<>();
                double [] solution;
                if (solutionTexts != null && solutionTexts.length == selectNum)
                    for (int i = 0; i < solutionTexts.length; i++){
                        resultPanel.remove(solutionTexts[i]);
                    }
                if(!gauss.isSelected() && !matrixInv.isSelected()){
                    JOptionPane.showMessageDialog(null,"Please choose one solving method!");
                }
                else{
                    for (int i = 0; i < textFields.length; i++){
                        String value = textFields[i].getText();
                        if(value.equals("")){
                            JOptionPane.showMessageDialog(null,"Please enter all equations.");
                            return;
                        }
                        else {
                            int countComma = 0;
                            for (int j = 0; j < value.length(); j++){
                                if (value.charAt(j) == ','){
                                    countComma++;
                                }
                            }
                            if(countComma == selectNum){
                                String[] data = value.split(",");
                                for(int j = 0; j < data.length - 1; j++)
                                    a.add(Double.parseDouble(data[j]));
                                b.add(Double.parseDouble(data[data.length-1]));
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "Illegal equations. Please enter legal equations.");
                                return;
                            }
                        }
                    }
                    int row = (int) Math.sqrt((double) a.size());
                    Double[][] A = new Double[row][];
                    for(int i = 0; i < row; i++)
                        A[i] = new Double[row];
                    for(int i = 0; i < row; i++){
                        for(int j = 0; j < row; j++)
                            A[i][j] = a.get((row * i) + j);
                    }
                    if(gauss.isSelected()){
                        Equations gaussEq = new Equations(new GaussianElimination());
                        solution = gaussEq.solveEquations(A,b);
                        if(solution != null) {
                            solutionTexts = new JFormattedTextField[solution.length];
                            for(int i = 0; i < solution.length; i++){
                                solutionTexts[i] = new JFormattedTextField();
                                solutionTexts[i].setValue("x" + (i + 1) + ": " + (solution[i]));
                                solutionTexts[i].setEditable(false);
                                resultPanel.add(solutionTexts[i]);
                                mainPanel.updateUI();
                            }
                        }
                    }
                    else if (matrixInv.isSelected()){
                        Equations matrixInvEqu = new Equations(new MatrixInversion());
                        solution = matrixInvEqu.solveEquations(A,b);
                        if(solution != null){
                            solutionTexts = new JFormattedTextField[solution.length];
                            for(int i = 0; i < solution.length; i++){
                                solutionTexts[i] = new JFormattedTextField();
                                solutionTexts[i].setValue("x" + (i + 1) + ": " + (solution[i]));
                                solutionTexts[i].setEditable(false);
                                resultPanel.add(solutionTexts[i]);
                                mainPanel.updateUI();
                            }
                        }
                    }
                }
            }

        });
    }

    /**
     * Bu method, programin calismasini saglar.
     * @param args Programin parametreleri
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Linear System Equations Calculator");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 540);
        frame.setVisible(true);
    }
}
