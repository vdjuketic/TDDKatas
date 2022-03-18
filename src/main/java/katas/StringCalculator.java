package katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Kata link -> https://osherove.com/tdd-kata-1/
public class StringCalculator {

	private static final String regexSpecialChars = "[\\[+\\]+:{}^~?\\\\/()><=\"!*]";

	public int add(String text){
		if(text.equals(""))
			return 0;

		List<String> numbers = split(text);

		List<Integer> positiveNumbers = filterPositiveNumbers(numbers);

		return positiveNumbers.stream()
		                .mapToInt(Integer::intValue)
		                .filter(number -> number < 1000)
		                .sum();
	}

	private static List<String> split(String text) {
		if(text.startsWith("//[")){
			return splitByCustomDelimiterFromRegex(text, "//\\[(.*)]\n(.*)");

		} else if(text.startsWith("//")){
			return splitByCustomDelimiterFromRegex(text, "//(.)\n(.*)");
		}

		return Arrays.asList(text.split(",|\n"));
	}

	private static List<String> splitByCustomDelimiterFromRegex(String text, String regex) {
		Matcher matcher = Pattern.compile(regex)
		                         .matcher(text);
		matcher.matches();

		String delimiter = matcher.group(1).replaceAll(regexSpecialChars, "\\\\$0");
		String numbers = matcher.group(2);

		return Arrays.asList(numbers.split(delimiter));
	}

	private static List<Integer> filterPositiveNumbers(List<String> numbers) {
		List<Integer> positives = new ArrayList<>();
		List<Integer> negatives = new ArrayList<>();

		numbers.stream().mapToInt(Integer::parseInt).forEach(number -> (number > 0 ?
				positives : negatives).add(number));

		if(negatives.size() > 0){
			throw new RuntimeException("negatives not allowed: " + Arrays.toString(negatives.toArray()));
		}

		return positives;
	}
}
