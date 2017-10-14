package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the cuentas_cliente database table.
 * 
 */
@Entity
@Table(name="cuentas_cliente")
@NamedQuery(name="CuentasCliente.findAll", query="SELECT c FROM CuentasCliente c")
public class CuentasCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cmnt_cta_cte")
	private String cmntCtaCte;

	@Column(name="fch_cre")
	private Timestamp fchCre;

	@Column(name="id_cta")
	private Long idCta;

	@Id
	@SequenceGenerator(name="seq_cta_cte", sequenceName="cuentas_cliente_id_cta_cte_seq", allocationSize=1)
	@GeneratedValue(generator="seq_cta_cte", strategy=GenerationType.SEQUENCE)
	@Column(name="id_cta_cte")
	private Integer idCtaCte;

	@Column(name="id_cte")
	private Long idCte;

	@Column(name="id_edo_cta_cte")
	private Long idEdoCtaCte;

	@Column(name="id_tip_cta_cte")
	private Long idTipCtaCte;

	public CuentasCliente() {
	}

	public String getCmntCtaCte() {
		return this.cmntCtaCte;
	}

	public void setCmntCtaCte(String cmntCtaCte) {
		this.cmntCtaCte = cmntCtaCte;
	}

	public Timestamp getFchCre() {
		return this.fchCre;
	}

	public void setFchCre(Timestamp fchCre) {
		this.fchCre = fchCre;
	}

	public Long getIdCta() {
		return this.idCta;
	}

	public void setIdCta(Long idCta) {
		this.idCta = idCta;
	}

	public Integer getIdCtaCte() {
		return this.idCtaCte;
	}

	public void setIdCtaCte(Integer idCtaCte) {
		this.idCtaCte = idCtaCte;
	}

	public Long getIdCte() {
		return this.idCte;
	}

	public void setIdCte(Long idCte) {
		this.idCte = idCte;
	}

	public Long getIdEdoCtaCte() {
		return this.idEdoCtaCte;
	}

	public void setIdEdoCtaCte(Long idEdoCtaCte) {
		this.idEdoCtaCte = idEdoCtaCte;
	}

	public Long getIdTipCtaCte() {
		return this.idTipCtaCte;
	}

	public void setIdTipCtaCte(Long idTipCtaCte) {
		this.idTipCtaCte = idTipCtaCte;
	}

}