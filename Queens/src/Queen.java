import java.util.Scanner;



public class Queen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[][] chessSize=new int[8][8];
			int numOfQueens=8;
			int temp=0,count=0,count1=0;
			for(int i=0;i<8;i++)
				for(int j=0;j<8;j++)
					chessSize[i][j]=0;
			int rowPos=0;
		while(numOfQueens>0)
		{
			System.out.println("Enter the row and column position to place the queen");
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					if(chessSize[i][j]==1||chessSize[i][j]==2)
						count++;
				}
			}

			if(count==64)
			{
				System.out.println("Not a feasible solution");
				break;
			}
			else
				count=0;
			
			for(int i=0;i<8;i++)
			{
				if(chessSize[rowPos][i]==1||chessSize[rowPos][i]==2)
					count1++;
			}
			if(count1==8)
			{
				System.out.println("Not a feasible solution");
				break;
			}
			else
				count1=0;
			int colPos=(int)(Math.random()*10)%8;
		//	Scanner s=new Scanner(System.in);
			System.out.println(rowPos + " " +colPos );	
			//String a=s.nextLine();
			if(chessSize[rowPos][colPos]==0)
			{
				numOfQueens=queens(rowPos,colPos,chessSize,numOfQueens);	/////
				System.out.println("num of queens"+numOfQueens);
				rowPos++;
		    }
			else
			{
				System.out.println("cannot place a queen here");
				colPos=(int)(Math.random()*10)%8;
			//	Scanner s1=new Scanner(System.in);
				System.out.println(rowPos + " " +colPos );
				//String b=s.nextLine();
				if(chessSize[rowPos][colPos]==0)
				{
					numOfQueens=queens(rowPos,colPos,chessSize,numOfQueens);	/////
					System.out.println("num of queens"+numOfQueens);
					rowPos++;
				}
			}
	    }		
	}
    public static int queens(int rowPos,int colPos,int[][] chessSize,int numOfQueens)
    {
    	for(int i=0;i<colPos;i++)
			chessSize[rowPos][i]=1;
		for(int j=colPos;j<8;j++)
			chessSize[rowPos][j]=1;
		
		for(int i=0;i<rowPos;i++)
			chessSize[i][colPos]=1;
		for(int j=rowPos;j<8;j++)
			chessSize[j][colPos]=1;
		int r=rowPos; int c=colPos;
		while((r>=0&&r<=7)&&(c>=0&&c<=7))	//left upper diagonal
		{
			chessSize[r][c]=1;
			r--;c--;
		}
		r=rowPos;
		c=colPos;
		while((r>=0&&r<=7)&&(c>=0&&c<=7))  //right lower diagonal
		{
			chessSize[r][c]=1;
			r++;c++;
		}
		r=rowPos;
		c=colPos;
		while((r>=0&&r<=7)&&(c>=0&&c<=7))  //left lower diagonal
		{
			chessSize[r][c]=1;
			r++;c--;
		}
		r=rowPos;
		c=colPos;
		while((r>=0&&r<=7)&&(c>=0&&c<=7))  //right upper diagonal
		{
			chessSize[r][c]=1;
			r--;c++;
		}
		chessSize[rowPos][colPos]=2;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
				System.out.print(chessSize[i][j]+" ");
			System.out.println();
		}
		numOfQueens--;
		r=0;c=0;
        return numOfQueens; 
    }
}
