package viewcontroller;

import viewmodel.KeyActionObserver;

public interface KeyBehavior {

    void fieldDeactivate();

    void registerKeyObserver(KeyActionObserver observer);

    void fieldActivate();
}
