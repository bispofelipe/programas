package MV.MV;

import java.util.List;
import java.util.Scanner;

import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import entidade.Funcionario;
import entidade.ItensCafe;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		FuncionarioDAO funcDAO = new FuncionarioDAOImpl();
		Scanner scan = new Scanner(System.in);

		int i = 0;
		List<ItensCafe> cont = funcDAO.listarTodosItens();
		for (ItensCafe item : cont) {
			if (item.getItem_id_pk() > i) {
				i = item.getItem_id_pk()+1;
			}
		}

		while (i > 0) {

			System.err.println("\n\nSelecione uma opção: \n\n[1] ADICIONAR FUNCIONARIO\n[2] DELETAR FUNCIONARIO\n"
					+ "[3] ADICIONAR CAFÉ DA MANHÃ\n[4] DELETAR CAFÉ DA MANHÃ\n[5] LISTAR FUNCIONARIOS\n[6] LISTAR CAFÉ DA MANHÃ ");
			int opcao = scan.nextInt();

			Funcionario funcionario = new Funcionario();
			ItensCafe itenscafe = new ItensCafe();

			switch (opcao) {

			case 1: 

				System.err.println("\n\nDigite o CPF do Funcionario: ");
				funcionario.setCpf(scan.nextLine());
				funcionario.setCpf(scan.nextLine());

				System.err.println("\nDigite o Nome do Funcionario: ");
				funcionario.setNome(scan.nextLine());

				funcDAO.inserir(funcionario);

				System.out.println(" INSERIDO COM SUCESSO!!!");

				break;

			case 2: 

				System.err.println("\nDigite o CPF do Funcionario que vai ser removido: ");
				funcionario.setCpf(scan.nextLine());
				funcionario.setCpf(scan.nextLine());

				funcDAO.remover(funcionario.getCpf());
				System.out.println(" REMOVIDO COM SUCESSO!!! ");
				break;

			case 3: 

				System.err.println("\n\nDigite o item que slevará ao CAFÉ DA MANHÃ: ");
				itenscafe.setItem_cafe(scan.nextLine());
				itenscafe.setItem_cafe(scan.nextLine());

				System.err.println("\nDigite o CPF do funcionário pelo item: ");
				funcionario.setCpf(scan.nextLine());

				funcDAO.inserirCafe(i, itenscafe.getItem_cafe(), funcionario.getCpf());

				System.out.println("==== INSERIDO COM SUCESSO!!! ===");

				break;

			case 4: 

				System.err.println("\nDigite o ITEM que será removido: ");
				itenscafe.setItem_cafe(scan.nextLine());
				itenscafe.setItem_cafe(scan.nextLine());

				funcDAO.removerCafe(itenscafe.getItem_cafe());
				System.out.println(" REMOVIDO COM SUCESSO!!! ");
				break;

			case 5:

				List<Funcionario> listaFuncionarios = funcDAO.listarTodos();
				for (Funcionario func : listaFuncionarios) {
					System.out.println(" CPF: " + func.getCpf() + " NOME: " + func.getNome());

				}

				break;

			case 6: 

				List<ItensCafe> listaCafe = funcDAO.listarTodosItens();

				for (ItensCafe item : listaCafe) {
					System.out.println(
							" ITEM / FUNCIONÁRIO: " + item.getItem_cafe() + " / " + item.getFuncionario().getNome());

				}

				break;

			default:
				break;
			}
			i++;
		}

	}

}