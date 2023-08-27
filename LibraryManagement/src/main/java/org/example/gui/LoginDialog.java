package org.example.gui;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginDialog extends JDialog implements ActionListener, KeyListener {

    private final JTextField txtUsername;
    private final UserDao userDao = new UserDaoImpl();
    private final JPasswordField txtPassword;
    private final JButton btnLogin, btnCancel;
    private boolean loggedIn;

    public LoginDialog(JFrame parent) {
        super(parent, "Đăng nhập", true);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 55, 200, 200, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 29, 40, 40, 30, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);

        GridBagConstraints gbc_lblTenDN = new GridBagConstraints();
        gbc_lblTenDN.fill = GridBagConstraints.BOTH;
        gbc_lblTenDN.insets = new Insets(0, 0, 5, 5);
        gbc_lblTenDN.gridx = 1;
        gbc_lblTenDN.gridy = 1;
        JLabel lblTenDN = new JLabel("Tên đăng nhập: ");
        getContentPane().add(lblTenDN, gbc_lblTenDN);

        txtUsername = new JTextField(20);
        GridBagConstraints gbc_txtUsername = new GridBagConstraints();
        gbc_txtUsername.fill = GridBagConstraints.BOTH;
        gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
        gbc_txtUsername.gridx = 2;
        gbc_txtUsername.gridy = 1;
        getContentPane().add(txtUsername, gbc_txtUsername);
        btnCancel = new JButton("Hủy bỏ");
        btnCancel.addActionListener(this);
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.fill = GridBagConstraints.BOTH;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 1;
        gbc_lblPassword.gridy = 2;
        JLabel lblPassword = new JLabel("Mật khẩu: ");
        getContentPane().add(lblPassword, gbc_lblPassword);
        txtPassword = new JPasswordField(20);
        GridBagConstraints gbc_txtPassword = new GridBagConstraints();
        gbc_txtPassword.fill = GridBagConstraints.BOTH;
        gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
        gbc_txtPassword.gridx = 2;
        gbc_txtPassword.gridy = 2;
        getContentPane().add(txtPassword, gbc_txtPassword);
        btnLogin = new JButton("Đăng nhập");

        btnLogin.addActionListener(this);
        GridBagConstraints gbc_btnLogin = new GridBagConstraints();
        gbc_btnLogin.fill = GridBagConstraints.BOTH;
        gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
        gbc_btnLogin.gridx = 1;
        gbc_btnLogin.gridy = 3;
        getContentPane().add(btnLogin, gbc_btnLogin);
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
        gbc_btnCancel.fill = GridBagConstraints.BOTH;
        gbc_btnCancel.gridx = 2;
        gbc_btnCancel.gridy = 3;
        getContentPane().add(btnCancel, gbc_btnCancel);

        txtUsername.setText("admin1");
        txtPassword.setText("123");

        setSize(500, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        txtUsername.addKeyListener(this);
        txtPassword.addKeyListener(this);
    }





    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());

            if (userDao.checkLogin(username,password)) {
                setVisible(false);
                new Application().getFrame().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập và mật khẩu không đúng", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnCancel) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
