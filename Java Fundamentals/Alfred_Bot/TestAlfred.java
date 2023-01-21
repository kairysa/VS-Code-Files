public class TestAlfred {
    public static void main(String[] args){

        AlfredQuotes alfredQuotes = new AlfredQuotes();

        String testGreet = alfredQuotes.basicGreeting();
        String testGuestGreet = alfredQuotes.guestGreeting("Noah Gardner");
        String testGreetWithDayPeriod = alfredQuotes.guestGreeting("Noah", "Good morning");
        String testDate = alfredQuotes.dateAnnouncement();
        
        
        // Testing greets and dates
        
        System.out.println(testGreet);
        System.out.println(testGuestGreet);
        System.out.println(testDate);
        System.out.println(testGreetWithDayPeriod);

        // Testing conversations, add/remove comments to test

        String conversationOne = alfredQuotes.respondBeforeAlexis("Alexis, fetch me a glass of water please.");
        System.out.println(conversationOne);

        String conversationTwo = alfredQuotes.respondBeforeAlexis("Alfred, fetch me a glass of water please.");
        System.out.println(conversationTwo);

        String conversationThree = alfredQuotes.respondBeforeAlexis("I wonder what I'm going to do for dinner today.");
        System.out.println(conversationThree);

    }
}