package org.vm;

import java.util.*;
public class Assembler {


	public static ArrayList<Integer[]> getValues(String s){
		ArrayList<String[]> opCodes = new ArrayList<String[]>();
		String[] lines = s.split("\n");
		for(int i=0; i<lines.length; i++){
			String[] line = lines[i].split("\\s+");
			if(line.length > 1){
				String[] l = {line[0], line[1]};
				opCodes.add(l.clone());
			}
			else{
				String[] l = {line[0]};
				opCodes.add(l.clone());
			}
		}
		ArrayList<Integer[]> ls = new ArrayList<Integer[]>();
		for(String[] l : opCodes){
			Integer a[] = new Integer[2];
			if(l[0].equals("'")) continue;
			if(l.length>1){
				if(l[0].equalsIgnoreCase("LDA")) a[0] = 0;
				else if(l[0].equalsIgnoreCase("LDB")) a[0] = 1;
				else if(l[0].equalsIgnoreCase("LDO")) a[0] = 2;
				else if(l[0].equalsIgnoreCase("ADD")) a[0] = 3;
				else if(l[0].equalsIgnoreCase("SUB")) a[0] = 4;
				else if(l[0].equalsIgnoreCase("MUL")) a[0] = 5;
				else if(l[0].equalsIgnoreCase("DIV")) a[0] = 6;
				else if(l[0].equalsIgnoreCase("STA")) a[0] = 7;
				else if(l[0].equalsIgnoreCase("STB")) a[0] = 8;
				else if(l[0].equalsIgnoreCase("STR")) a[0] = 9;
				else if(l[0].equalsIgnoreCase("MOV")) a[0] = 11;
				else if(l[0].equalsIgnoreCase("LMA")) a[0] = 12;
				else if(l[0].equalsIgnoreCase("LMB")) a[0] = 13;
				else if(l[0].equalsIgnoreCase("LMO")) a[0] = 14;
				a[1] = Integer.parseInt(l[1]);
			}
			else{
				if(l[0].equalsIgnoreCase("FLO")){a[0] = 10; a[1] = null;}
			}
			ls.add(a);
		}
		return ls;
	}
}
