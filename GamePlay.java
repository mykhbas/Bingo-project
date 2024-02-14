package Main;
import java.util.Random;
public class GamePlay {
	UI ui;
	GameManager gm;
	public Random rand = new Random();
	public GamePlay(GameManager gm,UI ui) {
		this.gm = gm;
		this.ui = ui;
		run();
	}
	private boolean botEasy  = false;
	private boolean botEasyM = false;
	private boolean botMid = false;
	private int[] checkClose = new int [7];
	private int[][]board;
	private int[] nubrow = new int [7];
	private int[] nubrow1 = new int [7];
	public void startGame() {
		gm.ui.setGameStat();
	}
	public void Player() {
		gm.ui.setStartGame(0);
		botEasy = false;
		botEasyM = false;
		botMid = false;
	}
	public void BotVeryEasy() {
		gm.ui.setStartGame(1);
		botEasy = true;
		botEasyM = false;
		botMid = false;
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
	}
	public void BotEasy() {
		gm.ui.setStartGame(2);
		
		botEasyM = true;
		botMid = false;
		botEasy = false;
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		
	}
	public void BotMidium() {
		gm.ui.setStartGame(3);
		botMid = true;
		botEasy = false;
		botEasyM = false;
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
	}
	public void setBoard() {
		 board = new int [7][6];
	}
	public void runGold() {
		ui.setGoldRound();
	}
	public void runRed() {
		ui.setRedRound();
		
	}
	public void run() {
		setBoard();
	}

