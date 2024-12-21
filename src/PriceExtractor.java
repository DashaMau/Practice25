import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceExtractor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите текст со списками цен: ");
        String inputText = scanner.nextLine();

        extractPrices(inputText);

        scanner.close();
    }

    public static void extractPrices(String text) {
        String regex = "\\b(\\d+(?:\\.\\d{1,2})?)\\s*(USD|RUR|EUR)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        System.out.println("Найденные цены:");

        while (matcher.find()) {
            found = true;
            System.out.println(matcher.group());
        }

        if (!found) {
            System.out.println("Цены не найдены.");
        }
    }
}

