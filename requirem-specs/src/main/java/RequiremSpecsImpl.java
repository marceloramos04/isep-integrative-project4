import gen.JobRequirementsLexer;
import gen.JobRequirementsParser;
import org.antlr.v4.runtime.*;
import requirem_specs.RequiremSpecs;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;

public class RequiremSpecsImpl implements RequiremSpecs {

    public static String configFile = "";

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
    public boolean evaluateFile(String configFile, String inputFile) {

        RequiremSpecsImpl.configFile = configFile;

        ParseTree tree = parseFile(inputFile);
        if (tree == null) {
            return false;
        }

        return processWithListener(tree);
    }

    public ParseTree parseFile(String inputFile) {

        ErrorListener errorListener = new ErrorListener();

        try {
            JobRequirementsLexer lexer = new JobRequirementsLexer(CharStreams.fromFileName(inputFile));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JobRequirementsParser parser = new JobRequirementsParser(tokens);
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

    public boolean processWithListener(ParseTree tree) {
        ParseTreeWalker walker = new ParseTreeWalker();
        EvalListener listener = new EvalListener();
        walker.walk(listener, tree);
        System.out.println("Result with Listener:\n");
        return listener.getResult();
    }
}
