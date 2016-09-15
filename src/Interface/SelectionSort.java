/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Ishwari
 */
public class SelectionSort extends javax.swing.JInternalFrame {

    /**
     * Creates new form SelectionSort
     */
    
    private JButton[] buttons;
    private int arr[];
    
    Color red = new Color(255,74,28);
    Color blue = new Color(88,135,211);
    
    public SelectionSort() {
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
        
        //assign the same to array
        try{
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
    
    public void selectionSortAsc() {
        new Thread(new Runnable() {

            @Override
            public void run() {
               
                for (int i = 0; i < arr.length - 1; i++) {
                    //taking the first index of each iteration as the minimum to compare
                    int minimum = i;
                    
                    //looping through the rest of the array
                    for (int j = i + 1; j < arr.length; j++) {
                    
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                           
                        }
                        //if the current value is less than the previous it is assigned to the minimum
                        if (arr[minimum] > arr[j]) {
                            minimum = j;
                        }
                    }
                    
                    //animation
                    moveUp(i, minimum);
                    swap(i, minimum);
                    moveDown(i, minimum);
                    
                    //setting the sorted values to blue
                    buttons[minimum].setBackground(null);
                    buttons[i].setBackground(blue);
                    
                    //swapping with the minimum
                    int tempNum = arr[i];
                    arr[i] = arr[minimum];
                    arr[minimum] = tempNum;
                    
                    //reordering the button array items to align with the int array we are sorting
                    reOrderButtons();
                }
                for(JButton x:buttons){
                    x.setBackground(blue);
                }
                JOptionPane.showMessageDialog(rootPane, "Array Sorted!");
            }
        }).start();
        reOrderButtons();
    }
    
    public void selectionSortDesc() {
        new Thread(new Runnable() {

            @Override
            public void run() {
               
                for (int i = 0; i < arr.length - 1; i++) {
                    //taking the first index of each iteration as the maximum to compare
                    int max = i;
                    
                    //looping through the rest of the array
                    for (int j = i + 1; j < arr.length; j++) {
                    
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                           
                        }
                        //if the current value is less than the previous it is assigned to the maximum
                        if (arr[max] < arr[j]) {
                            max = j;
                        }
                    }
                    
                    //animation
                    moveUp(i, max);
                    swap(i, max);
                    moveDown(i, max);
                    
                    //setting the sorted values to blue
                    buttons[max].setBackground(null);
                    buttons[i].setBackground(blue);
                    //swapping with the maximum
                    int tempNum = arr[i];
                    arr[i] = arr[max];
                    arr[max] = tempNum;
                    
                    //reordering the button array items to align with the int array we are sorting
                    reOrderButtons();
                }
                for(JButton x:buttons){
                    x.setBackground(blue);
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

    //moving the button up (passing the index of the buttons to be moved)
    private void moveUp(final int index1, final int index2) {
        JButton button1 = buttons[index1];
        JButton button2 = buttons[index2];
        for (int i = 0; i < 50; i++) {
            button1.setBackground(red);
            button2.setBackground(red);
            //if its the same button
            if(index1==index2){
                button1.setLocation(button1.getX(), button1.getY() - 1);
            }
            else{
                button1.setLocation(button1.getX(), button1.getY() - 1);
                button2.setLocation(button2.getX(), button2.getY() - 1);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
        }      
    }
    
    //moving the button down (passing the index of the buttons to be moved)
    private void moveDown(final int index1, final int index2) {
        JButton button1 = buttons[index1];
        JButton button2 = buttons[index2];
        for (int i = 0; i < 50; i++) {
            //if its the same button
            if(index1==index2){
                button1.setLocation(button1.getX(), button1.getY() + 1);
            }
            else{
                button1.setLocation(button1.getX(), button1.getY() + 1);
                button2.setLocation(button2.getX(), button2.getY() + 1);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {

            }
        }      
    }
    
    //swapping the two buttons passing the buttons to be swapped
    private void swap(int index1, int index2) {
        JButton button1 = buttons[index1];
        JButton button2 = buttons[index2];
        
        //get x coordinate of 1st button
        int button1Pos = button1.getX();
        //get x coordinate of 2nd button
        int button2Pos = button2.getX();
        //get the distance to be moved
        int distance = button2Pos - button1Pos;
        for (int i = 0; i < distance; i++) {
            button1.setLocation(button1.getX() + 1, button1.getY());
            button2.setLocation(button2.getX() - 1, button2.getY());

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
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(817, 409));
        setMinimumSize(new java.awt.Dimension(817, 409));
        setPreferredSize(new java.awt.Dimension(817, 409));

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

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button (5).png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/button (6).png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
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
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(checkTextValues())
        //Fill values to the buttons
            getValues();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(checkButtonValues())
            selectionSortAsc();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(checkButtonValues())
            selectionSortDesc();
    }//GEN-LAST:event_jButton9ActionPerformed

    //check if the values are filled in the text fields
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
    
    //check if the values are assigned to the buttons
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
