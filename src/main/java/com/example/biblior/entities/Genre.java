package com.example.biblior.entities;

import org.apache.commons.lang3.text.WordUtils;


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
        String s = this.toString();
        while(s.contains("_")){
            s=substitute(s, "_", " ");
        }
        return WordUtils.capitalizeFully(s);
    }
    private String substitute(String main, String trash, String substitute){
        if(main.contains(trash)){
            StringBuilder sb = new StringBuilder(main);
            return sb.substring(0, sb.indexOf(trash)) + substitute + sb.substring(sb.indexOf(trash)+1);
        }else{
            return trash;
        }
    }
    private boolean contains(String s) {
        return this.toString().contains(s);
    }
}
