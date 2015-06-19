package edu.upc.fib.ossim.mcq.view;

import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.upc.fib.ossim.AppSession;
import edu.upc.fib.ossim.Home;
import edu.upc.fib.ossim.Menu;
import edu.upc.fib.ossim.OSSimFrame;
import edu.upc.fib.ossim.dao.EtudiantDAO;
import edu.upc.fib.ossim.dao.FactoryDAO;
import edu.upc.fib.ossim.dao.ProfesseurDAO;
import edu.upc.fib.ossim.mcq.MCQSession;
import edu.upc.fib.ossim.mcq.model.Etudiant;
import edu.upc.fib.ossim.mcq.model.Professeur;
import edu.upc.fib.ossim.utils.EscapeDialog;

public class PanelAuthentification extends EscapeDialog implements ActionListener{


	public static  enum Module{mcq, mcqc};
	FactoryDAO mFactoryDAO;
	private JLabel lblLogin = null;
	private JLabel lblpass = null;
	private JTextField tfLogin = null;
	private static PanelAuthentification instance = null;
	private JPasswordField tfPass = null;
	private JButton btnConnect = null;
	public static int mEtudiant = 0;
	public static int mProfesseur = 0;
	private static String catEtudiant =  "Etudiant";
	private static String catProfesseur =  "Professeur";
	private Module module;
	static String slected;
	String[] catStrings = {catEtudiant, catProfesseur };
	JComboBox catList ;
	public PanelAuthentification( Module module) {
		mFactoryDAO = FactoryDAO.getInstance();
		initSpecifics();
		this.module = module;
	}

	public void initSpecifics() {
		this.setTitle("Connexion");

		//TODO move the labels to a seperate langugage file and use the Translation class to change between languages
		lblLogin = new JLabel("Login:");
		lblpass = new JLabel("Password:");
		tfLogin  = new JTextField();
		tfPass = new JPasswordField();

		btnConnect =new JButton("Connecter");
		btnConnect.addActionListener(this);

		catList = new JComboBox(catStrings);
		catList.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		catList.setSelectedIndex(0);


		sortComponents();

		this.pack();
		this.setVisible(true);
		this.setResizable(false);

		//TODO check this function behavior in an applet environment
		this.setLocationRelativeTo((Frame)AppSession.getInstance().getApp());

	}

	@Override
	public void setVisible(boolean b) {

		if ((mEtudiant != 0)||(mProfesseur != 0)){
			super.setVisible(false);
			if (module == Module.mcq) 
				//MCQSession.getInstance().getMCQChooserDialog().setVisible(true);
				MCQSession.getInstance().getMCQDisplayExo().setVisible(true);
			else if (module == Module.mcqc && slected.compareTo(catEtudiant) != 0 ){
				MCQSession.destroyInstance();
				MCQSession.getInstance();
				MCQSession.getInstance().getMediumPanel();
			}
			else if( slected.compareTo(catEtudiant) == 0  && module == Module.mcqc)
				JOptionPane.showMessageDialog(this, "like Student, you don't have access to this module !!!", "Access Denied", JOptionPane.ERROR_MESSAGE);
		}
		else  super.setVisible(b);	
	}

	public void sortComponents() {
		Container pane = this.getContentPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

		this.setSize(300, 200);
		JPanel typePanel = new JPanel(new GridLayout(7,1));

		typePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		typePanel.add(lblLogin);
		typePanel.add(tfLogin);
		typePanel.add(lblpass);		
		typePanel.add(tfPass);
		typePanel.add(catList);

		typePanel.add(btnConnect);

		add(typePanel);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnConnect))
		{
			slected = (String) catList.getModel().getSelectedItem();
			String login = tfLogin.getText();
			String pass = tfPass.getText();
			Menu menu = null;
			if(slected.compareTo(catEtudiant) == 0){

				EtudiantDAO mEtudiantDAO = mFactoryDAO.getEtudiantDao();
				mEtudiant= mEtudiantDAO.getIdEtudiant(login, pass);

				if(mEtudiant != 0){

					this.dispose();
					if (module == Module.mcq){
						//MCQSession.getInstance().getMCQChooserDialog().setVisible(true);
						JOptionPane.showMessageDialog(instance, "Connection successful!", "connexion", JOptionPane.INFORMATION_MESSAGE);
						//mainfraime.dispose();
						//OSSimFrame mainFrame = new OSSimFrame();  
						MCQSession.getInstance().getMCQDisplayExo().setVisible(true);
					}
					else 
						JOptionPane.showMessageDialog(this, "like Student, you don't have access to this module !!!", "Access Denied", JOptionPane.ERROR_MESSAGE);
				}else
					JOptionPane.showMessageDialog(this, "Connection Fail: Login, password or status incorrect !!!", "Connection Failed", JOptionPane.ERROR_MESSAGE);
			}else{
				ProfesseurDAO mProfesseurDAO = mFactoryDAO.getProfesseurDAO();
				mProfesseur = mProfesseurDAO.getProfesseurId(login, pass);
				if(mProfesseur != 0){
					this.dispose();
					if (module == Module.mcq){
						//MCQSession.getInstance().getMCQChooserDialog().setVisible(true);
						JOptionPane.showMessageDialog(instance, "Connection successful!", "connexion", JOptionPane.INFORMATION_MESSAGE);
						//OSSimFrame mainFrame = new OSSimFrame(); 
						MCQSession.getInstance().getMCQDisplayExo().setVisible(true);
					}
					if (module == Module.mcqc){
						JOptionPane.showMessageDialog(instance, "Connection successful!", "connexion", JOptionPane.INFORMATION_MESSAGE);
						//OSSimFrame mainFrame = new OSSimFrame(); 
						MCQSession.destroyInstance();
						MCQSession.getInstance();
						MCQSession.getInstance().getMediumPanel();
					}

				}else
					JOptionPane.showMessageDialog(this, "Connection Fail: Login, password or status incorrect !!!", "Connection Failed", JOptionPane.ERROR_MESSAGE);
			}
		}


	}



}
