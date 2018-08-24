import java.util.*;
import java.io.*;
//import java.lang.*;

public class PassWord{
	private static final List<Character> vowel = new ArrayList<>(
		Arrays.asList('a', 'e', 'i', 'o', 'u'));
	private List<String> passwords;
	private List<Boolean> results;
	public PassWord(){
		passwords = new ArrayList<>();
		results = new ArrayList<>();
	}

	private boolean isAcctable(String s){
		if(s == null || s.length() == 0) return false;

		boolean one_vowel = false;
		int three_con = 0;
		int three_vow = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if (vowel.contains(c)){
				three_con = 0;
				one_vowel = true; // rule #1
				three_vow ++;
				if(three_vow == 3) return false; // rule #2
			}else{
				three_vow = 0;
				three_con++;
				if(three_con == 3) return false; // rule #2
			}
			if(i != 0){
				if(c == s.charAt(i-1) && c != 'e' && c != 'o'){
					return false; // rule # 3
				}
			}
		}

		return one_vowel;
	}

	public void readInput() throws IOException{
		
		try(Scanner sc = new Scanner(new File("test.input"))){
			while(sc.hasNext()){
				String line = sc.next();
				//System.out.println(line);
				passwords.add(line);
			}
		} catch (FileNotFoundException fe){
			System.out.println("No such file!");
			
		}

		if(passwords == null || passwords.size() == 0 ||
			!passwords.get(passwords.size()-1).equals("end")){
			throw new RuntimeException("No end sign!");
		}
	}

	public void outPut() throws IOException{
		try(PrintStream ps = new PrintStream("test.output")){
			for(String s : passwords){
				if(s.equals("end")) break;
				if(isAcctable(s)){
					ps.println("<" + s + ">" + " is acceptble.");
				}else{
					ps.println("<" + s + ">" + " is not acceptble.");
				}
				
			}
		} catch (FileNotFoundException fe){
			System.out.println("File not Found!");
		}

	}

	public static void main(String[] args){
		PassWord ps = new PassWord();

		try{
			System.out.println("Reading input file...");
			ps.readInput();
			ps.outPut();
			System.out.println("Done!");
		} catch (RuntimeException re){
			System.out.println("Invalid input!");
		} catch (IOException ie){
			System.out.println("IOException!");
		}
	}
}