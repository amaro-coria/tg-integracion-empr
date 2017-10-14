package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="blnc_cta")
	private BigDecimal blncCta;

	@Column(name="fch_alt")
	private Timestamp fchAlt;

	@Column(name="fch_cre")
	private Timestamp fchCre;

	@Column(name="fch_mod")
	private Timestamp fchMod;

	@Id
	@SequenceGenerator(name="seq_cta", sequenceName="cuenta_id_cta_seq", allocationSize=1)
	@GeneratedValue(generator="seq_cta", strategy=GenerationType.SEQUENCE)
	@Column(name="id_cta")
	private Integer idCta;

	@Column(name="id_est")
	private BigDecimal idEst;

	@Column(name="id_tip_cta")
	private Long idTipCta;

	@Column(name="no_cta")
	private String noCta;

	@Column(name="no_tar")
	private String noTar;

	public Cuenta() {
	}

	public BigDecimal getBlncCta() {
		return this.blncCta;
	}

	public void setBlncCta(BigDecimal blncCta) {
		this.blncCta = blncCta;
	}

	public Timestamp getFchAlt() {
		return this.fchAlt;
	}

	public void setFchAlt(Timestamp fchAlt) {
		this.fchAlt = fchAlt;
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

	public Integer getIdCta() {
		return this.idCta;
	}

	public void setIdCta(Integer idCta) {
		this.idCta = idCta;
	}

	public BigDecimal getIdEst() {
		return this.idEst;
	}

	public void setIdEst(BigDecimal idEst) {
		this.idEst = idEst;
	}

	public Long getIdTipCta() {
		return this.idTipCta;
	}

	public void setIdTipCta(Long idTipCta) {
		this.idTipCta = idTipCta;
	}

	public String getNoCta() {
		return this.noCta;
	}

	public void setNoCta(String noCta) {
		this.noCta = noCta;
	}

	public String getNoTar() {
		return this.noTar;
	}

	public void setNoTar(String noTar) {
		this.noTar = noTar;
	}

}