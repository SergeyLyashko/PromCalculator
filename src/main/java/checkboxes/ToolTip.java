package checkboxes;

import appcomponents.Factory;
import appcomponents.Visitor;

import javax.swing.*;
import java.io.Serializable;

public class ToolTip implements Serializable, SelectableCheckBox {

    private static final long serialVersionUID = 1L;

    private static final String BOX_NAME = "включить всплывающие подсказки";
    private static final String TOOL_TIP_BOX_TEXT = "включение/отключение всплывающих подсказок";
    private static final int LOCATION_X = 15;
    private static final int LOCATION_Y = 60;
    private JComponent componentSwing;

    @Override
    public int getLocationX() {
        return LOCATION_X;
    }

    @Override
    public int getLocationY() {
        return LOCATION_Y;
    }

    @Override
    public String getName() {
        return BOX_NAME;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public JComponent getParent() {
        return componentSwing;
    }

    @Override
    public void setParent(JComponent jComponent) {
        this.componentSwing = jComponent;
    }

    @Override
    public Factory getFactory() {
        return new CheckBoxFactory();
    }

    @Override
    public void select(Visitor visitor) {
        // TODO
        System.out.println("toolTip selected");
        setState(true);
        visitor.raid();
    }

    @Override
    public void deselect(Visitor visitor) {
        // TODO
        System.out.println("toolTip deselected");
        setState(false);
        visitor.raid();
    }

    private void setState(boolean state) {
        ToolTipManager.sharedInstance().setEnabled(state);
    }
}