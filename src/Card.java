import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Card {
	private String name;
	private int value;
	private ImageIcon icon;
	
	public Card(String name) {
		this.name = name;
		generateValue();
		generateIcon();
	}
	
	private void generateValue() {
		String[] nameParts = this.name.split("_");
		
		if (nameParts[0].equals("ace")) {
			this.value = 1;
		} else if (nameParts[0].equals("2")) {
			this.value = 2;
		} else if (nameParts[0].equals("3")) {
			this.value = 3;
		} else if (nameParts[0].equals("4")) {
			this.value = 4;
		} else if (nameParts[0].equals("5")) {
			this.value = 5;
		} else if (nameParts[0].equals("6")) {
			this.value = 6;
		} else if (nameParts[0].equals("7")) {
			this.value = 7;
		} else if (nameParts[0].equals("8")) {
			this.value = 8;
		} else if (nameParts[0].equals("9")) {
			this.value = 9;
		} else if (nameParts[0].equals("10")) {
			this.value = 10;
		} else if (nameParts[0].equals("jack")) {
			this.value = 11;
		} else if (nameParts[0].equals("queen")) {
			this.value = 12;
		} else if (nameParts[0].equals("king")) {
			this.value = 13;
		}
	}
	
	private void generateIcon() {
		try {
		this.icon = new ImageIcon(this.getClass().getResource("/images/" + this.name));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Images not found");
			System.exit(0);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public ImageIcon getIcon() {
		return this.icon;
	}
}
