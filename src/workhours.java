import java.awt.Desktop;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

import Connections_parameters.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.lang.model.element.ExecutableElement;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class workhours {

	private JFrame  frame;
	private JButton open_excel;
	private JButton btnSaveToPdf;
	private JButton open_pdf;
	private String absolute_path;
	
	private JFileChooser j;
	
	 public static JDateChooser dateChooser=null;
	 public static JDateChooser dateChooser_1=null;
	
	private static  Connection connection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connection = DBConnection.dbConnector();
					
					workhours window = new workhours();
					window.frame.setVisible(true);
					
					
			//		ExcelWriter writer = new ExcelWriter();
			//		writer.run_example();
					System.out.println("test");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public workhours() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frame = new JFrame();
		frame.setBounds(100, 100, 362, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		 String date = "2020-06-01";
		 Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		dateChooser = new JDateChooser(date2);
		dateChooser.setBounds(10, 45, 110, 20);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Start date");
		lblNewLabel.setBounds(10, 20, 87, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		String date_2 = "2020-06-04";
		 Date date2_2 = new SimpleDateFormat("yyyy-MM-dd").parse(date_2);
		 dateChooser_1 = new JDateChooser(date2_2);
		dateChooser_1.setBounds(153, 45, 110, 20);
		frame.getContentPane().add(dateChooser_1);
		
		
	
		JLabel lblEndDate = new JLabel("End date");
		lblEndDate.setBounds(153, 20, 87, 14);
		frame.getContentPane().add(lblEndDate);
		
		JButton btnNewButton = new JButton("Save to Excel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				leverancier obiekt = new leverancier();
				obiekt.printData();
				
				j = new JFileChooser("C:"); 
				j.setSelectedFile(new File("monthly_informations.xlsx"));
				j.showSaveDialog(null); 
				
				absolute_path = j.getSelectedFile().getAbsolutePath();
				
				System.out.println("d:" + absolute_path);
				
				ReadFromDatabase_afdnr read = new ReadFromDatabase_afdnr();
				ReadFromDatabase_afdeling read_afdeling = new ReadFromDatabase_afdeling();
				
				try {
	
					ExcelWriter wr = new ExcelWriter(read.ReadData(),read_afdeling.ReadData());
					wr.run_example(j.getSelectedFile().getAbsolutePath(),read_afdeling.calculate_sum_of_hours_minutes(),read.getDate_from(),read.getDate_to());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {

					JOptionPane.showMessageDialog(null, "Close document first!");
					
					e.printStackTrace();
				}
				
				// let open excel button be active
				open_excel.setVisible(true);
				open_excel.setEnabled(true);
				
				
				
			}
		});
		btnNewButton.setBounds(10, 141, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		 btnSaveToPdf = new JButton("Save to PDF");
		btnSaveToPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaveToPdf.setBounds(10, 175, 110, 23);
		frame.getContentPane().add(btnSaveToPdf);
		
		 open_excel = new JButton("open");
		open_excel.setEnabled(false);
		open_excel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Desktop.getDesktop().open(new File(absolute_path));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "FIle does not exists");
					e1.printStackTrace();
				}
				
			}
		});
		open_excel.setBounds(151, 141, 69, 23);
		open_excel.setVisible(false);
		frame.getContentPane().add(open_excel);
		
		 open_pdf = new JButton("open");
		 open_pdf.setVisible(false);
		open_pdf.setEnabled(false);
		open_pdf.setBounds(153, 175, 67, 23);
		frame.getContentPane().add(open_pdf);
	}
}
