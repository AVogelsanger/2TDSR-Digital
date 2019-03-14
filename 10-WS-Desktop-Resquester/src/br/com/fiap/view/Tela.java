package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNum1;
	private Text txtNum2;
	private Text textResultado;
	private Text txtCepO;
	private Text txtCepD;
	private Text txtPrazo;
	private Text txtDataMax;

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
		
		Label lblNum = new Label(shell, SWT.NONE);
		lblNum.setBounds(10, 21, 55, 15);
		lblNum.setText("Num1");
		
		Label lblNum_1 = new Label(shell, SWT.NONE);
		lblNum_1.setBounds(10, 82, 55, 15);
		lblNum_1.setText("Num2");
		
		txtNum1 = new Text(shell, SWT.BORDER);
		txtNum1.setBounds(71, 18, 76, 21);
		
		txtNum2 = new Text(shell, SWT.BORDER);
		txtNum2.setBounds(71, 79, 76, 21);
		
		Label lblResultado = new Label(shell, SWT.NONE);
		lblResultado.setBounds(10, 204, 55, 15);
		lblResultado.setText("Resultado");
		
		textResultado = new Text(shell, SWT.BORDER);
		textResultado.setBounds(71, 201, 76, 21);
		
		Button btnCalculate = new Button(shell, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Executado no clique do botão
				//Capturar os dois valores
				
				int n1 = Integer.parseInt(txtNum1.getText());
				int n2 = Integer.parseInt(txtNum2.getText());
				
				int soma = n1 + n2;
				
				textResultado.setText(Integer.toString(soma));
			}
			
			
			//------------------------------------------------
		});
		btnCalculate.setBounds(72, 129, 75, 25);
		btnCalculate.setText("Calculate");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(180, 21, 2, 205);
		
		txtCepO = new Text(shell, SWT.BORDER);
		txtCepO.setBounds(303, 18, 76, 21);
		
		Label lblCepOri = new Label(shell, SWT.NONE);
		lblCepOri.setBounds(197, 21, 69, 15);
		lblCepOri.setText("CEP origem");
		
		Label lblCepDestino = new Label(shell, SWT.NONE);
		lblCepDestino.setBounds(197, 59, 69, 15);
		lblCepDestino.setText("CEP Destino");
		
		txtCepD = new Text(shell, SWT.BORDER);
		txtCepD.setBounds(303, 56, 76, 21);
		
		Button btnCalcPrazo = new Button(shell, SWT.NONE);
		btnCalcPrazo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String cepOrigin = txtCepO.getText();
				String cepDestino = txtCepD.getText();
				
				try {
					//obj que serão enviados para o web service
					CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
					
					CalcPrazo valores = new CalcPrazo();
					valores.setNCdServico("40010");
					valores.setSCepOrigem(cepOrigin);
					valores.setSCepDestino(cepDestino);
					
					//Chamando o web service e recuperando a resposta
					CalcPrazoResponse resp = stub.calcPrazo(valores);
					
					//Exibindo a resposta na tela
							txtPrazo.setText(resp.getCalcPrazoResult().getServicos()
								.getCServico()[0].getPrazoEntrega());
							
							txtDataMax.setText(resp.getCalcPrazoResult().getServicos()
								.getCServico()[0].getDataMaxEntrega());
							
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		btnCalcPrazo.setBounds(303, 94, 75, 25);
		btnCalcPrazo.setText("Calcular");
		
		Label lblPrazo = new Label(shell, SWT.NONE);
		lblPrazo.setBounds(197, 155, 55, 15);
		lblPrazo.setText("Prazo");
		
		txtPrazo = new Text(shell, SWT.BORDER);
		txtPrazo.setBounds(303, 149, 76, 21);
		
		Label lblDaraMax = new Label(shell, SWT.NONE);
		lblDaraMax.setBounds(197, 204, 55, 15);
		lblDaraMax.setText("Dara Max");
		
		txtDataMax = new Text(shell, SWT.BORDER);
		txtDataMax.setBounds(303, 198, 76, 21);

	}
}
