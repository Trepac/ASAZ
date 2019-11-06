package com.asazg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class About {

	private JFrame frmAbout;
	
	private String About = "<HTML>Greetings,<br/>"
			+ "this program is made to search trough postfix audit logs.<br/>"
			+ "To begin press Import button and select text file .txt containing audit logs trough which you want ot seach.<br/>"
			+ "Once you imported text file containing audit logs you may start using filters to serach trough audit logs.<br/>"
			+ "Once you set filter press Search button and after a moment you will get results of your search on right side.<br/>"
			+ "Clicking on a required line in results will show audit log about that exact line bellow result of search.<br/>"
			+ "If you want to save required audit lox press export button and choose where sa save text file containing selected audit log.<br/>"
			+ "To refresh all filters press Refresh button<br/>"
			+ "<br/>"
			+ "Author: Bc. Martin Trep·Ë<br/>"
			+ "</html>";
	private String WrongtSelected = "Wrong txt File was selected";
	private String FilterNotFilled = "One of Filters was not filled";
	private String NotSelected = "No txt file was selected";

	/**
	 * Launch the application.
	 */
	public static void Window(int stat) {
		//setStatu(stat);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About(stat);
					window.frmAbout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public About(int stat) {
		initialize(stat);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int stat) {
		frmAbout = new JFrame();
		frmAbout.setTitle("Info");
		frmAbout.setBounds(100, 100, 450, 400);
		frmAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAbout.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel();
		
		if(stat == 1){
		lblNewLabel = new JLabel(About);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEADING);}
		if(stat == 2){
			lblNewLabel = new JLabel(WrongtSelected);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);}
		if(stat == 3){
			lblNewLabel = new JLabel(FilterNotFilled);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);}
		if(stat == 4){
			lblNewLabel = new JLabel(NotSelected);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);}
		
		lblNewLabel.setBounds(12, 13, 408, 327);
		frmAbout.getContentPane().add(lblNewLabel);
	}

}
