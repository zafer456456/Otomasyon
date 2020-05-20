/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtomasyonOdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Zafer
 */
public class VeriTabaniIslemleri {

    public String kulad="root";
    public String parola="";
    public String db_name="javaodev";
    public String host="localhost";
    public int port=3306;
    public Connection con=null;
    public PreparedStatement prstatement=null;
    public ResultSet rs;
    
    public VeriTabaniIslemleri()
    {
     String url="jdbc:mysql://"+host+":"+port+"/"+db_name+"?characterEncoding=utf8";
    try {
          Class.forName("com.mysql.jdbc.Driver"); 
          con=DriverManager.getConnection(url, kulad, parola); 
          System.out.println("Bağlantı başarılı");
        } catch (ClassNotFoundException e) { 
     
            System.out.println("Driver bulunamadı");
        } catch (SQLException ex) {  
          
            System.out.println("Bağlantı başarısız");
        }
    }
    //veri çekme
    public ResultSet Cekme(String Sorgu)
    {
        try {
            prstatement = con.prepareStatement(Sorgu);
            rs = prstatement.executeQuery();
        }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"İşlem Başarısız");
       }
    return rs;
    }
       public ResultSet Cekme(String Sorgu,String veri1)
    {
        try {
            prstatement = con.prepareStatement(Sorgu);
            prstatement.setString(1,veri1);
            rs = prstatement.executeQuery();
        }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"İşlem Başarısız");
       }
    return rs;
    }
          public ResultSet Cekme(String Sorgu,String veri1,String veri2)
    {
        try {
            prstatement = con.prepareStatement(Sorgu);
            prstatement.setString(1,veri1);
            prstatement.setString(2,veri2);
            rs = prstatement.executeQuery();
        }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"İşlem Başarısız");
       }
    return rs;
    }
    public ResultSet Cekme(String Sorgu,String veri1,String veri2,String veri3)
    {
        try {
            prstatement = con.prepareStatement(Sorgu);
            prstatement.setString(1,veri1);
            prstatement.setString(2,veri2);
            prstatement.setString(3,veri3);
            rs = prstatement.executeQuery();
        }
       catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Çekme İşlemi Başarısız");
       }
    return rs;
    }
    //veri çekme bitiş
    public boolean Kullaniciekle(String KulAd,String KulSifre){
    String sorgu="Insert into kullanici(KullaniciAdi,KullaniciSifre) values(?,?)";
    try {
        prstatement=con.prepareStatement(sorgu);
        prstatement.setString(1,KulAd);
        prstatement.setString(2,KulSifre);
        prstatement.executeUpdate();
        return true;    
        } 
    catch (SQLException ex) {
         Logger.getLogger(Icerik.class.getName()).log(Level.SEVERE, null, ex);
         return false;    
        }
    }
    public boolean KullaniciGuncelle(String KullaniciAd,String KullaniciSifre,String KullaniciId){
     String sorgu="Update kullanici set KullaniciAdi=?,KullaniciSifre=? where KullaniciID=?";
    try {
        prstatement=con.prepareStatement(sorgu);
        prstatement.setString(1,KullaniciAd);
        prstatement.setString(2,KullaniciSifre);
        prstatement.setString(3,KullaniciId);
        prstatement.executeUpdate();
        return true;
       } catch (SQLException ex) {
         Logger.getLogger(Icerik.class.getName()).log(Level.SEVERE, null, ex);
        return false;
       }    
    }
    public boolean KullaniciSilme(String KullaniciId)
    {
     String sorgu="Delete From kullanici where KullaniciID=?";
    try {
        prstatement=con.prepareStatement(sorgu);
        prstatement.setString(1, KullaniciId);
        prstatement.executeUpdate();
        return true;
        } catch (SQLException ex) {
        Logger.getLogger(Icerik.class.getName()).log(Level.SEVERE, null, ex);
        return false;
        }
    }
}
