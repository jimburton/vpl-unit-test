import java.util.Formatter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        MyTest t = new MyTest();
        int grade = 0;
        try {
            t.testOne(); //worth 50 marks
            System.out.println(formatOutput("Test One", "50", null));
            grade += 50;
        } catch (AssertionError e) {
            System.out.println(formatOutput("Test One", "50", e));
        }
        try {
            t.testTwo(); //worth 50 marks
            System.out.println(formatOutput("Test Two", "50", null));
            grade += 50;
        } catch (AssertionError e) {
            System.out.println(formatOutput("Test Two", "50", e));
        }
        System.out.println("Grade :=>> "+grade);
    }

    private static String formatOutput(String testName, String value, AssertionError e) {
        StringBuilder sb = new StringBuilder();
        Formatter f = new Formatter(sb, Locale.getDefault());
        String grade = (e == null ? value : "0");
        f.format("Comment :=>> %s: %s. %s marks\n", testName, (e == null ? "success" : "failure"), grade);
        if (e != null) {
            f.format("<|-- \n%s\n --|>\n", e.getMessage());
        }
        return sb.toString();
    }
}
