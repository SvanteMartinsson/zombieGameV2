import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Grid {

	private int width = 0;
	private int height = 0;
	private int blocksWidth = 0;
	private int blocksHeight = 0;
	private int tWidth;
	private int tHeight;
	private int[][] gridList;
	private ArrayList<Rectangle> collisionList;
	private Tileset tiles;
	private BufferedImage tileSet;
	private Main main;
	
	public Grid(int width, int height, int blocksWidth, int blocksHeight, Main main){
		this.width = width;
		this.height = height;
		this.blocksHeight = blocksHeight;
		this.blocksWidth = blocksWidth;
		gridList = new int[blocksWidth][blocksHeight];
		collisionList = new ArrayList<Rectangle>();
		tWidth = 16;
		tHeight = 16;
		this.main = main;
		//System.out.println(this.getClass().getResource("res/tilesBasic.png"));
		tiles = new Tileset(this);
	}

	public void initGrid(){
		for(int y = 0; y < blocksHeight; y++){
			for(int x = 0; x < blocksWidth; x++){
				gridList[x][y] = 0;
			}
		}
	}


	// minus 1 on height is needed for unknown reason
	public void drawGrid(Graphics2D g){
		int height = (this.height-100)/blocksHeight;
		int posY = 0;
		for(int y = 0; y < blocksHeight; y++){
			int width = this.width/blocksWidth;
			int posX = 0;
			for(int x = 0; x < blocksWidth; x++){

				if(gridList[x][y] == 0){
					g.setColor(Color.black);
				}else if(gridList[x][y] == 1){
					//g.setColor(Color.RED);
					tiles.drawTile(g, "FLOOR_BASIC", posX, posY);
					
				}else if(gridList[x][y] == 2){
					//g.setColor(Color.GREEN);
					tiles.drawTile(g, "STONE_WALL", posX, posY);
					collisionList.add(new Rectangle(posX, posY, 36, 36));
					
				}else if(gridList[x][y] == 3){
					tiles.drawTile(g, "FLOOR_LAVA", posX, posY);
				}

				if(gridList[x][y] == 0){
					g.drawRect(posX, posY, width, height);
				}else if(gridList[x][y] == 1){
					
				}else{
				
					//g.fillRect(posX, posY, width, height);
				}

				posX += width;
			}
			posY += height;
		}
	}
	
	

	public void setGridItem(int x, int y, int num){

		if(x < blocksWidth && y < blocksHeight)
			gridList[x][y] = num;

	}
	
	public int getBlocksWidth(){
		return blocksWidth;
	}
	
	public int getBlocksHeight(){
		return blocksHeight;
	}

	public int[][] getMap(){
		return gridList;
	}
	
	public int getGridWidth(){
		return blocksWidth;
	}
	
	public int getGridHeight(){
		return blocksHeight;
	}
	
	public Tileset getTileset(){
		return tiles;
	}
	
	public void setGridList(int[][] gridList){
		this.gridList = gridList;
	}
	
	public ArrayList getCollisionList(){
		return collisionList;
	}


}
