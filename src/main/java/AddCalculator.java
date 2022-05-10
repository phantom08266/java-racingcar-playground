import com.sun.tools.javac.util.StringUtils;

public class AddCalculator {

    public int calculate(String text) {
        if (isEmptyText(text)) return 0;

        int result = add(text);
        return result;
    }

    private int add(String text) {
        int total = 0;
        String[] numbers = text.split(",|:");
        for (int i = 0; i < numbers.length; i++) {
            total += Integer.parseInt(numbers[i]);
        }

        return total;
    }

    private boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }
}
