package view.settingscomponents;

import view.ViewController;
import view.AppComponent;
import view.Host;
import view.Visitor;

import javax.swing.*;
import java.awt.event.ItemEvent;

class ToolTipsCheckBox implements AppComponent, Host {

    private final JCheckBox jCheckBox;

    private static final String BOX_NAME = "включить всплывающие подсказки";
    private static final String TOOL_TIP_TEXT = "включение/отключение всплывающих подсказок";
    private static final int LOCATION_X = 15;
    private static final int LOCATION_Y = 60;
    private static final int WIDTH = 320;
    private static final int HEIGHT = 20;

    ToolTipsCheckBox(ViewController viewController){
        jCheckBox = new JCheckBox();
        jCheckBox.setSelected(true);
        jCheckBox.setSize(WIDTH, HEIGHT);
        jCheckBox.setText(BOX_NAME);
        jCheckBox.setToolTipText(TOOL_TIP_TEXT);

        addItemListener(viewController);
        addHost(viewController);
    }

    private void addHost(ViewController viewController){
        Visitor visitor = viewController.getVisitor();
        visitor.addHost(this);
    }

    private void addItemListener(ViewController viewController){
        jCheckBox.addItemListener(event ->
                ToolTipManager.sharedInstance().setEnabled(event.getStateChange() == ItemEvent.SELECTED));
    }

    @Override
    public int getLocationX() {
        return LOCATION_X;
    }

    @Override
    public int getLocationY() {
        return LOCATION_Y;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitComponent(this);
    }

    @Override
    public JComponent getParent() {
        return jCheckBox;
    }
}