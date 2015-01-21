package SalesTaxes;

import java.io.IOException;

import SalesTaxes.Tax;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Tax fs=new Tax();
    	try {
			fs.freeTax();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	fs.getInput();
       
    }
}
