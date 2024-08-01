package com.xiazhimiao.utils;

public class transitionUtils {
    public static Integer transition(Character character){
        if(character=='A'){
            return 1;
        }else if(character =='B'){
            return 2;
        }else if(character=='C'){
            return 3;
        }else {
            return 4;
        }
    }
}
