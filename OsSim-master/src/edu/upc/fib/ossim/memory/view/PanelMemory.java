package edu.upc.fib.ossim.memory.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import edu.upc.fib.ossim.memory.MemoryPresenter;
import edu.upc.fib.ossim.template.Presenter;
import edu.upc.fib.ossim.template.view.PanelTemplate;


/**
 * Main memory management panel. Tool bar allows process creation, memory settings managing, 
 * information view and time control apart from common actions such as: loading and saving simulations. <br/>
 * This panel contains 3 elements (painters), a physical memory scheme, a process queue and a 
 * a backing store where reside swapped processes. a secondary one with incoming processes and the cpu. 
 * In addition a legend shows fragmentation textures to identify them into memory      
 *  
 * @author Alex Macia
 * 
 * @see PanelTemplate
 * @see MemoryPainter
 * @see LegendPainter
 * @see QueuePainter
 * @see SwapPainter
 */
public class PanelMemory extends PanelTemplate { 
	private static final long serialVersionUID = 1L;
	public JScrollPane scrollv;

	/**
	 * Constructs a PanelMemory 
	 * 
	 * @param presenter	event manager
	 * @param keyLabelAdd	reference to add label string into bundle file	
	 */
	public PanelMemory(Presenter presenter, String keyLabelAdd) { 
		super(presenter, keyLabelAdd, "memory", true, true);
		
	}
	

	/**
	 * Adds components to panel, memory, fragmentation legend, process queue and backing store 
	 */
	public void initSpecificLayout() {
		
		VirtualMemoryPainter vmem = (VirtualMemoryPainter) presenter.getPainter(MemoryPresenter.VMEM_PAINTER);
		 scrollv = new JScrollPane();
		scrollv.setViewportView(vmem);
		scrollv.setPreferredSize(new Dimension(MemoryPresenter.MEMORY_WIDTH+10, MemoryPresenter.MEMORY_HEIGHT+10));
		scrollv.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		layout.putConstraint(SpringLayout.WEST, scrollv, 0, SpringLayout.WEST, header);
		layout.putConstraint(SpringLayout.NORTH, scrollv, 20, SpringLayout.SOUTH, header);
		pane.add(scrollv);
		
		MemoryPainter mem = (MemoryPainter) presenter.getPainter(MemoryPresenter.MEM_PAINTER);
		JScrollPane scroll0 = new JScrollPane();
		scroll0.setViewportView(mem);
		scroll0.setPreferredSize(new Dimension(MemoryPresenter.MEMORY_WIDTH+10, MemoryPresenter.MEMORY_HEIGHT+10));
		scroll0.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
		layout.putConstraint(SpringLayout.WEST, scroll0, 10, SpringLayout.EAST, scrollv);
		layout.putConstraint(SpringLayout.NORTH, scroll0, 20, SpringLayout.SOUTH, header);
		pane.add(scroll0);
		

		LegendPainter legend = new LegendPainter(MemoryPresenter.LEGEND_WIDTH, MemoryPresenter.LEGEND_HEIGTH);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, legend, 0, SpringLayout.HORIZONTAL_CENTER, scroll0);
		layout.putConstraint(SpringLayout.NORTH, legend, 10, SpringLayout.SOUTH, scroll0);
		pane.add(legend);
		
		QueuePainter procs = (QueuePainter) presenter.getPainter(MemoryPresenter.PROGS_PAINTER);
		JScrollPane scroll1 = new JScrollPane(procs);
		scroll1.setPreferredSize(new Dimension(MemoryPresenter.PROGRAMS_WIDTH+10, MemoryPresenter.PROGRAMS_HEIGHT+10));
		layout.putConstraint(SpringLayout.WEST, scroll1, 10, SpringLayout.EAST, scroll0);
		layout.putConstraint(SpringLayout.NORTH,scroll1, 0, SpringLayout.NORTH, scroll0);
		//layout.putConstraint(SpringLayout.EAST,scroll1, -10, SpringLayout.EAST, pane);
		pane.add(scroll1);

		SwapPainter swap = (SwapPainter) presenter.getPainter(MemoryPresenter.SWAP_PAINTER);
		JScrollPane scroll2 = new JScrollPane(swap);
		scroll2.setPreferredSize(new Dimension(MemoryPresenter.PROGRAMS_WIDTH+10, MemoryPresenter.PROGRAMS_HEIGHT+10));
		layout.putConstraint(SpringLayout.WEST, scroll2, 0, SpringLayout.WEST, scroll1);
		layout.putConstraint(SpringLayout.NORTH,scroll2, 10, SpringLayout.SOUTH, scroll1);
		//layout.putConstraint(SpringLayout.EAST,scroll2, -10, SpringLayout.EAST, pane);
		pane.add(scroll2);
	}

}
