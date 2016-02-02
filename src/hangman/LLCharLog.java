package hangman;

public class LLCharLog {

	private LLCharacterNode lead;

	public LLCharLog(){
		lead = null;
	}

    public void insert(char guess){
    	LLCharacterNode L=new LLCharacterNode(guess);
    	if(lead==null){
    		lead=L;
    	}
    	else{
    		LLCharacterNode l=lead;
        while(l.getLink()!=null){
			 l=l.getLink();
		 }
		l.setLink(L);
		}
    }

    public boolean contains(char guess){
    	LLCharacterNode l=lead;
    	boolean contains=false;
    	while(l!=null){
    		if(l.getInfo()==guess) contains=true;
    		l = l.getLink();
    	}
    	
    	return contains;
    	
    }

    public String s(){
    	LLCharacterNode l=lead;
    	String s = "";
		s+="[";
		while(l!=null){
    		s+=l.getInfo()+", ";
    		l=l.getLink();
    	}
		s=s.substring(0,s.length()-2);
         s+="]";
		return s;
    }


}
