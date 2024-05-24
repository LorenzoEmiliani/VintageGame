package org.generation.italy.vintagegame.model;

public class Display {

    public static void instruction(String name) {
        System.out.println("Ciao " + name + " queste sono le istruzioni del gioco:");
        System.out.println("Inserisci la direzione dove vuoi andare (n,s,w,e) e premi enter per muoverti.");
        System.out.println("Scrivi pick, premi enter, scrivi il nome dell'oggetto e premi enter");
        System.out.println("nuovamente per prendere un oggetto presente nella mappa.");
        System.out.println("Scrivi drop, premi enter, poi scrivi il nome dell'oggetto e premi enter");
        System.out.println("nuovamente per lasciare un oggetto del tuo inventario sulla mappa");
        System.out.println("Scrivi inv e premi enter per vedere gli oggetti del tuo inventario.");
        System.out.println("Scrivi exit e premi enter per uscire dal gioco.");
    }

    public static void announceMap(Map actualMap) {
        System.out.println("Sei in " + actualMap + ".");
        if(!actualMap.getObject().isEmpty()){
            System.out.println("Ci sono questi oggetti " + actualMap.getObject().toString());
        } else {
            System.out.println("Non ci sono oggetti in questa parte della mappa.");
        }
        announcePossibleDirection(actualMap);
    }

    private static void announcePossibleDirection(Map actualMap) {
        for (Map map : Map.values()) {
            if(actualMap.getN().equals(map.toString())) {
                System.out.println("Puoi andare a Nord in " + actualMap.getN());
            } else if(actualMap.getS().equals(map.toString())) {
                System.out.println("Puoi andare a Sud in " + actualMap.getS());
            } else if(actualMap.getW().equals(map.toString())) {
                System.out.println("Puoi andare a Ovest in " + actualMap.getW());
            } else if(actualMap.getE().equals(map.toString())) {
                System.out.println("Puoi andare a Est in " + actualMap.getE());
            }
        }
    }

}
