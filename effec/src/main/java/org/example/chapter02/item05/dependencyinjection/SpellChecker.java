package org.example.chapter02.item05.dependencyinjection;


import org.example.chapter02.item05.DefaultDictionary;
import org.example.chapter02.item05.Dictionary;

import java.util.List;
import java.util.function.Supplier;

public class SpellChecker {

    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public SpellChecker(Supplier<Dictionary> dictionarySupplier) {
        this.dictionary = dictionarySupplier.get();
    }

    public boolean isValid(String word) {
        // TODO 여기 SpellChecker 코드
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        // TODO 여기 SpellChecker 코드
        return dictionary.closeWordsTo(typo);
    }

    public static void main(String[] args) {
//        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
        SpellChecker spellChecker = new SpellChecker(DefaultDictionary::new);
    }
}
