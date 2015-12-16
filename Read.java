import java.io.*;
import java.util.*;

public class  Read{

public static void main(String[] args) throws IOException {


Scanner scanner = new Scanner(new File("dat.txt"));
int [] X = new int [100];
int [] Y =new int [100];
int i = 0,count=1;
	while(scanner.hasNextInt()){
	if(i%2==0)
		{
		X[count] = scanner.nextInt();
		System.out.println(X[count]+":"+count);
		}
	else
		{
		Y[count++] = scanner.nextInt();
		System.out.println(Y[count]+":"+count);
		}
	i++;
	}
	}
}
