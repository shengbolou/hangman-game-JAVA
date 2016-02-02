package hangman;


public class GameBoardLinkedList implements GameBoard {
	
	private LLCharLog L;
	private char[]guessWORD,display;
	/** hung state */
	private int	state;
	private int guesses = 0;

	/**
	 * Creates a new GameBoardArray object.
	 * 
	 *  guessWord the word to guess
	 */
	public GameBoardLinkedList(String guessWord){
		
		L = new LLCharLog();
		state =0;
        guessWORD=guessWord.toCharArray();
        display=new char[guessWord.length()];
        for(int a=0;a<display.length;a++){
			display[a]='_';
		}
	}

	public boolean isPriorGuess(char guess) {

		

        
		return L.contains(guess);

		
		// TODO (2)
	}

	public int numberOfGuesses() {

		return guesses;
	}

	public boolean isCorrectGuess(char guess) {

		boolean icg=false;
		for(int a=0;a<guessWORD.length;a++){
			if(guess==guessWORD[a]){
				icg=true;
			}
		}
		return icg;
		// TODO (4)
	}

	public boolean doMove(char guess) {
       
		boolean result =false;
		if(isPriorGuess(guess)){	
			return false;
		}
		else if(isCorrectGuess(guess)){ 
			for(int a=0;a<guessWORD.length;a++){
					if(guessWORD[a]==guess) 
						display[a]=guess;
			}

			result=true;

		}	
		else{

			state++;

		}

        L.insert(guess);

		guesses++;


		return result;


	}// TODO (5)

	public boolean inWinningState() {
		boolean win=true;
		for(int a=0;a<display.length;a++){
			if(display[a]=='_') win=false;
		}
		return win;// TODO (6)
	}

	public boolean inLosingState() {
		return state == 10;
	}

	public String toString() {
		String s = "";
		for(int a=0;a<display.length;a++){
			s+=display[a]+" ";
		}
		
		return s.trim();
		// TODO (7)


	}

	public String previousGuessString() {
		return L.s();// TODO (8)
	}

	public int currentHungState() {
		return state;
	}

}
