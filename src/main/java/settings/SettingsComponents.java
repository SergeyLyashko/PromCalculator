package settings;

import appview.*;

import java.util.ArrayList;
import java.util.List;

public class SettingsComponents {

    private final List<SwingComponent> components = new ArrayList<>();

    public List<SwingComponent> getComponents(Visitor visitor){
        SelectableCheckBox theme = getCheckBox("theme", visitor);
        SelectableCheckBox toolTip = getCheckBox("toolTip", visitor);
        components.add(theme);
        components.add(toolTip);
        return components;
    }

    private SelectableCheckBox getCheckBox(String type, Visitor visitor) {
        AbstractCheckBox abstractCheckBox = new AbstractCheckBox() {
            @Override
            public SelectableCheckBox createCheckBox(String type) {
                return create(type);
            }
        };
        return abstractCheckBox.orderedCheckBox(type, visitor);
    }

    private SelectableCheckBox create(String type) throws IllegalStateException {
        switch (type){
            case "theme":
                return new ColorTheme();
            case "toolTip":
                return new ToolTip();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
