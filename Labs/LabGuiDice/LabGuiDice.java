package guiDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * 
 * @author Jefson S
 *
 */
public class LabGuiDice extends JFrame {
	
	private ImageIcon img1 = new ImageIcon(LabGuiDice.class.getResource("/images/die-1.png"));
	private ImageIcon img2 = new ImageIcon(LabGuiDice.class.getResource("/images/die-2.png"));
	private ImageIcon img3 = new ImageIcon(LabGuiDice.class.getResource("/images/die-3.png"));
	private ImageIcon img4 = new ImageIcon(LabGuiDice.class.getResource("/images/die-4.png"));
	private ImageIcon img5 = new ImageIcon(LabGuiDice.class.getResource("/images/die-5.png"));
	private ImageIcon img6 = new ImageIcon(LabGuiDice.class.getResource("/images/die-6.png"));
	
	private ImageIcon[] dice = {img1, img2, img3, img4, img5, img6};
	
	private final Random rand = new Random();
	int randImages = rand.nextInt(6);
	int verifiedNum = 0;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton rollEmButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiDice frame = new LabGuiDice();
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
	public LabGuiDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		rollEmButton = rollingDice();
		contentPane.add(rollEmButton, BorderLayout.SOUTH);
		
		lblNewLabel = myImage();
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
	
	/**
	 * Every time the program is started, 
	 * a random die image is displayed.
	 * @return lblNewLabel
	 */
	private JLabel myImage() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(dice[randImages]);
		return lblNewLabel;
	}
	
	/**
	 * Every time the "Roll 'Em" button is clicked, 
	 * a random die is displayed on the screen.
	 * @return rollEmButton
	 */
	private JButton rollingDice() {
		JButton rollEmButton = new JButton("Roll Em");
		rollEmButton.setBorderPainted(false);
		rollEmButton.setFont(new Font("Rockwell", Font.PLAIN, 20));
		rollEmButton.setForeground(new Color(255, 192, 203));
		rollEmButton.setBackground(Color.BLACK);
		
		rollEmButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 do {
					 randImages = rand.nextInt(6);
				 } 
				 while (randImages == verifiedNum);
				 
				 verifiedNum = randImages;
				 lblNewLabel.setIcon(dice[verifiedNum]);

			 }
			 
		 });
		
		return rollEmButton;
		
		
	}

}
