package Ventanas.VentanaPrincipal;
import Iconos.Iconos;
import Ventanas.*;
import Ventanas.Boleto.*;
import Ventanas.Empleados.AdministrarEmpleados;
import Ventanas.Evento.Eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.Frame.MAXIMIZED_BOTH;

class FondoPanelEventos extends JPanel{
    private Image imagenFondo;
    @Override
    public void paint(Graphics g) {
        imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/ImagenTickets.jpg")).getImage();
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}//Fin de la clase: FondoPanelBoleteria

public class VentanaPrincipalEventos {
    private Cursor _cursor = new Cursor(Cursor.HAND_CURSOR); //Cambia la forma del cursor

    private static JFrame _frame;
    private static JFrame _frameLogin;
    private Font estiloTextoMenu = new Font("Candara",Font.BOLD,25);
    public  JPanel _panelFondoEventos = new FondoPanelEventos();

    public JMenuBar _barraDeMenu = new JMenuBar();
    private JMenu _menuOpciones = new JMenu("Opciones");
    private JMenu _menuEmpleados = new JMenu("Personal");
    private JMenu _menuBoletos = new JMenu("Boletos");
    private JMenu _menuEventos = new JMenu("Eventos");
    private JMenu _menuNegocios = new JMenu("Negocios");

    private JMenuItem _menuOpciones_cerrarSesion = new JMenuItem("Cerrar sesión");

    private JMenuItem _menuEmpleados_administrarUsuarios = new JMenuItem("Administrar Usuarios");
    private JMenuItem _menuEmpleados_administrarEmpleados = new JMenuItem("Administrar Empleados");

    private JMenuItem _menuBoletos_crearBoleto = new JMenuItem("Crear Boleto");

    private JMenuItem _menuEventos_crearEvento = new JMenuItem("Crear Evento");
    private JMenuItem _menuEventos_crearLanzamiento = new JMenuItem("Lanzamiento de Evento");
    private JMenuItem _menuEventos_crearBuffet = new JMenuItem("Buffet");

    private JMenuItem _menuNegocios_compras = new JMenuItem("Compras");
    private JMenuItem _menuNegocios_clientes = new JMenuItem("Clientes");
    private JMenuItem _menuNegocios_patrocinadores = new JMenuItem("Patrocinadores");
    private JMenuItem _menuNegocios_ventas = new JMenuItem("Ventas");
    private JMenuItem _menuNegocios_rentaDeEquipo = new JMenuItem("Renta de equipo");
    private JMenuItem _menuNegocios_CronogramaOAgenda = new JMenuItem("Cronograma o Agenda");

