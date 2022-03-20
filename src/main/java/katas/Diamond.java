package katas;

public class Diamond {

	private static final int ASCII_OFFSET = 65;

	public String draw(char letter) {
		if(letter == 'A')
			return "A";

		StringBuilder result = new StringBuilder();
		appendTopHalf(result, letter);
		appendBottomHalf(result, letter);

		return result.toString();
	}

	private void appendBottomHalf(StringBuilder result, char letter) {
		int startWhitespaces = 0;
		char currentLetter = letter;
		for (int i = letter; i >= ASCII_OFFSET; i--) {
			appendLine(result, startWhitespaces, currentLetter);

			if(i > ASCII_OFFSET) {
				result.append("\n");
				startWhitespaces++;
				currentLetter--;
			}
		}
	}

	private void appendTopHalf(StringBuilder result, char letter) {
		int startWhitespaces = getAlphabetPosition(letter);
		char currentLetter = ASCII_OFFSET;
		for (int i = ASCII_OFFSET; i < letter; i++) {
			appendLine(result, startWhitespaces, currentLetter);

			result.append("\n");
			startWhitespaces--;
			currentLetter++;
		}
	}

	private void appendLine(StringBuilder result, int startWhitespaces, char letter) {
		appendWhitespaces(result, startWhitespaces);
		result.append(letter);
		appendWhitespaces(result, getNthOddNumber(getAlphabetPosition(letter)));
		appendSecondChar(result, letter);
	}

	private void appendSecondChar(StringBuilder result, int currentLetterAscii) {
		if (getNthOddNumber(currentLetterAscii - ASCII_OFFSET) > 0)
			result.append((char)currentLetterAscii);
	}

	private void appendWhitespaces(StringBuilder builder, int whitespaces){
		builder.append(" ".repeat(Math.max(0, whitespaces)));
	}

	private int getNthOddNumber(int n){
		return 2 * n - 1;
	}

	private int getAlphabetPosition(char letter){
		return letter - ASCII_OFFSET;
	}
}
