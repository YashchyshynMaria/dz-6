import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<String> getSymbols(List<String> listOfRows) {
        List<String> words = new ArrayList<>();
        String stringOfDistinctChars = "";
        for (int i = 0; i < listOfRows.size(); i++) {
            int countOfChar = 0;
            String row = listOfRows.get(i);
            for (char symbolOfRow : row.toCharArray()) {
                long count = listOfRows
                        .get(i)
                        .chars()
                        .filter(symbol -> symbol == symbolOfRow)
                        .count();
                if (count % 2 == 0) {
                    countOfChar++;
                }
            }
            if (countOfChar == row.length()) {
                words.add(row);
            }
            if (words.size() == 2) {
                break;
            }
        }
        System.out.print("Two first rows with add number of same letters" + words);
        StringBuilder builder = new StringBuilder();
        for (String value : words) {
            builder.append(value);
        }
        String text = builder.toString();
        List<String> letterArray = text.chars().distinct().mapToObj(o -> String.valueOf((char) o)).collect(Collectors.toList());
        System.out.println("\n" + "Array of letters is:" + letterArray);
        return letterArray;

    }

    public static void main(String[] args) {
        List<String> listOfRows = new ArrayList<>();
        listOfRows.add("mama");
        listOfRows.add("tata");
        listOfRows.add("daughter");
        listOfRows.add("tato");
        getSymbols(listOfRows);

    }

}
