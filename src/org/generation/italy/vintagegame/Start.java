package org.generation.italy.vintagegame;

import java.util.Scanner;

import org.generation.italy.vintagegame.model.Display;
import org.generation.italy.vintagegame.model.Player;

public class Start {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ciao, come ti chiami?");
        Player player = new Player(scanner.nextLine());
        Display.instruction(player.getName());
        Display.announceMap(player.getActualMap());
        String action;
        do {
            action = scanner.nextLine().toLowerCase();
            player.play(action);
        } while(!action.equals("exit"));
    }
}
