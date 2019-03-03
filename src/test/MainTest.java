package test;

import banka.Banka;
import banka.Datum;
import banka.KreditniZahtev;
import banka.Racun;
import banka.Uplatnica;
import banka.ZahtevZaTransfer;
import greske.GPraznaZbirka;

public class MainTest {

	public static void main(String[] args) {
		Racun klijent = new Racun(3000, -100);
		Racun bankAccount = new Racun(600000, 0);
		Banka banka = new Banka(bankAccount);
		ZahtevZaTransfer uplata1 = new Uplatnica(bankAccount, klijent, 200, new Datum(5,4,2019));
		ZahtevZaTransfer kredit = new KreditniZahtev(klijent, bankAccount, 1000, new Datum(5,4,2019));
		ZahtevZaTransfer uplata2 = uplata1.clone();
		uplata2.setDatPod(new Datum(5,5,2019));
		
		banka.dodaj(kredit).dodaj(uplata1).dodaj(uplata2);
		System.out.println(banka);
		
		
		try {
			while(banka.izvrsi()) {
			}
		}catch(GPraznaZbirka g) {System.out.println(banka);}
	}
}
