import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
public class PuzzleUtil{
    Random random = new Random();
    public int[] generateArray(){
        int[] numberList = new int[10];
        for(int i = 0; i < numberList.length; i++){
            int x = random.nextInt(20);
            numberList[i] = x;
            System.out.println(numberList[i]);
        }
        return numberList;
    }
    public char getRandomLetter(){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int randomNumber = random.nextInt(26);
        char randomLetter = alphabet[randomNumber];
        return randomLetter;
    }

    public String generatePassword(){
        String password = "";
        while(password.length()<8){
            char letter = getRandomLetter();
            String charToString = Character.toString(letter);
            password += charToString;
        }
        return password;
    }

    public ArrayList getNewPasswordSet(int length){
        ArrayList<String> pwArray = new ArrayList<String>();
        for (int i=0; i<length; i++){
            pwArray.add(generatePassword());
        }
        return pwArray;
    }
}