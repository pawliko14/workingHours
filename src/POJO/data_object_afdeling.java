package POJO;

public class data_object_afdeling {

	private String afdeling;
    private String naam;
    private String hours;
    private String minutes;

    public data_object_afdeling(String afd, String na, String godziny, String minuty) {
        this.afdeling = afd;
        this.naam = na;
        this.hours = godziny;
        this.minutes = minuty;
    }

	public String getAfdeling() {
		return afdeling;
	}

	public String getNaam() {
		return naam;
	}

	public String gethours() {
		return hours;
	}

	public String getminutes() {
		return minutes;
	}

	@Override
	public String toString() {
		return "data_object [afdnr=" + afdeling + ", nest=" + naam + ", hours=" + hours + ", minutes=" + minutes + "]";
	}
	
	
	
}
