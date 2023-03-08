package viewmodel;

public class MainViewModel extends ViewModel {
    private IOFigureViewModel vmIOFigure;

    public MainViewModel() {
    }

    public ViewModel getIOFigureVM() {
        return this.vmIOFigure;
    }
}

