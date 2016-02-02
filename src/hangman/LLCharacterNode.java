package hangman;

public class LLCharacterNode {

	private char info;
	private LLCharacterNode link;


	public LLCharacterNode(char info){
		this.info=info;
		link=null;
	}


	public void setInfo(){
		this.info=info;
	}
	public char getInfo(){
		return info;
	}

	public void setLink(LLCharacterNode lk){
		this.link=lk;
	}
	public LLCharacterNode getLink(){
		return link;
	}





}


