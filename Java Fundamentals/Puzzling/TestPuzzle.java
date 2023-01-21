import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
public class TestPuzzle {
    public static void main(String[] args){
        PuzzleUtil puzzleApp = new PuzzleUtil();

        puzzleApp.generateArray();
        System.out.println(puzzleApp.getRandomLetter());
        System.out.println(puzzleApp.generatePassword());
        System.out.println(puzzleApp.getNewPasswordSet(10));
    }
}