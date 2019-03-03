package banka;

import greske.GPraznaZbirka;

public class Banka {
	private Racun bankAccount;
	
	public Banka(Racun r) {
		bankAccount = r;
	}
	
	private Elem prvi;
	
	private class Elem {
		ZahtevZaTransfer zahtev;
		Elem sled;
		Elem(ZahtevZaTransfer zahtev) {
			this.zahtev = zahtev;
			Elem tek = prvi, pret = null;
			while(tek != null && !tek.zahtev.getDatPod().noviji(zahtev.getDatPod())) {
				pret = tek;
				tek = tek.sled;
			}
			if(pret != null) pret.sled = this;
			else prvi = this;
			this.sled = tek;
		}
	}
	
	public Banka dodaj(ZahtevZaTransfer zahtev) {
		new Elem(zahtev);
		return this;
	}
	
	public ZahtevZaTransfer uzmi() throws GPraznaZbirka {
		if(prvi == null) throw new GPraznaZbirka();
		ZahtevZaTransfer zahtev = prvi.zahtev;
		prvi = prvi.sled;
		return zahtev;
	}
	
	public boolean izvrsi() throws GPraznaZbirka {
		ZahtevZaTransfer zahtev = this.uzmi();
		return zahtev.izvrsi();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(bankAccount.getStanje() + " (");
		for(Elem tek=prvi; tek!=null; tek=tek.sled) {
			sb.append(tek.zahtev);
			if(tek.sled!=null) sb.append(",\n");
		}
		return sb +")";
	}
}
