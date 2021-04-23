package hn.ujcv.edu.p3;

import PlaceHolder.TextPrompt;
import Ventanas.VentanaPrincipal.VentanaPrincipalEventos;
import hn.ujcv.edu.p3.Res.controller.ClientesController;
import hn.ujcv.edu.p3.Res.entity.Clientes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.Frame.MAXIMIZED_BOTH;
@SpringBootApplication
public class Login {
    private Cursor _cursor = new Cursor(Cursor.HAND_CURSOR); //Cambia la forma del cursor
    private static JFrame _frame = new JFrame("Login");
    public JPanel panelLogin;
    private JButton botonLogin;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;

   private TextPrompt temporalCampoUsuario = new TextPrompt("Usuario", txtUsuario);
   private TextPrompt temporalCampoContraseña = new TextPrompt("Contraseña", txtContraseña);

    public Login() {
        botonLogin.setCursor(_cursor);

        txtUsuario.setBorder(BorderFactory.createCompoundBorder());//Quita los feos bordes.
        txtContraseña.setBorder(BorderFactory.createCompoundBorder());
        botonLogin.setBorder(BorderFactory.createEmptyBorder());

        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientesController clientesCon = new ClientesController();

                Clientes c = new Clientes();
                c.setNombrecompleto("d");
                c.setDni(3333);
                c.setPaisregion("ds");
                c.setPueblo("dsada");
                c.setTelefono("23232");
                c.setEdad(2323);
                c.setGenero("ffw");

                clientesCon.addCliente(c);

                botonLogin.setFocusPainted(false); //Para quitar el focus al dar clic!
                _frame.setVisible(false);
                JFrame frame = new JFrame("Eventos EMDAMO");
                VentanaPrincipalEventos.getFrame(frame);
                VentanaPrincipalEventos.getFrameLogin(_frame);
                frame.setContentPane(new VentanaPrincipalEventos()._panelFondoEventos);
                frame.setIconImage(new ImageIcon(frame.getClass().getResource("/Iconos/IconoBoletoPequeño.png")).getImage());
                frame.setResizable(true);
                frame.setMinimumSize(new Dimension(600,500));
                frame.setExtendedState(MAXIMIZED_BOTH);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setJMenuBar(new VentanaPrincipalEventos()._barraDeMenu);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        botonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonLogin.setForeground(new Color(63, 220, 50));
            }
        });
        botonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                botonLogin.setForeground(new Color(212,212,212));
            }
        });
    }

    public static void main(String[] args){
        SpringApplication.run(Login.class, args);

        _frame.setContentPane(new Login().panelLogin);
        _frame.setResizable(true);
        _frame.setMinimumSize(new Dimension(600,500));
        _frame.setIconImage(new ImageIcon(_frame.getClass().getResource("/Iconos/IconoPersonal.png")).getImage());
        _frame.pack();
        _frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
    }
}//Fin del la clase: Login
