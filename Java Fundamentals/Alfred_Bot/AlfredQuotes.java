import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return "Hello, " + name;
    }
    public String guestGreeting(String name, String dayPeriod) {
        String response = String.format("%s, %s. It is so good to see you!", dayPeriod, name);
        return response;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "The current date is: " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        if (conversation.contains("Alexis")){
            return "Right, who is Alexis? I have never heard of this woman.";
        }
        else if (conversation.contains("Alfred")){
            return "Alfred at your service! I will get to it at once!";
        }
        else {
            return "I could be playing chess with Master Bruce right now.";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

