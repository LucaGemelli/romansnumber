package br.com.dell.romans.service;

public class RomansService {

	public void calculaNumeros(final String romanos) {
		this.validaNumeros(romanos);
		this.traduzirNumeralRomano(romanos);
	}

	private void validaNumeros(String romanos) {
		if(romanos.isEmpty()) {
			return;
		}

		for(int i = 0; i < romanos.length(); i++) {
			if(romanos.length() > 4) {
				String a = romanos.substring(0, 1);
				if(a.equals(romanos.substring(1, 2)) 
					&& a.equals(romanos.substring(2,3))
					&& a.equals(romanos.substring(3, 4))) {
					System.out.println("A letra ".concat(a).concat(" Está se repetindo mais de 3 vezes em sequencia."));
				}
				romanos = romanos.substring(1, romanos.length());
			}
		}
	}

	private int traduzirNumeralRomano(String texto) {
		int n = 0;
		int numeralDaDireita = 0;
		for (int i = texto.length() - 1; i >= 0; i--) {
			int valor = (int) this.traduzirNumeralRomano(texto.charAt(i));
			n += valor * Math.signum(valor + 0.5 - numeralDaDireita);
			numeralDaDireita = valor;
		}
		return n;
	}

	private double traduzirNumeralRomano(char caractere) {
		return Math.floor(Math.pow(10, "IXCM".indexOf(caractere))) + 5 * Math.floor(Math.pow(10, "VLD".indexOf(caractere)));
	}
}
