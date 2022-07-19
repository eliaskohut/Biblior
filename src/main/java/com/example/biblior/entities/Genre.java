package com.example.biblior.entities;

public enum Genre {
    ACTION, ADVENTURE, ALTERNATE_HISTORY, ANTHOLOGY, CHICK_LIT, CHILDREN, CLASSIC,
    COMIC, COMING_OF_AGE, CRIME, DRAMA, FAIRYTALE, FANTASY, GRAPHIC_NOVEL, HISTORICAL,
    HORROR, MYSTERY, PARANORMAL_ROMANCE, PICTURE_BOOK, POETRY, POLITICAL_THRILLER, ROMANCE,
    SATIRE, SCIENCE_FICTION, SHORT_STORY, SUSPENSE, THRILLER, WESTERN, YOUNG_ADULT, ART, ARCHITECTURE, AUTOBIOGRAPHY,
    BIOGRAPHY, BUSINESS, ECONOMICS, CRAFT, HOBBIES, COOKBOOK, DIARY, DICTIONARY,
    ENCYCLOPEDIA, GUIDE, HEALTH, FITNESS, HISTORY, HOME_AND_GARDEN, HUMOR, JOURNAL, MATH, MEMOIR, PROGRAMMING,
    PHILOSOPHY, PRAYER, RELIGION, SPIRITUALITY, TEXTBOOK, TRUE_CRIME, REVIEW, SCIENCE, SELF_HELP, SPORTS_AND_LEISURE,
    TRAVEL;
    public String enumFormat(){
        StringBuilder buf = new StringBuilder(this.toString());
        if(this.contains("_")){
            return buf.substring(0, 1) + buf.substring(1, buf.indexOf("_")).toLowerCase() + " " + buf.substring(buf.indexOf("_")+1).toLowerCase();
        }else{
            return buf.substring(0, 1) + buf.substring(1).toLowerCase();
        }
    }

    private boolean contains(String s) {
        return this.toString().contains(s);
    }
}
