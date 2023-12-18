package view;

import javax.swing.*;

public class ErrorPrompt extends ExcerciseFrame {

    public ErrorPrompt() {
        JOptionPane.showMessageDialog(null,
                "An error has occurred: Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void DateErrorPrompt(String message) {
        JOptionPane.showMessageDialog(null,
                message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
