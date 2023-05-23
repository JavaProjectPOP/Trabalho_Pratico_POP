package APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Registro extends JFrame implements ActionListener {
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton sairButton;
    private JButton registrarButton;

    Gestor cv= new Gestor();
public Registro() {

    setTitle("Pagina inicial");
    setVisible(true);
    setSize(800,500);
    setResizable(true);
    setLocationRelativeTo(null);
    setLayout(null);

    textField1.setBounds(250,250,100,40);
    textField1.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
    textField1.setForeground(new Color(58, 58, 58));
    textField1.setBackground(new Color(255, 255, 255));
    add(textField1);


    registrarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Utilizador utilizador= new Utilizador();
            utilizador.setEmail(textField3.getText());
            utilizador.setPalavraPasse(Arrays.toString(passwordField1.getPassword()));
            utilizador.setPrimeiroNome(textField1.getText());
            utilizador.setUltimoNome(textField2.getText());

            if(cv.GuardarUser(utilizador)){
                JOptionPane.showMessageDialog(null,"Utilizador Registado");
            }else{
                JOptionPane.showMessageDialog(null,"Erro, por favor registe de novo");
            }
        }
    });
    sairButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
