public class Arena {
    private Player playerA;
    private Player playerB;
    private Die die;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.die = new Die();
    }

    public void fight() {
        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() < playerB.getHealth()) {
                takeTurn(playerA, playerB);
                if (playerB.isAlive()) {
                    takeTurn(playerB, playerA);
                }
            } else {
                takeTurn(playerB, playerA);
                if (playerA.isAlive()) {
                    takeTurn(playerA, playerB);
                }
            }
        }

        if (!playerA.isAlive()) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("Player A wins!");
        }
    }

    private void takeTurn(Player attacker, Player defender) {
        int attackRoll = die.roll();
        int defenseRoll = die.roll();
        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int damage = Math.max(attackDamage - defenseStrength, 0);
        defender.reduceHealth(damage);

        System.out.println(attacker + " attacks " + defender + " for " + damage + " damage!");
        System.out.println(defender + " health: " + defender.getHealth());
    }
}
