package banka;

import greske.GPrekoracenMinus;

public class Uplatnica extends ZahtevZaTransfer {
	private static final int PROVIZIJA = 1;
	
	public Uplatnica(Racun p, Racun u, int iznos, Datum d) {
		super(p,u,iznos,d);
	}
	
	@Override
	public String vrsta() {
		return "Uplata";
	}

	@Override
	public String toString() {
		return super.toString() + "[" + getIznos() + ":" + getIznos()*PROVIZIJA/100.0 + "]";
	}
	
	@Override
	public void umanjiUplatilac() throws GPrekoracenMinus {
		uplatilac.promeniStanje((int)(-getIznos() - getIznos()*PROVIZIJA/100.0));
	}
}
