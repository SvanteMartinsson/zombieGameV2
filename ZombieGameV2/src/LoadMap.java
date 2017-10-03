import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadMap {
	
	private BufferedReader reader;
	private int[][] map;
	
	public void loadMap(String fileName){
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String lineOne = reader.readLine();
			String[] lineArr = lineOne.split(":");
			int width = Integer.parseInt(lineArr[0]);
			int height = Integer.parseInt(lineArr[1]);
			map = new int[width][height];
			
			System.out.println(width + " " + height);
			System.out.println(lineOne);
			//System.out.println(reader.readLine());
			for(int y = 0; y < height; y++){
				String line = reader.readLine();
				String[] lineArrLoop = line.split("");
				System.out.println(y);
				for(int x = 0; x < width; x++){
					if(x!=19){
						
					}
					//System.out.println(lineArrLoop[x+1] + ":TEST");
					map[x][y] = Integer.parseInt(lineArrLoop[x]);
				}
			}
			
			reader.close();
			
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int[][] getMap(){
		return map;
	}

}
