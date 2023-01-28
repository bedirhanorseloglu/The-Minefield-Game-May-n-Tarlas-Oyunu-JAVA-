import java.util.Scanner;

public class MayinTarlasiOyunuMain 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		int row,column;
		
		System.out.println("Mayin tarlasi oyununa hos geldiniz !");
		System.out.println("Lutfen oynamak istediginiz boyutlari giriniz !");
		System.out.print("Satir sayisi:");
		row = input.nextInt();
		System.out.print("Sutun sayisi:");
		column = input.nextInt();
		
		MayinTarlasiOyunu mayin = new MayinTarlasiOyunu(row,column);
		mayin.run();
		

	}

}
