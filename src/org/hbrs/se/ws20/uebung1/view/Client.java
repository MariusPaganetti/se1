package org.hbrs.se.ws20.uebung1.view;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.factory.Factory;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 */
	public void display( int aNumber ){
		// In dieser Methode soll die Methode translateNumber 
		// mit dem übergegebenen Wert der Variable aNumber 
		// aufgerufen werden.
		// Strenge Implementierung gegen das Interface Translator gewuenscht!
		GermanTranslator germanTranslator = Factory.createGermanTranslator();
		String result = germanTranslator.translateNumber(aNumber);

		System.out.println("Das Ergebnis der Berechnung: " + result);

	}

	public static void main(String[] args)
	{
		Client client = new Client();
		client.display(1);
	}
}




