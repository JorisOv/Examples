package opdracht3;

import java.io.*;

public class DataReader
{
	public static StringBuffer readFile(String file)
	{
		try
		{
			BufferedReader reader = new
				BufferedReader(new FileReader(file));

			// used for temporary storage of a line
			String stringRead = new String();
			// used for saving all the readed lines
			StringBuffer fileContent = new StringBuffer();

			// read all lines
			while(stringRead != null)
			{
				stringRead = reader.readLine();
				// put the readed line in the StringBuffer
				fileContent.append(stringRead);
			}
			// remove the null at the end of the StringBuffer
			int fileLength = fileContent.length();
			fileContent.delete(fileLength - 4, fileLength);

			return fileContent;
		}
		catch (FileNotFoundException fnfe)
		{
			System.out.println("File '" + file + "' not found.");
		}
		catch (IOException ioe)
		{
			System.out.println("An I/O error occured when trying to read file '" +
				file +"'.");
		}
		// after an exception return null
		return null;
	}

 /*	public static void main(String[] args)
	{
		// for testing purposes
		DataReader dr = new DataReader();
		StringBuffer br = dr.readFile("opdracht2/data/hanim_skull.m4");
		System.out.print(br);

	}*/
}