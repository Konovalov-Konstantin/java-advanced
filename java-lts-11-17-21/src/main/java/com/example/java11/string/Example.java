package com.example.java11.string;

import java.util.List;
import java.util.stream.Collectors;


public class Example {

    /**
     repeat(int n) - возвращает строку, значение которой представляет собой конкатенацию этой строки, повторяющуюся n раз
     */
    private static void writeHeader(final String headerText) {
        final String headerSeparator = "=".repeat(headerText.length() + 4);

        System.out.println("\n" + headerSeparator);
        System.out.println(headerText);
        System.out.println(headerSeparator);
    }

    /**
    lines() - возвращает поток строк, извлеченных из текущей строки, разделенных терминаторами строк (\n, \r, \r\n)
     */
    public static void demonstrateStringLines() {
        String originalString = "Hello\nWorld\n123";

        String stringWithoutLineSeparators = originalString.replaceAll("\\n", "\\\\n");

        writeHeader("String.lines() on '" + stringWithoutLineSeparators + "'");

        originalString.lines().forEach(System.out::println);
    }

    /**
     strip() - Возвращает строку, из которой удалены все пробелы, которые находятся до первого символа и после последнего
     */
    public static void demonstrateStringStrip() {
        String originalString = "  biezhi.me  23333  ";

        writeHeader("String.strip() on '" + originalString + "'");
        System.out.println("'" + originalString.strip() + "'");
    }

    /**
    stripLeading() - Возвращает строку, из которой удалены все пробелы, которые находятся до первого символа
     */
    public static void demonstrateStringStripLeading() {
        String originalString = "  biezhi.me  23333  ";

        writeHeader("String.stripLeading() on '" + originalString + "'");
        System.out.println("'" + originalString.stripLeading() + "'");
    }

    /**
     stripTrailing() - Возвращает строку, из которой удалены все пробелы, которые находятся после последнего символа
     */
    public static void demonstrateStringStripTrailing() {
        String originalString = "  biezhi.me  23333  ";

        writeHeader("String.stripTrailing() on '" + originalString + "'");
        System.out.println("'" + originalString.stripTrailing() + "'");
    }

    /**
     isBlank() - возвращает true, если строка пуста или содержит только пробелы
     */
    public static void demonstrateStringIsBlank() {
        writeHeader("String.isBlank()");

        String emptyString = "";
        System.out.println("emptyString  -> " + emptyString.isBlank());

        String onlyLineSeparator = System.getProperty("line.separator");
        System.out.println("onlyOneSeparator     -> " + onlyLineSeparator.isBlank());

        String tabOnly = "\t";
        System.out.println("Tab only        -> " + tabOnly.isBlank());

        String spacesOnly = "   ";
        System.out.println("Space Only         -> " + spacesOnly.isBlank());
    }


    public static void lines() {
        writeHeader("String.lines()");

        String str = "Hello \n World, I,m\nbiezhi.";

        System.out.println(str.lines().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        writeHeader("User-Agent\tMozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5)");
        demonstrateStringLines();
        demonstrateStringStrip();
        demonstrateStringStripLeading();
        demonstrateStringStripTrailing();
        demonstrateStringIsBlank();
        lines();
        String multilineString = "Otus helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        lines.forEach(System.out::println);
    }
}
