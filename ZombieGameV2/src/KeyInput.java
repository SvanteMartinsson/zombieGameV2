import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

	private Player player;

	public KeyInput(Player player){
		this.player = player;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_W){
			player.setVelY(-player.getVelocity());
		}
		if(key == KeyEvent.VK_A){
			player.setVelX(-player.getVelocity());
		}
		if(key == KeyEvent.VK_S){
			player.setVelY(player.getVelocity());
		}
		if(key == KeyEvent.VK_D){
			player.setVelX(player.getVelocity());
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
