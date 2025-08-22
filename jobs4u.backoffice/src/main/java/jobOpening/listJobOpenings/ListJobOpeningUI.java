package jobOpening.listJobOpenings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListJobOpeningUI implements Runnable {

    @Autowired
    private ListJobOpeningController listJobOpeningController;

    @Override
    public void run() {

        System.out.println("Listing Job Openings\n");

        System.out.println(listJobOpeningController.getJobOpenings());

    }
}
