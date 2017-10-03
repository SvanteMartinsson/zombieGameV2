import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tileset {
	
	enum Tile{
		GRASS, STONE_WALL;
	}
	
	private Grid grid;
	private int tWidth;
	private int tHeight;
	private BufferedImage tileSet;
	
	public Tileset(Grid grid){
		this.grid = grid;
		tWidth = 16;
		tHeight = 16;
		try {
			tileSet = ImageIO.read(new FileInputStream("res/tilesBasic.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void drawTile(Graphics2D g, String tile, int x, int y){
		if(tile.equals("FLOOR_BASIC")){
			Image image = tileSet.getSubimage(16, 144, 16, 16);
			g.drawImage(image, x, y, grid.getBlocksWidth()+16, grid.getBlocksHeight()+13, null);
		}else if(tile.equals("STONE_WALL")){
			Image image = tileSet.getSubimage(112, 16, 16, 16);
			g.drawImage(image, x, y, grid.getBlocksWidth()+16, grid.getBlocksHeight()+13, null);
		}else if(tile.equals("ZOMBIE_SPAWNER")){
			Image image = tileSet.getSubimage(112, 80, 16, 16);
			g.drawImage(image, x, y, grid.getBlocksWidth()+16, grid.getBlocksHeight()+13, null);
		}else if(tile.equals("FLOOR_LAVA")){
			Image image = tileSet.getSubimage(0, 32, 16, 16);
			g.drawImage(image, x, y, grid.getBlocksWidth()+16, grid.getBlocksHeight()+13, null);
		}else if(tile.equals("TORCH")){
			Image image = tileSet.getSubimage(64, 112, 16, 16);
			g.drawImage(image, x, y, grid.getBlocksWidth()+16, grid.getBlocksHeight()+13, null);
		}
	}
	
	

}
