package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButton implements ActionListener {
	GameManager gm;
	public ActionButton(GameManager gm) {
		this.gm = gm;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		case "LobbyGame":gm.gp.reLobby();break;
		case "clickStart":gm.gp.startGame();break;
		case "2PLAYER":gm.gp.Player();break;
		case "BOTVERYEASY":gm.gp.BotVeryEasy();break;
		case "BOTEASY":gm.gp.BotEasy();break;
		case "BOTMIDIUM":gm.gp.BotMidium() ;break;
		case "Red0":gm.gp.playRedRow1();break;
		case "Red1":gm.gp.playRedRow2();break;
		case "Red2":gm.gp.playRedRow3();break;
		case "Red3":gm.gp.playRedRow4();break;
		case "Red4":gm.gp.playRedRow5();break;
		case "Red5":gm.gp.playRedRow6();break;
		case "Red6":gm.gp.playRedRow7();break;
		case "Gold0":gm.gp.playGoldRow1();break;
		case "Gold1":gm.gp.playGoldRow2();break;
		case "Gold2":gm.gp.playGoldRow3();break;
		case "Gold3":gm.gp.playGoldRow4();break;
		case "Gold4":gm.gp.playGoldRow5();break;
		case "Gold5":gm.gp.playGoldRow6();break;
		case "Gold6":gm.gp.playGoldRow7();break;
		}
		
	}
	
}
