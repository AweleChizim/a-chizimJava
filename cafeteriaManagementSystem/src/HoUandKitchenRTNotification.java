
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chizi
 */
public class HoUandKitchenRTNotification implements Runnable {
    @Override    
    public void run() {
        env env = new env();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteriamanagement", "root", env.Password);
            System.out.println("connected");
            for(int i=1; i<2; i--) {    
                List<String> menuItems = new ArrayList<>();
                List<String> emails = new ArrayList<>();
                PreparedStatement ps = con.prepareStatement("select * from menu");
                PreparedStatement ps2 = con.prepareStatement("select * from staff");
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    String email = rs2.getString(2);
                    if ((rs2.getString(7)).equalsIgnoreCase("Kitchen") || (rs2.getString(7)).equalsIgnoreCase("Head of Unit")) {
                        emails.add(email);
                    }
                }
                Iterator<String> it = emails.iterator();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int portionsAvailable1 = rs.getInt(2);                    
                    if (portionsAvailable1 < 5) {
                        String menuItem = rs.getString(1);
                        menuItems.add(menuItem);
                    }
                }  
                String items = String.join("\n", menuItems);
                String popup = (String.join(", ", menuItems)).toUpperCase();
                while (it.hasNext()) {
                    String receiver = it.next();
                    String subject = "ALERT! Menu Item Portions Running Low!";
                    String text = "The following menu items are running low:\n[menuItems_here]\n\nPlease restock immediately!\n\n\nAGC";
                    String body = text.replace("[menuItems_here]", items.toUpperCase());
                    String senderEmail = "chizimawele@gmail.com";
                    String senderPassword = "craqfussrsiirinn";

                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");

                    Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(senderEmail, senderPassword);
                            }
                        });

                    try {
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(senderEmail));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
                        message.setSubject(subject);
                        message.setText(body);
                        Transport.send(message);
                        System.out.println("Email Sent");
                        JOptionPane.showMessageDialog(null, "Running Low!!! " + popup, "ALERT", 1);
                    } catch (MessagingException e) {
                        System.out.println(e);
                    }
                }
                   
                //System.out.println("Email & PopUp Notification");
                
                Thread.sleep(60000);
                Thread.sleep(60000);
                Thread.sleep(60000);
           }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}