package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Detalle extends JFrame {

	private JPanel jContentPane;
	private JTextField textField;
	private JTextField txtHola;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detalle frame = new Detalle();
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
	public Detalle() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SRG\\git\\proyectos-UPV\\GestionComunidades\\src\\home.png"));
		setTitle("Datos Inmueble");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jContentPane = new JPanel();
		jContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jContentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(jContentPane);
		
		JPanel formularioPanel = new JPanel();
		jContentPane.add(formularioPanel, BorderLayout.CENTER);
		GridBagLayout gbl_formularioPanel = new GridBagLayout();
		gbl_formularioPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_formularioPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_formularioPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_formularioPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		formularioPanel.setLayout(gbl_formularioPanel);
		
		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		formularioPanel.add(lblId, gbc_lblId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		formularioPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblEscalera = new JLabel("Escalera:");
		GridBagConstraints gbc_lblEscalera = new GridBagConstraints();
		gbc_lblEscalera.insets = new Insets(0, 0, 5, 5);
		gbc_lblEscalera.gridx = 1;
		gbc_lblEscalera.gridy = 2;
		formularioPanel.add(lblEscalera, gbc_lblEscalera);
		
		txtHola = new JTextField();
		GridBagConstraints gbc_txtHola = new GridBagConstraints();
		gbc_txtHola.insets = new Insets(0, 0, 5, 0);
		gbc_txtHola.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHola.gridx = 3;
		gbc_txtHola.gridy = 2;
		formularioPanel.add(txtHola, gbc_txtHola);
		txtHola.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		GridBagConstraints gbc_lblPiso = new GridBagConstraints();
		gbc_lblPiso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPiso.gridx = 1;
		gbc_lblPiso.gridy = 4;
		formularioPanel.add(lblPiso, gbc_lblPiso);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 4;
		formularioPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPuerta = new JLabel("Puerta:");
		GridBagConstraints gbc_lblPuerta = new GridBagConstraints();
		gbc_lblPuerta.insets = new Insets(0, 0, 0, 5);
		gbc_lblPuerta.gridx = 1;
		gbc_lblPuerta.gridy = 6;
		formularioPanel.add(lblPuerta, gbc_lblPuerta);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 6;
		formularioPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JPanel botonesPanel = new JPanel();
		jContentPane.add(botonesPanel, BorderLayout.SOUTH);
		
		JButton guardarButton = new JButton("Guardar");
		botonesPanel.add(guardarButton);
		
		JButton volverButton = new JButton("Volver");
		botonesPanel.add(volverButton);
		
		JLabel lblSergiuMarsavelaY = new JLabel(" ");
		lblSergiuMarsavelaY.setHorizontalAlignment(SwingConstants.CENTER);
		jContentPane.add(lblSergiuMarsavelaY, BorderLayout.NORTH);
	}

}
