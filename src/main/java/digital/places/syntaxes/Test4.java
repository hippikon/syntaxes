package digital.places.syntaxes;

import java.util.*;
public class Test4 {

	private static final String sentence = "this is a big long sentence, and this is not this is a big long sentence, this is a big long sentence this is a big long sentence ";

	/*
	Complexity analysis

	10, 1 dupe at position 2 and 5
	1+4*1+5*1*2 = 11

	20, dupes at /2,3 and 10/5 and 15
	1 + 1*1*1 + 1*1*3 + 7*2*3 +
	*/
	public static void main (String[] args) {
		findWords(sentence);
	}

	public static void findWords(String input)
	{
		Map<String,Integer> output = new HashMap<String,Integer>();
		StringTokenizer str = new StringTokenizer(input);

		while (str.hasMoreElements()) {
			String next = str.nextToken();
			if (output.containsKey(next)) {
				int count = output.get(next);
				count++;
				if (count == 2) {
					System.out.println("Duplicate "+next);
				}
				output.put(next,count);
			} else {
				output.put(next,1);
			}
		}
	}
}