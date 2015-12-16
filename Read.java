
import java.io.*;
import java.util.*;

public class  Read{

public static void main(String[] args) throws IOException {


Scanner scanner = new Scanner(new File("dataset"));
int [] X = new int [100];
int [] Y =new int [100];
int i = 0,count=1;
double Xmean=0,Ymean=0;
	while(scanner.hasNextInt()){
	if(i%2==0)
		{
		X[count] = scanner.nextInt();
		Xmean=Xmean+X[count];
		//System.out.println(X[count]+":"+count);
		}
	else
		{
		Y[count] = scanner.nextInt();
		Ymean=Ymean+Y[count];
		//System.out.println(Y[count]+":"+count);
		count++;
		}
	i++;
	}
	count--;
	Xmean=Xmean/count;
	Ymean=Ymean/count;
	
	System.out.println(Xmean+":"+Ymean);
	}
}
