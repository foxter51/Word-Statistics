import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Set text: ");
        String text = in.nextLine();

        System.out.print("Set history: ");
        String history = in.nextLine();

        WordStatistics wordStatistics = new WordStatistics(text, history);

        System.out.print("Enter the initial number of words: ");
        int wordsNumber = in.nextInt();

        System.out.println("Word Counts:");

        String[][] initWords = wordStatistics.countInitWords(wordsNumber);
        for (int i = 0; i < wordsNumber; i++) {
            System.out.println(initWords[i][0] + " " + initWords[i][1]);
        }
        System.out.println("Total words count: " +WordStatistics.totalWordCount);

        wordStatistics.longestSentence();
        System.out.println("Longest sentence length: " +WordStatistics.longestSentenceLength);

        System.out.println("Age of text: " +wordStatistics.textAge());
    }
}
