package POJO;
import java.util.Date;

public class data_object_afdnr {

		private String afdnr;
	    private String nest;
	    private String hours;
	    private String minutes;

	    public data_object_afdnr(String afdnr, String nest, String godziny, String minuty) {
	        this.afdnr = afdnr;
	        this.nest = nest;
	        this.hours = godziny;
	        this.minutes = minuty;
	    }

		public String getafdnr() {
			return afdnr;
		}

		public String getNest() {
			return nest;
		}

		public String gethours() {
			return hours;
		}

		public String getminutes() {
			return minutes;
		}

		@Override
		public String toString() {
			return "data_object [afdnr=" + afdnr + ", nest=" + nest + ", hours=" + hours + ", minutes=" + minutes + "]";
		}
		
		
	
}
