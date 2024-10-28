package controller;

import java.io.*;

import fatec.sp.gov.lib.listas.ListaGenerica;
import model.Cliente;

public class ModificacaoCadastroController {

	private void novoArquivo(ListaGenerica<Cliente> listaDeClientes, String nomeDoArquivo) throws Exception {
		String path = "C:" + File.separator + "TEMP" + File.separator;
		File dir = new File(path);

		if (!dir.exists()) {
			dir.mkdir();
		}

		File caminho = new File(path, nomeDoArquivo);
		BufferedWriter writer = new BufferedWriter(new FileWriter(caminho));

		while (!listaDeClientes.isEmpty()) {
			Cliente cliente = listaDeClientes.get(0);
			listaDeClientes.removeFirst();
			String addLinha = cliente.cpf + ";" + cliente.nome + ";" + cliente.idade + ";" + cliente.limiteCredito;
			writer.write(addLinha);
			writer.newLine();
		}
		writer.close();
	}
	
	
	public void novoCadastro(int idadeMin, int idadeMax, Double limiteCredito) throws Exception {
		ListaGenerica<Cliente> listaClientes = new ListaGenerica<Cliente>();

		String path = "C:" + File.separator + "TEMP" + File.separator;
		File arq = new File(path, "cadastro.csv");

		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);
			String linha = reader.readLine();

			while (linha != null) {
				String[] dados = linha.split(";");
				String cpf = dados[0];
				String nome = dados[1];
				String idade = dados[2];
				String limiteCreditoLista = dados[3];
				Cliente cliente = new Cliente(cpf, nome, idade, limiteCreditoLista);

				if (Integer.parseInt(cliente.getIdade()) >= idadeMin && Integer.parseInt(cliente.getIdade()) <= idadeMax
							&& Double.parseDouble(cliente.getLimiteCredito().trim().replace(",", ".").replaceAll("[^\\d.]","")) > limiteCredito) {
					listaClientes.addLast(cliente);
				}
				linha = reader.readLine();
			}
			reader.close();
		}
		String nomeArquivo = "IdadeEntre" + idadeMin + "e" + idadeMax + "_LimiteCredito" + limiteCredito.toString() + ".csv";
		novoArquivo(listaClientes, nomeArquivo);
	}

}
