package passwordManager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ListPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	// GUI Panels
	JPanel entryListPanel; // entries should show up in other ListPanel instances (if there is ever more than one)
	private JPanel entryDataPanel;
	private JPanel noSelectionPanel;
	
	private JPanel entryTitleContainer;
	private JPanel entryUsernameContainer;
	private JPanel entryPasswordContainer;
	private JPanel entryURLContainer;
	private JPanel buttonContainer;
	
	// GUI components
	private JLabel lblTitle;
	private JTextField fieldTitle;
	
	private JLabel lblUsername;
	private JTextField fieldUsername;
	
	private JLabel lblPassword;
	private JTextField fieldPassword;
	
	private JLabel lblURL;
	private JTextField fieldURL;
	
	private JButton btnSave;
	private JButton btnRemove;
	
	private JButton currButton;
	// other
	private static int currEntry;
	
	/**
	 * Create the frame.
	 */
	public ListPanel() {
		setLayout(new BorderLayout(15, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		createEntryListPanel();
		add(entryListPanel, BorderLayout.WEST);
		
		createNoSelectionPanel();
		add(noSelectionPanel, BorderLayout.CENTER);
		
		createEntryDataPanel();
	}

	/**
	 * create container for the entry's buttons
	 */
	private void createEntryListPanel() {
		entryListPanel = new JPanel();
		entryListPanel.setLayout(new BoxLayout(entryListPanel, BoxLayout.Y_AXIS));
		entryListPanel.setBorder(new EmptyBorder(20,20,20,20)); // right is 0
		entryListPanel.setBackground(Color.LIGHT_GRAY);
	}
	
	/**
	 * panel to display when no entries are selected
	 */
	private void createNoSelectionPanel() {
		noSelectionPanel = new JPanel();
		noSelectionPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSelect = new JLabel("Select or Create an Entry");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setVerticalAlignment(SwingConstants.CENTER);
		noSelectionPanel.add(lblSelect, BorderLayout.CENTER);
	}
	
	/**
	 * create container to display data on an entry
	 */
	private void createEntryDataPanel() {
		entryDataPanel = new JPanel();
		entryDataPanel.setLayout(new BoxLayout(entryDataPanel, BoxLayout.Y_AXIS));
		entryDataPanel.setBorder(new EmptyBorder(10, 0, 10, 20)); // right is 20
		
		createEntryTitleContainer();
		entryDataPanel.add(entryTitleContainer);
		
		createEntryUsernameContainer();
		entryDataPanel.add(entryUsernameContainer);
		
		createEntryPasswordContainer();
		entryDataPanel.add(entryPasswordContainer);
		
		createEntryURLContainer();
		entryDataPanel.add(entryURLContainer);
		
		createButtonContainer();
		entryDataPanel.add(buttonContainer);
	}
	
	private void createEntryTitleContainer() { //CreateEntryTitleContainer(Entry exampleEntryObj)
		entryTitleContainer = new JPanel();
		lblTitle = new JLabel("Title: ");
		fieldTitle = new JTextField();
		fieldTitle.setPreferredSize(new Dimension(250, 20));
		
		entryTitleContainer.add(lblTitle);
		entryTitleContainer.add(fieldTitle);
	}
	
	private void createEntryUsernameContainer() {
		entryUsernameContainer = new JPanel();
		lblUsername = new JLabel("Username: ");
		fieldUsername = new JTextField();
		fieldUsername.setPreferredSize(new Dimension(250, 20));
		
		entryUsernameContainer.add(lblUsername);
		entryUsernameContainer.add(fieldUsername);
	}
	
	private void createEntryPasswordContainer() {
		entryPasswordContainer = new JPanel();
		lblPassword = new JLabel("Password: ");
		fieldPassword = new JTextField();
		fieldPassword.setPreferredSize(new Dimension(250, 20));
		
		entryPasswordContainer.add(lblPassword);
		entryPasswordContainer.add(fieldPassword);
	}
	
	private void createEntryURLContainer() {
		entryURLContainer = new JPanel();
		lblURL = new JLabel("URL: ");
		fieldURL = new JTextField();
		fieldURL.setPreferredSize(new Dimension(250, 20));
		
		entryURLContainer.add(lblURL);
		entryURLContainer.add(fieldURL);
	}
	
	/**
	 * contains btnSave and btnRemove
	 */
	private void createButtonContainer() {
		buttonContainer = new JPanel();
		
		createBtnSave();
		createBtnRemove();
		
		buttonContainer.add(btnSave);
		buttonContainer.add(btnRemove);
	}

	/**
	 * creates btnSave. Writes new values to disk when clicked.
	 */
	private void createBtnSave() {
		btnSave = new JButton();
		btnSave.setText("Save Changes");
		btnSave.setPreferredSize(new Dimension(200, 30));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerGUI.listEntries.get(currEntry).setTitle(fieldTitle.getText());
				ManagerGUI.listEntries.get(currEntry).setUsername(fieldUsername.getText());
				ManagerGUI.listEntries.get(currEntry).setPassword(fieldPassword.getText());
				ManagerGUI.listEntries.get(currEntry).setURL(fieldURL.getText());
				
				//ManagerGUI.listEntries.updateButtonText(currEntry); // doesn't work well 
				ManagerGUI.serialize();
				refresh();
				
				ManagerGUI.updatePageTo(ManagerGUI.entryPanel);
			}
		});
	}
	
	/**
	 * creates btnRemove. Removes values from disk when clicked.
	 */
	private void createBtnRemove() {
		btnRemove = new JButton();
		btnRemove.setText("Remove Entry");
		btnRemove.setPreferredSize(new Dimension(200, 30));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// remove the entry from the list and remove the button corresponding to the currEntry
				ManagerGUI.listEntries.removeEntry(currEntry);
				
				ManagerGUI.serialize();
				refresh();
				
				remove(entryDataPanel);
				add(noSelectionPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
				
				ManagerGUI.updatePageTo(ManagerGUI.entryPanel);
			}
		});
	}
	
	/**
	 * adds a button to entryListPanel for a given entry
	 * @param entry
	 */
	public void addButtonForEntry(Entry entry) {
		JButton button = ManagerGUI.listEntries.getButton(ManagerGUI.listEntries.indexOf(entry));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currEntry = ManagerGUI.listEntries.indexOf(entry);
				
				fieldTitle.setText(entry.getTitle());
				fieldPassword.setText(entry.getPassword());
				fieldUsername.setText(entry.getUsername());
				fieldURL.setText(entry.getURL());
				
				ManagerGUI.serialize();
				
				remove(noSelectionPanel);
				add(entryDataPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		button.setText(entry.getTitle());
		entryListPanel.add(button);
	}
	
	/**
	 * removes all entry buttons in entryListPanel and then adds a button for each entry in ListEntries
	 */
	private void refresh() {
		entryListPanel.removeAll();
		for (Entry entry : ManagerGUI.listEntries) {
			addButtonForEntry(entry);
		}
	}
}