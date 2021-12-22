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

public class LoginAdminGui extends ComponentGui {
    JButton btnloginuser = new JButton("LOGIN AS USER ?");
    String pathicon;
    public LoginAdminGui(){
        initComponent();
    }
    
    void initComponent(){
        setTitle("Login Admin");
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
        
        btnloginuser.setBounds(70, 400, 180, 25);
        btnloginuser.setBorder(null);
        btnloginuser.setBackground(Color.white);
        add(btnloginuser);
        
        bingkaigambar.setBounds(80, 70, 150, 150);
        add(bingkaigambar);
        
        pathicon = "E:\\ITATS\\Semester 3\\Java\\aplicationGojek\\src\\Images\\gojek.png";
        
        try{
            bufferedImage = ImageIO.read(new File(pathicon));
        } catch (IOException ex) {
            Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        gambarresize = bufferedImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        bingkaigambar.setIcon(new ImageIcon(gambarresize));
        
        btnloginuser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnloginuser.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnloginuser.setForeground(Color.black);
            }
        });
        
        btnloginuser.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               dispose();
               new LoginGui().setVisible(true);
           }
        });
        
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.green);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });
        
        btnlogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String email = fieldemail.getText();
                String password = fieldpassword.getText();
                int cek = AllObjectController.admin.login(email, password);
                if(cek > 0){
                    dispose();
                    AdminGui adminGui = new AdminGui(cek);
                    adminGui.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}