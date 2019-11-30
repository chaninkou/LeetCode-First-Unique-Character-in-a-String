package unique;

public class Main {
	public static void main(String[] args){
		String input = "loveleetcode";
		
		System.out.println("Input: " + input);
		
		FindFirstUniqueLetterFunction solution = new FindFirstUniqueLetterFunction();
		
		System.out.println("Output: " + solution.firstUniqChar(input));
		
	}
}
