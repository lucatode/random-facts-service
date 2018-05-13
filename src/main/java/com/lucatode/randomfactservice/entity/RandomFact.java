package com.lucatode.randomfactservice.entity;

public class RandomFact {

    private final String id;
    private final String title;
    private final String text;
    private final String link;

    public static class Builder{
        private String id;
        private String title;
        private String text;
        private String link;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder text(String text){
            this.text = text;
            return this;
        }
        public Builder link(String link){
            this.link = link;
            return this;
        }

        public RandomFact build(){
            return new RandomFact(this);
        }
    }

    private RandomFact(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.text = builder.text;
        this.link = builder.link;
    }




    /*public String toJsonString() {
        return "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random facts\", \"link\":\"http://reddit.com/randomfact/1\"}";
    }*/
}
