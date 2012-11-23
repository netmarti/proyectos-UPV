package interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dominio.Inmueble;
import excepciones.InmuebleYaExiste;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDetalle extends JFrame {

	private JPanel jContentPane;
	private JTextField idTextField;
	private JTextField escaleraTextField;
	private JTextField pisoTextField;
	private JTextField puertaTextField;
	private ModeloTablaInmueble modelo;
	private JButton guardarButton;

	/**
	 * Create the frame.
	 */
	
	public VentanaDetalle(ModeloTablaInmueble m){
		//super();
		setTitle("Insetar Inmueble");
		modelo=m;
		initialize();
		
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public VentanaDetalle(Inmueble i){
		setTitle("Datos Inmueble");
		initialize();
		idTextField.setText(Integer.toString(i.getId()));
		escaleraTextField.setText(i.getEscalera());
		pisoTextField.setText(i.getPiso());
		puertaTextField.setText(i.getPuerta());
		
		idTextField.setEditable(false);
		escaleraTextField.setEditable(false);
		pisoTextField.setEditable(false);
		puertaTextField.setEditable(false);
		guardarButton.setEnabled(false);
		guardarButton.setVisible(false);
	}
	
	
	public void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("home.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		
		idTextField = new JTextField();
		GridBagConstraints gbc_idTextField = new GridBagConstraints();
		gbc_idTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_idTextField.insets = new Insets(0, 0, 5, 0);
		gbc_idTextField.gridx = 3;
		gbc_idTextField.gridy = 0;
		formularioPanel.add(idTextField, gbc_idTextField);
		idTextField.setColumns(10);
		
		JLabel lblEscalera = new JLabel("Escalera:");
		GridBagConstraints gbc_lblEscalera = new GridBagConstraints();
		gbc_lblEscalera.insets = new Insets(0, 0, 5, 5);
		gbc_lblEscalera.gridx = 1;
		gbc_lblEscalera.gridy = 2;
		formularioPanel.add(lblEscalera, gbc_lblEscalera);
		
		escaleraTextField = new JTextField();
		GridBagConstraints gbc_escaleraTextField = new GridBagConstraints();
		gbc_escaleraTextField.insets = new Insets(0, 0, 5, 0);
		gbc_escaleraTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_escaleraTextField.gridx = 3;
		gbc_escaleraTextField.gridy = 2;
		formularioPanel.add(escaleraTextField, gbc_escaleraTextField);
		escaleraTextField.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso:");
		GridBagConstraints gbc_lblPiso = new GridBagConstraints();
		gbc_lblPiso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPiso.gridx = 1;
		gbc_lblPiso.gridy = 4;
		formularioPanel.add(lblPiso, gbc_lblPiso);
		
		pisoTextField = new JTextField();
		GridBagConstraints gbc_pisoTextField = new GridBagConstraints();
		gbc_pisoTextField.insets = new Insets(0, 0, 5, 0);
		gbc_pisoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_pisoTextField.gridx = 3;
		gbc_pisoTextField.gridy = 4;
		formularioPanel.add(pisoTextField, gbc_pisoTextField);
		pisoTextField.setColumns(10);
		
		JLabel lblPuerta = new JLabel("Puerta:");
		GridBagConstraints gbc_lblPuerta = new GridBagConstraints();
		gbc_lblPuerta.insets = new Insets(0, 0, 0, 5);
		gbc_lblPuerta.gridx = 1;
		gbc_lblPuerta.gridy = 6;
		formularioPanel.add(lblPuerta, gbc_lblPuerta);
		
		puertaTextField = new JTextField();
		GridBagConstraints gbc_puertaTextField = new GridBagConstraints();
		gbc_puertaTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_puertaTextField.gridx = 3;
		gbc_puertaTextField.gridy = 6;
		formularioPanel.add(puertaTextField, gbc_puertaTextField);
		puertaTextField.setColumns(10);
		
		JPanel botonesPanel = new JPanel();
		jContentPane.add(botonesPanel, BorderLayout.SOUTH);
		
		guardarButton = new JButton("Guardar");
		guardarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inmueble inmueble=new Inmueble(Integer.parseInt(idTextField.getText()), escaleraTextField.getText(), pisoTextField.getText(), puertaTextField.getText(), 0);
				try {
					modelo.addInmueble(new Inmueble(Integer.parseInt(idTextField.getText()), escaleraTextField.getText(), pisoTextField.getText(), puertaTextField.getText(), 0));
					modelo.setFlag(true);
					dispose();
				} catch (InmuebleYaExiste e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "El inmueble que esta intentando guardar ya existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonesPanel.add(guardarButton);
		
		JButton volverButton = new JButton("Volver");
		volverButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonesPanel.add(volverButton);
		
		JLabel lblSergiuMarsavelaY = new JLabel(" ");
		lblSergiuMarsavelaY.setHorizontalAlignment(SwingConstants.CENTER);
		jContentPane.add(lblSergiuMarsavelaY, BorderLayout.NORTH);
	}

}
