package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {
	GameManager gm;
	JFrame window;
	
	private JTextArea messageText;
	private JPanel bgPanel[] = new JPanel[4];
	private JLabel bgLabel[] = new JLabel[6];
	private JLabel stLabel[] = new JLabel[6];
	private JLabel ltLabel[] = new JLabel[6];
	private JLabel chLabel[] = new JLabel[1];
	private JLabel objectLabelG[] = new JLabel[42];
	private JLabel objectLabelR[] = new JLabel[42];
	private JButton []buttonG = new JButton[7];
	private JButton []buttonR = new JButton[7];
	private JButton []bts = new JButton[1];
	private JButton []ltb = new JButton[2];
	private JButton []chb = new JButton[4];
	private boolean botEasy  = false;
	private boolean botEasyM = false;
	private boolean botMid = false;
	
	
	public UI(GameManager gm) {
		this.gm = gm;
		int sc = 0;
		generate();
		sc++;
		
		
		window.setVisible(true);
	}
	
	public void setGameStat() {
		bgPanel[0].setVisible(false);
		bgPanel[1].setVisible(false);
		bgPanel[2].setVisible(false);
		bgPanel[3].setVisible(true);
	}
	
	public void setRound() {
		bgLabel[2].setVisible(false);
	}
	
	public void createMainField() {
		window = new JFrame();
		window.setSize(700,700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);

	}
	public void createBackground() {
		ImageIcon bgStrat = new ImageIcon(getClass().getClassLoader().getResource("BGStart.png"));
//		หน้าแรก
		bgPanel[0] = new JPanel();
		bgPanel[0].setBounds(0, 0, 700, 700);
		bgPanel[0].setBackground(Color.green);
		bgPanel[0].setLayout(null);
		bgPanel[0].setVisible(true);
		
		stLabel[0] = new JLabel();
		stLabel[0].setBounds(0, 0, 700, 700);
		stLabel[0].setIcon(bgStrat);
		stLabel[0].setVisible(true);
//		หน้าเล่นเกม
		bgPanel[1] = new JPanel();
		bgPanel[1].setBounds(0, 0, 700, 700);
		bgPanel[1].setBackground(Color.green);
		bgPanel[1].setLayout(null);
		bgPanel[1].setVisible(false);
		
//		หน้าสุดท้าย
		bgPanel[2] = new JPanel();
		bgPanel[2].setBounds(0, 0, 700, 700);
		bgPanel[2].setBackground(Color.green);
		bgPanel[2].setLayout(null);
		bgPanel[2].setVisible(false);
//		หน้าเลือก
		bgPanel[3] = new JPanel();
		bgPanel[3].setBounds(0, 0, 700, 700);
		bgPanel[3].setLayout(null);
		bgPanel[3].setVisible(false);
		
		window.add(bgPanel[0]);
		window.add(bgPanel[1]);
		window.add(bgPanel[2]);
		window.add(bgPanel[3]);
		
		ImageIcon choiceBG = new ImageIcon(getClass().getClassLoader().getResource("choiceBG.png"));
		chLabel[0] = new JLabel();
		chLabel[0].setBounds(0, 0, 700, 700);
		chLabel[0].setIcon(choiceBG);
		
		
		ImageIcon ltIcon1 = new ImageIcon(getClass().getClassLoader().getResource("LastBG.png"));
		ltLabel[0] = new JLabel();
		ltLabel[0].setBounds(-8, -11, 700, 700);
		ltLabel[0].setIcon(ltIcon1);
		
		ImageIcon ltIcon2 = new ImageIcon(getClass().getClassLoader().getResource("RED WIN.png"));
		ltLabel[1] = new JLabel();
		ltLabel[1].setBounds(100, 150, 500, 200);
		ltLabel[1].setIcon(ltIcon2);
		ltLabel[1].setVisible(false);
		
		ImageIcon ltIcon3 = new ImageIcon(getClass().getClassLoader().getResource("GOLD WIN.png"));
		ltLabel[2] = new JLabel();
		ltLabel[2].setBounds(100, 150, 500, 200);
		ltLabel[2].setIcon(ltIcon3);
		ltLabel[2].setVisible(false);
		
		ImageIcon ltIcon4 = new ImageIcon(getClass().getClassLoader().getResource("DRAW.png"));
		ltLabel[3] = new JLabel();
		ltLabel[3].setBounds(100, 150, 500, 200);
		ltLabel[3].setIcon(ltIcon4);
		ltLabel[3].setVisible(true);
		
		ImageIcon bgIcon1 = new ImageIcon(getClass().getClassLoader().getResource("BACKGROUND.png"));
		bgLabel[0] = new JLabel();
		bgLabel[0].setBounds(0, 0, 700, 700);
		bgLabel[0].setIcon(bgIcon1);
		
		ImageIcon bo= new ImageIcon(getClass().getClassLoader().getResource("BB.png"));
		bgLabel[4] = new JLabel();
		bgLabel[4].setBounds(40, 150, 600, 500);
		bgLabel[4].setBackground(Color.blue);
		bgLabel[4].setIcon(bo);
		
		ImageIcon LOGO= new ImageIcon(getClass().getClassLoader().getResource("LOGOGAME.png"));
		
		bgLabel[5] = new JLabel();
		bgLabel[5].setBounds(200, 10, 300, 80);
		bgLabel[5].setIcon(LOGO);
		
		bgLabel[1] = new JLabel();
		bgLabel[1].setBounds(40, 150, 600, 500);
		bgLabel[1].setBackground(Color.black);
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource("Boarder.png"));
		bgLabel[1].setVisible(true);
		bgLabel[1].setIcon(bgIcon);
		bgLabel[1].setLayout(null);
		bgPanel[1].add(bgLabel[1]);
		

		
		
	}

	public void button() {
		
		ImageIcon chIcon1 = new ImageIcon(getClass().getClassLoader().getResource("2 PLAYER.png"));
		chb[0] = new JButton();
		chb[0].setBounds(250, 220, 200, 50);
		chb[0].setIcon(chIcon1);
		chb[0].setVisible(true);
		chb[0].addActionListener(new ActionButton(gm));
		chb[0].setActionCommand("2PLAYER");
		
		ImageIcon chIcon2 = new ImageIcon(getClass().getClassLoader().getResource("BOTVERYEASY.png"));
		chb[1] = new JButton();
		chb[1].setBounds(250, 320, 200, 50);
		chb[1].setIcon(chIcon2);
		chb[1].setVisible(true);
		chb[1].addActionListener(new ActionButton(gm));
		chb[1].setActionCommand("BOTVERYEASY");
		
		ImageIcon chIcon3 = new ImageIcon(getClass().getClassLoader().getResource("BOTEASY.png"));
		chb[2] = new JButton();
		chb[2].setBounds(250, 420, 200, 50);
		chb[2].setIcon(chIcon3);
		chb[2].setVisible(true);
		chb[2].addActionListener(new ActionButton(gm));
		chb[2].setActionCommand("BOTEASY");
		
		ImageIcon chIcon4 = new ImageIcon(getClass().getClassLoader().getResource("BOTMIDIUM.png"));
		chb[3] = new JButton();
		chb[3].setBounds(250, 500, 200, 50);
		chb[3].setIcon(chIcon4);
		chb[3].setVisible(false);
		chb[3].addActionListener(new ActionButton(gm));
		chb[3].setActionCommand("CLOSE");
		
		ImageIcon btStart = new ImageIcon(getClass().getClassLoader().getResource("STRATBUTTON.png"));
		bts[0]  = new JButton();
		bts[0].setIcon(btStart);
		bts[0].setBounds(200, 300, 300, 80);
		bts[0].addActionListener(new ActionButton(gm));
		bts[0].setContentAreaFilled(false);
		bts[0].setActionCommand("clickStart");

		ImageIcon ltLobby= new ImageIcon(getClass().getClassLoader().getResource("LOBBY.png"));
		ltb[0]  = new JButton();
		ltb[0].setIcon(ltLobby);
		ltb[0].setBounds(205, 500, 300, 80);
		ltb[0].addActionListener(new ActionButton(gm));
		ltb[0].setContentAreaFilled(false);
		ltb[0].setFocusPainted(false);
		ltb[0].setBorderPainted(false);
		ltb[0].setActionCommand("LobbyGame");
		
		ImageIcon bt1 = new ImageIcon(getClass().getClassLoader().getResource("GA.png"));
		
		int x1=70;
		for(int i=0;i<7;i++) {
			buttonG[i] = new JButton();
			buttonG[i].setBounds(x1, 90, 50, 50);
			buttonG[i].setIcon(bt1);
			buttonG[i].setBackground(null);
			buttonG[i].setBorderPainted(false);
			buttonG[i].setVisible(false);
			buttonG[i].setFocusPainted(false);
			buttonG[i].setContentAreaFilled(false);
			buttonG[i].addActionListener(new ActionButton(gm));
			buttonG[i].setActionCommand("Gold"+i);
			
			bgPanel[1].add(buttonG[i]);
			x1+=82;
		}
		ImageIcon bt2 = new ImageIcon(getClass().getClassLoader().getResource("RA.png"));
		
		x1=70;
		for(int i=0;i<7;i++) {
			buttonR[i] = new JButton();
			buttonR[i].setBounds(x1, 90, 50, 50);
			buttonR[i].setIcon(bt2);
			buttonR[i].setBackground(null);
			buttonR[i].setBorderPainted(false);
			buttonR[i].setVisible(false);
			buttonR[i].setFocusPainted(false);
			buttonR[i].setContentAreaFilled(false);
			buttonR[i].addActionListener(new ActionButton(gm));
			buttonR[i].setActionCommand("Red"+i);
			bgPanel[1].add(buttonR[i]);
			x1+=82;
		}
	}
	public ImageIcon box= new ImageIcon(getClass().getClassLoader().getResource("REDLOGO.png"));
	public ImageIcon box1= new ImageIcon(getClass().getClassLoader().getResource("GOLD ROUND.png"));
	
	public void createObject() {
		int x=56;
		int y=160;
		int nub=0;
		
		bgLabel[2] = new JLabel();
		bgLabel[2].setBounds(170, 320, 350, 100);
		bgLabel[2].setIcon(box1);
		bgLabel[2].setVisible(false);
		bgPanel[1].add(bgLabel[2]);
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<7;j++) {
				objectLabelG[nub] = new JLabel();
				objectLabelG[nub].setBounds(x, y, 80, 80);
				objectLabelG[nub].setVisible(false);
				nub++;
				x+=82;
			}
			y+=80;
			x=56;
		}
		nub = 0;
		x=56;
		y=160;
		for(int i=0;i<6;i++) {
			for(int j=0;j<7;j++) {
				objectLabelR[nub] = new JLabel();
				objectLabelR[nub].setBounds(x, y, 80, 80);
				objectLabelR[nub].setVisible(false);
				nub++;
				x+=82;
			}
			y+=80;
			x=56;
		}

		bgPanel[1].add(bgLabel[1]);
		for(int i=0;i<42;i++) {
			ImageIcon objectLabelCoin1= new ImageIcon(getClass().getClassLoader().getResource("3.png"));
			objectLabelG[i].setIcon(objectLabelCoin1);
			bgPanel[1].add(objectLabelG[i]);
		}
		
		for(int i=0;i<42;i++) {
			ImageIcon objectLabelCoin2= new ImageIcon(getClass().getClassLoader().getResource("4.png"));
			objectLabelR[i].setIcon(objectLabelCoin2);
			bgPanel[1].add(objectLabelR[i]);
		}
		
		ImageIcon LOGOGAME= new ImageIcon(getClass().getClassLoader().getResource("RealLOGO1.png"));
		stLabel[1] = new JLabel();
		stLabel[1].setBounds(100, 50, 500, 200);
		stLabel[1].setIcon(LOGOGAME);
		
