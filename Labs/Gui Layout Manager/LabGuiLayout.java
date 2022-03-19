package guiLayout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.ComponentOrientation;

/**
 * In this lab, you will create a GUI that looks similar to the image below. 
 * On the left, you have a control panel that includes 
 * two buttons: one with a left-arrow and one with a right-arrow.
 * the blue tile moves to the right (the numbers remain unchanged) 
 * Whenever you click the left arrow, the blue tile moves to the left
 * If the blue tile is on position 1 and the left arrow is clicked, 
 * the blue tile is moved to the very right (position 4) Something analogous is true for the right arrow.
 * @author Jefson S
 *
 */
public class LabGuiLayout extends JFrame {

	private JPanel contentPane;
	private JPanel mp;
	private JPanel cp;
	
	private JLabel lblOne;
	private JLabel lblTwo;
	private JLabel lblThree;
	private JLabel lblFour;
	
	private int blueTile = 1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiLayout frame = new LabGuiLayout();
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
	public LabGuiLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = myTitle();
		contentPane.add(lblTitle, BorderLayout.NORTH);
		
	    cp = controlPanel();
	    contentPane.add(cp, BorderLayout.WEST);
	    
	    mp = mainPanel();
	    contentPane.add(mp, BorderLayout.CENTER);

	    
		

	}
	/**
	 * Each 'tile' has a large number in the center. 
	 * All tiles are yellow except 
	 * for the second one from the left, which is blue. 
	 * There should be a gap between the tiles and spacing 
	 * around the tiles simulating the look of the image above.
	 * @return
	 */
	private JPanel mainPanel() {
		JPanel mp = new JPanel();
	    mp.setLayout(new GridLayout(0, 4, 15, 0));

	    {
	    	lblOne = new JLabel("1");
	    	lblOne.setOpaque(true);
	    	lblOne.setHorizontalAlignment(SwingConstants.CENTER);
	    	lblOne.setFont(new Font("Tahoma", Font.PLAIN, 55));
	    	lblOne.setBackground(Color.YELLOW);
	    	mp.add(lblOne);
	    }
	    
	    {
	    	lblTwo = new JLabel("2");
	    	lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
	    	lblTwo.setOpaque(true);
	    	lblTwo.setFont(new Font("Tahoma", Font.PLAIN, 55));
	    	lblTwo.setBackground(Color.BLUE);
	    	mp.add(lblTwo);
	    }
	    
	    {
	    	lblThree = new JLabel("3");
	    	lblThree.setHorizontalAlignment(SwingConstants.CENTER);
	    	lblThree.setOpaque(true);
	    	lblThree.setFont(new Font("Tahoma", Font.PLAIN, 55));
	    	lblThree.setBackground(Color.YELLOW);
	    	mp.add(lblThree);
	    }
	    
	    {
	    	lblFour = new JLabel("4");
	    	lblFour.setHorizontalAlignment(SwingConstants.CENTER);
	    	lblFour.setOpaque(true);
	    	lblFour.setFont(new Font("Tahoma", Font.PLAIN, 55));
	    	lblFour.setBackground(Color.YELLOW);
	    	mp.add(lblFour);
	    }
		return mp;
	}
	/**
	 * Create a title that says 'Demo Layout' on top.
	 * @return
	 */
	private JLabel myTitle() {
		JLabel lblTitle = new JLabel("Demo Layout");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBorder(new EmptyBorder(13, 0, 15, 0));
		return lblTitle;
	}
	/**
	 * Add a controlPanel of type JPanel on the left. 
	 * This JPanel should use the GridLayout.
	 * Every time you click the left arrow, the blue background 
	 * shifts to the left while the numbers remain unchanged.
	 * @return
	 */
	private JPanel controlPanel() {
	    JPanel cp = new JPanel();
	    cp.setBorder(new EmptyBorder(0, 10, 0, 10));
	    cp.setLayout(new GridLayout(4, 1, 0, 15));
	      
	    JButton left = new JButton("<==");
	    left.setFont(new Font("Tahoma", Font.BOLD, 10));
	    
		left.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(blueTile - 1 < 0) {
					 mp.getComponent(3).setBackground(Color.BLUE);
					 mp.getComponent(blueTile).setBackground(Color.YELLOW);
					 blueTile = 3;
				 }
				 else {
					 mp.getComponent(blueTile - 1).setBackground(Color.BLUE);
					 mp.getComponent(blueTile --).setBackground(Color.YELLOW);
				 }
			 }
			 
		 });
	    
	    cp.add(left);
	       
	      JButton right = new JButton("==>");
	       //right.setMargin(new Insets(2, 24, 2, 14));
	       right.setFont(new Font("Tahoma", Font.BOLD, 10));
	       
			right.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 if(blueTile + 1 > 3) {
						 mp.getComponent(0).setBackground(Color.BLUE);
						 mp.getComponent(blueTile).setBackground(Color.YELLOW);
						 blueTile = 0;
					 }
					 else {
						 mp.getComponent(blueTile + 1).setBackground(Color.BLUE);
						 mp.getComponent(blueTile ++).setBackground(Color.YELLOW);
					 }
				 }

				 
			 });
	       
	          cp.add(right);
	       
	       return cp;
	   }
}
