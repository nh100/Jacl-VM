JaclVM v0.1
(C) 2013 Lord Voldemort Tyrannus

To use simply run the jar with java -jar jacl.jar input_file with input_file replaced by the bytecode file.

OPCODES 
  LDA
  LDB
  LDO
  ADD
  SUB
  MUL
  DIV
  STA
  STB
  STR
  MOV
  LMA
  LMB
  LMO
  JMP // under testing, doesn't work correctly.
  CIN // under testing
  
  The VM has 5KB of memory, and the only output so far is the console.
  
  TODO:
    *Fix JMP and CIN opcodes
    *Add labels
    
  Current problem with JMP opcode probably has to do with the pc. VM should change pc to
  JMP argument, however ends up in an infinite loop.
  
  CIN works correctly except in the case of multiple characters.
