import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {

	
	protected int hp;
	protected float velX;
	protected float velY;
	protected float velocity;
	protected int x;
	protected int y;
	
	public abstract void render(Graphics2D g);
	public abstract void update();
	
	public abstract void setVelX(float velX);
	public abstract void setVelY(float velY);
	
	public abstract Rectangle getBounds();
	
}
