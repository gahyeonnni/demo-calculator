package calculator.controller;

import calculator.io.ReadString;
import calculator.service.CalculatorService;

import java.io.IOException;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ReadString readString;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.readString = new ReadString();
    }

    public void run() throws IOException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readString.readInput();

        try {
            long result = calculatorService.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws IOException {
        new CalculatorController().run();
    }
}
