package fields;

import appcomponents.AbstractFactory;
import appcomponents.Visitor;

import javax.swing.*;
import java.awt.*;

public class Length implements AbstractField {

    private static final String BOX_NAME = "введите длину";
    private static final String THEME_TOOL_TIP_TEXT = "поле ввода длины детали";
    private static final int LOCATION_X = 190;
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
    public Container getParent() {
        return componentSwing;
    }

    @Override
    public void setParent(JComponent jComponent) {
        this.componentSwing = jComponent;
    }

    @Override
    public AbstractFactory getFactory() {
        return AbstractField.super::ordered;
    }

    @Override
    public void activate(Visitor visitor) {
        System.out.println("length activate");
    }

    @Override
    public void deactivate(Visitor visitor) {
        System.out.println("length deactivate");
    }
}
