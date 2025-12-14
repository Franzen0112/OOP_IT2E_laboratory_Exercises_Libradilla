import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ArithmeticGame extends JFrame implements ActionListener {

    private JLabel lblNum1, lblNum2, lblOperator, lblLevel, lblCorrectIncorrect;
    private JTextField txtAnswer;
    private JButton btnSubmit;
    private JRadioButton rbAdd, rbSub, rbMul, rbDiv, rbMod;
    private JRadioButton rbLevel1, rbLevel2, rbLevel3;
    private ButtonGroup groupOperation, groupLevel;

    private int num1, num2, correctAnswer;
    private int correctCount = 0, incorrectCount = 0;
    private Random rand = new Random();

    public ArithmeticGame() {
        // JFrame setup
        setTitle("Arithmetic Game");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- Top Panel (Game area) ---
        JPanel pnlTop = new JPanel(new FlowLayout());
        lblNum1 = new JLabel("0");
        lblNum1.setFont(new Font("Arial", Font.BOLD, 40));
        lblOperator = new JLabel("+");
        lblOperator.setFont(new Font("Arial", Font.BOLD, 40));
        lblNum2 = new JLabel("0");
        lblNum2.setFont(new Font("Arial", Font.BOLD, 40));
        JLabel lblEqual = new JLabel("=");
        lblEqual.setFont(new Font("Arial", Font.BOLD, 40));
        txtAnswer = new JTextField(5);
        txtAnswer.setFont(new Font("Arial", Font.BOLD, 32));
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 28));
        btnSubmit.addActionListener(this);

        // Let Enter key trigger the Submit button
        getRootPane().setDefaultButton(btnSubmit);

        pnlTop.add(lblNum1);
        pnlTop.add(lblOperator);
        pnlTop.add(lblNum2);
        pnlTop.add(lblEqual);
        pnlTop.add(txtAnswer);
        pnlTop.add(btnSubmit);

        // --- Middle Panel (Operation & Level) ---
        JPanel pnlOptions = new JPanel(new GridLayout(2, 1, 0, 0));

        // Operation buttons
        JPanel pnlOp = new JPanel(new FlowLayout());
        pnlOp.setBorder(BorderFactory.createTitledBorder("Operation"));
        rbAdd = new JRadioButton("Addition", true);
        rbSub = new JRadioButton("Subtraction");
        rbMul = new JRadioButton("Multiplication");
        rbDiv = new JRadioButton("Division");
        rbMod = new JRadioButton("Modulo"); // new modulo option

        groupOperation = new ButtonGroup();
        groupOperation.add(rbAdd);
        groupOperation.add(rbSub);
        groupOperation.add(rbMul);
        groupOperation.add(rbDiv);
        groupOperation.add(rbMod);

        pnlOp.add(rbAdd);
        pnlOp.add(rbSub);
        pnlOp.add(rbMul);
        pnlOp.add(rbDiv);
        pnlOp.add(rbMod);

        // Level buttons
        JPanel pnlLevel = new JPanel(new FlowLayout());
        pnlLevel.setBorder(BorderFactory.createTitledBorder("Level"));
        rbLevel1 = new JRadioButton("Level 1 (1–10)", true);
        rbLevel2 = new JRadioButton("Level 2 (1–50)");
        rbLevel3 = new JRadioButton("Level 3 (51–100)");
        groupLevel = new ButtonGroup();
        groupLevel.add(rbLevel1);
        groupLevel.add(rbLevel2);
        groupLevel.add(rbLevel3);
        pnlLevel.add(rbLevel1);
        pnlLevel.add(rbLevel2);
        pnlLevel.add(rbLevel3);

        pnlOptions.add(pnlOp);
        pnlOptions.add(pnlLevel);

        // Add listeners for radio buttons
        ActionListener optionListener = e -> generateQuestion();
        rbAdd.addActionListener(optionListener);
        rbSub.addActionListener(optionListener);
        rbMul.addActionListener(optionListener);
        rbDiv.addActionListener(optionListener);
        rbMod.addActionListener(optionListener);
        rbLevel1.addActionListener(optionListener);
        rbLevel2.addActionListener(optionListener);
        rbLevel3.addActionListener(optionListener);

        // --- Bottom Panel (Status only) ---
        JPanel pnlBottom = new JPanel(new GridLayout(2, 1));
        JPanel pnlStats = new JPanel(new FlowLayout());
        JPanel pnlStatus = new JPanel(new FlowLayout());

        lblCorrectIncorrect = new JLabel("Correct: 0 | Incorrect: 0");
        lblCorrectIncorrect.setFont(new Font("Arial", Font.BOLD, 18));
        lblLevel = new JLabel("Ready!");
        lblLevel.setFont(new Font("Arial", Font.PLAIN, 18));

        pnlStats.add(lblCorrectIncorrect);
        pnlStatus.add(lblLevel);

        pnlBottom.add(pnlStats);
        pnlBottom.add(pnlStatus);

        // Add Panels to JFrame
        add(pnlTop, BorderLayout.NORTH);
        add(pnlOptions, BorderLayout.CENTER);
        add(pnlBottom, BorderLayout.SOUTH);

        // Generate first question
        generateQuestion();

        setVisible(true);
    }

    private void generateQuestion() {
        int min = 1, max = 10;
        if (rbLevel2.isSelected()) { min = 1; max = 50; }
        else if (rbLevel3.isSelected()) { min = 51; max = 100; }

        num1 = rand.nextInt(max - min + 1) + min;
        num2 = rand.nextInt(max - min + 1) + min;

        // Avoid division/modulo by zero
        if ((rbDiv.isSelected() || rbMod.isSelected()) && num2 == 0) {
            num2 = 1;
        }

        if (rbAdd.isSelected()) {
            correctAnswer = num1 + num2;
            lblOperator.setText("+");
        } else if (rbSub.isSelected()) {
            correctAnswer = num1 - num2;
            lblOperator.setText("-");
        } else if (rbMul.isSelected()) {
            correctAnswer = num1 * num2;
            lblOperator.setText("×");
        } else if (rbDiv.isSelected()) {
            correctAnswer = num1 / num2;
            lblOperator.setText("÷");
        } else if (rbMod.isSelected()) {
            correctAnswer = num1 % num2;
            lblOperator.setText("%");
        }

        lblNum1.setText(String.valueOf(num1));
        lblNum2.setText(String.valueOf(num2));
        txtAnswer.setText("");
        txtAnswer.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int answer = Integer.parseInt(txtAnswer.getText());
            if (answer == correctAnswer) {
                correctCount++;
                lblLevel.setText("✅ Correct!");
            } else {
                incorrectCount++;
                lblLevel.setText("❌ Wrong! Answer: " + correctAnswer);
            }
            lblCorrectIncorrect.setText("Correct: " + correctCount + " | Incorrect: " + incorrectCount);
            generateQuestion();
        } catch (NumberFormatException ex) {
            lblLevel.setText("⚠️ Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArithmeticGame::new);
    }
}
