package repository;
import java.util.ArrayList;
import java.util.List;

import Model.Condominio;
public class CondominioRepository {

	private List<Condominio> condominios = new ArrayList<Condominio>();
	
	public CondominioRepository() {		
	}
	
	public void addCondominio(Condominio condominio) {
		this.condominios.add(condominio);
	}

	public List<Condominio> getCondominios() {
		return condominios;
	}
}
