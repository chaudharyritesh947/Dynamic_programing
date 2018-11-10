import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws Exception
	 {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int T = Integer.parseInt(br.readLine());
	  while(T-->0)
	  {
	     int m = Integer.parseInt(br.readLine());
	     String s = br.readLine();
	     
	     int n = s.length();
	     
	     int t = 0;
	         
	     int fz = 0;
	     int lz =0;
	     
	     int z=0;
	     
	     while(z < n && s.charAt(z)=='0')
	      z++;
	      
	     fz = z;
	     
	     if(fz == n-1)
	      lz = 0;
	      
	     else
	      {
	          z=n-1;
	          while(z >= 0 && s.charAt(z)=='0')
	           {
	               z--;
	               lz++;
	           }        
	      }
	      
	       int max = Integer.MIN_VALUE;
	     for(int i=0 ; i<s.length() ; i++)
	      {
	         
	          if(s.charAt(i)=='0')
	          {
	              int j=i;
	              while(j < n && s.charAt(j)=='0')
	               j++;
	               
	              max = Math.max(max,j-i);
	              
	              i=j-1;
	          }
	      }
	//    System.out.println("fz: "+fz +" lz: "+lz +" max: "+max);
	  
	    if(max == s.length())
	     System.out.println(m*max);
	    else if(lz != 0 && fz!= 0)
	     System.out.println(Math.max(max,lz+fz));
	    else
	      System.out.println(max);
	     
	       
	 }//end of while(testcase)
  } 
}