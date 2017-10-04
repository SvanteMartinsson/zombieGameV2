import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet extends GameObject{

	

	
	public Bullet(int x, int y, float velX, float velY){
		velocity = 5;
		this.velX = velX;
		this.velY = velY;
		this.x = x;
		this.y = y;
	
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 3, 5);
	}

	@Override
	public void update() {
		x+=velX;
		y+=velY;
		
		
		
	}

	@Override
	public void setVelX(float velX) {
		this.velX = velX;
		
	}

	@Override
	public void setVelY(float velY) {
		this.velY = velY;
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 3, 5);
	}
	
	
	
	
	
	
	
	
	
}
