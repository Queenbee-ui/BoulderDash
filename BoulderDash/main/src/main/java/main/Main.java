/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.*;
import controller.Controller;
import model.Model;
import view.View;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The Class Main.
 *
 * @author Group 6; Eliphaz &amp;&amp; Alexis &amp;&amp; Reine  &amp;&amp; Christian
 */

public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     *
     * @throws IOException
     *              the IOException
     *
     * @throws SQLException
     *              the SQLException
     *
     * @throws InterruptedException
     *              the InterruptedException
     */

    public static void main(final String[] args) throws IOException, SQLException, InterruptedException {

        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);

        controller.orderPerform(ControllerOrder.STAND);
        controller.play();

    }
}