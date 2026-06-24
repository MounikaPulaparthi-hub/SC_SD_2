import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGame extends JFrame implements ActionListener {

    private JComboBox<String> difficultyBox;
    private JTextField guessField;
    private JButton guessButton, newGameButton;

    private JLabel titleLabel;
    private JLabel hintLabel;
    private JLabel livesLabel;
    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private JLabel rangeLabel;

    private JProgressBar progressBar;

    private int randomNumber;
    private int lives;
    private int maxLives;
    private int score = 0;
    private int highScore = 0;
    private int attempts = 0;

    private Random random = new Random();

    public NumberGuessingGame() {

        setTitle("🎯 Number Guessing Game");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        titleLabel = new JLabel("🎯 NUMBER GUESSING GAME");
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBounds(150, 20, 400, 40);

        JLabel difficultyLabel = new JLabel("Difficulty:");
        difficultyLabel.setForeground(Color.WHITE);
        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 16));
        difficultyLabel.setBounds(50, 90, 100, 30);

        String[] levels = {"Easy", "Medium", "Hard"};
        difficultyBox = new JComboBox<>(levels);
        difficultyBox.setBounds(150, 90, 150, 30);

        rangeLabel = new JLabel("Range: 1 - 50");
        rangeLabel.setForeground(Color.CYAN);
        rangeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        rangeLabel.setBounds(350, 90, 200, 30);

        livesLabel = new JLabel("❤️ Lives: ");
        livesLabel.setForeground(Color.PINK);
        livesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        livesLabel.setBounds(50, 140, 250, 30);

        scoreLabel = new JLabel("🏆 Score: 0");
        scoreLabel.setForeground(Color.YELLOW);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setBounds(50, 180, 200, 30);

        highScoreLabel = new JLabel("👑 High Score: 0");
        highScoreLabel.setForeground(Color.ORANGE);
        highScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        highScoreLabel.setBounds(300, 180, 250, 30);

        JLabel guessLabel = new JLabel("Enter Your Guess:");
        guessLabel.setForeground(Color.WHITE);
        guessLabel.setFont(new Font("Arial", Font.BOLD, 16));
        guessLabel.setBounds(50, 240, 180, 30);

        guessField = new JTextField();
        guessField.setBounds(220, 240, 150, 35);
        guessField.setFont(new Font("Arial", Font.PLAIN, 16));

        guessButton = new JButton("🎯 Guess");
        guessButton.setBounds(390, 240, 120, 35);
        guessButton.addActionListener(this);

        newGameButton = new JButton("🔄 New Game");
        newGameButton.setBounds(530, 240, 130, 35);
        newGameButton.addActionListener(this);

        hintLabel = new JLabel("Click New Game to Start!");
        hintLabel.setForeground(Color.GREEN);
        hintLabel.setFont(new Font("Arial", Font.BOLD, 18));
        hintLabel.setBounds(50, 300, 500, 40);

        progressBar = new JProgressBar();
        progressBar.setBounds(50, 370, 600, 30);
        progressBar.setStringPainted(true);

        panel.add(titleLabel);
        panel.add(difficultyLabel);
        panel.add(difficultyBox);
        panel.add(rangeLabel);
        panel.add(livesLabel);
        panel.add(scoreLabel);
        panel.add(highScoreLabel);
        panel.add(guessLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(newGameButton);
        panel.add(hintLabel);
        panel.add(progressBar);

        add(panel);

        startNewGame();

        setVisible(true);
    }

    private void startNewGame() {

        attempts = 0;

        String difficulty = (String) difficultyBox.getSelectedItem();

        if (difficulty.equals("Easy")) {
            randomNumber = random.nextInt(50) + 1;
            maxLives = 10;
            rangeLabel.setText("Range: 1 - 50");
        }
        else if (difficulty.equals("Medium")) {
            randomNumber = random.nextInt(100) + 1;
            maxLives = 7;
            rangeLabel.setText("Range: 1 - 100");
        }
        else {
            randomNumber = random.nextInt(200) + 1;
            maxLives = 5;
            rangeLabel.setText("Range: 1 - 200");
        }

        lives = maxLives;

        updateLivesDisplay();

        progressBar.setMaximum(maxLives);
        progressBar.setValue(0);

        hintLabel.setText("Game Started! Enter your guess.");
        guessField.setText("");

        // Uncomment for testing
        // System.out.println("Number = " + randomNumber);
    }

    private void updateLivesDisplay() {

        StringBuilder hearts = new StringBuilder();

        for (int i = 0; i < lives; i++) {
            hearts.append("❤️ ");
        }

        livesLabel.setText("Lives: " + hearts);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newGameButton) {
            startNewGame();
            return;
        }

        try {

            int guess = Integer.parseInt(guessField.getText());

            attempts++;
            progressBar.setValue(attempts);

            if (guess == randomNumber) {

                int earnedScore = lives * 10;
                score += earnedScore;

                if (score > highScore) {
                    highScore = score;
                }

                scoreLabel.setText("🏆 Score: " + score);
                highScoreLabel.setText("👑 High Score: " + highScore);

                JOptionPane.showMessageDialog(
                        this,
                        "🎉 Congratulations!\n\n" +
                        "You guessed the number correctly!\n" +
                        "Score Earned: " + earnedScore,
                        "Winner",
                        JOptionPane.INFORMATION_MESSAGE);

                startNewGame();
            }

            else {

                lives--;

                updateLivesDisplay();

                if (guess < randomNumber) {
                    hintLabel.setText("🔻 Too Low! Try a bigger number.");
                    hintLabel.setForeground(Color.CYAN);
                }
                else {
                    hintLabel.setText("🔺 Too High! Try a smaller number.");
                    hintLabel.setForeground(Color.ORANGE);
                }

                if (lives <= 0) {

                    JOptionPane.showMessageDialog(
                            this,
                            "💀 GAME OVER!\n\n" +
                            "The correct number was: " + randomNumber,
                            "Game Over",
                            JOptionPane.ERROR_MESSAGE);

                    startNewGame();
                }
            }

            guessField.setText("");

        }

        catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new NumberGuessingGame();
        });
    }
}