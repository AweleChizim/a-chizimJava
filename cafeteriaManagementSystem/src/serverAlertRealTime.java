
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chizi
 */
public class serverAlertRealTime implements Runnable {
    @Override    
    public void run() {
        env env = new env();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteriamanagement", "root", env.Password);
            System.out.println("connected");
            for(int i=1; i<2; i--) {              
            PreparedStatement ps = con.prepareStatement("select * from menu");
                ResultSet rs = ps.executeQuery();
                int count = 0;
                
                while (rs.next()) {
                    String menuItem = rs.getString(1);
                    int portionsAvailable1 = rs.getInt(2);
                    
                    if (portionsAvailable1 < 5) {
                        count = count + 1;
                        serverHome.jScrollPane2.setVisible(true);
                        serverHome.jTextArea1.setVisible(true);
                        serverHome.jLabel6.setVisible(true);
                        serverHome.jTextArea1.append(menuItem + " restock needed!\n");
                    }
                    if (count == 0) {
                        serverHome.jScrollPane2.setVisible(false);
                        serverHome.jTextArea1.setVisible(false);
                        serverHome.jLabel6.setVisible(false);
                        serverHome.jTextArea1.append("");
                    }
                }
                //System.out.println("HoU Hey");
                
                Thread.sleep(10000);
           }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}


