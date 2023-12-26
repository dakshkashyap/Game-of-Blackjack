import java.io.File;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game {
	private Card[] cards;
	private Card[] usedCards;
	private int usedCardIndex;
	private Player humanPlayer, computerPlayer;
	
	public Game() {
		cards = new Card[52];
		usedCards = new Card[10];
		humanPlayer = new Player("Player");
		computerPlayer = new Player("Computer");
		
		usedCardIndex = 0;
		generateCards();
	}
	
	public void generateCards() {
		File folder = new File("src/images");
		File[] files = folder.listFiles();
		
		for (int i = 0; i < 52; i++) {
			if (files[i].isFile()) {
				cards[i] = new Card(files[i].getName());
			}
		}
	}
	
	public boolean isUsed(Card card) {
		if (usedCards[usedCardIndex] == null) {
			return false;
		}
		
		for (int i = 0; i < 10; i++) {
			if (usedCards[i].getName().equals(card.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public void addUsedCard(Card card) {
		usedCards[this.usedCardIndex] = card;
		this.usedCardIndex++;
	}
	
	public Card getCard() {
		Card card = null;
		boolean used = true;
		
		while (used) {
			int randomIndex = new Random().nextInt(51) + 1;
			card = cards[randomIndex];
			used = isUsed(card);
		}
		
		addUsedCard(card);
		
		return card;
	}
	
	public void playTurn(JLabel label, JButton button, boolean skip) {
		if (!skip) {
			Card cardHuman = getCard();
			humanPlayer.addPoint(cardHuman.getValue());
			button.setText("");
			button.setIcon(cardHuman.getIcon());
			
		}
		
		Card cardComputer = getCard();
		computerPlayer.addPoint(cardComputer.getValue());
		label.setIcon(cardComputer.getIcon());
	}
	
	public int getHumanValue() {
		return this.humanPlayer.getTotalPoints();
	}
	
	public int getComputerValue() {
		return this.computerPlayer.getTotalPoints();
	}
	
	
	public boolean isFinished(int turn) {
		boolean humanExceed = humanPlayer.isExceeded();
		boolean computerExceed = computerPlayer.isExceeded();
		
		// For Every Turns
		if (computerExceed && humanExceed) {
			JOptionPane.showMessageDialog(null, "Match Draw!!!");
			return true;
		} else if (computerExceed) {
			JOptionPane.showMessageDialog(null, "You Win!!!");
			return true;
		} else if (humanExceed) {
			JOptionPane.showMessageDialog(null, "You Lost!!!");
			return true;
		} 
		
		// For The Last Turn
		else if (turn == 5) {
			if (getHumanValue() == getComputerValue()) {
				JOptionPane.showMessageDialog(null, "Match Draw");
			} else if (humanPlayer.isWinner(computerPlayer)) {
				JOptionPane.showMessageDialog(null, "You Win!!!");
			} else {
				JOptionPane.showMessageDialog(null, "You Lost!!!");
			}
			return true;
		} 
		
		return false;
	}

	public void clearGame() {
		this.humanPlayer.clearPoints();
		this.computerPlayer.clearPoints();
	}
}
