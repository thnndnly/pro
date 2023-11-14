package newchess.ui;

import newchess.data.*;

import java.util.List;
import java.util.Scanner;

public class CommandLineInputParser implements InputParser {

    @Override
    public String getInput() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public boolean isInputCorrect(String input) {
        boolean result = true;
        if(!isInputFormatCorrect(input)) {
            result = false;
        }
        else {
            List<String> inputPieces = List.of(input.split(" "));
            if(InputData.isMoveValid(inputPieces.get(0), inputPieces.get(2))) {
                result = false;
            };
        }
        return result;
    }

    private boolean isInputFormatCorrect(String input) {
        List<String> inputPieces = List.of(input.split(" "));
        return inputPieces.size() == 3 && inputPieces.get(0).length() == 2 && inputPieces.get(2).length() == 2;
    }

    @Override
    public Move parseInput(String input) {
        return null;
    }
}
