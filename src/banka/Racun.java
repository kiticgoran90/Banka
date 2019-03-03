package banka;

import greske.GPrekoracenMinus;

public class Racun {
	private static int ID = 0;
	private int id = ++ID;
	private int stanje, minus;
	
	public Racun(int stanje, int minus) {
		this.stanje = stanje;
		this.minus = minus;
	}

	public int getId() {
		return id;
	}

	public int getStanje() {
		return stanje;
	}

	public int getMinus() {
		return minus;
	}
	
	public void promeniStanje(int iznos) throws GPrekoracenMinus {
		if(stanje + iznos < minus) throw new GPrekoracenMinus();
		stanje += iznos;
	}
}
