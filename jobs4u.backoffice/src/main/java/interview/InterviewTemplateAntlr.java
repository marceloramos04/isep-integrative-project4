package interview;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class InterviewTemplateAntlr implements Runnable {

    @Override
    public void run() {

        try {

            CharStream charStream = CharStreams.fromFileName("docs/interview_files/example1.txt");

            interview.InterviewTemplateLexer lexer = new interview.InterviewTemplateLexer(charStream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            interview.InterviewTemplateParser parser = new interview.InterviewTemplateParser(tokens);

            parser.start();

            System.out.println("Done!");

        } catch (IOException e) {

            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
