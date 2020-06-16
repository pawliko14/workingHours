import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import Connections_parameters.DBConnection;
import POJO.data_object_afdeling;

public class ReadFromDatabase_afdeling {

private static Connection myConn;
	
	private List<data_object_afdeling> object_list;
	private String Date_from;
	private String Date_to;
	

	
	public String getDate_from() {
		return Date_from;
	}

	public String getDate_to() {
		return Date_to;
	}

	public ReadFromDatabase_afdeling()
	{
		object_list = new ArrayList<data_object_afdeling>();
		
	}
	
	public int calculate_sum_of_hours_minutes()
	{
		int sumhours = 0;
		int summinutes = 0;
		
		for(data_object_afdeling o : object_list)
		{
			sumhours = sumhours + Integer.parseInt(o.gethours());
			summinutes = summinutes + Integer.parseInt(o.getminutes());
		}
		
		summinutes = summinutes / 60;
		
		return sumhours = sumhours + summinutes;

	}
	
	public List<data_object_afdeling> ReadData() throws SQLException
	{
		myConn = DBConnection.dbConnector();
		
		 Date_from = ((JTextField)workhours.dateChooser.getDateEditor().getUiComponent()).getText();	
		 Date_to = ((JTextField)workhours.dateChooser_1.getDateEditor().getUiComponent()).getText();
		
		String sql = "select  w.afdeling,l.NAAM, sum(w.WERKTIJDH) as godziny , sum(w.WERKTIJDM60) as minuty  from werkuren w\r\n" + 
				"left join leverancier l\r\n" + 
				"on w.afdeling = l.LEVERANCIERNR\r\n" + 
				"where w.DATUM between '"+Date_from+"' and '"+Date_to+"'\r\n" + 
				"group by w.afdeling\r\n" + 
				"order by w.afdeling,w.DATUM";
		
		Statement takeDate = myConn.createStatement();
		ResultSet r = takeDate.executeQuery(sql);
		

		System.out.println(Date_from + "  -- " + Date_to);


		while(r.next()) {
			
			
			String godziny = r.getString("godziny");
			String minuty = r.getString("minuty");		
			String afdeling = r.getString("afdeling");		
			String naam = r.getString("Naam");		

			data_object_afdeling obj  = new data_object_afdeling(afdeling,naam, godziny, minuty);
			
			object_list.add(obj);
		}	
		
		
		for(data_object_afdeling o : object_list)
		{
				System.out.println(o.toString());
		}
		
		takeDate.close();
		r.close();
		
		
		return object_list;
	}
	
}
