package Gui;

import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterAdminGui extends JFrame {
    public RegisterAdminGui(){
        initComponent();
    }
    
    protected JLabel labelregister = new JLabel("REGISTER");
    protected JLabel labelemail = new JLabel("EMAIL");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldemail = new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JTextField fieldnotelp = new JTextField();
    protected JButton btnregister = new JButton("REGISTRASI ?");
    
    void kosong(){
        fieldnama.setText(null);
        fieldemail.setText(null);
        fieldpassword.setText(null);
        fieldnotelp.setText(null);
    }
    
    void initComponent(){
        setTitle("Register Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelregister.setText("REGISTER ADMIN");
        labelregister.setBounds(100, 50, 110, 25);
        add(labelregister);
        labelnama.setBounds(35, 95, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 95, 130, 25);
        add(fieldnama);
        
        labelemail.setBounds(35, 140, 80, 25);
        add(labelemail);
        fieldemail.setBounds(130, 140, 130, 25);
        add(fieldemail);
        
        labelpassword.setBounds(35, 185, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 185, 130, 25);
        add(fieldpassword);
        
        labelnotelp.setBounds(35, 230, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 230, 130, 25);
        add(fieldnotelp);
        
        btnregister.setBounds(80, 350, 140, 25);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        btnregister.setFocusPainted(false);
        add(btnregister);
        
        btnregister.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnregister.setForeground(Color.black);
                btnregister.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnregister.setForeground(Color.white);
                btnregister.setBackground(Color.black);
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nama = fieldnama.getText();
                String email = fieldemail.getText();
                String password = fieldpassword.getText();
                String notelp = fieldnotelp.getText();
                if(nama.length() != 0 && email.length() != 0 && password.length() != 0 && notelp.length() != 0){
                    AllObjectController.admin.insertData(nama, email, password, notelp);
                    JOptionPane.showMessageDialog(null, nama + "Adalah Admin");
                    dispose();
                    new LoginAdminGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
