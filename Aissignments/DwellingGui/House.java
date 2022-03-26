package dwellingImages;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

/**
 * 
 * @author Jefson S
 *
 */
public class House extends JFrame {
	
	private JPanel contentPane;
	private ImagePanel image;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					House frame = new House();
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
	public House() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = controlPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		image = new ImagePanel();
		contentPane.add(image, BorderLayout.CENTER);
	}

	private JPanel controlPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EmptyBorder(0, 4, 160, 4));
		panel.setLayout(new GridLayout(5, 1, 2, 2));
	
		JLabel lblNewLabel = new JLabel("You Choose..");
		panel.add(lblNewLabel);
		
		JCheckBox chckbxGarage = new JCheckBox("garage");
		selectedCheckbox(panel, chckbxGarage);
		
		JCheckBox chckbxWindow = new JCheckBox("window");
		selectedCheckbox(panel, chckbxWindow);
		
		JCheckBox chckbxTopWindow = new JCheckBox("topWindow");
		selectedCheckbox(panel, chckbxTopWindow);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxGarage.isSelected() && !chckbxWindow.isSelected() && !chckbxTopWindow.isSelected()) {
					image.changeColor();
				}
				
				if(chckbxGarage.isSelected()) {
					image.changeGarageImage();
				}
				if(chckbxWindow.isSelected()) {
					image.changeWindowImage();
				}
				if(chckbxTopWindow.isSelected()) {
					image.changeTopWindowImage();
				}
			}
		});
		panel.add(btnUpdate);
		return panel;
	}

	private void selectedCheckbox(JPanel panel, JCheckBox chckbx) {
		chckbx.setBackground(Color.LIGHT_GRAY);
		panel.add(chckbx);
	}

}
