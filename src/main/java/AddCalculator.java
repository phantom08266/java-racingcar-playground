import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {

    public int calculate(String text) {
        if (isEmptyText(text)) return 0;

        Matcher customSplitMatcher = getCustomSplitMatcher(text);
        if (customSplitMatcher.find()) {
            return customAdd(customSplitMatcher);
        }

        return basicAdd(text);
    }

    private Matcher getCustomSplitMatcher(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private int customAdd(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);
        return add(tokens);
    }

    private int basicAdd(String text) {
        String[] numbers = text.split(",|:");
        return add(numbers);
    }

    private int add(String[] numbers) {
        validMinusNumberContains(numbers);

        int total = 0;
        for (String number : numbers) {
            total += Integer.parseInt(number);
        }

        return total;
    }

    private boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    private void validMinusNumberContains(String[] numbers) {
        long count = Arrays.stream(numbers)
                .filter(parseInt())
                .count();

        if (count > 0) {
            throw new IllegalArgumentException("음수값은 연산할 수 없습니다.");
        }
    }

    private Predicate<String> parseInt() {
        return s -> {
            try{
                return Integer.parseInt(s) < 0;
            } catch (RuntimeException ex) {
                throw new IllegalArgumentException("특수 문자는 연산할 수 없습니다. 숫자를 입력하세요!");
            }
        };
    }
}
