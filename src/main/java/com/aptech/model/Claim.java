package com.aptech.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Claims")
public class Claim {

	@Id
	@GeneratedValue
	@Column(name = "ClaimId")
	private Long id;

	@NotNull
	@JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId")
	@ManyToOne
	private Employee employee;

	/**
	 * The fields for treatment information.
	 */

	@Temporal(TemporalType.DATE)
	@Column(name = "DateOfConsultation", nullable = false)
	private Date dateOfConsultation;

	@NotEmpty
	@Lob
	@Size(max = 2147483647)
	@Column(name = "ConditionsOfDisease")
	private String conditionsOfDisease;

	@Column(name = "OutPatient", nullable = false)
	private boolean outPatient;

	@Column(name = "InPatient", nullable = false)
	private boolean inPatient;

	@Temporal(TemporalType.DATE)
	@Column(name = "FromDate", nullable = false)
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "ToDate", nullable = false)
	private Date toDate;

	@NotEmpty
	@Column(name = "TreatmentAt")
	private String treatmentAt;

	/**
	 * The fields for treatment expenses.
	 */

	@Column(name = "Consultation", nullable = false)
	private BigDecimal consultation;

	@Column(name = "Medications", nullable = false)
	private BigDecimal medications;

	@Column(name = "LabAndImaging", nullable = false)
	private BigDecimal labAndImaging;

	@Column(name = "RoomAndBoard", nullable = false)
	private BigDecimal roomAndBoard;

	@Column(name = "Surgery", nullable = false)
	private BigDecimal surgery;

	@Column(name = "Others", nullable = false)
	private BigDecimal others;
	/**
	 * The field for related information.
	 */
	@NotEmpty
	@Lob
	@Size(max = 2147483647)
	@Column(name = "RelatedInvoices")
	private String relatedInvoices;

	/**
	 * The field for claim status.
	 */
	@NotEmpty
	@Column(name = "Status")
	private String status;

	public String getConditionsOfDisease() {
		return conditionsOfDisease;
	}

	public BigDecimal getConsultation() {
		return consultation;
	}

	public Date getDateOfConsultation() {
		return dateOfConsultation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getLabAndImaging() {
		return labAndImaging;
	}

	public BigDecimal getMedications() {
		return medications;
	}

	public BigDecimal getOthers() {
		return others;
	}

	public String getRelatedInvoices() {
		return relatedInvoices;
	}

	public BigDecimal getRoomAndBoard() {
		return roomAndBoard;
	}

	public String getStatus() {
		return status;
	}

	public BigDecimal getSurgery() {
		return surgery;
	}

	public Date getToDate() {
		return toDate;
	}

	public String getTreatmentAt() {
		return treatmentAt;
	}

	public boolean isInPatient() {
		return inPatient;
	}

	public boolean isOutPatient() {
		return outPatient;
	}

	public void setConditionsOfDisease(String conditionsOfDisease) {
		this.conditionsOfDisease = conditionsOfDisease;
	}

	public void setConsultation(BigDecimal consultation) {
		this.consultation = consultation;
	}

	public void setDateOfConsultation(Date dateOfConsultation) {
		this.dateOfConsultation = dateOfConsultation;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInPatient(boolean inPatient) {
		this.inPatient = inPatient;
	}

	public void setLabAndImaging(BigDecimal labAndImaging) {
		this.labAndImaging = labAndImaging;
	}

	public void setMedications(BigDecimal medications) {
		this.medications = medications;
	}

	public void setOthers(BigDecimal others) {
		this.others = others;
	}

	public void setOutPatient(boolean outPatient) {
		this.outPatient = outPatient;
	}

	public void setRelatedInvoices(String relatedInvoices) {
		this.relatedInvoices = relatedInvoices;
	}

	public void setRoomAndBoard(BigDecimal roomAndBoard) {
		this.roomAndBoard = roomAndBoard;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSurgery(BigDecimal surgery) {
		this.surgery = surgery;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public void setTreatmentAt(String treatmentAt) {
		this.treatmentAt = treatmentAt;
	}
}
