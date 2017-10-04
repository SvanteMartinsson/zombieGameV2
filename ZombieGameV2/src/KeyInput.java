import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

	private Player player;
	private int lastKey;
	private Handler handler;

	public KeyInput(Player player, Handler handler){
		this.player = player;
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_W){
			player.setVelY(-player.getVelocity());
			lastKey = KeyEvent.VK_W;
		}
		if(key == KeyEvent.VK_A){
			player.setVelX(-player.getVelocity());
			lastKey = KeyEvent.VK_A;
		}
		if(key == KeyEvent.VK_S){
			player.setVelY(player.getVelocity());
			lastKey = KeyEvent.VK_S;
		}
		if(key == KeyEvent.VK_D){
			player.setVelX(player.getVelocity());
			lastKey = KeyEvent.VK_D;
		}
		
		if(key == KeyEvent.VK_SPACE){
			if(lastKey == 87){
				handler.addObject(new Bullet(player.getX()+4, player.getY()-4, 0, -5));
			}
			if(lastKey == 65){
				handler.addObject(new Bullet(player.getX()-3, player.getY()+5, -5, 0));
			}
			if(lastKey == 83){
				handler.addObject(new Bullet(player.getX()+4, player.getY()+17, 0, 5));
			}
			if(lastKey == 68){
				handler.addObject(new Bullet(player.getX()+16, player.getY()+5, 5, 0));
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W){
			player.setVelY(0);
		}
		if(key == KeyEvent.VK_A){
			player.setVelX(0);		
		}
		if(key == KeyEvent.VK_S){
			player.setVelY(0);
		}
		if(key == KeyEvent.VK_D){
			player.setVelX(0);
		}
		
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
