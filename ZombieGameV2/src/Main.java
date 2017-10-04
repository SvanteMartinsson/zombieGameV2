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
	private Handler handler;

	
	public Main(){


		window = new Window();

		window.windowSetup(TITLE, WIDTH, HEIGHT, this);
		this.createBufferStrategy(3);
		bs = this.getBufferStrategy();
		handler = new Handler();
		grid = new Grid(720, 720, 20, 20, this, handler);
		loadMap = new LoadMap();
		loadMap.loadMap("level.dat");
		grid.setGridList(loadMap.getMap());
		player = new Player((WIDTH/2)-55, (HEIGHT/2)-70, 100, grid);
		
		this.addKeyListener(new KeyInput(player, handler));
		loop();

	}

	public void loop(){


		while(true){
			long lastTime = System.nanoTime();
			double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;
			long timer = System.currentTimeMillis();
			int frames = 0;
			while(true){
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;

				while(delta >=1){
					update();
					delta--;
				}

			
					render();

				

				frames++;


				if(System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					System.out.println("FPS: "+ frames);
					frames = 0;
				}


			}
		}

	}

	public void render(){
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		grid.drawGrid(g);
		player.render(g);
		handler.render(g);

		g.dispose();
		bs.show();

	}

	public void update(){
		player.update();
		handler.update();
		grid.checkCollision();
	}

	


	public static void main(String[] args){
		new Main();
	}

}
