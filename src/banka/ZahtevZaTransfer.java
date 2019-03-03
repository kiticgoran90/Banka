package banka;

import greske.GPrekoracenMinus;

public abstract class ZahtevZaTransfer implements Cloneable {
	private static int ID = 0;
	private int id = ++ID;
	protected Racun primalac;
	protected Racun uplatilac;
	private int iznos;
	private Datum datPod;
	
	public ZahtevZaTransfer(Racun p, Racun u, int iznos, Datum d) {
		primalac = p;
		uplatilac = u;
		this.iznos = iznos;
		datPod = d;
	}

	public int getIznos() {
		return iznos;
	}

	public Datum getDatPod() {
		return datPod;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}

	public void setDatPod(Datum datPod) {
		this.datPod = datPod;
	}
	
	public abstract String vrsta();
	
	@Override
	public ZahtevZaTransfer clone() {
		ZahtevZaTransfer kopija = null;
		try {
			kopija = (ZahtevZaTransfer)super.clone();
			kopija.id = ++ID;
			kopija.datPod = new Datum(datPod.getDan(), datPod.getMesec(), datPod.getGodina());
		}catch(CloneNotSupportedException g) { g.printStackTrace();}
		return kopija;
	}
	
	public void uvecajPrimalac() throws GPrekoracenMinus {
		primalac.promeniStanje(iznos);
	}
	
	public void umanjiUplatilac() throws GPrekoracenMinus {
		uplatilac.promeniStanje(-iznos);
	}
	
	public boolean izvrsi() {
		try {
			umanjiUplatilac();
			uvecajPrimalac();
		}catch(GPrekoracenMinus g) {
			System.out.println(g);
			return false;
		}
		return true;
	}
	
	public String toString() {
		return vrsta() + "(" + id + ")" + datPod;
	}
}
