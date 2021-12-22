package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginGui extends ComponentGui {
    JButton btnloginadmin = new JButton();
    String pathicon;
    public LoginGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelemail.setBounds(35, 250, 40, 25);
        add(labelemail);
        fieldemail.setBounds(130, 250, 130, 25);
        add(fieldemail);
        
        labelpassword.setBounds(35, 290, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 290, 130, 25);
        add(fieldpassword);
        
        btnlogin.setBounds(110, 350, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);
        
        btnnotreg.setBounds(70, 400, 180, 25);
        btnnotreg.setBorder(null);
        btnnotreg.setBackground(Color.white);
        add(btnnotreg);
        
        btnloginadmin.setBounds(0, 405, 20, 20);
        btnloginadmin.setBorder(null);
        btnloginadmin.setBackground(Color.black);
        add(btnloginadmin);
        
        bingkaigambar.setBounds(80,70,150,150);
        add(bingkaigambar);
        
        pathicon = "E:\\ITATS\\Semester 3\\Java\\aplicationGojek\\src\\Images\\gojek.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(150, 150,    Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        btnloginadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginAdminGui loginAdminGui = new LoginAdminGui();
                loginAdminGui.setVisible(true);
            }
        });
        
        btnnotreg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                btnnotreg.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnnotreg.setForeground(Color.black);
            }
        });
        btnnotreg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegisterGui().setVisible(true);
            }
        });
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String email = fieldemail.getText();
                String password = fieldpassword.getText();
                int cek = AllObjectController.user.login(email, password);
                if(cek > 0){
                    int cekverif = AllObjectController.user.verif(cek);
                    if(cekverif != 0){
                        dispose();
                        UserGui mahasiswaGui = new UserGui(cek);
                        mahasiswaGui.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "AKUN BELUM DI VERIFIKASI ADMIN");
                        kosong();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}
