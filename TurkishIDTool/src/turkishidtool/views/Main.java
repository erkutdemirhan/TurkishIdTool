package turkishidtool.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import turkishidtool.exception.InvalidInputException;
import turkishidtool.model.TurkishIdImplementation;
import turkishidtool.model.TurkishIdToolInterface;
import turkishidtool.resources.Strings;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

/**
 * @author Erkut Demirhan
 * @date Feb 21, 2016
 *
 */
public class Main extends JFrame {

	private JPanel contentPanel;
	private JTextField idEntryField;

	private JButton btnVerifyID = new JButton(Strings.BTN_VERIFY_ID.toString());
	private JButton btnGenerateID = new JButton(Strings.BTN_GENERATE_ID.toString());
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		initComponents();
		createEvents();
	}
	
	private void initComponents() {
		setResizable(false);
		setTitle(Strings.APPLICATION_NAME.toString());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 280);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel verifyIDPanel = new JPanel();
		tabbedPane.addTab(Strings.TABNAME_VERIFY_ID.toString(), null, verifyIDPanel, null);
		
		idEntryField = new JTextField();
		idEntryField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idEntryField.setToolTipText("");
		idEntryField.setColumns(11);
		
		JLabel idEntryLabel = new JLabel("Enter ID (11 digits):");
		idEntryLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnVerifyID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_verifyIDPanel = new GroupLayout(verifyIDPanel);
		gl_verifyIDPanel.setHorizontalGroup(
			gl_verifyIDPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_verifyIDPanel.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_verifyIDPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(idEntryField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
						.addComponent(idEntryLabel))
					.addGap(45))
				.addGroup(Alignment.TRAILING, gl_verifyIDPanel.createSequentialGroup()
					.addContainerGap(71, Short.MAX_VALUE)
					.addComponent(btnVerifyID, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(68))
		);
		gl_verifyIDPanel.setVerticalGroup(
			gl_verifyIDPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_verifyIDPanel.createSequentialGroup()
					.addGap(35)
					.addComponent(idEntryLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(idEntryField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(btnVerifyID, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		verifyIDPanel.setLayout(gl_verifyIDPanel);
		
		JPanel generateIDPanel = new JPanel();
		tabbedPane.addTab(Strings.TABNAME_GENERATE_ID.toString(), null, generateIDPanel, null);
		
		btnGenerateID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_generateIDPanel = new GroupLayout(generateIDPanel);
		gl_generateIDPanel.setHorizontalGroup(
			gl_generateIDPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generateIDPanel.createSequentialGroup()
					.addGap(48)
					.addComponent(btnGenerateID)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_generateIDPanel.setVerticalGroup(
			gl_generateIDPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_generateIDPanel.createSequentialGroup()
					.addGap(70)
					.addComponent(btnGenerateID, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		generateIDPanel.setLayout(gl_generateIDPanel);
		
		JPanel aboutPanel = new JPanel();
		tabbedPane.addTab(Strings.TABNAME_ABOUT.toString(), null, aboutPanel, null);
		
		JTextArea txtAbout = new JTextArea();
		txtAbout.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtAbout.setBackground(new Color(240, 230, 140));
		txtAbout.setEditable(false);
		txtAbout.setLineWrap(true);
		txtAbout.setText(Strings.INFO.toString());
		GroupLayout gl_aboutPanel = new GroupLayout(aboutPanel);
		gl_aboutPanel.setHorizontalGroup(
			gl_aboutPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(txtAbout, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
		);
		gl_aboutPanel.setVerticalGroup(
			gl_aboutPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(txtAbout, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
		);
		aboutPanel.setLayout(gl_aboutPanel);
		contentPanel.setLayout(gl_contentPanel);
	}
	
	private void createEvents() {
		btnVerifyID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String entry = idEntryField.getText();
				TurkishIdToolInterface turkishIdTool = new TurkishIdImplementation();
				try {
					if(turkishIdTool.isValidID(entry)) {
						JOptionPane.showMessageDialog(null, Strings.MSG_TURKISH_ID.toString(), Strings.VERIFICATION_DIALOG_HEADER.toString(), JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, Strings.MSG_NON_TURKISH_ID.toString(), Strings.VERIFICATION_DIALOG_HEADER.toString(), JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (InvalidInputException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), Strings.VERIFICATION_DIALOG_HEADER.toString(), JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnGenerateID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TurkishIdToolInterface turkishIdTool = new TurkishIdImplementation();
				JOptionPane.showMessageDialog(null, turkishIdTool.generateID(), Strings.GENERATE_DIALOG_HEADER.toString(), JOptionPane.INFORMATION_MESSAGE);
			}
		});	
		
	}
}
