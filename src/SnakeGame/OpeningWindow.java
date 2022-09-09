package SnakeGame;

import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpeningWindow extends JPanel{
	JFrame window = new JFrame();
	
	OpeningWindow(){	
	//window.add(this);
	 window.add(new JLabel(new ImageIcon("pictures//fruit-snake-game.png")));
	
	try {
		File sound = new File("sounds//mixkit-children-happy-countdown-923.wav");
	AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
	Clip clip = AudioSystem.getClip();
	clip.open(ais);
	clip.start();
	}catch(Exception e) {
		System.out.println(e);
	}
	
	window.setLocation(50,50);;
	window.setUndecorated(true);
	window.setSize(1107,596);
	window.setVisible(true);
	
	try {
		Thread.sleep(6000);//ms
		window.dispose();// 1st window dissapear after 6000ms
		Menu m = new Menu();// 2nd window appears
	}catch(Exception e) {
		System.out.println(e);
	}
	
	 window.add(new JLabel(new ImageIcon("pictures//fruit-snake-game.png")));

	}
	
	
//	public void paint(Graphics gr) {
//		ImageIcon background = new ImageIcon("pictures//fruit-snake-game.png");
//		gr.drawImage(background.getImage(),0,0,null);
//	}
//	

}