//		scene1
		bgPanel[0].add(stLabel[1]);
		bgPanel[0].add(bts[0]);
		bgPanel[0].add(stLabel[0]);
		
//		scene2
		bgPanel[1].add(bgLabel[5]);
		bgPanel[1].add(bgLabel[4]);
		bgPanel[1].add(bgLabel[0]);
		
//		scence3
		bgPanel[2].add(ltb[0]);
		bgPanel[2].add(ltLabel[2]);
		bgPanel[2].add(ltLabel[3]);
		bgPanel[2].add(ltLabel[1]);
		bgPanel[2].add(ltLabel[0]);
//		scence4
		bgPanel[3].add(chb[0]);
		bgPanel[3].add(chb[1]);
		bgPanel[3].add(chb[2]);
		bgPanel[3].add(chb[3]);
		bgPanel[3].add(chLabel[0]);
		
	}
	
	public void setCoinRed(int x) {
		objectLabelR[x].setVisible(true);
	}
	public void setCoinGold(int x) {
		objectLabelG[x].setVisible(true);
	}
	
	public void setGoldRound() {
		bgLabel[2].setVisible(false);
		bgLabel[2].setIcon(box1);
		if(botEasy==false&&botEasyM==false&&botMid==false) {
			bgLabel[2].setVisible(true);
			for(int i=0;i<7;i++) {
				buttonR[i].setVisible(false);
				buttonG[i].setVisible(true);
			}
		}
		
		
	}
	public void setRedRound() {
		bgLabel[2].setVisible(false);
		bgLabel[2].setIcon(box);
		bgLabel[2].setVisible(true);
		for(int i=0;i<7;i++) {
			buttonG[i].setVisible(false);
			buttonR[i].setVisible(true);
		}
	}
	public void setStartGame(int n) {
		bgPanel[0].setVisible(false);
		bgPanel[2].setVisible(false);
		bgPanel[3].setVisible(false);
		bgPanel[1].setVisible(true);
		if(n==0) {
			botEasy  = false;
			botEasyM = false;
			botMid = false;
		}
		if(n==1) {
			botEasy  = true;
			botEasyM = false;
			botMid = false;
		}
		if(n==2) {
			botEasy  = false;
			botEasyM = true;
			botMid = false;
		}
		if(n==3) {
			botEasy  = false;
			botEasyM = false;
			botMid = true;
		}
	}
	public void setLobby() {
		bgPanel[2].setVisible(false);
		bgPanel[1].setVisible(false);
		bgPanel[3].setVisible(false);
		bgPanel[0].setVisible(true);
		closeCoin();
	}
	public void closeCoin() {
		int nub=0;
		for(int i=0;i<6;i++) {
			for(int j=0;j<7;j++) {
				objectLabelR[nub].setVisible(false);
				objectLabelG[nub].setVisible(false);
				nub++;
			}
		}
	}
	public void RedWin() {
		bgPanel[2].setVisible(true);
		bgPanel[1].setVisible(false);
		ltLabel[1].setVisible(true);
		ltLabel[2].setVisible(false);
		ltLabel[3].setVisible(false);
		for(int i=0;i<7;i++) {
			buttonR[i].setVisible(true);
			buttonG[i].setVisible(false);
		}
		
	}
	public void GoldWin() {
		bgPanel[2].setVisible(true);
		bgPanel[1].setVisible(false);
		ltLabel[1].setVisible(false);
		ltLabel[2].setVisible(true);
		ltLabel[3].setVisible(false);
		for(int i=0;i<7;i++) {
			buttonR[i].setVisible(true);
			buttonG[i].setVisible(false);
		}
	}
	public void Draw() {
		bgPanel[2].setVisible(true);
		bgPanel[1].setVisible(false);
		ltLabel[1].setVisible(false);
		ltLabel[2].setVisible(false);
		ltLabel[3].setVisible(true);
		for(int i=0;i<7;i++) {
			buttonR[i].setVisible(true);
			buttonG[i].setVisible(false);
		}
	}
	public void clickStart() {
		bgPanel[3].setVisible(true);
		bgPanel[1].setVisible(false);
		bgPanel[2].setVisible(false);
		bgPanel[0].setVisible(false);
	}
	public void generate() {
		
		createMainField();
		createBackground();
		button();
		createObject();
		setRedRound();
		
	}
}
