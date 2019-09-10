package visão;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Cadastro_Unidade extends JFrame {

	private JPanel contentPane;
	private JLabel lblCadastroTipo;
	private JTextField txtNome;
	private JLabel lblNome;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	public Cadastro_Unidade() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//para não fechar todos os frames
		setBounds(100, 100, 367, 228);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblCadastroTipo());
		contentPane.add(getTxtNome());
		contentPane.add(getLblNome());
		contentPane.add(getBtnConfirmar());
		contentPane.add(getBtnCancelar());
	}
	public JLabel getLblCadastroTipo() {
		if (lblCadastroTipo == null) {
			lblCadastroTipo = new JLabel("CADASTRO UNIDADE");
			lblCadastroTipo.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblCadastroTipo.setBounds(0, 0, 281, 30);
		}
		return lblCadastroTipo;
	}
	public JTextField getTxtNome() {
		if (txtNome == null) {
			txtNome = new JTextField();
			txtNome.setBounds(30, 67, 289, 20);
			txtNome.setColumns(10);
		}
		return txtNome;
	}
	public JLabel getLblNome() {
		if (lblNome == null) {
			lblNome = new JLabel("Nome:");
			lblNome.setBounds(30, 55, 46, 14);
		}
		return lblNome;
	}
	public JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(154, 155, 89, 23);
		}
		return btnConfirmar;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(252, 155, 89, 23);
		}
		return btnCancelar;
	}
}
