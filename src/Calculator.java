import javax.swing.*;
import java.awt.*;

public class Calculator {

    private final JTextField textField;
    private JPanel buttonPanel;
    private int num1 = 0;
    private int num2 = 0;
    private int ans = 0;
    private String operator;


    public Calculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setSize(new Dimension(400, 400));
        frame.setLayout(new GridLayout(2, 1));
        textField = new JTextField("0");
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);
        makeButtonPanel();
        frame.add(buttonPanel);
        frame.pack();
        frame.setVisible(true);

    }

    private void makeButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        String[] ops = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "C", "0", "=", "/"};
        ButtonFactory factory = new ButtonFactory();
        for (String op : ops) {
            buttonPanel.add(factory.makeButton(op));
        }
    }

    private class ButtonFactory {

        private JButton makeButton(String string) {
            JButton button = new JButton();
            switch (string) {
                case ("+") -> {
                    button.setText("+");
                    button.addActionListener(e -> {
                        num1 = Integer.parseInt(textField.getText());
                        textField.setText("0");
                        operator = "+";
                    });
                }
                case ("-") -> {
                    button.setText("-");
                    button.addActionListener(e -> {
                        num1 = Integer.parseInt(textField.getText());
                        textField.setText("0");
                        operator = "-";
                    });
                }
                case ("*") -> {
                    button.setText("*");
                    button.addActionListener(e -> {
                        num1 = Integer.parseInt(textField.getText());
                        textField.setText("0");
                        operator = "*";
                    });
                }
                case ("/") -> {
                    button.setText("/");
                    button.addActionListener(e -> {
                        num1 = Integer.parseInt(textField.getText());
                        textField.setText("0");
                        operator = "/";
                    });
                }
                case ("=") -> {
                    button.setText("=");
                    button.addActionListener(e -> {
                        num2 = Integer.parseInt(textField.getText());
                        switch (operator) {
                            case ("+") -> ans = num1 + num2;
                            case ("-") -> ans = num1 - num2;
                            case ("*") -> ans = num1 * num2;
                            case ("/") -> {
                                if (num2 == 0) {
                                    ans = 0;
                                } else {
                                    ans = num1 / num2;
                                }
                            }
                            default -> textField.setText("");
                        }
                        textField.setText(String.valueOf(ans));
                        num1 = 0;
                        num2 = 0;
                    });
                }
                case ("C") -> {
                    button.setText("C");
                    button.addActionListener(e -> textField.setText("0"));
                }
                default -> {
                    button.setText(string);
                    button.addActionListener(e -> textField.setText(textField.getText() + string));
                }
            }
            return button;
        }
    }
}