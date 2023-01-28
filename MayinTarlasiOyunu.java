import java.util.Random;
import java.util.Scanner;
	/* -2 = etrafındaki birer karede mayın yok
	   -1 = seçtiğin karede mayın var
	    seçtiğin karede mayın varsa kaç tane mayın ise onu yazdır */

public class MayinTarlasiOyunu 
{
	
	
	int rowNumber = 2 , colNumber = 2 , size;
	int[][] map; // bu mayınların haritasi
	int [][] board;  // bu kullanıcının oynayacağı
	boolean game = true;
	
	Random rand = new Random();
	Scanner input = new Scanner(System.in); 
	
	MayinTarlasiOyunu(int rowNumber , int colNumber)
	{
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.map = new int [rowNumber][colNumber]; // yukarıda mapin-boardın kaç boytlu olduğunu belirmemiştik. 
												   // Boyutu kullanıcıdan alacağız.
		this.board = new int [rowNumber][colNumber];
		this.size = rowNumber * colNumber;
	}
	
	
	
	public void run()
	{
		prepareGame();
		printMap(map);
		System.out.println("Oyun Basladi !");
		
		int satir , sutun;
		int sucsess = 0; // oyunu bitirmek için gereken doğru sayısı 
		
		while(game)
			
		{
			printMap(board);
			System.out.print("Satir:");
			satir = input.nextInt();
			System.out.print("Sutun:");
			sutun = input.nextInt();
			if(map[satir][sutun] != -1)
			{
				checkMayin(satir,sutun);
				sucsess++;
				if(sucsess == (size - (size/4)))
				{
						System.out.println("TEBRIKLER !!! HICBIR MAYINA BASMADINIZ :)");
						break;
				}
			}
			else
			{
				game = false;
				System.out.println("GAME OVER !!!!");
			}
			
		}
	}
	
	
	
	public void prepareGame()
	{
		int randomRow , randomCol , count = 0; // rastgele mayınlerin geleceği satır ve sütünlar için
		
		
		while(count != (size/4)) // mayın sayısı boyutun 4'de 1'i olana kadar
		{
			randomRow = rand.nextInt(rowNumber); // mayın koyulabilcek max kaçıncı satır
			randomCol = rand.nextInt(colNumber); // mayın koyulabilcek max kaçıncı sütun
			
			if(map[randomRow][randomCol]!= -1)
			{
				map[randomRow][randomCol] = -1;
				count++;
			}
		}
	}
	
	
	
	
	public void printMap(int [][] array)
	{
		for(int i = 0 ; i < array.length ; i++)
		{
			for( int j = 0 ; j < array[0].length ; j++)
			{
				if(array[i][j] >= 0)
				{
					System.out.print(" ");  // bu if güzel board'ın güzel gözükmesi için
				}
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	public void checkMayin(int r , int c)
	{
		
		
		if(board[r][c] == 0)
		{		
			if((c < colNumber - 1) && map[r][c+1] == -1)  	 // sağını solunu üstünü altını kontrol ettik mayın var mı diye varsa bir arttırdık
			board[r][c]++;    							 
		                       								 
			if((c > colNumber) && map[r][c-1] == -1)
			board[r][c]++;
		
			if((r < rowNumber - 1) && map[r+1][c] == -1) 	//köşeleri de kontrol etmemiz gerkiyor
			board[r][c]++;
		
			if((r > 0) && map[r-1][c] == -1)
			board[r][c]++;
			
			if(board[r][c] == 0)
				board[r][c] = -2;	//etrafında mayın yoksa -2 değerini verdik
		}
	}
	
}
