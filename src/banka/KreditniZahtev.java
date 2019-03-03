package banka;

import greske.GPrekoracenMinus;

public class KreditniZahtev extends ZahtevZaTransfer {
	private static final int PROVIZIJA = 5;
	
	public KreditniZahtev(Racun p, Racun u, int iznos, Datum d) {
		super(p,u,iznos,d);
	}
	
	@Override
	public String vrsta() {
		return "Kredit";
	}

	@Override
	public String toString() {
		return super.toString() + "[" + getIznos() + "]";
	}
	
	@Override
	public  void uvecajPrimalac() throws GPrekoracenMinus {
		primalac.promeniStanje((int)(getIznos() - getIznos()*PROVIZIJA/100.0));
	}
}
