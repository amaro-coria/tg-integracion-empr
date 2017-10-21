package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
	@NamedQuery(name="Cliente.findByA", query="SELECT c FROM Cliente c WHERE c.apePatCte like :param")
})

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="seq_cte", sequenceName="cliente_id_cte_seq", allocationSize=1)
	@GeneratedValue(generator="seq_cte", strategy=GenerationType.SEQUENCE)
	@Column(name="id_cte")
	private Integer idCte;
	
	@Column(name="ape_mat_cte")
	private String apeMatCte;

	@Column(name="ape_pat_cte")
	private String apePatCte;

	@Column(name="dir_cte")
	private String dirCte;

	@Column(name="id_edo_cte")
	private Long idEdoCte;

	@Column(name="nom_cte")
	private String nomCte;

	@Column(name="tel_cte")
	private String telCte;

	public Cliente() {
	}

	public String getApeMatCte() {
		return this.apeMatCte;
	}

	public void setApeMatCte(String apeMatCte) {
		this.apeMatCte = apeMatCte;
	}

	public String getApePatCte() {
		return this.apePatCte;
	}

	public void setApePatCte(String apePatCte) {
		this.apePatCte = apePatCte;
	}

	public String getDirCte() {
		return this.dirCte;
	}

	public void setDirCte(String dirCte) {
		this.dirCte = dirCte;
	}

	public Integer getIdCte() {
		return this.idCte;
	}

	public void setIdCte(Integer idCte) {
		this.idCte = idCte;
	}

	public Long getIdEdoCte() {
		return this.idEdoCte;
	}

	public void setIdEdoCte(Long idEdoCte) {
		this.idEdoCte = idEdoCte;
	}

	public String getNomCte() {
		return this.nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
	}

	public String getTelCte() {
		return this.telCte;
	}

	public void setTelCte(String telCte) {
		this.telCte = telCte;
	}

}