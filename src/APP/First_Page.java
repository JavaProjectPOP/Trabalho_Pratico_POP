package APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First_Page extends JFrame implements ActionListener {
    private JButton loginButton;
    private JButton registerButton;

    public First_Page(){
         setTitle("Pagina inicial");
         setVisible(true);
         setSize(800,500);
         setResizable(true);
         setLocationRelativeTo(null);
         setLayout(null);

         registerButton.setBounds(250,250,100,40);
         registerButton.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
         registerButton.setForeground(new Color(58, 58, 58));
         registerButton.setBackground(new Color(255, 255, 255));
         add(registerButton);
         registerButton.addActionListener(this::registo);

         loginButton.setBounds(450,250,100,40);
         loginButton.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
         loginButton.setForeground(new Color(58, 58, 58));
         loginButton.setBackground(new Color(255, 255, 255));
         add(loginButton);
         loginButton.addActionListener(this::Login);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
    private void registo(ActionEvent actionEvent){
        Registro registro=new Registro();
    }
    private void Login(ActionEvent actionEvent){

    }
}
