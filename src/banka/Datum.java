package banka;

public class Datum {
	private int dan, mesec, godina;
	
	public Datum(int dan, int mesec, int godina) {
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}

	public int getDan() {
		return dan;
	}

	public int getMesec() {
		return mesec;
	}

	public int getGodina() {
		return godina;
	}
	
	public boolean noviji(Datum d) {
		if(godina > d.godina || (godina == d.godina && mesec > d.mesec) || (godina == d.godina && mesec == d.mesec && dan > d.dan))
			return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return dan + "/" + mesec + "/" + godina;
	}
}