    public VentanaPrincipalEventos(){
        _menuOpciones.setCursor(_cursor);
        _menuOpciones.setFont(estiloTextoMenu);
        _barraDeMenu.add(_menuOpciones);
        _menuEmpleados.setCursor(_cursor);
        _menuEmpleados.setFont(estiloTextoMenu);
        _barraDeMenu.add(_menuEmpleados);
        _menuBoletos.setCursor(_cursor);
        _menuBoletos.setFont(estiloTextoMenu);
        _barraDeMenu.add(_menuBoletos);
        _menuEventos.setCursor(_cursor);
        _menuEventos.setFont(estiloTextoMenu);
        _barraDeMenu.add(_menuEventos);
        _menuNegocios.setCursor(_cursor);
        _menuNegocios.setFont(estiloTextoMenu);
        _barraDeMenu.add(_menuNegocios);

        //*********************************Personalizando botones menú principal
        _menuOpciones.setCursor(_cursor);
        _menuOpciones.setFont(estiloTextoMenu);
        _menuOpciones.setIcon(Iconos._ICONO_OPCIONES);

        _menuEmpleados.setCursor(_cursor);
        _menuEmpleados.setFont(estiloTextoMenu);
        _menuEmpleados.setIcon(Iconos._PERSONAL);

        _menuBoletos.setCursor(_cursor);
        _menuBoletos.setFont(estiloTextoMenu);
        _menuBoletos.setIcon(Iconos._BOLETO_MEDIANO);

        _menuEventos.setCursor(_cursor);
        _menuEventos.setFont(estiloTextoMenu);
        _menuEventos.setIcon(Iconos._EVENTO);

        _menuNegocios.setCursor(_cursor);
        _menuNegocios.setFont(estiloTextoMenu);
        _menuNegocios.setIcon(Iconos._NEGOCIOS);
        //*********************************Personalizando menú principal

        //*********************************Cerrar sesión
        _menuOpciones_cerrarSesion.setCursor(_cursor);
        _menuOpciones_cerrarSesion.setFont(estiloTextoMenu);
        _menuOpciones_cerrarSesion.setIcon(Iconos._CERRAR_SESION);
        _menuOpciones.add(_menuOpciones_cerrarSesion);
        //*********************************Cerrar sesión

        //*********************************Personal
        _menuEmpleados_administrarUsuarios.setCursor(_cursor);
        _menuEmpleados_administrarUsuarios.setFont(estiloTextoMenu);
        _menuEmpleados_administrarUsuarios.setIcon(Iconos._USUARIO); //ICono
        _menuEmpleados.add(_menuEmpleados_administrarUsuarios);

        _menuEmpleados_administrarEmpleados.setCursor(_cursor);
        _menuEmpleados_administrarEmpleados.setFont(estiloTextoMenu);
        _menuEmpleados_administrarEmpleados.setIcon(Iconos._EMPLEADOS); //ICono
        _menuEmpleados.add(_menuEmpleados_administrarEmpleados);
        //*********************************Personal

        //************************************************************Boletos
        _menuBoletos_crearBoleto.setCursor(_cursor);
        _menuBoletos_crearBoleto.setFont(estiloTextoMenu);
        _menuBoletos_crearBoleto.setIcon(Iconos._BOLETO_MEDIANO); //ICono
        _menuBoletos.add(_menuBoletos_crearBoleto);
        //************************************************************Boletos

        //************************************************************Eventos
        _menuEventos_crearEvento.setCursor(_cursor);
        _menuEventos_crearEvento.setFont(estiloTextoMenu);
        _menuEventos_crearEvento.setIcon(Iconos._EVENTO); //ICono
        _menuEventos.add(_menuEventos_crearEvento);

        _menuEventos_crearLanzamiento.setCursor(_cursor);
        _menuEventos_crearLanzamiento.setFont(estiloTextoMenu);
        _menuEventos_crearLanzamiento.setIcon(Iconos._EVENTO); //ICono
        _menuEventos.add(_menuEventos_crearLanzamiento);

        _menuEventos_crearBuffet.setCursor(_cursor);
        _menuEventos_crearBuffet.setFont(estiloTextoMenu);
        _menuEventos_crearBuffet.setIcon(Iconos._BUFFET); //ICono
        _menuEventos.add(_menuEventos_crearBuffet);
        //************************************************************Eventos

        //************************************************************Negocios
        _menuNegocios_compras.setCursor(_cursor);
        _menuNegocios_compras.setFont(estiloTextoMenu);
        _menuNegocios_compras.setIcon(Iconos._COMPRAS); //ICono
        _menuNegocios.add(_menuNegocios_compras);

        _menuNegocios_clientes.setCursor(_cursor);
        _menuNegocios_clientes.setFont(estiloTextoMenu);
        _menuNegocios_clientes.setIcon(Iconos._CLIENTES); //ICono
        _menuNegocios.add(_menuNegocios_clientes);

        _menuNegocios_patrocinadores.setCursor(_cursor);
        _menuNegocios_patrocinadores.setFont(estiloTextoMenu);
        _menuNegocios_patrocinadores.setIcon(Iconos._PATROCINADORES); //ICono
        _menuNegocios.add(_menuNegocios_patrocinadores);

        _menuNegocios_ventas.setCursor(_cursor);
        _menuNegocios_ventas.setFont(estiloTextoMenu);
        _menuNegocios_ventas.setIcon(Iconos._VENTAS); //ICono
        _menuNegocios.add(_menuNegocios_ventas);

        _menuNegocios_rentaDeEquipo.setCursor(_cursor);
        _menuNegocios_rentaDeEquipo.setFont(estiloTextoMenu);
        _menuNegocios_rentaDeEquipo.setIcon(Iconos._RENTA_EQUIPO); //ICono
        _menuNegocios.add(_menuNegocios_rentaDeEquipo);

        _menuNegocios_CronogramaOAgenda.setCursor(_cursor);
        _menuNegocios_CronogramaOAgenda.setFont(estiloTextoMenu);
        _menuNegocios_CronogramaOAgenda.setIcon(Iconos._CRONOGRAMA_O_AGENDA); //ICono
        _menuNegocios.add(_menuNegocios_CronogramaOAgenda);
        //************************************************************Negocios

        _menuOpciones_cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    _frame.dispose();
                    _frameLogin.setVisible(true);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });//
        _menuEmpleados_administrarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameUsuarios = new JFrame("Usuarios");
                frameUsuarios.setContentPane(new Usuarios()._panelUsuarios);
                frameUsuarios.setResizable(true);
                frameUsuarios.setMinimumSize(new Dimension(600,500));
                frameUsuarios.setExtendedState(MAXIMIZED_BOTH);
                frameUsuarios.setIconImage(new ImageIcon(frameUsuarios.getClass().getResource("/Iconos/IconoUsuario.png")).getImage());
                frameUsuarios.pack();
                frameUsuarios.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameUsuarios.setLocationRelativeTo(null);
                frameUsuarios.setVisible(true);
            }
        });//
        _menuEmpleados_administrarEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameEmpleados = new JFrame("Empleados");
                frameEmpleados.setContentPane(new AdministrarEmpleados()._panelAdministrarEmpleados);
                frameEmpleados.setResizable(true);
                frameEmpleados.setMinimumSize(new Dimension(600,500));
                frameEmpleados.setExtendedState(MAXIMIZED_BOTH);
                frameEmpleados.setIconImage(new ImageIcon(frameEmpleados.getClass().getResource("/Iconos/IconoEmpleados.png")).getImage());
                frameEmpleados.pack();
                frameEmpleados.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameEmpleados.setLocationRelativeTo(null);
                frameEmpleados.setVisible(true);
            }
        });//
        _menuBoletos_crearBoleto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frameBoleto = new JFrame("Vender Boleto");
                frameBoleto.setContentPane(new Boletos()._panelBoleto);
                frameBoleto.setResizable(true);
                frameBoleto.setMinimumSize(new Dimension(600,500));
                frameBoleto.setExtendedState(MAXIMIZED_BOTH);
                frameBoleto.setIconImage(new ImageIcon(frameBoleto.getClass().getResource("/Iconos/IconoPersonal.png")).getImage());
                frameBoleto.setIconImage(new ImageIcon(frameBoleto.getClass().getResource("/Iconos/IconoBoletoPequeño.png")).getImage());
                frameBoleto.pack();
                frameBoleto.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameBoleto.setLocationRelativeTo(null);
                frameBoleto.setVisible(true);
            }
        });//
        _menuEventos_crearEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frameEvento = new JFrame("Vender Boleto");
                frameEvento.setContentPane(new Eventos()._panelEventos);
                frameEvento.setResizable(true);
                frameEvento.setMinimumSize(new Dimension(600,500));
                frameEvento.setExtendedState(MAXIMIZED_BOTH);
                frameEvento.setIconImage(new ImageIcon(frameEvento.getClass().getResource("/Iconos/IconoEvento.png")).getImage());
                frameEvento.pack();
                frameEvento.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameEvento.setLocationRelativeTo(null);
                frameEvento.setVisible(true);
            }
        });//
        _menuEventos_crearLanzamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frameEvento = new JFrame("Vender Lanzamiento");
                frameEvento.setContentPane(new Lanzamiento()._panelLanzamientos);
                frameEvento.setResizable(true);
                frameEvento.setMinimumSize(new Dimension(600,500));
                frameEvento.setExtendedState(MAXIMIZED_BOTH);
                frameEvento.setIconImage(new ImageIcon(frameEvento.getClass().getResource("/Iconos/IconoEvento.png")).getImage());
                frameEvento.pack();
                frameEvento.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameEvento.setLocationRelativeTo(null);
                frameEvento.setVisible(true);
            }
        });//
        _menuEventos_crearBuffet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameEvento = new JFrame("Vender Buffet");
                frameEvento.setContentPane(new Buffet()._panelBuffet);
                frameEvento.setResizable(true);
                frameEvento.setMinimumSize(new Dimension(600,500));
                frameEvento.setExtendedState(MAXIMIZED_BOTH);
                frameEvento.setIconImage(new ImageIcon(frameEvento.getClass().getResource("/Iconos/IconoBuffet.png")).getImage());
                frameEvento.pack();
                frameEvento.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameEvento.setLocationRelativeTo(null);
                frameEvento.setVisible(true);
            }
        });//
        _menuNegocios_compras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frameCompras = new JFrame("Compras");
                frameCompras.setContentPane(new Compras()._panelCompras);
                frameCompras.setResizable(true);
                frameCompras.setMinimumSize(new Dimension(600,500));
                frameCompras.setExtendedState(MAXIMIZED_BOTH);
                frameCompras.setIconImage(new ImageIcon(frameCompras.getClass().getResource("/Iconos/IconoCompras.png")).getImage());
                frameCompras.pack();
                frameCompras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameCompras.setLocationRelativeTo(null);
                frameCompras.setVisible(true);
            }
        });//
        _menuNegocios_clientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameCompras = new JFrame("Clientes");
                frameCompras.setContentPane(new Cliente()._panelCliente);
                frameCompras.setResizable(true);
                frameCompras.setMinimumSize(new Dimension(600,500));
                frameCompras.setExtendedState(MAXIMIZED_BOTH);
                frameCompras.setIconImage(new ImageIcon(frameCompras.getClass().getResource("/Iconos/IconoClientes.png")).getImage());
                frameCompras.pack();
                frameCompras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameCompras.setLocationRelativeTo(null);
                frameCompras.setVisible(true);
            }
        });//
        _menuNegocios_patrocinadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameCompras = new JFrame("Patrocinadores");
                frameCompras.setContentPane(new Patrocinadores()._panelPatrocinadores);
                frameCompras.setResizable(true);
                frameCompras.setMinimumSize(new Dimension(600,500));
                frameCompras.setExtendedState(MAXIMIZED_BOTH);
                frameCompras.setIconImage(new ImageIcon(frameCompras.getClass().getResource("/Iconos/IconoPatrocinadores.png")).getImage());
                frameCompras.pack();
                frameCompras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameCompras.setLocationRelativeTo(null);
                frameCompras.setVisible(true);
            }
        });//
        _menuNegocios_ventas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameCompras = new JFrame("Ventas");
                frameCompras.setContentPane(new Ventas()._panelVentas);
                frameCompras.setResizable(true);
                frameCompras.setMinimumSize(new Dimension(600,500));
                frameCompras.setExtendedState(MAXIMIZED_BOTH);
                frameCompras.setIconImage(new ImageIcon(frameCompras.getClass().getResource("/Iconos/IconoVentas.png")).getImage());
                frameCompras.pack();
                frameCompras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameCompras.setLocationRelativeTo(null);
                frameCompras.setVisible(true);
            }
        });//
        _menuNegocios_rentaDeEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameCompras = new JFrame("Renta de equipo");
                frameCompras.setContentPane(new RentaDeEquipo()._panelRentaDeEquipo);
                frameCompras.setResizable(true);
                frameCompras.setMinimumSize(new Dimension(600,500));
                frameCompras.setExtendedState(MAXIMIZED_BOTH);
                frameCompras.setIconImage(new ImageIcon(frameCompras.getClass().getResource("/Iconos/IconoRentaEQuipo.png")).getImage());
                frameCompras.pack();
                frameCompras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameCompras.setLocationRelativeTo(null);
                frameCompras.setVisible(true);
            }
        });//
        _menuNegocios_CronogramaOAgenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameCompras = new JFrame("Cronograma o agenda");
                frameCompras.setContentPane(new CronogramaOAgenda()._panelCronogramaOAgenda);
                frameCompras.setResizable(true);
                frameCompras.setMinimumSize(new Dimension(600,500));
                frameCompras.setExtendedState(MAXIMIZED_BOTH);
                frameCompras.setIconImage(new ImageIcon(frameCompras.getClass().getResource("/Iconos/IconoCronogramaOAgenda.png")).getImage());
                frameCompras.pack();
                frameCompras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                frameCompras.setLocationRelativeTo(null);
                frameCompras.setVisible(true);
            }
        });//
    }//Fin del constructor.
    public static void getFrame(JFrame frame){_frame = frame;}
    public static void getFrameLogin(JFrame frameLogin){_frameLogin = frameLogin;}
}//Fin de la clase: Boleteria
