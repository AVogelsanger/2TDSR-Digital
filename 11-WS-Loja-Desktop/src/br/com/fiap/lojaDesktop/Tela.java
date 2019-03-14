package br.com.fiap.lojaDesktop;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtCodigo;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblCodProduto = new Label(shell, SWT.NONE);
		lblCodProduto.setBounds(10, 13, 76, 15);
		lblCodProduto.setText("Cod Produto");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(103, 10, 183, 21);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					EstoqueBOStub stub = new EstoqueBOStub();
					
					ConsultarProduto param = new ConsultarProduto();
					param.setCodigoProduto(Integer.parseInt(txtCodigo.getText()));
					//Chamando o Web Service
					ConsultarProdutoResponse resp = stub.consultarProduto(param);
					
					//Recuperar o valor retornado pelo web service
					ProdutoTO p = resp.get_return();
					
					table.removeAll();
					
					TableItem item = new TableItem(table, 0);
					item.setText(new String[] {
							String.valueOf(p.getCodigo()),
							String.valueOf(p.getDescricao()),
							String.valueOf(p.getPreco()),
							String.valueOf(p.getQuantidade())
					});
					
									
				} catch (Exception e1) {
					e1.printStackTrace();
					MessageBox dialog = new MessageBox(shell);
					dialog.setMessage(e1.getMessage());
					dialog.open();
				}
				
				
			}
		});
		btnPesquisar.setBounds(324, 10, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(22, 51, 390, 200);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn colCodigo = new TableColumn(table, SWT.NONE);
		colCodigo.setWidth(100);
		colCodigo.setText("Codigo");
		
		TableColumn colDescricao = new TableColumn(table, SWT.NONE);
		colDescricao.setWidth(100);
		colDescricao.setText("Descri\u00E7\u00E3o");
		
		TableColumn colPreco = new TableColumn(table, SWT.NONE);
		colPreco.setWidth(100);
		colPreco.setText("Pre\u00E7o");
		
		TableColumn colQtd = new TableColumn(table, SWT.NONE);
		colQtd.setWidth(86);
		colQtd.setText("QTD");

	}
}
