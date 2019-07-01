
package TreasureGame;
import java.util.Scanner;
public class Treasure {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

Scanner input=new Scanner(System.in);		

int[][] grid=new int [6][6];
int[][]show=new int[6][6];
int[] cl=new int[5];
int[] rw=new int[5];
int []row1=new int[10];
int []row2=new int[10];
int coinsum=0;
int chestpoint=0;
int ghostrw=0;
int ghostcl=0;
int monsterrw=0;
int monstercl=0;
int cobrarw=0;
int cobracl=0;
int one=1,two=2,three=3,four=4,five=5;
int move=0;

for(int row=0;row<6;row++){
	for(int col=0;col<6;col++){
		grid[row][col]=0;
		show[row][col]=0;
	}
}

chestSet(grid,show,cl,rw);
grid[ghostrw][ghostcl]=ghostSet(grid,ghostrw,ghostcl);
monsterSet(grid,monsterrw,monstercl);
cobraSet(grid,cobrarw,cobracl);

Pgrid(grid);

System.out.println("ghost" +ghostrw);
System.out.println("monster" +monsterrw+","+monstercl);
System.out.println("cobra" +cobrarw+","+cobracl);
for(int u=0;u<5;u++){
	System.out.println(rw[u]+","+cl[u]);
}

for(int ask=0;ask<=10;ask++){
	
	if(ask>=10){
		if(chestpoint==5){
		System.out.println("HURRAY! You Won with "+coinsum+"coins");
		break;
		}
		else{
			System.out.println("Game over! you ran out of tries and ended off with "+coinsum+" coins.");
			break;
		}
	}
	
	do{
		System.out.println("Enter a value for coordinate of the row between 0 to 5.");
		row1[ask]=input.nextInt();
	}while(row1[ask]<0 || row1[ask]>5);{
	}
	
	do{
		System.out.println("Enter a value for coordinate of the column between 0 to 5.");
		row2[ask]=input.nextInt();
		
	}while(row2[ask]<0 || row2[ask]>5);{
	}
	
	if(grid[row1[ask]][row2[ask]]==1){
		System.out.println("Hurray! You found a treasure worth of "+one+" coin.");
		coinsum=coinsum+one;
		chestpoint++;
		System.out.println("You hold "+coinsum+" coins in total.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
	}
	else if(grid[row1[ask]][row2[ask]]==2){
		System.out.println("Hurray! You found a treasure worth of "+two+" coin.");
		coinsum=coinsum+two;
		chestpoint++;
		System.out.println("You hold "+coinsum+" coins in total.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
	}
	else if(grid[row1[ask]][row2[ask]]==3){
		System.out.println("Hurray! You found a treasure worth of "+three+" coin.");
		coinsum=coinsum+three;
		chestpoint++;
		System.out.println("You hold "+coinsum+" coins in total.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
	}
	else if(grid[row1[ask]][row2[ask]]==4){
		System.out.println("Hurray! You found a treasure worth of "+four+" coin.");
		coinsum=coinsum+four;
		chestpoint++;
		System.out.println("You hold "+coinsum+" coins in total.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
	}
	else if(grid[row1[ask]][row2[ask]]==5){
		System.out.println("Hurray! You found a treasure worth of "+five+" coin.");
		coinsum=coinsum+five;
		chestpoint++;
		System.out.println("You hold "+coinsum+" coins in total.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
	}
	else if(grid[row1[ask]][row2[ask]]==6){
		System.out.println("Oh no! the ghost took 1 coin away from you.");
		coinsum--;
		System.out.println("You hold "+coinsum+" coins in total.");
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
	}
	else if(grid[row1[ask]][row2[ask]]==7){
		System.out.println("Oh no! the monster took all the coins away from you.");
		coinsum=0;
		System.out.println("You hold "+coinsum+" coins in total.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pshow(show);
	}
	else if(grid[row1[ask]][row2[ask]]==8){
		System.out.println("Oh no! You died.");
		System.out.println("You held "+coinsum+" coins before you died...try again next time.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
		break;
	}
	else{
		System.out.println("Nothing in this chest...try again.");
		show[row1[ask]][row2[ask]]=grid[row1[ask]][row2[ask]];
		ghostMove(grid,ghostrw,ghostcl,move);
		Pgrid(grid);
	}
	
}


}
	public static void Pgrid(int[][]grid){
		for(int row=0;row<6;row++){
			for(int col=0;col<6;col++){
				System.out.print(grid[row][col]+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static void Pshow(int[][]show){
		for(int row=0;row<6;row++){
			for(int col=0;col<6;col++){
				System.out.print(show[row][col]+" ");
			}
			System.out.println(" ");
		}
	}
	
	public static void chestSet(int[][]grid,int[][]show,int[]cl,int[]rw){
		for(int u=0;u<5;u++){
			cl[u]=(int)(Math.random()*6);
			rw[u]=(int)(Math.random()*6);
			
			while(grid[rw[u]][cl[u]]==0){
			cl[u]=(int)(Math.random()*6);
			rw[u]=(int)(Math.random()*6);
			show[rw[u]][cl[u]]=grid[rw[u]][cl[u]];
			grid[rw[u]][cl[u]]=u+1;
		}
		}
	}
	
	public static void monsterSet(int[][]grid,int monsterrw,int monstercl){
		monsterrw=(int)(Math.random()*6);
		monstercl=(int)(Math.random()*6);
		
		while(grid[monsterrw][monstercl]==0){
			monsterrw=(int)(Math.random()*6);
			monstercl=(int)(Math.random()*6);
		grid[monsterrw][monstercl]=7;
		}
		}

	
	public static void cobraSet(int[][]grid,int cobrarw,int cobracl){
			cobrarw=(int)(Math.random()*6);
			cobracl=(int)(Math.random()*6);
			
		while(grid[cobrarw][cobracl]==0){
		cobrarw=(int)(Math.random()*6);
		cobracl=(int)(Math.random()*6);
		grid[cobrarw][cobracl]=8;
		}
		}
	
	public static int ghostSet(int[][]grid,int ghostrw,int ghostcl){
		ghostrw=(int)(Math.random()*6);
		ghostcl=(int)(Math.random()*6);
		
		while(grid[ghostrw][ghostcl]==0){
			ghostrw=(int)(Math.random()*6);
			ghostcl=(int)(Math.random()*6);
		grid[ghostrw][ghostcl]=6;
		}
return grid[ghostrw][ghostcl];
		}

	
	public static void ghostMove(int[][]grid,int ghostrw,int ghostcl,int move){
		grid[ghostrw][ghostcl]=0;
		
		if(ghostrw==0 && ghostcl==0){
			move=(int)(Math.random()*3+1);
			if(move==1){
				if(grid[ghostrw][ghostcl+1]==0)
				grid[ghostrw][ghostcl+1]=6;
			}
			else if(move==2){
				if(grid[ghostrw+1][ghostcl+1]==0)
			grid[ghostrw+1][ghostcl+1]=6;
			}
			else if(move==3){
				if(grid[ghostrw+1][ghostcl]==0)
			grid[ghostrw+1][ghostcl]=6;
			}
		}
		else if(ghostrw==0 && ghostcl==5){
			move=(int)(Math.random()*3+1);
			if(move==1){
				if(grid[ghostrw][ghostcl-1]==0)
			grid[ghostrw][ghostcl-1]=6;
			}
			else if(move==2){
				if(grid[ghostrw+1][ghostcl-1]==0)
			grid[ghostrw+1][ghostcl-1]=6;
			}
			else if(move==3){
				if(grid[ghostrw+1][ghostcl]==0)
			grid[ghostrw+1][ghostcl]=6;
			}
		}
		else if(ghostrw==5 && ghostcl==0){
			move=(int)(Math.random()*3+1);
			if(move==1){
				if(grid[ghostrw-1][ghostcl]==0)
			grid[ghostrw-1][ghostcl]=6;
			}
			else if(move==2){
				if(grid[ghostrw-1][ghostcl+1]==0)
			grid[ghostrw-1][ghostcl+1]=6;
			}
			else if(move==3){
				if(grid[ghostrw][ghostcl+1]==0)
			grid[ghostrw][ghostcl+1]=6;
			}
		}
		else if(ghostrw==5 && ghostcl==5){
			move=(int)(Math.random()*3+1);
			if(move==1){
				if(grid[ghostrw-1][ghostcl]==0)
			grid[ghostrw-1][ghostcl]=6;
			}
			else if(move==2){
				if(grid[ghostrw-1][ghostcl-1]==0)
			grid[ghostrw-1][ghostcl-1]=6;
			}
			else if(move==3){
				if(grid[ghostrw][ghostcl-1]==0)
			grid[ghostrw][ghostcl-1]=6;
			}
		}
		else if(ghostrw==0 && (ghostcl<5 && ghostcl>0)){
			move=(int)(Math.random()*5+1);
			if(move==1){
				if(grid[ghostrw][ghostcl-1]==0)
			grid[ghostrw][ghostcl-1]=6;
			}
			else if(move==2){
				if(grid[ghostrw+1][ghostcl-1]==0)
			grid[ghostrw+1][ghostcl-1]=6;
			}
			else if(move==3){
				if(grid[ghostrw+1][ghostcl]==0)
			grid[ghostrw+1][ghostcl]=6;
			}
			else if(move==4){
				if(grid[ghostrw+1][ghostcl+1]==0)
			grid[ghostrw+1][ghostcl+1]=6;
			}
			else if(move==5){
				if(grid[ghostrw][ghostcl+1]==0)
			grid[ghostrw][ghostcl+1]=6;
			}
		}
		else if(ghostrw==5 && (ghostcl<5 && ghostcl>0)){
			move=(int)(Math.random()*5+1);
			if(move==1){
				if(grid[ghostrw][ghostcl-1]==0)
			grid[ghostrw][ghostcl-1]=6;
			}
			else if(move==2){
				if(grid[ghostrw-1][ghostcl-1]==0)
			grid[ghostrw-1][ghostcl-1]=6;
			}
			else if(move==3){
				if(grid[ghostrw-1][ghostcl]==0)
			grid[ghostrw-1][ghostcl]=6;
			}
			else if(move==4){
				if(grid[ghostrw-1][ghostcl+1]==0)
			grid[ghostrw-1][ghostcl+1]=6;
			}
			else if(move==5){
				if(grid[ghostrw][ghostcl+1]==0)
			grid[ghostrw][ghostcl+1]=6;
			}
		}
		else if((ghostrw<5 && ghostrw>0) && ghostcl==0){
			move=(int)(Math.random()*5+1);
			if(move==1){
				if(grid[ghostrw-1][ghostcl]==0)
			grid[ghostrw-1][ghostcl]=6;
			}
			else if(move==2){
				if(grid[ghostrw-1][ghostcl+1]==0)
			grid[ghostrw-1][ghostcl+1]=6;
			}
			else if(move==3){
				if(grid[ghostrw][ghostcl+1]==0)
			grid[ghostrw][ghostcl+1]=6;
			}
			else if(move==4){
				if(grid[ghostrw+1][ghostcl+1]==0)
			grid[ghostrw+1][ghostcl+1]=6;
			}
			else if(move==5){
				if(grid[ghostrw+1][ghostcl]==0)
			grid[ghostrw+1][ghostcl]=6;
			}
		}
		else if((ghostrw<5 && ghostrw>0) && ghostcl==5){
			move=(int)(Math.random()*5+1);
			if(move==1){
				if(grid[ghostrw-1][ghostcl]==0)
			grid[ghostrw-1][ghostcl]=6;
			}
			else if(move==2){
				if(grid[ghostrw-1][ghostcl-1]==0)
			grid[ghostrw-1][ghostcl-1]=6;
			}
			else if(move==3){
				if(grid[ghostrw][ghostcl-1]==0)
			grid[ghostrw][ghostcl-1]=6;
			}
			else if(move==4){
				if(grid[ghostrw+1][ghostcl-1]==0)
			grid[ghostrw+1][ghostcl-1]=6;
			}
			else if(move==5){
				if(grid[ghostrw+1][ghostcl]==0)
			grid[ghostrw+1][ghostcl]=6;
			}
		}
		else{
			move=(int)(Math.random()*8+1);
			if(move==1){
				if(grid[ghostrw-1][ghostcl]==0)
			grid[ghostrw-1][ghostcl]=6;
			}
			else if(move==2){
				if(grid[ghostrw-1][ghostcl-1]==0)
			grid[ghostrw-1][ghostcl-1]=6;
			}
			else if(move==3){
				if(grid[ghostrw][ghostcl-1]==0)
			grid[ghostrw][ghostcl-1]=6;
			}
			else if(move==4){
				if(grid[ghostrw+1][ghostcl-1]==0)
			grid[ghostrw+1][ghostcl-1]=6;
			}
			else if(move==5){
				if(grid[ghostrw+1][ghostcl]==0)
			grid[ghostrw+1][ghostcl]=6;
			}
			else if(move==6){
				if(grid[ghostrw+1][ghostcl+1]==0)
			grid[ghostrw+1][ghostcl+1]=6;
			}
			else if(move==7){
				if(grid[ghostrw][ghostcl+1]==0)
			grid[ghostrw][ghostcl+1]=6;
			}
			else if(move==8){
				if(grid[ghostrw-1][ghostcl+1]==0)
			grid[ghostrw-1][ghostcl+1]=6;
			}
		}
		
	}
}
