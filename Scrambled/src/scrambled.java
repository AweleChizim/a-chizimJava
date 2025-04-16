
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author chizi
 */
public class scrambled extends javax.swing.JFrame {
    String[][] words = {
        {"Abundant", "Existing or available in large quantities"},
        {"Benevolent", "Kind and generous"},
        {"Catalyst", "Something that causes change or action"},
        {"Divergent", "Moving or extending in different directions"},
        {"Ephemeral", "Lasting for a very short time"},
        {"Facetious", "Treating serious issues with inappropriate humor"},
        {"Gargantuan", "Enormous or gigantic in size"},
        {"Hapless", "Unlucky or unfortunate"},
        {"Iconoclast", "A person who attacks cherished beliefs or institutions"},
        {"Juxtapose", "To place side by side for comparison"},
        {"Kindle", "To ignite or inspire"},
        {"Labyrinth", "A complex and confusing network of passages"},
        {"Meticulous", "Showing great attention to detail"},
        {"Nebulous", "Unclear, vague, or ill-defined"},
        {"Ostracize", "To exclude or banish from a group or society"},
        {"Pernicious", "Causing harm or ruin; deadly"},
        {"Quixotic", "Unrealistic and impractical"},
        {"Resilient", "Able to recover quickly from difficult conditions"},
        {"Serendipity", "The occurrence of events by chance in a happy or beneficial way"},
        {"Tenacious", "Holding fast, persistent, stubborn"},
        {"Ubiquitous", "Present, appearing, or found everywhere"},
        {"Vicarious", "Experienced in the imagination through the feelings or actions of another person"},
        {"Whimsical", "Playfully quaint or fanciful in an appealing way"},
        {"Xenophobia", "Fear or hatred of foreigners or strangers"},
        {"Yearn", "To have an intense longing or desire"},
        {"Zenith", "The highest point or peak"},
        {"Altruistic", "Showing a selfless concern for the well-being of others"},
        {"Belligerent", "Hostile and aggressive"},
        {"Conundrum", "A confusing and difficult problem or question"},
        {"Deleterious", "Causing harm or damage"},
        {"Enigma", "A person or thing that is mysterious, puzzling, or difficult to understand"},
        {"Fluctuate", "To vary or change irregularly"},
        {"Garrulous", "Excessively talkative, especially on trivial matters"},
        {"Hackneyed", "Lacking significance due to overuse or repetition"},
        {"Ineffable", "Too great or extreme to be expressed or described in words"},
        {"Juxtaposition", "The fact of two things being seen or placed close together with contrasting effect"},
        {"Kindle", "To light or set on fire"},
        {"Languid", "Displaying or having a disinclination for physical exertion or effort"},
        {"Mellifluous", "Sweet or musical; pleasant to hear"},
        {"Nonchalant", "Feeling or appearing casually calm and relaxed"},
        {"Obfuscate", "To deliberately make something unclear or confusing"},
        {"Pernicious", "Having a harmful effect, especially in a gradual or subtle way"},
        {"Querulous", "Complaining in a petulant or whining manner"},
        {"Reticent", "Not revealing one's thoughts or feelings readily"},
        {"Salient", "Most noticeable or important"},
        {"Taciturn", "Reserved or uncommunicative in speech; saying little"},
        {"Unanimous", "Fully in agreement or showing complete agreement"},
        {"Vacillate", "To waver in decision or opinion"},
        {"Wistful", "Having or showing a feeling of vague or regretful longing"},
        {"Xenial", "Friendly, relating to hospitality"},
        {"Yearning", "A feeling of intense longing for something"},
        {"Zen", "A state of calm attentiveness in which one's actions are guided by intuition rather than by conscious effort"},
        {"Abate", "To lessen or reduce in intensity"},
        {"Benevolent", "Showing kindness and goodwill"},
        {"Cacophony", "A harsh, discordant mixture of sounds"},
        {"Debilitate", "To weaken or enfeeble"},
        {"Eclectic", "Deriving ideas or style from a broad range of sources"},
        {"Facade", "The front of a building, or a superficial appearance"},
        {"Garrulous", "Excessively talkative, especially on trivial matters"},
        {"Halcyon", "Denoting a period of time in the past that was idyllically happy"},
        {"Idiosyncrasy", "A mode of behavior or way of thought peculiar to an individual"},
        {"Juxtapose", "To place side by side for contrast"},
        {"Kinetic", "Relating to or resulting from motion"},
        {"Laconic", "Using very few words"},
        {"Mellifluous", "Sweet or musical; pleasant to hear"},
        {"Nefarious", "Wicked or criminal"},
        {"Ostentatious", "Showy; designed to impress"},
        {"Paradigm", "A typical example or pattern of something"},
        {"Quixotic", "Exceedingly idealistic; unrealistic and impractical"},
        {"Recalcitrant", "Having an obstinately uncooperative attitude"},
        {"Sanguine", "Optimistic or positive, especially in a bad situation"},
        {"Taciturn", "Reserved or uncommunicative in speech"},
        {"Ubiquitous", "Present, appearing, or found everywhere"},
        {"Vicarious", "Experienced in the imagination through the feelings of another"},
        {"Wizened", "Shriveled or wrinkled with age"},
        {"Xenophobia", "Dislike of or prejudice against people from other countries"},
        {"Yoke", "To join together; a wooden crosspiece for oxen"},
        {"Zephyr", "A gentle, mild breeze"},
        {"Aesthetic", "Concerned with beauty or the appreciation of beauty"},
        {"Belligerent", "Hostile and aggressive"},
        {"Capricious", "Given to sudden changes of mood or behavior"},
        {"Deleterious", "Causing harm or damage"},
        {"Ephemeral", "Lasting for a very short time"},
        {"Furtive", "Attempting to avoid notice or attention; secretive"}
    };

