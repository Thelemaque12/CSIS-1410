package m03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Jefson S
 *
 */
public class Module03Gui extends JFrame {

	private ImageIcon map = new ImageIcon(Module03Gui.class.getResource("/m03/Resources/Map.jpg"));
	private ImageIcon president = new ImageIcon(Module03Gui.class.getResource("/m03/Resources/Zelenskyy.jpg"));
	private ImageIcon[] images = {	new ImageIcon(Module03Gui.class.getResource("/m03/Resources/AirportDonezk.jpg")),
									new ImageIcon(Module03Gui.class.getResource("/m03/Resources/MariupolTheatreBombing.jpg")),
									new ImageIcon(Module03Gui.class.getResource("/m03/Resources/MaternityHospitalBombing.jpg"))};
	private JPanel contentPane;
	private JLabel lblImage;

	private int imageIndex = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Module03Gui frame = new Module03Gui();
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
	public Module03Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = createButton();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblPresident = presidentImage();
		contentPane.add(lblPresident, BorderLayout.WEST);
		
		lblImage = imagePanel();
		contentPane.add(lblImage, BorderLayout.CENTER);
	}

	/**
	 * displaying the Map image as the default image
	 * @return
	 */
	private JLabel imagePanel() {
		JLabel lblMap = new JLabel("");
		lblMap.setBorder(new EmptyBorder(0, 10, 0, 0));
		lblMap.setIcon(map);
		return lblMap;
	}

	/**
	 * displaying the president image
	 * @return
	 */
	private JLabel presidentImage() {
		JLabel lblPresident = new JLabel("");
		lblPresident.setIcon(president);
		return lblPresident;
	}

	/**
	 * creating the Map and Invasion Button
	 * Whenever the Map button is clicked, 
	 * the image on the right displays the image
	 * Every time the Invasion button is clicked, the following happens:
	 * The image on the right is updated with one of the three images 
	 * that depict the results of the invasion.
	 * The image is selected randomly
	 * @return panel
	 */
	private JPanel createButton() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 6, 0));
		panel.setLayout(new GridLayout(1, 0, 10, 0));

		JButton btnMap = new JButton("Map");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImage.setIcon(map);
			}
		});
		button(panel, btnMap);
		
		JButton btnInvasion = new JButton("Invasion");
		btnInvasion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageIndex = ++imageIndex % images.length;
				lblImage.setIcon(images[imageIndex]);
			}
		});
		button(panel, btnInvasion);
		
		return panel;
	}

	/**
	 * 
	 * @param panel
	 * @param btn
	 */
	private void button(JPanel panel, JButton btn) {
		btn.setBackground(new Color(90,101,99));
		btn.setForeground(new Color(255,254,233));
		btn.setBorder(new EmptyBorder(8, 0, 8, 0));
		btn.setFont(new Font("Arial", Font.PLAIN, 24));
		panel.add(btn);
	}

}
