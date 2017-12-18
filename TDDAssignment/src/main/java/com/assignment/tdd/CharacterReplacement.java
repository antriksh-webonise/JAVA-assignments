package com.assignment.tdd;

import java.lang.*;

import java.lang.Object;

public class CharacterReplacement {

   public String replaceCharacter (String inputString, char replacementCharacter) {

       StringBuilder tempStringBuilder = new StringBuilder(inputString);
       int stringLength = tempStringBuilder.length();
       String resultString;
       StringBuilder stringBuilder = new StringBuilder();
       int index = 0;

       while(index < 3) {
           if(stringLength<4 && index < stringLength && tempStringBuilder.charAt(index)!=replacementCharacter) {
               stringBuilder.append(tempStringBuilder.charAt(index));
           } else if (stringLength>=4 && tempStringBuilder.charAt(index)!=replacementCharacter){
               stringBuilder.append(tempStringBuilder.charAt(index));
           }
           index++;
       }
       if (stringLength>=4) {
           stringBuilder.append(tempStringBuilder, index, stringLength);
       }

       resultString = stringBuilder.toString();
       return resultString;
   }
}
