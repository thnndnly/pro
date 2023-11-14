package newchess.ui;

import newchess.data.Move;

public interface InputParser {

    public String getInput();
    public boolean isInputCorrect(String input);
    public Move parseInput(String input);
}
