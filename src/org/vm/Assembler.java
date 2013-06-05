/*
 Assembler.java Assembler for bytecode
    Copyright (C) 2013  Lord Voldemort Tyrannus

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

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
				else if(l[0].equalsIgnoreCase("JMP")) a[0] = 16;
				else if(l[0].equalsIgnoreCase("CIN")) a[0] = 17;
				a[1] = Integer.parseInt(l[1]);
			}
			else{
				if(l[0].equalsIgnoreCase("FLO")){a[0] = 10; a[1] = null;}
				else if(l[0].equalsIgnoreCase("CMP")){a[0] = 15; a[1] = null;}
			}
			ls.add(a);
		}
		return ls;
	}
}
