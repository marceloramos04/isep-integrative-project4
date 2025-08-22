package menu;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class MenuItem {
    private final String description;
    private final Runnable ui;

    /**
     * Instantiates a new Menu item.
     *
     * @param description the description
     * @param ui          the ui
     */
    public MenuItem(String description, Runnable ui) {

        if (StringUtils.isBlank(description)) {

            throw new IllegalArgumentException("MenuItem description cannot be null or empty.");
        }

        if (Objects.isNull(ui)) {
            throw new IllegalArgumentException("MenuItem does not support a null UI.");
        }

        this.description = description;
        this.ui = ui;
    }

    /**
     * Run.
     */
    public void run() {
        this.ui.run();
    }

    public String toString() {
        return this.description;
    }
}
