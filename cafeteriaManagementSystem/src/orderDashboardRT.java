
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
public class orderDashboardRT implements Runnable {
    @Override    
    public void run() {
        env env = new env();
        try {
           for(int i=1; i<2; i--) {              
                DefaultTableModel tm = (DefaultTableModel) headOfUnitHome.jTable2.getModel();
                tm.setRowCount(0);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteriamanagement", "root", env.Password);
                System.out.println("connected");
                
                if ((headOfUnitHome.jComboBox4.getSelectedItem()).toString().equalsIgnoreCase("Order ID")) {
                    PreparedStatement ps = con.prepareStatement("select * from orders");
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        String orderID = String.valueOf(rs.getInt(1));
                        String price = String.valueOf(rs.getInt(2));
                        String paymentMethod = rs.getString(3);
                        String status = rs.getString(4);
                        String date = String.valueOf(rs.getDate(5));
                        
                        String[] row = {orderID, price, paymentMethod, status, date};
                        tm.addRow(row);
                    }
                
                }else if ((headOfUnitHome.jComboBox4.getSelectedItem()).toString().equalsIgnoreCase("Total Price")) {
                    PreparedStatement ps = con.prepareStatement("select * from orders order by total_price");
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        String orderID = String.valueOf(rs.getInt(1));
                        String price = String.valueOf(rs.getInt(2));
                        String paymentMethod = rs.getString(3);
                        String status = rs.getString(4);
                        String date = String.valueOf(rs.getDate(5));
                        
                        String[] row = {orderID, price, paymentMethod, status, date};
                        tm.addRow(row);
                    }
                }else if ((headOfUnitHome.jComboBox4.getSelectedItem()).toString().equalsIgnoreCase("Payment Method")) {
                    PreparedStatement ps = con.prepareStatement("select * from orders order by payment_method");
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        String orderID = String.valueOf(rs.getInt(1));
                        String price = String.valueOf(rs.getInt(2));
                        String paymentMethod = rs.getString(3);
                        String status = rs.getString(4);
                        String date = String.valueOf(rs.getDate(5));
                        
                        String[] row = {orderID, price, paymentMethod, status, date};
                        tm.addRow(row);
                    }
                }else if ((headOfUnitHome.jComboBox4.getSelectedItem()).toString().equalsIgnoreCase("Order Status")) {
                    PreparedStatement ps = con.prepareStatement("select * from orders order by status");
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        String orderID = String.valueOf(rs.getInt(1));
                        String price = String.valueOf(rs.getInt(2));
                        String paymentMethod = rs.getString(3);
                        String status = rs.getString(4);
                        String date = String.valueOf(rs.getDate(5));
                        
                        String[] row = {orderID, price, paymentMethod, status, date};
                        tm.addRow(row);
                    }
                }else if ((headOfUnitHome.jComboBox4.getSelectedItem()).toString().equalsIgnoreCase("Date")) {
                    PreparedStatement ps = con.prepareStatement("select * from orders order by order_date");
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        String orderID = String.valueOf(rs.getInt(1));
                        String price = String.valueOf(rs.getInt(2));
                        String paymentMethod = rs.getString(3);
                        String status = rs.getString(4);
                        String date = String.valueOf(rs.getDate(5));
                        
                        String[] row = {orderID, price, paymentMethod, status, date};
                        tm.addRow(row);
                    }
                }
                headOfUnitHome.jTable5.setVisible(false);
                headOfUnitHome.jScrollPane6.setVisible(false);
            
                
                headOfUnitHome.jTable2.setModel(tm);
                //System.out.println("HoU Order DB Hey");
                
                Thread.sleep(10000);
           }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}