	public void checkBingo() { 
		
		int Rnub =0;
		int Gnub =0;
//		แนวตั้ง
		int nubsu =0;
		for(int i=0;i<7;i++) {
			for(int j=0;j<6;j++) {
				if(board[i][j]!=0) {
					nubsu++;
				}
			}
		}
		if(nubsu>=42) {
			gm.ui.Draw();
			
		}
		for(int i=0;i<7;i++) {
			for(int j=0;j<6;j++) {
				
				if(board[i][j] == 1) {
					Rnub++;
				}
				else Rnub =0;
				if(board[i][j] == 2) {
					Gnub++;
				}
				else Gnub =0;
				if (Rnub == 4) {
					
					gm.ui.RedWin();
					break;
				}
				
				
				if (Gnub == 4) {
					gm.ui.GoldWin();
					break;
				}
				if(botEasyM||botMid) {
					if (Rnub == 3&&j>=3) {

						if(board[i][j-3]!=2) {
							checkClose[i] = 1;
						}
					}
				}
				if(botMid) {
					if (Rnub == 2) {
						checkClose[i] = 2;
					}
				}
				
			}
			Rnub =0;
			Gnub =0;
		}
		Rnub =0;
		Gnub =0;
//		
////แนวนอน
		for(int i=0;i<6;i++) {
			for(int j=0;j<7;j++) {
				
				if(board[j][i] == 1) {
					Rnub++;
				}
				else Rnub =0;
				if(board[j][i] == 2) {
					Gnub++;
				}
				else Gnub=0;
				if (Rnub == 4) {
					gm.ui.RedWin();
					break;
				}
				if (Gnub == 4) {
					gm.ui.GoldWin();
					break;
				}
				
				if(botEasyM||botMid) {
					if (Rnub == 3&&j>2) {
						if(board[j-3][i]!=2) {
							checkClose[j-3] = 1;
						}

					}
					if (Rnub == 3&&j<6) {
						if(board[j+1][i]!=2) {
							checkClose[j+1] = 1;
						}
					}
				}
			}
			Rnub =0;
			Gnub =0;
		}
////		ทะแยง
		
		Rnub =0;
		Gnub =0;
		for(int i =0;i<6;i++) {
			if(board[i][i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i][i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&&i>=3) {
					if(board[i-3][i-3]!=2&&board[i-2][i-3]!=0) {
						checkClose[i-3] = 1;
					}
					
				}
				if (Rnub == 3&&i<5) {
					if(board[i-3][i-3]!=2) {
						checkClose[i+1] = 1;
					}
					
				}
				
			}
		}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<6;i++) {
			
			if(board[i+1][i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i+1][i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				
				if (Rnub == 3&&i>=3) {
					if(board[i-2][i-3]!=2&&board[i-2][i-2] !=0) {
						checkClose[i-2] = 1;
					}
					
				}
				if (Rnub == 3&&i<5) {
					System.out.println("i = "+i);
					if(i<4) {
						if(board[i+2][i+1]!=2&&board[i+2][i+2] !=0) {
							
							checkClose[i+2] = 1;
						}
					}
					else if(i==4) {
						if(board[i+2][i+1]!=2) {
							checkClose[i+2] = 1;
						}
					}
				}
			}
		
		}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<5;i++) {
			
			if(board[i][i+1]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i][i+1] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&&i>3) {
					
					if(board[i-3][i-2]!=2&&board[i-3][i-1] !=0) {
						checkClose[i-3] = 1;
					}
					
				}
				if (Rnub == 3&&i<4) {
					if(i<4) {
						System.out.println("i = "+i);
						if(board[i+1][i+2]!=2) {
							checkClose[i+1] = 1;
						}
					}
					else if(i==4) {
						if(board[i+2][i+1]!=2) {
							checkClose[i+1] = 1;
						}
					}
				}
				
			}

		}
		Rnub =0;
		Gnub =0;
		
		for(int i =0;i<4;i++) {
			
			
			if(board[i][i+2]==1) {
				
				Rnub++;
			}
			else Rnub =0;
			if(board[i][i+2] == 2) {
				
				Gnub++;
			}
			
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&i<4&i>2) {
					if(board[i-3][i-1]!=2&&board[i-3][i] !=0)
						checkClose[i-3] = 1;
					
				}
				if(Rnub ==3&&i==2) {
					if(board[i+1][i+3]!=2) {
						checkClose[i+1] = 1;
					}
					
				}
				
			}
		}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<5;i++) {
			
			if(board[i+2][i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i+2][i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&&i>3) {
					if(board[i-2][i-3]!=2&&board[i-2][i-2] !=0) {
						checkClose[i-3] = 1;
					}
					
				}
				if (Rnub == 3&&i<4) {
					if(i<4) {
						if(board[i+1][i+2]!=2) {
							checkClose[i+1] = 1;
						}
					}
					else if(i==4) {
						if(board[i+2][i+1]!=2) {
							checkClose[i+1] = 1;
						}
					}
				}
			}
		}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<4;i++) {
			if(board[i+3][i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i+3][i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&i<4&i>2) {
					if(board[i-3][i-1]!=2&&board[i-3][i] !=0)
						checkClose[i-3] = 1;
					
				}
				if(Rnub ==3&&i>=2) {
					if(board[i+1][i+3]!=2) {
						checkClose[i+1] = 1;
					}
					
				}
				
			}
		}
		Rnub =0;
		Gnub =0;
