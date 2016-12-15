package gastaldo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shlNumeri;
	private Text txtNumeri;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client window = new Client();
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
		shlNumeri.open();
		shlNumeri.layout();
		while (!shlNumeri.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlNumeri = new Shell();
		shlNumeri.setSize(225, 108);
		shlNumeri.setText("Numeri");
		
		txtNumeri = new Text(shlNumeri, SWT.BORDER);
		txtNumeri.setText("0");
		txtNumeri.setBounds(160, 27, 39, 21);
		Button btnPrendiNumero = new Button(shlNumeri, SWT.NONE);
		btnPrendiNumero.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Socket s=new Socket("localhost", 9999);
					InputStreamReader isr=new InputStreamReader(s.getInputStream());
					BufferedReader in=new BufferedReader(isr);
					txtNumeri.setText(in.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrendiNumero.setBounds(10, 25, 119, 25);
		btnPrendiNumero.setText("Prendi Numero");
		
		

	}
}
