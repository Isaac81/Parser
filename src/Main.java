import analyzers.context.LexicalContext;
import analyzers.context.SyntacticContext;
import analyzers.lexical.LexicalAnalyzer;
import analyzers.syntactic.SyntacticAnalyzer;
import components.token.Token;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Analyzers
        LexicalAnalyzer la = new LexicalAnalyzer();
        SyntacticAnalyzer sa = new SyntacticAnalyzer();

        // Context
        LexicalContext lexicalContext = new LexicalContext();
        SyntacticContext syntacticContext = new SyntacticContext();

        // File
        String sourceFileName = "src/resources/input/test2.lev";
        String lexicalFileName = "src/resources/output/output.csv";
        File file = new File(sourceFileName);
        Scanner sc = new Scanner(file);

        // Read file and call the lexical analyzer
        while (sc.hasNext()) {
            // Get and save the next line
            String line = sc.nextLine();
            syntacticContext.getFileContent().add(line);
            lexicalContext.setLine(line);

            lexicalContext.incrementLineNumber();
            la.analyzer(lexicalContext);
        }
        sc.close();

        // Save result in csv file
        saveLexicalResults(lexicalFileName, lexicalContext.getTokensList());
        syntacticContext.setTokensList(lexicalContext.getTokensList());

        for (Token t : syntacticContext.getTokensList()) {
            System.out.println(t.getType().getValue() + " " + t.getType().name() + " " + t.getValue() + " " + t.getLine());
        }

        System.out.println("\n\n-----------------------\n\n");

        System.out.println(syntacticContext.getFileContent().size());
        sa.analyzer(syntacticContext);
    }


    static private void saveLexicalResults(String filename, List<Token> tokensList) throws IOException {
        File file = new File(filename);
        PrintWriter writer = new PrintWriter(new FileWriter(file));

        // headers
        writer.println("Line,Token code,Token name,Value");

        // data
        for (Token t : tokensList) {
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
