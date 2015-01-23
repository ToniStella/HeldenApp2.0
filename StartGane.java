public class StartGame 
{
	public static void main(String[] args) 
	{
		HeldenApp heldenApp = new HeldenApp();
		MiniGameGui gui 	= new MiniGameGui(heldenApp);
		gui.setVisible(true);
	}
}
