/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Date;
/**
 *
 * @author chizi
 */
public class timer implements Runnable {
    @Override
    public void run() {
        try {
            for(int i = 0; i<3; i--) {
               scrambled.jLabel6.setText(new Date().toString());
            }         
        } catch (Exception e) {        
        }
    }
}
