package loggi;

public class Pacotes {

	public static int totalPacotes = 0;
	public static int totalPacotesValidos = 0;
	private int codigo;
	private String codigoDeBarras;
	private String origem;
	private String destino;
	private String codLoggi;
	private String codVendedor;
	private String produto;
	
	private boolean invalido;

	
	public Pacotes(String codigoDeBarras) {
		
		this.codigoDeBarras = codigoDeBarras;
		this.origem = retornaRegiaoOrigem(codigoDeBarras);
		this.destino = retornaRegiaoDestino(codigoDeBarras);
		this.codLoggi = divideTrinca(codigoDeBarras, 3);
		this.codVendedor = divideTrinca(codigoDeBarras, 4);
		this.produto = retornaProduto(codigoDeBarras);
		
		if(this.origem.equals("Código Inválido!") || this.destino.equals("Código Inválido!") || this.produto.equals("Código Inválido!"))
			this.invalido = true;
		if(this.origem.equals("Centro-oeste") && this.produto.equals("Jóias"))
			this.invalido = true;
		if(this.codVendedor.equals("367"))
			this.invalido = true;
		
		Pacotes.totalPacotes++;
		if(!this.invalido)
			Pacotes.totalPacotesValidos++;
		this.codigo = Pacotes.totalPacotes;
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean getinvalido() {
		return invalido;
	}
	
	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public String getCodLoggi() {
		return codLoggi;
	}

	public String getCodVendedor() {
		return codVendedor;
	}

	public String getProduto() {
		return produto;
	}

	protected String divideTrinca(String codigoBarras, int trinca) {
		
		if(trinca<=0 || trinca>5)
			return null;
		
		trinca -= 1;
		return codigoBarras.substring((trinca *3), (trinca *3)+3);
	}
	
	private String retornaRegiao(String codigoBarras, int trinca) {
		String codigo = divideTrinca(codigoBarras, trinca);
		if(codigo.substring(0, 1).equals("0"))
			return "Sudeste";
		else if(codigo.substring(0, 1).equals("1"))
			return "Sul";
		else if(codigo.substring(0, 1).equals("2"))
			return "Centro-oeste";
		else if(codigo.substring(0, 1).equals("3"))
			return "Nordeste";
		else if(codigo.substring(0, 1).equals("4"))
			return "Norte";
		else
			return "Código Inválido!";
	}
	
	
	public String retornaRegiaoOrigem(String codigoBarras) {
		
		return retornaRegiao(codigoBarras, 1);		
	}
	
	public String retornaRegiaoDestino(String codigoBarras) {
		
		return retornaRegiao(codigoBarras, 2);	
	}
	
	private String retornaProduto(String codigoBarras) {
		String codigo = divideTrinca(codigoBarras, 5);
		if(codigo.substring(0, 3).equals("001"))
			return "Jóias";
		else if(codigo.substring(0, 3).equals("111"))
			return "Livro";
		else if(codigo.substring(0, 3).equals("333"))
			return "Eletrônicos";
		else if(codigo.substring(0, 3).equals("555"))
			return "Bebidas";
		else if(codigo.substring(0, 3).equals("888"))
			return "Briquedos";
		else
			return "Código Inválido!";
	}

	@Override
	public String toString() {
		return "Pacotes [codigo=" + codigo + ", origem=" + origem + ", destino=" + destino + ", codLoggi=" + codLoggi
				+ ", codVendedor=" + codVendedor + ", produto=" + produto + ", invalido=" + invalido + "]";
	}
	
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
}
