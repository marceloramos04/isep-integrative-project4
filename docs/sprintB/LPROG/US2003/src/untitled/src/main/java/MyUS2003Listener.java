import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MyUS2003Listener extends US2003BaseListener {
    private ParseTreeProperty<String> candidateFields = new ParseTreeProperty<>();
    private boolean jobRequirementsPrinted = false;

    @Override
    public void enterJob_opening_description(US2003Parser.Job_opening_descriptionContext ctx) {
        System.out.println("Job Opening Details:");
    }

    @Override
    public void enterJob_requirements_description(US2003Parser.Job_requirements_descriptionContext ctx) {
        if (!jobRequirementsPrinted) {
            System.out.println("Job Requirements:");
            jobRequirementsPrinted = true;
        }
    }

    @Override
    public void enterJob_requirement(US2003Parser.Job_requirementContext ctx) {
        if (ctx.DATA_FIELD() != null) {
            String dataField = ctx.DATA_FIELD().getText();
            String requirement = ctx.STRING().getText();
            System.out.println("Data Field: " + dataField + ", Requirement: " + requirement);
        } else {
            System.out.println("No data field found for job requirement");
        }
    }

    @Override
    public void enterCandidate_fields_description(US2003Parser.Candidate_fields_descriptionContext ctx) {
        System.out.println("Candidate Fields:");
    }

    @Override
    public void enterCandidate_field(US2003Parser.Candidate_fieldContext ctx) {
        String dataField = ctx.DATA_FIELD().getText();
        String fieldValue = "";
        if (ctx.EMAIL() != null) {
            fieldValue = ctx.EMAIL().getText();
        } else if (ctx.PHONE() != null) {
            fieldValue = ctx.PHONE().getText();
        } else {
            fieldValue = ctx.STRING().getText();
        }
        System.out.println("Data Field: " + dataField + ", Field Value: " + fieldValue);
    }
}
