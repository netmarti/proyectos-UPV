package excepciones;

public class InmuebleYaExiste extends Exception{
	
	public InmuebleYaExiste() {
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		//return super.getMessage();
		return "Mensaje de error.";
	}

}
