package info;

import appview.SwingComponent;
import appview.Visitor;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InfoPanel implements Serializable, SwingComponent {

    private static final long serialVersionUID = 1L;

    // TODO del test string
    private static final String PANEL_NAME = "Справка";
    // TODO del test method
    public String getName() {
        return PANEL_NAME;
    }

    public List<SwingComponent> getComponents(Visitor visitor){
        visitor.addVisitorComponent(this);
        List<SwingComponent> componentList = new ArrayList<>();
        // TODO создается без AbstractPanel
        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.getComponents(visitor);

        componentList.add(scrollPanel);
        return componentList;
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public LayoutManager getLayout() {
        return new BorderLayout();
    }

    public String getBorderLayout(){
        return BorderLayout.CENTER;
    }

}