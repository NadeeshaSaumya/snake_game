package SnakeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener, KeyListener {
	
	
	JFrame window = new JFrame();
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	JLabel infoLabel = new JLabel();
	JLabel centerImageLabel = new JLabel();
	JButton backgroundButton = new JButton();
	
	Font customFont = new Font("Italic",Font.ITALIC,22);
	Menu(){
		
		this.setBackground(Color.green);
		this.setForeground(Color.green);
		window.add(this);
		
		playButton.setIcon(new ImageIcon("pictures//images.jfif"));
		playButton.addActionListener(this);
		playButton.addKeyListener(this);
		window.add(playButton,BorderLayout.PAGE_START);
		
	    exitButton.setIcon(new ImageIcon("pictures//exit.jfif"));
		exitButton.addActionListener(this);
		exitButton.addKeyListener(this);
		window.add(exitButton,BorderLayout.PAGE_END);
		
		
		centerImageLabel.setBackground(Color.BLUE);
		centerImageLabel.setIcon(new ImageIcon("pictures//snake1.jfif"));
		window.add(centerImageLabel,BorderLayout.CENTER);
		
		window.setLocation(50,50);
		window.setUndecorated(true);
		window.setSize(800,700);
		window.setVisible(true);
}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE) {
			window.dispose();
		}else if(kp.getKeyCode()==KeyEvent.VK_ENTER) {
			window.dispose();
			LevelWindow lw = new LevelWindow();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==exitButton) {
			window.dispose();
		}else if (ae.getSource()==playButton) {
			window.dispose();
			LevelWindow lw = new LevelWindow();
		}
		
	}
}
