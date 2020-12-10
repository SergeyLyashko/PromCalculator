package view.model;

public interface FieldBehavior {

    void fieldActivate();

    void fieldDeactivate();

    void areaActivate();

    void areaDeactivate();

    void registerObserver(KeyActionObserver viewModel);
}