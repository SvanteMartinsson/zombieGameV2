import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {

	
	private int hp;
	private float velX;
	private float velY;
	private int x;
	private int y;
	private float velocity;
	private Grid grid;
	
	
	public Player(int x, int y, int hp, Grid grid){
		this.hp = hp;
		this.x = x;
		this.y = y;
		velX = 0;
		velY = 0;
		velocity = 5;
		this.grid = grid;
	}
	
	public void render(Graphics2D g){
		g.setColor(Color.RED);
		g.fillRect(x, y, 15, 15);
	}
	
	public void update(){
		x += velX;
		y += velY;
		
		for(int i = 0; i < grid.getCollisionList().size(); i++){
			if(getLeftBounds().intersects((Rectangle) grid.getCollisionList().get(i))){
				x+=velocity;
			}
			if(getRightBounds().intersects((Rectangle) grid.getCollisionList().get(i))){
				x-=velocity;
			}
			if(getUpperBounds().intersects((Rectangle) grid.getCollisionList().get(i))){
				y+=velocity;
			}
			if(getLowerBounds().intersects((Rectangle) grid.getCollisionList().get(i))){
				y-=velocity;
			}
		}
	}
	
	public void checkCollision(){
		
	}
	
	public void setVelX(float velX){
		this.velX = velX;
	}
	
	public void setVelY(float velY){
		this.velY = velY;
	}
	
	public float getVelocity(){
		return velocity;
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle(x, y+2, 2, 11);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle(x+13, y+2, 2, 11);
	}
	
	public Rectangle getUpperBounds(){
		return new Rectangle(x, y, 15, 2);
	}
	
	public Rectangle getLowerBounds(){
		return new Rectangle(x, y+13, 15, 2);
	}
	
}
