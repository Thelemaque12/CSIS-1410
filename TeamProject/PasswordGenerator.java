package TeamProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PasswordGenerator extends JFrame implements ChangeListener{

	private JPanel contentPane;
    private JSlider lengthChooser;
    private JButton genButton;
    private JTextField textField;
	private JTextField sliderValue;
    private JCheckBox lowercaseButton;
    private JCheckBox uppercaseButton;
    private JCheckBox symbolButton;
    private JCheckBox numberButton;
    private String lower = "abcdefghijklmnopqrstuvwxyz";
    private String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String symbols = "~`!@#$%^&*()-_=+[{]}|;:'\",<>./?//";
    private String numbers = "1234567890";
    private String password = "";
	String charString = "";



	/**
	 * Create the frame.
	 */
	public PasswordGenerator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 614, 339);
		contentPane.add(tabbedPane);
		
		JPanel Entry = new JPanel();
		tabbedPane.addTab("Entry", null, Entry, null);
		
		JPanel generator = generate();
		tabbedPane.addTab("Generator", null, generator, null);
			

	}


	/**
	 * 
	 * @return
	 */
	private JPanel generate() {
		JPanel generator = new JPanel();
		generator.setLayout(null);
		lengthChooser = lengthSlider();
		generator.add(lengthChooser);
		
		uppercaseButton = new JCheckBox("A-Z");
		uppercaseButton.setBounds(120, 169, 80, 23);
		generator.add(uppercaseButton);
		
		lowercaseButton = new JCheckBox("a-z");
		lowercaseButton.setBounds(214, 169, 80, 23);
		generator.add(lowercaseButton);
		
		numberButton = new JCheckBox("0-9");
		numberButton.setBounds(296, 169, 80, 23);
		generator.add(numberButton);
		
		symbolButton = new JCheckBox("/*+&");
		symbolButton.setBounds(373, 169, 80, 23);
		generator.add(symbolButton);
		
		generateButton();
		generator.add(genButton);
		
		textField = new JTextField();
		textField.setBounds(78, 71, 402, 26);
		textField.setColumns(10);
		generator.add(textField);
		
		sliderValue = new JTextField(Integer.toString(lengthChooser.getValue()));
		sliderValue.setHorizontalAlignment(SwingConstants.CENTER);
		sliderValue.setFont(new Font("Tahoma", Font.BOLD, 12));
		sliderValue.setBounds(490, 123, 43, 23);
		sliderValue.setColumns(10);
		generator.add(sliderValue);
		
		return generator;
	}


	/**
	 * 
	 * @return
	 */
	private JSlider lengthSlider() {
		lengthChooser = new JSlider();
		lengthChooser.setMaximum(30);
		lengthChooser.setBounds(78, 123, 402, 39);
		lengthChooser.setSnapToTicks(true);
		lengthChooser.setMajorTickSpacing(10);
		lengthChooser.setMinorTickSpacing(1);
		lengthChooser.setPaintTicks(true);
		lengthChooser.setPaintLabels(true);
		
		lengthChooser.addChangeListener(this);
		
		return lengthChooser;
	}



	/**
	 * 
	 */
	private void generateButton() {
		genButton = new JButton("Generate");
		genButton.setBounds(214, 229, 137, 23);
		
		genButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Random random = new Random();
		        boolean boxesArentChecked = !numberButton.isSelected() && !symbolButton.isSelected() && !uppercaseButton.isSelected()
		        		&& !lowercaseButton.isSelected();
		        if(boxesArentChecked && lengthChooser.getValue() == 0) {
		        	textField.setForeground(Color.RED);
		        	textField.setText("Please select a box and a size");
		        }
		        else if(lengthChooser.getValue() == 0) {
		        	textField.setForeground(Color.RED);
		        	textField.setText("Your password length is zero");
		        }
		        else if(boxesArentChecked) {
		        	textField.setForeground(Color.RED);
		        	textField.setText("Please check a box");
		        }
		        
		        else {
		        	if(lowercaseButton.isSelected()) {
		        		charString += lower;
		        	}
		        	if(uppercaseButton.isSelected()) {
		        		charString+= upper;
		        	}
		        	if(symbolButton.isSelected()) {
		        		charString += symbols;
		        	}
		        	if(numberButton.isSelected()) {
		        		charString += numbers;
		        	}
		        	
		        	char[] characters = charString.toCharArray();
		        	password = "";
		        	for(int i = 1; i <= lengthChooser.getValue(); i++) {
		        		int choice = random.nextInt(characters.length);
		        		password += characters[choice];
		        	}
		        	
		        	charString = "";
		        	textField.setText(password);
		        }

			}
		});
		
	}



	@Override
	public void stateChanged(ChangeEvent e) {
		String value = Integer.toString(lengthChooser.getValue());
		sliderValue.setText(value);
	}


}
