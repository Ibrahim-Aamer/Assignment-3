package com.example.assignment3;

public class Word {

    private String word;
    private int frequency;

    public Word(String word) {
        this.word = word;
        this.frequency = 1;

    }

    public void IncFrequency()
    {
        this.frequency++;
    }

    public String getWord()
    {
        return this.word;
    }

    public int getFrequency()
    {
        return this.frequency;
    }

    public String DisplayFrequency()
    {
        return (this.frequency + "  " + this.word);
    }
}
