package com.lucatode.randomfactservice.entity;

public class RandomFact {

    private final String id;
    private final String title;
    private final String text;
    private final String link;

    public RandomFact(String id, String title, String text, String link) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.link = link;
    }

    public static RandomFact builder() {

        return new RandomFact("", "", "", "");
    }


    public String toJsonString() {
        return "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random facts\", \"link\":\"http://reddit.com/randomfact/1\"}";
    }
}
