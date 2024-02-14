package Main;

public class pullButton {
	GameManager gm;
	public pullButton(GameManager gm) {
		this.gm = gm;
	}
	int nub =0;
	int[] nubrow =new int [7];
	int[] nubrow1 =new int [7];
	int[][] board = new int[7][6];
	private boolean botEasy = false;
	private boolean botEasyM = false;
	private boolean botMid = false;
	public void setNubrow(int[] nubrow) {
		this.nubrow = nubrow;
	}
	public void setNubrow1(int[] nubrow1) {
		this.nubrow1 = nubrow1;
	}
	public int[] getNubrow1() {
		return nubrow1;
	}
	public int[] getNubrow() {
		return nubrow;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public void setBotEasy(boolean botEasy) {
		this.botEasy = botEasy;
		
	}
	public void setBotEasyM(boolean botEasyM) {
		this.botEasyM = botEasyM;
	}
	public void setBotMid(boolean botMid) {
		this.botMid = botMid;
	}
	public int[][]getBoard(){
		return board;
	}
	public void playRedRow1() {
		for(int i =0;i<6;i++) {
			if(nubrow[0]>=6) {
				break;
			}
			else 
			if(board[0][5-i]==0) {
				board[0][5-i] = 1;
				nubrow1[0]++;
				gm.ui.setCoinRed(35-(i*7));
				gm.gp.runGold();
				nub++;
				break;
			}
		}
		gm.gp.checkBingo();
		gm.bot.setNubrow(nubrow1);
		if(nub>0) {
			nub=0;
			if(botEasy) {
				gm.bot.BotEasyPlay();
			}
			else if(botEasyM) {
				gm.bot.BotEasyMPlay();
			}
			else if(botMid) {
				gm.bot.BotMidPlay();
			}
		}
		
	}
	public void playRedRow2() {
		
		for(int i =0;i<6;i++) {
			if(nubrow[1]>=6) {
				break;
			}
			else if(board[1][5-i]==0) {
				board[1][5-i] = 1;
				nubrow1[1]++;
				gm.ui.setCoinRed(36-(i*7));
				gm.gp.runGold();
				nub++;
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
		if(nub>0) {
			nub=0;
		if(botEasy==true) {
			gm.bot.BotEasyPlay();
		}
		else if(botEasyM) {
			gm.bot.BotEasyMPlay();
		}
		else if(botMid) {
			gm.bot.BotMidPlay();
		}}
	}
	public void playRedRow3() {

		for(int i =0;i<6;i++) {
			if(nubrow[2]>=6) {
				break;
			}
			else if(board[2][5-i]==0) {
				board[2][5-i] = 1;
				nubrow1[2]++;
				gm.ui.setCoinRed(37-(i*7));
				gm.gp.runGold();
				nub++;
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
		if(nub>0) {
			nub=0;
		if(botEasy==true) {
			gm.bot.BotEasyPlay();
		}
		else if(botEasyM) {
			gm.bot.BotEasyMPlay();
		}
		else if(botMid) {
			gm.bot.BotMidPlay();
		}}
	}
	public void playRedRow4() {

		for(int i =0;i<6;i++) {
			if(nubrow[3]>=6) {
				break;
			}
			else if(board[3][5-i]==0) {
				board[3][5-i] = 1;
				nubrow1[3]++;
				gm.ui.setCoinRed(38-(i*7));
				gm.gp.runGold();
				nub++;
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
		if(nub>0) {
			nub=0;
		if(botEasy==true) {
			gm.bot.BotEasyPlay();
		}
		else if(botEasyM) {
			gm.bot.BotEasyMPlay();
		}
		else if(botMid) {
			gm.bot.BotMidPlay();
		}}
	}
	public void playRedRow5() {

		for(int i =0;i<6;i++) {
			if(nubrow[4]>=6) {
				break;
			}
			else if(board[4][5-i]==0) {
				board[4][5-i] = 1;
				nubrow1[4]++;
				gm.ui.setCoinRed(39-(i*7));
				gm.gp.runGold();
				nub++;
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
		if(nub>0) {
			nub=0;
		if(botEasy==true) {
			gm.bot.BotEasyPlay();
		}
		else if(botEasyM) {
			gm.bot.BotEasyMPlay();
		}
		else if(botMid) {
			gm.bot.BotMidPlay();
		}}
	}
	public void playRedRow6() {

		for(int i =0;i<6;i++) {
			if(nubrow[5]>=6) {
				break;
			}
			else if(board[5][5-i]==0) {
				board[5][5-i] = 1;
				nubrow1[5]++;
				gm.ui.setCoinRed(40-(i*7));
				gm.gp.runGold();
				nub++;
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
		if(nub>0) {
			nub=0;
		if(botEasy==true) {
			gm.bot.BotEasyPlay();
		}
		else if(botEasyM) {
			gm.bot.BotEasyMPlay();
		}
		else if(botMid) {
			gm.bot.BotMidPlay();
		}}
	}
	public void playRedRow7() {

		for(int i =0;i<6;i++) {
			if(nubrow[6]>=6) {
				break;
			}
			else if(board[6][5-i]==0) {
				board[6][5-i] = 1;
				nubrow1[6]++;
				gm.ui.setCoinRed(41-(i*7));
				gm.gp.runGold();
				nub++;
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
		if(nub>0) {
			nub=0;
		if(botEasy==true) {
			gm.bot.BotEasyPlay();
		}
		else if(botEasyM) {
			gm.bot.BotEasyMPlay();
		}
		else if(botMid) {
			gm.bot.BotMidPlay();
		}}
	}
	public void playGoldRow1() {

		for(int i =0;i<6;i++) {
			if(nubrow[0]>=6) {
				break;
			}
			else if(board[0][5-i]==0) {
				board[0][5-i] = 2;
				gm.ui.setCoinGold(35-(i*7));
				gm.gp.runRed();
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
		
	}
	public void playGoldRow2() {
		for(int i =0;i<6;i++) {
			if(nubrow[1]>=6) {
				break;
			}
			else if(board[1][5-i]==0) {
				board[1][5-i] = 2;
				gm.ui.setCoinGold(36-(i*7));
				gm.gp.runRed();
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
	}
	public void playGoldRow3() {

		for(int i =0;i<6;i++) {
			if(nubrow[2]>=6) {
				break;
			}
			else if(board[2][5-i]==0) {
				board[2][5-i] = 2;
				gm.ui.setCoinGold(37-(i*7));
				gm.gp.runRed();
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
	}
	public void playGoldRow4() {

		for(int i =0;i<6;i++) {
			if(nubrow[3]>=6) {
				break;
			}
			else if(board[3][5-i]==0) {
				board[3][5-i] = 2;
				gm.ui.setCoinGold(38-(i*7));
				gm.gp.runRed();
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
	}
	public void playGoldRow5() {

		for(int i =0;i<6;i++) {
			
			if(nubrow[4]>=6) {
				break;
			}
			else if(board[4][5-i]==0) {
				board[4][5-i] = 2;
				gm.ui.setCoinGold(39-(i*7));
				gm.gp.runRed();
				break;
			}
			
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
	}
	public void playGoldRow6() {

		for(int i =0;i<6;i++) {
			if(nubrow[5]>=6) {
				break;
			}
			else if(board[5][5-i]==0) {
				board[5][5-i] = 2;
				gm.ui.setCoinGold(40-(i*7));
				gm.gp.runRed();
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
	}
	public void playGoldRow7() {

		for(int i =0;i<6;i++) {
			if(nubrow[6]>=6) {
				break;
			}
			else if(board[6][5-i]==0) {
				board[6][5-i] = 2;
				gm.ui.setCoinGold(41-(i*7));
				gm.gp.runRed();
				break;
			}
		}
		gm.bot.setNubrow(nubrow1);
		gm.gp.checkBingo();
	}
}
