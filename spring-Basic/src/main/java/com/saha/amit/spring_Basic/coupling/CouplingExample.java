package com.saha.amit.spring_Basic.coupling;

interface GameRunner {
    void run();
}

class MarioGame implements GameRunner {
    @Override
    public void run() {
        System.out.println("Mario is running!");
    }
}

class SuperContra implements GameRunner {
    @Override
    public void run() {
        System.out.println("Contra is running!");
    }
}

/**
 * LOOSE COUPLING: GameConsole depends on an interface, not a specific implementation.
 * We can easily swap Mario for Contra.
 */
class GameConsole {
    private final GameRunner game;

    public GameConsole(GameRunner game) {
        this.game = game;
    }

    public void playGame() {
        game.run();
    }
}
