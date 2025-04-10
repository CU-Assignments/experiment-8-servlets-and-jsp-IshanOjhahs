package myjava.exp8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfUsername;
    JPasswordField tfPassword;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchLbl = new JLabel("Admin Login");
        searchLbl.setBounds(180, 20, 350, 50);
        searchLbl.setFont(new Font("serif", Font.BOLD, 40));
        add(searchLbl);

        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setBounds(70, 90, 100, 30);
        usernameLbl.setFont(new Font("serif", Font.PLAIN, 20));
        add(usernameLbl);

        tfUsername = new JTextField();
        tfUsername.setBounds(180, 90, 200, 30);
        add(tfUsername);

        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(70, 150, 100, 30);
        passwordLbl.setFont(new Font("serif", Font.PLAIN, 20));
        add(passwordLbl);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(180, 150, 200, 30);
        add(tfPassword);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(180, 230, 200, 40);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener(this);
        add(loginBtn);

        ImageIcon i1 = new ImageIcon("C:\\Users\\Ishan Ojha\\Downloads\\exp8\\exp8\\icon\\second.jpg");
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 250, 250);
        add(image);

        setVisible(true);
        setSize(700, 400);
        setLocation(650, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfUsername.getText();
            String password = new String(tfPassword.getPassword());  // Convert char[] to String

            conn c = new conn();
            Connection con = c.c;

            // Use PreparedStatement to prevent SQL injection
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Welcome to the system, " + username + "!");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


