package loggi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppMain {
	

	public static void main(String[] args) {
		
		List<String> codigosPacotes = carregaPacotes();
		List<Pacotes> pacotes = new ArrayList<>();
		for (String codigo : codigosPacotes) {
			pacotes.add(new Pacotes(codigo));
		}
		
		
		identificaRegiaoDestinoETotal(pacotes);
		identificaValidosEInvalidos(pacotes);
		origemSulEBrinquedos(pacotes);
		listarOsPacotesAgrupados(pacotes);
		pacotesEnviadosPorVendedor(pacotes);
		listaDePacotesPorDestinoETipo(pacotes);
		pacotesDespachadosPeloMesmoCaminhao(pacotes);
		filaDestinoNorteECentroOeste(pacotes);
		filaDestinoNorteECentroOesteJoiasPrimeiro(pacotes);
		listarPacotesInvalidos(pacotes);
		
	}
	
	
	public static List<String> carregaPacotes(){
		List<String > lista = new ArrayList<String>();
		lista.add("288355555123888");
		lista.add("335333555584333");
		lista.add("223343555124001");
		lista.add("002111555874555");
		lista.add("111188555654777");
		lista.add("111333555123333");
		lista.add("432055555123888");
		lista.add("079333555584333");
		lista.add("155333555124001");
		lista.add("333188555584333");
		lista.add("555288555123001");
		lista.add("111388555123555");
		lista.add("288000555367333");
		lista.add("066311555874001");
		lista.add("110333555123555");
		lista.add("333488555584333");
		lista.add("455448555123001");
		lista.add("022388555123555");
		lista.add("432044555845333");
		lista.add("034311555874001");
		return lista;
	}
	
	
	public static void identificaRegiaoDestinoETotal(List<Pacotes> pacotes) {
		int no = 0;
		int ne = 0;
		int se = 0;
		int su = 0;
		int co = 0;
		
		for (int i = 0; i<pacotes.size(); i++) {
			System.out.println("Pacote "+(i+1)+": "+pacotes.get(i).getDestino());
			
			if(pacotes.get(i).getDestino().equals("Sudeste"))
				se++;
			if(pacotes.get(i).getDestino().equals("Sul"))
				su++;
			if(pacotes.get(i).getDestino().equals("Centro-oeste"))
				co++;
			if(pacotes.get(i).getDestino().equals("Norte"))
				no++;
			if(pacotes.get(i).getDestino().equals("Nordeste"))
				ne++;		
		}
		
		System.out.println("--------------------------------");
		System.out.println("Total Pacotes destino Norte: "+ no);
		System.out.println("Total Pacotes destino Nordeste: "+ ne);
		System.out.println("Total Pacotes destino Sul: "+ su);
		System.out.println("Total Pacotes destino Sudeste: "+ se);
		System.out.println("Total Pacotes destino Centro-oeste: "+ co);
	}
	
	public static void identificaValidosEInvalidos(List<Pacotes> pacotes) {
		for (int i = 0; i<pacotes.size(); i++) {
			if(pacotes.get(i).getinvalido())
				System.out.println("Pacote "+(i+1)+": Inválido!");
			else
				System.out.println("Pacote "+(i+1)+": Válido!");
		}		
	}
	
	public static void origemSulEBrinquedos(List<Pacotes> pacotes) {
		System.out.println("Pacotes de Origem Sul com Brinquedos: ");
		int j = 0;
		for(Pacotes pacote: pacotes) {
			if(pacote.getOrigem().equalsIgnoreCase("sul") && pacote.getProduto().equalsIgnoreCase("brinquedos")) {
				System.out.println("Pacote "+pacote.getCodigo());
				j++;
			}
		}
		if(j==0)
			System.out.println("Nenhum pacote satisfaz condição");
	}
	
	public static void listarOsPacotesAgrupados(List<Pacotes> pacotes) {
		
		List<String> nordeste = new ArrayList<>();
		List<String> norte = new ArrayList<>();
		List<String> centrooeste = new ArrayList<>();
		List<String> sul = new ArrayList<>();
		List<String> sudeste = new ArrayList<>();
		
		for (Pacotes pacote: pacotes) {
			if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("nordeste")) {
				nordeste.add("Pacote "+pacote.getCodigo());		
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("norte")) {
				norte.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("centro-oeste")) {
				centrooeste.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("sul")) {
				sul.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("sudeste")) {
				sudeste.add("Pacote "+pacote.getCodigo());
			}
		}
		System.out.println("Pacotes válidos enviados para o Nordeste: " + nordeste);
		System.out.println("Pacotes válidos enviados para o Norte: " + norte);
		System.out.println("Pacotes válidos enviados para o Centro-Oeste: " + centrooeste);
		System.out.println("Pacotes válidos enviados para o Sul: " + sul);
		System.out.println("Pacotes válidos enviados para o Sudeste: " + sudeste);
		
	}
	
	public static void pacotesEnviadosPorVendedor(List<Pacotes> pacotes) {
		Set<String> codigoVendedor = new HashSet<String>();
		for (Pacotes pacote: pacotes) {
			if(!pacote.getinvalido() ) {
				codigoVendedor.add(pacote.getCodVendedor());		
			}
		}
		for(String codigo: codigoVendedor){
			int nun = 0;
			System.out.print("Vendendor "+codigo);
			for(Pacotes pacote: pacotes){
				if(!pacote.getinvalido() && pacote.getCodVendedor().equals(codigo)){
					//System.out.println("Pacote "+pacote.getCodigo());
					nun++;
				}
			}
			System.out.print(": " + nun + "\n");
		}	
	}
	
	public static void listaDePacotesPorDestinoETipo(List<Pacotes> pacotes) {
		List<String> nordesteEJoias = new ArrayList<>();
		List<String> nordesteELivros = new ArrayList<>();
		List<String> nordesteEEletronicos = new ArrayList<>();
		List<String> nordesteEBebidas = new ArrayList<>();
		List<String> nordesteEBrinquedos = new ArrayList<>();
		List<String> norteEJoias = new ArrayList<>();
		List<String> norteELivros = new ArrayList<>();
		List<String> norteEEletronicos = new ArrayList<>();
		List<String> norteEBebidas = new ArrayList<>();
		List<String> norteEBrinquedos = new ArrayList<>();
		List<String> centroOesteEJoias = new ArrayList<>();
		List<String> centroOesteELivros = new ArrayList<>();
		List<String> centroOesteEEletronicos = new ArrayList<>();
		List<String> centroOesteEBebidas = new ArrayList<>();
		List<String> centroOesteEBrinquedos = new ArrayList<>();
		List<String> sulEJoias = new ArrayList<>();
		List<String> sulELivros = new ArrayList<>();
		List<String> sulEEletronicos = new ArrayList<>();
		List<String> sulEBebidas = new ArrayList<>();
		List<String> sulEBrinquedos = new ArrayList<>();
		List<String> sudesteEJoias = new ArrayList<>();
		List<String> sudesteELivros = new ArrayList<>();
		List<String> sudesteEEletronicos = new ArrayList<>();
		List<String> sudesteEBebidas = new ArrayList<>();
		List<String> sudesteEBrinquedos = new ArrayList<>();

		
		for (Pacotes pacote: pacotes) {
			if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("nordeste") && pacote.getProduto().equalsIgnoreCase("jóias")) {
				nordesteEJoias.add("Pacote "+pacote.getCodigo());		
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("nordeste") && pacote.getProduto().equalsIgnoreCase("livros")) {
				nordesteELivros.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("nordeste") && pacote.getProduto().equalsIgnoreCase("eletrônicos")) {
				nordesteEEletronicos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("nordeste") && pacote.getProduto().equalsIgnoreCase("bebidas")) {
				nordesteEBebidas.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("nordeste") && pacote.getProduto().equalsIgnoreCase("brinquedos")) {
				nordesteEBrinquedos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("norte") && pacote.getProduto().equalsIgnoreCase("jóias")) {
				norteEJoias.add("Pacote "+pacote.getCodigo());		
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("norte") && pacote.getProduto().equalsIgnoreCase("livros")) {
				norteELivros.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("norte") && pacote.getProduto().equalsIgnoreCase("eletrônicos")) {
				norteEEletronicos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("norte") && pacote.getProduto().equalsIgnoreCase("bebidas")) {
				norteEBebidas.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("norte") && pacote.getProduto().equalsIgnoreCase("brinquedos")) {
				norteEBrinquedos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("centro-oeste") && pacote.getProduto().equalsIgnoreCase("jóias")) {
				centroOesteEJoias.add("Pacote "+pacote.getCodigo());		
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("centro-oeste") && pacote.getProduto().equalsIgnoreCase("livros")) {
				centroOesteELivros.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("centro-oeste") && pacote.getProduto().equalsIgnoreCase("eletrônicos")) {
				centroOesteEEletronicos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("centro-oeste") && pacote.getProduto().equalsIgnoreCase("bebidas")) {
				centroOesteEBebidas.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("centro-oeste") && pacote.getProduto().equalsIgnoreCase("brinquedos")) {
				centroOesteEBrinquedos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sul") && pacote.getProduto().equalsIgnoreCase("jóias")) {
				sulEJoias.add("Pacote "+pacote.getCodigo());		
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sul") && pacote.getProduto().equalsIgnoreCase("livros")) {
				sulELivros.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sul") && pacote.getProduto().equalsIgnoreCase("eletrônicos")) {
				sulEEletronicos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sul") && pacote.getProduto().equalsIgnoreCase("bebidas")) {
				sulEBebidas.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sul") && pacote.getProduto().equalsIgnoreCase("brinquedos")) {
				sulEBrinquedos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sudeste") && pacote.getProduto().equalsIgnoreCase("jóias")) {
				sudesteEJoias.add("Pacote "+pacote.getCodigo());		
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sudeste") && pacote.getProduto().equalsIgnoreCase("livros")) {
				sudesteELivros.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sudeste") && pacote.getProduto().equalsIgnoreCase("eletrônicos")) {
				sudesteEEletronicos.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sudeste") && pacote.getProduto().equalsIgnoreCase("bebidas")) {
				sudesteEBebidas.add("Pacote "+pacote.getCodigo());
			}
			else if(!pacote.getinvalido() && pacote.getDestino().equalsIgnoreCase("Sudeste") && pacote.getProduto().equalsIgnoreCase("brinquedos")) {
				sudesteEBrinquedos.add("Pacote "+pacote.getCodigo());
			}
		}
		System.out.println("Pacotes válidos enviados para o Nordeste com produto Jóia: " + nordesteEJoias);
		System.out.println("Pacotes válidos enviados para o Nordeste com produto Livros: " + nordesteELivros);
		System.out.println("Pacotes válidos enviados para o Nordeste com produto Eletrônicos: " + nordesteEEletronicos);
		System.out.println("Pacotes válidos enviados para o Nordeste com produto Bebidas: " + nordesteEBebidas);
		System.out.println("Pacotes válidos enviados para o Nordeste com produto Brinquedos: " + nordesteEBrinquedos);
		System.out.println("Pacotes válidos enviados para o Norte com produto Jóia: " + norteEJoias);
		System.out.println("Pacotes válidos enviados para o Norte com produto Livros: " + norteELivros);
		System.out.println("Pacotes válidos enviados para o Norte com produto Eletrônicos: " + norteEEletronicos);
		System.out.println("Pacotes válidos enviados para o Norte com produto Bebidas: " + norteEBebidas);
		System.out.println("Pacotes válidos enviados para o Norte com produto Brinquedos: " + norteEBrinquedos);
		System.out.println("Pacotes válidos enviados para o Centro-Oeste com produto Jóia: " + centroOesteEJoias);
		System.out.println("Pacotes válidos enviados para o Centro-Oeste com produto Livros: " + centroOesteELivros);
		System.out.println("Pacotes válidos enviados para o Centro-Oeste com produto Eletrônicos: " + centroOesteEEletronicos);
		System.out.println("Pacotes válidos enviados para o Centro-Oeste com produto Bebidas: " + centroOesteEBebidas);
		System.out.println("Pacotes válidos enviados para o Centro-Oeste com produto Brinquedos: " + centroOesteEBrinquedos);
		System.out.println("Pacotes válidos enviados para o Sul com produto Jóia: " + sulEJoias);
		System.out.println("Pacotes válidos enviados para o Sul com produto Livros: " + sulELivros);
		System.out.println("Pacotes válidos enviados para o Sul com produto Eletrônicos: " + sulEEletronicos);
		System.out.println("Pacotes válidos enviados para o Sul com produto Bebidas: " + sulEBebidas);
		System.out.println("Pacotes válidos enviados para o Sul com produto Brinquedos: " + sulEBrinquedos);
		System.out.println("Pacotes válidos enviados para o Sudeste com produto Jóia: " + sudesteEJoias);
		System.out.println("Pacotes válidos enviados para o Sudeste com produto Livros: " + sudesteELivros);
		System.out.println("Pacotes válidos enviados para o Sudeste com produto Eletrônicos: " + sudesteEEletronicos);
		System.out.println("Pacotes válidos enviados para o Sudeste com produto Bebidas: " + sudesteEBebidas);
		System.out.println("Pacotes válidos enviados para o Sudeste com produto Brinquedos: " + sudesteEBrinquedos);
				
	}
	public static void pacotesDespachadosPeloMesmoCaminhao(List<Pacotes> pacotes) {
		List<String> cargaNorteECentroOeste = new ArrayList<>();
		
		for (Pacotes pacote: pacotes) {
			if(pacote.getDestino().equalsIgnoreCase("norte") || pacote.getDestino().equalsIgnoreCase("centro-oeste")) {
				cargaNorteECentroOeste.add("Pacote "+pacote.getCodigo());		
			}
		}
		System.out.println(cargaNorteECentroOeste);
		
	}

	public static void filaDestinoNorteECentroOeste(List<Pacotes> pacotes) {
		Set<String> origens = new HashSet<String>();
			
		for(Pacotes pacote: pacotes) {
			if(!pacote.getinvalido()) {
				origens.add(pacote.getOrigem());
			}
		}

		for(String origem: origens) {
			System.out.println("Ordem de carga para o Norte para descarregar no Centro-Oeste. Pacotes com origem no "+ origem);
			List<PacotesOrdem1> listaParaOrdenar = new ArrayList<>();
			for(Pacotes pacote: pacotes) {
				if(pacote.getOrigem().equalsIgnoreCase(origem) && (pacote.getDestino().equalsIgnoreCase("norte") || pacote.getDestino().equalsIgnoreCase("centro-oeste"))) {
					listaParaOrdenar.add(new PacotesOrdem1(pacote.getCodigoDeBarras(), pacote.getCodigo()));
				}
			}
			Collections.sort(listaParaOrdenar);
			System.out.println(listaParaOrdenar);
			for(Pacotes pacoteOrdenado: listaParaOrdenar) {
				System.out.println(pacoteOrdenado);
			}
		}
	}
	
	public static void filaDestinoNorteECentroOesteJoiasPrimeiro(List<Pacotes> pacotes) {
		Set<String> origens = new HashSet<String>();
			
		for(Pacotes pacote: pacotes) {
			if(!pacote.getinvalido()) {
				origens.add(pacote.getOrigem());
			}
		}

		for(String origem: origens) {
			System.out.println("Ordem de carga para o Norte para descarregar no Centro-Oeste. Pacotes com origem no "+origem);
			List<PacotesOrdem2> listaParaOrdenar = new ArrayList<>();
			for(Pacotes pacote: pacotes) {
				if(pacote.getOrigem().equalsIgnoreCase(origem) && (pacote.getDestino().equalsIgnoreCase("norte") || pacote.getDestino().equalsIgnoreCase("centro-oeste"))) {
					listaParaOrdenar.add(new PacotesOrdem2(pacote.getCodigoDeBarras(), pacote.getCodigo()));
				}
			}
			Collections.sort(listaParaOrdenar);
			System.out.println(listaParaOrdenar);
			for(Pacotes pacoteOrdenado: listaParaOrdenar) {
				System.out.println(pacoteOrdenado);
			}
		}
	}
	
	public static void listarPacotesInvalidos(List<Pacotes> pacotes) {
		System.out.println("Pacotes Invalidos: ");
		for (int i = 0; i<pacotes.size(); i++) {
			if(pacotes.get(i).getinvalido())
				System.out.println("Pacote "+(i+1));
			}	
		
	}
	
}
