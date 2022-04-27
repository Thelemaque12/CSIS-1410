package passwordManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Dimension;

/**
 * 
 * @author  Gabriel Perillo, Jefson Simeus
 *
 */
public class unlockPage extends JFrame implements ActionListener{
	

	private static final SecureRandom RAND = new SecureRandom();
	private static String salt;
	private static String hash;
	

	private JButton unlockBtn;
	private JLabel textLbl;
	
	private static ManagerGUI manager;

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JCheckBox showPassCheckBx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					unlockPage frame = new unlockPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public unlockPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		newJLabel();
		contentPane.add(textLbl, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(95, 0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		
		newPasswordField();
		
		newShowPassCheckBox();
		
		panel.add(showPassCheckBx);
		panel.add(passwordField);


		
		unlockBtn = newUnlockButton();
		panel.add(unlockBtn);
		
		// this is here as a placeholder because the app doesn't allow users to set their own password as of now.
		// this should only ever run once for each new password, but in this case we have set a pre-defined password
		// for this assignment.
		salt = aPinchOfSalt();
		serializeSalt();
		String password = "testpassword";
		hash = hashBrowns(password.toCharArray(), salt);
		serializeHash();
		
	}

	private void newJLabel() {
		textLbl = new JLabel("<html><p>Please input password to unlock password database</p></html>");
		textLbl.setBorder(new EmptyBorder(60, 0, 0, 0));
		textLbl.setHorizontalAlignment(SwingConstants.CENTER);
		textLbl.setFont(new Font("Dialog", Font.BOLD, 16));
	}

	private void newShowPassCheckBox() {
		showPassCheckBx = new JCheckBox("Show Password");
		showPassCheckBx.addActionListener(this);
		showPassCheckBx.setFont(new Font("Dialog", Font.PLAIN, 13));
	}

	private void newPasswordField() {
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(315, 25));
	}

	private JButton newUnlockButton() {
		unlockBtn = new JButton("Unlock");
		unlockBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		unlockBtn.setBackground(new Color(255, 255, 255));
		unlockBtn.addActionListener(this);	
		return unlockBtn;
	}

	/**
	 * adds an eventListener to unlockButton and showPassCheckBx. 
	 * When the button is clicked, the programs main window
	 * is started if the user provided password was correct. 
	 * When the CheckBox is checked, the password is shown/hidden
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == unlockBtn) {
			char[] pass=passwordField.getPassword();
			if(verifyPassword(pass)) {
				manager = new ManagerGUI();
				manager.setVisible(true);
				dispose();
			}
			else {

				textLbl.setText("Please Enter The Correct Password");
				textLbl.setForeground(Color.RED);			
			}
					
		}
		
		//show password checkbox 
		if(e.getSource() == showPassCheckBx) {
			if(showPassCheckBx.isSelected()) {
				passwordField.setEchoChar((char) 0);
				
				}
			
			else {
				passwordField.setEchoChar('*');
				
				}
			}
		
	}
	
	/**
	 * method for generating salt.
	 * @return
	 */
	public String aPinchOfSalt() {
		// use when a password is created/changed
		// in the case with this application, this will be only ever be used once and will be run manually
		// could be used in future if more features are implemented
		byte[] iodizedSalt = new byte[16];
		RAND.nextBytes(iodizedSalt);
		return Base64.getEncoder().encodeToString(iodizedSalt);
	}
	
	/**
	 * hashes char[] pass with salt
	 * @param pass
	 * @param salt
	 * @return
	 */
	private String hashBrowns(char[] pass, String salt) {
		byte[] s = salt.getBytes();
		
		PBEKeySpec specs = new PBEKeySpec(pass, s, 50000, 256);
		
		Arrays.fill(pass, Character.MIN_VALUE); // done because recommended by .getPassword() method
		
		try { //must be in try block
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			byte[] hashedPassword = factory.generateSecret(specs).getEncoded();
			return Base64.getEncoder().encodeToString(hashedPassword);
			
			
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException n) {
			n.printStackTrace();
			return "";
		} finally {
			specs.clearPassword();
		}
	}
	
	/**
	 * When the unlockButton is clicked, the password the user entered will be hashed with the
	 * salt stored in salt.ser and compared to the hash already stored in hash.ser.
	 * If the hashes match, it means the password the user entered is correct.
	 * @param userPassword
	 * @return
	 */
	private boolean verifyPassword(char[] userPassword) {
		deserializeHash();
		deserializeSalt();
		String HashedPassword = hashBrowns(userPassword, salt);
		
		return HashedPassword.equals(hash);
	}
	
	/**
	 * gets salt String stored in salt.ser
	 */
	private void deserializeSalt() {
		salt = null;
	      try {
	          FileInputStream fileIn = new FileInputStream("salt.ser");
	          ObjectInputStream streamIn = new ObjectInputStream(fileIn);
	          salt = (String) streamIn.readObject();
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
	 * writes salt String to salt.ser
	 */
	private void serializeSalt() {
		// use when a password is created/changed
		// in the case with this application, this will be only ever be used once and will be run manually
		// could be used in future if more features are implemented
	      try {
	          FileOutputStream fileOut = new FileOutputStream("salt.ser");
	          ObjectOutputStream streamOut = new ObjectOutputStream(fileOut);
	          streamOut.writeObject(salt);
	          streamOut.close();
	          fileOut.close();
	       } catch (IOException e) {
	          e.printStackTrace();
	       }
	}
	
	/**
	 * gets hash String stored in hash.ser
	 */
	private void deserializeHash() {
		hash = null;
	      try {
	          FileInputStream fileIn = new FileInputStream("hash.ser");
	          ObjectInputStream streamIn = new ObjectInputStream(fileIn);
	          hash = (String) streamIn.readObject();
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
	 * writes hash String to salt.ser
	 */
	private void serializeHash() {
		// use when a password is created/changed
		// in the case with this application, this will be only ever be used once and will be run manually
		// could be used in future if more features are implemented
	      try {
	          FileOutputStream fileOut = new FileOutputStream("hash.ser");
	          ObjectOutputStream streamOut = new ObjectOutputStream(fileOut);
	          streamOut.writeObject(hash);
	          streamOut.close();
	          fileOut.close();
	       } catch (IOException e) {
	          e.printStackTrace();
	       }
	}

}
