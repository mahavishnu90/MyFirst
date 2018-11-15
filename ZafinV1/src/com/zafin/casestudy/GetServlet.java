package com.zafin.casestudy;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class GetServlet
 */
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /*    String inputList[];
       
       
    public String[] getInputList() {
		return inputList;
	}

	public void setInputList(String[] inputList) {
		this.inputList = inputList;
	}*/

	/**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubSystem.out.println("dsfssssdsfd");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	protected void doPost(HttpServletRequest request, HttpServletResponse httpResponse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("ssssssssse");     
		System.out.println("e213112");
		System.out.println("3132sdsa");
		System.out.println("2323423ddf ");
		String leftDiagList[];
		String rightDiagList[];
		String topElementsList[];
		StringBuilder diagonalElementsString = new StringBuilder(); 
		StringBuilder topElementsString= new StringBuilder(); 
		String newWordList[]={};
		
		String inputList[] = request.getParameterValues("inputList");
		
		
		try{
			
		/*Get the Dictionary Words to be loaded in List of String*/
		List<String> dictionaryWordsList = FileUtils.readLines(new File(request.getRealPath("\\My_Case_Study\\Dictionary\\Dictionary.txt")));
		
		/*START - GET MAX LENGTH AND TOTAL SIZE OF ELEMENTS - START*/
		int maxLength=0;
		int totSize=0;
		StringBuilder myText= new StringBuilder();
		for(int i=0; i<=inputList.length-1;i++)
		{
			
			
			for(int j=0; j<=inputList[i].length()-1;j++)
			{
				myText.append(inputList[i].toUpperCase().charAt(j)+",");
			}
			totSize=inputList.length;
			if(inputList[i].trim().length()>=maxLength) maxLength= inputList[i].trim().length();
		}
		/*END- GET MAX LENGTH AND TOTAL SIZE OF ELEMENTS - END */
		
		
		/*START - CONVERT THE ELEMENTS INTO 2D ARRAY - START  */
		String a[][]=new String[totSize][maxLength];
		String d[]=myText.toString().split(",");
	    
		 int count=0;

	        for(int i=0;i<totSize;i++)
	        {
	            for(int j=0;j<maxLength;j++)
	            {
	            if(count==d.length) break;
	            a[i][j]=d[count];
	            count++;
	            }
	        }
	        
	    	/*END - CONVERT THE ELEMENTS INTO 2D ARRAY - END  */   
	        
	        
	        /*START - GET LEFT DIAGONAL ELEMENTS - START  */
	        leftDiagList = new String[ totSize*2 ];    // Initialize the size of left String array
	        
	        for( int k = 0 ; k < totSize * 2 ; k++ ) {
		        for( int j = 0 ; j <= k ; j++ ) {
		     if( j < totSize ) {
		        	if(j==k) {
		        		diagonalElementsString.append( a[j][k]);
		        		   }
		        	}
		        }
		        leftDiagList[k]= diagonalElementsString.toString();
		    }
	        /*END - GET LEFT DIAGONAL ELEMENTS - END  */
	        
	        
	        /*START - GET RIGHT DIAGONAL ELEMENTS - START  */
	        
	        StringBuilder rightBuild = new StringBuilder(); 
	        rightDiagList = new String[ totSize*2 ];   // Initialize the size of right String array
	        
	        for( int k = 0 ; k < totSize * 2 ; k++ ) { 
	        	rightBuild.setLength(0);  			// Clear Stringbuilder
		        for( int j = 0 ; j <= k ; j++ ) {
		            int i = k - j;
		            if( i < totSize && j < totSize ) {
		                rightBuild.append(a[i][j]);
		            }
		        }
		        rightDiagList[k]=rightBuild.toString();
		    }
	        
	        /*END - GET RIGHT DIAGONAL ELEMENTS - END  */
	        
	        
	        /*START - GET TOP ELEMENTS - START  */
			
	        topElementsList = new String[ maxLength ];    // Initialize the size of top element String array
		        for( int k = 0 ; k < maxLength  ; k++ ) {
		        	topElementsString.setLength(0);
			        for( int j = 0 ; j <= totSize-1 ; j++ ) {
			        	topElementsString.append( a[j][k]);
			        }
			        topElementsList[k]= topElementsString.toString();
			    }
		        /*END - GET TOP ELEMENTS - END  */
		        
		        
	        
	        ArrayList<String> wordsList = new ArrayList<String>();   // to get the words List
	        
			for(String dictionaryWord:dictionaryWordsList)
			{
				for(int i=0; i<=inputList.length-1;i++)
				{
					/*Performs left to right word search*/
				if(dictionaryWord.length()>=2)if(inputList[i].contains(dictionaryWord.toUpperCase())==true) if(!(wordsList.contains(dictionaryWord.toUpperCase()))  ) wordsList.add(dictionaryWord.toUpperCase());
				   /*Performs right to left word search*/
				if(dictionaryWord.length()>=2)if(new StringBuilder(inputList[i]).reverse().toString().contains(dictionaryWord.toUpperCase())==true) if(!(wordsList.contains(dictionaryWord.toUpperCase()))  ) wordsList.add(dictionaryWord.toUpperCase());
				}
				
				for(int i=0; i<=rightDiagList.length-1;i++)
				{
						/*Performs left to right word search for diagonal elments*/
		        	  if(dictionaryWord.length()>=2)if(rightDiagList[i].contains(dictionaryWord.toUpperCase())==true) if(!(wordsList.contains(dictionaryWord.toUpperCase())) ) wordsList.add(dictionaryWord.toUpperCase());
		        	   /*Performs right to left word search for diagonal elments*/
		        	  if(dictionaryWord.length()>=2)if(new StringBuilder(rightDiagList[i]).reverse().toString().contains(dictionaryWord.toUpperCase())==true) if(!(wordsList.contains(dictionaryWord.toUpperCase())) ) wordsList.add(dictionaryWord.toUpperCase());
						
				}
			        
				for(int i=0; i<=leftDiagList.length-1;i++)
				{
					   /*Performs left to right word search for reverse diagonal elments*/
		        	  if(dictionaryWord.length()>=2)if(leftDiagList[i].contains(dictionaryWord.toUpperCase())==true) if(!(wordsList.contains(dictionaryWord.toUpperCase())) ) wordsList.add(dictionaryWord.toUpperCase());
		        	  /*Performs right to left word search for reverse diagonal elments*/
		        	  if(dictionaryWord.length()>=2)if(new StringBuilder(leftDiagList[i]).reverse().toString().contains(dictionaryWord.toUpperCase())==true) if(!(wordsList.contains(dictionaryWord.toUpperCase())) ) wordsList.add(dictionaryWord.toUpperCase());
				}
				
				for(int i=0; i<=topElementsList.length-1;i++)
				{
					   /*Performs left to right word search for Top elments*/
		        	  if(dictionaryWord.length()>=2)if(topElementsList[i].contains(dictionaryWord.toUpperCase())==true){
		        		  if(!(wordsList.contains(dictionaryWord.toUpperCase())) ) wordsList.add(dictionaryWord.toUpperCase());
		        	  }
		        	  /*Performs right to left word search for Top elments*/
		        	  if(dictionaryWord.length()>=2)if(new StringBuilder(topElementsList[i]).reverse().toString().contains(dictionaryWord.toUpperCase())==true) if(!(wordsList.contains(dictionaryWord.toUpperCase())) ){
		        		  wordsList.add(dictionaryWord.toUpperCase());
		        	  }
				}
				
				 
			}
			
			newWordList = wordsList.toArray(new String[0]);   
			
		StringBuilder sa = new StringBuilder();
		
			
//			Write into a Notepad File
		httpResponse.setContentType("text/plain");
		httpResponse.setHeader("Content-Disposition", "attachment;filename=words.txt");
        
	
		for(int i=0; i<=newWordList.length-1;i++)
		{
			sa.append(newWordList[i] + "\r\n");
		} 
		InputStream input = new ByteArrayInputStream(sa.toString().getBytes("UTF8"));
        int read = 0;
        byte[] bytes = new byte[1024];
        OutputStream os = httpResponse.getOutputStream();

        while ((read = input.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }
        os.flush();
        os.close();
		
	}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