//		ล่างขึ้นบน		
for(int i=0;i<6;i++) {
			
			if(board[i][5-i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i][5-i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				// System.out.println(Rnub);
				if(Rnub == 3&&i==2) {
					// System.out.println("xxxxxxxxxxxxxxx");
					if(board[i+1][i]==0&&board[i+1][i+1]!=0){//3,2
						// System.out.println("3333333333333");
						checkClose[i+1]=1;
					}
				}
				if (Rnub == 3&&i==3) {
					// System.out.println("xxxxxxxxxxxxxxx");
					if(board[i-3][i+2]==0) {//0,5
						// System.out.println("11111111111");
						checkClose[i-3] = 1;
					}
					if(board[i+1][i-2]==0&&board[i+1][i-1]!=0){//4,1
						// System.out.println("22222222222");
						checkClose[i+1]=1;
					}
				}
				if (Rnub == 3&&i==4) {
					// System.out.println("bbbbbbbbbbbbbbbb");
					if(board[i-3][i]==0&&board[i-3][i+1]!=0) {//1,4
						checkClose[i-3] = 1;
					}
					if(board[i+1][i-4]==0&&board[i+1][i-3]!=0){//5,0
						// System.out.println("11111111111111");
						checkClose[i+1]=1;
					}
				}
				if (Rnub == 3&&i==5) {
					// System.out.println("aaaaaaaaaaaaaaaaaaa");
					if(board[i-3][i-2]==0&&board[i-3][i-1]!=0) {
						checkClose[i-3] = 1;
					}
				}

			}
		}
		Rnub =0;
		Gnub =0;
		for(int i=0;i<6;i++) {
			
			if(board[i+1][5-i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i+1][5-i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if(botEasyM||botMid) {
					// System.out.println(Rnub);
					if(Rnub == 3&&i==2) {
						// System.out.println("ccccccccccccccccccc");
						if(board[i+2][i]==0&&board[i+2][i+1]!=0){
							// System.out.println("3333333333333");
							checkClose[i+2]=1;
						}
					}
					if (Rnub == 3&&i==3) {
						// System.out.println("xxxxxxxxxxxxxxx");
						if(board[i-2][i+2]==0) {
							// System.out.println("11111111111");
							checkClose[i-2] = 1;
						}
						if(board[i+2][i-2]==0&&board[i+2][i-1]!=0){
							// System.out.println("22222222222");
							checkClose[i+2]=1;
						}
					}
					if (Rnub == 3&&i==4) {
						// System.out.println("bbbbbbbbbbbbbbbb");
						if(board[i-2][i]==0&&board[i-2][i+1]!=0) {
							// System.out.println("000000000000000000000");
							checkClose[i-2] = 1;
						}
						if(board[i+2][i-4]==0&&board[i+2][i-3]!=0){
							// System.out.println("11111111111111");
							checkClose[i+2]=1;
						}
					}
					if (Rnub == 3&&i==5) {
						// System.out.println("aaaaaaaaaaaaaaaaaaa");
						if(board[i-2][i-2]==0&&board[i-2][i-1]!=0) {
							checkClose[i-2] = 1;
						}
					}
	
				}
		}
	}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<5;i++) {
			
			if(board[i][4-i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i][4-i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&&i==2) {
					// System.out.println("bbbbbbbbbbbbbbbb");
					if(board[i+1][i-1]==0&&board[i+1][i] !=0) {//3,1
						// System.out.println("22222222222222");
						checkClose[i+1] = 1;
					}
				}
				if (Rnub == 3&&i==3) {
					// 
					if(board[i-3][i+1]==0&&board[i-3][i+2] !=0) {//0,4
						// System.out.println("1111111111111");
						checkClose[i-3] = 1;
					}
					if(board[i+1][i-3]==0&&board[i+1][i-2] !=0) {//4,0
						// System.out.println("5555555555555");
						checkClose[i+1] = 1;
					}		
				}
				if (Rnub == 3&&i==4) {
					// System.out.println("aaaaaaaaaaaaaaaaaaaa");
					if(board[i-3][i-1]==0&&board[i-3][i]!=0) {//1,3
						// System.out.println("1111111111111");
						checkClose[i-3] = 1;
					}
				}
			}
		}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<4;i++) {
			if(board[i][3-i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i][3-i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&i==3) {
					// System.out.println("xxxxxxxxxxxxxx");
					if(board[i-3][i]==0&&board[i-3][i+1] !=0){
						// System.out.println("111111111111111111");
						checkClose[i-3] = 1;}
					
				}
				if(Rnub ==3&&i==2) {
					// System.out.println("aaaaaaaaaaa");
					if(board[i+1][i-2]==0&&board[i+1][i-1]!=0) {
						// System.out.println("2222222222222");
						checkClose[i+1] = 1;
					}
					
				}
				
			}
		}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<5;i++) {
			
			if(board[i+2][5-i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i+2][5-i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&&i==2) {
					// System.out.println("bbbbbbbbbbbbbbbb");
					if(board[i+3][i]==0&&board[i+3][i+2] !=0) {//5,2
						// System.out.println("22222222222222");
						checkClose[i+3] = 1;
					}
				}
				if (Rnub == 3&&i==3) {
					// System.out.println("xxxxxxxxxxxxxxxxxxx");
					if(board[i-1][i+2]==0) {//2,5
						// System.out.println("1111111111111");
						checkClose[i-1] = 1;
					}
					if(board[i+3][i-2]==0&&board[i+3][i-1] !=0) {//6,1
						// System.out.println("5555555555555");
						checkClose[i+1] = 1;
					}		
				}
				if (Rnub == 3&&i==4) {
					// System.out.println("aaaaaaaaaaaaaaaaaaaa");
					if(board[i-1][i]==0&&board[i-1][i+1]!=0) {//3,4
						// System.out.println("1111111111111");
						checkClose[i-1] = 1;
					}
				}
			}
		}
		Rnub =0;
		Gnub =0;
		for(int i =0;i<4;i++) {
			
			if(board[i+3][5-i]==1) {
				Rnub++;
			}
			else Rnub =0;
			if(board[i+3][5-i] == 2) {
				Gnub++;
			}
			else Gnub=0;
			if (Rnub == 4) {
				gm.ui.RedWin();
				break;
			}
			if (Gnub == 4) {
				gm.ui.GoldWin();
				break;
			}
			if(botEasyM||botMid) {
				if (Rnub == 3&i==3) {
					// System.out.println("bbbbbbbbbbbbbbbb");
					if(board[i][i+2]==0){
						checkClose[i] = 1;
					}
				}
				if(Rnub ==3&&i==2) {
					// System.out.println("aaaaaaaaaaaa");
					if(board[i+4][i]==0&&board[i+4][i+1]!=0) {
						// System.out.println("11111111111");
						checkClose[i+4] = 1;
					}
					
				}
			}
		}
		Rnub =0;
		Gnub =0;
	}
