# Assembler
 STEPS OF PHASE1 <br />
 1.Reading file and adding code into array list line by line <br />
 2.Initializing Directive Map and Instruction Map And Fill it <br />
 3.Validating END statement (Absence of End , Validating Label of End) <br /> <br />
 4.Separate Lines into it's 4 Outputs And Filling Symbol Table (Validating Duplicate Label Error) <br />
 5.Validating If This Line is a Comment <br />
 6.Validating Start ( Operand Hexadecimal , Absence Of Label , Absence OF Start -> Program Counter=0) <br />
 7.Adding Label To Symbol List <br />
 8.Check If Mnemonic Is Valid (Syntax,Number of Operands,Format)(unrecognized operation code,missing or misplaced operandfield) <br />
 9.Check Mnemonic Is Directive Or Instruction <br />
 10.IF Mnemonic Is Instruction THEN Validate It's Operand ( illegal address for register,illegal address for memory,undefined symbol in operand)<br />
 11.Get Displacement To Update Program Counter And Validate Operand If Mnemonic Is Directive <br />
 12.Update Program Counter <br />
 13.Loop Whole Code <br />
 14.Print In File<br />

