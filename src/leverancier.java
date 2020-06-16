import java.util.ArrayList;
import java.util.List;

import Objetcs.Leverancier_object;



public class leverancier {

	
	
	List<Leverancier_object> leveranciers;
	
	public leverancier()
	{
		leveranciers = new ArrayList<Leverancier_object>();
		this.pushData();
	}
	
	
	public void printData()
	{
		for(Leverancier_object o : leveranciers)
		{
			System.out.println("ob 1 :" + o.getLev_number() + " val:" + o.getLev_text());
		}
	}



	private void pushData()
	{
		leveranciers.add(new Leverancier_object(1,"KRAWEDZIARKI PROD.FAT"));
		leveranciers.add(new Leverancier_object(2,"TOKARKI PROD.FAT"));
		leveranciers.add(new Leverancier_object(3,"WYKRAWACZE NAR. PROD.FAT"));
		leveranciers.add(new Leverancier_object(4,"ZAMOWIENIA ZEWNETRZNE"));
		leveranciers.add(new Leverancier_object(5,"GUBISCH PROD.FAT"));
		leveranciers.add(new Leverancier_object(6,"TYMCZASOWE TOKARKI"));
		leveranciers.add(new Leverancier_object(7,"Magazyn F.A.T."));
		leveranciers.add(new Leverancier_object(8,"ZONATO przecinarka do kamienia"));
		leveranciers.add(new Leverancier_object(9,"KOLUSZKI"));
		leveranciers.add(new Leverancier_object(10,"PU UTRZYMANIE RUCHU"));
		leveranciers.add(new Leverancier_object(11,"PRZYRZADY-GEREEDSCHAPPEN"));
		leveranciers.add(new Leverancier_object(12,"ARTYKULY BIUROWE"));
		leveranciers.add(new Leverancier_object(13,"RECLAMACJA"));
		leveranciers.add(new Leverancier_object(14,"FAT SERWIS"));
		leveranciers.add(new Leverancier_object(15,"INNE MASZYNY"));
		leveranciers.add(new Leverancier_object(16,"SRODKI CZYSTOSCI"));
		leveranciers.add(new Leverancier_object(17,"ODZIEZ ROBOCZA"));
		leveranciers.add(new Leverancier_object(18,"GUBISCH SERWIS"));
		leveranciers.add(new Leverancier_object(19,"INWESTYCJE - INVESTMENTS FAT"));
		leveranciers.add(new Leverancier_object(20,"MATERIAAL PRODUCTIE"));
		leveranciers.add(new Leverancier_object(21,"DZIURKARKI SPEEDMASTER"));
		leveranciers.add(new Leverancier_object(22,"KONSTRUKCJA - TESTY"));
		leveranciers.add(new Leverancier_object(23,"ROMMAK Electric"));
		leveranciers.add(new Leverancier_object(24,"SACA"));
		leveranciers.add(new Leverancier_object(25,"MARKETING FAT"));
		leveranciers.add(new Leverancier_object(26,"ROZMAITOSCI"));
		leveranciers.add(new Leverancier_object(27,"KOSZTY"));
		leveranciers.add(new Leverancier_object(28,"UBEZPIECZENIA"));
		leveranciers.add(new Leverancier_object(29,"MODELE FAT"));
		leveranciers.add(new Leverancier_object(30,"MONTAZ - USLUGI NIETOKARKOWE"));
		leveranciers.add(new Leverancier_object(31,"WYPOZYCZALNIA NARZEDZI"));
		leveranciers.add(new Leverancier_object(32,"W1/1A - AWARIE / POPRAWKI / NARZEDZIA"));
		leveranciers.add(new Leverancier_object(33,"W1/1B - AWARIE / POPRAWKI / NARZEDZIA"));
		leveranciers.add(new Leverancier_object(34,"W1/13 - AWARIE / POPRAWKI / NARZEDZIA"));
		leveranciers.add(new Leverancier_object(35,"W2/1 - PR2 - AWARIE / POPRAWKI / NARZEDZIA"));
		leveranciers.add(new Leverancier_object(36,"W4/1 - PR6 - AWARIE / POPRAWKI / NARZEDZIA"));
		leveranciers.add(new Leverancier_object(37,"W5/1 - PR5 - AWARIE / POPRAWKI / NARZEDZIA"));
		leveranciers.add(new Leverancier_object(38,"W8/1-KRAJALNIA-AWARIE/POPRAWKI/NARZEDZIA"));
		leveranciers.add(new Leverancier_object(39,"W9/1-SACA-AWARIE/POPRAWKI/NARZEDZIA"));
		leveranciers.add(new Leverancier_object(40,"TRANSPORT WEWNETRZNY"));
		leveranciers.add(new Leverancier_object(41,"MIROSLAW ZADKA"));
		leveranciers.add(new Leverancier_object(42,"CONSTRUCTION - DEVELOPMENT"));
		leveranciers.add(new Leverancier_object(43,"CONSTRUCTION - COMMERCIAL"));
		leveranciers.add(new Leverancier_object(44,"CONSTRUCTION - SERVICE / GUBISCH"));
		leveranciers.add(new Leverancier_object(45,"RESEARCH & DEVELOPMENT"));
		leveranciers.add(new Leverancier_object(99,"test leverancier productie"));
		leveranciers.add(new Leverancier_object(102,"Magazyn MCG"));
		leveranciers.add(new Leverancier_object(103,"Magazyn ZAKUP"));
		leveranciers.add(new Leverancier_object(104,"Magazyn Art.Uzytk."));
		leveranciers.add(new Leverancier_object(105,"MAGAZYN MATERIAL"));
		leveranciers.add(new Leverancier_object(300,"FAT - RETROFIT"));
		leveranciers.add(new Leverancier_object(496,"KFM KOOPERACJA"));
		leveranciers.add(new Leverancier_object(497,"SACA kooperacja"));
		leveranciers.add(new Leverancier_object(498,"Zaklad Slusarski - ZOFIA ROGOZA"));
		leveranciers.add(new Leverancier_object(499,"NITREX - HTC SP Zoo"));
		leveranciers.add(new Leverancier_object(500,"FAT produkcja"));
	}
	
	

}
