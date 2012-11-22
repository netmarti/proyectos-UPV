package interfaz;

import gestion.GestionInmuebles;

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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import dominio.Inmueble;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class Principal extends JFrame {

	private JPanel jContentPane;
	private JTable tabla;

	private ModeloTablaInmueble modelo;
	private GestionInmuebles gestion =new GestionInmuebles();
	private File f=null;

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

		modelo= new ModeloTablaInmueble(gestion);

		ActionListener cargarListener =new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				f=chooser.getSelectedFile();
				modelo.cargaInmuebles(f.getAbsolutePath());
			}
		};
		ActionListener guardarComoListener =new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser chooser = new JFileChooser();
					if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
						f=chooser.getSelectedFile();
						modelo.guardaInmuebles(f.getAbsolutePath());
						JOptionPane.showMessageDialog(null, "Archivo guardado.");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No se ha podido guardar el archivo.");
				}
			}
		};

		WindowAdapter ventanaListener =new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(tabla.getRowCount()==0 || modelo.isFlag()==false) {
					int resp;
					resp=JOptionPane.showConfirmDialog(null,  "ÀEst‡ seguro de que desea salir?", "Aviso",JOptionPane.YES_NO_OPTION);
					if (resp==JOptionPane.YES_OPTION)
						System.exit(0);					
				} else if(f==null || modelo.isFlag()==true) {
					try {
						JFileChooser chooser = new JFileChooser();
						if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
							f=chooser.getSelectedFile();
							modelo.guardaInmuebles(f.getAbsolutePath());
							JOptionPane.showMessageDialog(null, "Archivo guardado.");
							int resp;
							resp=JOptionPane.showConfirmDialog(null,  "ÀEst‡ seguro de que desea salir?", "Aviso",JOptionPane.YES_NO_OPTION);
							if (resp==JOptionPane.YES_OPTION)
								System.exit(0);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "No se ha podido guardar el archivo.");
					}
				}
			}
		};
		
		addWindowListener(ventanaListener);

		setTitle("Gestion Inmuebles");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("home.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 630, 430);

		JMenuBar jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);

		JMenu archivoMenu = new JMenu("Archivo");
		jMenuBar.add(archivoMenu);

		JMenuItem guardarMenuItem = new JMenuItem("Guardar");
		guardarMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(f!=null) {
						modelo.guardaInmuebles(f.getAbsolutePath());
						JOptionPane.showMessageDialog(null, "Archivo guardado.");
					} else {
						JFileChooser chooser = new JFileChooser();
						if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
							f=chooser.getSelectedFile();
							modelo.guardaInmuebles(f.getAbsolutePath());
							JOptionPane.showMessageDialog(null, "Archivo guardado.");
						}
					}					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "No se ha podido guardar el archivo.");
				}
			}
		});
		archivoMenu.add(guardarMenuItem);

		JMenuItem guardarComoMenuItem = new JMenuItem("Guardar como...");
		guardarComoMenuItem.addActionListener(guardarComoListener);
		archivoMenu.add(guardarComoMenuItem);

		JMenuItem cargarArchivoMenuItem = new JMenuItem("Cargar archivo");
		cargarArchivoMenuItem.addActionListener(cargarListener);
		archivoMenu.add(cargarArchivoMenuItem);

		JSeparator separator = new JSeparator();
		archivoMenu.add(separator);

		JMenuItem salirMenuItem = new JMenuItem("Salir");
		salirMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp;
				resp=JOptionPane.showConfirmDialog(null,  "ÀEst‡ seguro de que desea salir?", "Aviso",JOptionPane.YES_NO_OPTION);
				if (resp==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
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

		JToolBar jToolBar = new JToolBar();
		jContentPane.add(jToolBar, BorderLayout.NORTH);

		JButton abrirButton = new JButton("");
		abrirButton.addActionListener(cargarListener);
		abrirButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("openFile.png")));
		jToolBar.add(abrirButton);

		JButton guardarButton = new JButton("");
		guardarButton.addActionListener(guardarComoListener);
		guardarButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("saveFile.png")));
		jToolBar.add(guardarButton);

		JScrollPane tablaScrollPane = new JScrollPane();
		jContentPane.add(tablaScrollPane, BorderLayout.CENTER);

		tabla = new JTable();
		tablaScrollPane.setViewportView(tabla);
		tabla.setModel(modelo);

		JPanel posicionBotonesPanel = new JPanel();
		jContentPane.add(posicionBotonesPanel, BorderLayout.EAST);
		posicionBotonesPanel.setLayout(new GridLayout(6, 1, 0, 20));

		JButton addButton = new JButton("A\u00F1adir");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDetalle v=new VentanaDetalle((ModeloTablaInmueble) tabla.getModel());
				v.setVisible(true);
			}
		});
		posicionBotonesPanel.add(addButton);

		JButton delButton = new JButton("Borrar");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp;
				resp=JOptionPane.showConfirmDialog(null,  "Est‡ a punto de borrar el inmueble con \"id\" "
						+modelo.recuperaInmueblePorPosicion(tabla.getSelectedRow()).getId()+
						" ÀEst‡s seguro de querer borrarlo?", "Aviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (resp==JOptionPane.YES_OPTION) {
					modelo.borraInmueblePorPosicion(tabla.getSelectedRow());
					modelo.setFlag(true);
				}
			}
		});
		posicionBotonesPanel.add(delButton);

		JButton detalleButton = new JButton("Detalle");
		detalleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		detalleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inmueble inmueble= modelo.recuperaInmueblePorPosicion(tabla.getSelectedRow());
				VentanaDetalle v=new VentanaDetalle(inmueble);
				v.setVisible(true);
			}
		});
		posicionBotonesPanel.add(detalleButton);

		JPanel panel = new JPanel();
		jContentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		Label statusbar = new Label(new Date().toString());
		panel.add(statusbar);
		Label nombres = new Label("SERGIU Y PATRICK");
		nombres.setEnabled(false);
		nombres.setAlignment(Label.RIGHT);
		panel.add(nombres);
	}

	protected void guardarArchivo() {
		// TODO Auto-generated method stub
		
	}

}
