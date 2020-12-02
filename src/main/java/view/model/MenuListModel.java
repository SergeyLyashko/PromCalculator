package view.model;

import javax.swing.*;
import java.util.List;

class MenuListModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private final List<String> receiveMenuList;
    private int selected;

    MenuListModel(List<String> receiveMenuList, JComboBox<String> comboBox){
        this.receiveMenuList = receiveMenuList;
        comboBox.setModel(this);
    }

    @Override
    public int getSize() {
        return receiveMenuList.size();
    }

    @Override
    public String getElementAt(int index) {
        return receiveMenuList.get(index);
    }

    @Override
    public void setSelectedItem(Object item) {
        selected = receiveMenuList.indexOf(item);
    }

    @Override
    public Object getSelectedItem() {
        return receiveMenuList.get(selected);
    }
}
