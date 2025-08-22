package jobOpening.closePhase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.Utils;

import java.sql.Struct;

@Component
public class ClosePhaseUI implements Runnable{

    @Autowired
    private ClosePhaseController closePhaseController;

    @Override
    public void run() {

        //to do part of getting user Id to select job openings for the user
        if (closePhaseController.getJobOpeningsWithActivePhases().isEmpty()) {
            System.out.println("No available job openings with active phases\n\nExiting close phase...\n");
            return;
        }

        System.out.println("Entering Close Phase UI\n \n Listing job opening with active phases");
        int input;
        boolean isValidInput = false;
        while (!isValidInput){

            input = Utils.showAndSelectIndex(closePhaseController.getJobOpeningsWithActivePhases(), "Select a job opening to close its active phase :") + 1;
            switch (input){
                case 0:
                    System.out.println("Exiting close phase...");
                    isValidInput = true;
                    break;
                default:
                    if (closePhaseController.jobOpeningExists(input)){
                        System.out.println(closePhaseController.closePhase(input) + "\n\nExiting close phase...");
                        isValidInput = true;
                        break;
                    } else {
                        System.out.println("Invalid option, please select a valid job opening number\n");
                    }
            }

        }




    }

}
