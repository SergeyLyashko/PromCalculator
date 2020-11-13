package comboboxes;

import appcomponents.AbstractFactory;
import appcomponents.Visitor;

import javax.swing.*;
import java.awt.*;

public class TypesBox implements AbstractComboBox {

    private static final String BOX_NAME = "тип";
    private static final String THEME_TOOL_TIP_TEXT = "выбор типа профиля детали";
    private static final int LOCATION_X = 20;
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
        return AbstractComboBox.super::ordered;
    }

    @Override
    public void activate(Visitor visitor) {

    }

    @Override
    public void deactivate(Visitor visitor) {

    }
}
