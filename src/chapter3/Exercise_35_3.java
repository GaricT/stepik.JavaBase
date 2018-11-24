package chapter3;

import java.util.Arrays;

interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

public class Exercise_35_3 {
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label result = Label.OK;
        for (TextAnalyzer mtd: analyzers) {
            result = mtd.processText(text);
            if (result != Label.OK) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
// инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};

        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(Exercise_35_3.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }    }
}

// Код для грейдера


abstract class KeywordAnalyzer implements TextAnalyzer{
    abstract protected String[] getKeywords();
    abstract protected Label getLabel();

    public Label processText(String text){
        return Arrays.stream(getKeywords()).anyMatch(text::contains) ? getLabel() : Label.OK;
    }
}

class SpamAnalyzer extends KeywordAnalyzer {
    private String[] keywords; // массив строк с ключевыми словами

    public SpamAnalyzer(String[] args){
        this.keywords = args;
    }

    protected String[] getKeywords(){
        return keywords;
    }

    protected Label getLabel(){
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer{
    protected String[] getKeywords(){
        return new String[]{":(", "=(", ":|"};
    }

    protected Label getLabel(){
        return Label.NEGATIVE_TEXT;
    }
}

class TooLongTextAnalyzer implements TextAnalyzer{
    private int maxLength; // максимальная длиная комментария

    public TooLongTextAnalyzer(int MaxLength){
        this.maxLength = MaxLength;
    }

    public Label processText(String text){
        return (text.length() > maxLength) ? Label.TOO_LONG : Label.OK;
    }
}
