package attacks;
import character.*;
import character.Character;
public abstract class Attack {
	    private Attack next;

	    /**
	     * Builds chains of middleware objects.
	     */
	    public Attack linkWith(Attack next) {
	        this.next = next;
	        return next;
	    }

	    /**
	     * Subclasses will implement this method with concrete checks.
	     */
	    public abstract boolean execute(Character character, Character enemy);

	    /**
	     * Runs check on the next object in chain or ends traversing if we're in
	     * last object in chain.
	     */
	    protected boolean attackNext(Character character, Character enemy) {
	        if (next == null) {
	            return true;
	        }
	        return next.execute(character, enemy);
	    }
}
