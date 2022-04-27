package passwordManager;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

public class EntryList extends ArrayList<Entry> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> buttons;
	
	/**
	 * Constructor, creates new ArrayList of Entry and a new ArrayList of buttons
	 * corresponding to each entry.
	 */
	public EntryList() {
		super();
		buttons = new ArrayList<>();
	}
	
	/**
	 * adds a new Entry and button to the list
	 */
	public void newEntry() {
		Entry e = new Entry();
		super.add(e);
		
		JButton b = new JButton();
		buttons.add(b);
		
		ManagerGUI.entryPanel.addButtonForEntry(e);
	}
	
	/**
	 * deletes entry and removes the entry and button from the list
	 * @param entryindex
	 */
	public void removeEntry(int entryindex) {
		super.get(entryindex).deleteEntry();
		super.remove(entryindex);
		buttons.remove(entryindex);
		
	}
	
	
	public ArrayList<Entry> getEntries() {
		return this;
	}
	
	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	
	public void setButtons(ArrayList<JButton> buttons) {
		this.buttons = buttons;
	}
	
	public JButton getButton(int index) {
		return buttons.get(index);
	}
}
