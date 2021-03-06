package viewcontroller;

import view.AppComponent;
import viewmodel.FocusActionObserver;
import viewmodel.KeyActionObserver;

class FieldsAction implements FocusActionObserver {

    private final FieldBehavior fieldBehavior;
    private final FocusBehavior focusBehavior;
    private final KeyBehavior keyBehavior;
    private final Filter defaultFilter;
    private final Filter digitalFilter;
    private final AppComponent component;

    private boolean actionState;

    FieldsAction(ViewModel viewModel, AppComponent component) {
        this.component = component;
        this.fieldBehavior = viewModel.createFieldBehavior(component);
        this.focusBehavior = viewModel.createFocusBehavior(component);
        this.keyBehavior = viewModel.createKeyBehavior(component);
        this.defaultFilter = viewModel.getDefaultFilter();
        this.digitalFilter = viewModel.getDigitalFilter();
        focusBehavior.registerFocusObserver(this);
        deactivate();
    }

    boolean isActionState(){
        return actionState;
    }

    void setState(boolean status){
        this.actionState = status;
    }

    void registerKeyObserver(KeyActionObserver observer){
        keyBehavior.registerKeyObserver(observer);
    }

    void deactivate(){
        removeFilter();
        fieldBehavior.fieldDeactivate();
        focusBehavior.fieldDeactivate();
        keyBehavior.fieldDeactivate();
    }

    void activate(){
        removeFilter();
        fieldBehavior.fieldActivate();
        focusBehavior.fieldActivate();
    }

    void areaActivate(){
        fieldBehavior.areaActivate();
    }

    void areaDeactivate(){
        fieldBehavior.areaDeactivate();
    }

    private void removeFilter(){
        defaultFilter.setFilter(component);
    }

    private void setFilter(){
        digitalFilter.setFilter(component);
    }

    @Override
    public void focusActionUpdate(AppComponent component) {
        setFilter();
        keyBehavior.fieldActivate();
    }
}
