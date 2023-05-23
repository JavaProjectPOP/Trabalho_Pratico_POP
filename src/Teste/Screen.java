package Teste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {
    public Screen(){
        setTitle("Inicial Page");
        setVisible(true);
        setSize(800,500);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);



        JButton jButton = new JButton("Login");
        jButton.setBounds(150,200,250,70);
        jButton.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        jButton.setForeground(new Color(58, 58, 58));
        jButton.setBackground(new Color(255, 255, 255));
        add(jButton);
        jButton.addActionListener(this);



        JButton jButton1 = new JButton("Register");
        jButton1.setBounds(180,300,150,70);
        jButton1.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        jButton1.setForeground(new Color(101, 99, 99));
        jButton1.setBackground(new Color(80, 79, 79));
        jButton1.addActionListener(this::teste);
        add(jButton1);



    }

    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null,"cenas");
    }
    private void teste(ActionEvent actionEvent){
        JOptionPane.showMessageDialog(null,"coiso","cenas",JOptionPane.WARNING_MESSAGE);
    }
}
