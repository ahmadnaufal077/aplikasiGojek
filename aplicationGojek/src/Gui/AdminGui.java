package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdminGui extends ComponentGui {
    JTable tabeluser = new JTable();
    JScrollPane spuser = new JScrollPane(tabeluser);
    JTextField textpilih = new JTextField();
    int kode;
    
    public AdminGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(final int cek){
        setTitle("PROGRAM VERIF USER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        spuser.setBounds(20, 50, 500, 350);
        tabeluser.setModel(AllObjectController.user.daftarUser());
        add(spuser);
        
        btnverif.setBounds(540, 50, 110, 25);
        btnverif.setFocusPainted(false);
        btnverif.setBorder(null);
        btnverif.setBackground(Color.black);
        btnverif.setForeground(Color.white);
        add(btnverif);
        
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnubahpassword.setText("UBAH PASSWORD");
        btnubahpassword.setBounds(540, 140, 110, 25);
        btnubahpassword.setFocusPainted(false);
        btnubahpassword.setBorder(null);
        btnubahpassword.setBackground(Color.black);
        btnubahpassword.setForeground(Color.white);
        add(btnubahpassword);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnregister.setText("REGIST ADMIN");
        btnregister.setBounds(540, 185, 110, 25);
        btnregister.setFocusPainted(false);
        btnregister.setBorder(null);
        btnregister.setBackground(Color.black);
        btnregister.setForeground(Color.white);
        add(btnregister);
        
        tabeluser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabeluser.getSelectedRow();
                textpilih.setText(AllObjectController.user.daftarUser().getValueAt(i, 0).toString());
            }
        });
        
        btnverif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.admin.verifUser(kode);
                JOptionPane.showMessageDialog(null, "Berhasil Verifikasi");
                tabeluser.setModel(AllObjectController.user.daftarUser());
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.admin.deleteData(kode);
                tabeluser.setModel(AllObjectController.user.daftarUser());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
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
                LoginAdminGui loginAdminGui = new LoginAdminGui();
                loginAdminGui.setVisible(true);
                dispose();
            }
        });
        
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController.admin.updatePassword(inputpass, cek);
                        JOptionPane.showMessageDialog(null, "Berhasil Ubah Password");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btnregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                RegisterAdminGui registerAdminGui = new RegisterAdminGui();
                registerAdminGui.setVisible(true);
                dispose();
            }
        });
    } 
}
