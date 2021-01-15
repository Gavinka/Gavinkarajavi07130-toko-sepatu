package View;
import Entity.SepatuEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
public class Gavinka07130_PembeliGUI {
    JFrame Pembeli = new JFrame();
    JButton back,daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarsepatu;
    JComboBox piltas = new JComboBox(SepatuEntity.Sepatu);
    int cek = Gavinka07130_Allobjctrl.pembeli.cekDaftarPembeli
        (Gavinka07130_Allobjctrl.pembeli.getData().getId());
    
    public Gavinka07130_PembeliGUI(){
        Pembeli.setSize(720, 600);
        Pembeli.setLayout(null);
        Pembeli.getContentPane().setBackground(Color.RED);
        
        datadiri = new JLabel("Data Pembeli");
        datadiri.setFont(new Font("Timer New Roman",Font.BOLD,30));
        datadiri.setBounds(90, 30, 200, 30);
        Pembeli.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pembeli.add(area);
        
        daftarsepatu = new JLabel("Daftar sepatu");
        daftarsepatu.setBounds(450, 30, 250, 30);
        daftarsepatu.setFont(new Font("Times New Roman",Font.BOLD,30));
        Pembeli.add(daftarsepatu);
        piltas.setBounds(450, 90, 230, 30);
        Pembeli.add(piltas);
        
        daftarbtn = new JButton("Beli");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GRAY);
        Pembeli.add(daftarbtn);
        
        back = new JButton("Back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.GRAY);
        Pembeli.add(back);
        
        Pembeli.setVisible(true);
        Pembeli.setLocationRelativeTo(null);
        Pembeli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(cek==-1){
            JOptionPane.showMessageDialog(null, "Anda Belum Memilih Sepatu", "Information", JOptionPane.INFORMATION_MESSAGE);        
        }else if(cek==-2){
            JOptionPane.showMessageDialog(null,"Anda Belum Memilih Sepatu", "Information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            area.setText(datapembeli());
        }
        daftarbtn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae){
            int indexSepatu = piltas.getSelectedIndex();
            Gavinka07130_Allobjctrl.pembeli.DaftarPembeli
            (indexSepatu,Gavinka07130_Allobjctrl.pembeli.getData(), false);
            area.setText(datapembeli());
        }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Pembeli.dispose();
                Gavinka07130_GUI men = new Gavinka07130_GUI(); //nama objek menu
            }
        });
    }
    
    String datapembeli(){
        int cek = Gavinka07130_Allobjctrl.pembeli.cekDaftarPembeli
        (Gavinka07130_Allobjctrl.pembeli.getData().getId());
        String cekverif; //untuk verivikasi data berdasarkan id
        if(Gavinka07130_Allobjctrl.pembeli.showDaftarPembeli(cek).isIsVerified()==false){
            cekverif = "belum diverifikasi";
        }else{
            cekverif = "sudah diverifikasi";
        }
         String text = "Id : "+Gavinka07130_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getId()+"\n"
                +"Nama : "+Gavinka07130_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getnama()+"\n"
                +"Alamat : "+Gavinka07130_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getalamat()+"\n"
                +"No Pembeli : "+Gavinka07130_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getnoIdentitas()+"\n"
                +"No Telp : "+Gavinka07130_Allobjctrl.pembeli.showDaftarPembeli(cek).getPembeli().getnotelp()+"\n"
                +"Verifikasi : "+cekverif+"\n"
                +"Sepatu : "+SepatuEntity.Sepatu[Gavinka07130_Allobjctrl.pembeli.showDaftarPembeli(cek).getIndexSepatu()];
        return text;
    }
    }