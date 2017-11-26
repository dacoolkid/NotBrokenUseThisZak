import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	static int molesWhacked = 0;
	 public JButton moleButton;
	 JFrame frame;
	
	public static void main(String[] args) {
		Random r = new Random();
		int random = r.nextInt(24);
		WhackAMole mole = new WhackAMole();
		mole.DrawButtons(random, molesWhacked);
		
	}
	
	public void DrawButtons(int rando, int moleWhack) {
		 moleButton = new JButton("MOLE");
		Date newDate = new Date();
		System.out.println(moleWhack);
		
		
		if(moleWhack == 10) {
			endGame(newDate, molesWhacked);
		}
		
		JPanel panel = new JPanel();
		 frame = new JFrame("Whack a Button for Fame and Glory");
		for(int i = 0; i<24; i++) {
			if(i==rando) {
				
				moleButton.addActionListener(this);
				panel.add(moleButton);
			}
			else {
				  
			JButton button = new JButton();
			button.addActionListener(this);
			panel.add(button);
			
			
			
		}
		
		frame.add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		
	}
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == moleButton) {
			
			
			molesWhacked++;
			
		
			
		}
		else {
			
			speak("You are a dole dipper");
		}
		Random r = new Random();
		int random = r.nextInt(24);
		frame.dispose();
		DrawButtons(random, molesWhacked);
		
		// TODO Auto-generated method stub
		
	}
	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
		+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
		}
	void speak(String words) {
		try {
		Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}




}
