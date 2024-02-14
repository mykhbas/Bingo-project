package Main;
import java.util.Random;
public class botPlay {
	GameManager gm;
	public botPlay(GameManager gm) {
		this.gm = gm;
	} 
	public Random rand = new Random();
	private int[][] board = new int[7][6]; 
	private int [] nubrow = new int [7];
	private int [] checkClose = new int[7];
	
	
	public void setBoard(int[][] board) {
		this.board = board;
	}
	public void setNubrow(int[] nubrow1) {
		nubrow = nubrow1;
	}
	public void setCheckClose(int[] check) {
		checkClose = check;
	}
	public int[] getCheckClose() {
		return checkClose;
	}
	public int[][] getBoard(){
		return board;
	}
	public int[] getNubrow1() {
		return nubrow;
	}
	
	public void BotEasyPlay() {
		int x =rand.nextInt(0,6);
		while(nubrow[x]==6) {
			x =rand.nextInt(0,6);
		}
		for(int i =0;i<6;i++) {
			if(nubrow[x]>=6) {
				break;
			}
			else if(board[x][5-i]==0&&nubrow[x]<6) {
				System.out.println(x);
				board[x][5-i] = 2;
				gm.ui.setCoinGold((41-(6-x))-(i*7));
				nubrow[x]++;
				break;
			}
		}
		for(int i=0;i<7;i++) {
			System.out.print(nubrow[i]+" ");
		}
		System.out.println();
		gm.gp.checkBingo();
	}
	
	
	public void BotEasyMPlay() {
		int x =rand.nextInt(0,6);
		while(nubrow[x]==6) {
			x =rand.nextInt(0,6);
		}
		int nub =0;
		for(int i=0;i<7;i++) {
			nub =0;
			if(nubrow[i]<7) {
				
				if(nub==1) {
					x=rand.nextInt(0,6);
					nub =0;
					break;
				}
				
				else if(checkClose[i]==1) {
					x = i;
					nub++;
					
					break;
					}
			}
			
		}
		
		System.out.println();
		if(nub==0) {
			x =rand.nextInt(0,6);
		}
		nubrow[x]++;
		checkClose[x] =0;
		for(int i =0;i<7;i++) {
			if(nubrow[x]>6) {
				while(nubrow[x]==6&&board[x][5-i]==0)
					x =rand.nextInt(0,6);
					
				break;
			}
			
			if(board[x][5-i]==0) {
				
				gm.ui.setCoinGold((41-(6-x))-(i*7));
				board[x][5-i] = 2;
				break;
			}
			
		}
		
		gm.gp.checkBingo();
		for(int i =0;i<6;i++) {
			for(int j=0;j<7;j++) {
				System.out.print(board[j][i]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<7;i++) {
			System.out.print(checkClose[i]+" ");
		}
		System.out.println();
		for(int i=0;i<7;i++) {
			System.out.print(nubrow[i]+" ");
		}
		System.out.println();
	}
	
	public void BotMidPlay() {
		int x =0;
		int nub =0;
		for(int i=0;i<6;i++) {
			if(checkClose[i]==1) {
				x = i;
				nub++;
			}
		}
		if(nub == 0) {
			for(int i=0;i<6;i++) {
				if(checkClose[i]==2) {
					x = i;
					nub++;
				}
			}
		}
		if(nub==0)
			x =rand.nextInt(0,6);
		checkClose[x] =0;
		nub =0;
		for(int i =0;i<6;i++) {
			if(nubrow[x]>=6) {
				x =rand.nextInt(0,6);
			}
			else if(board[x][5-i]==0) {
				board[x][5-i] = 2;
				gm.ui.setCoinGold((41-(6-x))-(i*7));
				break;
			}
		}
		gm.gp.checkBingo();
	}
}
