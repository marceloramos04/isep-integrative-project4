import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Read the content of the test file
            String filePath = "test_template.txt";
            String inputText = Files.readString(Paths.get(filePath));

            // Create a CharStream from the input text
            CharStream input = CharStreams.fromString(inputText);

            // Create a lexer that feeds off of input CharStream
            US2003Lexer lexer = new US2003Lexer(input);

            // Create a buffer of tokens pulled from the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Create a parser that feeds off the tokens buffer
            US2003Parser parser = new US2003Parser(tokens);

            // Begin parsing at the job_opening_description rule
            ParseTree tree = parser.job_opening_description();

            // Create a visitor to traverse the parse tree
            ParseTreeWalker walker = new ParseTreeWalker();
            MyUS2003Listener listener = new MyUS2003Listener();

            // Walk the parse tree and listen for events
            walker.walk(listener, tree);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
