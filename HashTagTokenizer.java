

public class HashTagTokenizer {

	public static void main(String[] args) {

		if(args.length == 0)
		return;

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		int index = 0; 
		while(in.hasNextLine() && index < 3000) {
			dictionary[index] = in.readLine(); 
			index++;
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		// #feedback - dictionary[i] should not be null. If you want to check it, please do so inside the loop. Otherwise, in case of null the loop will end.
		for(int i = 0; i < dictionary.length && dictionary[i] != null; i++) { 
			if(dictionary[i].equals(word)){
			return true; 
		}
		}	
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
		// #feedback - you should use toLowerCase to be case-insensitive.
			String curString = hashtag.substring(0, i);
			if(existInDictionary(curString, dictionary)){
				System.out.println(curString);
				breakHashTag(hashtag.substring(i), dictionary);
				// #feedback - you should break from the loop here.
			}
		
        }
    }

}
