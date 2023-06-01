package APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First_Page extends JFrame implements ActionListener {
    private JButton loginButton;
    private JButton registerButton;
    private JLabel T1;
    private JPanel test;

    public First_Page(){
         /*setTitle("Pagina inicial");
         setVisible(true);
         setSize(800,500);
         setResizable(false);
         setLocationRelativeTo(null);
         setLayout(null);
         test.setVisible(true);
         test.setBackground(Color.RED);
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
         loginButton.addActionListener(this::Login);*/
        // Configurações da janela
        setTitle("Minha Página");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centralizar na tela

        // Criação dos componentes
        JLabel label = new JLabel("Bem-vindo");
        JButton registerButton = new JButton("Registrar");
        JButton loginButton = new JButton("Login");

        // Configuração do layout
        setLayout(new FlowLayout());

        // Adição dos componentes à janela
        add(label);
        add(registerButton);
        add(loginButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//por favor

    }
    private void registo(ActionEvent actionEvent){
        Registro registro =new Registro();
    }
    private void Login(ActionEvent actionEvent){

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
