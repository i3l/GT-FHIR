package edu.gatech.i3l.fhir.dstu2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.dstu2.composite.QuantityDt;
import ca.uhn.fhir.model.dstu2.resource.MedicationPrescription;
import ca.uhn.fhir.model.dstu2.resource.MedicationPrescription.DosageInstruction;
import ca.uhn.fhir.model.dstu2.valueset.QuantityComparatorEnum;

/**
 * @fhirVersion 2.0
 * @author Ismael Sarmento
 */
@Entity
@Table(name="f_drug_exposure")
@PrimaryKeyJoinColumn(name="drug_exposure_id")
@Audited
public class DrugExposurePrescriptionWrittenComplement extends DrugExposurePrescriptionWritten {

	/**
	 * @fhir MedicationPrescription.dosageInstruction.dose.doseQuantity
	 */
	@Column(name="dose")
	private String dose;
//	@Column(name="effective_drug_dose")
//	private BigDecimal dose;
	
	/**
	 * The corresponding unit for the dose quantity.
	 */
	@Column(name="unit")
	private String unit;
//	@Column(name="dose_unit_concept_id")
//	private Concept unit;

	
	
	public String getDose() {
		return dose;
	}
	
	
	public void setDose(String dose) {
		this.dose = dose;
	}
	
	
	public String getUnit() {
		return unit;
	}
	
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public IResource getRelatedResource() {
		MedicationPrescription resource = (MedicationPrescription) super.getRelatedResource();
		DosageInstruction dosage = new DosageInstruction();
		dosage.setDose(new QuantityDt(QuantityComparatorEnum.LESSTHAN_OR_EQUALS, Double.parseDouble(this.dose),  this.unit));
		resource.addDosageInstruction(dosage);
		return resource;
	}
	
}