    int index = 0; 
    int score = 0;
    int point = 10;
    int trials = 2;
    /**
     * Creates new form scrambled
     */
    public scrambled() {
        initComponents();
        String word = scrambleWord(words[index][0]).toLowerCase();
        jLabel5.setText(word); 
        
        jLabel8.setText(String.valueOf(score));
        
        timer n = new timer();
        Thread t = new Thread(n);
        t.start();
        
        blink b = new blink();
        Thread tt = new Thread(b);
        tt.start();
    }
    
    public String scrambleWord(String text) {
        char[] letters = text.toCharArray();
        Random random = new Random();
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(196, 173, 221));

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 14, 32));
        jLabel1.setText("SCRAMBLED");

        jButton1.setBackground(new java.awt.Color(70, 49, 92));
        jButton1.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 240, 255));
        jButton1.setText("Guess");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(70, 49, 92));
        jButton2.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 240, 255));
        jButton2.setText("Hint");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(70, 49, 92));
        jButton3.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 240, 255));
        jButton3.setText("Reschuffle");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(70, 49, 92));
        jButton4.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 240, 255));
        jButton4.setText("Next");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(27, 14, 32));
        jLabel2.setText("WORD");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 14, 32));
        jLabel3.setText("GUESS");

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(27, 14, 32));
        jLabel4.setText(" ");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(27, 14, 32));
        jLabel5.setText(" ");

        jTextField1.setBackground(new java.awt.Color(141, 119, 168));
        jTextField1.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(27, 14, 32));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(27, 14, 32));
        jLabel6.setText("Time");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(27, 14, 32));
        jLabel7.setText("SCORE:");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("0  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addGap(141, 141, 141)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(32, 32, 32)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(33, 33, 33))
                        .addComponent(jLabel1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jLabel4.setText(" ");
        trials = 2;
        if (words.length - 1 == index) {
           JOptionPane.showMessageDialog(rootPane, "You have reached the end of the game!"); 
        } else {
            point = 10;
            index = index+1;
            String word = scrambleWord(words[index][0]).toLowerCase();
            jLabel5.setText(word);  
            jTextField1.setText("");
        }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel4.setText(words[index][1]);
        point = 5;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String guess = jTextField1.getText().toLowerCase();
        try {
            if (words[index][0].toLowerCase().equals(guess)){
                JOptionPane.showMessageDialog(rootPane, "Correct!");
                score = score+point;
                jLabel8.setText(String.valueOf(score));
                jButton4ActionPerformed(evt);
            } else {
                if (trials == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Trial Limit Exceeded! Too bad!");
                    jButton4ActionPerformed(evt);
                } else {
                    trials = trials - 1;
                    JOptionPane.showMessageDialog(rootPane, "Incorrect! Try again!");
                    jTextField1.setText("");
                }                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Invalid Entry!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String word = scrambleWord(words[index][0]).toLowerCase();
        jLabel5.setText(word); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setForeground(Color.white);
        jButton4.setBackground(Color.black);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setForeground(Color.white);
        jButton2.setBackground(Color.black);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setForeground(Color.white);
        jButton1.setBackground(Color.black);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setForeground(Color.white);
        jButton3.setBackground(Color.black);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setForeground(new Color(255, 240, 255));
        jButton1.setBackground(new Color(70, 49, 92));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setForeground(new Color(255, 240, 255));
        jButton2.setBackground(new Color(70, 49, 92));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setForeground(new Color(255, 240, 255));
        jButton4.setBackground(new Color(70, 49, 92));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setForeground(new Color(255, 240, 255));
        jButton3.setBackground(new Color(70, 49, 92));
    }//GEN-LAST:event_jButton3MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(scrambled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(scrambled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(scrambled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(scrambled.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new scrambled().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
