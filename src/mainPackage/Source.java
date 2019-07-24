package mainPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Source {
	public static Map<String,Integer> literalsIndex = new HashMap<String,Integer>();
	public static Map<Integer, String> Errortable = new HashMap<Integer, String>();
	public static boolean StartHaveLabel = false;
	public static String LabelOfStart = "";
	public static boolean OrgStatamentOccur = false;
	public static Map<String, Integer> forwardreference = new HashMap<String, Integer>();
	public static ArrayList<String> Literals = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		String AddressingMode = "Simple"; // PASS 2
		ArrayList<ArrayList<String>> ArrayOfFourOutputs = new ArrayList<ArrayList<String>>(); // PASS 2
		ArrayList<String> ObjectCodeList = new ArrayList<String>(); // PASS 2
		ArrayList<String> MyArrayList = new ArrayList<String>();
		ArrayList<String> FourOutputs = new ArrayList<String>();
		ArrayList<String> ProgramList = new ArrayList<String>();
		Map<String, Integer> Myinstructions = new HashMap<String, Integer>();
		Map<String, Integer> MyDirectives = new HashMap<String, Integer>();
		Map<String, Integer> Mysymboltable = new HashMap<String, Integer>();
		Map<String, String> MyRegisters = new HashMap<String, String>();
		Map<String, String> MyOpcodes = new HashMap<String, String>();
		Functions Myfunctions = new Functions();
		int PC = 0;
		int PCDisplacement = 0;
//_______________________________________Variables^________________________________________________//
		Myfunctions.FileReader("src.txt", MyArrayList);
//_______________________________________Adding lines of code to the Array list ^____________________//
		Myfunctions.InitializeMaps(Myinstructions, MyDirectives, MyRegisters, MyOpcodes);
//________Adding instructions and directives to maps^^__________//
		for (int i = 0; i < MyArrayList.size(); i++) {
			FourOutputs = new ArrayList<String>();///////////////////// NEW LINEEEE FOR PASS 2
													///////////////////// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			if (i == MyArrayList.size() - 1 || MyArrayList.get(i).contains("END")) {
				Myfunctions.CheckEndValidity(MyArrayList.get(i).toLowerCase(), i);
				ProgramList.add(Integer.toHexString(PC));
				FourOutputs.add("");
				FourOutputs.add("END");
				ArrayOfFourOutputs.add(FourOutputs);
				break;
			}
//______________________________________END validity^________________________________________________//			
			Myfunctions.GetOutputs(FourOutputs, MyArrayList.get(i), i, Mysymboltable, Myinstructions);
			ArrayOfFourOutputs.add(FourOutputs);///////////////////// NEW LINEEEE FOR PASS 2
												///////////////////// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//________________Seprating Lines into it's components and validate there places______________________________________________//
			if (FourOutputs.size() == 0) {
				ProgramList.add("");
				continue;
			}
//______________________________________COMMENTS Validity^____________________________________________//			
			if (FourOutputs.get(1).equals("start") == true) {

				if (FourOutputs.get(0).isEmpty() == false) {
					StartHaveLabel = true;
					LabelOfStart = FourOutputs.get(0);

				}
				// ____________Checking Label^_______________________//
				if (Myfunctions.IsHexa(FourOutputs.get(2)) == false || FourOutputs.get(2).length() > 4) {
					Source.Errortable.put(i, "not valid  hexadecimal string");
					ProgramList.add("");
					FourOutputs.clear();
					continue;
				}
				// _____________Validity of Operand^___________________//
				PC = Integer.parseInt(FourOutputs.get(2), 16);
				ProgramList.add(Integer.toHexString(PC));

				if (FourOutputs.get(0).equals("") == false) {
					Mysymboltable.put(FourOutputs.get(0), PC);
				}
				// _____________Adding Label To Symbol List ^^^^____________________//
			}
//_______________________________________START Validity_________________________________________________//
			else if (Myfunctions.isMnemonicValid(FourOutputs.get(1), FourOutputs.get(3), i, Myinstructions,
					MyDirectives) == true) {
				// mnemonic is valid in it's number of operands,format and syntax
				if (MyDirectives.containsKey(FourOutputs.get(1)) == false) {
					Myfunctions.InstructionOperandValidity(i, FourOutputs.get(1), FourOutputs.get(2),
							FourOutputs.get(3), Myinstructions, Mysymboltable);
					// Case Mnemonic is Instruction and check it's operand validity
				}

				PCDisplacement = Myfunctions.MnemonicDisplacement(Myinstructions, Mysymboltable, FourOutputs.get(1),
						MyDirectives, FourOutputs.get(2), FourOutputs.get(0), i);
				// Getting Displacement Of Mnemonic + Checking Validity of Operand if Mnemonic
				// is Directive
				if (FourOutputs.get(0).equals("") == false) {
					Mysymboltable.put(FourOutputs.get(0), PC);
				}
				// Adding Label in symbol table
				ProgramList.add(Integer.toHexString(PC));
				if (OrgStatamentOccur) {
					PC = PCDisplacement;
					OrgStatamentOccur = false;
				} else {
					PC = PC + PCDisplacement;
				}
				// _____Updating PC____________________________//
			} else {
				if(Errortable.containsKey(i)==false) {
				Errortable.put(i, "Invalid instruction");
				}
				ProgramList.add("");
			}
		}
		/**** Forward reference ****/
		Myfunctions.checkforwardreferences(Mysymboltable);
		int LastPC = Integer.parseInt(ProgramList.get(ProgramList.size() - 1), 16);
		/////////////////////////////////////////////////////////////////
		//Myfunctions.updatePCForliterals(LastPC, ProgramList, MyArrayList);
		Myfunctions.WriteInFile(Mysymboltable, ProgramList, MyArrayList);
		
		
		/*System.out.println(ArrayOfFourOutputs.get(6).get(2));
		System.out.println(MyArrayList);
		System.exit(0);*/
