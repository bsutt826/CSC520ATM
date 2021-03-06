package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import model.Account;

public class JPanelCustomer extends JPanel implements ActionListener 
{
	// A unique ID required because this class is serializable
	// This can be auto generated by hovering over the warning on the class name
	private static final long serialVersionUID = -2603135579915766160L;
	
	private final String ACTION_BALANCE = "BALANCE";
	private final String ACTION_WITHDRAWAL = "WITHDRAWAL";
	private final String ACTION_TRANSFER = "TRANSFER";
	private final String ACTION_DEPOSIT = "DEPOSIT";
	private final String ACTION_CANCEL = "CANCEL";

	JFrameATM atmFrame;
	
	JLabel lblTitle;
	JLabel lblMessage;
	JLabel lblBalance;
	JLabel lblWithdrawal;
	JLabel lblTransfer;
	JLabel lblDeposit;
	JLabel lblCancel;
	
	/**
	 * Constructor for the Service panel
	 * 
	 * @param appFrame Parent frame that will hold the panels created by actions performed by this class
	 */
	public JPanelCustomer(JFrameATM atmFrame) {
		
		// Save the application frame
		this.atmFrame = atmFrame;
		
		// Reset the frame's button action listeners
		atmFrame.setButtonActionDefaults();
		
		// Set frame background color
		this.setBackground(Main.ATM_CONTENT_PANEL_BACKGROUND);

        // Number of rows and heights
		int panelRows = 7;
        int[] rows = new int[panelRows];
        Arrays.fill(rows, (Main.ATM_PANEL_HEIGHT / panelRows));
		
		// Number of columns and widths
        int panelColumns = 2;
        int[] columns = new int[panelColumns];
        Arrays.fill(columns, (Main.ATM_PANEL_WIDTH / panelColumns));
		
		// Set layout
		GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowHeights = rows;
        gridBagLayout.columnWidths = columns;
		this.setLayout(gridBagLayout);
		
		// Set initial constraints
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(0,0,0,0);
		
		// Create and add components for this panel
		
		lblTitle = new JLabel("Please select desired Transaction. ");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.insets = new Insets(0,0,0,0);  //top, left, bottom, right padding
		constraints.anchor = GridBagConstraints.NORTH;
		this.add(lblTitle, constraints);
		
		lblMessage = new JLabel(" ");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMessage.setForeground(Color.RED);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.insets = new Insets(0,0,0,0);  //top, left, bottom, right padding
		constraints.anchor = GridBagConstraints.CENTER;
		this.add(lblMessage, constraints);
		
		int labelWidth = 200;
		int labelHeight = 40;
		
		lblBalance = new JLabel(" Check Balance", JLabel.LEFT);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 22));
		atmFrame.setActionListener_Left2(ACTION_BALANCE, this);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(0,10,0,0);  //top, left, bottom, right padding
		constraints.anchor = GridBagConstraints.WEST;
		lblBalance.setOpaque(true);
		lblBalance.setBackground(Color.BLACK);
		lblBalance.setForeground(Color.WHITE);
		//lblBalance.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		lblBalance.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x007FFF)));
		//lblBalance.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblBalance.setMinimumSize(new Dimension(labelWidth, labelHeight)); // Width, Height
		lblBalance.setPreferredSize(new Dimension(labelWidth, labelHeight));
		lblBalance.setMaximumSize(new Dimension(labelWidth, labelHeight));
		this.add(lblBalance, constraints);
		
		lblWithdrawal = new JLabel(" Withdrawal", JLabel.LEFT);
		lblWithdrawal.setFont(new Font("Tahoma", Font.BOLD, 22));
		atmFrame.setActionListener_Left3(ACTION_WITHDRAWAL, this);
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(0,10,0,0);  //top, left, bottom, right padding
		constraints.anchor = GridBagConstraints.WEST;
		lblWithdrawal.setOpaque(true);
		lblWithdrawal.setBackground(Color.BLACK);
		lblWithdrawal.setForeground(Color.WHITE);
		//lblWithdrawal.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		lblWithdrawal.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x007FFF)));
		//lblWithdrawal.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblWithdrawal.setMinimumSize(new Dimension(labelWidth, labelHeight)); // Width, Height
		lblWithdrawal.setPreferredSize(new Dimension(labelWidth, labelHeight));
		lblWithdrawal.setMaximumSize(new Dimension(labelWidth, labelHeight));
		this.add(lblWithdrawal, constraints);
		
		lblTransfer = new JLabel("Transfer ", JLabel.RIGHT);
		lblTransfer.setFont(new Font("Tahoma", Font.BOLD, 22));
		atmFrame.setActionListener_Right3(ACTION_TRANSFER, this);
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(0,0,0,10);  //top, left, bottom, right padding
		constraints.anchor = GridBagConstraints.EAST;
		lblTransfer.setOpaque(true);
		lblTransfer.setBackground(Color.BLACK);
		lblTransfer.setForeground(Color.WHITE);
		//lblTransfer.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		lblTransfer.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x007FFF)));
		//lblTransfer.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblTransfer.setMinimumSize(new Dimension(labelWidth, labelHeight)); // Width, Height
		lblTransfer.setPreferredSize(new Dimension(labelWidth, labelHeight));
		lblTransfer.setMaximumSize(new Dimension(labelWidth, labelHeight));
		this.add(lblTransfer, constraints);
		
		lblDeposit = new JLabel(" Deposit", JLabel.LEFT);
		lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 22));
		atmFrame.setActionListener_Left4(ACTION_DEPOSIT, this);
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(0,10,0,0);  //top, left, bottom, right padding
		constraints.anchor = GridBagConstraints.WEST;
		lblDeposit.setOpaque(true);
		lblDeposit.setBackground(Color.BLACK);
		lblDeposit.setForeground(Color.WHITE);
		//lblDeposit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		lblDeposit.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x007FFF)));
		//lblDeposit.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblDeposit.setMinimumSize(new Dimension(labelWidth, labelHeight)); // Width, Height
		lblDeposit.setPreferredSize(new Dimension(labelWidth, labelHeight));
		lblDeposit.setMaximumSize(new Dimension(labelWidth, labelHeight));
		this.add(lblDeposit, constraints);
		
		lblCancel = new JLabel("Cancel ", JLabel.RIGHT);
		lblCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
		atmFrame.setActionListener_Right4(ACTION_CANCEL, this);
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.insets = new Insets(0,0,0,10);  //top, left, bottom, right padding
		constraints.anchor = GridBagConstraints.EAST;
		lblCancel.setOpaque(true);
		lblCancel.setBackground(Color.BLACK);
		lblCancel.setForeground(Color.WHITE);
		//lblCancel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLUE));
		lblCancel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(0x007FFF)));
		//lblCancel.setBorder(new BevelBorder(BevelBorder.RAISED));
		lblCancel.setMinimumSize(new Dimension(labelWidth, labelHeight)); // Width, Height
		lblCancel.setPreferredSize(new Dimension(labelWidth, labelHeight));
		lblCancel.setMaximumSize(new Dimension(labelWidth, labelHeight));
		this.add(lblCancel, constraints);
			
		/*
		// Set initial component focus
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Doesn't work when you just want to press the enter key and not click
				//boolean focused = btnCancel.requestFocusInWindow();
				//if (Main.DEBUG)
			    //	System.err.println(this.getClass().getTypeName() + "."
				//	         + (new Throwable().getStackTrace()[0].getMethodName())
				//	         + ": focused: >" + focused + "<"
				//	          );
				
				// Use this when you just want to press the enter key and not have to click the button
				atmFrame.getRootPane().setDefaultButton( btnCancel );
				if (Main.DEBUG)
			    	System.err.println(this.getClass().getTypeName() + "."
					         + (new Throwable().getStackTrace()[0].getMethodName())
					         + ": DefaultButton set >" + btnCancel.getText() + "<"
					          );
			}
		});
		*/

		// All done
		return;
	}
	
	public void showPanel(){
		
		// Set this panel as the frame's content panel and update the frame title
		atmFrame.setContentPanel(this);
		atmFrame.setTitle(Main.ATM_FRAME_TITLE + " - (" + this.getClass().getSimpleName() + ")");
		
		// Actions prior to display
        
		// Initialize some stuff
		atmFrame.setSourceAccountNumber(0);
		atmFrame.setTargetAccountNumber(0);
		atmFrame.setTransactionType(null);
		atmFrame.setTransactionAmount(new BigDecimal(0));
		atmFrame.setAccount(null);
		
		// Get the account associated with this customer
		ArrayList<Account> accounts = Account.getAccounts(atmFrame.getPerson().getIdentification());
		
		// If there are less than 2 accounts don't show "Transfer" as an option
		if (accounts.size() < 2)
		{
			lblTransfer.setVisible(false);
			atmFrame.setActionListener_Right3("", null);
		}
		
		// Re-paint and re-validate to display the panel
		atmFrame.repaint();
		atmFrame.revalidate();

		// All done
		return;
	}
	
	/**
	 * Handles the actions that are requested by this panel
	 * 
	 * @param actionEvent An ActionEvent containing the details of the event
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		String action = actionEvent.getActionCommand();
		
		if(Main.DEBUG)
	    	System.err.println(this.getClass().getTypeName() + "."
			         + (new Throwable().getStackTrace()[0].getMethodName())
			         + ": Got action: : " + action
			          );
		
		JPanelSelectAccount panelSelectAccount = null;
		atmFrame.setSourceAccountNumber(0);
		atmFrame.setTargetAccountNumber(0);
		
		switch (action) {
		
			case ACTION_BALANCE:
		        
				// Save transaction type
				atmFrame.setTransactionType(ACTION_BALANCE);
				 
				// Create the select account panel and place it on the frame
				panelSelectAccount = new JPanelSelectAccount(atmFrame, false);
				panelSelectAccount.showPanel();
				
				break;
			
			case ACTION_WITHDRAWAL:
		        
				// Save transaction type
				atmFrame.setTransactionType(ACTION_WITHDRAWAL);
				 
				// Create the select account panel and place it on the frame
				panelSelectAccount = new JPanelSelectAccount(atmFrame, false);
				panelSelectAccount.showPanel();
				
				break;
				
			case ACTION_TRANSFER:
		        
				// Save transaction type
				atmFrame.setTransactionType(ACTION_TRANSFER);
				 
				// Create the select account panel and place it on the frame
				panelSelectAccount = new JPanelSelectAccount(atmFrame, false);
				panelSelectAccount.showPanel();
				
				break;
				
			case ACTION_DEPOSIT:
		        
				// Save transaction type
				atmFrame.setTransactionType(ACTION_DEPOSIT);
				 
				// Create the select account panel and place it on the frame
				panelSelectAccount = new JPanelSelectAccount(atmFrame, true);
				panelSelectAccount.showPanel();
				
				break;
				
			case ACTION_CANCEL:
				// Create the logon panel and place it on the frame
				JPanelLogon panelLogon = new JPanelLogon(atmFrame);
				panelLogon.showPanel();
				
				break;
		}
		
		// All done
		return;
	}

}
