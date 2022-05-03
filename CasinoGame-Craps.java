package projects;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CasinoGame extends JFrame implements ActionListener {
	JLabel lbl = new JLabel();
	JLabel lbl1 = new JLabel();
	JButton btn = new JButton();
	
	CasinoGame() {
		lbl = new JLabel("Casino Game: craps");
		lbl.setBounds(90, 50, 350, 60);
		add(lbl);
		
		lbl1 = new JLabel("Lets play!");
		lbl1.setBounds(90, 140, 350, 60);
		add(lbl1);
		
		btn = new JButton("Play");
		btn.setBounds(90, 200, 100, 30);
		add(btn);
		
		btn.addActionListener(this);
		
		setLayout(null);
		setSize(600, 400);
		setVisible(true);
	}
	
	private int rollTwoDice() {
		Random ran = new Random();
		int x = ran.nextInt(1, 7) ;
		Random ran1 = new Random();
		int y = ran1.nextInt(1, 7) ;
		int z = x + y;
		return z;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int total = rollTwoDice();
		
		if(e.getSource().equals(btn)) {
			if(total == 7 || total == 11) {
				String message = "You Rolled " + total + " That' a natural. You win.";
				lbl.setText(String.valueOf(message));
			} else if(total == 2 || total == 3 || total == 12) {
				String message = "you rolled " + total + " That's craps. You lose.";
				lbl.setText(String.valueOf(message));
			}else {
				int point = total;
				String message = "Your point is " + point + ".";
				lbl.setText(String.valueOf(message));
				while (true) {
					total = rollTwoDice();
					if(total == point) {
						String message1 = "you rolled " + total + " You made your point! you win.";
						lbl.setText(String.valueOf(message1));
						break;
					}else if(total == 7) {
						String message1 = "thats a 7 you lose.";
						lbl.setText(String.valueOf(message1));
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		CasinoGame t = new CasinoGame();
	}
	

}
