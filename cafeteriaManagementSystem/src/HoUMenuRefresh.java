
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
public class HoUMenuRefresh implements Runnable {
    @Override    
    public void run() {
        env env = new env();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteriamanagement", "root", env.Password);
            System.out.println("connected");
            for(int i=1; i<2; i--) {              
                DefaultTableModel tm = (DefaultTableModel) headOfUnitHome.jTable1.getModel();
                tm.setRowCount(0);
                PreparedStatement ps = con.prepareStatement("select * from menu");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String menuItem = rs.getString(1);
                    int portionsAvailable1 = rs.getInt(2);
                    int price1 = rs.getInt(3);

                    String price = String.valueOf(price1);
                    String portionsAvailable = String.valueOf(portionsAvailable1);
                    String[] row = {menuItem, portionsAvailable, price};
                    tm.addRow(row);
                }
                headOfUnitHome.jTable1.setModel(tm);
                //System.out.println("HoU Hey");
                
                Thread.sleep(10000);
           }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

