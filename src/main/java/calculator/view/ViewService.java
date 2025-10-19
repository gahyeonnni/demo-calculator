package calculator.view;

public class ViewService {
    private ViewInput viewInput;
    private ViewOutput viewOutput;

    public ViewService() {
        this.viewInput = new ViewInput();
        this.viewOutput = new ViewOutput();
    }

    public void runView() {
        viewInput.viewInput();
    }

    public void runView(int result) {
        viewOutput.viewOutput(result);
    }
}
