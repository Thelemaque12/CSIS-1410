package guiIntro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * 
 * @author Jefson S
 *
 */
public class LabGuiIntro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiIntro frame = new LabGuiIntro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame, and
	 * sets the values of parameters
	 * such as color, size, etc.
	 */
	public LabGuiIntro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTitle = newLblTitle();
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
		JButton btnNewButton = newLbButton();
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		JPanel textPanel = newTextPanel();
		contentPane.add(textPanel, BorderLayout.SOUTH);
		
		{
			JLabel lblRedLabel = newLblRedLabel();
			contentPane.add(lblRedLabel, BorderLayout.CENTER);
		}
	}

	private JLabel newLblRedLabel() {
		JLabel lblRedLabel = new JLabel("Hi");
		lblRedLabel.setOpaque(true);
		lblRedLabel.setBackground(Color.RED);
		lblRedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedLabel.setForeground(Color.ORANGE);
		lblRedLabel.setFont(new Font("Ink Free", Font.PLAIN, 77));
		return lblRedLabel;
	}

	private JPanel newTextPanel() {
		JPanel textPanel = new JPanel();
		textPanel.setBackground(Color.GRAY);
		{
			JLabel lblNewLabel = new JLabel("Name:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textPanel.add(textField);
			textField.setColumns(16);
		}
		return textPanel;
	}

	private JButton newLbButton() {
		JButton btnNewButton = new JButton("WEST");
		return btnNewButton;
	}

	private JLabel newLblTitle() {
		JLabel lblTitle = new JLabel("My First Gui");
		lblTitle.setOpaque(true);
		lblTitle.setForeground(Color.GREEN);
		lblTitle.setBackground(Color.BLUE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		return lblTitle;
	}

}
