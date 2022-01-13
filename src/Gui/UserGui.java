package Gui;

import Controller.*;
import Entity.UserEntity;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserGui extends JFrame {
    int id;
    int status;
    String nama, email, password, notelp, gambar, namagambar, path;
    String filemove = "./src/Images/";
    
    File file;
    public UserGui(int cek){
        initComponent(cek);
    }
    
    protected JButton btnback = new JButton("<< LOG OUT");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labelemail = new JLabel("EMAIL");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldemail = new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JTextField fieldnotelp = new JTextField();
    protected JLabel bingkaigambar = new JLabel();
    protected JButton btnubahnama = new JButton("Ubah");
    protected JButton btnubahemail = new JButton("Ubah");
    protected JButton btnubahpassword = new JButton("Ubah");
    protected JButton btnubahnotelp = new JButton("Ubah");
    protected JButton btnubahgambar = new JButton("Upload");
    BufferedImage bufferedImage = null;
    Image gambarresize;
    
    void initComponent(final int cek){
        for(UserEntity userEntities : AllObjectController.user.getById(cek)) {
            this.id       = userEntities.getId();
            this.nama     = userEntities.getNama();
            this.email    = userEntities.getEmail();
            this.password = userEntities.getPassword();
            this.notelp   = userEntities.getnoTelp();
            this.status   = userEntities.getStatus();
            this.gambar   = userEntities.getGambar();
        }
        
        setTitle("PROGRAM VERIF USER");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        labelnama.setBounds(25, 50, 40, 25);
        add(labelnama);
        fieldnama.setBounds(120, 50, 100, 25);
        fieldnama.setText(nama);
        fieldnama.setEditable(false);
        add(fieldnama);
        
        labelemail.setBounds(25, 90, 40, 25);
        add(labelemail);
        fieldemail.setBounds(120, 90, 100, 25);
        fieldemail.setText(email);
        fieldemail.setEditable(false);
        add(fieldemail);
        
        labelpassword.setBounds(25, 135, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(120, 135, 100, 25);
        fieldpassword.setText(password);
        fieldpassword.setEditable(false);
        add(fieldpassword);
        
        labelnotelp.setBounds(25, 180, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(120, 180, 100, 25);
        fieldnotelp.setText(notelp);
        fieldnotelp.setEditable(false);
        add(fieldnotelp);
        
        bingkaigambar.setBounds(50, 225, 150, 200);
        add(bingkaigambar);
        
        btnubahnama.setBounds(245, 50, 80, 25);
        btnubahemail.setBounds(245, 90, 80, 25);
        btnubahpassword.setBounds(245, 135, 80, 25);
        btnubahnotelp.setBounds(245, 180, 80, 25);
        btnubahgambar.setBounds(245, 325, 80, 25);
        
        add(btnubahnama);
        add(btnubahemail);
        add(btnubahpassword);
        add(btnubahnotelp);
        add(btnubahgambar);
        
        String pict = filemove+gambar;
        System.out.println("pict");
        if(this.gambar != null){
            try{
                bufferedImage = ImageIO.read(new File(pict));
            } catch (IOException ex){
                Logger.getLogger(UserGui.class.getName()).log(Level.SEVERE, null,ex);
            }
            
            gambarresize = bufferedImage.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            bingkaigambar.setIcon(new  ImageIcon(gambarresize));
        }
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LoginGui loginGui = new LoginGui();
                loginGui.setVisible(true);
                dispose();
            }
        });
        
        btnubahnama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputnama = JOptionPane.showInputDialog("Massukkan Nama Baru");
                    if(inputnama.length() > 0){
                        AllObjectController.user.updateData(1, inputnama, cek);
                        fieldnama.setText(inputnama);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahemail.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputemail = JOptionPane.showInputDialog("Masukan Email Baru");
                    if(inputemail.length() > 0){
                        AllObjectController.user.updateData(2, inputemail, cek);
                        fieldemail.setText(inputemail);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController.user.updateData(3, inputpass, cek);
                        fieldpassword.setText(inputpass);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahnotelp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputNoTelp = JOptionPane.showInputDialog("Masukan Nomor Telepon Baru");
                    if(inputNoTelp.length() > 0){
                        AllObjectController.user.updateData(5, inputNoTelp, cek);
                        fieldnotelp.setText(inputNoTelp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnubahgambar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filterekstensi = new FileNameExtensionFilter("Gambar","jpg","png","gif");
            chooser.addChoosableFileFilter(filterekstensi);
            int status = chooser.showOpenDialog(null);
            if(status == JFileChooser.APPROVE_OPTION){
                file = chooser.getSelectedFile();
                File destinasi = new File(filemove.concat(email + ".jpg"));
                try{
                    Files.move(file.toPath(), destinasi.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    namagambar = destinasi.getName();
                    path = destinasi.getAbsolutePath();
                    try{
                        bufferedImage = ImageIO.read(new File(path));
                    } catch(IOException ex) {
                        Logger.getLogger(UserGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                gambarresize = bufferedImage.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
                bingkaigambar.setIcon(new ImageIcon(gambarresize));
                AllObjectController.user.updateData(4, namagambar, cek);
            } else if (status == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "Tidak Memilih Gambar");
            }
            }
        });
    }
}
