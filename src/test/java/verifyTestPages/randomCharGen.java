package verifyTestPages;

import java.util.Random;

public class randomCharGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int c = r.nextInt(26) + (byte)'a';
		System.out.println((char)c);
		
		char randomLetter = (char) ('a' + Math.random() * ('z'-'a' + 1));
		System.out.println(randomLetter);
		
		System.out.println( (char)(Math.random()*26 + 'a'));

	}

}
