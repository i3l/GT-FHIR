/**
 * 
 */
package edu.gatech.i3l.fhir.dstu3.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.instance.model.api.IBaseResource;

import org.hl7.fhir.dstu3.model.Condition;
import org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Period;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Type;
import org.hl7.fhir.dstu3.model.codesystems.ConditionCategory;
import org.hl7.fhir.exceptions.FHIRException;

import ca.uhn.fhir.context.FhirVersionEnum;
//import ca.uhn.fhir.model.api.IDatatype;
//import ca.uhn.fhir.model.api.IResource;
//import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
//import ca.uhn.fhir.model.dstu2.composite.CodingDt;
//import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
//import ca.uhn.fhir.model.dstu2.composite.PeriodDt;
//import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
//import ca.uhn.fhir.model.dstu2.resource.Condition;
//import ca.uhn.fhir.model.dstu2.valueset.ConditionCategoryCodesEnum;
//import ca.uhn.fhir.model.dstu2.valueset.ConditionVerificationStatusEnum;
//import ca.uhn.fhir.model.primitive.DateTimeDt;
//import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.primitive.InstantDt;
import edu.gatech.i3l.fhir.jpa.entity.BaseResourceEntity;
import edu.gatech.i3l.fhir.jpa.entity.IResourceEntity;
import edu.gatech.i3l.omop.enums.Omop4ConceptsFixedIds;
import edu.gatech.i3l.omop.mapping.OmopConceptMapping;

/**
 * @author Myung Choi
 *
 */