//	
	
	
	public void playRedRow1() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playRedRow1();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playRedRow2() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playRedRow2();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playRedRow3() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playRedRow3();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playRedRow4() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playRedRow4();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playRedRow5() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playRedRow5();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
		
	}
	public void playRedRow6() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playRedRow6();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playRedRow7() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playRedRow7();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playGoldRow1() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playGoldRow1();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playGoldRow2() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playGoldRow2();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playGoldRow3() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playGoldRow3();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playGoldRow4() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playGoldRow4();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playGoldRow5() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playGoldRow5();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playGoldRow6() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playGoldRow6();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void playGoldRow7() {
		gm.bot.setCheckClose(checkClose);
		gm.bot.setBoard(board);
		gm.pB.setBoard(board);
		gm.pB.setNubrow(nubrow);
		gm.pB.setNubrow1(nubrow1);
		gm.pB.setBotEasy(botEasy);
		gm.pB.setBotEasyM(botEasyM);
		gm.pB.setBotMid(botMid);
		gm.pB.playGoldRow7();
		nubrow1 = gm.pB.getNubrow1();
		nubrow = gm.pB.getNubrow();
		board = gm.pB.getBoard();
		gm.bot.setBoard(board);
		gm.bot.setCheckClose(checkClose);
	}
	public void reLobby() {
		gm.ui.setLobby();
		reBoard();
		reRow();
	}
	public void reBoard() {
		for(int i =0;i<7;i++) {
			for(int j =0;j<6;j++) {
				board[i][j] =0;
				checkClose[j]=0;
			}
		}
	}
	public void reRow() {
		for(int i=0;i<7;i++) {
			nubrow1[i] =0;
		}
	}

	public void BotEasyPlay() {
		gm.bot.setBoard(board);
		gm.bot.setNubrow(nubrow1);
		gm.bot.BotEasyPlay();
		board = gm.bot.getBoard();
		nubrow1 = gm.pB.getNubrow1();
	}
	///////////////////////////////////////////////////
	public void BotEasyMPlay() {
		gm.bot.setBoard(board);
		gm.bot.setNubrow(nubrow1);
		gm.bot.setCheckClose(checkClose);
		gm.bot.BotEasyMPlay();
		checkClose = gm.bot.getCheckClose();
		board = gm.bot.getBoard();
		nubrow1 = gm.pB.getNubrow1();
	}
	////////////////////////////////////////////////////
	public void BotMidPlay() {
		gm.bot.setBoard(board);
		gm.bot.setNubrow(nubrow1);
		gm.bot.setCheckClose(checkClose);
		gm.bot.BotMidPlay();
		checkClose = gm.bot.getCheckClose();
		board = gm.bot.getBoard();
		nubrow1 = gm.pB.getNubrow1();
	}

	
}
