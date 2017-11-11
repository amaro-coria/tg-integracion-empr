package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the movimientos_cuenta database table.
 * 
 */
@Entity
@Table(name="movimientos_cuenta")
@NamedQuery(name="MovimientosCuenta.findAll", query="SELECT m FROM MovimientosCuenta m")
public class MovimientosCuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="dsc_mov")
	private String dscMov;

	@Column(name="fch_cre")
	private Timestamp fchCre;

	@Column(name="fol_aut")
	private String folAut;

	@Column(name="id_cta")
	private Long idCta;

	@Id
	@SequenceGenerator(name="seq_cta_mov", sequenceName="movimientos_cuenta_id_mov_cta_seq", allocationSize=1)
	@GeneratedValue(generator="seq_cta_mov", strategy=GenerationType.SEQUENCE)
	@Column(name="id_mov_cta")
	private Integer idMovCta;

	@Column(name="id_tip_mov")
	private BigDecimal idTipMov;

	@Column(name="mnt_mov")
	private BigDecimal mntMov;

	public MovimientosCuenta() {
	}

	public String getDscMov() {
		return this.dscMov;
	}

	public void setDscMov(String dscMov) {
		this.dscMov = dscMov;
	}

	public Timestamp getFchCre() {
		return this.fchCre;
	}

	public void setFchCre(Timestamp fchCre) {
		this.fchCre = fchCre;
	}

	public String getFolAut() {
		return this.folAut;
	}

	public void setFolAut(String folAut) {
		this.folAut = folAut;
	}

	public Long getIdCta() {
		return this.idCta;
	}

	public void setIdCta(Long idCta) {
		this.idCta = idCta;
	}

	public Integer getIdMovCta() {
		return this.idMovCta;
	}

	public void setIdMovCta(Integer idMovCta) {
		this.idMovCta = idMovCta;
	}

	public BigDecimal getIdTipMov() {
		return this.idTipMov;
	}

	public void setIdTipMov(BigDecimal idTipMov) {
		this.idTipMov = idTipMov;
	}

	public BigDecimal getMntMov() {
		return this.mntMov;
	}

	public void setMntMov(BigDecimal mntMov) {
		this.mntMov = mntMov;
	}

}