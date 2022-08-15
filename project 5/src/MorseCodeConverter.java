import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class is used to convert morsecode to English
 * @author Joshua Lucas
 *
 */

public class MorseCodeConverter {
	
	private static  MorseCodeTree convert = new  MorseCodeTree();
	
	public MorseCodeConverter()
	{}

	/**
	 * Turns a sting in morsecode to English
	 * @param code the code being converted
	 * @return the English translation of the code
	 */
	public static String convertToEnglish(String code)
	{
		String send = "";
		String complete = "";
		
		for (int i = 0; i < code.length(); i++)
		{
			
			
			if (code.charAt(i) == '.' || code.charAt(i) == '-')
				send += code.charAt(i);
			
			else if (code.charAt(i) == ' ' && i+1 != code.length())
			{
				if (code.charAt(i+1) != '/')
				{
				complete += convert.fetch(send);
				send = "";
				}
				
				else 
				{
					complete += convert.fetch(send) + " ";
					send = "";
					i++;
					i++;
				}
			}
			
			if (i+1 == code.length())
			{
				complete += convert.fetch(send);
			}
			
		}
		
		return complete;
	}
	
	/**
	 * 
	 * @param code1 the file containing morsecode
	 * @return a string of the English translation of the morsecode found in the file
	 */
	
	public static String convertToEnglish(File code1)
	{
		String code = null;
		String line;
		
		
		try {
		FileReader fileReader = 
                new FileReader(code1);
		
		BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
		
	
			while((line = bufferedReader.readLine()) != null)
			{
				code += line;
			}
			
			fileReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("pass");
		String send = "";
		String complete = "";
		
		for (int i = 0; i < code.length(); i++)
		{
			
			
			if (code.charAt(i) == '.' || code.charAt(i) == '-')
				send += code.charAt(i);
			
			else if (code.charAt(i) == ' ' && i+1 != code.length())
			{
				if (code.charAt(i+1) != '/')
				{
				complete += convert.fetch(send);
				send = "";
				}
				
				else 
				{
					complete += convert.fetch(send) + " ";
					send = "";
					i++;
					i++;
				}
			}
			
			if (i+1 == code.length())
			{
				complete += convert.fetch(send);
			}
			
		}
		
		return complete;
	}
	
	/**
	 * return a string of all elements in the morsecode tree in LNR order
	 * @return a string of all elements in the morsecode tree in LNR order
	 */
	
	public static String printTree()
	{
		String send = "";
		
		for (int i = 0; i < convert.toArrayList().size(); i++)
			send += convert.toArrayList().get(i);
		
		return send;
		
	}
	
}
