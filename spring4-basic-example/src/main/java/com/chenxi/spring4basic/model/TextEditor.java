package com.chenxi.spring4basic.model;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class TextEditor {
    private SpellChecker spellChecker;

//    public TextEditor(SpellChecker spellChecker) {
//        System.out.println("Inside TextEditor constructor.");
//        this.spellChecker = spellChecker;
//    }

    // a setter method to inject the dependency.
    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("TextEditor: Inside setSpellChecker.");
        this.spellChecker = spellChecker;
    }

    // a getter method to return spellChecker
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
