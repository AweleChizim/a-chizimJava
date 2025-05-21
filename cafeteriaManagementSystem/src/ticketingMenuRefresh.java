
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
public class ticketingMenuRefresh implements Runnable {
    @Override    
    public void run() {
        env env = new env();
        try {
           for(int i=1; i<2; i--) {              
                DefaultTableModel tm = (DefaultTableModel) ticketingHome.jTable1.getModel();
                tm.setRowCount(0);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteriamanagement", "root", env.Password);
                System.out.println("connected");
                PreparedStatement ps = con.prepareStatement("select * from menu");
                ResultSet rs = ps.executeQuery();
                int count = 0;
                while (rs.next()) {
                    String menuItem = rs.getString(1);
                    int portionsAvailable1 = rs.getInt(2);
                    int price1 = rs.getInt(3);

                    String price = String.valueOf(price1);
                    String portionsAvailable = String.valueOf(portionsAvailable1);
                    String[] row = {menuItem, portionsAvailable, price};
                    if (portionsAvailable1 < 5) {
                        count = count + 1;
                        ticketingHome.jScrollPane2.setVisible(true);
                        ticketingHome.jTextArea1.setVisible(true);
                        ticketingHome.jLabel2.setVisible(true);
                        ticketingHome.jTextArea1.append(menuItem + " restock needed!\n");
                    }
                    tm.addRow(row);
                    if (count == 0) {
                        ticketingHome.jScrollPane2.setVisible(false);
                        ticketingHome.jTextArea1.setVisible(false);
                        ticketingHome.jLabel2.setVisible(false);
                        ticketingHome.jTextArea1.append("");
                    }
                }
                ticketingHome.jTable1.setModel(tm);
                //System.out.println("ticketing Hi");
                
                Thread.sleep(10000);
           }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
