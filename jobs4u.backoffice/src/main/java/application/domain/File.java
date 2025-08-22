package application.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class File {

    @Getter
    @Setter
    private String filePath;

    protected File() {
        // ORM
    }

    public File(String filePath) {
        this.filePath = filePath;
    }

}
