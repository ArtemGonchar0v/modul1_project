package com.cryptoanalizator.transformer;

import com.cryptoanalizator.constants.Alphabets;

import java.util.ArrayList;

public class TextTransformer {


    public void mooveLettersOnRhightPosition(int pos, String text) {

        ArrayList<String> strings = new ArrayList<>();
        char[] textCharArray = text.toCharArray();
        ArrayList<String> newAlphabet = prepareAlphabet(pos);

        for (int i = 0; i < textCharArray.length; i++) {
            strings.add(i, String.valueOf(textCharArray[i]));
            for (int j = 0; j < Alphabets.ENGLISH_ALPHABET.size(); j++) {
                if (strings.get(i).equals(Alphabets.ENGLISH_ALPHABET.get(j))) {
                    strings.add(i, newAlphabet.get(j));
                }
            }
        }
    }

    private ArrayList<String> prepareAlphabet(int move) {

        ArrayList<String> newAlphabet = new ArrayList<>(Alphabets.ENGLISH_ALPHABET.size());
        if (move > Alphabets.ENGLISH_ALPHABET.size()) {
            move = move % Alphabets.ENGLISH_ALPHABET.size();
        }

        for (int i = 0; i < Alphabets.ENGLISH_ALPHABET.size(); i++) {
            if (move > Alphabets.ENGLISH_ALPHABET.size()) {
                move = 0;
            }
            newAlphabet.add(i, Alphabets.ENGLISH_ALPHABET.get(move));
            move++;

        }

        return newAlphabet;
    }
}
