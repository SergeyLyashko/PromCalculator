package viewcomponents;

import javax.swing.*;

public interface AppComponent extends Host {

    default void addVisitor(Visitor visitor, AppComponent component){
        visitor.addHost(component);
    }

    default void setLocation(AppComponent appComponent, JComponent jComponent) {
        int locationX = appComponent.getLocationX();
        int locationY = appComponent.getLocationY();
        jComponent.setLocation(locationX, locationY);
    }

    default AppComponent initialization(AppComponent component, Visitor visitor){
        JComponent jComponent = getParent();
        setLocation(component, jComponent);
        addListener(component, visitor);
        addVisitor(visitor, component);
        return component;
    }

    default AbstractFactory getFactory(){
        return this::initialization;
    }

    void addListener(AppComponent component, Visitor visitor);

    int getLocationX();

    int getLocationY();

    JComponent getParent();
}
