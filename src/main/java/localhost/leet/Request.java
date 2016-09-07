package localhost.leet;

import java.io.*;
import java.net.*;

public class Request {
	
	
//	@author Michael Donnelly
//	@date 2016-9-7
	
//	The URL
	
	protected static String endpoint = "http://localhost:1337/employee";
	
//	The character set
	
	protected static String charset = "UTF-8";
	

	

	public static void main(String[] args) {
	try{	
		
//		All of our variables to add to the query

		String firstName = "Stevie";
		String lastName = "Nicks";
		String email = "who.isthis@ironyard.com";
		String phone1 = "410-555-5595";
		String phone2 = "443-555-5595";
		String password = "p4ssWord";
		String active = "1";
		

//		adding them in
		
		String queryString = String.format("firstName=%s&lastName=%s&email=%s&phone1=%s&phone2=%s&password=%s&active=%s", 
				URLEncoder.encode(firstName, charset),
				URLEncoder.encode(lastName, charset),
				URLEncoder.encode(email, charset),
				URLEncoder.encode(phone1, charset),
				URLEncoder.encode(phone2, charset),
				URLEncoder.encode(password, charset),
				URLEncoder.encode(active, charset)
				
				);
		
//		combining url and query
		
		URL googleDirections = new URL(endpoint + "?" + queryString);
		HttpURLConnection connection = (HttpURLConnection) googleDirections.openConnection();
				connection.setRequestMethod("POST");
		
		if (connection.getResponseCode() != 201){
			throw new RuntimeException("Failed: Http error code: " + connection.getResponseCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		
		while (br.readLine() != null) {
			System.out.println(br.readLine());
		}
		
		connection.disconnect();
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		

	}

}
