package counter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Jefson S
 *
 */
public class Counter extends JFrame {

   private Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA};
  
   private final Random rand = new Random();
   int randColor = rand.nextInt(5);
   int currentColor = 1;

   private JPanel contentPane;
   private JButton btnClickMe;
   private JLabel lblRedCounter;
   private int count;

   /**
   * Launch the application.
   */
   public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
               try {
                   Counter frame = new Counter();
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
   public Counter() {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 500, 200);
       contentPane = new JPanel();
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       contentPane.setLayout(new BorderLayout(0, 0));
       setContentPane(contentPane);

       count = 0;
      
      
       
       btnClickMe = mybtnClickMe();
       contentPane.add(btnClickMe, BorderLayout.CENTER);
      
        lblRedCounter = mylblRedCounter();
       contentPane.add(lblRedCounter, BorderLayout.WEST);
      
       JLabel lblJeffGUI = mylblJeffGUI();
       contentPane.add(lblJeffGUI, BorderLayout.SOUTH);
   }
   /**
    * Every time the button is clicked, the background color randomly changes.
    * Every time the background color happens to be red, 
    * the 'Red Counter' on the left is increased by one.
    * @return btnClickMe
    */
   private JButton mybtnClickMe() {
       JButton btnClickMe = new JButton("Click Me");
       btnClickMe.setForeground(Color.WHITE);
       btnClickMe.setFont(new Font("Snap ITC", Font.PLAIN, 40));
       btnClickMe.setBackground(color[currentColor]);
       btnClickMe.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           do {
               randColor = rand.nextInt(5);          
           }
              
           while (randColor == currentColor);
              
           currentColor = randColor;

           btnClickMe.setBackground(color[currentColor]);
          
           if (currentColor == 0) {
               count++;
               String scounts = String.format("%02d", count);
               lblRedCounter.setText("Red Counter: " + scounts);
           }
  
       }

   });
       return btnClickMe;
   }
   /**
    * When the GUI opens, the counter displays  
    * Red Counter: 00.  
    * @return lblRedCounter
    */
   private JLabel mylblRedCounter() {
          
       JLabel lblRedCounter = new JLabel("Red Counter: 00" );
       lblRedCounter.setHorizontalAlignment(SwingConstants.CENTER);
       lblRedCounter.setOpaque(true);
       lblRedCounter.setFont(new Font("Monospaced", Font.PLAIN, 24));
       lblRedCounter.setBackground(Color.LIGHT_GRAY);
       lblRedCounter.setPreferredSize(new Dimension(235, 14));
       return lblRedCounter;
   }
   /**
    * displays the text: {YourName}'s GUI where {YourName} 
    * is replaced with your actual name
    * @return lblJeffGUI
    */
   private JLabel mylblJeffGUI() {
       JLabel lblJeffGUI = new JLabel("Jefson's GUI");
       lblJeffGUI.setBorder(new EmptyBorder(10, 0, 10, 0));
       lblJeffGUI.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
       lblJeffGUI.setOpaque(true);
       lblJeffGUI.setBackground(SystemColor.controlHighlight);
       lblJeffGUI.setHorizontalAlignment(SwingConstants.CENTER);
       return lblJeffGUI;
   }

}
