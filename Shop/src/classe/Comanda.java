package classe;

public class Comanda {
	private String adreçaEnvio;
	private Client client;
	private Model model;
	private Pagament tipusPagament;
	
	
	public Comanda(Client client, Model model){
		this.client=client;
		this.model=model;
	}

}
