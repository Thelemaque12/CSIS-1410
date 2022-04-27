package passwordManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.security.*;
/**
 * 
 * @author Gabriel Perillo, Jefson Simeus
 */
public class ManagerGUI extends JFrame {
	
	// GUI Panels
	private static JPanel contentPane;
	public static ListPanel entryPanel;
	private static JPanel unlockPanel;
	private static JPanel controlPanel;
	private static GeneratorPanel generatorPanel;
	
	// GUI Components
	private Button btnNewEntry;
	private Button btnLockPasswords;
	private Button btnList;
	private Button btnGenerator;
	
	// Other
	public static EntryList listEntries = new EntryList();
	
	/*
	 * 0 = unlockPanel
	 * 1 = entryPanel
	 * 2 = generatorPanel
	 */
	private static int currentPanel = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerGUI frame = new ManagerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. This is the root container for the Application.
	 */
	public ManagerGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setTitle("Password Manager Proof of Concept");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.NORTH);
		
		entryPanel = new ListPanel();
		contentPane.add(entryPanel, BorderLayout.CENTER);
		
		generatorPanel = new GeneratorPanel();
		
		loadExistingEntries();
		
		
	}
	
	/**
	 * Creates Container for the main buttons.
	 * @return controlPanel
	 */
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(new Color(211, 211, 211));
		controlPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
		controlPanel.setLayout(new GridLayout(1, 4, 10, 0));
		
		// create controlPanel Buttons
		btnList = createControlPanelBtn("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePageTo(entryPanel);
				currentPanel = 1;
			}
		});
		controlPanel.add(btnList);
		
		btnGenerator = createControlPanelBtn("Generator");
		btnGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePageTo(generatorPanel);
				currentPanel = 2;
			}
		});
		controlPanel.add(btnGenerator);
		
		btnNewEntry = createControlPanelBtn("New Entry");
		btnNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listEntries.newEntry();
				updatePageTo(entryPanel);
				
				// click button to show new Entry's data
				int size = entryPanel.entryListPanel.getComponentCount();
				((AbstractButton) entryPanel.entryListPanel.getComponent(size-1)).doClick();
				currentPanel = 1;
				
				
			}
		});
		controlPanel.add(btnNewEntry);
		
		btnLockPasswords = createControlPanelBtn("Lock Passwords");
		btnLockPasswords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unlockPage unlock = new unlockPage();
				unlock.setVisible(true);
				dispose();
			}
		});
		controlPanel.add(btnLockPasswords);
		
		return controlPanel;
	}
	
	/**
	 * Create a new button with the text parameter. Configures buttons to needed values and avoids code duplication.
	 * @param text
	 * @return b
	 */
	private Button createControlPanelBtn(String text) {
		Button b = new Button(text);
		b.setFont(new Font("Dialog", Font.PLAIN, 16));
		b.setBackground(new Color(255, 255, 255));
		return b;
	}
	
	/**
	 * Removes the JPanel currently displayed on BorderLayout.CENTER and adds the parameter panel to BorderLayout.CENTER
	 * @param panel
	 */
	public static void updatePageTo(JPanel panel) {
		
		switch (currentPanel) {
			case 0:
				contentPane.remove(unlockPanel);
				break;
			case 1:
				contentPane.remove(entryPanel);
				break;
			case 2:
				contentPane.remove(generatorPanel);
		}
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	/**
	 * reads entries from list.ser
	 */
	public static void deserialize() {
		listEntries = null;
	      try {
	          FileInputStream fileIn = new FileInputStream("list.ser");
	          ObjectInputStream streamIn = new ObjectInputStream(fileIn);
	          listEntries = (EntryList) streamIn.readObject();
	          streamIn.close();
	          fileIn.close();
	       } catch (IOException e) {
	          e.printStackTrace();
	          return;
	       } catch (ClassNotFoundException e) {
	          e.printStackTrace();
	          return;
	       }
	}
	
	/**
	 * writes entries to list.ser
	 */
	public static void serialize() {
	      try {
	          FileOutputStream fileOut = new FileOutputStream("list.ser");
	          ObjectOutputStream streamOut = new ObjectOutputStream(fileOut);
	          streamOut.writeObject(listEntries);
	          streamOut.close();
	          fileOut.close();
	       } catch (IOException e) {
	          e.printStackTrace();
	       }
	}
	
	/**
	 * method that determines whether there are existing entries on disk.
	 * @return
	 */
	private static boolean entriesExist() {
		Path path = Paths.get("list.ser");
		return Files.exists(path);
	}
	
	/**
	 * populates program with entries on the disk.
	 */
	public static void loadExistingEntries() {
		if (entriesExist()) {
			deserialize();
			for (Entry entry : listEntries) {
				entryPanel.addButtonForEntry(entry);
			}
		}
	}
}