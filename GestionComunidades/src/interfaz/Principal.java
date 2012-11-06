package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Label;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Button;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel jContentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Gestion Inmuebles");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SRG\\git\\proyectos-UPV\\GestionComunidades\\src\\home.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 430);
		
		JMenuBar jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		JMenu archivoMenu = new JMenu("Archivo");
		jMenuBar.add(archivoMenu);
		
		JMenuItem guardarMenuItem = new JMenuItem("Guardar");
		archivoMenu.add(guardarMenuItem);
		
		JMenuItem guardarComoMenuItem = new JMenuItem("Guardar como...");
		archivoMenu.add(guardarComoMenuItem);
		
		JMenuItem cargarArchivoMenuItem = new JMenuItem("Cargar archivo");
		archivoMenu.add(cargarArchivoMenuItem);
		
		JSeparator separator = new JSeparator();
		archivoMenu.add(separator);
		
		JMenuItem salirMenuItem = new JMenuItem("Salir");
		archivoMenu.add(salirMenuItem);
		
		JMenu mnAspecto = new JMenu("Aspecto");
		jMenuBar.add(mnAspecto);
		
		JMenuItem colorFuentes = new JMenuItem("Color fuente");
		mnAspecto.add(colorFuentes);
		
		JMenuItem ColorFondo = new JMenuItem("Color fondo");
		mnAspecto.add(ColorFondo);
		jContentPane = new JPanel();
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jContentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(jContentPane);
		
		Label statusbar = new Label(new Date().toString()+"   SERGIU Y PATRICK");
		jContentPane.add(statusbar, BorderLayout.SOUTH);
		
		JScrollPane tablaScrollPane = new JScrollPane();
		jContentPane.add(tablaScrollPane, BorderLayout.CENTER);
		
		JPanel posicionBotonesPanel = new JPanel();
		jContentPane.add(posicionBotonesPanel, BorderLayout.EAST);
		posicionBotonesPanel.setLayout(new GridLayout(6, 1, 0, 20));
		
		JButton addButton = new JButton("A\u00F1adir");
		posicionBotonesPanel.add(addButton);
		
		JButton delButton = new JButton("Borrar");
		posicionBotonesPanel.add(delButton);
		
		JButton detalleButton = new JButton("Detalle");
		posicionBotonesPanel.add(detalleButton);
		
		JToolBar jToolBar = new JToolBar();
		jContentPane.add(jToolBar, BorderLayout.NORTH);
		
		JButton abrirButton = new JButton("");
		abrirButton.setIcon(new ImageIcon("C:\\Users\\SRG\\git\\proyectos-UPV\\GestionComunidades\\src\\openFile.png"));
		jToolBar.add(abrirButton);
		
		JButton guardarButton = new JButton("");
		guardarButton.setIcon(new ImageIcon("C:\\Users\\SRG\\git\\proyectos-UPV\\GestionComunidades\\src\\saveFile.png"));
		jToolBar.add(guardarButton);
	}

}
