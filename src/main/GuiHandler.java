package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static main.ModifyXML.modifyxml;

public class GuiHandler {

    public static void main(String[] args) {

        JFrame f = new JFrame("Text Field into XML");
        f.getContentPane().setLayout(new FlowLayout());
        JButton button = new JButton("Submit");
        button.setBounds(100,100,140,40);
        JLabel label = new JLabel("Enter your IBAN");
        label.setBounds(10,10,100,100);
        JTextField tf = new JTextField(10);
        JLabel label2 = new JLabel("Enter the name of your XML File");
        label.setBounds(10,10,100,100);
        JTextField tf2 = new JTextField(10);
        f.add(label);
        f.add(tf);
        f.add(label2);
        f.add(tf2);
        f.add(button);
        f.setSize(300,300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.pack();
        f.setVisible(true);

        button.addActionListener(e -> {
            String text = tf.getText();
            String filename = tf2.getText();
                File file = new File(filename);
                if(file.isFile()) {
                    try {
                        modifyxml(file, text);
                    } catch (Exception ex) {
                        System.out.println("A problem has been encountered while modifying your XML File");
                        ex.printStackTrace();
                    }
                }else {
                    JOptionPane.showMessageDialog(f, "Sorry, your XML file does not exist", "XML File Error", JOptionPane.ERROR_MESSAGE);
                }

        });

    }


}
