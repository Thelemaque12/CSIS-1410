package passwordManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BoxLayout;

/**
 * GUI Panel with randomized password generation feature.
 * @author Jefson Simeus, Gabriel Perillo
 */
public class GeneratorPanel extends JPanel implements ChangeListener {
	
	// random object
	private static Random rand = new Random();
	
	// Possible chars in password
	private static String lower = "abcdefghijklmnopqrstuvwxyz";
    private static String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String symbols = "~`!@#$%^&*()-_=+[{]}|;:'\",<>./?//";
    private static String numbers = "1234567890";
    private String generatedPassword = "";
	private String charString = "";
	
	// GUI Panels
	private JPanel textFieldContainer;
	private JPanel sliderContainer;
	private JPanel checkboxContainer;
	private JPanel btnGenerateContainer;
	
	// GUI components
    private JSlider lengthChooser;
    private JButton btnGenerate;
    private JTextField textField;
	private JTextField sliderValue;
    private JCheckBox chckbxLowercase;
    private JCheckBox chckbxUppercase;
    private JCheckBox chckbxSymbol;
    private JCheckBox chckbxNumber;
    
	/**
	 * Create the panel.
	 */
	public GeneratorPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(new EmptyBorder(100, 70, 100, 70));
		
		
		// create and add components
		createTextFieldContainer();
		add(textFieldContainer);
		
		createSliderContainer();
		add(sliderContainer);
		
		createCheckboxContainer();
		add(checkboxContainer);
		
		createBtnGenerateContainer();
		add(btnGenerateContainer);
	}
	
	/**
	 * creates a container for textField. The container allows for easier layout management.
	 */
	private void createTextFieldContainer() {
		textFieldContainer = new JPanel();
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setForeground(Color.RED);
		textField.setColumns(30);
		
		textFieldContainer.add(textField);
	}
	
	/**
	 * Creates a container for LengthChooser and sliderValue. The container allows for easier layout management.
	 */
	private void createSliderContainer() {
		sliderContainer = new JPanel();
		sliderContainer.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// add components
		createLengthChooser();
		sliderContainer.add(lengthChooser, BorderLayout.CENTER);
		
		sliderValue = new JTextField(Integer.toString(lengthChooser.getValue()));
		sliderContainer.add(sliderValue, BorderLayout.EAST);
	}
	
	/**
	 * Assigns lengthChooser to a new JSlider and configures it.
	 */
	private void createLengthChooser() {
		lengthChooser = new JSlider();
		lengthChooser.setPreferredSize(new Dimension(450, 50));
		
		lengthChooser.setMaximum(30);
		lengthChooser.setSnapToTicks(true);
		lengthChooser.setMajorTickSpacing(10);
		lengthChooser.setMinorTickSpacing(1);
		lengthChooser.setPaintTicks(true);
		lengthChooser.setPaintLabels(true);
		lengthChooser.addChangeListener(this);
	}
	
	/**
	 * Creates a container for the check boxes. Container allows for easier layout management.
	 */
	private void createCheckboxContainer() {
		checkboxContainer = new JPanel();
		
		// create and add check boxes
		chckbxUppercase = createCheckBox("A-Z");
		checkboxContainer.add(chckbxUppercase);
		
		chckbxLowercase = createCheckBox("a-z");
		checkboxContainer.add(chckbxLowercase);
		
		chckbxNumber = createCheckBox("0-9");
		checkboxContainer.add(chckbxNumber);
		
		chckbxSymbol = createCheckBox("/*+&");
		checkboxContainer.add(chckbxSymbol);
	}
	
	/**
	 * Creates a new check box with the name parameter. Configures check boxes to needed values and avoids code duplication.
	 * @param name
	 * @return checkBox
	 */
	private JCheckBox createCheckBox(String name) {
		JCheckBox checkBox = new JCheckBox(name);
		checkBox.setBorder(new EmptyBorder(10, 10, 10, 10));
		return checkBox;
	}
	
	/**
	 * Create a container for btnGenerate. The Container allows for easier layout management.
	 */
	private void createBtnGenerateContainer() {
		btnGenerateContainer = new JPanel();
		createBtnGenerate();
		
		btnGenerate.setPreferredSize(new Dimension(150, 30));
		btnGenerateContainer.add(btnGenerate);
	}
	
	/**
	 * Creates a button that, when clicked, will generate a randomized String from a series of characters based of of user-selected
	 * values. The randomized String is set as the text for textField. If no values are selected or if the they are invalid, the user
	 * is prompted for new input.
	 */
	private void createBtnGenerate() {
		btnGenerate = new JButton();
		btnGenerate.setText("Generate");
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        boolean boxesArentChecked = !chckbxNumber.isSelected() && !chckbxSymbol.isSelected() && !chckbxUppercase.isSelected()
		        		&& !chckbxLowercase.isSelected();
		        
		        if(boxesArentChecked && lengthChooser.getValue() == 0) {
		        	textField.setText("Please select a box and a size");
		        }
		        else if(lengthChooser.getValue() == 0) {
		        	textField.setText("Your password length is zero");
		        }
		        else if(boxesArentChecked) {
		        	textField.setText("Please check a box");
		        }
		        else {
		        	if(chckbxLowercase.isSelected()) {
		        		charString += lower;
		        	}
		        	if(chckbxUppercase.isSelected()) {
		        		charString+= upper;
		        	}
		        	if(chckbxSymbol.isSelected()) {
		        		charString += symbols;
		        	}
		        	if(chckbxNumber.isSelected()) {
		        		charString += numbers;
		        	}
		        	
		        	char[] characters = charString.toCharArray();
		        	generatedPassword = "";
		        	for(int i = 1; i <= lengthChooser.getValue(); i++) {
		        		generatedPassword += characters[rand.nextInt(characters.length)];
		        	}
		        	
		        	charString = "";
		        	textField.setText(generatedPassword);
		        	generatedPassword = "";
		        }
			}
		});
	}
	
	/**
	 * Generate a randomized String. This method is for use everywhere, even outside a GeneratorPanel object.
	 * @return genPassword
	 */
	public static String generateStrongPassword() {
		String allCharString = "";
		String genPassword = "";
		allCharString += lower;
		allCharString += upper;
		allCharString += symbols;
		allCharString += numbers;
		char[] allCharacters = allCharString.toCharArray();
		for(int i = 1; i <= 30; i++) {
    		genPassword += allCharacters[rand.nextInt(allCharacters.length)];
    	}
		return genPassword;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		String value = Integer.toString(lengthChooser.getValue());
		sliderValue.setText(value);
	}
}