//___________________________________Writing into file___________________________________________________________________________//	

		if (Errortable.size()!=0) {
			System.out.println(Errortable);
			System.out.println("Error cannot generate object code check the code first");
			return;
		}
		System.out.println("Pass 2");
		int length = 0; // Used in printing the file 
		for (int i = 0; i < MyArrayList.size(); i++) {
			
			while (ArrayOfFourOutputs.get(i).size() == 0) {
				i++;
				ObjectCodeList.add("");
			}
		
			if ( ArrayOfFourOutputs.get(i).get(1).equalsIgnoreCase("END") || Myfunctions.checkliterals(ArrayOfFourOutputs.get(i).get(2),i) == true) {
				
				ObjectCodeList.add("");
				continue;
			}
			if (Myinstructions.get(ArrayOfFourOutputs.get(i).get(1)) != null
					|| ArrayOfFourOutputs.get(i).get(1).equalsIgnoreCase("WORD")
					|| ArrayOfFourOutputs.get(i).get(1).equalsIgnoreCase("BYTE")) {

				AddressingMode = Myfunctions.GetAddressingMode(ArrayOfFourOutputs.get(i).get(2),
						ArrayOfFourOutputs.get(i).get(3), Mysymboltable, MyRegisters);
				String objcode = Myfunctions.GetObjectCode(Mysymboltable, ArrayOfFourOutputs.get(i), AddressingMode,
						ProgramList.get(i), Myinstructions, MyRegisters, MyOpcodes,i);
				ObjectCodeList.add(objcode);
					if(objcode.length() > length) {
						length = objcode.length();
					}
			}
			else {
				ObjectCodeList.add("");
			}
		}
		
		Myfunctions.updateCodeForLiteralOperand(ArrayOfFourOutputs, MyArrayList, ObjectCodeList, ProgramList, LastPC, Myinstructions, MyOpcodes,ProgramList.size()-1);
		Myfunctions.ModifyWriteInFile(Mysymboltable, ProgramList, MyArrayList, ObjectCodeList,length+2);
		Myfunctions.Text(ArrayOfFourOutputs, ProgramList, ObjectCodeList);
	}
}
/*
 * STEPS OF PHASE1 1.Reading file and adding code into array list line by line
 * 2.Initializing Directive Map and Instruction Map And Fill it 3.Validating END
 * statement (Absence of End , Validating Label of End) 4.Separate Lines into
 * it's 4 Outputs And Filling Symbol Table (Validating Duplicate Label Error)
 * 5.Validating If This Line is a Comment 6.Validating Start ( Operand
 * Hexadecimal , Absence Of Label , Absence OF Start -> PC=0) 7.Adding Label To
 * Symbol List 8.Check If Mnemonic Is Valid (Syntax,Number of
 * Operands,Format)(unrecognized operation code,missing or misplaced operand
 * field) 9.Check Mnemonic Is Directive Or Instruction 10.IF Mnemonic Is
 * Instruction THEN Validate It's Operand ( illegal address for register,illegal
 * address for memory,undefined symbol in operand) 11.Get Displacement To Update
 * PC And Validate Operand If Mnemonic Is Directive 12.Update PC 13.Loop Whole
 * Code 14.Print In File
 */
