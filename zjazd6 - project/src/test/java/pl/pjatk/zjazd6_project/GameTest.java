package pl.pjatk.zjazd6_project;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameTest {

    private final Game game;
    private final Random rand;

    public GameTest() {
        this.game = new Game();
        this.rand = new Random();
    }

    @Test
    public void gameTest() throws InterruptedException {
        game.printBoard();
        System.out.println();
        while (!game.isFinished()) {
            Thread.sleep(2000);
            int move = rand.nextInt(4);
            switch (move) {
                case 0 -> game.moveUp();
                case 1 -> game.moveDown();
                case 2 -> game.moveLeft();
                case 3 -> game.moveRight();
            }
            game.printBoard();
            System.out.println();
        }
        assertThat(game.isFinished(), is(true));
    }
}
