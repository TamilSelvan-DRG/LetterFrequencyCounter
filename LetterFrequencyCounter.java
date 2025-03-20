package assignment013;
import java.util.Scanner;

public class LetterFrequencyCounter {
	Scanner scan =new Scanner(System.in);
	String sentence; 
	int[] alphabets = new int[26];
	int[] alphabetsCount = new int[26];
	int countOfLetters =0;
	public LetterFrequencyCounter() {
		sentence = getInput();
	}
	public static void main(String [] args) {
		LetterFrequencyCounter obj = new LetterFrequencyCounter();
		int lettersLength = obj.arrLengtht(obj.sentence);
		int[] letters=new int[lettersLength];
		int[] countLetters= new int[lettersLength];
		obj.letterCounters(obj.sentence,letters,countLetters);
		obj.matchAlpCount(letters,countLetters);
		obj.count(countLetters);
		System.out.print("1. Only letters that are given\n2. Through all\nEnter Your option: ");
		int exist = obj.scan.nextInt();
		System.out.println();
		if(exist==2) {
			obj.printingOutput(obj.alphabets,obj.alphabetsCount );
		}else {
			obj.printingOutput(letters, countLetters);
		}
		
	}
	public String getInput() {
		String input ="";
		System.out.println("Enter the text here.....\ntype :wq to exit");
		while (true) {
			String line = scan.nextLine();
			if(line.equals(":wq")){
				break;
			}
			input += line+"\n";
		}
		input = input.toLowerCase().trim();
		return input;
	}
	public void printingOutput(int[] alpha, int[] count) {
		while(true) {
			System.out.println("1. Ascending Order by Abc \n2. Descending Order by Abc\n3.Ascending by count\n4.Descending by count");
			System.out.print("Enter Your Option: ");
			int order = scan.nextInt();
			scan.nextLine();
			System.out.println();
			if(order == 2) {
				order(alpha,count,false);
			}else if(order ==3) {
				order(count,alpha,true);
			}else if(order ==4) {
				order(count,alpha,false);
			}else {
				order(alpha,count,true);
			}
			printOutput(alpha,count);
			System.out.print("Wanna see in another order(Y/n): ");
			String flag = scan.nextLine();
			if(flag.equals("n")||flag.equals("N")) {
				break;
			}			
		}
	}
	public void count(int[] countLetters) {
		for(int elements: countLetters) {
			countOfLetters+=elements;
		}
	}
	public void printArrValues(int[] input) {
		System.out.print("{");
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+ ((i==input.length-1)?("}"):(",")));
		}
		System.out.println();
	}
	public int arrLengtht(String sentence) {
		String repeatLetters ="";
		for(int i=0;i<sentence.length();i++) {
			int ch = sentence.charAt(i);
			String c ="";
			c+=(char)(ch);
			int count =1;
			if(repeatLetters.contains(c) || (((char)(ch))==' ') ||(((char)(ch))=='\n')){
				continue;
			}
			repeatLetters+=(char)(ch);
//			for(int j=i+1;j<sentence.length();j++) {
//				if(((char)(ch)==(sentence.charAt(j)))){
//					count++;
//				}
//			}
		}
		return repeatLetters.length();
	}
	public void letterCounters(String sentence, int[] letters, int[] countLetters) {
		int index=0; 
		String repeatLetters ="";
		for(int i=0;i<sentence.length();i++) {
			int ch = sentence.charAt(i);
			String c ="";
			c+=(char)(ch);
			int count =1;
			if(repeatLetters.contains(c) || (((char)(ch))==' ') ||(((char)(ch))=='\n')){
				continue;
			}
			repeatLetters+=(char)(ch);
			for(int j=i+1;j<sentence.length();j++) {
				if(((char)(ch)==(sentence.charAt(j)))){
					count++;
				}
			}
			letters[index]=ch;
			countLetters[index]=count;
			index++;
		}
	}
	public void order(int[] orderArr, int[] pairArr, boolean flag ) {
		for(int i=0; i<orderArr.length;i++) {
			int min = orderArr[i];
			for(int j=i+1;j<orderArr.length;j++) {
				int max = orderArr[j];
				if(flag) {
					if(min>max) {
						orderArr[j]=min;
						orderArr[i]=max;
						int temp = pairArr[i];
						pairArr[i]=pairArr[j];
						pairArr[j]=temp;
						min = max;				
					}
				}else {
					if(min<max) {
						orderArr[j]=min;
						orderArr[i]=max;
						int temp = pairArr[i];
						pairArr[i]=pairArr[j];
						pairArr[j]=temp;
						min = max;			
					}
				}
			}
		}
	}
	public boolean isPresent(int[] letters,int num) {
		for(int element  : letters) {
			if(element==num) {
				return true;
			}
		}
		return false;
	}
	public void matchAlpCount(int[] letters , int[] count) {
		int ch =97;
		int index =0;
		for(int i=0; i<alphabets.length;i++) {
			if(index<letters.length && letters[index]!=0) {
				alphabets[i] = letters[i];
				alphabetsCount[i]=count[i];
				index++;
			}
			else {
				while(true) {
					if(isPresent(letters , ch)) {
						ch++;
					}else {
						break;
					}
				}
				alphabets[i] = (char)(ch);
				alphabetsCount[i] =0;
				ch++;
			}
		}
	}
	public void printOutput(int[] letters, int[] count) {
		System.out.println("----------------------------------------------------");
		System.out.println("| Letter       |   Occurrences      |   Percentage ");
		System.out.println("----------------------------------------------------");
		for(int i=0;i<letters.length;i++) {
			System.out.println("|  "+(char)(letters[i])+"           |    "+count[i]+"               |    "+((float)((count[i])*100)/countOfLetters)+"% ");
		}
		System.out.println("----------------------------------------------------");
	}
	
}





















//public void printOutput(int[] letters, int[] count) {
//	int index1 =0;
//	int index2 =0;
//	int alph =97;
//	int total = letters.length;
//	System.out.println("Letter          Occurrences         Percentage");
//	for(int i=0;i<letters.length;i++) {
//		if(index1<letters.length && letters[index1] !=0) {
//			System.out.println(" "+(char)(letters[index1])+"               "+count[index1]+"                    "+(((count[index])*100)/total)+"%");
//			index1++;
//		}else {
//			System.out.println(" "+(char)()+"               "+0+"                    "+((0*100)/total)+"%");
//			alph++;
//		}
//		System.out.println(" "+(char)(letters[i])+"               "+count[i]+"                    "+((float)((count[i])*100)/countOfLetters)+"%");
//	}
//}

//obj.printArrValues(obj.alphabets);
//obj.printArrValues(obj.alphabetsCount);
//obj.order(obj.alphabetsCount, obj.alphabets,true);
//obj.printArrValues(obj.alphabets);
//obj.printArrValues(obj.alphabetsCount);



