package it.polito.tdp.spellchecker.model;

public class RichWord {

	/*  Ogni istanza di questa classe conterr� una parola del testo in input, e l�indicazione se tale
parola � corretta o meno (utilizzare, ad esempio, un booleano ).
*/
	private String parola;
	private boolean corretta=true;
	
	public RichWord(String parola) {
		super();
		this.parola = parola;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}
	
	
	
}
