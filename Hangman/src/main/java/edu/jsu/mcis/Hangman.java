package edu.jsu.mcis;

import java.util.*;

public class Hangman {
    public enum Result { WIN, LOSE, NONE };
    private String word;
    private List<Character> usedLetters;
    
    public Hangman() {
        word = "";
        usedLetters = new ArrayList<Character>();
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public boolean available(char c) {
		if (usedLetters.contains(c))
			return false;
		else
			return true;
    }
    
    public int guess(char c) { 
		int num = 2;
			if(usedLetters.contains(c))
				num = 1;
			else
				usedLetters.add(c);
		return num;
		
    }
	
	public boolean tooMany(){
		if(usedLetters.size() > 5)
			return true;
		else
			return false;
	}
    
    public Result getResult() {
        return Result.NONE;
    }
    
}












