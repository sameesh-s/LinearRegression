import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
class LinearRegression {
	double slope,A;
	LinearRegression()  throws IOException
		{
		Scanner scanner = new Scanner(new File("dataset"));
		int [] X = new int [100];
		int [] Y =new int [100];
		int i = 0,count=0;
		double Xsum=0,Ysum=0,X2sum=0,XYsum=0;
		while(scanner.hasNextInt()){
		if(i%2==0)
			{
			X[count] = scanner.nextInt();
			Xsum=Xsum+X[count];
			X2sum=X2sum+Math.pow((X[count]),2);  
			}
		else
			{
			Y[count] = scanner.nextInt();
			Ysum=Ysum+Y[count];
			XYsum=XYsum+(X[count]*Y[count]);
			count++;
			}
		i++;
		}
	slope= ( (count * XYsum) - ( Xsum * Ysum ) ) / ( ( count * X2sum ) - Math.pow(Xsum,2) ) ;
	A= ( Ysum - (slope * Xsum ) ) / count;
		}
	public String returnPrice(String s)
		{double price,x;
		x = Double.parseDouble(s);
		price = (slope * x ) + A;
		return String.valueOf(price);
		}
	}

public class Sample {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public Sample(){
		prepareGUI();
		}
	public static void main(String[] args)  throws IOException{
		Sample  Sample = new Sample(); 
		LinearRegression lr= new LinearRegression();     
        	Sample.showButtonDemo(lr);
		}
	private void prepareGUI(){
		mainFrame = new JFrame("Linear Regression");
		mainFrame.setSize(400,400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent windowEvent){
		System.exit(0);
		}        
		});    
	headerLabel = new JLabel("", JLabel.CENTER);        
	statusLabel = new JLabel("",JLabel.CENTER);    
	statusLabel.setSize(350,100);
	controlPanel = new JPanel();
      
	controlPanel.setLayout(new FlowLayout());
	mainFrame.add(headerLabel);
	mainFrame.add(controlPanel);
	mainFrame.add(statusLabel);
	mainFrame.setVisible(true);  
	}
    
private void showButtonDemo(LinearRegression lr){
	headerLabel.setText("Prediction"); 
        JTextField userText = new JTextField(6);
	userText.setText("sqfeet");
        JTextField userText2 = new JTextField(6);
        JButton cancelButton = new JButton("Predict Price");
        cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);   

        cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
		userText2.setText(lr.returnPrice(userText.getText()));
        	}
                });
      controlPanel.add(userText); 
      controlPanel.add(cancelButton);
      controlPanel.add(userText2); 
      mainFrame.setVisible(true);  
	}
}
