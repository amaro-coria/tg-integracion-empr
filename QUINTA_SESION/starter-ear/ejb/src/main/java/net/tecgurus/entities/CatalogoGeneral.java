package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the catalogo_general database table.
 * 
 */
@Entity
@Table(name = "catalogo_general")
@Cacheable
@NamedQueries({ @NamedQuery(name = "CatalogoGeneral.findAll", query = "SELECT c FROM CatalogoGeneral c"),
		@NamedQuery(name = "CatalogoGeneral.findRecentFromDays", 
		query = "SELECT c FROM CatalogoGeneral c WHERE c.fchCre > :fechaParam")
})
public class CatalogoGeneral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY=MYSQL)
	@SequenceGenerator(sequenceName = "catalogo_general_id_cat_seq", name = "sequence_catalogo", allocationSize = 1)
	@GeneratedValue(generator = "sequence_catalogo", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_cat")
	private Integer idCat;

	@Column(name = "dsc_com_cat")
	private String dscComCat;

	@Column(name = "dsc_cor_cat")
	private String dscCorCat;

	@Column(name = "fch_cre")
	private Timestamp fchCre;

	@Column(name = "fch_mod")
	private Timestamp fchMod;

	@Column(name = "id_est_cat")
	private Long idEstCat;

	public CatalogoGeneral() {
	}

	public String getDscComCat() {
		return this.dscComCat;
	}

	public void setDscComCat(String dscComCat) {
		this.dscComCat = dscComCat;
	}

	public String getDscCorCat() {
		return this.dscCorCat;
	}

	public void setDscCorCat(String dscCorCat) {
		this.dscCorCat = dscCorCat;
	}

	public Timestamp getFchCre() {
		return this.fchCre;
	}

	public void setFchCre(Timestamp fchCre) {
		this.fchCre = fchCre;
	}

	public Timestamp getFchMod() {
		return this.fchMod;
	}

	public void setFchMod(Timestamp fchMod) {
		this.fchMod = fchMod;
	}

	public Integer getIdCat() {
		return this.idCat;
	}

	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	public Long getIdEstCat() {
		return this.idEstCat;
	}

	public void setIdEstCat(Long idEstCat) {
		this.idEstCat = idEstCat;
	}

}