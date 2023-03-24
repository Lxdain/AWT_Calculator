import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    private Label firstNumberLabel, secondNumberLabel, operationLabel, resultLabel;
    private TextField firstNumberField, secondNumberField;
    private Choice operationChoice;
    private Button calculateButton;

    public Calculator() {
        setTitle("Java AWT Calculator");
        setSize(400, 300);
        setBackground(new Color(66, 66, 66));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        // First Number Label and Field
        firstNumberLabel = new Label("First Number:");
        firstNumberLabel.setBackground(new Color(154, 205, 50));
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST; // align label to left edge
        add(firstNumberLabel, c);

        firstNumberField = new TextField(10);
        firstNumberField.setBackground(Color.LIGHT_GRAY);
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST; // align field to right edge
        add(firstNumberField, c);

        // Operation Label and Choice
        operationLabel = new Label("Operation:");
        operationLabel.setBackground(new Color(255, 198, 0));
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST; // align label to left edge
        add(operationLabel, c);

        operationChoice = new Choice();
        operationChoice.setBackground(Color.LIGHT_GRAY);
        operationChoice.add("+");
        operationChoice.add("-");
        operationChoice.add("*");
        operationChoice.add("/");
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST; // align choice to right edge
        add(operationChoice, c);

        // Second Number Label and Field
        secondNumberLabel = new Label("Second Number:");
        secondNumberLabel.setBackground(new Color(154, 205, 50));
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST; // align label to left edge
        add(secondNumberLabel, c);

        secondNumberField = new TextField(10);
        secondNumberField.setBackground(Color.LIGHT_GRAY);
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST; // align field to right edge
        add(secondNumberField, c);

        // Calculate Button
        calculateButton = new Button("Calculate!");
        calculateButton.setBackground(new Color(255, 50, 50));
        calculateButton.addActionListener(this);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER; // center button
        add(calculateButton, c);

        // Result Label
        resultLabel = new Label("Result:");
        resultLabel.setBackground(Color.LIGHT_GRAY);
        resultLabel.setPreferredSize(new Dimension(450, 30));
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST; // align label to left edge
        add(resultLabel, c);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double firstNumber = Double.parseDouble(firstNumberField.getText());
        double secondNumber = Double.parseDouble(secondNumberField.getText());
        String operation = operationChoice.getSelectedItem();

        double result = 0;

        if (secondNumber == 0 && operation.equals("/")) {
            resultLabel.setText("Not Divisible by 0!");
        } else {
            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
            }
            resultLabel.setText("Result: " + Double.toString(result));
        }
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
