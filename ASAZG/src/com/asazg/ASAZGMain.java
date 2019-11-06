package com.asazg;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Image;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class ASAZGMain extends JFrame  {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] foundEntriesResults;
	private DefaultListModel<String> model = new  DefaultListModel<String>();
	private Pattern keyPattern = Pattern.compile("Key: ");
	private JPanel contentPane;
	private JTextField textFieldFrom;
	private JTextField textFieldTo;
	private JDateChooser dateChooserA;
	private JDateChooser dateChooserB;
	private JTextField textFieldFrom1;
	private JTextField textFieldTo1;
	private JDateChooser dateChooserA1;
	private JDateChooser dateChooserB1;
	private int additionalFilters =0;
	private String exportString;
	private boolean used = false;
	private JProgressBar progressBar;
	//private Search searchFilter;
	private String[] a = new String[0];
	private JList list = new JList(a);
	private JScrollPane scrollPane;
	private ArrayList<String> legitEntries = new ArrayList<String>();
	
	private JRadioButton rdbtnAnd1;
	private JRadioButton rdbtnAnd2;
	private JRadioButton rdbtnAnd3;
	private JRadioButton rdbtnAnd4;
	private JRadioButton rdbtnAnd5;
	private JRadioButton rdbtnAnd6;
	private JRadioButton rdbtnAnd7;
	private JRadioButton rdbtnAnd8;
	private JRadioButton rdbtnAnd9;
	
	private JRadioButton rdbtnOr1;
	private JRadioButton rdbtnOr2;
	private JRadioButton rdbtnOr3;
	private JRadioButton rdbtnOr4;
	private JRadioButton rdbtnOr5;
	private JRadioButton rdbtnOr6;
	private JRadioButton rdbtnOr7;
	private JRadioButton rdbtnOr8;
	private JRadioButton rdbtnOr9;
	
	private JRadioButton rdbtnNot1;
	private JRadioButton rdbtnNot2;
	private JRadioButton rdbtnNot3;
	private JRadioButton rdbtnNot4;
	private JRadioButton rdbtnNot5;
	private JRadioButton rdbtnNot6;
	private JRadioButton rdbtnNot7;
	private JRadioButton rdbtnNot8;
	private JRadioButton rdbtnNot9;
	
	
	private ArrayList<String[]> addFilters = new ArrayList<String[]>();
	private JTextField textFieldFrom2;
	private JTextField textFieldTo2;
	private JDateChooser dateChooserA2;
	private JDateChooser dateChooserB2;
	private JTextField textFieldFrom3;
	private JTextField textFieldTo3;
	private JDateChooser dateChooserB3;
	private JDateChooser dateChooserA3;
	private JTextField textFieldFrom4;
	private JTextField textFieldTo4;
	private JDateChooser dateChooserA4;
	private JDateChooser dateChooserB4;
	private JTextField textFieldFrom5;
	private JTextField textFieldTo5;
	private JDateChooser dateChooserA5;
	private JDateChooser dateChooserB5;
	private JTextField textFieldFrom6;
	private JTextField textFieldTo6;
	private JDateChooser dateChooserA6;
	private JDateChooser dateChooserB6;
	private JTextField textFieldFrom7;
	private JTextField textFieldTo7;
	private JDateChooser dateChooserA7;
	private JDateChooser dateChooserB7;
	private JTextField textFieldFrom8;
	private JTextField textFieldTo8;
	private JDateChooser dateChooserA8;
	private JDateChooser dateChooserB8;
	private JTextField textFieldFrom9;
	private JTextField textFieldTo9;
	private JDateChooser dateChooserA9;
	private JDateChooser dateChooserB9;
	
	private JRadioButtonMenuItem rdbtnmntmAndA;
	private JRadioButtonMenuItem rdbtnmntmAndA1;
	private JRadioButtonMenuItem rdbtnmntmAndA2;
	private JRadioButtonMenuItem rdbtnmntmAndA3;
	private JRadioButtonMenuItem rdbtnmntmAndA4;
	private JRadioButtonMenuItem rdbtnmntmAndA5;
	private JRadioButtonMenuItem rdbtnmntmAndA6;
	private JRadioButtonMenuItem rdbtnmntmAndA7;
	private JRadioButtonMenuItem rdbtnmntmAndA8;
	private JRadioButtonMenuItem rdbtnmntmAndA9;
	private JRadioButtonMenuItem rdbtnmntmAndB;
	private JRadioButtonMenuItem rdbtnmntmAndB1;
	private JRadioButtonMenuItem rdbtnmntmAndB2;
	private JRadioButtonMenuItem rdbtnmntmAndB3;
	private JRadioButtonMenuItem rdbtnmntmAndB4;
	private JRadioButtonMenuItem rdbtnmntmAndB5;
	private JRadioButtonMenuItem rdbtnmntmAndB6;
	private JRadioButtonMenuItem rdbtnmntmAndB7;
	private JRadioButtonMenuItem rdbtnmntmAndB8;
	private JRadioButtonMenuItem rdbtnmntmAndB9;
	
	private JRadioButtonMenuItem rdbtnmntmOrA;
	private JRadioButtonMenuItem rdbtnmntmOrA1;
	private JRadioButtonMenuItem rdbtnmntmOrA2;
	private JRadioButtonMenuItem rdbtnmntmOrA3;
	private JRadioButtonMenuItem rdbtnmntmOrA4;
	private JRadioButtonMenuItem rdbtnmntmOrA5;
	private JRadioButtonMenuItem rdbtnmntmOrA6;
	private JRadioButtonMenuItem rdbtnmntmOrA7;
	private JRadioButtonMenuItem rdbtnmntmOrA8;
	private JRadioButtonMenuItem rdbtnmntmOrA9;
	private JRadioButtonMenuItem rdbtnmntmOrB;
	private JRadioButtonMenuItem rdbtnmntmOrB1;
	private JRadioButtonMenuItem rdbtnmntmOrB2;
	private JRadioButtonMenuItem rdbtnmntmOrB3;
	private JRadioButtonMenuItem rdbtnmntmOrB4;
	private JRadioButtonMenuItem rdbtnmntmOrB5;
	private JRadioButtonMenuItem rdbtnmntmOrB6;
	private JRadioButtonMenuItem rdbtnmntmOrB7;
	private JRadioButtonMenuItem rdbtnmntmOrB8;
	private JRadioButtonMenuItem rdbtnmntmOrB9;
	
	private JRadioButtonMenuItem rdbtnmntmNotA;
	private JRadioButtonMenuItem rdbtnmntmNotA1;
	private JRadioButtonMenuItem rdbtnmntmNotA2;
	private JRadioButtonMenuItem rdbtnmntmNotA3;
	private JRadioButtonMenuItem rdbtnmntmNotA4;
	private JRadioButtonMenuItem rdbtnmntmNotA5;
	private JRadioButtonMenuItem rdbtnmntmNotA6;
	private JRadioButtonMenuItem rdbtnmntmNotA7;
	private JRadioButtonMenuItem rdbtnmntmNotA8;
	private JRadioButtonMenuItem rdbtnmntmNotA9;
	private JRadioButtonMenuItem rdbtnmntmNotB;
	private JRadioButtonMenuItem rdbtnmntmNotB1;
	private JRadioButtonMenuItem rdbtnmntmNotB2;
	private JRadioButtonMenuItem rdbtnmntmNotB3;
	private JRadioButtonMenuItem rdbtnmntmNotB4;
	private JRadioButtonMenuItem rdbtnmntmNotB5;
	private JRadioButtonMenuItem rdbtnmntmNotB6;
	private JRadioButtonMenuItem rdbtnmntmNotB7;
	private JRadioButtonMenuItem rdbtnmntmNotB8;
	private JRadioButtonMenuItem rdbtnmntmNotB9;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ASAZGMain frame = new ASAZGMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ASAZGMain() {
		setTitle("Automatizovan\u00E9 spracovanie auditn\u00FDch z\u00E1znamov");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1568, 958);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		startButtons();
		contentPane.validate();
		contentPane.repaint();
		firstFilter();
		menuBar();	
	}
	
	public static String readFileAsString(String fileName)throws Exception 
	  { 
	    String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return data; 
	  } 
	
	public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
        }
    }
	
	public void startButtons()
	{JPanel panel_1 = new JPanel();
	panel_1.setBounds(12, 28, 598, 45);
	panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.add(panel_1);
	JButton btnAddFilter = new JButton("Add Filter");
	btnAddFilter.setBounds(12, 10, 133, 25);
	Image imgAdd = new ImageIcon(this.getClass().getResource("/Filter.png")).getImage();
	btnAddFilter.setIcon(new ImageIcon(imgAdd));
	btnAddFilter.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			additionalFilters++;
			addClicked(additionalFilters);
			contentPane.validate();
			contentPane.repaint();
		}
	});
	panel_1.setLayout(null);
	panel_1.add(btnAddFilter);
	JButton btnSearch = new JButton("Search");
	btnSearch.setBounds(162, 10, 133, 25);
	Image imgAddSearch = new ImageIcon(this.getClass().getResource("/Search.png")).getImage();
	btnSearch.setIcon(new ImageIcon(imgAddSearch));
	
	btnSearch.addActionListener(new ActionListener() {	
		public void actionPerformed(ActionEvent e) {
			if(used){
				contentPane.remove(scrollPane);
			}
			used = true;
			
			if(legitEntries.isEmpty()){About window = new About(4);
			  window.Window(4);
				return;}
			
			JPanel panel_11 = new JPanel();
			   panel_11.setBounds(12, 860, 689, 35);
			   contentPane.add(panel_11);
			   panel_11.setLayout(null);
			   progressBar = new JProgressBar(0,100);
			   progressBar.setValue(0);
			   progressBar.setStringPainted(true);
			   progressBar.setBounds(12, 5, 665, 20);
			   panel_11.add(progressBar);
			   contentPane.validate();
			   contentPane.repaint();
			  String fromText = textFieldFrom.getText();
			  String toText = textFieldTo.getText();
			  String dateText = "";
			  String dateText2 = "";
			  if(dateChooserA.getDate() != null){
				  dateText = dateChooserA.getDate().toString();}
			  if(dateChooserB.getDate() != null){
				  dateText2 = dateChooserB.getDate().toString();}
			  if(additionalFilters>0){
				  getOtherFilters(); 
			  }
			  String LogicA="";
			  if(rdbtnmntmAndA.isSelected()){LogicA = "And";}
			  if(rdbtnmntmOrA.isSelected()){LogicA = "Or";}
			  if(rdbtnmntmNotA.isSelected()){LogicA = "Not";}
			  String LogicB="";
			  if(rdbtnmntmAndB.isSelected()){LogicB = "And";}
			  if(rdbtnmntmOrB.isSelected()){LogicB = "Or";}
			  if(rdbtnmntmNotB.isSelected()){LogicB = "Not";}
			  Search searchFilter;
			  searchFilter = new Search(legitEntries,fromText,toText,dateText,dateText2,LogicA,LogicB,addFilters,additionalFilters);	
			  searchFilter.addPropertyChangeListener(new PropertyChangeListener() {  public void propertyChange(PropertyChangeEvent evt) {
		            if ("progress" == evt.getPropertyName()) {
		                int progress = (Integer) evt.getNewValue();
		                progressBar.setValue(progress);
		            }else{
		            	if(searchFilter.getTruth()){
		            foundEntriesResults = searchFilter.getResults();
		            list = new JList(foundEntriesResults);
		            try{
		            scrollPane.setViewportView(list);}
		            
		            catch(NullPointerException e){}
		            list.addListSelectionListener( p -> {	
	        if (!p.getValueIsAdjusting()) {
	        	model.removeAllElements();
	        	String name = (String) list.getSelectedValue();
	            String[] getKeySplitter = keyPattern.split(name);
	            model.addElement(searchFilter.getInfo(getKeySplitter[1]));
	            exportString = searchFilter.getInfo(getKeySplitter[1]);
	            JButton btnExport = new JButton("Export");
				Image imgAddExpo = new ImageIcon(this.getClass().getResource("/Export.png")).getImage();
				btnSearch.setIcon(new ImageIcon(imgAddExpo));
		  		   btnExport.addActionListener(new ActionListener() {
		  		   	public void actionPerformed(ActionEvent e) {
		  		   		exportFile();
		  		   	}
		  		   });
		  		 btnExport.setBounds(1104, 872, 97, 25);
				   contentPane.add(btnExport);
	            
	            JScrollPane scrollPane_1 = new JScrollPane();
	    		scrollPane_1.setBounds(799, 453, 686, 406);
	    		contentPane.add(scrollPane_1);
	    		
	    		JList listResults = new JList(model);
	    		listResults.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    		scrollPane_1.setViewportView(listResults);
	    		JLabel lblLogs = new JLabel("Logs");
	    		lblLogs.setHorizontalAlignment(SwingConstants.CENTER);
	    		scrollPane_1.setColumnHeaderView(lblLogs);
	    		
	    		contentPane.validate();
	    		contentPane.repaint();
	    		}
	    });
		            }
		            }
		        } });
			  searchFilter.execute();
		
			  scrollPane = new JScrollPane();
				scrollPane.setBounds(799, 71, 686, 336);
				contentPane.add(scrollPane);
				
				
				scrollPane.setViewportView(list);
				JLabel lblResults = new JLabel("Results");
				lblResults.setHorizontalAlignment(SwingConstants.CENTER);
				scrollPane.setColumnHeaderView(lblResults);
		}
	});
	panel_1.add(btnSearch);
	
	JButton btnRefresh = new JButton("Refresh");
	btnRefresh.setBounds(307, 10, 133, 25);
	Image imgAddRefr = new ImageIcon(this.getClass().getResource("/Refresh.png")).getImage();
	btnRefresh.setIcon(new ImageIcon(imgAddRefr));
	btnRefresh.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			additionalFilters = 0;
			contentPane.removeAll();
			startButtons();
			firstFilter();
			menuBar();
			used = false;
			contentPane.validate();
			contentPane.repaint();	
		}
	});
	panel_1.add(btnRefresh);
	JButton importButton = new JButton("Import");
	importButton.setBounds(452, 10, 133, 25);
	Image imgAddImp = new ImageIcon(this.getClass().getResource("/Import.png")).getImage();
	importButton.setIcon(new ImageIcon(imgAddImp));
	importButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			 importFile();
		}
	});
	panel_1.add(importButton);}
	
	public void addClicked(int y){
		int Y = y;		
			switch(Y){
			case 1:
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(22, 114, 653, 83);
				panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.add(panel_2);
				panel_2.setLayout(null);
				
				rdbtnAnd1 = new JRadioButton("And");
				rdbtnAnd1.setSelected(true);
				rdbtnAnd1.setActionCommand("And");
				rdbtnAnd1.setBounds(165, 5, 51, 25);
				panel_2.add(rdbtnAnd1);
				
				rdbtnOr1 = new JRadioButton("Or");
				rdbtnOr1.setActionCommand("Or");
				rdbtnOr1.setBounds(220, 5, 43, 25);
				panel_2.add(rdbtnOr1);
				
				rdbtnNot1 = new JRadioButton("Not");
				rdbtnNot1.setActionCommand("Not");
				rdbtnNot1.setBounds(267, 5, 47, 25);
				panel_2.add(rdbtnNot1);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(rdbtnAnd1);
				group1.add(rdbtnOr1);
				group1.add(rdbtnNot1);
				
				
				JLabel label_3 = new JLabel("From");
				label_3.setBounds(12, 42, 30, 16);
				panel_2.add(label_3);
				
				textFieldFrom1 = new JTextField();
				textFieldFrom1.setColumns(10);
				textFieldFrom1.setBounds(47, 39, 116, 22);
				panel_2.add(textFieldFrom1);
				
				textFieldTo1 = new JTextField();
				textFieldTo1.setColumns(10);
				textFieldTo1.setBounds(210, 39, 116, 22);
				panel_2.add(textFieldTo1);
				
				JLabel label_4 = new JLabel("To");
				label_4.setBounds(189, 45, 15, 16);
				panel_2.add(label_4);
				
				JLabel label_5 = new JLabel("Date");
				label_5.setBounds(353, 42, 26, 16);
				panel_2.add(label_5);
				
				JLabel label_27 = new JLabel("To");
				label_27.setBounds(507, 42, 15, 16);
				panel_2.add(label_27);
				
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBounds(165, 39, 19, 26);
				panel_2.add(menuBar);
				
				JMenu menu = new JMenu("A");
				menuBar.add(menu);
				
				 rdbtnmntmAndA1 = new JRadioButtonMenuItem("And");
				rdbtnmntmAndA1.setSelected(true);
				rdbtnmntmAndA1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menu.setText("A");	
					}
				});
				menu.add(rdbtnmntmAndA1);
				
				 rdbtnmntmOrA1 = new JRadioButtonMenuItem("Or");
				rdbtnmntmOrA1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menu.setText("O");	
					}
				});
				menu.add(rdbtnmntmOrA1);
				
				 rdbtnmntmNotA1 = new JRadioButtonMenuItem("Not");
				rdbtnmntmNotA1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menu.setText("N");	
					}
				});
				menu.add(rdbtnmntmNotA1);
				ButtonGroup groupA1 = new ButtonGroup();
				groupA1.add(rdbtnmntmAndA1);
				groupA1.add(rdbtnmntmOrA1);
				groupA1.add(rdbtnmntmNotA1);
				
				JMenuBar menuBar_1 = new JMenuBar();
				menuBar_1.setBounds(331, 39, 19, 26);
				panel_2.add(menuBar_1);
				
				JMenu menu_1 = new JMenu("A");
				menuBar_1.add(menu_1);
				
				 rdbtnmntmAndB1 = new JRadioButtonMenuItem("And");
				rdbtnmntmAndB1.setSelected(true);
				rdbtnmntmAndB1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menu_1.setText("A");	
					}
				});
				menu_1.add(rdbtnmntmAndB1);
				
				 rdbtnmntmOrB1 = new JRadioButtonMenuItem("Or");
				rdbtnmntmOrB1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menu_1.setText("O");	
					}
				});
				menu_1.add(rdbtnmntmOrB1);
				
				 rdbtnmntmNotB1 = new JRadioButtonMenuItem("Not");
				rdbtnmntmNotB1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menu_1.setText("N");	
					}
				});
				menu_1.add(rdbtnmntmNotB1);
				ButtonGroup groupB1 = new ButtonGroup();
				groupB1.add(rdbtnmntmAndB1);
				groupB1.add(rdbtnmntmOrB1);
				groupB1.add(rdbtnmntmNotB1);
				
				dateChooserA1 = new JDateChooser();
				dateChooserA1.setBounds(384, 39, 116, 22);
				panel_2.add(dateChooserA1);
				
				dateChooserB1 = new JDateChooser();
				dateChooserB1.setBounds(525, 39, 116, 22);
				panel_2.add(dateChooserB1);
			
			break;
		case 2: JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(22, 196, 653, 83);
		contentPane.add(panel_1);
		
		 rdbtnAnd2 = new JRadioButton("And");
		rdbtnAnd2.setSelected(true);
		rdbtnAnd2.setActionCommand("And");
		rdbtnAnd2.setBounds(165, 5, 51, 25);
		panel_1.add(rdbtnAnd2);
		
		 rdbtnOr2 = new JRadioButton("Or");
		rdbtnOr2.setActionCommand("Or");
		rdbtnOr2.setBounds(220, 5, 43, 25);
		panel_1.add(rdbtnOr2);
		
		 rdbtnNot2 = new JRadioButton("Not");
		rdbtnNot2.setActionCommand("Not");
		rdbtnNot2.setBounds(267, 5, 47, 25);
		panel_1.add(rdbtnNot2);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnAnd2);
		group2.add(rdbtnOr2);
		group2.add(rdbtnNot2);
		
		
		JLabel label = new JLabel("From");
		label.setBounds(12, 42, 30, 16);
		panel_1.add(label);
		
		textFieldFrom2 = new JTextField();
		textFieldFrom2.setColumns(10);
		textFieldFrom2.setBounds(47, 39, 116, 22);
		panel_1.add(textFieldFrom2);
		
		textFieldTo2 = new JTextField();
		textFieldTo2.setColumns(10);
		textFieldTo2.setBounds(210, 39, 116, 22);
		panel_1.add(textFieldTo2);
		
		JLabel label_1 = new JLabel("To");
		label_1.setBounds(189, 45, 15, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Date");
		label_2.setBounds(353, 42, 26, 16);
		panel_1.add(label_2);
		
		JLabel label_28 = new JLabel("To");
		label_28.setBounds(507, 42, 15, 16);
		panel_1.add(label_28);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(165, 39, 19, 26);
		panel_1.add(menuBar_2);
		
		JMenu menu_2 = new JMenu("A");
		menuBar_2.add(menu_2);
		
		 rdbtnmntmAndA2 = new JRadioButtonMenuItem("And");
		rdbtnmntmAndA2.setSelected(true);
		rdbtnmntmAndA2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu_2.setText("A");	
			}
		});
		menu_2.add(rdbtnmntmAndA2);
		
		 rdbtnmntmOrA2 = new JRadioButtonMenuItem("Or");
		rdbtnmntmOrA2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu_2.setText("O");	
			}
		});
		menu_2.add(rdbtnmntmOrA2);
		
		 rdbtnmntmNotA2 = new JRadioButtonMenuItem("Not");
		rdbtnmntmOrA2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu_2.setText("N");	
			}
		});
		menu_2.add(rdbtnmntmNotA2);
		ButtonGroup groupA2 = new ButtonGroup();
		groupA2.add(rdbtnmntmAndA2);
		groupA2.add(rdbtnmntmOrA2);
		groupA2.add(rdbtnmntmNotA2);
		
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(331, 39, 19, 26);
		panel_1.add(menuBar_3);
		
		JMenu menu_3 = new JMenu("A");
		menuBar_3.add(menu_3);
		
		 rdbtnmntmAndB2 = new JRadioButtonMenuItem("And");
		rdbtnmntmAndB2.setSelected(true);
		rdbtnmntmAndB2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu_3.setText("A");	
			}
		});
		menu_3.add(rdbtnmntmAndB2);
		
		 rdbtnmntmOrB2 = new JRadioButtonMenuItem("Or");
		rdbtnmntmOrB2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu_3.setText("O");	
			}
		});
		menu_3.add(rdbtnmntmOrB2);
		
		 rdbtnmntmNotB2 = new JRadioButtonMenuItem("Not");
		rdbtnmntmNotB2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu_3.setText("N");	
			}
		});
		menu_3.add(rdbtnmntmNotB2);
		ButtonGroup groupB2 = new ButtonGroup();
		groupB2.add(rdbtnmntmAndB2);
		groupB2.add(rdbtnmntmOrB2);
		groupB2.add(rdbtnmntmNotB2);
		
		 dateChooserA2 = new JDateChooser();
		dateChooserA2.setBounds(383, 39, 116, 22);
		panel_1.add(dateChooserA2);
		
		 dateChooserB2 = new JDateChooser();
		dateChooserB2.setBounds(525, 39, 116, 22);
		panel_1.add(dateChooserB2);
			
			break;
		case 3:
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel_3.setBounds(22, 283, 653, 83);
			contentPane.add(panel_3);
			
			 rdbtnAnd3 = new JRadioButton("And");
			rdbtnAnd3.setSelected(true);
			rdbtnAnd3.setActionCommand("And");
			rdbtnAnd3.setBounds(165, 5, 51, 25);
			panel_3.add(rdbtnAnd3);
			
			 rdbtnOr3 = new JRadioButton("Or");
			rdbtnOr3.setActionCommand("Or");
			rdbtnOr3.setBounds(220, 5, 43, 25);
			panel_3.add(rdbtnOr3);
			
			 rdbtnNot3 = new JRadioButton("Not");
			rdbtnNot3.setActionCommand("Not");
			rdbtnNot3.setBounds(267, 5, 47, 25);
			panel_3.add(rdbtnNot3);
			ButtonGroup group3 = new ButtonGroup();
			group3.add(rdbtnAnd3);
			group3.add(rdbtnOr3);
			group3.add(rdbtnNot3);
			
			
			JLabel label_6 = new JLabel("From");
			label_6.setBounds(12, 42, 30, 16);
			panel_3.add(label_6);
			
			textFieldFrom3 = new JTextField();
			textFieldFrom3.setColumns(10);
			textFieldFrom3.setBounds(47, 39, 116, 22);
			panel_3.add(textFieldFrom3);
			
			textFieldTo3 = new JTextField();
			textFieldTo3.setColumns(10);
			textFieldTo3.setBounds(210, 39, 116, 22);
			panel_3.add(textFieldTo3);
			
			JLabel label_7 = new JLabel("To");
			label_7.setBounds(189, 45, 15, 16);
			panel_3.add(label_7);
			
			JLabel label_8 = new JLabel("Date");
			label_8.setBounds(353, 42, 26, 16);
			panel_3.add(label_8);
			
			JLabel label_29 = new JLabel("To");
			label_29.setBounds(507, 42, 15, 16);
			panel_3.add(label_29);
			
			JMenuBar menuBar_4 = new JMenuBar();
			menuBar_4.setBounds(165, 39, 19, 26);
			panel_3.add(menuBar_4);
			
			JMenu menu_4 = new JMenu("A");
			menuBar_4.add(menu_4);
			
			 rdbtnmntmAndA3 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndA3.setSelected(true);
			rdbtnmntmAndA3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_4.setText("A");	
				}
			});
			menu_4.add(rdbtnmntmAndA3);
			
			 rdbtnmntmOrA3 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrA3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_4.setText("O");	
				}
			});
			menu_4.add(rdbtnmntmOrA3);
			
			 rdbtnmntmNotA3 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotA3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_4.setText("N");	
				}
			});
			menu_4.add(rdbtnmntmNotA3);
			ButtonGroup groupA3 = new ButtonGroup();
			groupA3.add(rdbtnmntmAndA3);
			groupA3.add(rdbtnmntmOrA3);
			groupA3.add(rdbtnmntmNotA3);
			
			JMenuBar menuBar_5 = new JMenuBar();
			menuBar_5.setBounds(331, 39, 19, 26);
			panel_3.add(menuBar_5);
			
			JMenu menu_5 = new JMenu("A");
			menuBar_5.add(menu_5);
			
			 rdbtnmntmAndB3 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndB3.setSelected(true);
			rdbtnmntmAndB3.setSelected(true);
			rdbtnmntmAndA3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_5.setText("A");	
				}
			});
			menu_5.add(rdbtnmntmAndB3);
			
			 rdbtnmntmOrB3 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrB3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_5.setText("O");	
				}
			});
			menu_5.add(rdbtnmntmOrB3);
			
			 rdbtnmntmNotB3 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotB3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_5.setText("N");	
				}
			});
			menu_5.add(rdbtnmntmNotB3);
			ButtonGroup groupB3 = new ButtonGroup();
			groupB3.add(rdbtnmntmAndB3);
			groupB3.add(rdbtnmntmOrB3);
			groupB3.add(rdbtnmntmNotB3);
			
			 dateChooserB3 = new JDateChooser();
			dateChooserB3.setBounds(525, 39, 116, 22);
			panel_3.add(dateChooserB3);
			
			 dateChooserA3 = new JDateChooser();
			dateChooserA3.setBounds(383, 39, 116, 22);
			panel_3.add(dateChooserA3);
				
			break;
		case 4: 
			JPanel panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel_4.setBounds(22, 369, 653, 83);
			contentPane.add(panel_4);
			
			 rdbtnAnd4 = new JRadioButton("And");
			rdbtnAnd4.setSelected(true);
			rdbtnAnd4.setActionCommand("And");
			rdbtnAnd4.setBounds(165, 5, 51, 25);
			panel_4.add(rdbtnAnd4);
			
			 rdbtnOr4 = new JRadioButton("Or");
			rdbtnOr4.setActionCommand("Or");
			rdbtnOr4.setBounds(220, 5, 43, 25);
			panel_4.add(rdbtnOr4);
			
			 rdbtnNot4 = new JRadioButton("Not");
			rdbtnNot4.setActionCommand("Not");
			rdbtnNot4.setBounds(267, 5, 47, 25);
			panel_4.add(rdbtnNot4);
			ButtonGroup group4 = new ButtonGroup();
			group4.add(rdbtnAnd4);
			group4.add(rdbtnOr4);
			group4.add(rdbtnNot4);
			
			JLabel label_9 = new JLabel("From");
			label_9.setBounds(12, 42, 30, 16);
			panel_4.add(label_9);
			
			textFieldFrom4 = new JTextField();
			textFieldFrom4.setColumns(10);
			textFieldFrom4.setBounds(47, 39, 116, 22);
			panel_4.add(textFieldFrom4);
			
			textFieldTo4 = new JTextField();
			textFieldTo4.setColumns(10);
			textFieldTo4.setBounds(210, 39, 116, 22);
			panel_4.add(textFieldTo4);
			
			JLabel label_10 = new JLabel("To");
			label_10.setBounds(189, 45, 15, 16);
			panel_4.add(label_10);
			
			JLabel label_11 = new JLabel("Date");
			label_11.setBounds(353, 42, 26, 16);
			panel_4.add(label_11);
			
			JLabel label_30 = new JLabel("To");
			label_30.setBounds(507, 42, 15, 16);
			panel_4.add(label_30);
			
			JMenuBar menuBar_6 = new JMenuBar();
			menuBar_6.setBounds(165, 39, 19, 26);
			panel_4.add(menuBar_6);
			
			JMenu menu_6 = new JMenu("A");
			menuBar_6.add(menu_6);
			
			 rdbtnmntmAndA4 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndA4.setSelected(true);
			rdbtnmntmAndA4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_6.setText("A");	
				}
			});
			menu_6.add(rdbtnmntmAndA4);
			
			 rdbtnmntmOrA4 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrA4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_6.setText("O");	
				}
			});
			menu_6.add(rdbtnmntmOrA4);
			
			 rdbtnmntmNotA4 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotA4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_6.setText("N");	
				}
			});
			menu_6.add(rdbtnmntmNotA4);
			ButtonGroup groupA4 = new ButtonGroup();
			groupA4.add(rdbtnmntmAndA4);
			groupA4.add(rdbtnmntmOrA4);
			groupA4.add(rdbtnmntmNotA4);
			
			JMenuBar menuBar_7 = new JMenuBar();
			menuBar_7.setBounds(331, 39, 19, 26);
			panel_4.add(menuBar_7);
			
			JMenu menu_7 = new JMenu("A");
			menuBar_7.add(menu_7);
			
			 rdbtnmntmAndB4 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndB4.setSelected(true);
			rdbtnmntmAndB4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_7.setText("A");	
				}
			});
			menu_7.add(rdbtnmntmAndB4);
			
			 rdbtnmntmOrB4 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrB4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_7.setText("O");	
				}
			});
			menu_7.add(rdbtnmntmOrB4);
			
			 rdbtnmntmNotB4 = new JRadioButtonMenuItem("Not");
			rdbtnmntmOrB4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_7.setText("N");	
				}
			});
			menu_7.add(rdbtnmntmNotB4);
			ButtonGroup groupB4 = new ButtonGroup();
			groupB4.add(rdbtnmntmAndB4);
			groupB4.add(rdbtnmntmOrB4);
			groupB4.add(rdbtnmntmNotB4);
			
			 dateChooserB4 = new JDateChooser();
			dateChooserB4.setBounds(525, 39, 116, 22);
			panel_4.add(dateChooserB4);
			
			 dateChooserA4 = new JDateChooser();
			dateChooserA4.setBounds(385, 39, 110, 22);
			panel_4.add(dateChooserA4);
				
			break;
		case 5: 
			JPanel panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel_5.setBounds(22, 452, 653, 83);
			contentPane.add(panel_5);
			
			 rdbtnAnd5 = new JRadioButton("And");
			rdbtnAnd5.setSelected(true);
			rdbtnAnd5.setActionCommand("And");
			rdbtnAnd5.setBounds(165, 5, 51, 25);
			panel_5.add(rdbtnAnd5);
			
			 rdbtnOr5 = new JRadioButton("Or");
			rdbtnOr5.setActionCommand("Or");
			rdbtnOr5.setBounds(220, 5, 43, 25);
			panel_5.add(rdbtnOr5);
			
			 rdbtnNot5 = new JRadioButton("Not");
			rdbtnNot5.setActionCommand("Not");
			rdbtnNot5.setBounds(267, 5, 47, 25);
			panel_5.add(rdbtnNot5);
			ButtonGroup group5 = new ButtonGroup();
			group5.add(rdbtnAnd5);
			group5.add(rdbtnOr5);
			group5.add(rdbtnNot5);
			
			JLabel label_12 = new JLabel("From");
			label_12.setBounds(12, 42, 30, 16);
			panel_5.add(label_12);
			
			textFieldFrom5 = new JTextField();
			textFieldFrom5.setColumns(10);
			textFieldFrom5.setBounds(41, 39, 116, 22);
			panel_5.add(textFieldFrom5);
			
			textFieldTo5 = new JTextField();
			textFieldTo5.setColumns(10);
			textFieldTo5.setBounds(210, 39, 116, 22);
			panel_5.add(textFieldTo5);
			
			JLabel label_13 = new JLabel("To");
			label_13.setBounds(189, 45, 15, 16);
			panel_5.add(label_13);
			
			JLabel label_14 = new JLabel("Date");
			label_14.setBounds(353, 42, 26, 16);
			panel_5.add(label_14);
			
			JLabel label_31 = new JLabel("To");
			label_31.setBounds(507, 42, 15, 16);
			panel_5.add(label_31);
			
			JMenuBar menuBar_8 = new JMenuBar();
			menuBar_8.setBounds(165, 39, 19, 26);
			panel_5.add(menuBar_8);
			
			JMenu menu_8 = new JMenu("A");
			menuBar_8.add(menu_8);
			
			 rdbtnmntmAndA5 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndA5.setSelected(true);
			rdbtnmntmAndA5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_8.setText("A");	
				}
			});
			menu_8.add(rdbtnmntmAndA5);
			
			 rdbtnmntmOrA5 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrA5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_8.setText("O");	
				}
			});
			menu_8.add(rdbtnmntmOrA5);
			
			 rdbtnmntmNotA5 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotA5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_8.setText("N");	
				}
			});
			menu_8.add(rdbtnmntmNotA5);
			ButtonGroup groupA5 = new ButtonGroup();
			groupA5.add(rdbtnmntmAndA5);
			groupA5.add(rdbtnmntmOrA5);
			groupA5.add(rdbtnmntmNotA5);
			
			JMenuBar menuBar_9 = new JMenuBar();
			menuBar_9.setBounds(331, 39, 19, 26);
			panel_5.add(menuBar_9);
			
			JMenu menu_9 = new JMenu("A");
			menuBar_9.add(menu_9);
			
			 rdbtnmntmAndB5 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndB5.setSelected(true);
			rdbtnmntmAndB5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_9.setText("A");	
				}
			});
			menu_9.add(rdbtnmntmAndB5);
			
			 rdbtnmntmOrB5 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrB5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_9.setText("O");	
				}
			});
			menu_9.add(rdbtnmntmOrB5);
			
			 rdbtnmntmNotB5 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotB5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_9.setText("N");	
				}
			});
			menu_9.add(rdbtnmntmNotB5);
			ButtonGroup groupB5 = new ButtonGroup();
			groupB5.add(rdbtnmntmAndB5);
			groupB5.add(rdbtnmntmOrB5);
			groupB5.add(rdbtnmntmNotB5);
			
			 dateChooserB5 = new JDateChooser();
			dateChooserB5.setBounds(525, 39, 116, 22);
			panel_5.add(dateChooserB5);
			
			 dateChooserA5 = new JDateChooser();
			dateChooserA5.setBounds(385, 39, 110, 22);
			panel_5.add(dateChooserA5);
				
			break;
		case 6:
			JPanel panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel_6.setBounds(22, 533, 653, 83);
			contentPane.add(panel_6);
			
			 rdbtnAnd6 = new JRadioButton("And");
			rdbtnAnd6.setSelected(true);
			rdbtnAnd6.setActionCommand("And");
			rdbtnAnd6.setBounds(165, 5, 51, 25);
			panel_6.add(rdbtnAnd6);
			
			 rdbtnOr6 = new JRadioButton("Or");
			rdbtnOr6.setActionCommand("Or");
			rdbtnOr6.setBounds(220, 5, 43, 25);
			panel_6.add(rdbtnOr6);
			
			 rdbtnNot6 = new JRadioButton("Not");
			rdbtnNot6.setActionCommand("Not");
			rdbtnNot6.setBounds(267, 5, 47, 25);
			panel_6.add(rdbtnNot6);
			ButtonGroup group6 = new ButtonGroup();
			group6.add(rdbtnAnd6);
			group6.add(rdbtnOr6);
			group6.add(rdbtnNot6);
			
			JLabel label_15 = new JLabel("From");
			label_15.setBounds(12, 42, 30, 16);
			panel_6.add(label_15);
			
			textFieldFrom6 = new JTextField();
			textFieldFrom6.setColumns(10);
			textFieldFrom6.setBounds(47, 39, 116, 22);
			panel_6.add(textFieldFrom6);
			
			textFieldTo6 = new JTextField();
			textFieldTo6.setColumns(10);
			textFieldTo6.setBounds(210, 39, 116, 22);
			panel_6.add(textFieldTo6);
			
			JLabel label_16 = new JLabel("To");
			label_16.setBounds(189, 45, 15, 16);
			panel_6.add(label_16);
			
			JLabel label_17 = new JLabel("Date");
			label_17.setBounds(353, 42, 26, 16);
			panel_6.add(label_17);
			
			JLabel label_32 = new JLabel("To");
			label_32.setBounds(507, 42, 15, 16);
			panel_6.add(label_32);
			
			JMenuBar menuBar_10 = new JMenuBar();
			menuBar_10.setBounds(165, 39, 19, 26);
			panel_6.add(menuBar_10);
			
			JMenu menu_10 = new JMenu("A");
			menuBar_10.add(menu_10);
			
			 rdbtnmntmAndA6 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndA6.setSelected(true);
			rdbtnmntmAndA6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_10.setText("A");	
				}
			});
			menu_10.add(rdbtnmntmAndA6);
			
			 rdbtnmntmOrA6 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrA6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_10.setText("O");	
				}
			});
			menu_10.add(rdbtnmntmOrA6);
			
			 rdbtnmntmNotA6 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotA6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_10.setText("N");	
				}
			});
			menu_10.add(rdbtnmntmNotA6);
			ButtonGroup groupA6 = new ButtonGroup();
			groupA6.add(rdbtnmntmAndA6);
			groupA6.add(rdbtnmntmOrA6);
			groupA6.add(rdbtnmntmNotA6);
			
			JMenuBar menuBar_11 = new JMenuBar();
			menuBar_11.setBounds(331, 39, 19, 26);
			panel_6.add(menuBar_11);
			
			JMenu menu_11 = new JMenu("A");
			menuBar_11.add(menu_11);
			
			 rdbtnmntmAndB6 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndB6.setSelected(true);
			rdbtnmntmAndB6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_11.setText("A");	
				}
			});
			menu_11.add(rdbtnmntmAndB6);
			
			 rdbtnmntmOrB6 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrB6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_11.setText("O");	
				}
			});
			menu_11.add(rdbtnmntmOrB6);
			
			 rdbtnmntmNotB6 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotB6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_11.setText("N");	
				}
			});
			menu_11.add(rdbtnmntmNotB6);
			ButtonGroup groupB6 = new ButtonGroup();
			groupB6.add(rdbtnmntmAndB6);
			groupB6.add(rdbtnmntmOrB6);
			groupB6.add(rdbtnmntmNotB6);
			
			 dateChooserB6 = new JDateChooser();
			dateChooserB6.setBounds(525, 39, 116, 22);
			panel_6.add(dateChooserB6);
			
			 dateChooserA6 = new JDateChooser();
			dateChooserA6.setBounds(385, 39, 110, 22);
			panel_6.add(dateChooserA6);
				
			break;
		case 7: 
			JPanel panel_7 = new JPanel();
			panel_7.setLayout(null);
			panel_7.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel_7.setBounds(22, 614, 653, 83);
			contentPane.add(panel_7);
			
			 rdbtnAnd7 = new JRadioButton("And");
			rdbtnAnd7.setSelected(true);
			rdbtnAnd7.setActionCommand("And");
			rdbtnAnd7.setBounds(165, 5, 51, 25);
			panel_7.add(rdbtnAnd7);
			
			 rdbtnOr7 = new JRadioButton("Or");
			rdbtnOr7.setActionCommand("Or");
			rdbtnOr7.setBounds(220, 5, 43, 25);
			panel_7.add(rdbtnOr7);
			
			 rdbtnNot7 = new JRadioButton("Not");
			rdbtnNot7.setActionCommand("Not");
			rdbtnNot7.setBounds(267, 5, 47, 25);
			panel_7.add(rdbtnNot7);
			ButtonGroup group7 = new ButtonGroup();
			group7.add(rdbtnAnd7);
			group7.add(rdbtnOr7);
			group7.add(rdbtnNot7);
			
			JLabel label_18 = new JLabel("From");
			label_18.setBounds(12, 42, 30, 16);
			panel_7.add(label_18);
			
			textFieldFrom7 = new JTextField();
			textFieldFrom7.setColumns(10);
			textFieldFrom7.setBounds(47, 39, 116, 22);
			panel_7.add(textFieldFrom7);
			
			textFieldTo7 = new JTextField();
			textFieldTo7.setColumns(10);
			textFieldTo7.setBounds(210, 39, 116, 22);
			panel_7.add(textFieldTo7);
			
			JLabel label_19 = new JLabel("To");
			label_19.setBounds(189, 45, 15, 16);
			panel_7.add(label_19);
			
			JLabel label_20 = new JLabel("Date");
			label_20.setBounds(353, 42, 26, 16);
			panel_7.add(label_20);
			
			JLabel label_33 = new JLabel("To");
			label_33.setBounds(507, 42, 15, 16);
			panel_7.add(label_33);
			
			JMenuBar menuBar_12 = new JMenuBar();
			menuBar_12.setBounds(165, 39, 19, 26);
			panel_7.add(menuBar_12);
			
			JMenu menu_12 = new JMenu("A");
			menuBar_12.add(menu_12);
			
			 rdbtnmntmAndA7 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndA7.setSelected(true);
			rdbtnmntmAndA7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_12.setText("A");	
				}
			});
			menu_12.add(rdbtnmntmAndA7);
			
			 rdbtnmntmOrA7 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrA7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_12.setText("O");	
				}
			});
			menu_12.add(rdbtnmntmOrA7);
			
			 rdbtnmntmNotA7 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotA7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_12.setText("N");	
				}
			});
			menu_12.add(rdbtnmntmNotA7);
			ButtonGroup groupA7 = new ButtonGroup();
			groupA7.add(rdbtnmntmAndA7);
			groupA7.add(rdbtnmntmOrA7);
			groupA7.add(rdbtnmntmNotA7);
			
			JMenuBar menuBar_13 = new JMenuBar();
			menuBar_13.setBounds(331, 39, 19, 26);
			panel_7.add(menuBar_13);
			
			JMenu menu_13 = new JMenu("A");
			menuBar_13.add(menu_13);
			
			 rdbtnmntmAndB7 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndB7.setSelected(true);
			rdbtnmntmAndB7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_13.setText("A");	
				}
			});
			menu_13.add(rdbtnmntmAndB7);
			
			 rdbtnmntmOrB7 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrB7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_13.setText("O");	
				}
			});
			menu_13.add(rdbtnmntmOrB7);
			
			 rdbtnmntmNotB7 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotB7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_13.setText("N");	
				}
			});
			menu_13.add(rdbtnmntmNotB7);
			ButtonGroup groupB7 = new ButtonGroup();
			groupB7.add(rdbtnmntmAndB7);
			groupB7.add(rdbtnmntmOrB7);
			groupB7.add(rdbtnmntmNotB7);
			
			 dateChooserB7 = new JDateChooser();
			dateChooserB7.setBounds(525, 39, 116, 22);
			panel_7.add(dateChooserB7);
			
			 dateChooserA7 = new JDateChooser();
			dateChooserA7.setBounds(385, 39, 110, 22);
			panel_7.add(dateChooserA7);
			
				
			break;
		case 8: 
			JPanel panel_8 = new JPanel();
			panel_8.setBounds(22, 699, 653, 83);
			contentPane.add(panel_8);
			panel_8.setLayout(null);
			panel_8.setBorder(new EmptyBorder(5, 5, 5, 5));
			ButtonGroup group8 = new ButtonGroup();
			ButtonGroup groupA8 = new ButtonGroup();
			ButtonGroup groupB8 = new ButtonGroup();
			 rdbtnAnd8 = new JRadioButton("And");
			 rdbtnAnd8.setSelected(true);
			 rdbtnAnd8.setActionCommand("And");
			 rdbtnAnd8.setBounds(165, 5, 51, 25);
			 panel_8.add(rdbtnAnd8);
			 
			  rdbtnOr8 = new JRadioButton("Or");
			  rdbtnOr8.setActionCommand("Or");
			  rdbtnOr8.setBounds(220, 5, 43, 25);
			  panel_8.add(rdbtnOr8);
			  
			   rdbtnNot8 = new JRadioButton("Not");
			   rdbtnNot8.setActionCommand("Not");
			   rdbtnNot8.setBounds(267, 5, 47, 25);
			   panel_8.add(rdbtnNot8);
			   group8.add(rdbtnAnd8);
			   group8.add(rdbtnOr8);
			   group8.add(rdbtnNot8);
			   
			   JLabel label_21 = new JLabel("From");
			   label_21.setBounds(12, 42, 30, 16);
			   panel_8.add(label_21);
			   
			   textFieldFrom8 = new JTextField();
			   textFieldFrom8.setColumns(10);
			   textFieldFrom8.setBounds(47, 39, 116, 22);
			   panel_8.add(textFieldFrom8);
			   
			   textFieldTo8 = new JTextField();
			   textFieldTo8.setColumns(10);
			   textFieldTo8.setBounds(210, 39, 116, 22);
			   panel_8.add(textFieldTo8);
			   
			   JLabel label_22 = new JLabel("To");
			   label_22.setBounds(189, 45, 15, 16);
			   panel_8.add(label_22);
			   
			   JLabel label_23 = new JLabel("Date");
			   label_23.setBounds(353, 42, 26, 16);
			   panel_8.add(label_23);
			   
			   JLabel label_34 = new JLabel("To");
			   label_34.setBounds(507, 42, 15, 16);
			   panel_8.add(label_34);
			   
			   JMenuBar menuBar_14 = new JMenuBar();
			   menuBar_14.setBounds(165, 39, 19, 26);
			   panel_8.add(menuBar_14);
			   
			   JMenu menu_14 = new JMenu("A");
			   menuBar_14.add(menu_14);
			   
			    rdbtnmntmAndA8 = new JRadioButtonMenuItem("And");
			   rdbtnmntmAndA8.setSelected(true);
			   rdbtnmntmAndA8.addActionListener(new ActionListener() {
			   	@Override
			   	public void actionPerformed(ActionEvent e) {
			   		menu_14.setText("A");	
			   	}
			   });
			   menu_14.add(rdbtnmntmAndA8);
			   
			    rdbtnmntmOrA8 = new JRadioButtonMenuItem("Or");
			   rdbtnmntmOrA8.addActionListener(new ActionListener() {
			   	@Override
			   	public void actionPerformed(ActionEvent e) {
			   		menu_14.setText("O");	
			   	}
			   });
			   menu_14.add(rdbtnmntmOrA8);
			   
			    rdbtnmntmNotA8 = new JRadioButtonMenuItem("Not");
			   rdbtnmntmNotA8.addActionListener(new ActionListener() {
			   	@Override
			   	public void actionPerformed(ActionEvent e) {
			   		menu_14.setText("N");	
			   	}
			   });
			   menu_14.add(rdbtnmntmNotA8);
			   groupA8.add(rdbtnmntmAndA8);
			   groupA8.add(rdbtnmntmOrA8);
			   groupA8.add(rdbtnmntmNotA8);
			   
			   JMenuBar menuBar_15 = new JMenuBar();
			   menuBar_15.setBounds(331, 39, 19, 26);
			   panel_8.add(menuBar_15);
			   
			   JMenu menu_15 = new JMenu("A");
			   menuBar_15.add(menu_15);
			   
			    rdbtnmntmAndB8 = new JRadioButtonMenuItem("And");
			   rdbtnmntmAndB8.setSelected(true);
			   menu_15.add(rdbtnmntmAndB8);
			   rdbtnmntmAndB8.addActionListener(new ActionListener() {
			   	@Override
			   	public void actionPerformed(ActionEvent e) {
			   		menu_15.setText("A");	
			   	}
			   });
			   
			    rdbtnmntmOrB8 = new JRadioButtonMenuItem("Or");
			   rdbtnmntmOrB8.addActionListener(new ActionListener() {
			   	@Override
			   	public void actionPerformed(ActionEvent e) {
			   		menu_15.setText("O");	
			   	}
			   });
			   menu_15.add(rdbtnmntmOrB8);
			   
			    rdbtnmntmNotB8 = new JRadioButtonMenuItem("Not");
			   rdbtnmntmNotB8.addActionListener(new ActionListener() {
			   	@Override
			   	public void actionPerformed(ActionEvent e) {
			   		menu_15.setText("N");	
			   	}
			   });
			   menu_15.add(rdbtnmntmNotB8);
			   groupB8.add(rdbtnmntmAndB8);
			   groupB8.add(rdbtnmntmOrB8);
			   groupB8.add(rdbtnmntmNotB8);
			   
			    dateChooserB8 = new JDateChooser();
			   dateChooserB8.setBounds(525, 39, 116, 22);
			   panel_8.add(dateChooserB8);
			   
			    dateChooserA8 = new JDateChooser();
			   dateChooserA8.setBounds(385, 42, 110, 22);
			   panel_8.add(dateChooserA8);
				
			break;
		case 9:
			JPanel panel_9 = new JPanel();
			panel_9.setLayout(null);
			panel_9.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel_9.setBounds(22, 776, 653, 83);
			contentPane.add(panel_9);
			
			 rdbtnAnd9 = new JRadioButton("And");
			rdbtnAnd9.setSelected(true);
			rdbtnAnd9.setActionCommand("And");
			rdbtnAnd9.setBounds(165, 5, 51, 25);
			panel_9.add(rdbtnAnd9);
			
			 rdbtnOr9 = new JRadioButton("Or");
			rdbtnOr9.setActionCommand("Or");
			rdbtnOr9.setBounds(220, 5, 43, 25);
			panel_9.add(rdbtnOr9);
			
			 rdbtnNot9 = new JRadioButton("Not");
			rdbtnNot9.setActionCommand("Not");
			rdbtnNot9.setBounds(267, 5, 47, 25);
			panel_9.add(rdbtnNot9);
			ButtonGroup group9 = new ButtonGroup();
			group9.add(rdbtnAnd9);
			group9.add(rdbtnOr9);
			group9.add(rdbtnNot9);
			
			JLabel label_24 = new JLabel("From");
			label_24.setBounds(12, 42, 30, 16);
			panel_9.add(label_24);
			
			textFieldFrom9 = new JTextField();
			textFieldFrom9.setColumns(10);
			textFieldFrom9.setBounds(47, 39, 116, 22);
			panel_9.add(textFieldFrom9);
			
			textFieldTo9 = new JTextField();
			textFieldTo9.setColumns(10);
			textFieldTo9.setBounds(210, 39, 116, 22);
			panel_9.add(textFieldTo9);
			
			JLabel label_25 = new JLabel("To");
			label_25.setBounds(189, 45, 15, 16);
			panel_9.add(label_25);
			
			JLabel label_26 = new JLabel("Date");
			label_26.setBounds(353, 42, 26, 16);
			panel_9.add(label_26);
			
			JLabel label_35 = new JLabel("To");
			label_35.setBounds(507, 42, 15, 16);
			panel_9.add(label_35);
			
			JMenuBar menuBar_16 = new JMenuBar();
			menuBar_16.setBounds(165, 39, 19, 26);
			panel_9.add(menuBar_16);
			
			JMenu menu_16 = new JMenu("A");
			menuBar_16.add(menu_16);
			
			 rdbtnmntmAndA9 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndA9.setSelected(true);
			rdbtnmntmAndA9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_16.setText("A");	
				}
			});
			menu_16.add(rdbtnmntmAndA9);
			
			 rdbtnmntmOrA9 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrA9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_16.setText("O");	
				}
			});
			menu_16.add(rdbtnmntmOrA9);
			
			 rdbtnmntmNotA9 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotA9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_16.setText("N");	
				}
			});
			menu_16.add(rdbtnmntmNotA9);
			ButtonGroup groupA9 = new ButtonGroup();
			groupA9.add(rdbtnmntmAndA9);
			groupA9.add(rdbtnmntmOrA9);
			groupA9.add(rdbtnmntmNotA9);
			
			JMenuBar menuBar_17 = new JMenuBar();
			menuBar_17.setBounds(331, 39, 19, 26);
			panel_9.add(menuBar_17);
			
			JMenu menu_17 = new JMenu("A");
			menuBar_17.add(menu_17);
			
			 rdbtnmntmAndB9 = new JRadioButtonMenuItem("And");
			rdbtnmntmAndB9.setSelected(true);
			rdbtnmntmAndB9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_17.setText("A");	
				}
			});
			menu_17.add(rdbtnmntmAndB9);
			
			 rdbtnmntmOrB9 = new JRadioButtonMenuItem("Or");
			rdbtnmntmOrB9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_17.setText("O");	
				}
			});
			menu_17.add(rdbtnmntmOrB9);
			
			 rdbtnmntmNotB9 = new JRadioButtonMenuItem("Not");
			rdbtnmntmNotB9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menu_17.setText("N");	
				}
			});
			menu_17.add(rdbtnmntmNotB9);
			ButtonGroup groupB9 = new ButtonGroup();
			groupB9.add(rdbtnmntmAndB9);
			groupB9.add(rdbtnmntmOrB9);
			groupB9.add(rdbtnmntmNotB9);
			
			 dateChooserB9 = new JDateChooser();
			dateChooserB9.setBounds(525, 39, 116, 22);
			panel_9.add(dateChooserB9);
			
			 dateChooserA9 = new JDateChooser();
			dateChooserA9.setBounds(384, 39, 111, 22);
			panel_9.add(dateChooserA9);
				
			break;}
		
	}
	
	private void firstFilter(){
		JPanel panel = new JPanel();
		panel.setBounds(12, 71, 663, 45);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(19, 15, 30, 16);
		
		textFieldFrom = new JTextField();
		textFieldFrom.setBounds(54, 12, 116, 22);
		textFieldFrom.setColumns(10);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(199, 15, 15, 16);
		
		textFieldTo = new JTextField();
		textFieldTo.setBounds(219, 12, 116, 22);
		textFieldTo.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(364, 15, 26, 16);
		panel.setLayout(null);
		panel.add(lblFrom);
		panel.add(textFieldFrom);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(175, 10, 19, 26);
		panel.add(menuBar);
		
		JMenu mnA = new JMenu("A");
		menuBar.add(mnA);
		
		 rdbtnmntmAndA = new JRadioButtonMenuItem("And");
		rdbtnmntmAndA.setSelected(true);
		rdbtnmntmAndA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mnA.setText("A");	
			}
		});
		mnA.add(rdbtnmntmAndA);
		
		 rdbtnmntmOrA = new JRadioButtonMenuItem("Or");
		rdbtnmntmOrA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mnA.setText("O");	
			}
		});
		mnA.add(rdbtnmntmOrA);
		
		 rdbtnmntmNotA = new JRadioButtonMenuItem("Not");
		rdbtnmntmNotA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			mnA.setText("N");	
			}
		});
		mnA.add(rdbtnmntmNotA);
		ButtonGroup groupA = new ButtonGroup();
		groupA.add(rdbtnmntmAndA);
		groupA.add(rdbtnmntmOrA);
		groupA.add(rdbtnmntmNotA);
		
		
		panel.add(lblTo);
		panel.add(textFieldTo);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(340, 10, 19, 26);
		panel.add(menuBar_1);
		
		JMenu menu = new JMenu("A");
		menuBar_1.add(menu);
		
		 rdbtnmntmAndB = new JRadioButtonMenuItem("And");
		rdbtnmntmAndB.setSelected(true);
		rdbtnmntmAndB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("A");	
			}
		});
		menu.add(rdbtnmntmAndB);
		
		 rdbtnmntmOrB = new JRadioButtonMenuItem("Or");
		rdbtnmntmOrB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("O");	
			}
		});
		menu.add(rdbtnmntmOrB);
		
		 rdbtnmntmNotB = new JRadioButtonMenuItem("Not");
		rdbtnmntmNotB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.setText("N");	
			}
		});
		menu.add(rdbtnmntmNotB);
		ButtonGroup groupB = new ButtonGroup();
		groupB.add(rdbtnmntmAndB);
		groupB.add(rdbtnmntmOrB);
		groupB.add(rdbtnmntmNotB);
		
		panel.add(lblDate);
		
		dateChooserA = new JDateChooser();
		dateChooserA.setBounds(395, 12, 116, 22);
		panel.add(dateChooserA);
		
		
		JLabel label = new JLabel("To");
		label.setBounds(516, 15, 15, 16);
		panel.add(label);
		
		dateChooserB = new JDateChooser();
		dateChooserB.setBounds(535, 12, 116, 22);
		panel.add(dateChooserB);
	}
	
	private void getOtherFilters(){
		
		String[] additionalFilter1 = new String[7];
		String[] additionalFilter2 = new String[7];
		String[] additionalFilter3 = new String[7];
		String[] additionalFilter4 = new String[7];
		String[] additionalFilter5 = new String[7];
		String[] additionalFilter6 = new String[7];
		String[] additionalFilter7 = new String[7];
		String[] additionalFilter8 = new String[7];
		String[] additionalFilter9 = new String[7];
		if(additionalFilters>=1){
		if(rdbtnAnd1.isSelected()){additionalFilter1[0] = "And";}
		if(rdbtnOr1.isSelected()){additionalFilter1[0] = "Or";}
		if(rdbtnNot1.isSelected()){additionalFilter1[0] = "Not";}
		additionalFilter1[1] = textFieldFrom1.getText();
		additionalFilter1[2] = textFieldTo1.getText();
		if(dateChooserA1.getDate() != null){
			additionalFilter1[3] = dateChooserA1.getDate().toString();}
		else{additionalFilter1[3] = "";}
		if(dateChooserB1.getDate() != null){
			additionalFilter1[4] = dateChooserB1.getDate().toString();}
		else{additionalFilter1[4] = "";}
		if(rdbtnmntmAndA1.isSelected()){additionalFilter1[5] = "And";}
		if(rdbtnmntmOrA1.isSelected()){additionalFilter1[5] = "Or";}
		if(rdbtnmntmNotA1.isSelected()){additionalFilter1[5] = "Not";}
		if(rdbtnmntmAndB1.isSelected()){additionalFilter1[6] = "And";}
		if(rdbtnmntmOrB1.isSelected()){additionalFilter1[6] = "Or";}
		if(rdbtnmntmNotB1.isSelected()){additionalFilter1[6] = "Not";}
		}
		if(additionalFilters>=2){
		if(rdbtnAnd2.isSelected()){additionalFilter2[0] = "And";}
		if(rdbtnOr2.isSelected()){additionalFilter2[0] = "Or";}
		if(rdbtnNot2.isSelected()){additionalFilter2[0] = "Not";}
		additionalFilter2[1] = textFieldFrom2.getText();
		additionalFilter2[2] = textFieldTo2.getText();
		if(dateChooserA2.getDate() != null){
			additionalFilter2[3] = dateChooserA2.getDate().toString();}
		else{additionalFilter2[3] = "";}
		if(dateChooserB2.getDate() != null){
			  additionalFilter2[4] = dateChooserB2.getDate().toString();}
		else{additionalFilter2[4] = "";}
		if(rdbtnmntmAndA2.isSelected()){additionalFilter2[5] = "And";}
		if(rdbtnmntmOrA2.isSelected()){additionalFilter2[5] = "Or";}
		if(rdbtnmntmNotA2.isSelected()){additionalFilter2[5] = "Not";}
		if(rdbtnmntmAndB2.isSelected()){additionalFilter2[6] = "And";}
		if(rdbtnmntmOrB2.isSelected()){additionalFilter2[6] = "Or";}
		if(rdbtnmntmNotB2.isSelected()){additionalFilter2[6] = "Not";}
		}
		if(additionalFilters>=3){
		if(rdbtnAnd3.isSelected()){additionalFilter3[0] = "And";}
		if(rdbtnOr3.isSelected()){additionalFilter3[0] = "Or";}
		if(rdbtnNot3.isSelected()){additionalFilter3[0] = "Not";}
		additionalFilter3[1] = textFieldFrom3.getText();
		additionalFilter3[2] = textFieldTo3.getText();
		if(dateChooserA3.getDate() != null){
			additionalFilter3[3] = dateChooserA3.getDate().toString();}
		else{additionalFilter3[3] = "";}
		if(dateChooserB3.getDate() != null){
			additionalFilter3[4] = dateChooserB3.getDate().toString();}
		else{additionalFilter3[4] = "";}
		if(rdbtnmntmAndA3.isSelected()){additionalFilter3[5] = "And";}
		if(rdbtnmntmOrA3.isSelected()){additionalFilter3[5] = "Or";}
		if(rdbtnmntmNotA3.isSelected()){additionalFilter3[5] = "Not";}
		if(rdbtnmntmAndB3.isSelected()){additionalFilter3[6] = "And";}
		if(rdbtnmntmOrB3.isSelected()){additionalFilter3[6] = "Or";}
		if(rdbtnmntmNotB3.isSelected()){additionalFilter3[6] = "Not";}
		}
		if(additionalFilters>=4){
		if(rdbtnAnd4.isSelected()){additionalFilter4[0] = "And";}
		if(rdbtnOr4.isSelected()){additionalFilter4[0] = "Or";}
		if(rdbtnNot4.isSelected()){additionalFilter4[0] = "Not";}
		additionalFilter4[1] = textFieldFrom4.getText();
		additionalFilter4[2] = textFieldTo4.getText();
		if(dateChooserA4.getDate() != null){
			additionalFilter4[3] = dateChooserA4.getDate().toString();}
		else{additionalFilter4[3] = "";}
		if(dateChooserB4.getDate() != null){
			additionalFilter4[4] = dateChooserB4.getDate().toString();}
		else{additionalFilter4[4] = "";}
		if(rdbtnmntmAndA4.isSelected()){additionalFilter4[5] = "And";}
		if(rdbtnmntmOrA4.isSelected()){additionalFilter4[5] = "Or";}
		if(rdbtnmntmNotA4.isSelected()){additionalFilter4[5] = "Not";}
		if(rdbtnmntmAndB4.isSelected()){additionalFilter4[6] = "And";}
		if(rdbtnmntmOrB4.isSelected()){additionalFilter4[6] = "Or";}
		if(rdbtnmntmNotB4.isSelected()){additionalFilter4[6] = "Not";}
		}
		if(additionalFilters>=5){
		if(rdbtnAnd5.isSelected()){additionalFilter5[0] = "And";}
		if(rdbtnOr5.isSelected()){additionalFilter5[0] = "Or";}
		if(rdbtnNot5.isSelected()){additionalFilter5[0] = "Not";}
		additionalFilter5[1] = textFieldFrom5.getText();
		additionalFilter5[2] = textFieldTo5.getText();
		if(dateChooserA5.getDate() != null){
			additionalFilter5[3] = dateChooserA5.getDate().toString();}
		else{additionalFilter5[3] = "";}
		if(dateChooserB5.getDate() != null){
			additionalFilter5[4] = dateChooserB5.getDate().toString();}
		else{additionalFilter5[4] = "";}
		if(rdbtnmntmAndA5.isSelected()){additionalFilter5[5] = "And";}
		if(rdbtnmntmOrA5.isSelected()){additionalFilter5[5] = "Or";}
		if(rdbtnmntmNotA5.isSelected()){additionalFilter5[5] = "Not";}
		if(rdbtnmntmAndB5.isSelected()){additionalFilter5[6] = "And";}
		if(rdbtnmntmOrB5.isSelected()){additionalFilter5[6] = "Or";}
		if(rdbtnmntmNotB5.isSelected()){additionalFilter5[6] = "Not";}
		}
		if(additionalFilters>=6){
		if(rdbtnAnd6.isSelected()){additionalFilter6[0] = "And";}
		if(rdbtnOr6.isSelected()){additionalFilter6[0] = "Or";}
		if(rdbtnNot6.isSelected()){additionalFilter6[0] = "Not";}
		additionalFilter6[1] = textFieldFrom6.getText();
		additionalFilter6[2] = textFieldTo6.getText();
		if(dateChooserA6.getDate() != null){
			additionalFilter6[3] = dateChooserA6.getDate().toString();}
		else{additionalFilter6[3] = "";}
		if(dateChooserB6.getDate() != null){
			additionalFilter6[4] = dateChooserB6.getDate().toString();}
		else{additionalFilter6[4] = "";}
		if(rdbtnmntmAndA6.isSelected()){additionalFilter6[5] = "And";}
		if(rdbtnmntmOrA6.isSelected()){additionalFilter6[5] = "Or";}
		if(rdbtnmntmNotA6.isSelected()){additionalFilter6[5] = "Not";}
		if(rdbtnmntmAndB6.isSelected()){additionalFilter6[6] = "And";}
		if(rdbtnmntmOrB6.isSelected()){additionalFilter6[6] = "Or";}
		if(rdbtnmntmNotB6.isSelected()){additionalFilter6[6] = "Not";}
		}
		//LogicC From To Date DateLimit LogicA LogicB
		if(additionalFilters>=7){
		if(rdbtnAnd7.isSelected()){additionalFilter7[0] = "And";}
		if(rdbtnOr7.isSelected()){additionalFilter7[0] = "Or";}
		if(rdbtnNot7.isSelected()){additionalFilter7[0] = "Not";}
		additionalFilter7[1] = textFieldFrom7.getText();
		additionalFilter7[2] = textFieldTo7.getText();
		if(dateChooserA7.getDate() != null){
			additionalFilter7[3] = dateChooserA7.getDate().toString();}
		else{additionalFilter7[3] = "";}
		if(dateChooserB7.getDate() != null){
			additionalFilter7[4] = dateChooserB7.getDate().toString();}
		else{additionalFilter7[4] = "";}
		if(rdbtnmntmAndA7.isSelected()){additionalFilter7[5] = "And";}
		if(rdbtnmntmOrA7.isSelected()){additionalFilter7[5] = "Or";}
		if(rdbtnmntmNotA7.isSelected()){additionalFilter7[5] = "Not";}
		if(rdbtnmntmAndB7.isSelected()){additionalFilter7[6] = "And";}
		if(rdbtnmntmOrB7.isSelected()){additionalFilter7[6] = "Or";}
		if(rdbtnmntmNotB7.isSelected()){additionalFilter7[6] = "Not";}
		}
		if(additionalFilters>=8){
		if(rdbtnAnd8.isSelected()){additionalFilter8[0] = "And";}
		if(rdbtnOr8.isSelected()){additionalFilter8[0] = "Or";}
		if(rdbtnNot8.isSelected()){additionalFilter8[0] = "Not";}
		additionalFilter8[1] = textFieldFrom8.getText();
		additionalFilter8[2] = textFieldTo8.getText();
		if(dateChooserA8.getDate() != null){
			additionalFilter8[3] = dateChooserA8.getDate().toString();}
		else{additionalFilter8[3] = "";}
		if(dateChooserB8.getDate() != null){
			additionalFilter8[4] = dateChooserB8.getDate().toString();}
		else{additionalFilter8[4] = "";}
		if(rdbtnmntmAndA8.isSelected()){additionalFilter8[5] = "And";}
		if(rdbtnmntmOrA8.isSelected()){additionalFilter8[5] = "Or";}
		if(rdbtnmntmNotA8.isSelected()){additionalFilter8[5] = "Not";}
		if(rdbtnmntmAndB8.isSelected()){additionalFilter8[6] = "And";}
		if(rdbtnmntmOrB8.isSelected()){additionalFilter8[6] = "Or";}
		if(rdbtnmntmNotB8.isSelected()){additionalFilter8[6] = "Not";}
		}
		if(additionalFilters>=9){
		if(rdbtnAnd9.isSelected()){additionalFilter9[0] = "And";}
		if(rdbtnOr9.isSelected()){additionalFilter9[0] = "Or";}
		if(rdbtnNot9.isSelected()){additionalFilter9[0] = "Not";}
		additionalFilter9[1] = textFieldFrom9.getText();
		additionalFilter9[2] = textFieldTo9.getText();
		if(dateChooserA9.getDate() != null){
			additionalFilter9[3] = dateChooserA9.getDate().toString();}
		else{additionalFilter9[3] = "";}
		if(dateChooserB9.getDate() != null){
			additionalFilter9[4] = dateChooserB9.getDate().toString();}
		else{additionalFilter9[4] = "";}
		if(rdbtnmntmAndA9.isSelected()){additionalFilter9[5] = "And";}
		if(rdbtnmntmOrA9.isSelected()){additionalFilter9[5] = "Or";}
		if(rdbtnmntmNotA9.isSelected()){additionalFilter9[5] = "Not";}
		if(rdbtnmntmAndB9.isSelected()){additionalFilter9[6] = "And";}
		if(rdbtnmntmOrB9.isSelected()){additionalFilter9[6] = "Or";}
		if(rdbtnmntmNotB9.isSelected()){additionalFilter9[6] = "Not";}
		}
		addFilters.add(additionalFilter1);
		addFilters.add(additionalFilter2);
		addFilters.add(additionalFilter3);
		addFilters.add(additionalFilter4);
		addFilters.add(additionalFilter5);
		addFilters.add(additionalFilter6);
		addFilters.add(additionalFilter7);
		addFilters.add(additionalFilter8);
		addFilters.add(additionalFilter9);
		
	}
	private void exportFile(){
		JFileChooser chooser = new JFileChooser();
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
	            
	            Pattern eportPattern = Pattern.compile("<br/>");
	            String[] exportStringArray = eportPattern.split(exportString);
	            StringBuilder exportStringFinal =new StringBuilder();
	            for (int i = 0; i < exportStringArray.length; i++) {
	            	exportStringFinal.append(exportStringArray[i]);
	            	exportStringFinal.append("\n");
	            }
	            fw.write(exportStringFinal.toString());
	            fw.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
		
	}
	
	private void importFile(){
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "txt file", "txt");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }else{
	    	return;}
	   
	    Pattern pat = Pattern.compile("\\wx/\\w");
		Pattern pat3 = Pattern.compile("opendkim.[0-9]{3}.");
		Pattern pat2 = Pattern.compile("dovecot");
		Pattern patExtra = Pattern.compile("spamd.[0-9]{5}.");
		Pattern serverName = Pattern.compile(" ");
		Pattern fromToPattern = Pattern.compile("=<|>");
		Pattern keyExtractorPattern = Pattern.compile("\\.|@");
		String dvojbodkapatternString = ": ";
		Pattern pattern3 = Pattern.compile(dvojbodkapatternString);
	    
	    FileInputStream inputStream = null;
    	Scanner sc = null;
    	legitEntries.clear();
    	
	    try {
	    	    inputStream = new FileInputStream(chooser.getSelectedFile());
	    	    sc = new Scanner(inputStream, "UTF-8");
	    	    while (sc.hasNextLine()) {
	    	        String line = sc.nextLine();
	    	        
	    	        String[] serverGetter = serverName.split(line);
	    	        Pattern pattern2 = Pattern.compile(" "+serverGetter[3]+" " );
	    	        String[] serverSpliter = pattern2.split(line);
	  			  if(serverSpliter.length!=2){
	  				  About window = new About(2);
	  				  window.Window(2);
	  					return;
	  			  }
	  			  String[] dvojbodkaSpliter = pattern3.split(serverSpliter[1]);	
	  			  Matcher mat = pat.matcher(dvojbodkaSpliter[0]);
	  			  Matcher mat2 = pat2.matcher(dvojbodkaSpliter[0]);
	  			  Matcher mat3 = pat3.matcher(dvojbodkaSpliter[0]);
	  			  Matcher matExtra = patExtra.matcher(dvojbodkaSpliter[0]);
	  			 
	  			  while (mat.find()){
	  			    if(dvojbodkaSpliter.length == 3 ){
	  					  String[] fromToSting = fromToPattern.split(dvojbodkaSpliter[2]);
	  					  keyChecker(dvojbodkaSpliter[1], line);
	  					  
	  						 String[] extractedKey = keyExtractorPattern.split(dvojbodkaSpliter[2]);
	  						 for(int k=0;k<=extractedKey.length-1;k++){
	  							 keyChecker(extractedKey[k], line);
	  						}
	  					  }
	  				    
	  				 if(dvojbodkaSpliter.length == 4 ){
	  					String[] fromToSting = fromToPattern.split(dvojbodkaSpliter[2]);
	  				     keyChecker(dvojbodkaSpliter[1], line);
	  					 keyChecker(dvojbodkaSpliter[3], line);
	  					 }}
	  			  
	  			  while (mat2.find()){
	  				  
	  				 if(dvojbodkaSpliter.length == 5 ){
	  					 String[] extractedKey = keyExtractorPattern.split(dvojbodkaSpliter[3]);
	  					 for(int k=0;k<=extractedKey.length-1;k++){
	  						 keyChecker(extractedKey[k], line); 
	  						 }}}
	  			  
	  			  while (mat3.find()){
	  				 
	  				 if(dvojbodkaSpliter.length == 3 ){
	  					
	  					 legitEntries.add(line);
	  					 }}
	  			  
	  			  while (matExtra.find()){
	  				  
	  				  if(dvojbodkaSpliter.length == 3 ){
	  						 String[] extractedKey = keyExtractorPattern.split(dvojbodkaSpliter[2]);
	  						 for(int k=0;k<=extractedKey.length-1;k++){
	  							 keyChecker(extractedKey[k], line);	
	  							}}
	  				  
	  				 if(dvojbodkaSpliter.length == 4 ){
	  					 String[] extractedKey = keyExtractorPattern.split(dvojbodkaSpliter[3]);
	  					 for(int k=0;k<=extractedKey.length-1;k++){
	  						 keyChecker(extractedKey[k], line);
	  						 }}}
	    	    }
	    	    // note that Scanner suppresses exceptions
	    	    if (sc.ioException() != null) {
	    	        throw sc.ioException();
	    	    }
	    	
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	    catch (NullPointerException e1) {
		
	    	About window = new About(2);
	    	window.Window(2);
			e1.printStackTrace();
		}
	    finally {
    	    if (inputStream != null) {
    	        try {
					inputStream.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
    	    }
    	    if (sc != null) {
    	        sc.close();
    	    }
    	}
			
	}
	
	private void menuBar(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1538, 26);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		Image imgAddImp = new ImageIcon(this.getClass().getResource("/Import.png")).getImage();
		mntmImport.setIcon(new ImageIcon(imgAddImp));
		mntmImport.addActionListener(new ActionListener (){
			@Override
			public void actionPerformed(ActionEvent e) {
			importFile();
			}
		});
		mnMenu.add(mntmImport);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				About window = new About(1);
				window.Window(1);
				
			}
		});
		
		mnMenu.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			System.exit(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		mnMenu.add(mntmExit);
	}
	
	private void keyChecker(String keyString, String entry){
		Pattern keycheckerPattern = Pattern.compile("\\b^[A-F0-9]{11}\\b");
		Matcher matKey = keycheckerPattern.matcher(keyString);
		 while (matKey.find()){
			 legitEntries.add(entry);
			 
			
			 }
	}
}
