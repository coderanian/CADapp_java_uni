package viewmodel;

import view.IView;

public abstract class ViewModel {
    protected IView view = null;

    public ViewModel() {
    }

    public void registerView(IView view) {
        this.view = view;
    }
}
