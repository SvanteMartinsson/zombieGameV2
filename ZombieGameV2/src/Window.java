import javax.swing.JFrame;

public class Window {


	public void windowSetup(String title, int width, int height, Main canvas){
		JFrame window = new JFrame();
		window.setSize(width, height);
		window.setTitle(title);
		window.add(canvas);
		window.requestFocus();
		window.setVisible(true);
		window.setResizable(false);
		window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
	}



}
