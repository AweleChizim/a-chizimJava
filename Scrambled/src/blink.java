
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chizi
 */
public class blink implements Runnable {
    @Override
    public void run() {
        try {
           for(;;) {
               scrambled.jLabel6.setForeground(Color.black);
               Thread.sleep(1000);
               scrambled.jLabel6.setForeground(Color.white);
               Thread.sleep(1000);
               scrambled.jLabel6.setForeground(Color.black);
               Thread.sleep(1000);
               scrambled.jLabel6.setForeground(Color.white);
               Thread.sleep(1000);
               scrambled.jLabel6.setForeground(Color.black);
               Thread.sleep(1000);
               scrambled.jLabel6.setForeground(Color.white);
               Thread.sleep(1000);
           }
        } catch (Exception e) {
        
        }
    }
}
