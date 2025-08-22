package customer.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class CustomerCode implements ValueObject, Comparable<CustomerCode> {


    private String code;
    private static final String CUSTOMER_CODE_REGEX="^[a-zA-Z][a-zA-Z0-9]{0,9}$";

    public CustomerCode(String code) {
        if (checkCustomerCodeFormat(code)){
            this.code=code;
        } else throw new InvalidParameterException("ERRO: Customer Code em formato inválido. Deve conter no máximo 10 caracteres e iniciar por letras");
    }

    public String getCode(){
        return code;
    }

    protected CustomerCode(){}

    public static boolean checkCustomerCodeFormat(String code){
        Pattern pattern=Pattern.compile(CUSTOMER_CODE_REGEX);
        Matcher matcher=pattern.matcher(code);
        return matcher.matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerCode that = (CustomerCode) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return String.format("Customer Code = %s\n", code);
    }

    @Override
    public int compareTo(CustomerCode o) {
        return code.compareToIgnoreCase(o.code);
    }
}
