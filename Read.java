import java.io.*;
import java.util.*;

public class  Read{



public static void main(String[] args) throws IOException {


Scanner scanner = new Scanner(new File("dataset"));
int [] X = new int [100];
int [] Y =new int [100];
int i = 0,count=0;
double slope,inter;
double Xmean=0,Ymean=0,Xsum=0,Ysum=0,X2sum=0,Y2sum=0,SYdev=0,SXdev=0,XYsum=0,r,temp1;
	while(scanner.hasNextInt()){
	if(i%2==0)
		{
		X[count] = scanner.nextInt();
		Xsum=Xsum+X[count];
		X2sum=X2sum+Math.pow((X[count]),2);  
		//System.out.println(X[count]+":"+count);
		}
	else
		{
		Y[count] = scanner.nextInt();
		Ysum=Ysum+Y[count];
		Y2sum=Y2sum+Math.pow((X[count]),2);
		XYsum=XYsum+(X[count]*Y[count]);
		//System.out.println(Y[count]+":"+count);
		count++;
		}
	i++;
	}
	Xmean=Xsum/count;
	Ymean=Ysum/count;
	
	System.out.println(Xmean+":"+Ymean);

//Standerd deviation
	i=0;
	while(i<count)
		{ 
		SXdev=SXdev+Math.pow((X[i]-Xmean),2);  
		SYdev=SYdev+Math.pow((Y[i]-Ymean),2);
		i++;
		}
	SXdev/=count; 	//SXdev=SXdev/count;  
	SXdev=Math.sqrt(SXdev); 
	SYdev/=count;  
	SYdev=Math.sqrt(SYdev); 
	System.out.println(SXdev+":"+SYdev);
//regression coefficient
	//System.out.println(Math.pow(Xsum,2));
	//System.out.println(( count * X2sum));
	r =(count * XYsum) - (Xsum * Ysum );
	temp1 =( count * X2sum ) - Math.pow(Xsum,2) ;
	//System.out.println("regression coefficient :"+temp1);
	temp1 *=( count * Y2sum ) - Math.pow(Ysum,2);
	//System.out.println("regression coefficient :"+temp1);
	temp1 =Math.sqrt(temp1);
	r/=temp1;
	System.out.println("regression coefficient :"+r);
//calculating slope,inter
	slope=r * (SYdev / SXdev);
	inter=Ymean-(slope*Xmean);
	System.out.println("slope :"+slope+" intersection "+inter);

	}
}
