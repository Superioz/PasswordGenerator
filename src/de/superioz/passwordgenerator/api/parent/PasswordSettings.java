package de.superioz.passwordgenerator.api.parent;

/**
 * Class created on 08.02.2015
 */
public class PasswordSettings {

    /*
    variables
     */
    private boolean withWord;
    private String word;
    private boolean[] firstLetter;
    private boolean[] middleLetters;
    private boolean[] lastLetter;
    private boolean swirlLetters;
    private boolean reverseWord;
    private boolean letterReplacement;
    private String letterReplacementChoice;
    private double letterReplacementLevel;
    private double numberCharacters;

    /*
    constructor, setting all items
     */
    public PasswordSettings(boolean withWord, String word
            , boolean[] firstLetter, boolean[] middleLetters, boolean[] lastLetter
            , boolean swirlLetters, boolean reverseWord, boolean letterReplacement, Object letterReplacementChoice
            , double letterReplacementLevel, double numberCharacters){
        this.withWord = withWord;
        this.word = word;
        this.firstLetter = firstLetter;
        this.middleLetters = middleLetters;
        this.lastLetter = lastLetter;
        this.swirlLetters = swirlLetters;
        this.reverseWord = reverseWord;
        this.letterReplacement = letterReplacement;
        this.letterReplacementChoice = letterReplacementChoice.toString();
        this.letterReplacementLevel = letterReplacementLevel;
        this.numberCharacters = numberCharacters;
    }

    public boolean[] getFirstLetter(){
        return firstLetter;
    }

    public void setFirstLetter(boolean[] firstLetter){
        this.firstLetter = firstLetter;
    }

    public boolean[] getLastLetter(){
        return lastLetter;
    }

    public void setLastLetter(boolean[] lastLetter){
        this.lastLetter = lastLetter;
    }

    public boolean isLetterReplacement(){
        return letterReplacement;
    }

    public void setLetterReplacement(boolean letterReplacement){
        this.letterReplacement = letterReplacement;
    }

    public String getLetterReplacementChoice(){
        return letterReplacementChoice;
    }

    public void setLetterReplacementChoice(String letterReplacementChoice){
        this.letterReplacementChoice = letterReplacementChoice;
    }

    public double getLetterReplacementLevel(){
        return letterReplacementLevel;
    }

    public void setLetterReplacementLevel(int letterReplacementLevel){
        this.letterReplacementLevel = letterReplacementLevel;
    }

    public boolean[] getMiddleLetters(){
        return middleLetters;
    }

    public void setMiddleLetters(boolean[] middleLetters){
        this.middleLetters = middleLetters;
    }

    public double getNumberCharacters(){
        return numberCharacters;
    }

    public void setNumberCharacters(int numberCharacters){
        this.numberCharacters = numberCharacters;
    }

    public boolean isReverseWord(){
        return reverseWord;
    }

    public void setReverseWord(boolean reverseWord){
        this.reverseWord = reverseWord;
    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }

    public boolean isWithWord(){
        return withWord;
    }

    public void setWithWord(boolean withWord){
        this.withWord = withWord;
    }

    public boolean isSwirlLetters(){
        return swirlLetters;
    }

    public void setSwirlLetters(boolean swirlLetters){
        this.swirlLetters = swirlLetters;
    }
}
