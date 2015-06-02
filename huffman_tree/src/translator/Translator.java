package translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;

public class Translator 
{
	//Method converts a string containing a continuous stream of 0's and 1's into its corresponding English text.
	public static StringBuilder StringDecoder(String stream, HuffmanTree<Character> newTree)
	{
		StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(stream);
		while(scan.hasNextLine())
		{
			sb.append(newTree.decode(scan.nextLine()));
		}
		return sb;
	}
	
	//Method converts a string of English text to its corresponding 0 and 1 value.
	public static StringBuilder StringEncoder(String stream, HashMap<Character, String> newMap)
	{
		StringBuilder sb = new StringBuilder();
		char[] array = stream.toCharArray();
		for(int i = 0; i<array.length; i++)
		{
			sb.append(newMap.get(array[i]));
		}
		
		return sb;
	}
	
	//Method converts a file containing a continuous stream of 0's and 1's into its corresponding English text.
	public static StringBuilder FileDecoder(File newFile, HuffmanTree<Character> newTree) throws FileNotFoundException
	{
		StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(newFile);
		while(scan.hasNextLine())
		{
			sb.append(newTree.decode(scan.nextLine()));
		}
		
		return sb;
	}
	
	//Method creates an input stream from a file containing English text and converts it into its corresponding 0 and 1 values.
	public static StringBuilder FileEncoder(File newFile, HashMap<Character, String> newMap) throws IOException
	{
		int index;
		StringBuilder sb = new StringBuilder();
		
		InputStream in = new FileInputStream(newFile);
		Reader reader = new InputStreamReader(in);
		Reader buffer = new BufferedReader(reader);

		while((index = buffer.read()) != -1)
		{
			char ch = (char) index;
			sb.append(newMap.get(ch));
		}
		return sb;		
	}	
}
