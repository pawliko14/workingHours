import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import Connections_parameters.DBConnection;
import POJO.data_object_afdnr;

public class ReadFromDatabase_afdnr {
	private static Connection myConn;
	
	private List<data_object_afdnr> object_list;
	private String Date_from;
	private String Date_to;
	

	
	public String getDate_from() {
		return Date_from;
	}

	public String getDate_to() {
		return Date_to;
	}

	public ReadFromDatabase_afdnr()
	{
		object_list = new ArrayList<data_object_afdnr>();
		
	}
	
	public int calculate_sum_of_hours_minutes()
	{
		int sumhours = 0;
		int summinutes = 0;
		
		for(data_object_afdnr o : object_list)
		{
			sumhours = sumhours + Integer.parseInt(o.gethours());
			summinutes = summinutes + Integer.parseInt(o.getminutes());
		}
		
		summinutes = summinutes / 60;
		
		return sumhours = sumhours + summinutes;

	}
	
	public List<data_object_afdnr> ReadData() throws SQLException
	{
		myConn = DBConnection.dbConnector();
		
		 Date_from = ((JTextField)workhours.dateChooser.getDateEditor().getUiComponent()).getText();	
		 Date_to = ((JTextField)workhours.dateChooser_1.getDateEditor().getUiComponent()).getText();
		
		String sql = "select sum(u.WERKTIJDH) as godziny , sum(u.WERKTIJDM60) as minuty, w.AFDNR, u.NEST  from werkuren as u\r\n" + 
				"left join werkpost as w \r\n" + 
				"on u.NEST = w.NEST\r\n" + 
				"where u.DATUM between '"+Date_from+"' and '"+Date_to+"'\r\n" + 
				"group by u.NEST ";
		Statement takeDate = myConn.createStatement();
		ResultSet r = takeDate.executeQuery(sql);
		

		System.out.println(Date_from + "  -- " + Date_to);


		while(r.next()) {
			
			
			String godziny = r.getString("godziny");
			String minuty = r.getString("minuty");		
			String afdnr = r.getString("AFDNR");		
			String nest = r.getString("NEST");		

			data_object_afdnr obj  = new data_object_afdnr(afdnr,nest, godziny, minuty  );
			
			object_list.add(obj);
		}	
		
		
		for(data_object_afdnr o : object_list)
		{
				System.out.println(o.toString());
		}
		
		takeDate.close();
		r.close();
		
		
		return object_list;
	}

}
