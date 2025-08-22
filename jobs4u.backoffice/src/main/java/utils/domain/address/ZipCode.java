package utils.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class ZipCode {

    private final static String REGEX="^[0-9]{4}-[0-9]{3}$";

    @Column(nullable = false)
    private String zipCode;

    public ZipCode(String zipCode){
        if (checkZipCodeFormat(zipCode)){
            this.zipCode=zipCode;
        } else throw new InvalidParameterException("ERRO: Código postal em formato inválido. Deve seguir o padrão XXXX-XXX, constituído por dígitos apenas");
    }

    protected ZipCode() {

    }

    public static boolean checkZipCodeFormat(String zipCode){
        Pattern pattern=Pattern.compile(REGEX);
        Matcher matcher=pattern.matcher(zipCode);
        return matcher.matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode1 = (ZipCode) o;
        return Objects.equals(zipCode, zipCode1.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode);
    }

    @Override
    public String toString() {
        return zipCode;
    }
}
