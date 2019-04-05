import model.Model;
import view.CommandLineView;
import view.ConsolePGView;
import view.View;
import ctrl.Ctrl;

public class TicTacToe {
	
	public static void main(String[] args) {
		
		final Model model = new Model();
		final View  view  = new ConsolePGView();
		
		final Ctrl ctrl = new Ctrl(model, view);
		ctrl.run();
	}
	
}
