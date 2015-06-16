/**
 * 
 */
package edu.upc.fib.ossim.mcq.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import edu.upc.fib.ossim.AppSession;
import edu.upc.fib.ossim.dao.FactoryDAO;
import edu.upc.fib.ossim.dao.TestRealiseDAO;
import edu.upc.fib.ossim.mcq.model.TestRealise;
import edu.upc.fib.ossim.utils.EscapeDialog;




/**
 * @author Laure
 *
 */
public class PanelHistoryEtudiant extends EscapeDialog {

	private JTable historique;     
	private JScrollPane scrollPane;
	private long idEtudiant;
	
	public PanelHistoryEtudiant(){
		if(PanelAuthentification.mEtudiant != null)
		this.idEtudiant = PanelAuthentification.mEtudiant.getIdEtudiant();

		initSpecifics();
	}

	public void initSpecifics() {
		this.setTitle("Historique");

		scrollPane = new JScrollPane();
		HistoriqueTableModel mHistoriqueTableModel = new HistoriqueTableModel(idEtudiant);
		historique = new JTable(mHistoriqueTableModel);
		historique.setRowHeight(30);
		historique.getTableHeader().setPreferredSize(new Dimension(5, 50));

		scrollPane.setSize(300, 300);
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setViewportView(historique);
		add(scrollPane);

		this.pack();
		

		//TODO check this function behavior in an applet environment
		this.setLocationRelativeTo((Frame)AppSession.getInstance().getApp());

	}

	
	private class HistoriqueTableModel extends  AbstractTableModel{

		private String[] columnNames = new String[] {
				"Titre Test", "Note","Date De Passage"
		};

		TestRealiseDAO mTestRealiseDAO;
		private Object[][] data;
		
		public HistoriqueTableModel(long idEtudiant){
			mTestRealiseDAO = FactoryDAO.getInstance().getTestRealiseDAO();
			List<TestRealise> listOfTest = mTestRealiseDAO.getListTestsByEtudiant(idEtudiant);
			data = new Object[listOfTest.size()][columnNames.length];
			int i = 0;
			for (TestRealise testRealise : listOfTest) {
				data[i][0] = testRealise.getIdExerice().getTitreExercice();
				data[i][1] = testRealise.getNote();
				data[i][2] = testRealise.getDatePassageTest();
				i++;
			}
			

			
		}
		
		public int getColumnCount() {
	        return columnNames.length;
	    }

	    public int getRowCount() {
	        return data.length;
	    }

	    public String getColumnName(int col) {
	        return columnNames[col];
	    }
	    
	    public boolean isCellEditable(int row, int col) {
	      
	            return false;
	       
	    }

	    public Object getValueAt(int row, int col) {
	        return data[row][col];
	    }


	    

	}


}
