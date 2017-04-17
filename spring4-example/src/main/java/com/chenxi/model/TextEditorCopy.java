package com.chenxi.model;

/**
 * Created by chenxi on 2017/4/2.
 *
 * @author chenxi
 */
public class TextEditorCopy {
    private SpellChecker spellChecker;
    private String name;

    public TextEditorCopy(SpellChecker spellChecker, String name) {
        System.out.println("Inside TextEditor constructor: " + name);
        this.spellChecker = spellChecker;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // a getter method to return spellChecker
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
