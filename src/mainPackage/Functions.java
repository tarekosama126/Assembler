package mainPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Functions {
	public ArrayList<String> registers = new ArrayList<String>(Arrays.asList("a", "l", "x", "s", "t", "b", "f"));

	public void FileReader(String FileName, ArrayList<String> MyArrayList) throws IOException {
		FileReader R = new FileReader(FileName);
		BufferedReader Reader = new BufferedReader(R);
		while (true) {
			String df = Reader.readLine();
			if (df == null) {
				break;
			}
			MyArrayList.add(df);
		}
		Reader.close();
	}

	public void InitializeMaps(Map<String, Integer> InstructionsMap, Map<String, Integer> Directive,
			Map<String, String> Registers, Map<String, String> Opcodes) {
		InstructionsMap.put("rmo", 2);
		InstructionsMap.put("lda", 3);
		InstructionsMap.put("ldl", 3);
		InstructionsMap.put("ldx", 3);
		InstructionsMap.put("lds", 3);
		InstructionsMap.put("ldt", 3);
		InstructionsMap.put("ldb", 3);
		InstructionsMap.put("+ldb", 4);
		InstructionsMap.put("+lda", 4);
		InstructionsMap.put("+ldl", 4);
		InstructionsMap.put("+ldx", 4);
		InstructionsMap.put("+lds", 4);
		InstructionsMap.put("+ldt", 4);
		InstructionsMap.put("sta", 3);
		InstructionsMap.put("stl", 3);
		InstructionsMap.put("stx", 3);
		InstructionsMap.put("sts", 3);
		InstructionsMap.put("stt", 3);
		InstructionsMap.put("+sta", 4);
		InstructionsMap.put("+stl", 4);
		InstructionsMap.put("+stx", 4);
		InstructionsMap.put("+sts", 4);
		InstructionsMap.put("+stt", 4);
		InstructionsMap.put("ldch", 3);
		InstructionsMap.put("+ldch", 4);
		InstructionsMap.put("stch", 3);
		InstructionsMap.put("+stch", 4);
		InstructionsMap.put("add", 3);
		InstructionsMap.put("+add", 4);
		InstructionsMap.put("sub", 3);
		InstructionsMap.put("+sub", 4);
		InstructionsMap.put("addr", 2);
		InstructionsMap.put("subr", 2);
		InstructionsMap.put("comp", 3);
		InstructionsMap.put("+comp", 4);
		InstructionsMap.put("compr", 2);
		InstructionsMap.put("mulr", 2);
		InstructionsMap.put("divr", 2);
		InstructionsMap.put("j", 3);
		InstructionsMap.put("+j", 4);
		InstructionsMap.put("jeq", 3);
		InstructionsMap.put("+jeq", 4);
		InstructionsMap.put("jlt", 3);
		InstructionsMap.put("+jlt", 4);
		InstructionsMap.put("jgt", 3);
		InstructionsMap.put("+jgt", 4);
		InstructionsMap.put("tix", 3);
		InstructionsMap.put("+tix", 4);
		InstructionsMap.put("tixr", 2);
		// __________________________________________
		Directive.put("start", 1);
		Directive.put("end", 2);
		Directive.put("byte", 3);
		Directive.put("word", 4);
		Directive.put("resw", 5);
		Directive.put("resb", 6);
		Directive.put("equ", 7);
		Directive.put("org", 8);
		// __________________________________________
		Registers.put("a", "0000");
		Registers.put("x", "0001");
		Registers.put("l", "0010");
		Registers.put("b", "0011");
		Registers.put("s", "0100");
		Registers.put("t", "0101");
		Registers.put("f", "0110");
		// Registers.put("A register with value 7 doesn't exist", 7);
		Registers.put("pc", "1000");
		Registers.put("sw", "1001");
		// ____Last 2 bits are cut for format 3/4____
		Opcodes.put("rmo", "10101100"); // 2
		Opcodes.put("lda", "000000"); // 3
		Opcodes.put("ldl", "000010"); // 3
		Opcodes.put("ldx", "000001"); // 3
		Opcodes.put("lds", "011011"); // 3
		Opcodes.put("ldt", "011101"); // 3
		Opcodes.put("+lda", "000000"); // 4
		Opcodes.put("+ldl", "000010"); // 4
		Opcodes.put("+ldx", "000001"); // 4
		Opcodes.put("+lds", "011011"); // 4
		Opcodes.put("+ldt", "011101"); // 4
		Opcodes.put("sta", "000011"); // 3
		Opcodes.put("stl", "000101"); // 3
		Opcodes.put("stx", "000100"); // 3
		Opcodes.put("sts", "011111"); // 3
		Opcodes.put("stt", "100001"); // 3
		Opcodes.put("+sta", "000011"); // 4
		Opcodes.put("+stl", "000101"); // 4
		Opcodes.put("+stx", "000100"); // 4
		Opcodes.put("+sts", "011111"); // 4
		Opcodes.put("+stt", "100001"); // 4
		Opcodes.put("ldch", "010100"); // 3
		Opcodes.put("+ldch", "010100"); // 4
		Opcodes.put("stch", "010101"); // 3
		Opcodes.put("+stch", "010101"); // 4
		Opcodes.put("add", "000110"); // 3
		Opcodes.put("+add", "000110"); // 4
		Opcodes.put("sub", "000111"); // 3
		Opcodes.put("+sub", "000111"); // 4
		Opcodes.put("addr", "10010000"); // 2
		Opcodes.put("subr", "10010100"); // 2
		Opcodes.put("comp", "001010"); // 3
		Opcodes.put("+comp", "001010"); // 4
		Opcodes.put("compr", "10100000"); // 2
		Opcodes.put("mulr", "10011000");// 2
		Opcodes.put("divr", "10011100");// 2
		Opcodes.put("ldb", "011010");// 3
		Opcodes.put("+ldb", "011010");// 4
		Opcodes.put("j", "001111"); // 3
		Opcodes.put("+j", "001111"); // 4
		Opcodes.put("jeq", "001100"); // 3
		Opcodes.put("+jeq", "001100"); // 4
		Opcodes.put("jlt", "001110"); // 3
		Opcodes.put("+jlt", "001110"); // 4
		Opcodes.put("jgt", "001110"); // 3
		Opcodes.put("+jgt", "001110"); // 4
		Opcodes.put("tix", "001011"); // 3
		Opcodes.put("+tix", "001011"); // 4
		Opcodes.put("tixr", "10111000"); // 2
	}

	public ArrayList<String> GetOutputs(ArrayList<String> Outputs, String Line, int errorindex,
			Map<String, Integer> Mysymboltable, Map<String, Integer> InstructionsMap) {
		String label, instruction, operand1, operand2;
		int range = 34;
		// ________________Variables____________________//
		if (Line.startsWith(".")) {
			return Outputs;
		}
		// ________________COMMENTS Validity____________//
		label = Line.substring(0, 8);
		if (label.charAt(0) == ' ' && !label.equals("        ")) {
			Source.Errortable.put(errorindex, "Misplaced Label");
			return Outputs;
		}
		label = label.trim();
		label = label.toLowerCase();
		if (label.isEmpty() == false && checkLabelValidity(label) == false) {
			Source.Errortable.put(errorindex, "Invalid Label");
			return Outputs;
		}
		if (Mysymboltable.containsKey(label)) {
			Source.Errortable.put(errorindex, "duplicate label definition");
			return Outputs;
		}
		if (InstructionsMap.containsKey(label) == true) {
			Source.Errortable.put(errorindex, "label can't have the same name as instruction");
			return Outputs;
		}

		// ________________Label Getting + Validity_______//

		try {
			instruction = Line.substring(9, 15);
		} catch (Exception e) {
			instruction = Line.substring(9, Line.length());
		}

		if (instruction.charAt(0) == ' ' && !instruction.equals("      ")) {
			Source.Errortable.put(errorindex, "Misplaced instruction");
			return Outputs;
		}
		instruction = instruction.trim();
		instruction = instruction.toLowerCase();
		if (Line.length() < 18 && instruction.equals("end") == false) {
			Source.Errortable.put(errorindex, "Missing Operand");
			return Outputs;
		}
		// _____Instruction getting + Validity______________________________//
		if (Line.contains("*") == false || Line.length() < 34) {
			range = Line.length();
		}
		operand1 = Line.substring(17, range);
		if (operand1.charAt(0) == ' ' && operand1 != null) {
			Source.Errortable.put(errorindex, "Misplaced Operand");
			return Outputs;
		}
		String[] operands = operand1.split(",");
		operand1 = operands[0];
		operand1 = operand1.trim();
		operand1 = operand1.toLowerCase();
		if (operands.length == 1) {
			operand2 = null;
		} else {
			operand2 = operands[1];
			operand2 = operand2.trim();
			operand2 = operand2.toLowerCase();
		}
		// ___Operand Getting + Validity_____________________________________//
		Outputs.add(label);
		Outputs.add(instruction);
		Outputs.add(operand1);
		Outputs.add(operand2);
		return Outputs;
	}

	public boolean isMnemonicValid(String Mnemonic, String Operand2, int errorindex,
			Map<String, Integer> InstructionsMap, Map<String, Integer> Directive) {
		if (Mnemonic.equals("rmo") == true && Operand2 == null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("lda") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("ldb") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("ldl") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("lds") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("ldx") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("ldt") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("sta") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("stl") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("sts") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("stx") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("stt") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("ldch") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;

		} else if (Mnemonic.equals("stch") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("add") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("sub") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("addr") == true && Operand2 == null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("subr") == true && Operand2 == null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;

		} else if (Mnemonic.equals("mulr") == true && Operand2 == null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("divr") == true && Operand2 == null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("comp") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("compr") == true && Operand2 == null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("j") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("jeq") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("jlt") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("jgt") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("tix") == true && Operand2 != null && Operand2.equals("x") == false) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("tixr") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;

		} else if (Mnemonic.equals("start") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("end") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("byte") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("word") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("resw") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("resb") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("equ") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		} else if (Mnemonic.equals("org") == true && Operand2 != null) {
			Source.Errortable.put(errorindex, "missing or misplaced operand field");
			return false;
		}

		else {
			if (InstructionsMap.containsKey(Mnemonic) == true || Directive.containsKey(Mnemonic) == true) {
				return true;
			} else {
				Source.Errortable.put(errorindex, "unrecognized operation code");
				return false;
			}

		}
	}

	private void GetInstructionFormatError(int errorindex, String Instruction, Map<String, Integer> InstructionsMap) {
		if (Instruction.charAt(0) == '+') {
			Source.Errortable.put(errorindex, "This Instruction Can't be Format 4");
			return;
		}
		Instruction = "+" + Instruction.substring(1);
		if (InstructionsMap.get(Instruction) != null) {
			Source.Errortable.put(errorindex, "This Instruction has wrong prefix");
			return;
		} else {
			Source.Errortable.put(errorindex, "Invalid Instruction");
			return;
		}
	}

	public int MnemonicDisplacement(Map<String, Integer> InstructionsMap, Map<String, Integer> SymbolList,
			String Instruction, Map<String, Integer> Directive, String Operand1, String Label, int errorindex) {

		if (InstructionsMap.get(Instruction) == null) {
			if (Directive.get(Instruction) != null) {
				return DirectiveDisplacement_And_DirectiveOperandValidity(Operand1, Instruction,
						Directive.get(Instruction), SymbolList, Label, errorindex);
			} else {
				GetInstructionFormatError(errorindex, Instruction, InstructionsMap);
				return 0;
			}

		} else
			return InstructionsMap.get(Instruction);

	}

	private int DirectiveDisplacement_And_DirectiveOperandValidity(String Operand, String Instruction,
			int directivenumber, Map<String, Integer> SymbolList, String Label, int errorindex) {
		String Passer = null;
		if (directivenumber == 1) {

			if (IsHexa(Operand)) {
				return Integer.parseInt(Operand);
			} else {
				Source.Errortable.put(errorindex, "not valid  hexadecimal string");
				return 0;
			}
		}
		if (directivenumber == 2) {
			for (Map.Entry<String, Integer> entry : SymbolList.entrySet()) {
				Passer = entry.getKey();
				break;
			}
			if (Label.equals("") == false) {
				Source.Errortable.put(errorindex, "This statment can't have a label");
			}
			if (Passer.equals(Operand) == true) {
				System.out.println(
						" s u c c e s s f u l    a s s e m b l y\r\n" + "e  n  d      o  f      p  r  o  g  r  a  m");

			} else {
				System.out.println(" u n s u c c e s s f u l    a s s e m b l y\r\n"
						+ "e  n  d      o  f      p  r  o  g  r  a  m");

			}
		}
		if (directivenumber == 3) {
			if ((Operand.charAt(0) == 'C' || Operand.charAt(0) == 'c') && Operand.charAt(1) == '\''
					&& Operand.charAt(Operand.length() - 1) == '\'') {
				Operand = Operand.substring(2, Operand.length() - 1);
				if (Operand.length() <= 15) {
					return Operand.length();
				} else {
					Source.Errortable.put(errorindex, "Invalid Size");
					return 0;
				}

			} else if ((Operand.charAt(0) == 'X' || Operand.charAt(0) == 'x') && Operand.charAt(1) == '\''
					&& Operand.charAt(Operand.length() - 1) == '\'') {
				Operand = Operand.substring(2, Operand.length() - 1);
				if (Operand.length() <= 14 && (Operand.length() % 2) == 0 && IsHexa(Operand) == true) {
					return Operand.length() / 2;
				} else {
					Source.Errortable.put(errorindex, "Invalid in Size or Hexa string");
					return 0;
				}

			} else if (TestNumeric(Operand)) {
				int number = Integer.parseInt(Operand);
				if (number <= 127 && number >= -128) {
					return 1;
				} else {
					Source.Errortable.put(errorindex, "Wrong range for byte");
					return 0;
				}
			} else {
				Source.Errortable.put(errorindex, "illegal Operand");
				return 0;
			}
		}
		if (directivenumber == 4) {
			if (TestNumeric(Operand) && Operand.length() <= 4) {
				return 3;
			} else if (Operand.charAt(0) == '-') {
				Operand = Operand.substring(1);
				if (TestNumeric(Operand) && Operand.length() <= 4) {
					return 3;
				}
				Source.Errortable.put(errorindex, "illegal Operand");
				return 0;
			} else {
				Source.Errortable.put(errorindex, "illegal Operand");
				return 0;
			}
		}
		if (directivenumber == 5) {
			if (TestNumeric(Operand) && Operand.length() <= 4) {
				int number = Integer.parseInt(Operand);
				return 3 * number;
			} else {
				Source.Errortable.put(errorindex, "illegal Operand");
				return 0;
			}
		}
		if (directivenumber == 6) {
			if (TestNumeric(Operand) && Operand.length() <= 4) {
				int number = Integer.parseInt(Operand);
				return number;
			} else {
				Source.Errortable.put(errorindex, "illegal Operand");
				return 0;
			}
		}
		if (directivenumber == 7) {
			if (Label.isEmpty() == true) {
				Source.Errortable.put(errorindex, "EQU must have a label");
				return 0;
			}
			if (TestNumeric(Operand) && Operand.length() <= 4) {
				return 0;

			} else if (SymbolList.containsKey(Operand)) {
				return 0;
			} else {
				Source.Errortable.put(errorindex, "illegal Oprand");
				return 0;
			}
		}
		if (directivenumber == 8) {
			if (Label.isEmpty() == false) {
				Source.Errortable.put(errorindex, "Instruction mustn't have a label");
				return 0;
			}
			if (TestNumeric(Operand) && Operand.length() <= 4) {
				Source.OrgStatamentOccur = true;
				return Integer.parseInt(Operand);
			} else if (SymbolList.containsKey(Operand)) {
				Source.OrgStatamentOccur = true;
				return SymbolList.get(Operand);
			} else {
				Source.Errortable.put(errorindex, "Invalid Oprand For ORG");
				return 0;
			}
		}

		return 0;
	}

	private boolean TestNumeric(String text) {
		if (text.matches("[0-9]+") && text.length() > 0)
			return true;
		else
			return false;
	}

	public void CheckEndValidity(String line, int error_index) {
		if (line.contains("end") == false) {
			Source.Errortable.put(error_index, "Missing End Statment");
			return;
		}
		String test = line.substring(0, 8);
		test = test.trim();
		if (test.isEmpty() == false) {
			Source.Errortable.put(error_index, "This statment can't have a label");
			return;
		} else if (line.length() < 18 && Source.StartHaveLabel == false) {
			return;
		} else if (line.length() < 18 && Source.StartHaveLabel == true) {
			Source.Errortable.put(error_index, "Missing Label");
			return;
		} else if (line.length() >= 18) {

			String oprand = line.substring(17, line.length());
			oprand = oprand.trim();
			if (oprand.equalsIgnoreCase(Source.LabelOfStart)) {
				return;
			} else {
				Source.Errortable.put(error_index, "Undefined Label");
				return;
			}
		}

	}

	public void WriteInFile(Map<String, Integer> SymbolList, ArrayList<String> ProgramList,
			ArrayList<String> MyArrayList) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("assembler.txt", "UTF-8");
		writer.println("	     Symbol Table			");
		writer.println("	name		address		");
		for (Map.Entry<String, Integer> entry : SymbolList.entrySet()) {
			writer.println("	" + entry.getKey() + "		" + FixIntegarToHexaDecimal(entry.getValue()));
		}
		writer.println("\n");
		writer.println("	     p r o g r a m     l i s t i n g		");
		for (int i = 0; i < ProgramList.size(); i++) {
			writer.println(FixStringToHexaDecimal(ProgramList.get(i)) + "        " + MyArrayList.get(i));
			if (Source.Errortable.containsKey(i)) {
				writer.println("  	 	*****" + Source.Errortable.get(i));
			}
		}
		CheckAssemble(Source.Errortable.size(), writer);
		writer.close();
	}

	public void InstructionOperandValidity(int errorindex, String instruction, String operand1, String operand2,
			Map<String, Integer> InstructionsMap, Map<String, Integer> Mysymboltable) {

		if (InstructionsMap.get(instruction) == 2 && instruction.equals("tixr") && registers.contains(operand1))
			return;
		else if (InstructionsMap.get(instruction) == 2 && instruction.equals("tixr")
				&& registers.contains(operand1) == false) {
			Source.Errortable.put(errorindex, "illegal address for a register");
			return;
		}

		if (InstructionsMap.get(instruction) == 2 && registers.contains(operand1) && registers.contains(operand2)) {
			return;
		}

		else if (InstructionsMap.get(instruction) == 2) {
			Source.Errortable.put(errorindex, "illegal address for a register");
			return;
		}

		//////////////////////
		if ((InstructionsMap.get(instruction) == 3 || InstructionsMap.get(instruction) == 4)) {

			if (operand1.equals("*") == true) {
				return;
			}
			if (registers.contains(operand1) == true) {
				Source.Errortable.put(errorindex, "illegal address for a memory");
				return;
			}

			else {
				if (TestNumeric(operand1) == true) {
					return;
				}
				if (operand1.charAt(0) == '#') {
					operand1 = operand1.substring(1);
					if (IsAlphanumric(operand1) == true && InstructionsMap.get(operand1) == null) {
						return;
					}
					if (TestNumeric(operand1) == false) {
						Source.Errortable.put(errorindex, "undefined symbol in operand");
						return;
					}
					return;
				} else if (operand1.charAt(0) == '@') {
					operand1 = operand1.substring(1);
					if (IsAlphanumric(operand1) == false) {
						Source.Errortable.put(errorindex, "undefined symbol in operand");
						return;
					}
					return;
				} else if (checkliterals(operand1, errorindex) == true) {

					Source.Literals.add(operand1);
					return;
				} else if (IsAlphanumric(operand1) == true && Mysymboltable.containsKey(operand1) == false) {
					Source.forwardreference.put(operand1, errorindex);
					return;
				} else if (Checkexpression(operand1, errorindex, Mysymboltable) == false
						|| Checkexpression(operand1, errorindex, Mysymboltable) == true) {
					return;
				}

			}
			return;
		}
	}

	private boolean IsAlphanumric(String operand) {
		return operand != null && operand.matches("^[a-zA-Z0-9]*$");

	}

	public boolean IsHexa(String number) {
		boolean retvalue;
		try {
			@SuppressWarnings("unused")
			int test = Integer.parseInt(number, 16);
			retvalue = true;

		} catch (Exception e) {
			retvalue = false;
		}
		return retvalue;

	}

	public String FixIntegarToHexaDecimal(int number) {
		return String.format("%06X", number & 0xFFFFFF).toUpperCase();
	}

	private String FixStringToHexaDecimal(String number) {
		if (number.isEmpty()) {
			return "";
		}
		return FixIntegarToHexaDecimal(Integer.parseInt(number, 16));
	}

	private void CheckAssemble(int SizeOfErrorTable, PrintWriter writer) {
		if (SizeOfErrorTable == 0) {
			writer.println(
					" s u c c e s s f u l    a s s e m b l y\r\n" + "e  n  d      o  f      p  r  o  g  r  a  m");
			return;
		}
		writer.println(
				" u n s u c c e s s f u l    a s s e m b l y\r\n" + "e  n  d      o  f      p  r  o  g  r  a  m");
		return;
	}

	private boolean checkLabelValidity(String label) {
		char c = label.charAt(0);
		if (Character.isDigit(c)) {
			return false;
		}
		return IsAlphanumric(label);
	}

	@SuppressWarnings("unused")
	public String BintoHex(String binary, int format) {
		String ans = "", padding = "";
		int digitNumber = 1, sum = 0;
		if (binary.length() % 4 != 0) {
			int n = (binary.length() % 4);
			int m = (binary.length() / 4) + 1;
			m = (m * 4) - n;
			for (int i = 0; i < m; i++)
				padding += '0';
			padding += binary;
		} else
			padding = binary;
		for (int i = 0; i < padding.length(); i++) {
			if (digitNumber == 1)
				sum += Integer.parseInt(padding.charAt(i) + "") * 8;
			else if (digitNumber == 2)
				sum += Integer.parseInt(padding.charAt(i) + "") * 4;
			else if (digitNumber == 3)
				sum += Integer.parseInt(padding.charAt(i) + "") * 2;
			else if (digitNumber == 4 || i < padding.length() + 1) {
				sum += Integer.parseInt(padding.charAt(i) + "") * 1;
				digitNumber = 0;
				if (sum < 10) {
					char c = (char) sum;
					ans += sum;
				} else if (sum == 10)
					ans += "A";
				else if (sum == 11)
					ans += "B";
				else if (sum == 12)
					ans += "C";
				else if (sum == 13)
					ans += "D";
				else if (sum == 14)
					ans += "E";
				else if (sum == 15)
					ans += "F";
				sum = 0;
			}
			digitNumber++;
		}
		if (format == 2 && ans.length() < 4) {
			String s = "";
			int x = 4 - ans.length();
			for (int i = 0; i < x; i++)
				s += '0';
			s += ans;
			return s;
		} else if (format == 3 && ans.length() < 6) {
			String s = "";
			int x = 6 - ans.length();
			for (int i = 0; i < x; i++)
				s += '0';
			s += ans;
			return s;
		} else if (format == 4 && ans.length() < 8) {
			String s = "";
			int x = 8 - ans.length();
			for (int i = 0; i < x; i++)
				s += '0';
			s += ans;
			return s;
		} else
			return ans;
	}

	public void checkforwardreferences(Map<String, Integer> Mysymboltable) {
		Iterator<Entry<String, Integer>> it = Source.forwardreference.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it.next();
			if (Mysymboltable.containsKey(pair.getKey()) == true) {
				it.remove();
			} else {
				Source.Errortable.put(pair.getValue(), "this is invalid operand");
			}
		}
	}

	public boolean checkliterals(String Operand, int errorindex) {

		if (Operand.charAt(0) == '=' && (Operand.charAt(1) == 'C' || Operand.charAt(1) == 'c')
				&& Operand.charAt(2) == '\'' && Operand.charAt(Operand.length() - 1) == '\'') {
			Operand = Operand.substring(3, Operand.length() - 1);
			if (Operand.length() <= 15) {
				return true;
			} else {
				Source.Errortable.put(errorindex, "Invalid Size");
				return false;
			}
		} else if (Operand.charAt(0) == '=' && (Operand.charAt(1) == 'X' || Operand.charAt(1) == 'x')
				&& Operand.charAt(2) == '\'' && Operand.charAt(Operand.length() - 1) == '\'') {
			Operand = Operand.substring(3, Operand.length() - 1);
			if (Operand.length() <= 14 && (Operand.length() % 2) == 0 && IsHexa(Operand) == true) {

				return true;
			} else {
				Source.Errortable.put(errorindex, "Invalid in Size or Hexa string");
				Source.literalsIndex.put(Operand, errorindex);
				return false;
			}
		} else if (Operand.charAt(0) == '=' && (Operand.charAt(1) == 'W' || Operand.charAt(1) == 'w')
				&& Operand.charAt(2) == '\'' && Operand.charAt(Operand.length() - 1) == '\'') {
			Operand = Operand.substring(3, Operand.length() - 1);
			if (TestNumeric(Operand) && Operand.length() <= 4) {
				return true;
			} else {
				Source.Errortable.put(errorindex, "Invalid in Size");
				return false;
			}
		}
		return false;
	}

	public void updatePCForliterals(ArrayList<ArrayList<String>> ArrayOfFourOutputs, int number,
			ArrayList<String> ProgramList, ArrayList<String> ArrayList, ArrayList<String> ObjectList, int limit) {
		for (int i = 0; i < Source.Literals.size(); i++) {
			ArrayList.add(Source.Literals.get(i));
			number = number + 3;
			ProgramList.add(Integer.toHexString(number));
			ObjectList.add(OpcodeLiteral(Source.Literals.get(i), limit + i));
			Source.literalsIndex.put(Source.Literals.get(i), limit + i);
			ArrayList<String> desoo = new ArrayList<String>();
			desoo.add("");
			desoo.add("literal");
			ArrayOfFourOutputs.add(desoo);
		}
	}

	private boolean Checkexpression(String Operand, int errorindex, Map<String, Integer> SymbolTable) {
		if (Operand.contains("+") == false && Operand.contains("-") == false) {
			Source.Errortable.put(errorindex, "Invalid expression");
			return false;
		}
		if (Operand.contains("+") == true) {
			String[] splited = Operand.split("\\+");
			ArrayList<String> arrayofoperands = new ArrayList<String>();
			for (String a : splited) {
				if (a.equals("+") == false) {
					arrayofoperands.add(a);
				}
			}
			if (arrayofoperands.size() < 2) {
				Source.Errortable.put(errorindex, "Invalid expression because missing term");
				return false;
			}
			if (IsAlphanumric(arrayofoperands.get(0)) && TestNumeric(arrayofoperands.get(1))
					&& checkSizeNumber(arrayofoperands.get(1))) {
				if (SymbolTable.containsKey(arrayofoperands.get(0)) == false) {
					Source.forwardreference.put(arrayofoperands.get(0), errorindex);
				}
				return true;
			} else if (IsAlphanumric(arrayofoperands.get(1)) && TestNumeric(arrayofoperands.get(0))
					&& checkSizeNumber(arrayofoperands.get(0))) {
				if (SymbolTable.containsKey(arrayofoperands.get(1)) == false) {
					Source.forwardreference.put(arrayofoperands.get(1), errorindex);
				}
				return true;
			} else {
				Source.Errortable.put(errorindex, "check the operands of the expression");
				return false;
			}
		} else if (Operand.contains("-") == true) {
			String[] splited = Operand.split("\\-");
			ArrayList<String> arrayofoperands = new ArrayList<String>();
			for (String a : splited) {
				if (a.equals("-") == false) {
					arrayofoperands.add(a);
				}
			}
			if (IsAlphanumric(arrayofoperands.get(0)) && TestNumeric(arrayofoperands.get(1))
					&& checkSizeNumber(arrayofoperands.get(1))) {
				if (SymbolTable.containsKey(arrayofoperands.get(0)) == false) {
					Source.forwardreference.put(arrayofoperands.get(0), errorindex);
				}
				return true;
			} else {
				Source.Errortable.put(errorindex, "check the arrange of operand for expression");
				return false;
			}
		}

		return false;
	}

	public String GetAddressingMode(String Operand1, String Operand2, Map<String, Integer> Mysymboltable,
			Map<String, String> Registers) {
		String AddressingMode = "Simple";
		if (Operand1.charAt(0) == '#') {
			AddressingMode = "Immediate"; /////////// Immediate
			return AddressingMode;
		} else if (Operand1.charAt(0) == '@') {
			AddressingMode = "Indirect"; /////////// Indirect
			return AddressingMode;
		} else if (Operand2 != null && Operand2.equalsIgnoreCase("x") == true) {

			AddressingMode = "Indexed";//////////// Indexed
			return AddressingMode;
		} else if (Mysymboltable.containsKey(Operand1) == true) {
			AddressingMode = "Simple";
			return AddressingMode;
		} else
			return AddressingMode;
	}

	public String intToBinary(int n, int NumOfBits) {
		String Binary = "";

		for (int i = 0; i < NumOfBits; ++i, n /= 2) {
			switch (n % 2) {
			case 0:
				Binary = "0" + Binary;
				break;
			case 1:
				Binary = "1" + Binary;
				break;
			}
		}
		return Binary;

	}

	private ArrayList<String> SetUpExperession(String expression) {
		ArrayList<String> exp = new ArrayList<String>();
		ArrayList<String> arrayofoperands = new ArrayList<String>();
		if (expression.contains("+")) {
			String[] splited = expression.split("\\+");
			for (String a : splited) {
				if (a.equals("+") == false) {
					arrayofoperands.add(a);
				}
			}
			if (IsAlphanumric(arrayofoperands.get(0)) && TestNumeric(arrayofoperands.get(1))) {
				exp.add("+");
				exp.add(arrayofoperands.get(0));
				exp.add(arrayofoperands.get(1));
				return exp;
			} else {
				exp.add("+");
				exp.add(arrayofoperands.get(1));
				exp.add(arrayofoperands.get(0));
				return exp;
			}
		} else {
			String[] splited = expression.split("\\-");
			for (String a : splited) {
				if (a.equals("-") == false) {
					arrayofoperands.add(a);
				}
			}
			exp.add("-");
			exp.add(arrayofoperands.get(0));
			exp.add(arrayofoperands.get(1));
			return exp;
		}
	}

	private ArrayList<String> SetUpLiterals(String Literal) {
		ArrayList<String> exp = new ArrayList<String>();
		if (Literal.contains("w")) {
			exp.add("w");
			exp.add(Literal.substring(3, Literal.length() - 1));
			return exp;
		} else if (Literal.contains("x")) {
			exp.add("x");
			exp.add(Literal.substring(3, Literal.length()));
			return exp;
		}
		exp.add("c");
		exp.add(Literal.substring(3, Literal.length() - 1));
		return exp;
	}

	public String GetObjectCode(Map<String, Integer> Mysymboltable, ArrayList<String> FourOutPuts,
			String AddressingMode, String PC, Map<String, Integer> MyInstructions, Map<String, String> Registers,
			Map<String, String> Opcodes, int errorindex) {
		String BinaryObjectCode = null;
		boolean p = false, b = false, n = false, i = false, x = false, e = false;
		int TA = 0;
		/*
		 * if(checkliterals(FourOutPuts.get(2), errorindex)) {
		 * if(MyInstructions.get(FourOutPuts.get(1))==3) { n = true; i = true; p = true;
		 * TA = Mysymboltable.get(FourOutPuts.get(2)) - ; } //format 4
		 * 
		 * return "ABC"; }
		 */

		if (Checkexpression(FourOutPuts.get(2), errorindex, Mysymboltable) == true) {
			ArrayList<String> exp = SetUpExperession(FourOutPuts.get(2));
			BinaryObjectCode = "";
			BinaryObjectCode = Opcodes.get(FourOutPuts.get(1));
			if (exp.get(0).contains("+")) {
				n = true;
				i = true;
				if (MyInstructions.get(FourOutPuts.get(1)) == 3) {
					p = true;
					TA = (Mysymboltable.get(exp.get(1)) + Integer.parseInt(exp.get(2)))
							- (Integer.parseInt(PC, 16) + 3);
					BinaryObjectCode = BinaryObjectCode + n + i + x + b + p + e + intToBinary(TA, 12);
					return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 3);
				}
				e = true;
				TA = (Mysymboltable.get(exp.get(1)) + Integer.parseInt(exp.get(2)));
				BinaryObjectCode = BinaryObjectCode + n + i + x + b + p + e + intToBinary(TA, 20);
				return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 4);
			} else {
				n = true;
				i = true;

				if (MyInstructions.get(FourOutPuts.get(1)) == 3) {
					p = true;
					TA = (Mysymboltable.get(exp.get(1)) - Integer.parseInt(exp.get(2)))
							- (Integer.parseInt(PC, 16) + 3);
					BinaryObjectCode = BinaryObjectCode + n + i + x + b + p + e + intToBinary(TA, 12);
					return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 3);
				}
				e = true;
				TA = (Mysymboltable.get(exp.get(1)) - Integer.parseInt(exp.get(2)));
				BinaryObjectCode = BinaryObjectCode + n + i + x + b + p + e + intToBinary(TA, 20);
				return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 4);
			}
		}
		if (FourOutPuts.get(1).equalsIgnoreCase("WORD") == true) {
			return BintoHex(intToBinary(Integer.parseInt(FourOutPuts.get(2)), 16), 3);
		} else if (FourOutPuts.get(1).equalsIgnoreCase("BYTE") == true) {

			if (FourOutPuts.get(2).startsWith("x")) {
				return FourOutPuts.get(2).substring(2, FourOutPuts.get(2).length() - 1).toUpperCase();
			}
			if (FourOutPuts.get(2).startsWith("c")) {
				FourOutPuts.set(2, FourOutPuts.get(2).substring(2, FourOutPuts.get(2).length() - 1));
				BinaryObjectCode = "";
				for (int k = 0; k < FourOutPuts.get(2).length(); k++) {
					BinaryObjectCode = BinaryObjectCode.concat(
							BintoHex(Integer.toBinaryString((int) FourOutPuts.get(2).charAt(k)), 2).substring(2));
				}
				return BinaryObjectCode;
			}

		}
		// Format 2
		else if (MyInstructions.get(FourOutPuts.get(1)) == 2) {

			BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + Registers.get(FourOutPuts.get(2))
					+ Registers.get(FourOutPuts.get(3));
			// To validate the TIXR because it's format 2 but have 1 operand while all
			// format 2 have 2 Operand which are resgister.
			return BintoHex(BinaryObjectCode.replace("null", "0000"), 2);
		}
		// format 3
		if (MyInstructions.get(FourOutPuts.get(1)) == 3) {
			if (AddressingMode.equals("Simple")) {
				n = true;
				i = true;
				p = true;

				TA = Mysymboltable.get(FourOutPuts.get(2)) - (Integer.valueOf(PC, 16) + 3);
				BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 12); // ;
				return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 3);
			}
			if (AddressingMode.equals("Immediate") == true) {
				FourOutPuts.set(2, FourOutPuts.get(2).substring(1));
				if (Mysymboltable.containsKey(FourOutPuts.get(2)) == true) {
					i = true;
					p = true;
					TA = Mysymboltable.get(FourOutPuts.get(2)) - (Integer.valueOf(PC, 16) + 3);
					BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 12); // ;
					return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 3);
					// NOT HANDLED IN ASSEMBLER FILE!!!!///
				} else {
					i = true;
					TA = Integer.valueOf(FourOutPuts.get(2), 16);
					BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 12); // ;
					BinaryObjectCode = BinaryObjectCode.replace("true", "1").replace("false", "0");
					return BintoHex(BinaryObjectCode, 3);

				}
			}
			if (AddressingMode.equals("Indirect") == true) {
				FourOutPuts.set(2, FourOutPuts.get(2).substring(1));
				n = true;
				p = true;
				TA = Mysymboltable.get(FourOutPuts.get(2)) - (Integer.valueOf(PC, 16) + 3);
				BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 12); // ;
				return (BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 3));

			}
			if (AddressingMode.equals("Indexed") == true) {
				// String RegisterX = "0033";
				n = true;
				i = true;
				x = true;
				p = true;
				TA = Mysymboltable.get(FourOutPuts.get(2)) - (Integer.valueOf(PC, 16) + 3);
				BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 12); // ;
				return (BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 3));

			}

		}
		// Format 4
		if (MyInstructions.get(FourOutPuts.get(1)) == 4) {
			e = true;
			if (AddressingMode.equals("Simple")) {
				n = true;
				i = true;
				TA = Mysymboltable.get(FourOutPuts.get(2));
				BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 20); // ;
				return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 3);
			}
			if (AddressingMode.equals("Immediate") == true) {
				FourOutPuts.set(2, FourOutPuts.get(2).substring(1));
				if (Mysymboltable.containsKey(FourOutPuts.get(2)) == true) {
					i = true;
					TA = Mysymboltable.get(FourOutPuts.get(2));
					BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 20); // ;
					return BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 4);
					// NOT HANDLED IN ASSEMBLER FILE!!!!///
				} else {
					i = true;
					TA = Integer.valueOf(FourOutPuts.get(2), 16);
					BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 20); // ;
					BinaryObjectCode = BinaryObjectCode.replace("true", "1").replace("false", "0");
					return BintoHex(BinaryObjectCode, 4);

				}
			}
			if (AddressingMode.equals("Indirect") == true) {
				FourOutPuts.set(2, FourOutPuts.get(2).substring(1));
				n = true;
				// p = true;
				TA = Mysymboltable.get(FourOutPuts.get(2));
				BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 20); // ;
				return (BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 4));
			}
			if (AddressingMode.equals("Indexed") == true) {
				// String RegisterX = "0033";
				n = true;
				i = true;
				x = true;
				// p = true;
				TA = Mysymboltable.get(FourOutPuts.get(2));
				BinaryObjectCode = Opcodes.get(FourOutPuts.get(1)) + n + i + x + b + p + e + intToBinary(TA, 20); // ;
				return (BintoHex(BinaryObjectCode.replace("true", "1").replace("false", "0"), 4));
			}

		}
		return BinaryObjectCode;
	}

	public void ModifyWriteInFile(Map<String, Integer> SymbolList, ArrayList<String> ProgramList,
			ArrayList<String> MyArrayList, ArrayList<String> ObjectCode, int limit)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("objectCode.txt", "UTF-8");
		writer.println("	     Symbol Table			");
		writer.println("	name		address		");
		for (Map.Entry<String, Integer> entry : SymbolList.entrySet()) {
			writer.println("	" + entry.getKey() + "		" + FixIntegarToHexaDecimal(entry.getValue()));
		}
		writer.println("\n");
		writer.println("	     p r o g r a m     l i s t i n g		");
		for (int i = 0; i < ProgramList.size(); i++) {

			writer.println(FixStringToHexaDecimal(ProgramList.get(i)) + "        " + Padding(ObjectCode.get(i), limit)
					+ "" + MyArrayList.get(i));
		}
		writer.close();
	}

	private String Padding(String line, int length) {
		for (int i = line.length(); i <= length; i++) {
			line = line + " ";
		}
		return line;
	}

	private String Header(ArrayList<ArrayList<String>> ArrayOfFourOutputs, ArrayList<String> ProgramList) {
		int i = 0;
		while (ArrayOfFourOutputs.get(i).size() == 0) {
			i++;
		}
		int LastPC = Integer.parseInt(ProgramList.get(ProgramList.size() - 1), 16);
		int FirstPC = Integer.parseInt(ProgramList.get(i), 16);
		int value = LastPC - FirstPC;
		if (Source.StartHaveLabel == false) {
			return "H" + "       " + FixIntegarToHexaDecimal(Integer.parseInt(ProgramList.get(i), 16)) + ""
					+ FixIntegarToHexaDecimal(value);
		} else {
			return "H" + Source.LabelOfStart + FixIntegarToHexaDecimal(Integer.parseInt(ProgramList.get(i), 16)) + ""
					+ FixIntegarToHexaDecimal(value);
		}
	}

	private String End(ArrayList<ArrayList<String>> ArrayOfFourOutputs, ArrayList<String> ProgramList) {
		int i = 0;
		while (ArrayOfFourOutputs.get(i).size() == 0) {
			i++;
		}
		return "E" + FixIntegarToHexaDecimal(Integer.parseInt(ProgramList.get(i), 16));
	}

	public void Text(ArrayList<ArrayList<String>> ArrayOfFourOutputs, ArrayList<String> ProgramList,
			ArrayList<String> ObjectCodeList) throws FileNotFoundException, UnsupportedEncodingException {
		boolean jump = true;
		String result = "";
		int StartIndex = 0, EndIndex = 0;
		ArrayList<String> obj = new ArrayList<String>();
		ArrayList<String> Indexes = new ArrayList<String>();
		for (int i = 0; i < ProgramList.size(); i++) {
			if (ArrayOfFourOutputs.get(i).size() == 0 || ArrayOfFourOutputs.get(i).get(1).equalsIgnoreCase("Start")) {
				continue;
			}
			if ((ObjectCodeList.get(i).isEmpty() == true && jump == false)) {
				EndIndex = i;
				Indexes.add(ProgramList.get(StartIndex));
				Indexes.add(ProgramList.get(EndIndex));
				obj.add(result);
				jump = true;
				result = "";

			} else {
				if (jump == true) {
					jump = false;
					StartIndex = i;
				}
				jump = false;
				result = result + ObjectCodeList.get(i);
			}
		}
		// write
		if (Source.Literals.size() != 0) {
			Indexes.add(ProgramList.get(StartIndex));
			EndIndex = Integer.parseInt(ProgramList.get(StartIndex), 16) + (Source.Literals.size() * 3);
			Indexes.add(Integer.toHexString(EndIndex));
			obj.add(result);
		}
		WriteInObjCode(ArrayOfFourOutputs, ProgramList, Indexes, obj);
		return;
	}

	private void WriteInObjCode(ArrayList<ArrayList<String>> ArrayOfFourOutputs, ArrayList<String> ProgramList,
			ArrayList<String> Indexes, ArrayList<String> obj)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter writer = new PrintWriter("ObjFile.txt", "UTF-8");
		writer.println(Header(ArrayOfFourOutputs, ProgramList));
		for (int i = 0; i < obj.size(); i++) {
			int address1 = Integer.parseInt(Indexes.get(2 * i), 16);
			int address2 = Integer.parseInt(Indexes.get((2 * i) + 1), 16);
			int value = address2 - address1;
			writer.println("T" + FixIntegarToHexaDecimal(address1) + FixIntegarToHexaDecimal(value) + obj.get(i));
		}
		writer.println(End(ArrayOfFourOutputs, ProgramList));
		writer.close();
	}

	private boolean checkSizeNumber(String ll) {
		if (ll.length() > 0 && ll.length() < 3) {
			return true;
		}
		return false;
	}

	public void updateCodeForLiteralOperand(ArrayList<ArrayList<String>> ArrayOfFourOutputs,
			ArrayList<String> ArrayList, ArrayList<String> objectList, ArrayList<String> ProgramList, int LastPC,
			Map<String, Integer> InstructionsMap, Map<String, String> Opcodes, int limit) {

		updatePCForliterals(ArrayOfFourOutputs, LastPC, ProgramList, ArrayList, objectList, limit);
		for (int i = 0; i < limit; i++) {

			if (ArrayOfFourOutputs.get(i).size() == 0 || checkliterals(ArrayOfFourOutputs.get(i).get(2), i) == false) {
				continue;
			} else {
				int indexOfPCForLiterals = Source.literalsIndex.get(ArrayOfFourOutputs.get(i).get(2));
				String code = updateLitForInstruction(ProgramList.get(indexOfPCForLiterals), ProgramList.get(i),
						ArrayOfFourOutputs.get(i), i, InstructionsMap, Opcodes);
				objectList.set(i, code);
			}
		}
	}

	private String updateLitForInstruction(String PC, String range, ArrayList<String> FourOutputs, int index,
			Map<String, Integer> InstructionsMap, Map<String, String> Opcodes) {
		boolean p = false, b = false, n = false, i = false, x = false, e = false;
		if (InstructionsMap.get(FourOutputs.get(1)) == 3) {
			n = true;
			i = true;
			p = true;
			String Code = Opcodes.get(FourOutputs.get(1));
			int TA = Integer.parseInt(PC, 16) - (Integer.parseInt(range, 16) + 3);
			Code = Code + n + i + x + b + p + e + intToBinary(TA, 12);
			return (BintoHex(Code.replace("true", "1").replace("false", "0"), 3));
		} else {
			n = true;
			i = true;
			e = true;
			String Code = Opcodes.get(FourOutputs.get(1));
			int TA = Integer.parseInt(PC, 16);
			Code = Code + n + i + x + b + p + e + intToBinary(TA, 20);
			return (BintoHex(Code.replace("true", "1").replace("false", "0"), 4));
		}

	}

	private String OpcodeLiteral(String Literal, int index) {
		ArrayList<String> details = SetUpLiterals(Literal);
		if (details.get(0).equalsIgnoreCase("W")) {
			String number = Integer.toHexString(Integer.parseInt(details.get(1)));
			if (number.length() > 7) {
				Source.Errortable.put(index, "Invalid Size for the Literal");
				return "";
			}
			return FixStringToHexaDecimal(number);
		} else if (details.get(0).equalsIgnoreCase("X")) {
			if (details.get(1).length() > 7) {
				Source.Errortable.put(index, "Invalid Size for Literal");
				return "";
			}
			return FixStringToHexaDecimal(details.get(1));
		} else {
			String Code = "";
			System.out.println(details);
			for (int k = 0; k < details.get(1).length(); k++) {
				Code = Code + BintoHex(Integer.toBinaryString((int) details.get(1).charAt(k)), 2);
			}
			System.out.println(Code);
			if (Code.length() > 7) {
				Source.Errortable.put(index, "Invalid Size For Literals");
				return "";
			}
			return FixStringToHexaDecimal(Code);
		}
	}

}
