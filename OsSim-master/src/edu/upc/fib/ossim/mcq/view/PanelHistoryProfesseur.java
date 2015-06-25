/**
 * 
 */
package edu.upc.fib.ossim.mcq.view;


import java.awt.Frame;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import edu.upc.fib.ossim.AppSession;
import edu.upc.fib.ossim.dao.FactoryDAO;
import edu.upc.fib.ossim.dao.TestRealiseDAO;
import edu.upc.fib.ossim.mcq.model.TestRealise;
import edu.upc.fib.ossim.mcq.view.PanelHistoryEtudiant.HeaderRenderer;
import edu.upc.fib.ossim.utils.EscapeDialog;

/**
 * @author Laure
 *
 */
public class PanelHistoryProfesseur extends EscapeDialog{

	private JTable historique;     
	private JScrollPane scrollPane;
	private int idTest;

	public PanelHistoryProfesseur(int idtest){
		this.idTest = idtest;
		initSpecifics();
	}

	public void initSpecifics() {
		this.setTitle("Test History");

		scrollPane = new JScrollPane();
		HistoriqueTableModel mHistoriqueTableModel = new HistoriqueTableModel(idTest);// à remplacer ou renvoyer le bon idtest
		historique = new JTable(mHistoriqueTableModel)		{
			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				// TODO Auto-generated method stub
				return new  HeaderRenderer(historique);
			}
		};
		historique.setRowHeight(30);

		JTableHeader header = historique.getTableHeader();

		header.setDefaultRenderer(new HeaderRenderer(historique));

		scrollPane.setSize(300, 300);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		scrollPane.setViewportView(historique);
		add(scrollPane);

		this.pack();


		//TODO check this function behavior in an applet environment
		this.setLocationRelativeTo((Frame)AppSession.getInstance().getApp());

	}

	private class HistoriqueTableModel extends  AbstractTableModel{

		private String[] columnNames = new String[] {
				"Students Names", "Mark","Date"
		};

		TestRealiseDAO mTestRealiseDAO;
		private Object[][] data;

		public HistoriqueTableModel(long idExercice){
			mTestRealiseDAO = FactoryDAO.getInstance().getTestRealiseDAO();
			List<TestRealise> listOfTest = mTestRealiseDAO.getListEtudiantsByTest(idExercice);
			data = new Object[listOfTest.size()][columnNames.length];
			int i = 0;
			for (TestRealise testRealise : listOfTest) {
				data[i][0] = testRealise.getNom();
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
