package application;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import translator.HuffmanTree;
import translator.Translator;

public class Main 
{
	public static void main (String [] args) throws IOException
	{
		//Create the HashMap and Huffman Tree.
		HashMap<Character, String> theMap = new HashMap<Character, String>();
		HuffmanTree<Character> theTree = new HuffmanTree<Character>();
		
		//Fill the HashMap with the char(s) as keys in the <Key, Value> pair 
		//and with the corresponding value as strings of 0's and 1's.
		theMap.put('a', "1010");
		theMap.put('b', "100000");
		theMap.put('c', "00000");
		theMap.put('d', "10110");
		theMap.put('e', "010");
		theMap.put('f', "110011");
		theMap.put('g', "100010");
		theMap.put('h', "0001");
		theMap.put('i', "0110");
		theMap.put('j', "1100001011");
		theMap.put('k', "11000011");
		theMap.put('l', "10111");
		theMap.put('m', "110010");
		theMap.put('n', "0111");
		theMap.put('o', "1001");
		theMap.put('p', "100001");
		theMap.put('q', "1100001001");
		theMap.put('r', "0010");
		theMap.put('s', "0011");
		theMap.put('t', "1101");
		theMap.put('u', "00001");
		theMap.put('v', "1100000");
		theMap.put('w', "110001");
		theMap.put('x', "1100001000");
		theMap.put('y', "100011");
		theMap.put('z', "1100001010");
		theMap.put(' ', "111");
		
		//Convert the HaspMap to a Set in order to traverse them consecutively.
		//Build tree
		Set<Character> keySet = theMap.keySet();
		for(Character c : keySet)
		{
			theTree.add(c, theMap.get(c));
		}
		
		//Visual Representation of tree
		System.out.println("A visual representation of the Huffman Tree." +"\n");
		System.out.println(theTree);
		System.out.println("****************************");
		System.out.println("****************************");
		System.out.println();
		
		//Encode and Decode a string showing the conversions produce the original string
		System.out.println("Original String = hello world"+"\n"+"Encode text and print");
		String encodedText = Translator.StringEncoder("hello world", theMap).toString();
		System.out.println(encodedText);
		
		System.out.println("Decoded encoded text"+"\n"+"print (expected Original String)");
		String decodedText = Translator.StringDecoder(encodedText, theTree).toString();
		System.out.println(decodedText);
		
		System.out.println();
		System.out.println("****************************");
		System.out.println("****************************");
		System.out.println();
		
		//Encode and Decode a string then append erroneous data to show the conversions produce a different string
		System.out.println("Original String = hello world"+"\n"+"Encode text and print");
		encodedText = Translator.StringEncoder("hello world", theMap).toString();
		System.out.println(encodedText);				
		System.out.println("Append erroneous data.");
		
		encodedText = encodedText + "010";
				
		
		decodedText = Translator.StringDecoder(encodedText, theTree).toString();
		System.out.println(decodedText);
				
		System.out.println();
		System.out.println("****************************");
		System.out.println("****************************");
		System.out.println();
		
		//Encode a string containing a stream of 0's and 1's 
		//Replace all 0's with 1's and decode string.
		
		System.out.println("Original String = hello world"+"\n"+"Encode text and print");
		encodedText = Translator.StringEncoder("hello world", theMap).toString();
		System.out.println(encodedText);				
		System.out.println("Insert new characters");
		
		encodedText = encodedText.replace('1', '0');				
		
		decodedText = Translator.StringDecoder(encodedText, theTree).toString();
		System.out.println(decodedText);
				
		System.out.println();
		System.out.println("****************************");
		System.out.println("****************************");
		System.out.println();
		
		
		//Convert a file containing a stream of 0's and 1's to its corresponding English text.
		System.out.println("Decode a binary document." + "\n");
		File code = new File("code.txt");
		System.out.println(Translator.FileDecoder(code, theTree));
		System.out.println("****************************");
		
		//Convert a file containing English text to its corresponding 0 and 1 values.
		System.out.println("Encode an English document." + "\n");
		File text = new File("text.txt");
		System.out.println(Translator.FileEncoder(text, theMap));
	}
}
