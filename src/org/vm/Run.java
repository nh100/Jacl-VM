package org.vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Run {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Machine m = new Machine();
		Scanner in = null;
		try{
			in = new Scanner(new File(args[0]));
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.err.println("No input file found");
			System.exit(0);
		}
		String ins = "";
		while(in.hasNextLine()){
			ins += in.nextLine() + "\n";
	}
			
		for(Integer[] l : Assembler.getValues(ins))
			if(l[0] != null)
				m.execOp(l[0], l[1]);}
}
