public class WordStatistics {
    private final String text;
    private final String history;
    private static int totalWordCount;
    private static int longestSentenceLength;

    public WordStatistics(String text, String history) {
        this.text = text.replaceAll("[\\!|\\?]", ".").replaceAll("\\,", "");
        this.history = history;
    }

    public String[][] countInitWords(int uniqueWordsCount){
        String[][] initWords = new String[uniqueWordsCount][2];

        String[] words = text.replaceAll("\\.", "").split(" ");

        int iterator = 0;

        for(String word : words){
            if(iterator == uniqueWordsCount) break;
            if(!isContainsWord(word, initWords[0])){
                int wordOccurrences = countWordOccurrences(word, words);

                initWords[iterator][0] = word.toLowerCase();
                initWords[iterator][1] = String.valueOf(wordOccurrences);

                totalWordCount += wordOccurrences;
                iterator++;
            }
        }
        return initWords;
    }

    public int longestSentence(){
        String[] sentences = text.split("\\.");

        int maxSentenceLength = 0;
        int indexOfMax = 0;

        for (int i = 0; i < sentences.length; i++) {
            int currentLength = countSentenceLength(sentences[i]);
            if(currentLength > maxSentenceLength){
                maxSentenceLength = currentLength;
                indexOfMax = i;
            }
        }

        System.out.println("The longest sentence:" +sentences[indexOfMax] + ".");
        longestSentenceLength = maxSentenceLength;

        return maxSentenceLength;
    }

    public int textAge(){
        return 2022 - Integer.parseInt(history.substring(10, 14));
    }

    private boolean isContainsWord(String word, String[] initWords){
        for(String comparableWord : initWords){
            if(word.equalsIgnoreCase(comparableWord)) return true;
        }
        return false;
    }

    private int countWordOccurrences(String word, String[] words){
        int counter = 0;

        for(String comparableWord : words){
            if(word.equalsIgnoreCase(comparableWord)) {
                counter++;
            }
        }
        return counter;
    }

    private int countSentenceLength(String sentence){
        return sentence.split(" ").length;
    }
}
