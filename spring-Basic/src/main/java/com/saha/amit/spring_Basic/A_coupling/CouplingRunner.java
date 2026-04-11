package com.saha.amit.spring_Basic.A_coupling;

/**
 * RUNNER: Pure Java execution to show A_coupling.
 */
public class CouplingRunner {
    public static void main(String[] args) {
        System.out.println("--- Coupling Demo ---");
        
        // Loose Coupling: GameConsole accepts any GameRunner
        GameRunner mario = new MarioGame();
        GameConsole console = new GameConsole(mario);
        console.playGame();

        GameRunner contra = new SuperContra();
        GameConsole console2 = new GameConsole(contra);
        console2.playGame();
    }

    interface GameRunner {
        void run();
    }

    static class MarioGame implements GameRunner {
        @Override
        public void run() {
            System.out.println("Mario is running!");
        }
    }

    static class SuperContra implements GameRunner {
        @Override
        public void run() {
            System.out.println("Contra is running!");
        }
    }

    /**
     * LOOSE COUPLING: GameConsole depends on an interface, not a specific implementation.
     * We can easily swap Mario for Contra.
     */
    static class GameConsole {
        private final GameRunner game;

        public GameConsole(GameRunner game) {
            this.game = game;
        }

        public void playGame() {
            game.run();
        }
    }
}


