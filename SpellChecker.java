
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		String ans = ""; 
		if(str.length()==1)
		return ans; 
		else 
		ans+= str.substring(1);
		return ans; 

	}

	public static char head(String str){
		return str.charAt(0);
	}


	public static int levenshtein(String word1, String word2) {
		word1 = word1.toLowerCase(); 
		word2 = word2.toLowerCase(); 
		if(word1.length() == 0)
		return word2.length();
		if(word2.length() == 0)
		return word1.length(); 
		if(head(word1) == head(word2))
			return levenshtein(tail(word1), tail(word2)); 
		else {
		int min = Math.min(levenshtein(tail(word1), word2),Math.min(levenshtein(word1, tail(word2)),levenshtein(tail(word1), tail(word2))));
		return 1+min; 
		}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		int index = 0; 
		while (in.hasNextLine() && index < 3000 ) {
			dictionary[index] = in.readLine(); 
			index++; 
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		word = word.toLowerCase();
		int minDistance = levenshtein(word, dictionary[0]); 
		int index = 0; 
		for(int i = 1; i < 3000; i++) {
			int curDistance = levenshtein(word, dictionary[i]); 

			if(curDistance < minDistance) { 
				minDistance = curDistance; 
				index = i; 	
		} 
	}
	    if(minDistance > threshold ) 
		return word; 
		else 
		return dictionary[index];
 

		}
			


			
		
	}