@Entity
@Table(name="condition_occurrence")
@Inheritance(strategy=InheritanceType.JOINED)
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class ConditionOccurrence extends BaseResourceEntity {

	public static final String RESOURCE_TYPE = "Condition";

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="condition_occurrence_seq_gen")
	@SequenceGenerator(name="condition_occurrence_seq_gen", sequenceName="condition_occurrence_id_seq", allocationSize=1)
	@Column(name="condition_occurrence_id")
	@Access(AccessType.PROPERTY)
	private Long id;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="person_id", nullable=false)
	@NotNull
	private PersonComplement person;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="condition_concept_id", nullable=false)
	@NotNull
	private Concept conditionConcept;
	
	@Column(name="condition_start_date", nullable=false)
	@NotNull
	private Date startDate;
	
	@Column(name="condition_end_date", nullable=false)
	private Date endDate;
	
	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="condition_type_concept_id", nullable=false)
	@NotNull
	private Concept conditionTypeConcept;
	
	@Column(name="stop_reason")
	private String stopReason;
	
	/**
	 * @omop 
	 * @fhir Asserter:
	 * 			person who asserts this condition (Practitioner or Patient)
	 * @fhirVersion 0.4.0
	 * @omopVersion 4.0
	 */
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="provider_id")
	private Provider provider;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="visit_occurrence_id")
	private VisitOccurrence encounter;
	
	@Column(name="condition_source_value")
	private String sourceValue; 

	@ManyToOne(cascade={CascadeType.MERGE})
	@JoinColumn(name="condition_source_concept_id")
	private Concept sourceConcept;
	
	public ConditionOccurrence() {
		super();
	}

	public ConditionOccurrence(Long id, PersonComplement person, Concept conditionConcept, Date startDate, Date endDate,
			Concept conditionTypeConcept, String stopReason, Provider provider, VisitOccurrence encounter,
			String sourceValue, Concept sourceConcept) {
		super();

		this.id = id;
		this.person = person;
		this.conditionConcept = conditionConcept;
		this.startDate = startDate;
		this.endDate = endDate;
		this.conditionTypeConcept = conditionTypeConcept;
		this.stopReason = stopReason;
		this.provider = provider;
		this.encounter = encounter;
		this.sourceValue = sourceValue;
		this.sourceConcept = sourceConcept;
	}

	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getResourceType() {
		return RESOURCE_TYPE;
	}

	public PersonComplement getPerson() {
		return person;
	}

	public void setPerson(PersonComplement person) {
		this.person = person;
	}

	public Concept getConditionConcept() {
		return conditionConcept;
	}

	public void setConditionConcept(Concept conditionConcept) {
		this.conditionConcept = conditionConcept;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Concept getConditionTypeConcept() {
		return conditionTypeConcept;
	}

	public void setConditionTypeConcept(Concept conditionTypeConcept) {
		this.conditionTypeConcept = conditionTypeConcept;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public VisitOccurrence getEncounter() {
		return encounter;
	}

	public void setEncounter(VisitOccurrence encounter) {
		this.encounter = encounter;
	}

	public String getSourceValue() {
		return sourceValue;
	}

	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}
	
	public Concept getSourceConcept() {
		return sourceConcept;
	}
	
	public void setSourceConcept(Concept sourceConcept) {
		this.sourceConcept = sourceConcept;
	}

	@Override
	public IResourceEntity constructEntityFromResource(IBaseResource resource) {
		if (resource instanceof Condition) {
			Condition condition = (Condition) resource;
			
			/* Set patient */
			Reference patientResource =  condition.getSubject();
			if (patientResource == null) return null; // We have to have a patient
			
//			Long patientRef = patientResource.getReference().getIdPartAsLong();
			PersonComplement person = PersonComplement.searchAndUpdate(patientResource);
			if (person == null) return null; // We must have a patient
			
			this.setPerson(person);

//			Long patientRef = condition.getPatient().getReference().getIdPartAsLong();
//			if(patientRef != null){
//				this.person =  new PersonComplement();
//				this.person.setId(patientRef);
//			}
			
			// We are writing to the database. Keep the source so we know where it is coming from
			OmopConceptMapping ocm = OmopConceptMapping.getInstance();
			if (condition.getIdElement().getIdPartAsLong() != null) {
				this.setId(condition.getIdElement().getIdPartAsLong());
			} else {
				// We are creating a new entry. But, before we do that, we need to check if
				// this data has already been entered. Use its identifier again source value to check 
				//
				// See if we have identifier.
				Identifier identifier = condition.getIdentifierFirstRep();
				String identifierValue = identifier.getValue();
				if (identifierValue != null && identifierValue.isEmpty() == false) {
					ConditionOccurrence existingConditionOccurrence = 
							(ConditionOccurrence) ocm.loadEntityBySource(ConditionOccurrence.class, "ConditionOccurrence", "sourceValue", identifierValue);
					if (existingConditionOccurrence != null) {
						this.setId(existingConditionOccurrence.getId());
					}
					
					this.setSourceValue(identifierValue);
				}				
			}

			Long conditionConceptRef = ocm.get(condition.getCode().getCodingFirstRep().getCode());
			this.conditionConcept = new Concept();
			if(conditionConceptRef != null){
				this.conditionConcept.setId(conditionConceptRef);
			} else {
				this.conditionConcept.setId(0L);
				System.out.println("Condition code not recognized: "+condition.getCode().getCodingFirstRep().getCode()+". System: "+condition.getCode().getCodingFirstRep().getSystem());
			}
			
			Type onSetDate = condition.getOnset();
			if (onSetDate instanceof DateTimeType) {
				DateTimeType dateTimeType = (DateTimeType) onSetDate;
				this.startDate = dateTimeType.getValue();
			} else if (onSetDate instanceof Period) {
				Period period = (Period) onSetDate;
				this.startDate = period.getStart();
				this.endDate = period.getEnd();
			}

			Reference encounterResource = condition.getContext();
			if (encounterResource != null) {
				Long encounterReference = encounterResource.getReferenceElement().getIdPartAsLong();
				if (encounterReference != null) {
					VisitOccurrence visitOccurrence = VisitOccurrence
							.searchAndUpdate(encounterReference, startDate, endDate, this.person);
					if (visitOccurrence != null) {
						this.setEncounter(visitOccurrence);
					} 
				}
			}
			
			this.conditionTypeConcept = new Concept();
			List<CodeableConcept> condCategories = condition.getCategory();
			CodeableConcept condCategory = condCategories.get(0);
			if (!condCategory.isEmpty()) {
				Coding condCatCoding = condCategory.getCodingFirstRep();
				
				if (condCatCoding.getCode().equalsIgnoreCase(ConditionCategory.PROBLEMLISTITEM.toCode())) {
					this.conditionTypeConcept.setId(Omop4ConceptsFixedIds.PATIENT_SELF_REPORT.getConceptId());
				} else {
					this.conditionTypeConcept.setId(Omop4ConceptsFixedIds.EHR_PROBLEM_ENTRY.getConceptId());
				}
			} else {
				this.conditionTypeConcept.setId(Omop4ConceptsFixedIds.PRIMARY_CONDITION.getConceptId());
			}

			// this.stopReason = stopReason; NOTE: no FHIR parameter for
			// stopReason.

			Reference asserterResRef = condition.getAsserter();
			if (!asserterResRef.isEmpty() && asserterResRef.getReferenceElement().getIdPartAsLong() != null && asserterResRef.getReferenceElement().getResourceType() != null 
					&& asserterResRef.getReferenceElement().getResourceType().equalsIgnoreCase(Provider.RESOURCE_TYPE)) {
				Long providerId = asserterResRef.getReferenceElement().getIdPartAsLong();					
				if (providerId != null) {
					Provider provider = (Provider) OmopConceptMapping.getInstance().loadEntityById(Provider.class, providerId);
					if (provider != null) {
						this.setProvider(provider);
					} else {
						// See if we have received this earlier.
						provider = (Provider) OmopConceptMapping.getInstance().loadEntityBySource(Provider.class, "Provider", "providerSourceValue", providerId.toString());
						if (provider == null) {
							this.provider = new Provider();
							this.provider.setProviderName(asserterResRef.getDisplay());
							this.provider.setProviderSourceValue(providerId.toString());
						} else {
							this.setProvider(provider);
						}
					}
				} 
			}

			//this.sourceValue = "FHIRCREATE";
		}

		return this;
	}
	
	@Override
	public Condition getRelatedResource() {
		Condition condition = new Condition();

		// Populate condition parameters.
		// Refer to 4.3.3 at http://hl7-fhir.github.io/condition.html

		condition.setId(this.getIdDt());

		// Set patient reference to Patient (note: in dstu1, this was subject.)
//		ResourceReferenceDt patientReference = new ResourceReferenceDt(new IdDt(Person.RES_TYPE, this.person.getId()));
//		patientReference.setDisplay(this.person.getNameAsSingleString());
		Reference patientReference = new Reference();
		patientReference.setReference(Person.RES_TYPE+"/"+this.person.getId());
		patientReference.setDisplay(this.person.getNameAsSingleString());
		condition.setSubject(patientReference);

		// Set encounter if exists.
		if (encounter != null && encounter.getId() > 0) {
			// FIXME: encounter resource not yet implemented.
			// we just create this reference resource manually. When encounter
			// is implemented, we
			// will get it from visit_occurrence class.
			Reference encounterReference = new Reference();
			encounterReference.setReference(VisitOccurrence.RES_TYPE+"/"+this.encounter.getId());
			condition.setContext(encounterReference);
		}

		// Set asserter if exists
		// This can be either Patient or Practitioner.
		if (provider != null && provider.getId() > 0) {
			Reference practitionerReference = new Reference();
			practitionerReference.setReference(Provider.RESOURCE_TYPE+"/"+provider.getId());
			practitionerReference.setDisplay(this.provider.getProviderName());
			condition.setAsserter(practitionerReference);
		}

		// Set Code
		// System.out.println("ConceptID:"+this.getConditionConcept().getId().toString());
		// System.out.println("ConceptName:"+this.getConditionConcept().getName());
		//
		// Vocabulary myVoc = this.getConditionConcept().getVocabulary();
		//
		// System.out.println("VocabularyID:"+myVoc.getId());
		// System.out.println("VocabularyName:"+myVoc.getName());

		// First check if ICD codes are available.
		String theSystem;
		String theCode;
		String theDisplay = "";
//		if (this.sourceValue.startsWith("icd-9-cm:") == true) {
//			theSystem = "http://hl7.org/fhir/sid/icd-9-cm";
//			theCode = this.sourceValue.substring(9);
//		} else {
		theSystem = conditionConcept.getVocabulary().getSystemUri();
		theCode = conditionConcept.getConceptCode();
		theDisplay = conditionConcept.getName();
//		}

		CodeableConcept conditionCodeConcept = new CodeableConcept();
		if (theSystem != "") {
			// Create coding here. We have one coding in this condition as OMOP
			// allows one coding concept per condition.
			// In the future, if we want to allow multiple coding concepts here,
			// we need to do it here.
			Coding coding = new Coding(theSystem, theCode, theDisplay);
			conditionCodeConcept.addCoding(coding);
		}

		// FHIR does not require the coding. If our System URI is not mappable
		// from
		// OMOP database, then coding would be empty. Set Text here. Even text
		// is not
		// required in FHIR. But, then no reason to have this condition, I
		// think...
		String theText = conditionConcept.getName() + ", " + conditionConcept.getVocabulary().getName() + ", "
				+ conditionConcept.getConceptCode();

		conditionCodeConcept.setText(theText);
		condition.setCode(conditionCodeConcept);

		// Set clinicalStatus
		// We have clinicalStatus information in the FHIR extended table. This
		// will
		// be set in the extended class.

		// Set severity
		// We have this as well in the FHIR exteded table.

		// Set onset[x]
		// We may have only one date if this condition did not end. If ended, we
		// have
		// a period. First, check if endDate is available.
		DateTimeType startDateDt = new DateTimeType(startDate);
		if (endDate == null) {
			// Date
			condition.setOnset(startDateDt);
		} else {
			// Period
			Period periodDt = new Period();
			periodDt.setStart(startDate);
			periodDt.setEnd(endDate);
			condition.setOnset(periodDt);
		}
		
		// Category
		Concept myCat = this.getConditionConcept();
		CodeableConcept categoryCodeableConcept = new CodeableConcept();
		ConditionCategory category;
		try {
			if (myCat.getId() == Omop4ConceptsFixedIds.PATIENT_SELF_REPORT.getConceptId()) {
				category = ConditionCategory.fromCode(ConditionCategory.PROBLEMLISTITEM.toCode());
			} else {
				category = ConditionCategory.fromCode(ConditionCategory.ENCOUNTERDIAGNOSIS.toCode());
			}
			categoryCodeableConcept.addCoding((new Coding(category.getSystem(), category.toCode(), category.getDisplay())));
			condition.addCategory(categoryCodeableConcept);
		} catch (FHIRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// VerficationStutus 
		condition.setVerificationStatus(ConditionVerificationStatus.CONFIRMED);

		return condition;
	}
		
		
	@Override
	public FhirVersionEnum getFhirVersion() {
		return FhirVersionEnum.DSTU2;
	}

	@Override
	public InstantDt getUpdated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String translateSearchParam(String link) {
		switch (link) {
		case Condition.SP_CODE:
			return "conditionConcept.conceptCode";
		case Condition.SP_ONSET_DATE:
			return "startDate";
		case Condition.SP_ENCOUNTER:
			return "encounter";
		case Condition.SP_PATIENT:
			return "person";
//		case Condition.SP_SUBJECT:
//			return "person";
		default:
			break;
		}
		return link;
	}
}