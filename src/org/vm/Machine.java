package org.vm;

public class Machine {
	public final int MEMORY_SIZE = 0x1388;
	
	byte[] memory;
	// A,B are general purpose. In R the results of operations are stored. Out is standard output register.
	byte regA, regB, regR, regOut;
	
	public Machine(){
		memory = new byte[MEMORY_SIZE];
	}
	
	
	public void execOp(Object op, Object arg){
		byte barg = 0;
		int iarg = 0;
		if(arg != null){
			if((int) arg < 128)
				barg = (Byte.parseByte(arg.toString()));
			else iarg = (int) arg;
		}
		switch(Byte.parseByte(op.toString())){
		case 0:
			loadA((byte)barg); break;
		case 1:
			loadB((byte)barg); break;
		case 2:
			loadOut((byte)barg); break;
		case 3:
			add((byte)barg); break;
		case 4:
			sub((byte)barg); break;
		case 5:
			mult((byte)barg); break;
		case 6:
			div((byte)barg); break;
		case 7:
			storeA(iarg); break;
		case 8:
			storeB(iarg); break;
		case 9:
			storeR(iarg); break;
		case 10:
			flushOut(); break;
		case 11:
			move(barg); break;
		case 12:
			loadMemA(iarg); break;
		case 13:
			loadMemB(iarg); break;
		case 14:
			loadMemOut(iarg); break;
			
		}
	}
	
	public void execOp(byte op){
		
	}
	/* Follwing defines bytecode methods */
	
	/**
	 * lda lit, 00
	 * @param target
	 */
	private void loadA(byte target){
		regA = target;
	}
	
	/**
	 * ldb lit, 01
	 * @param target
	 */
	private void loadB(byte target){
		regB = target;
	}
	

	/**
	 * ldo reg, 02
	 * @param target
	 */
	private void loadOut(byte reg){
		if(reg == 0) regOut = regA;
		else if(reg == 1) regOut = regB;
		else if(reg == 2) regOut = regR;
	}

	/**
	 * add reg, 03
	 * @param reg
	 */
	private void add(byte reg){
		switch(reg){
		case 0:
			regR = (byte) (regA + regB); break;
		case 1:
			regR = (byte) (regA + regR); break;
		case 2:
			regR = (byte) (regB + regR); break;
		}
	}
	
	/**
	 * div reg, 04
	 * @param reg
	 */
	public void sub(byte reg){
		switch(reg){
		case 0:
			regR = (byte) (regA - regB); break;
		case 1:
			regR = (byte) (regA - regR); break;
		case 2:
			regR = (byte) (regB - regR); break;
		}
	}
	
	/**
	 * mul reg, 05
	 * @param reg
	 */
	public void mult(byte reg){
		switch(reg){
		case 0:
			regR = (byte) (regA * regB); break;
		case 1:
			regR = (byte) (regA * regR); break;
		case 2:
			regR = (byte) (regB * regR); break;
		}
	}
	
	/**
	 * div reg, 06
	 * @param reg
	 */
	public void div(byte reg){
		switch(reg){
		case 0:
			regR = (byte) (regA / regB); break;
		case 1:
			regR = (byte) (regA / regR); break;
		case 2:
			regR = (byte) (regB / regR); break;
		}
	}
	
	/**
	 * sta addr, 07
	 * @param addr
	 */
	public void storeA(int addr){
		memory[addr] = regA;
	}
	
	/**
	 * stb addr, 08
	 * @param addr
	 */
	public void storeB(int addr){
		memory[addr] = regB;
	}

	/**
	 * str addr, 09
	 * @param addr
	 */
	public void storeR(int addr){
		memory[addr] = regR;
	}
	
	/**
	 * Sends ascii value of register out to stdout
	 * flo, 10
	 */
	public void flushOut(){
		System.out.print((char)regOut);
	}

	/**
	 * mov arg, 11
	 * @param arg
	 */
	public void move(byte arg){
		switch(arg){
		case 0: regA = regB; break;
		case 1: regB = regA; break;
		case 2: regA = regR; break;
		case 3: regB = regR; break;
		}
	}


	/**
	 * lma addr, 12
	 * @param addr
	 */
	public void loadMemA(int addr){
		regA = memory[addr];
	}
	
	/**
	 * lmb addr, 13
	 * @param addr
	 */
	public void loadMemB(int addr){
		regB = memory[addr];
	}
	
	/**
	 * lmo addr, 14
	 */
	public void loadMemOut(int addr){
		regOut = memory[addr];
	}
	
}
