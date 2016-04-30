package coinmachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

/**
 * GUI component
 * @author Nutcharueta Sihirunwong 5810545866
 *
 */
public class CoinsMachineUI extends JFrame implements Observer{
	private JLabel balance, balanceStatus, insertMoney;
	private JButton oneCoinButton, fiveCoinButton, tenCoinButton;
	private JProgressBar progressBar;
	private MainCoinMachine demo = new MainCoinMachine();
	
	/**
	 * Create the application.
	 */
	public CoinsMachineUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		oneCoinButton = new JButton("");
		oneCoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demo.insertButtonListener(1);
			}
		});
		oneCoinButton.setBounds(23, 146, 134, 103);
		oneCoinButton.setIcon(new ImageIcon(CoinsMachineUI.class.getResource("/images/1baht.png")));
		getContentPane().add(oneCoinButton);

		fiveCoinButton = new JButton("");
		fiveCoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demo.insertButtonListener(5);
			}
		});
		fiveCoinButton.setBounds(159, 146, 134, 105);
		fiveCoinButton.setIcon(new ImageIcon(CoinsMachineUI.class.getResource("/images/5baht.png")));
		getContentPane().add(fiveCoinButton);

		tenCoinButton = new JButton("");
		tenCoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				demo.insertButtonListener(10);
			}
		});
		tenCoinButton.setIcon(new ImageIcon(CoinsMachineUI.class.getResource("/images/10baht.png")));
		tenCoinButton.setBounds(295, 146, 134, 105);
		getContentPane().add(tenCoinButton);

		progressBar = new JProgressBar();
		progressBar.setMaximum(MainCoinMachine.capacity);
		progressBar.setStringPainted(true);
		progressBar.setString("0");
		progressBar.setBounds(234, 36, 185, 41);
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("");
		getContentPane().add(progressBar);

		balance = new JLabel( "0" );
		balance.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		balance.setBounds(121, 46, 108, 16);
		getContentPane().add(balance);

		balanceStatus = new JLabel("Balance:        Status:");
		balanceStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		balanceStatus.setBounds(37, 46, 203, 16);
		getContentPane().add(balanceStatus);

		insertMoney = new JLabel("Insert Money");
		insertMoney.setBounds(42, 104, 100, 16);
		getContentPane().add(insertMoney);
	}
	
	/**
	 * update Text and value in UI
	 */
	@Override
	public void update(Observable subject, Object info) {
		balance.setText( Integer.toString( ( (CoinMachine)subject ).getBalance() ) );
		progressBar.setValue(( (CoinMachine)subject ).getCount());
		progressBar.setString(Integer.toString( ( (CoinMachine)subject ).getCount() ) );
	}

}
