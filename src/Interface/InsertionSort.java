/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishwari
 */
public class InsertionSort extends javax.swing.JInternalFrame {

    /**
     * Creates new form InsertionSort
     */
    
    private JButton[] buttons;
    private int arr[];
    
    Color red = new Color(255,74,28);
    Color blue = new Color(88,135,211);
    
    public InsertionSort() {
        initComponents();
        //initialize the buttons in an array
        buttons = new JButton[]{jButton2,jButton3,jButton4,jButton5,jButton6,jButton7};
    }
    
    //method to get Values from the text fields and assign to buttons
    private void getValues(){
        buttons[0].setText(jTextField1.getText());
        buttons[1].setText(jTextField2.getText());
        buttons[2].setText(jTextField3.getText());
        buttons[3].setText(jTextField4.getText());
        buttons[4].setText(jTextField5.getText());
        buttons[5].setText(jTextField6.getText());
        
        try{
        //assign the same to array
        arr = new int[]{Integer.parseInt(jTextField1.getText()),
                        Integer.parseInt(jTextField2.getText()),
                        Integer.parseInt(jTextField3.getText()),
                        Integer.parseInt(jTextField4.getText()),
                        Integer.parseInt(jTextField5.getText()),
                        Integer.parseInt(jTextField6.getText())
                };
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane,"Please enter valid inputs!");
        }
    }
    
    public void insertionSortAsc() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                int n = arr.length;
                for (int j = 1; j < n; j++) {
                    //to show that array goes from element to element
                    try {
                            Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //counter to check the iteration of the while loop. to track the key for animation
                    int count = 0;
                    int key = arr[j];
                    int i = j-1;
                    //x coordinate of the key
                    int toBeMoved = buttons[j].getLocation().x;
                    //tracks the location the previous value should be moved to
                    int current=0;
                    //stores the location of the current location
                    int temp;
                    
                    //if the array element is greater than the key
                    while ( (i >= 0) && ( arr [i] > key ) ) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        //first itertion of the while loop
                        if(count<1){
                            //location of the previous element
                            current = buttons[i].getLocation().x;
                            //key should be moved up
                            moveUp(j);
                            //the previous element is moved to that position
                            moveForward(toBeMoved,i);
                            count++;
                        }
                        else{
                            //temporary stores the elements current location
                            temp = buttons[i].getLocation().x;
                            //each button is moved one forward
                            moveForward(current,i);
                            //stores the temporary value in current to facilitate the next element to be moved to this location
                            current = temp;
                        }
                        //each element is moved one forward
                        arr [i+1] = arr [i];
                        i--; 
                    } 
                    //replace the key
                    arr[i+1] = key;
                    moveForward(current, j);
                    reOrderButtons();
                    
                    //setting the ordered elements to blue
                    buttons[j].setBackground(blue);
                    buttons[j-1].setBackground(blue);
                }
                JOptionPane.showMessageDialog(rootPane, "Array Sorted!");
            }
        }).start();
        reOrderButtons();
    }
    
    public void insertionSortDesc() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                int n = arr.length;
                for (int j = 1; j < n; j++) {
                    //to show that array goes from element to element
                    try {
                            Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //counter to check the iteration of the while loop. to track the key for animation
                    int count = 0;
                    int key = arr[j];
                    int i = j-1;
                    //x coordinate of the key
                    int toBeMoved = buttons[j].getLocation().x;
                    //tracks the location the previous value should be moved to
                    int current=0;
                    //stores the location of the current location
                    int temp;
                    
                    //if the array element is less than the key
                    while ( (i >= 0) && ( arr [i] < key ) ) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        //first itertion of the while loop
                        if(count<1){
                            //location of the previous element
                            current = buttons[i].getLocation().x;
                            //key should be moved up
                            moveUp(j);
                            //the previous element is moved to that position
                            moveForward(toBeMoved,i);
                            count++;
                        }
                        else{
                            //temporary stores the elements current location
                            temp = buttons[i].getLocation().x;
                            //each button is moved one forward
                            moveForward(current,i);
                            //stores the temporary value in current to facilitate the next element to be moved to this location
                            current = temp;
                        }
                        //each element is moved one forward
                        arr [i+1] = arr [i];
                        i--; 
                    } 
                    //replace the key
                    arr[i+1] = key;
                    moveForward(current, j);
                    reOrderButtons();
                    
                    //setting the ordered elements to blue
                    buttons[j].setBackground(blue);
                    buttons[j-1].setBackground(blue);
                }
                JOptionPane.showMessageDialog(rootPane, "Array Sorted!");
            }
        }).start();
        reOrderButtons();
    }
    
    //reorder the buttons array
    private void reOrderButtons() {
        for (int i = 0; i < buttons.length; i++) {
           buttons[i].setText("" + arr[i]);
        }
    }
    
    private void moveForward(int oldX, int index) {
        JButton button1 = buttons[index];
        
        //get x coordinate of moving button
        int button1Pos = button1.getX();
        for (int i = 0; i < oldX-button1Pos ; i++) {
            button1.setLocation(button1.getX() + 1, button1.getY());

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
        }
    }
    
    //moving the button up (passing the index of the buttons to be moved)
    private void moveUp(final int index1) {
        JButton button1 = buttons[index1];
        for (int i = 0; i < 50; i++) {
            button1.setBackground(red);
            button1.setLocation(button1.getX(), button1.getY() - 1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
        }      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(817, 409));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button (6).png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button (5).png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button (2).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(116, 116, 116)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton1)))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(checkButtonValues())
            insertionSortDesc();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(checkButtonValues())
            insertionSortAsc();
    }//GEN-LAST:event_jButton8ActionPerformed
    //check if all the text fields are filled
    private boolean checkTextValues(){
        if(jTextField1.getText()==""||jTextField1.getText()==null||jTextField2.getText()==""||jTextField2.getText()==null||jTextField3.getText()==""
            ||jTextField3.getText()==null||jTextField4.getText()==""||jTextField4.getText()==null||jTextField5.getText()==""||jTextField5.getText()==null
            ||jTextField6.getText()==null||jTextField6.getText()==""
            )
        {
            JOptionPane.showMessageDialog(rootPane, "Please enter 6 numbers to be swapped");
            return false;
        }
        return true;
    }
    //check if the values are assigned
    private boolean checkButtonValues(){
        if(jButton7.getText()==""||jButton7.getText()==null||jButton2.getText()==""||jButton2.getText()==null||jButton3.getText()==""
            ||jButton3.getText()==null||jButton4.getText()==""||jButton4.getText()==null||jButton5.getText()==""||jButton5.getText()==null||
            jButton6.getText()==""||jButton6.getText()==null
            )
        {
            JOptionPane.showMessageDialog(rootPane, "Please set the values");
            return false;
        }
        //Fill values to the buttons
        getValues();
        return true;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(checkTextValues())
        //Fill values to the buttons
            getValues();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
