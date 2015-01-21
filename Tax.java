package SalesTaxes;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tax {
	
	public Tax(){}
	  

	  
	  public HashSet<String> freeTax() throws IOException{ // make up list which consists food, book,medical product. this  are exempt tax
		  
		  HashSet<String> list = new HashSet<String>();
		  
		 
		  File file = new File("freeList");
	      BufferedReader reader = null;
	      reader = new BufferedReader(new FileReader(file));
	      String word = reader.readLine();

	          while (word!=null) {   //adding word from freelist to list
	        	  list .add(word);  
	          //	System.out.println(word);
	          	
	          	word = reader.readLine();
	          }
		  reader.close();
	      return list;
	
	            
	  }
	  
	   
	  public ArrayList<String> getInput(){ 
		  int count=0;
	  	
		  ArrayList<String> inputlist = new ArrayList<String>();   // list of buyed product
		  
	  	
	  	   Scanner write= new Scanner(System.in);   //**getting product
	        
	    	  while(write.hasNextLine()){
	    		  String s=write.nextLine();
	              inputlist.add(s);
	              
	              
	              
	     if (s.equals("")) //if push enter twice break
	        	++count;
	          if(count==1)
	        	break;
	    	  }
	           return inputlist;                           
	    
	}
	    public void isTax(ArrayList<String> inputlist, HashSet<String> list){
	    	 
	    	 double totalTax;
	    	 double totalPay;
	    	 double goodsPrice;
	    	 
	    	 Iterator<String> itr = inputlist.iterator();
	         while (itr.hasNext()) {
	            // System.out.println(itr.next());
	             
	       	  String sentence=itr.next(); 
	   	 

	    Scanner read = new Scanner(sentence);
	           
	    String []inputStr = inputlist.split(" at ");
	    String goodsName = inputStr[0];

	     
	     while(read.hasNext()){
	         
	    	
	    	 
	         String kelime = read.next();
	          if(kelime=="imported")
	             { //tax rate is %5
	        	  
	               goodsPrice = Double.parseDouble(inputStr[1]);
	                 totalTax=+goodsPrice*0.05;    //total tax
	                 goodsPrice=+ goodsPrice*0.05;   //tax+price
	                 totalPay=+goodsPrice;
	                 
	                 System.out.println(goodsName + ":" +goodsPrice);
	              
	              }
	          else
	       	   if(list.contains(kelime))
	       	   {
	       		  //do not add tax
	       		totalPay=+goodsPrice;
	            System.out.println(goodsName + ":" +goodsPrice);
	       	   }
	       	   
	       	   else
	       	   {
	       		   // tax rate is %10 
	       		 goodsPrice = Double.parseDouble(inputStr[1]);
	            totalTax=+goodsPrice*0.1;    //total tax
	            goodsPrice=+ goodsPrice*0.1;   //tax+price
	            totalPay=+goodsPrice;
	            
	            System.out.println(goodsName + ":" +goodsPrice);
	       		   
	       	   }
	            //read.hasNext("at");
	         System.out.println("kelime = " + kelime);
	     }
	     System.out.println("total taxes:" + totalTax);   
	     System.out.println("total: " + totalPay);
	   	
	   }
	         
	     }  

}
