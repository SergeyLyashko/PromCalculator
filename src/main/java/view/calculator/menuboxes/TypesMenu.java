package view.calculator.menuboxes;

import view.AppComponent;
import view.MenuReceivable;
import view.calculator.MenuSelectable;
import view.calculator.fields.FieldSelectable;

import javax.swing.*;
import java.util.List;

public class TypesMenu implements MenuSelectable {

    private final JComboBox<String> jComboBox;

    private static final String TYPE_HEADER = "Тип профиля";
    private static final String THEME_TOOL_TIP_TEXT = "выбор типа профиля детали";
    private static final int LOCATION_X = 20;
    private static final int LOCATION_Y = 60;
    private static final int WIDTH = 155;
    private static final int HEIGHT = 23;
    private MenuReceivable menuReceivable;

    public TypesMenu(){
        jComboBox = new JComboBox<>();
        jComboBox.setSize(WIDTH, HEIGHT);
        jComboBox.setSelectedIndex(-1);
    }

    @Override
    public void addReceiver(MenuReceivable menuReceivable) {
        this.menuReceivable = menuReceivable;
    }

    @Override
    public List<String> receiveMenu(String menuItem) {
        return menuReceivable.getTypeMenu(menuItem);
    }

    @Override
    public String getHeaderMenu() {
        return TYPE_HEADER;
    }

    @Override
    public void setMenuModel(MenuModel menuModel) {
        jComboBox.setModel(menuModel);
    }

    @Override
    public <T extends AppComponent> void addListener(T componentListener) {
        if(componentListener instanceof MenuSelectable){
            addActionListener((MenuSelectable) componentListener);
        }
        if(componentListener instanceof FieldSelectable){
            jComboBox.addActionListener(e -> ((FieldSelectable) componentListener).deactivate());
        }
    }

    private void addActionListener(MenuSelectable menuSelectable){
        jComboBox.addActionListener(event -> {
            String selectedItem = (String) jComboBox.getSelectedItem();
            MenuModel menuModel = new MenuModel(menuSelectable, selectedItem);
            menuSelectable.setMenuModel(menuModel);
        });
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
    public JComponent getParent() {
        return jComboBox;
    }

 }
