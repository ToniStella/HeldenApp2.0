import java.util.*;

public class Held {
	Scanner scan = new Scanner(System.in);
	private String name;
	private int lifepoints;
	private int power; // hit power
	private int agility;
	private boolean evil;
	private Waffe waffe;
	private int healpot;
	
	public void setWaffe (Waffe waffe){
		if (waffe == null) {
			this.waffe.setAngelegt(true);
		}
		this.waffe = waffe;
	}
	
	public Waffe getWaffe(){
		return waffe;
	}
	
	// Konstruktor mit Arguments
	public Held (String name, int lifepoints, int power, int agility, boolean evil, Waffe waffe, int healpot){
		this.name = name;
		this.lifepoints = lifepoints;
		this.power = power;
		this.agility = agility;
		this.evil = evil;
		this.setHealpot(healpot);
		setWaffe(waffe);
		if ((this.waffe).isAngelegt()==true) {
			this.waffe = waffe;
			this.agility += waffe.getAgilityWaffe();
			this.power += waffe.getPowerWaffe();
			this.lifepoints += waffe.getLifeplointsWaffe();
		}
	}

	// No-Arg-Konstruktor
	public Held() {

	}

	// Getter und Setter
	public void setEvil(boolean evil){
		this.evil = evil;
	}
	public boolean isEvil(){
		return evil;
	}
	
	public void setName(){
	}
	public String getName(String name) {
		name = scan.next();
		return name;
	}
	
	public void setName(String name) {
	}
	public String getName() {
		return name;
	}
	
	public boolean setAgility(int agility) {
		if (agility >= 0) {
			this.agility = agility;
			return true;
		}
		return false;
	}
	public int getAgility() {
		return agility;
	}
	
	public boolean setPower(int power) {
		if (power >= 0) {
			this.power = power;
			return true;
		}
		return false;
	}
	public int getPower(){
		return power;
	}
	
	public int getLifepoints() {
		return lifepoints;
	}
	public boolean setLifepoints(int lifepoints) {
		if (lifepoints >= 0) {
			this.lifepoints = lifepoints;
			return true;
		}
		return false;
	}
	
	// Objektmethode zum vorstellen und Begrüßen
	public String vorstellen() {
		if (evil) {
			return "Ich bin " + name + " und ich werde dich vernichten! HARHARHAR!";
		}
		return "Mein name ist " + name + " und ich freue mich auf einen ehrenvollen und fairen Kampf!";
	}
	
	// Held erleidet Schaden
	public void reduziereLP (int schaden){
		if (schaden < 0) {
			schaden *= -1;
		}
		if (schaden >= lifepoints) {
			lifepoints = 0;
		}else{
			lifepoints -= schaden;
		}
	}
	
	// Methode zum Kampf
	//Schaden kann nur erzeugt werden wenn Held noch lebt
	public int schlagen(Held andererHeld){
		int schaden = 0;
		if (lifepoints > 0) {
		schaden = (int) ((power * (1 - andererHeld.agility/100) + (1 - waffe.getSchaden()/100))
						* Math.random());
		andererHeld.reduziereLP(schaden);
		}
		if (schaden < 0) {
			return schaden*-1;
		}
		return schaden;
	}
	
	// Methode zum Sterben
	
	public String sterben() {
		if (evil) {
			return name + ": The Scourge... will bring.... Death to all...";
		}else {
			return name + ": The Light will purify this land!";
		}
	}

	public int getHealpot() {
		return healpot;
	}

	public void setHealpot(int healpot) {
		this.healpot = healpot;
	}	
}
