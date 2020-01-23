package dev.paie;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BulletinJason {
	private Integer			idBulletinSalaire;
	private LocalDateTime	dateHeureCreation ;
	private LocalDate		dateDebutPeriode;
	private LocalDate		dateFinPeriode;
	private	String			matricule;
	private BigDecimal		salaireBrut;
	private BigDecimal		salaireNetImposable;
	private BigDecimal		salaireNetAPayer;
	
	public BulletinJason() {
		
	}
	
	public BulletinJason(int idBulletinSalaire, LocalDateTime dateHeureCreation, LocalDate dateDebutPeriode,
			LocalDate dateFinPeriode, String matricule, BigDecimal salaireBrut, BigDecimal salaireNetImposable,
			BigDecimal salaireNetAPayer) {
		super();
		this.idBulletinSalaire = idBulletinSalaire;
		this.dateHeureCreation = dateHeureCreation;
		this.dateDebutPeriode = dateDebutPeriode;
		this.dateFinPeriode = dateFinPeriode;
		this.matricule = matricule;
		this.salaireBrut = salaireBrut;
		this.salaireNetImposable = salaireNetImposable;
		this.salaireNetAPayer = salaireNetAPayer;
	}

	/** Getter
	 * @return the dateHeureCreation
	 */
	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	/** Setter
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	/** Getter
	 * @return the dateDebutPeriode
	 */
	public LocalDate getDateDebutPeriode() {
		return dateDebutPeriode;
	}
	/** Setter
	 * @param dateDebutPeriode the dateDebutPeriode to set
	 */
	public void setDateDebutPeriode(LocalDate dateDebutPeriode) {
		this.dateDebutPeriode = dateDebutPeriode;
	}
	/** Getter
	 * @return the dateFinPeriode
	 */
	public LocalDate getDateFinPeriode() {
		return dateFinPeriode;
	}
	/** Setter
	 * @param dateFinPeriode the dateFinPeriode to set
	 */
	public void setDateFinPeriode(LocalDate dateFinPeriode) {
		this.dateFinPeriode = dateFinPeriode;
	}
	/** Getter
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/** Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/** Getter
	 * @return the salaireBrut
	 */
	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}
	/** Setter
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	/** Getter
	 * @return the salaireNetImposable
	 */
	public BigDecimal getSalaireNetImposable() {
		return salaireNetImposable;
	}
	/** Setter
	 * @param salaireNetImposable the salaireNetImposable to set
	 */
	public void setSalaireNetImposable(BigDecimal salaireNetImposable) {
		this.salaireNetImposable = salaireNetImposable;
	}
	/** Getter
	 * @return the salaireNetAPayer
	 */
	public BigDecimal getSalaireNetAPayer() {
		return salaireNetAPayer;
	}
	/** Setter
	 * @param salaireNetAPayer the salaireNetAPayer to set
	 */
	public void setSalaireNetAPayer(BigDecimal salaireNetAPayer) {
		this.salaireNetAPayer = salaireNetAPayer;
	}

	/** Getter
	 * @return the idBulletinSalaire
	 */
	public int getIdBulletinSalaire() {
		return idBulletinSalaire;
	}

	/** Setter
	 * @param idBulletinSalaire the idBulletinSalaire to set
	 */
	public void setIdBulletinSalaire(int idBulletinSalaire) {
		this.idBulletinSalaire = idBulletinSalaire;
	}
	
	
}
