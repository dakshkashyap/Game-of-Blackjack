import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TurnController implements ActionListener {
	private JLabel labels[];
	private JLabel lblComputerPoints, lblPlayerPoints;
	private JButton buttons[];
	private JButton skippButton;
	private Game game;
	private int turn;
	private GameUI gameUI;

	public TurnController(JLabel labels[], JButton buttons[], JLabel lblComputerPoints, JLabel lblPlayerPoints, JButton skippButton, GameUI gameUI) {
		this.labels = labels;
		this.buttons = buttons;
		this.turn = 0;
		this.game = new Game();
		this.lblComputerPoints = lblComputerPoints;
		this.lblPlayerPoints = lblPlayerPoints;
		this.skippButton = skippButton;
		this.gameUI = gameUI;
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
		this.skippButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == skippButton) {
			game.playTurn(labels[turn], buttons[turn], true);
			this.turn++;

		} else if (e.getSource() == buttons[turn]) {
			game.playTurn(labels[turn], buttons[turn], false);
			this.turn++;
		}
		
		lblPlayerPoints.setText("Player Points : " + this.game.getHumanValue());
		lblComputerPoints.setText("Computer Points : " + this.game.getComputerValue());
		
		if (game.isFinished(turn)) {
			int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Play Again", JOptionPane.YES_NO_OPTION);
			if (choice == 0) {
				this.gameUI.dispose();
				GameUI frame = new GameUI();
				frame.setVisible(true);
			} else {
				System.exit(0);
			}
		}
	}

}
