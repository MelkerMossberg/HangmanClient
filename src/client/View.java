package client;

import com.sun.source.tree.IfTree;

public class View {

    public void UpdateGameView(String gameInfo){

        // Get GAME STATE
        String gameState = gameInfo.split("-")[0];

        // CHOOSE TEMPLATES depending on GAME STATE
        if (gameState.equals("LETTER_GUESS")){
            String view = createLetterGuessView(gameInfo);
            System.out.println(view);
        }
        else if (gameState.equals("WORD_GUESS")){
            //Todo: Implement word guess
        }
        else if (gameState.equals("LOST"))
            printYouLoose(gameInfo);

        else if (gameState.equals("WIN"))
            printYouWin(gameInfo);

        else
            System.out.println("Nothing got caught in UpdateGameView");
    }

    private void printYouWin(String gameInfo) {
        String view = createLetterGuessView(gameInfo);
        System.out.println("\nYOU WON! The word was: '" + gameInfo.split("-")[6] + "'");
        System.out.println("\n======= NEW ROUND ======\n");
        System.out.println(view);
    }

    private void printYouLoose(String gameInfo) {
        String view = createLetterGuessView(gameInfo);
        System.out.println("\nYOU LOST... The word was: '" + gameInfo.split("-")[6] + "'");
        System.out.println("\n======= NEW ROUND ======\n");
        System.out.println(view);
    }

    private String createLetterGuessView(String state) {
        String[] parts = state.split("-");
        String gameScore = parts[1];
        String livesLeft = parts[2];
        String numCorrect = parts[3];
        String guesses = parts[4];
        String hiddenWord = parts[7];

        StringBuilder sb = new StringBuilder();
        sb.append("Score: " + gameScore + "  Lives: " + livesLeft + "/" + 3 +
                  "   Correct: "+numCorrect + "  Hidden:"+ hiddenWord + "  Guessed: " + guesses);
        return sb.toString();
    }
}
