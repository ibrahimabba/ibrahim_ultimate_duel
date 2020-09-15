import java.io.File;
import java.io.IOException;
import java.util.*;

public class EmailLogsHistogram {
    public static void main(String[] args) {
        File sourcefile = new File("C:\\Users\\Abba\\Desktop\\Java Stuffs\\mbox-short.txt");
        List<String> result = new ArrayList<>();
        Map<String, Integer> histoGram = new HashMap();
        String content = "";
        Scanner scanner;

        try {
            scanner = new Scanner(sourcefile);
            while (scanner.hasNextLine()) {
                content += scanner.nextLine() + "\n";
            }
            scanner.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Something went wrong! " + e);
        }
        String contentWithoutWhiteSpace = content.replaceAll("\\s+", ""); // Eliminate all white space

        char[] contentCharArray = contentWithoutWhiteSpace.toCharArray(); // converts string to character array

        for (int i = 0; i < contentCharArray.length - 1; i++) {
            String accumulated = "";
            //check to see if character at the current index and the one after contains "by", and also if the next character after "by" is S
            if ((String.valueOf(contentCharArray[i]).toLowerCase() + String.valueOf(contentCharArray[i + 1]).toLowerCase()).equals("by") && !String.valueOf(contentCharArray[i + 2]).equals("S")) {

                //accumulated is a reference to the next 27 characters after string "by"
                for (int j = 2; j < 39; j++) {
                    accumulated += String.valueOf(contentCharArray[i + j]);
                }

                char[] accumulatedInArray = accumulated.toCharArray();
                char[] temp = new char[29];
                for (int j = accumulatedInArray.length - 1; j > 1; j--) {
                    if ((String.valueOf(accumulatedInArray[j - 1]).toLowerCase() + String.valueOf(accumulatedInArray[j]).toLowerCase()).equals("uk")) {
                        for (int k = j; k >= 0; k--) {
                            temp[k] = accumulatedInArray[k];
                        }
                    }
                    if ((String.valueOf(accumulatedInArray[j - 2]).toLowerCase() + String.valueOf(accumulatedInArray[j - 1]).toLowerCase() + String.valueOf(accumulatedInArray[j]).toLowerCase()).equals("edu")) {
                        for (int k = j; k >= 0; k--) {
                            temp[k] = accumulatedInArray[k];
                        }
                    }

                }
                result.add(String.valueOf(temp));
            }

        }
        result.forEach(item -> {
            if (histoGram.containsKey(item)) {
                int val = histoGram.get(item);
                histoGram.put(item, val + 1);
            } else {
                histoGram.put(item, 1);
            }
        });

        for (Map.Entry m : histoGram.entrySet()) {
            System.out.println(m.getKey() + "  occurred  " + m.getValue() + "  times");

        }

    }
}

