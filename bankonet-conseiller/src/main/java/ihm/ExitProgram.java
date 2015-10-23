package ihm;

public class ExitProgram extends IhmCommand{

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Arrêter le programme";
	}

	@Override
	void Execute() {
		System.out.println("Arrêt du programme");
		System.exit(0);
		
	}

}
