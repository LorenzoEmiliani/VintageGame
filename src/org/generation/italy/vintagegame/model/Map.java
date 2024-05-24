package org.generation.italy.vintagegame.model;

import java.util.ArrayList;

public enum Map {
    MARKETPLACE("PHARMACY", "TEATRE", "MUSEUM", "CHURCH"), 
    PHARMACY("", "MARKETPLACE", "", "LIBRARY"), 
    MUSEUM("", "", "", "MARKETPLACE"), 
    CHURCH("LIBRARY", "SCHOOL", "MARKETPLACE", ""), 
    TEATRE("MARKETPLACE", "", "", "SCHOOL"), 
    SCHOOL("CHURCH", "", "TEATRE", ""), 
    LIBRARY("", "CHURCH", "PHARMACY", "");
    
    private ArrayList<String> objects;
    private String n;
    private String s;
    private String w;
    private String e;

    private Map(String n, String s, String w, String e) {
        this.n = n;
        this.s = s;
        this.w = w;
        this.e = e;
        objects = new ArrayList<>();
    }

    static {
        MARKETPLACE.objects.add("pomodoro");
        PHARMACY.objects.add("test di gravidanza");
        MUSEUM.objects.add("vernice");
        CHURCH.objects.add("rosario");
        TEATRE.objects.add("maschera");
        SCHOOL.objects.add("righello");
        LIBRARY.objects.add("libro");
    }

    public Map move(String direction) {
        if(direction.equals("n") && !this.getN().equals("")) {
            for (Map map : Map.values()) {
                if(this.getN().equals(map.toString())) {
                    return map;
                }
            }
        } else if(direction.equals("s") && !this.getS().equals("")) {
            for (Map map : Map.values()) {
                if(this.getS().equals(map.toString())) {
                    return map;
                }    
            }
        } else if(direction.equals("w") && !this.getW().equals("")) {
            for (Map map : Map.values()) {
                if(this.getW().equals(map.toString())) {
                    return map;
                }
            }
        } else if(direction.equals("e") && !this.getE().equals("")) {
            for (Map map : Map.values()) {
                if(this.getE().equals(map.toString())) {
                    return map;
                }   
            }
        }
        return this;
    }

    public ArrayList<String> getObject() {
        return objects;
    }

    public String getN() {
        return n;
    }

    public String getS() {
        return s;
    }

    public String getW() {
        return w;
    }

    public String getE() {
        return e;
    }
}
