import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

public class Main extends Canvas {

	private final String TITLE = "Zombie Game V2";
	private int WIDTH = 720;
	private int HEIGHT = 720;
	private Window window;
	private BufferStrategy bs;
	private Grid grid;
	private LoadMap loadMap;
	private Player player;

	
	public Main(){


		window = new Window();

		window.windowSetup(TITLE, WIDTH, HEIGHT, this);
		this.createBufferStrategy(3);
		bs = this.getBufferStrategy();
		grid = new Grid(720, 720, 20, 20, this);
		loadMap = new LoadMap();
		loadMap.loadMap("level.dat");
		grid.setGridList(loadMap.getMap());
		player = new Player(100, 100, 100, grid);
		this.addKeyListener(new KeyInput(player));
		loop();

	}

	public void loop(){


		while(true){
			update();
			render();
		}

	}

	public void render(){
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		grid.drawGrid(g);
		player.render(g);

		g.dispose();
		bs.show();

	}

	public void update(){
		player.update();
	}

	


	public static void main(String[] args){
		new Main();
	}

}
