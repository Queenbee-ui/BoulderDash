package contract;

/**
 * The Interface IController.
 *
 * Shows methods other package need from UserOrder
 *
 * @author Group 6; Reine &amp;&amp; Eliphaz &amp;&amp; Alexis  &amp;&amp; Christian
 */

public interface IUserOrder {

    /**
     * Gets the player
     *
     * @return the player
     */

    int getPlayer();

    /**
     * Gets the order
     *
     * @return the order
     */

    ControllerOrder getOrder();
}