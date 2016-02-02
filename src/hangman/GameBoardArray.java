package hangman;

/**
 * The Array implementation of the GameBoard interface.
 */
public class GameBoardArray implements GameBoard, HangManConstants {
	/** The number of characters (lower/upper). */
	private static int ALPHABET_COUNT = 26*2;
	

	private char[]guessedchars=new char[50];
	private char[]guessWORD;
	private char[]display;
	/** hung state */
	private int	state;
	private int guesses = 0;

	/**
	 * Creates a new GameBoardArray object.
	 * 
	 *  guessWord the word to guess
	 */
	public GameBoardArray(String guessWord) {
		// TODO (1)
		state    = STARTING_STATE;
         this.guessWORD = guessWord.toCharArray();
		 this.display=new char[guessWord.length()];
         for(int a=0;a<display.length;a++){
			display[a]='_';
		}
	}

	public boolean isPriorGuess(char guess) {

		


		boolean yes=false;
		for(int a=0;a<guessedchars.length;a++){
			if(guessedchars[a]==guess) yes=true;
		}

		return yes;
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


		guessedchars[guesses]=guess;

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
		return state == NUMBER_OF_STATES;
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
		String s = "";
		s+="[";
		for(int a=0;a<=guesses;a++){
			
			s+=guessedchars[a]+", ";
				    
		}
		
         s=s.substring(0,s.length()-5);
		
         s+="]";
		return s;// TODO (8)
	}

	public int currentHungState() {
		return state;
	}

}
