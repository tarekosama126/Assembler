# Assembler
 STEPS OF PHASE1 \n
 1.Reading file and adding code into array list line by line
 2.Initializing Directive Map and Instruction Map And Fill it 
 3.Validating END statement (Absence of End , Validating Label of End) 
 4.Separate Lines into it's 4 Outputs And Filling Symbol Table (Validating Duplicate Label Error)
 5.Validating If This Line is a Comment 
 6.Validating Start ( Operand Hexadecimal , Absence Of Label , Absence OF Start -> Program Counter=0) 
 7.Adding Label To Symbol List 
 8.Check If Mnemonic Is Valid (Syntax,Number of Operands,Format)(unrecognized operation code,missing or misplaced operandfield) 
 9.Check Mnemonic Is Directive Or Instruction 
 10.IF Mnemonic Is Instruction THEN Validate It's Operand ( illegal address for register,illegal address for memory,undefined symbol in operand)
 11.Get Displacement To Update Program Counter And Validate Operand If Mnemonic Is Directive 
 12.Update Program Counter 
 13.Loop Whole Code 
 14.Print In File
[readme.txt](https://github.com/tarekosama126/Assembler/files/7977098/readme.txt)
