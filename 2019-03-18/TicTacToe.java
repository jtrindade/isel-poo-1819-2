import model.Model;
import view.View;
import ctrl.Ctrl;

public class TicTacToe {
	
	public static void main(String[] args) {
		
		final Model model = new Model();
		final View  view  = new View();
		
		final Ctrl ctrl = new Ctrl(model, view);
		ctrl.run();
	}
	
}
