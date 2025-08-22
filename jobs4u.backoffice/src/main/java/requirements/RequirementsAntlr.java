package requirements;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequirementsAntlr implements Runnable {

    @Override
    public void run() {

        try {

            CharStream charStream = CharStreams.fromFileName("docs/requirements_files/test-file.txt");

            requirements.RequirementsLexer lexer = new requirements.RequirementsLexer(charStream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            requirements.RequirementsParser parser = new requirements.RequirementsParser(tokens);

            parser.start();

            System.out.println("Done!");

        } catch (IOException e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
