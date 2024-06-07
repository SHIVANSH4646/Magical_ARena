import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testReduceHealth() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(30);
        assertEquals(20, player.getHealth());
        player.reduceHealth(50);
        assertEquals(0, player.getHealth());
    }
com.sun.tools.javac.launcher
    @Test
    public void testIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
        player.reduceHealth(50);
        assertFalse(player.isAlive());
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class DieTest {
    @Test
    public void testRoll() {
        Die die = new Die();
        for (int i = 0; i < 100; i++) {
            int roll = die.roll();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}

import org.junit.Test;
import static org.junit.Assert.*;

public class ArenaTest {
    @Test
    public void testFight() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        Arena arena = new Arena(playerA, playerB);

        arena.fight();
        assertTrue(!playerA.isAlive() || !playerB.isAlive());
    }
}
