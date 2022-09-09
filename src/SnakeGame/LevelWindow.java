package SnakeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelWindow extends JPanel implements ActionListener,KeyListener {

	JFrame window = new JFrame();
	String[] s = {"Beginners-Level", "Middle-Level", "Highest-Level"};
	JComboBox nameOfLevels = new JComboBox(s);
	JButton enterButton = new JButton();
	JButton backButton = new JButton();
	

	Font customFont = new Font("Bold",Font.BOLD,30);

	Font comboFont = new Font("Italic",Font.ITALIC,25);
	
	LevelWindow(){
		this.setBackground(Color.BLACK);
		window.add(this);
		
		nameOfLevels.setFont(comboFont);
	    nameOfLevels.setBackground(Color.black);
		nameOfLevels.setForeground(Color.red);
		window.add(nameOfLevels,BorderLayout.PAGE_START);
		
		backButton.setFont(customFont);
		backButton.setText("Back");
		backButton.setBackground(Color.darkGray);
	    backButton.setForeground(Color.white);
	    backButton.addActionListener(this);
	    backButton.addKeyListener(this);
		window.add(backButton,BorderLayout.PAGE_END);
		
		enterButton.setFont(customFont);
		enterButton.setText("ENTER");
		enterButton.setBackground(Color.darkGray);
	    enterButton.setForeground(Color.white);
	    enterButton.addActionListener(this);
	    enterButton.addKeyListener(this);
		window.add(enterButton,BorderLayout.CENTER);
		
		window.setUndecorated(true);
		window.setSize(750,550);
		window.setLocation(50,50);
		window.setVisible(true);
		
	}
	@Override
	public void keyTyped(KeyEvent g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_ESCAPE) {
			window.dispose();
			Menu m = new Menu();
		} else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(null,"Beginners level is not ready");
		}else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==1){
			JOptionPane.showMessageDialog(null,"Middle level is not ready");
		}else if(kp.getKeyCode()==KeyEvent.VK_ENTER&&nameOfLevels.getSelectedIndex()==2){
			JOptionPane.showMessageDialog(null,"Highest level is not ready");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==backButton) {
			window.dispose();
			Menu m = new Menu();
		}else if (ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==0) {
			window.dispose();
			GamePlay g = new GamePlay();
		}else if (ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==1) {
			JOptionPane.showMessageDialog(null,"Middle level is still in maintainance mode");
		}else if (ae.getSource()==enterButton&&nameOfLevels.getSelectedIndex()==2) {
			JOptionPane.showMessageDialog(null,"Highest level is still in maintainance mode");
		}
	}

}
