
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
public class staffActivitiesDashboardRT implements Runnable {
    @Override    
    public void run() {
        env env = new env();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteriamanagement", "root", env.Password);
            System.out.println("connected sadrt");
                
           for(int i=1; i<2; i--) {              
                DefaultTableModel tm = (DefaultTableModel) headOfUnitHome.jTable3.getModel();
                tm.setRowCount(0);
                
                PreparedStatement ps = con.prepareStatement("select * from updated_menu");
                ResultSet rs = ps.executeQuery();                    
                while (rs.next()) {
                    String name = rs.getString(4);
                    PreparedStatement ps3 = con.prepareStatement("select role from staff where name = ?");
                    ps3.setString(1, name);
                    ResultSet rs3 = ps3.executeQuery();                    

                    String role = null;
                    while (rs3.next()) {
                        role = rs3.getString(1);
                    }
                    String action = rs.getString(5) + " " + rs.getString(2) + " (Qty: " + rs.getString(3) + ")";
                    String date = String.valueOf(rs.getDate(6));

                    String[] row = {name, role, action, date};
                    tm.addRow(row);
                }

                PreparedStatement ps2 = con.prepareStatement("select * from orders");
                ResultSet rs2 = ps2.executeQuery();                    
                while (rs2.next()) {
                    String name1 = rs2.getString(6);
                    String name2 = rs2.getString(7);
                    String action1 = "Logged Order No " + String.valueOf(rs2.getInt(1));
                    String role1 = "Ticketing";
                    String role2 = "Server";
                    String date = String.valueOf(rs2.getDate(5));
                    String[] row1 = {name1, role1, action1, date};
                    tm.addRow(row1);
                    if (name2 != null) {
                        String action2 = "Served Order No " + String.valueOf(rs2.getInt(1));
                        String[] row2 = {name2, role2, action2, date};                        
                        tm.addRow(row2);
                    }                    
                }

                headOfUnitHome.jTable5.setVisible(false);
                headOfUnitHome.jScrollPane6.setVisible(false);
            
                
                headOfUnitHome.jTable3.setModel(tm);
                System.out.println("HoU Staff Activities DB Hey");
                
                Thread.sleep(10000);
           }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



