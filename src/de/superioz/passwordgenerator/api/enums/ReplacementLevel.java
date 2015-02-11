package de.superioz.passwordgenerator.api.enums;

/**
 * Class created on 09.02.2015
 */
public enum ReplacementLevel {

    FULL_WORD(4),
    THREE_FOURTH_WORD(3),
    HALF_WORD(2),
    ONE_FOURTH_WORD(1);

    private int value;

    ReplacementLevel(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static ReplacementLevel getByValue(int value){
        for(ReplacementLevel level : ReplacementLevel.values()){
            if(level.getValue()==value)
                return level;
        }

        return ReplacementLevel.FULL_WORD;
    }

}
