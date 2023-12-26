import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class GameUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameUI frame = new GameUI();
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
	public GameUI() {
		setTitle("Card Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComputerPoints = new JLabel("Computer Points : 0", SwingConstants.RIGHT);
		lblComputerPoints.setBounds(277, 212, 273, 15);
		contentPane.add(lblComputerPoints);
		
		JLabel lblPlayerPoints = new JLabel("Player Points : 0", SwingConstants.RIGHT);
		lblPlayerPoints.setBounds(277, 412, 273, 15);
		contentPane.add(lblPlayerPoints);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setBounds(50, 50, 500, 150);
		contentPane.add(upperPanel);
		upperPanel.setLayout(new GridLayout(0, 5, 10, 0));
		
		JLabel label1 = new JLabel("");
		label1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//label1.setIcon(new ImageIcon(this.getClass().getResource("images/queen_of_hearts.png")));
		upperPanel.add(label1);
		
		JLabel label2 = new JLabel("");
		label2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		upperPanel.add(label2);
		
		JLabel label3 = new JLabel("");
		label3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		upperPanel.add(label3);
		
		JLabel label4 = new JLabel("");
		label4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		upperPanel.add(label4);
		
		JLabel label5 = new JLabel("");
		label5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		upperPanel.add(label5);
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setBounds(50, 250, 500, 150);
		contentPane.add(lowerPanel);
		lowerPanel.setLayout(new GridLayout(1, 5, 10, 0));
		
		
		JButton btnCard1 = new JButton("Card 1");
		//btnCard.setIcon(new ImageIcon(this.getClass().getResource("/images/queen_of_hearts.png")));
		lowerPanel.add(btnCard1);
		
		JButton btnCard2 = new JButton("Card 2");
		lowerPanel.add(btnCard2);
		
		JButton btnCard3 = new JButton("Card 3");
		lowerPanel.add(btnCard3);
		
		JButton btnCard4 = new JButton("Card 4");
		lowerPanel.add(btnCard4);
		
		JButton btnCard5 = new JButton("Card 5");
		lowerPanel.add(btnCard5);
		
		
		JButton skippButton = new JButton("Skip");
		skippButton.setBounds(254, 463, 117, 25);
		contentPane.add(skippButton);
		
		JLabel[] labels = new JLabel[] {label1, label2, label3, label4, label5};
		JButton[] buttons = new JButton[] {btnCard1, btnCard2, btnCard3, btnCard4, btnCard5};
		
		TurnController turn = new TurnController(labels, buttons, lblComputerPoints, lblPlayerPoints, skippButton, this);
	}
}
