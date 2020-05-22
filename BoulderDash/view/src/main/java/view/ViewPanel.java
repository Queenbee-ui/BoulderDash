package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * Draws inside the graphic interface.
 *
 * @author Group 6; Eliphaz &amp;&amp; Christian &amp;&amp; Reine  &amp;&amp; Alexis
 */

class ViewPanel extends JPanel implements Observer {

	/** The view frame */

	private ViewFrame viewFrame;
	ImageIcon icofond,icofond1;
	Image imgfond,image;
	public static boolean debutJeu = false;
	/** The Constant serialVersionUID. */

	private static final long serialVersionUID = -998294702363713521L;

	/** Instantiates a new view panel.
	 *
	 * @param viewFrame the view frame
	 */

	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
//		this.icofond = new ImageIcon(getClass().getResource("C:\\Users\\hp\\Documents\\GitHub\\BoulderDash\\BoulderDash\\sprites\\bouldfond.png"));
//		this.imgfond = this.icofond.getImage();
//		this.icofond1 = new ImageIcon(getClass().getResource("C:\\Users\\hp\\Documents\\GitHub\\BoulderDash\\BoulderDash\\sprites\\fond.png"));
//		this.image = this.icofond1.getImage();
		
		try {
			this.imgfond = ImageIO.read(new File("C:\\Users\\hp\\Documents\\GitHub\\BoulderDash\\BoulderDash\\sprites\\bouldfond.png"));
			this.image = ImageIO.read(new File("C:\\Users\\hp\\Documents\\GitHub\\BoulderDash\\BoulderDash\\sprites\\fond.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */

	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	/*
	 * (non-Javadoc)
	 *
	 * Paints the graphic interface.
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		//graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		Graphics g2 = (Graphics2D)graphics;
		if(debutJeu == false) {
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.drawImage(image,0, 0, getWidth(), getHeight(), this);
		g2.drawImage(this.imgfond, 262, 40, null);
		
		Font font = new Font("Arial", Font.BOLD, 40);
		g2.setFont(font);
		g2.setColor(Color.white); 
		g2.drawString("Appuyez sur ENTRER pour commencer le jeu normal", 50, 390);
		g2.drawString("Appuyez sur Echap pour quitter le jeu normal", 50, 440);
		}else {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		ArrayList<entity.Tileset> DrawMap = this.getViewFrame().getModel().getMap();
		BufferedImage imageTemp = null;

		for (int i = 0; i < DrawMap.size(); i++) {

			try {
					imageTemp = ImageIO.read(new File("C:\\Users\\hp\\Documents\\GitHub\\BoulderDash\\BoulderDash\\sprites\\" + DrawMap.get(i).getFactory().getName() + ".png"));

			} catch (IOException e) {
				e.printStackTrace();
			}
			graphics.drawImage(imageTemp, DrawMap.get(i).getX() * 32, DrawMap.get(i).getY() * 32, 32, 32, null);
		}

		this.repaint();
		}
	}

}