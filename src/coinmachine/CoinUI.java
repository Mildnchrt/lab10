package coinmachine;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * GUI component
 * @author Nutcharueta Sihirunwong 5810545866
 *
 */
public class CoinUI extends JFrame implements Observer{
	private JTextField input;
	private JLabel coins, acceptingCoin;
	private Container contents;
	private CoinMachine coinmachine;
	
	/**
	 * create the application
	 * @param cm is CoinMachine object
	 */
	public CoinUI ( CoinMachine cm) {
		this.coinmachine = cm;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponents() {
		GridLayout layout1 = new GridLayout(2, 1);
		Container c1 = new Container();
		Container c2 = new Container();
		FlowLayout layout2 = new FlowLayout();
		c1.setLayout(layout2);
		c2.setLayout(layout2);
		this.setLayout(layout1);
		
		setBounds(100, 450, 500, 200);
		
		coins = new JLabel("#Coins: ");
		acceptingCoin = new JLabel("Acception Coins");
		input = new JTextField(9);
		input.setText("0");
		input.setEditable(false);
		c2.add(coins);
		c2.add(input);
		c1.add(acceptingCoin);
		this.add(c1);
		this.add(c2);
		
		getContentPane().add(c1);
		this.pack();
	}
	
	/**
	 * update Text and value in UI
	 */
	public void update(Observable subject, Object info) {
		input.setText( Integer.toString(( (CoinMachine)subject ).getCount()) );
		if ( ( (CoinMachine)subject ).isFull()) {
			acceptingCoin.setText( "FULL !!" );
		}
	}
}
