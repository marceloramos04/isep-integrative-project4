package jobOpening.InterviewModelSelector;

import org.springframework.stereotype.Component;
import utils.Utils;
@Component
public class InterviewModelSelectorUI implements Runnable {


    @Override
    public void run() {

        int choice = Utils.readIntegerFromConsole("Select Interview Model:\nOPTIONS:\n1-TrueFalseQuestion\n2-ShortTextQuestion\n3-MultipleChoiceQuestion\n4-IntegerQuestion\n5-DecimalQuestion\n6-DateQuestion\n7-TimeQuestion\n8-NumericScaleQuestion\n\nEnter the number of the model you want to select: ");
        String selectedModel;
        switch (choice) {
            case 1:
                selectedModel = "Model trueFalseQuestion";
                break;
            case 2:
                selectedModel = "Model shortTextQuestion";
                break;
            case 3:
                selectedModel = "Model multipleChoiceQuestion";
                break;
            case 4:
                selectedModel = "Model integerQuestion";
                break;
            case 5:
                selectedModel = "Model decimalQuestion";
                break;
            case 6:
                selectedModel = "Model dateQuestion";
                break;
            case 7:
                selectedModel = "Model timeQuestion";
                break;
            case 8:
                selectedModel = "Model numericScaleQuestion";
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                return;
        }

        System.out.println("Selected Model: " + selectedModel);
        // Aqui você pode continuar com o código para processar o modelo selecionado

    }
}
