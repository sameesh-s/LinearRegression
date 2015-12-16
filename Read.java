import java.io.*;
import java.util.*;

public class  Read{

public static void main(String[] args) throws IOException {


Scanner scanner = new Scanner(new File("dat.txt"));
int [] tall = new int [100];
int i = 0;
while(scanner.hasNextInt()){
   tall[i++] = scanner.nextInt();
   System.out.println(tall[i-1]);
	}
	}
}
