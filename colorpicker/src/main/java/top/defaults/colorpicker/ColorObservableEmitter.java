package top.defaults.colorpicker;

import java.util.ArrayList;
import java.util.List;

class ColorObservableEmitter implements ColorObservable {

    private List<ColorObserver> listeners = new ArrayList<>();
    private int color;

    @Override
    public void subscribe(ColorObserver observer) {
        if (observer == null) return;
        listeners.add(observer);
    }

    @Override
    public void unsubscribe(ColorObserver observer) {
        if (observer == null) return;
        listeners.remove(observer);
    }

    @Override
    public int getColor() {
        return color;
    }

    void onColor(int color, boolean fromUser) {
        this.color = color;
        for (ColorObserver listener : listeners) {
            listener.onColor(color, fromUser);
        }
    }

}
