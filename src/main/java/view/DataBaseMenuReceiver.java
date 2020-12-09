package view;

import java.util.List;

public interface DataBaseMenuReceiver {

    List<String> getAssortmentMenu();

    List<String> getTypeMenu(String assortment);

    List<String> getNumberMenu(String assortment, String type);
}