/**
 * 
 */
package edu.upc.fib.ossim.mcq.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

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
	private int idEtudiant;
	
	public PanelHistoryEtudiant(){
		if(PanelAuthentification.mEtudiant != 0)
		this.idEtudiant = PanelAuthentification.mEtudiant;

		initSpecifics();
	}

	public void initSpecifics() {
		this.setTitle("Student History");

		scrollPane = new JScrollPane();
		HistoriqueTableModel mHistoriqueTableModel = new HistoriqueTableModel(idEtudiant);
		historique = new JTable(mHistoriqueTableModel){
			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				// TODO Auto-generated method stub
				return new  HeaderRenderer(historique);
			}
		};
		historique.setRowHeight(30);
		
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JTableHeader header = historique.getTableHeader();
		
		header.setDefaultRenderer(new HeaderRenderer(historique));
		scrollPane.setSize(300, 300);
		
		scrollPane.setViewportView(historique);
		add(scrollPane);

		this.pack();
		

		//TODO check this function behavior in an applet environment
		this.setLocationRelativeTo((Frame)AppSession.getInstance().getApp());

	}

	
	private class HistoriqueTableModel extends  AbstractTableModel{

		private String[] columnNames = new String[] {
				"Test Title", "Mark","Date"
		};

		TestRealiseDAO mTestRealiseDAO;
		private Object[][] data;
		
		public HistoriqueTableModel(long idEtudiant){
			mTestRealiseDAO = FactoryDAO.getInstance().getTestRealiseDAO();
			List<TestRealise> listOfTest = mTestRealiseDAO.getListTestsByEtudiant(idEtudiant);
			data = new Object[listOfTest.size()][columnNames.length];
			int i = 0;
			for (TestRealise testRealise : listOfTest) {
				data[i][0] = testRealise.getTitreExerice();
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
	
	public static class HeaderRenderer implements TableCellRenderer {

	    
	    private JLabel l = new JLabel();

	    public HeaderRenderer(JTable table) {
	       
	        table.getTableHeader().setPreferredSize(new Dimension(5, 40));
	        l.setOpaque(true);
	    }

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			
			if (row==-1 ){
				l.setFont(new Font("SansSerif",Font.BOLD,13));
				l.setBackground(Color.GRAY);
				l.setForeground(Color.WHITE);
				
			}
			else{
				l.setFont(new Font("SansSerif",Font.PLAIN,11));
				if(row%2 ==0)
					l.setBackground(Color.WHITE);
				else
					l.setBackground(Color.LIGHT_GRAY);
			}

			l.setToolTipText(value.toString());
			l.setHorizontalAlignment(JLabel.CENTER);
			l.setVerticalAlignment(JLabel.CENTER);
			l.setText(value.toString());
			
			return l;
		}
	}
}
