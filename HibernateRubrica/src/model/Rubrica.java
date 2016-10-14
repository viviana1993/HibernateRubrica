package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity//creo un entità
@Table(name="RubricaHQL")//creo tabella con questo nome
public class Rubrica {


	@Id//indico che questa è una chiave primaria
	@GeneratedValue(strategy=GenerationType.AUTO)//Serve per  scegliere le strategie con cui voglio lavorare
	//.AUTO serve per imporre di assegnare la chiave in automatico
	private int id_rubrica;

	@Column(name="nome")
	private String nome;


	@OneToMany(fetch=FetchType.EAGER,mappedBy="persona",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Voce> vociRubrica=new HashSet<>();



	public Set<Voce> getVociRubrica() {
		return vociRubrica;
	}


	public void setVociRubrica(Set<Voce> vociRubrica) {
		vociRubrica = vociRubrica;
	}


	public Rubrica() {
		super();
	}


	public Rubrica(int id_rubrica, String nome,Set<Voce> vociRubrica) {
		super();
		this.id_rubrica = id_rubrica;
		this.nome = nome;
		this.vociRubrica=vociRubrica;
	}


	public int getId_rubrica() {
		return id_rubrica;
	}


	public void setId_rubrica(int id_rubrica) {
		this.id_rubrica = id_rubrica;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void addVoce(Voce v){
		this.vociRubrica.add(v);
		
	}


}
