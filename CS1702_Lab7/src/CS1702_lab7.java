import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FilenameFilter;

public class CS1702_lab7 {
	
	static public void main(String args[]) throws IOException 
	
	{
		Strings();
		RoundingTest(10.2);
		SystemCommands();
		RandomNumGen();
		FileHandling();	
	}
	static public void Strings()
	
	{
		double number = 1.0/3.0;
		
		DecimalFormat number_format = new DecimalFormat("#.##");
		System.out.println(number);
		String formatted_string = number_format.format(number);
		System.out.println(formatted_string);
		
		double x = 123.456;
		double y = 17.0/3.0;
		double z = Math.sqrt(2);
		String a = "Hello", b = "World";
		
		System.out.println();
		System.out.println("7.3.1 - Y to 3dp");
		DecimalFormat YDP = new DecimalFormat("#.###"); //decimal format # after "." states how many dp. 3DP variable for this
		System.out.println(y);
		String Y_3DP = YDP.format(y);
		System.out.println(Y_3DP);
		
		System.out.println();
		System.out.println("7.3.2 - before and after DP");
		String text = Double.toString(Math.abs(x));
		int wholenumber = text.indexOf('.');
		int decimalpoints = text.length() - wholenumber - 1;
		
		System.out.println("Whole Numbers = " + wholenumber);
		System.out.println("decimal points = " + decimalpoints);

		System.out.println();
		System.out.println("7.3.3 - rev. a + b");
		String c;
		String rev_a = new StringBuffer(a).reverse().toString();
		c = rev_a + " " + b;
		System.out.println(c);
		
		System.out.println();
		System.out.println("7.3.4 - replace ll with ppp");
		
		String c_original = c;
		String c_ppp = c_original.replaceAll("ll", "ppp");
				
		System.out.println(c_original);
		System.out.println(c_ppp);
		
	}
	
	private static void RoundingTest(double x)
	{
		x = -11.11; 
		System.out.println("x = " + x);
		
		System.out.println("ceil");
		System.out.println(Math.ceil(x));
		
		System.out.println("floor");
		System.out.println(Math.floor(x));
		
		System.out.println("round");
		System.out.println(Math.round(x));
	}

	static public void SystemCommands()
	{
		System.out.println();
		System.out.println("7.5 - System Commands");
		File dir = new File("C:/Temp"); //looks in this directory
	      FilenameFilter filter = new FilenameFilter() {
	         public boolean accept (File dir, String title) { 
	            return title.startsWith("t"); //searches for any files beginning wiht t - test.txt
	         } 
	      }; 
	      String[] holder = dir.list(filter);
	      if (holder == null) {
	         System.out.println("Either dir does not exist or is not a directory"); 
	      } else { 
	         for (int i=0; i< holder.length; i++) { //continues searching 
	            String file_name = holder[i];
	            System.out.println(file_name); 
	         } 
	      } 
    }
	static public void RandomNumGen()
	{
		System.out.println();
		System.out.println("Random Number Generator");
		
		System.out.println();
		System.out.println("for -100 to 100");
		for(int i=0;i<10;++i)
		{
			int min = -100;
			int max = 100;
			System.out.println(min + (int)(Math.random() * ((max - min) + 1)));
		}
		
		/* System.out.println();
		System.out.println("for -100 to 100");
		for(int i=0;i<10;++i)
		{
			int min = a;
			int max = b;
			System.out.println(min + (int)(Math.random() * ((max - min) + 1)));
		}
		*/ // no idea how to do for string (a and b = "Hello" and "World") 
		
		System.out.println();
		System.out.println("for random doubles ");
		for(int i=0;i<10;++i)
		{
			System.out.println(Double.MIN_VALUE + (double)(Math.random() * ((Double.MAX_VALUE - Double.MIN_VALUE) + 1)));
		}
		
		System.out.println();
		System.out.println("for random doubles between 0 and 1");
		for(int i=0;i<10;++i)
		{
			Random generator = new Random();
			double number = generator.nextDouble() * 1;
			System.out.println(number);
		}
		
		// unknown for string a and b - however if it is meant that a and b are TO BE specified 
		/*
		if (b > a){
		 for(int i=0;i<10;++i)
		{
			System.out.println(a + (double)(Math.random() * ((b - a) + 1)));
		}
		else{
			System.out.println("b is not greater than a");
			}
		}
		*/
		
	}
	static public void FileHandling() throws IOException
	{
		System.out.println();
		System.out.println("7.1.1 - reading");
		File file = new File("C:/Temp/Billy Goats.txt");
		try(Scanner sc = new Scanner(new FileInputStream(file))){
		    int count=0;
		    while(sc.hasNext()){
		        sc.next();
		        count++;
		    }
		System.out.println("Number of words: " + count);
		}
		
		System.out.println();
		System.out.println("7.1.2 - writing");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Temp/Billy Goats.txt"))) {
            final String format = "%-10s %-10.1f %-10.2f %-10.3f %n";
            int n = 1;
			for(int i=1;i<=n ;i++){
                final double root = Math.sqrt(i);
                writer.write(String.format(format,i+":",root ,root,root));
            }
        }
		
		JARExample je = new JARExample();
		
	}


}


