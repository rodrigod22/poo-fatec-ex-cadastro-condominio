package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Model.Condominio;
import Model.Endereco;
import Model.Estado;
import Model.Unidade;
import repository.CondominioRepository;

public class ViewCadastroCondominio extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField cnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JFormattedTextField txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
	private JComboBox<Estado> comboUf = new JComboBox();
	private JComboBox<String>comboCondominios = new JComboBox();
	private JComboBox<String> comboCondominiosBusca = new JComboBox();
	private JComboBox<String> comboUnidades = new JComboBox();
	private CondominioRepository repository = new CondominioRepository();
	private JTextField txtnumeroUnidade;
	private JTextField txtNomeResponsavel;
	private JFormattedTextField txtCpfResponsavel = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
	private ArrayList<Condominio> lista = (ArrayList<Condominio>) repository.getCondominios();
	private JTextField nomeBusca;
	private JTextField cnpjBusca;
	private JTextField ruaBusca;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField NomeRespBusca;
	private JTextField cpfBusca;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroCondominio frame = new ViewCadastroCondominio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewCadastroCondominio() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel cadCond = new JPanel();
		tabbedPane.addTab("Cadastro condominio", null, cadCond, null);
		
		JLabel lblCadastroCondominio = new JLabel("CADASTRO CONDOMINIO");
		lblCadastroCondominio.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 16));		
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplemento.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Cidade");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("UF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidade.setColumns(10);		
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 16));		
		
		txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCep.setColumns(10);			
	
		comboUf.setModel(new DefaultComboBoxModel<Estado>(Estado.values()));				
		
		/*ACOES BOTOES*/
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {					
				Condominio c = cadastroCondominio();		
				if(c != null) {
					repository.addCondominio(c);					
					comboCondominios.removeAllItems();
					comboCondominiosBusca.removeAllItems();
					for (Condominio cond : repository.getCondominios()) {			
						comboCondominios.addItem(cond.getNome());	
						comboCondominiosBusca.addItem(cond.getNome());
				    }
				}			
			}
		});		
	
		JButton btnCadastroUnidade = new JButton("cadastrar");
		btnCadastroUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastroUnidade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String condominioUnidade = (String) comboCondominios.getSelectedItem();
				Unidade unidade = cadastroUnidade();
				
				for (Condominio condominio : lista) {
					if(condominio.getNome().equals(condominioUnidade)) {
						condominio.addUnidade(unidade);						
					}
				}				
			}
		});		
		
		JButton btnBusca = new JButton("Buscar");
		
		btnBusca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Condominio condBusca = buscaCondominio(comboCondominiosBusca.getSelectedItem());
				comboUnidades.removeAllItems();
				for (Unidade unidade :condBusca.getUnidade()) {
					comboUnidades.addItem(unidade.getNumero());
				}
				
				nomeBusca.setText(condBusca.getNome());
				
				comboUnidades.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						for (Unidade unidade : condBusca.getUnidade()) {
							
							if(unidade.equals(comboUnidades.getSelectedItem())) {
								System.out.println(unidade.getNumero());
							}
						}						
					}
				});
			}
		});	
		
		JButton btnLimpaCondominio = new JButton("limpar");
		btnLimpaCondominio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnLimpaCondominio.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    limpaCamposCondominio();				
			}
		});		
		
		GroupLayout gl_cadCond = new GroupLayout(cadCond);
		gl_cadCond.setHorizontalGroup(
			gl_cadCond.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadCond.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cadCond.createSequentialGroup()
							.addComponent(lblRua)
							.addContainerGap())
						.addGroup(gl_cadCond.createSequentialGroup()
							.addGroup(gl_cadCond.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtRua, Alignment.LEADING, 409, 409, 409)
								.addComponent(lblCadastroCondominio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_cadCond.createSequentialGroup()
									.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(btnLimpaCondominio))
								.addGroup(gl_cadCond.createSequentialGroup()
									.addComponent(lblBairro)
									.addPreferredGap(ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
									.addGroup(gl_cadCond.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_cadCond.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addGap(144)))))
							.addGap(24)
							.addGroup(gl_cadCond.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_cadCond.createSequentialGroup()
									.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addGap(276))
								.addGroup(gl_cadCond.createSequentialGroup()
									.addGroup(gl_cadCond.createParallelGroup(Alignment.LEADING)
										.addComponent(cnpj, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_cadCond.createSequentialGroup()
											.addGroup(gl_cadCond.createParallelGroup(Alignment.LEADING)
												.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNumero)
												.addComponent(lblNewLabel_1)
												.addComponent(comboUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(gl_cadCond.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblCep)
												.addComponent(lblComplemento)
												.addComponent(txtComplemento)
												.addComponent(txtCep))))
									.addGap(40))))
						.addGroup(gl_cadCond.createSequentialGroup()
							.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_cadCond.setVerticalGroup(
			gl_cadCond.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadCond.createSequentialGroup()
					.addGap(29)
					.addComponent(lblCadastroCondominio, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua)
						.addComponent(lblNumero)
						.addComponent(lblComplemento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel)
						.addComponent(lblCep))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(78)
					.addGroup(gl_cadCond.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpaCondominio))
					.addContainerGap(163, Short.MAX_VALUE))
		);
		cnpj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cadCond.setLayout(gl_cadCond);
		
		JPanel cadUnid = new JPanel();
		tabbedPane.addTab("Cadastro unidade", null, cadUnid, null);
		
		JLabel lblCadastroUnidade = new JLabel("CADASTRO UNIDADE");
		lblCadastroUnidade.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_2 = new JLabel("Condominio");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNumero_1 = new JLabel("Numero");
		lblNumero_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtnumeroUnidade = new JTextField();
		txtnumeroUnidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtnumeroUnidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome responsavel");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtNomeResponsavel = new JTextField();
		txtNomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeResponsavel.setColumns(10);
		
		JLabel lblCpfl = new JLabel("CPF");
		lblCpfl.setFont(new Font("Tahoma", Font.PLAIN, 16));		
		
		txtCpfResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpfResponsavel.setColumns(10);	
		
		GroupLayout gl_cadUnid = new GroupLayout(cadUnid);
		gl_cadUnid.setHorizontalGroup(
			gl_cadUnid.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadUnid.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_cadUnid.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastroUnidade)
						.addGroup(gl_cadUnid.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblCpfl)
							.addComponent(lblNewLabel_3)
							.addComponent(txtnumeroUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNumero_1)
							.addComponent(comboCondominios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2)
							.addComponent(lblCadastroUnidade, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNomeResponsavel, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
							.addComponent(txtCpfResponsavel)))
					.addContainerGap(470, Short.MAX_VALUE))
		);
		gl_cadUnid.setVerticalGroup(
			gl_cadUnid.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadUnid.createSequentialGroup()
					.addGap(31)
					.addComponent(lblCadastroUnidade, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboCondominios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNumero_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtnumeroUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNomeResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblCpfl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCpfResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(69)
					.addComponent(btnCadastroUnidade)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		cadUnid.setLayout(gl_cadUnid);
		
		JPanel cadBusca = new JPanel();
		tabbedPane.addTab("Busca", null, cadBusca, null);
		
		JLabel lblBuscaCondominio = new JLabel("BUSCA CONDOMINIO");
		lblBuscaCondominio.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		JPanel panel = new JPanel();		
		GroupLayout gl_cadBusca = new GroupLayout(cadBusca);
		gl_cadBusca.setHorizontalGroup(
			gl_cadBusca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadBusca.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_cadBusca.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBusca)
						.addComponent(comboCondominiosBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBuscaCondominio)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 706, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		gl_cadBusca.setVerticalGroup(
			gl_cadBusca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cadBusca.createSequentialGroup()
					.addGap(23)
					.addComponent(lblBuscaCondominio)
					.addGap(18)
					.addComponent(comboCondominiosBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnBusca)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		nomeBusca = new JTextField();
		nomeBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeBusca.setColumns(10);
		
		JLabel lblCnpj_1 = new JLabel("CNPJ");
		lblCnpj_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cnpjBusca = new JTextField();
		cnpjBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cnpjBusca.setColumns(10);
		
		JLabel lblRua_1 = new JLabel("Rua");
		lblRua_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		ruaBusca = new JTextField();
		ruaBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ruaBusca.setColumns(10);
		
		JLabel lblNumero_2 = new JLabel("Numero");
		lblNumero_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JLabel lblNewLcomplementoabel = new JLabel("Complemento");
		lblNewLcomplementoabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		
		JLabel lblBairro_1 = new JLabel("Bairro");
		lblBairro_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		
		JLabel lblLabel = new JLabel("Cidade");
		lblLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblCep_1 = new JLabel("CEP");
		lblCep_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNomeResponsavel = new JLabel("Nome Responsavel");
		lblNomeResponsavel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		NomeRespBusca = new JTextField();
		NomeRespBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NomeRespBusca.setColumns(10);
		
		cpfBusca = new JTextField();
		cpfBusca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cpfBusca.setColumns(10);		
		
		table = new JTable();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNome_1, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addGap(359))
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(lblNomeResponsavel)
													.addComponent(NomeRespBusca, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE))
												.addGap(8))
											.addComponent(ruaBusca, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
											.addComponent(nomeBusca, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
														.addGap(18))
													.addGroup(gl_panel.createSequentialGroup()
														.addComponent(lblBairro_1)
														.addGap(159)))
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(lblLabel)
													.addComponent(textField_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
										.addGap(18)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblRua_1)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblCnpj_1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
										.addGap(258))
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lblUf)
													.addComponent(lblNumero_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(textField, 0, 0, Short.MAX_VALUE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lblNewLcomplementoabel)
													.addComponent(lblCep_1)
													.addComponent(textField_4)
													.addComponent(textField_1))
												.addGap(10))
											.addComponent(cpfBusca, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
										.addGap(314))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(cnpjBusca, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCpf)
									.addContainerGap())))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUnidades)
								.addComponent(comboUnidades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(64)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(566, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCnpj_1)
						.addComponent(lblNome_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nomeBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cnpjBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLcomplementoabel)
						.addComponent(lblNumero_2)
						.addComponent(lblRua_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ruaBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBairro_1)
								.addComponent(lblLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUf)
								.addComponent(lblCep_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblUnidades)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboUnidades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeResponsavel)
						.addComponent(lblCpf))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(NomeRespBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cpfBusca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		cadBusca.setLayout(gl_cadBusca);
	}
	
	public Condominio cadastroCondominio() {
		cnpj.setFocusLostBehavior(NORMAL);
		txtCep.setFocusLostBehavior(NORMAL);
		if(validaCondominio()) {
			Condominio cond = new Condominio();		
			Endereco end = new Endereco()
			.setLogradouro(txtRua.getText())
			.setNumero(txtNumero.getText())
			.setComplemento(txtComplemento.getText())
			.setBairro(txtBairro.getText())
			.setCidade(txtCidade.getText())
			.setCep(txtCep.getText())	
			.setEstado((Estado)comboUf.getModel().getSelectedItem());
			cond.setNome(txtNome.getText())
			.setCnpj(cnpj.getText())	
			.setEndereco(end);
			limpaCamposCondominio();
			return cond;
		}
		return null;	
	}
	
	public void limpaCamposCondominio() {
		txtNome.setText("");
		cnpj.setText("");
		txtRua.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtCep.setText("");		
	}
	
	public boolean validaCondominio() {		
		if(txtNome.getText().equals("") || txtRua.getText().equals("") || txtNumero.getText().equals("") || txtBairro.getText().equals("") ||
				txtCidade.getText().equals("")) {			
			JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro", 0);			
			return false;
		}else if(cnpj.getText().trim().length() < 18) {			
			JOptionPane.showMessageDialog(null, "CNPJ Incompleto", "Erro", 0);
			return false;
		}else if(txtCep.getText().trim().length() < 9) {
			JOptionPane.showMessageDialog(null, "CEP Incompleto", "Erro", 0);
			return false;
		}
		return true;
	}
	
	public Unidade cadastroUnidade() {
		Unidade unidade = new Unidade()
		.setNumero(txtnumeroUnidade.getText())
		.setCpf(txtCpfResponsavel.getText())
		.setNomeResponsavel(txtNomeResponsavel.getText());
		return unidade;
	}
	
	public Condominio buscaCondominio(Object object) {
		for (Condominio condominio : repository.getCondominios()) {
			if(condominio.getNome().equals(object)) {
				System.out.println(condominio);
				return condominio;				
			}
		}
		return new Condominio();		
	}	
}
