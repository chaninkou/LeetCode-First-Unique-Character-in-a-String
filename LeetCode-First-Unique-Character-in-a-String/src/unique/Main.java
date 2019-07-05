package unique;

public class Main {
	public static void main(String[] args){
		String input = "loveleetcode";
		
		System.out.println("Input: " + input);
		
		System.out.println("Output: " + firstUniqChar(input));
		
	}
    public static int firstUniqChar(String s) {
        int freq [] = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            freq [s.charAt(i) - 'a'] ++;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(freq [s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
