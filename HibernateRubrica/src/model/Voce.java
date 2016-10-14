package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voce {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_voce;
	
	private String nome;
	private String cognome;
	private String tel;
	
	@ManyToOne
	private Rubrica rubrica;
	
	



	public Voce() {

		this.nome = "";
		this.cognome = "";
		this.tel = "";
	}
	
	
	
	public Voce( String nome, String cognome, String tel) {

		this.nome = nome;
		this.cognome = cognome;
		this.tel = tel;
	}



	@Override
	public String toString() {
		return nome +" "+cognome+" "+tel;
	}



	public long getId_voce() {
		return id_voce;
	}



	public void setId_voce(long id_voce) {
		this.id_voce = id_voce;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public Rubrica getRubrica() {
		return rubrica;
	}



	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}
	
	

}