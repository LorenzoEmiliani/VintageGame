package org.generation.italy.vintagegame.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private ArrayList<String> inventary = new ArrayList<>();
    private Map actualMap;

    public Player(String name) {
        this.name = name;
        actualMap = Map.MARKETPLACE;
    }

    public void play(String action) {
        switch(action) {
            case "n":
                this.move("n");
                break;
            case "s":
                this.move("s");
                break;
            case "w":
                this.move("w");
                break;
            case "e":
                this.move("e");
                break;
            case "inv":
                this.inv();
                break;
            case "pick":
                System.out.println("Inserisci l'oggetto che vuoi prendere.");
                String objectPick = scanner.nextLine().toLowerCase();
                this.pick(objectPick);
                break;
            case "drop":
                System.out.println("Inserisci l'oggetto che vuoi lasciare.");
                String objectDrop = scanner.nextLine().toLowerCase();
                this.drop(objectDrop);
                break;
            case "exit":
                break;
            default:
                System.out.println("Azione non esistente.");
    }
   } 
    
    private void pick(String object) {
        if(!actualMap.getObject().isEmpty()) {
            for(int i = 0; i < actualMap.getObject().size(); i++) {
                if(object.equals(actualMap.getObject().get(i))) {
                    inventary.add(object);
                    actualMap.getObject().remove(i);
                    System.out.println("Hai aggiunto " + object + " al tuo inventario.");
                    return;
                }
            }
        System.out.println("Non c'è quest'oggetto in questa parte della mappa.");
        } else {
            System.out.println("Non ci sono oggetti in questa parte della mappa.");
        }
    }
    
    private void drop(String object) {
        if(!inventary.isEmpty()) {
            for(int i = 0; i < inventary.size(); i++) {
                if(object.equals(inventary.get(i))) {
                    actualMap.getObject().add(object);
                    inventary.remove(i);
                    System.out.println("Hai lasciato " + object + " in " + actualMap + ".");
                    return;
                }
            }
            System.out.println("Non possiedi questo oggetto.");
        } else {
            System.out.println("Il tuo inventario è vuoto.");
        }  
    }

    private void move(String direction) {
        Map newMap = actualMap.move(direction);
        if(newMap.equals(actualMap)) {
            System.out.println("Direzione non corretta.");
        } else {
            actualMap = newMap;
            Display.announceMap(actualMap);
        }
    }

    private void inv() {
        if(!inventary.isEmpty()) {
            System.out.println("Nel tuo inventario hai " + inventary.toString());
        } else {
            System.out.println("Non ci sono oggetti nel tuo inventario.");
        }
    }

    public Map getActualMap() {
        return actualMap;
    }

    public String getName() {
        return name;
    }
}
