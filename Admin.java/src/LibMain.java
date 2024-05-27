import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class LibMain {
    static JFrame frame;

    public static void main(String[] args) {
        AdminFunctions.refresh();
        mainMenu();
    }

    public static void mainMenu() {
        String[] options = { "Login", "Add new user", "Exit" };

        newFrame("Welcome to the Library", 800, 478);
        frame.setLayout(null);

		JLabel background = new JLabel(new ImageIcon("C:\\myWebProject\\LibManSystem\\Admin.java\\src\\MainPage.jpg"));
        JLabel labelT = new JLabel("Welcome to the Sanguine Library");
        labelT.setHorizontalAlignment(JLabel.CENTER);
        labelT.setBounds(0, 50, 800, 70);
        labelT.setFont(new Font("Arial", Font.BOLD, 40));
        labelT.setForeground(new Color(92, 64, 51)); // Dark Brown Color
       
        frame.add(labelT);
        frame.add(background);

        background.setBounds(0,0,800,478);

        int selection = JOptionPane.showOptionDialog(frame, "Welcome to Library Management System", "Select an option",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (selection == 0) {
            LogAdd.login();
        } else if (selection == 1) {
            LogAdd.addUser();
        } else if (selection == 2) {
            frame.setVisible(false);
            frame.dispose();
            System.exit(0);
        }
    }

    public static void newFrame(String title, int w, int h) {
        frame = new JFrame(title);
        frame.setSize(w, h);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static JFrame newJframeWindow(String title, int w, int h, int closeop) {
        JFrame iframe = new JFrame(title);
        iframe.setSize(w, h);
        iframe.setDefaultCloseOperation(closeop);
        iframe.setLayout(null);
        iframe.setVisible(true);
        iframe.setLocationRelativeTo(null);
        return iframe;
    }
}
