package loggi;

public class PacotesOrdem1 extends Pacotes implements Comparable<PacotesOrdem1> {
	
	
	public PacotesOrdem1(String codigoDeBarras, int codigo) {
		super(codigoDeBarras);
		this.setCodigo(codigo);

	}


	@Override
	public int compareTo(PacotesOrdem1 outroPacote) {
		
		if(this.getDestino().equals("Centro-oeste") && outroPacote.getDestino().equals("Norte"))
			return -1;
		else if(this.getDestino().equals("Norte") && outroPacote.getDestino().equals("Centro-oeste"))
			return 1;
		else {
			int num = Integer.parseInt(divideTrinca(this.getCodigoDeBarras(), 2));
			int outroNum = Integer.parseInt(divideTrinca(outroPacote.getCodigoDeBarras(), 2));
			if(num > outroNum)
				return -1;
			else
				return 1;
		}
	}

	
	
}
	
	
