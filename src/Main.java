import analyzers.lexical.LexicalAnalyzer;
import components.token.Token;
import analyzers.syntactic.SyntacticAnalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Analyzers
        LexicalAnalyzer la = new LexicalAnalyzer();
        SyntacticAnalyzer sa = new SyntacticAnalyzer();
        List<String> fileContent = new ArrayList<>();
        // Datastructures
        List<Token> tokensList = new LinkedList<>();
        // variables
        int lineNumber = 0;
        boolean isString = false;
        // File
        String sourceFileName = "src/resources/input/test2.lev";
        String lexicalFileName = "src/resources/output/output.csv";
        File file = new File(sourceFileName);
        Scanner sc = new Scanner(file);

        while(sc.hasNext()) {
            String line = sc.nextLine();
             la.analyzer(line, tokensList, ++lineNumber, isString);
             fileContent.add(line);
        }
        sc.close();

        // Save result in csv file
        saveLexicalResults(lexicalFileName, tokensList);

        for (Token t: tokensList) {
            System.out.println(t.getType().getValue() + " " + t.getType().name() + " " + t.getValue() + " " + t.getLine());
        }

        System.out.println("\n\n-----------------------\n\n");

        sa.analyzer(tokensList, fileContent);
    }

    static private void saveLexicalResults (String filename, List<Token> tokensList) throws IOException {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(new FileWriter(file));

        // headers
        writer.println("Line,Token code,Token name,Value");

        // data
        for (Token t: tokensList) {
            // avoid conflicts with file's delimiter ","
            String val = t.getValue();
            if (val.equals(",")) {
                val = "\\comma";
            }
            writer.println(t.getLine() + "," + t.getType().getValue() + "," + t.getType().name() + "," + val);
        }
        writer.close();
    }
}
