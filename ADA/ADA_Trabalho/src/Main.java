import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String fristLine = input.readLine();
		String secondLine = input.readLine();

		boolean allLetters = fristLine.chars().allMatch(Character::isLetter);
		boolean allLetters2 = secondLine.chars().allMatch(Character::isLetter);

		if ((allLetters2) && (allLetters)) {

			if ((fristLine.length() < 98) || (secondLine.length() < 98)) {
				LongestComonSequence prob;
				if (fristLine.compareTo(secondLine) <= 0) {
					prob = new LongestComonSequence(((" " + fristLine).toCharArray()),
							(" " + secondLine).toCharArray());
				} else
					prob = new LongestComonSequence(((" " + secondLine).toCharArray()),
							(" " + fristLine).toCharArray());

				System.out.println(prob.getMaxSeq());
				if (prob.getMaxSeq() > 0)
					System.out.println(prob.getLongestCSeq());
			} else System.out.println("0");
				;
		} else
			System.out.println("0");

		// xxabABxxcdCDefEF
		// ABxyabCDxycdEFef

	}
}
