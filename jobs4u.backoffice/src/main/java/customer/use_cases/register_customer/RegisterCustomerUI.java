package customer.use_cases.register_customer;

import eapli.framework.io.util.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterCustomerUI implements Runnable {

    @Autowired
    private RegisterCustomerCtrl ctrl;

    private String name;
    private String email;
    private String code;
    private String street;
    private int buildingNum;
    private String zipcode;
    private String city;
    private String password;
    private final String SEPARATOR = "====================";

    @Override
    public void run() {
        System.out.printf("%s REGISTER A CUSTOMER %s\n\n", SEPARATOR, SEPARATOR);
        name = askName();
        email = askEmail();
        code = askCustomerCode();
        askAddress();
        askPassword();
        conclude(askConfirmation());
    }

    private String askName() {
        return Console.readLine("Introduza o nome do cliente");
    }

    private String askEmail() {
        boolean validEmail = false;
        boolean uniqueEmail = false;
        String email;

        do {
            email = Console.readLine("Introduza o email do cliente");

            validEmail = ctrl.checkEmailFormat(email);
            if (!validEmail) {
                System.err.println("ERROR: Email em formato inválido");
                continue;
            }

            uniqueEmail = ctrl.isEmailUnique(email);
            if (!uniqueEmail) {
                System.err.println("ERROR: Email já atribuído a outro usuário do sistema");
                continue;
            }
        } while (!validEmail || !uniqueEmail);

        return email;
    }

    private String askCustomerCode() {
        boolean validCode = false;
        boolean uniqueCode = false;
        String code;

        do {
            code = Console.readLine("Introduza a sigla do cliente");

            validCode = ctrl.checkCustomerCodeFormat(code);
            if (!validCode) {
                System.err.println("ERROR: Sigla em formato inválido. Deve conter no máximo 10 caracteres, e começar por letras");
                continue;
            }

            uniqueCode = ctrl.isCustomerCodeUnique(code);
            if (!uniqueCode) {
                System.err.println("ERROR: Sigla já atribuída a outro cliente do sistema");
                continue;
            }
        } while (!validCode || !uniqueCode);

        return code;
    }

    private void askAddress() {
        street = Console.readLine("Introduza a rua de morada principal do cliente");
        buildingNum = Console.readInteger("Introduza o número da porta/edíficio da morada principal do cliente");

        boolean validZipcode;

        do {
            zipcode = Console.readLine("Introduza o código postal da morada principal do cliente");

            validZipcode = ctrl.checkZipCodeFormat(zipcode);

            if (!validZipcode) {
                System.err.println("ERROR: Código postal em formato inválido. Deve seguir a estrutura XXXX-XXX");
            }

        } while (!validZipcode);

        city = Console.readLine("Introduza a cidade de morada principal do cliente");
    }

    private void askPassword(){
        password= Console.readLine("Introduza a password do cliente");
    }

    private boolean askConfirmation() {
        System.out.printf("\n%s SUMMARY OF CUSTOMER DATA %s\n\n", SEPARATOR, SEPARATOR);
        System.out.printf("Name = %s\n", name);
        System.out.printf("Email = %s\n", email);
        System.out.printf("Customer Code = %s\n", code);
        System.out.printf("Address = %s, %d, %s, %s\n", street, buildingNum, zipcode, city);
        System.out.printf("Password = %s\n", password);

        return Console.readBoolean("Pretende submeter o registro do cliente? (y/n)");
    }

    private void conclude(boolean confirmation) {
        if (confirmation) {
            if (ctrl.registerCustomer(name, email, code, street, buildingNum, zipcode, city,password)) {
                System.out.println("\nCLIENTE REGISTADO COM SUCESSO\n");
            } else {
                System.err.println("\nERRO: NÃO FOI POSSÍVEL REGISTAR O CLIENTE\n");
            }
        }
    }
}
