import gen.IntervModelLexer;
import gen.IntervModelParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import requirem_specs.IntervModel;

import java.io.File;
import java.io.IOException;

public class IntervModelImpl implements IntervModel {

    public static String configFile;


    @Override
    public boolean validateFileSyntax(String inputFile) {

        return parseFile(inputFile)!=null;
    }

    @Override
    public void generateTemplate(String configFile, String outputFile) {
        new TemplateGenerator().generateTemplate(configFile, outputFile);
        System.out.printf("Template generated successfully as: '%s'\n\n", new File(outputFile).getAbsolutePath());
    }

    @Override
    public double evaluateFile(String configFile, String inputFile) {

        IntervModelImpl.configFile = configFile;

        ParseTree tree = parseFile(inputFile);
        if (tree == null) {
            return -1;
        }

        return processWithListener(tree);
    }

    public ParseTree parseFile(String inputFile) {

        ErrorListener errorListener = new ErrorListener();

        try {
            IntervModelLexer lexer = new IntervModelLexer(CharStreams.fromFileName(inputFile));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            IntervModelParser parser = new IntervModelParser(tokens);
            parser.addErrorListener(errorListener);
            ParseTree tree=parser.start();

            if (!errorListener.hasErrors()){
                return tree;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public double processWithListener(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        EvaluationListener listener = new EvaluationListener();
        walker.walk(listener, tree);
        System.out.println("Result with Listener:\n");
        return listener.getGrade();
    }
}
