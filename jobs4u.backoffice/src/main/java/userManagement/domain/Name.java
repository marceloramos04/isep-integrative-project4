package userManagement.domain;

import jakarta.persistence.Embeddable;

import java.util.regex.Pattern;

@Embeddable
public class Name {
    private String name;

    protected Name() {
        // for ORM
    }

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$");

        if (!pattern.matcher(name).matches()) {
            throw new IllegalArgumentException("Name should only contain alphanumeric characters");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
