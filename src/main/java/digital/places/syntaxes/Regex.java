package digital.places.syntaxes;

import java.util.regex.*;
public class Regex {

	private static final String regex = "[a-zA-Z\\d[$%#@*]]+";

	public static void main (String[] args) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = 
			pattern.matcher("IN123S@#$%ERT* ()!");
		boolean found = false;
		while (matcher.find()) {
			System.out.println(
			 "Found "+matcher.group());
		}
	}
}
