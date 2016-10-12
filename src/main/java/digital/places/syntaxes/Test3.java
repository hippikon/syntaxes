package digital.places.syntaxes;

import java.util.*;
public class Test3 {

	private static final String sentence = "this is a big long sentence, and this is not this is a big long sentence, this is a big long sentence this is a big long sentence ";

	/*
	Complexity analysis

	10, 1 dupe at position 2 and 5
	1+4*1+5*1*2 = 11

	20, 2 dupes at /2,3 and 10/5 and 15
	1 + 1*2 + 8*2*2 +
	*/
	public static void main (String[] args) {
		findWords(sentence);
	}

	public static void findWords(String input)
	{
		List<String> output = new LinkedList<String>();
		List<String> dupes = new LinkedList<String>();
		StringTokenizer str = new StringTokenizer(input);

		while (str.hasMoreElements()) {
			String next = (String) str.nextElement();
			if (output.contains(next)) {
				if (!dupes.contains(next)) {
					System.out.println("Duplicate "+next);
				}
				dupes.add(next);
			} else {
				output.add(next);
			}
		}
	}
}