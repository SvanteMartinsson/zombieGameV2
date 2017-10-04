import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Handler {

	private ArrayList<GameObject> objList = new ArrayList<GameObject>();
	
	public void render(Graphics2D g){
		for(int i = 0; i < objList.size(); i++){
			objList.get(i).render(g);
		}
	}
	
	public void update(){
		for(int i = 0; i < objList.size(); i++){
			objList.get(i).update();
		}
	}
	
	public void addObject(GameObject obj){
		objList.add(obj);
	}
	
	public void removeObject(int i){
		objList.remove(i);
	}
	
	public ArrayList getObjList(){
		return objList;
	}
	
	public Rectangle getBounds(int i){
		return objList.get(i).getBounds();
	}
	
}
