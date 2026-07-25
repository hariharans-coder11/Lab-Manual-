import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends Frame implements ActionListener {

    Label lblTitle, lblNum1, lblNum2, lblResult;
    TextField txtNum1, txtNum2, txtResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(380, 320);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        lblTitle = new Label("Simple Calculator", Label.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitle.setBounds(80, 40, 220, 25);
        add(lblTitle);

        lblNum1 = new Label("First Number :");
        lblNum1.setBounds(40, 80, 110, 25);
        add(lblNum1);

        txtNum1 = new TextField();
        txtNum1.setBounds(160, 80, 160, 25);
        add(txtNum1);

        lblNum2 = new Label("Second Number :");
        lblNum2.setBounds(40, 120, 110, 25);
        add(lblNum2);

        txtNum2 = new TextField();
        txtNum2.setBounds(160, 120, 160, 25);
        add(txtNum2);

        btnAdd = new Button("Add");
        btnAdd.setBounds(40, 160, 65, 30);
        add(btnAdd);

        btnSub = new Button("Subtract");
        btnSub.setBounds(115, 160, 65, 30);
        add(btnSub);

        btnMul = new Button("Multiply");
        btnMul.setBounds(190, 160, 65, 30);
        add(btnMul);

        btnDiv = new Button("Divide");
        btnDiv.setBounds(265, 160, 65, 30);
        add(btnDiv);

        lblResult = new Label("Result :");
        lblResult.setBounds(40, 210, 110, 25);
        add(lblResult);

        txtResult = new TextField();
        txtResult.setBounds(160, 210, 160, 25);
        txtResult.setEditable(false);
        add(txtResult);

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operation = e.getActionCommand();
        computeAndDisplay(txtNum1.getText(), txtNum2.getText(), operation);
    }

    public void computeAndDisplay(String str1, String str2, String operation) {
        try {
            double num1 = Double.parseDouble(str1.trim());
            double num2 = Double.parseDouble(str2.trim());

            System.out.println("First Number : " + (int) num1);
            System.out.println("Second Number : " + (int) num2);
            System.out.println("Click : " + operation);

            if (operation.equals("Add")) {
                double result = num1 + num2;
                txtResult.setText(String.valueOf(result));
                System.out.println("Result : " + result);
            } else if (operation.equals("Subtract")) {
                double result = num1 - num2;
                txtResult.setText(String.valueOf(result));
                System.out.println("Result : " + result);
            } else if (operation.equals("Multiply")) {
                double result = num1 * num2;
                txtResult.setText(String.valueOf(result));
                System.out.println("Result : " + result);
            } else if (operation.equals("Divide")) {
                if (num2 == 0) {
                    txtResult.setText("Cannot divide by zero");
                    System.out.println("Result : Cannot divide by zero");
                } else {
                    double result = num1 / num2;
                    txtResult.setText(String.valueOf(result));
                    System.out.println("Result : " + result);
                }
            }
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid Input");
            System.out.println("Result : Invalid Input");
        }
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();

        System.out.println("Case 1");
        System.out.println("----------------------------------------");
        System.out.println("         Simple Calculator             ");
        System.out.println("----------------------------------------");
        calc.computeAndDisplay("25", "15", "Add");
        System.out.println();

        System.out.println("Case 2");
        System.out.println("----------------------------------------");
        System.out.println("         Simple Calculator             ");
        System.out.println("----------------------------------------");
        calc.computeAndDisplay("18", "6", "Divide");
        System.out.println();

        System.out.println("Case 3");
        System.out.println("----------------------------------------");
        System.out.println("         Simple Calculator             ");
        System.out.println("----------------------------------------");
        calc.computeAndDisplay("25", "0", "Divide");
    }
}
