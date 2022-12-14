package SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class GamePlay extends JPanel implements ActionListener, KeyListener{
	
	JFrame obj = new JFrame();
	
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon snakeimage;
	
	private int[]fruitxposition = {25,50,75,100,125,150,175,200,125,150,175,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[]fruityposition = {75,100,125,150,175,200,125,150,175,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private ImageIcon fruitimage;
	private Random random = new Random();
	private int xposition = random.nextInt(34);
	private int yposition = random.nextInt(23);
	
	private int score = 0;
	
	private int moves = 0;
	
	private ImageIcon titleImage;
	
	
	public GamePlay() {
		obj.setUndecorated(true);
		obj.setBounds(10,10,905,700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(this);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
	//this execute only start of the game	
		if(moves == 0) {
			snakeXlength[2] = 50;
			snakeXlength[1] = 75;
			snakeXlength[0] = 100;
			
			snakeYlength[2] = 100;
			snakeYlength[1] = 100;
			snakeYlength[0] = 100;	
		}
		
		//draw title image border
		g.setColor(Color.white);
		g.drawRect(24, 10, 850, 55);
		
		//draw the title image
		ImageIcon titleImage = new ImageIcon("pictures//snaketitle.png");
		titleImage.paintIcon(this,g,25,11); 
		
		//draw border for gameplay
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		
		//draw background for the game play
		g.setColor(Color.orange);
		g.fillRect(25,75,850,575);
		
		//draw score
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Score: "+ score,780,30);
		
		//draw length
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Length: "+ lengthOfSnake,780,50);
		
		rightmouth = new ImageIcon("pictures//rightmouth.png");
		rightmouth.paintIcon(this,g,snakeXlength[0],snakeYlength[0]);
		
		//head of snake
		for (int a= 0;a <lengthOfSnake;a++) {
			if (a==0 && right) {
				rightmouth = new ImageIcon("pictures//rightmouth.png");
				rightmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
			}else if  (a==0 && left) {
				leftmouth = new ImageIcon("pictures//leftmouth.png");
				leftmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
			}else if  (a==0 && up) {
				upmouth = new ImageIcon("pictures//upmouth.png");
				upmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
			}else if  (a==0 && down) {
				downmouth = new ImageIcon("pictures//downmouth.png");
				downmouth.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
				//body of snake
			}else if  (a!=0) {
				snakeimage = new ImageIcon("pictures//snakeimage.png");
				snakeimage.paintIcon(this,g,snakeXlength[a],snakeYlength[a]);
			}	
		}
		
		fruitimage = new ImageIcon("pictures//fruit.png");
		if(fruitxposition[xposition]==snakeXlength[0] && fruityposition[yposition]==snakeYlength[0]) {
			score++;
			lengthOfSnake++;
			xposition = random.nextInt(34);
			yposition = random.nextInt(23);
		}
		
		fruitimage.paintIcon(this,g,fruitxposition[xposition],fruityposition[yposition]);
		
		for(int b = 1;b<lengthOfSnake;b++) {
			if(snakeXlength[b] == snakeXlength[0] && snakeYlength[b] == snakeYlength[0]) {
				right = false;
				left = false;
				up = false;
				down = false;
				//moves =0;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD,60));
				g.drawString("Game Over!",300,300);
				
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("Press Space Key to go back..",300,350);
			}
		}
		
		g.dispose();
} 
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent kp) {
		if(kp.getKeyCode()==KeyEvent.VK_SPACE) {
			obj.dispose();
			LevelWindow lw1 = new LevelWindow();
		}
		if(kp.getKeyCode()==KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if(!left) {right = true;}
			else {right = false;
				  left = true;}
			up = false;
			down = false;
		}
		
		if(kp.getKeyCode()==KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if(!right) {left = true;}
			else {
				left = false;
				right = true;}
			up = false;
			down = false;
		}
		
		if(kp.getKeyCode()==KeyEvent.VK_UP) {
			moves++;
			up = true;
			if(!down) {up = true;}
			else {
				up = false;
				down = true;}
			left = false;
			right = false;
		}
		
		if(kp.getKeyCode()==KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if(!up) {down = true;}
			else {
				down = false;
				up = true;}
			left = false;
			right = false;
		}	
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		timer.start();
		if(right) {
			for(int r = lengthOfSnake-1; r>=0;r--) {
				snakeYlength[r+1] = snakeYlength[r];}
			for(int r = lengthOfSnake; r>=0;r--) {
				if(r==0) {
				    snakeXlength[r] = snakeXlength[r]+25;
			    }else {
			    	snakeXlength[r] = snakeXlength[r-1];
			    }
				if(snakeXlength[r]>850) {
					snakeXlength[r] = 25;
				}
			}
			repaint();
		}
		if(left) {
			for(int r = lengthOfSnake-1; r>=0;r--) {
				snakeYlength[r+1] = snakeYlength[r];}
			for(int r = lengthOfSnake; r>=0;r--) {
				if(r==0) {
				    snakeXlength[r] = snakeXlength[r]-25;
			    }else {
			    	snakeXlength[r] = snakeXlength[r-1];
			    }
				if(snakeXlength[r]<25) {
					snakeXlength[r] = 850;
				}
			}
			repaint();
		}
		if(up) {
			for(int r = lengthOfSnake-1; r>=0;r--) {
				snakeXlength[r+1] = snakeXlength[r];}
			for(int r = lengthOfSnake; r>=0;r--) {
				if(r==0) {
				    snakeYlength[r] = snakeYlength[r]-25;
			    }else {
			    	snakeYlength[r] = snakeYlength[r-1];
			    }
				if(snakeYlength[r]<75) {
					snakeYlength[r] = 625;
				}
			}
			repaint();
		}
		if(down) {
			for(int r = lengthOfSnake-1; r>=0;r--) {
				snakeXlength[r+1] = snakeXlength[r];}
			for(int r = lengthOfSnake; r>=0;r--) {
				if(r==0) {
				    snakeYlength[r] = snakeYlength[r]+25;
			    }else {
			    	snakeYlength[r] = snakeYlength[r-1];
			    }
				if(snakeYlength[r]>625) {
					snakeYlength[r] = 75;
				}
			}
			repaint();
		}
	}
}

