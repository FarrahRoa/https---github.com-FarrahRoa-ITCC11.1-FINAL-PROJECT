import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Admin {
    static String[] names = { "View Books", "View Users", "View Issued Books", "Issue Book", "Add User", "Return Book", "Returned Books" };
    static JButton[] buttons = new JButton[names.length];
    static JButton logoutButton;

    public static void ShowAdminMenu(String name, int id) {
        JLabel label = new JLabel("Select an option");
        label.setHorizontalAlignment(JLabel.CENTER);
        LibMain.frame.add(label);
        LibMain.frame.setTitle("Main");
        LibMain.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setBounds(280, 70, 175, 30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.RED);
        label.setBorder(BorderFactory.createLineBorder(Color.black));

        int cols = 4; // Number of columns
        int buttonWidth = 180;
        int buttonHeight = 45;
        int buttonGap = 10; // Gap between buttons
        
        // Calculate the total width of buttons in a row
        int totalRowWidth = cols * (buttonWidth + buttonGap) - buttonGap;
        // Calculate the starting x-coordinate for centering the buttons
        int startX = (LibMain.frame.getWidth() - totalRowWidth) / 2;
        
        for (int i = 0; i < names.length; i++) {
            buttons[i] = new JButton(names[i]);
            LibMain.frame.add(buttons[i]);
            int row = i / cols;
            int col = i % cols;
            // Calculate the x-coordinate to center buttons in the second row
            int x = startX + col * (buttonWidth + buttonGap);
            int y = 190 + row * (buttonHeight + buttonGap);
            buttons[i].setBounds(x, y, buttonWidth, buttonHeight);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 16));
        
            final int j = i;
            buttons[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (j) {
                        case 0:
                            AdminFunctions.showBooks();
                            break;
                        case 1:
                            AdminFunctions.viewUsers();
                            break;
                        case 2:
                            AdminFunctions.viewIssuedBooks();
                            break;
                        case 3:
                            AdminFunctions.issueBook();
                            break;
                        case 4:
                            LogAdd.addUser();
                            break;
                        case 5:
                            AdminFunctions.returnBook();
                            break;
                        case 6:
                            AdminFunctions.viewReturnedBooks();
                            break;
                    }
                }
            });
        }
        

        // Adding logout button separately
        logoutButton = new JButton();
        ImageIcon logoutIcon = new ImageIcon("C:\\myWebProject\\LibManSystem\\Admin.java\\src\\logoutbutton.png"); // Specify the correct path to the image file
        
        // Resize the ImageIcon
        Image img = logoutIcon.getImage();
        Image resizedImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoutIcon = new ImageIcon(resizedImg);
        
        logoutButton.setIcon(resizedLogoutIcon);
        LibMain.frame.add(logoutButton);
        int buttonSize = 50; // Adjust the size of the logout button
        logoutButton.setBounds(LibMain.frame.getWidth() - buttonSize - 10, 10, buttonSize, buttonSize); // Adjusted bounds for logout button

        // ActionListener for logout button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminFunctions.logout();
            }
        });
    }
}
