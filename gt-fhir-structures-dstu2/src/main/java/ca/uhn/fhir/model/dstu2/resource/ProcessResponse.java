















package ca.uhn.fhir.model.dstu2.resource;

import java.math.BigDecimal;
import java.net.URI;
import java.util.*;
import ca.uhn.fhir.model.api.*;
import ca.uhn.fhir.model.api.annotation.*;
import ca.uhn.fhir.rest.gclient.*;

import ca.uhn.fhir.model.dstu2.valueset.AccountStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ActionListEnum;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.valueset.AdjudicationCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdjudicationErrorCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdjustmentReasonCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdmitSourceEnum;
import ca.uhn.fhir.model.dstu2.resource.AllergyIntolerance;
import ca.uhn.fhir.model.dstu2.valueset.AllergyIntoleranceCategoryEnum;
import ca.uhn.fhir.model.dstu2.valueset.AllergyIntoleranceCertaintyEnum;
import ca.uhn.fhir.model.dstu2.valueset.AllergyIntoleranceCriticalityEnum;
import ca.uhn.fhir.model.dstu2.valueset.AllergyIntoleranceSeverityEnum;
import ca.uhn.fhir.model.dstu2.valueset.AllergyIntoleranceStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.AllergyIntoleranceTypeEnum;
import ca.uhn.fhir.model.dstu2.composite.AnnotationDt;
import ca.uhn.fhir.model.dstu2.valueset.AnswerFormatEnum;
import ca.uhn.fhir.model.dstu2.resource.Appointment;
import ca.uhn.fhir.model.dstu2.valueset.AppointmentStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.AssertionDirectionTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.AssertionOperatorTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.AssertionResponseTypesEnum;
import ca.uhn.fhir.model.dstu2.composite.AttachmentDt;
import ca.uhn.fhir.model.dstu2.valueset.AuditEventActionEnum;
import ca.uhn.fhir.model.dstu2.valueset.AuditEventObjectLifecycleEnum;
import ca.uhn.fhir.model.dstu2.valueset.AuditEventObjectRoleEnum;
import ca.uhn.fhir.model.dstu2.valueset.AuditEventObjectTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.AuditEventOutcomeEnum;
import ca.uhn.fhir.model.dstu2.valueset.AuditEventParticipantNetworkTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.AuditEventSourceTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.BindingStrengthEnum;
import ca.uhn.fhir.model.dstu2.resource.BodySite;
import ca.uhn.fhir.model.dstu2.valueset.BundleTypeEnum;
import ca.uhn.fhir.model.dstu2.resource.CarePlan;
import ca.uhn.fhir.model.dstu2.valueset.CarePlanActivityStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.CarePlanRelationshipEnum;
import ca.uhn.fhir.model.dstu2.valueset.CarePlanStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Claim;
import ca.uhn.fhir.model.dstu2.resource.ClaimResponse;
import ca.uhn.fhir.model.dstu2.valueset.ClaimTypeEnum;
import ca.uhn.fhir.model.dstu2.resource.ClinicalImpression;
import ca.uhn.fhir.model.dstu2.valueset.ClinicalImpressionStatusEnum;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.resource.CommunicationRequest;
import ca.uhn.fhir.model.dstu2.valueset.CommunicationRequestStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.CommunicationStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Composition;
import ca.uhn.fhir.model.dstu2.valueset.CompositionAttestationModeEnum;
import ca.uhn.fhir.model.dstu2.valueset.CompositionStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ConceptMapEquivalenceEnum;
import ca.uhn.fhir.model.dstu2.resource.Condition;
import ca.uhn.fhir.model.dstu2.valueset.ConditionCategoryCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.ConditionClinicalStatusCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.ConditionVerificationStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ConditionalDeleteStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Conformance;
import ca.uhn.fhir.model.dstu2.valueset.ConformanceEventModeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ConformanceResourceStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ConformanceStatementKindEnum;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.valueset.ContentTypeEnum;
import ca.uhn.fhir.model.dstu2.resource.Contract;
import ca.uhn.fhir.model.dstu2.resource.Coverage;
import ca.uhn.fhir.model.dstu2.valueset.DataElementStringencyEnum;
import ca.uhn.fhir.model.dstu2.valueset.DaysOfWeekEnum;
import ca.uhn.fhir.model.dstu2.valueset.DetectedIssueSeverityEnum;
import ca.uhn.fhir.model.dstu2.resource.Device;
import ca.uhn.fhir.model.dstu2.resource.DeviceComponent;
import ca.uhn.fhir.model.dstu2.resource.DeviceMetric;
import ca.uhn.fhir.model.dstu2.valueset.DeviceMetricCalibrationStateEnum;
import ca.uhn.fhir.model.dstu2.valueset.DeviceMetricCalibrationTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.DeviceMetricCategoryEnum;
import ca.uhn.fhir.model.dstu2.valueset.DeviceMetricColorEnum;
import ca.uhn.fhir.model.dstu2.valueset.DeviceMetricOperationalStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.DeviceStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.DeviceUseRequest;
import ca.uhn.fhir.model.dstu2.valueset.DeviceUseRequestPriorityEnum;
import ca.uhn.fhir.model.dstu2.valueset.DeviceUseRequestStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticOrder;
import ca.uhn.fhir.model.dstu2.valueset.DiagnosticOrderPriorityEnum;
import ca.uhn.fhir.model.dstu2.valueset.DiagnosticOrderStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.DiagnosticReport;
import ca.uhn.fhir.model.dstu2.valueset.DiagnosticReportStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.DigitalMediaTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.DocumentModeEnum;
import ca.uhn.fhir.model.dstu2.resource.DocumentReference;
import ca.uhn.fhir.model.dstu2.valueset.DocumentReferenceStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.DocumentRelationshipTypeEnum;
import ca.uhn.fhir.model.dstu2.composite.ElementDefinitionDt;
import ca.uhn.fhir.model.dstu2.resource.EligibilityRequest;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.valueset.EncounterClassEnum;
import ca.uhn.fhir.model.dstu2.valueset.EncounterLocationStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.EncounterStateEnum;
import ca.uhn.fhir.model.dstu2.resource.EnrollmentRequest;
import ca.uhn.fhir.model.dstu2.resource.EpisodeOfCare;
import ca.uhn.fhir.model.dstu2.valueset.EpisodeOfCareStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ExtensionContextEnum;
import ca.uhn.fhir.model.dstu2.valueset.FamilyHistoryStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.FamilyMemberHistory;
import ca.uhn.fhir.model.dstu2.valueset.FilterOperatorEnum;
import ca.uhn.fhir.model.dstu2.valueset.FlagStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Goal;
import ca.uhn.fhir.model.dstu2.valueset.GoalPriorityEnum;
import ca.uhn.fhir.model.dstu2.valueset.GoalStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Group;
import ca.uhn.fhir.model.dstu2.valueset.GroupTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.GuideDependencyTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.GuidePageKindEnum;
import ca.uhn.fhir.model.dstu2.valueset.GuideResourcePurposeEnum;
import ca.uhn.fhir.model.dstu2.valueset.HTTPVerbEnum;
import ca.uhn.fhir.model.dstu2.resource.HealthcareService;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierTypeCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.IdentityAssuranceLevelEnum;
import ca.uhn.fhir.model.dstu2.resource.ImagingObjectSelection;
import ca.uhn.fhir.model.dstu2.resource.ImagingStudy;
import ca.uhn.fhir.model.dstu2.resource.Immunization;
import ca.uhn.fhir.model.dstu2.valueset.InstanceAvailabilityEnum;
import ca.uhn.fhir.model.dstu2.valueset.IssueSeverityEnum;
import ca.uhn.fhir.model.dstu2.valueset.IssueTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.KOStitleEnum;
import ca.uhn.fhir.model.dstu2.valueset.LinkTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ListModeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ListOrderCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.ListStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Location;
import ca.uhn.fhir.model.dstu2.valueset.LocationModeEnum;
import ca.uhn.fhir.model.dstu2.valueset.LocationStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.LocationTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.MaritalStatusCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.MeasmntPrincipleEnum;
import ca.uhn.fhir.model.dstu2.resource.Media;
import ca.uhn.fhir.model.dstu2.resource.Medication;
import ca.uhn.fhir.model.dstu2.valueset.MedicationAdministrationStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.MedicationDispenseStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.MedicationOrder;
import ca.uhn.fhir.model.dstu2.valueset.MedicationOrderStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.MedicationStatement;
import ca.uhn.fhir.model.dstu2.valueset.MedicationStatementStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.MessageEventEnum;
import ca.uhn.fhir.model.dstu2.valueset.MessageSignificanceCategoryEnum;
import ca.uhn.fhir.model.dstu2.valueset.MessageTransportEnum;
import ca.uhn.fhir.model.dstu2.resource.NamingSystem;
import ca.uhn.fhir.model.dstu2.valueset.NamingSystemIdentifierTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.NamingSystemTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.NoteTypeEnum;
import ca.uhn.fhir.model.dstu2.resource.NutritionOrder;
import ca.uhn.fhir.model.dstu2.valueset.NutritionOrderStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.valueset.ObservationRelationshipTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ObservationStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.OperationDefinition;
import ca.uhn.fhir.model.dstu2.valueset.OperationKindEnum;
import ca.uhn.fhir.model.dstu2.resource.OperationOutcome;
import ca.uhn.fhir.model.dstu2.valueset.OperationParameterUseEnum;
import ca.uhn.fhir.model.dstu2.resource.Order;
import ca.uhn.fhir.model.dstu2.valueset.OrderStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.valueset.ParticipantRequiredEnum;
import ca.uhn.fhir.model.dstu2.valueset.ParticipantStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ParticipantTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ParticipationStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.valueset.PayeeTypeCodesEnum;
import ca.uhn.fhir.model.dstu2.composite.PeriodDt;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Procedure;
import ca.uhn.fhir.model.dstu2.resource.ProcedureRequest;
import ca.uhn.fhir.model.dstu2.valueset.ProcedureRequestPriorityEnum;
import ca.uhn.fhir.model.dstu2.valueset.ProcedureRequestStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ProcedureStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.ProcessRequest;
import ca.uhn.fhir.model.dstu2.valueset.ProvenanceEntityRoleEnum;
import ca.uhn.fhir.model.dstu2.composite.QuantityDt;
import ca.uhn.fhir.model.dstu2.resource.Questionnaire;
import ca.uhn.fhir.model.dstu2.resource.QuestionnaireResponse;
import ca.uhn.fhir.model.dstu2.valueset.QuestionnaireResponseStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.QuestionnaireStatusEnum;
import ca.uhn.fhir.model.dstu2.composite.RangeDt;
import ca.uhn.fhir.model.dstu2.composite.RatioDt;
import ca.uhn.fhir.model.dstu2.valueset.ReferralMethodEnum;
import ca.uhn.fhir.model.dstu2.resource.ReferralRequest;
import ca.uhn.fhir.model.dstu2.valueset.ReferralStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.RelatedPerson;
import ca.uhn.fhir.model.dstu2.valueset.RemittanceOutcomeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ResourceTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ResourceVersionPolicyEnum;
import ca.uhn.fhir.model.dstu2.valueset.ResponseTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.RestfulConformanceModeEnum;
import ca.uhn.fhir.model.dstu2.valueset.RestfulSecurityServiceEnum;
import ca.uhn.fhir.model.dstu2.resource.RiskAssessment;
import ca.uhn.fhir.model.dstu2.valueset.RulesetCodesEnum;
import ca.uhn.fhir.model.dstu2.composite.SampledDataDt;
import ca.uhn.fhir.model.dstu2.resource.Schedule;
import ca.uhn.fhir.model.dstu2.valueset.SearchEntryModeEnum;
import ca.uhn.fhir.model.dstu2.valueset.SearchModifierCodeEnum;
import ca.uhn.fhir.model.dstu2.valueset.SearchParamTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ServiceProvisionConditionsEnum;
import ca.uhn.fhir.model.dstu2.composite.SignatureDt;
import ca.uhn.fhir.model.dstu2.resource.Slot;
import ca.uhn.fhir.model.dstu2.valueset.SlotStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Specimen;
import ca.uhn.fhir.model.dstu2.valueset.SpecimenStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.StructureDefinition;
import ca.uhn.fhir.model.dstu2.valueset.StructureDefinitionKindEnum;
import ca.uhn.fhir.model.dstu2.valueset.SubscriptionChannelTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.SubscriptionStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.Substance;
import ca.uhn.fhir.model.dstu2.valueset.SubstanceCategoryCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.SupplyDeliveryStatusEnum;
import ca.uhn.fhir.model.dstu2.resource.SupplyRequest;
import ca.uhn.fhir.model.dstu2.valueset.SupplyRequestStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.SystemRestfulInteractionEnum;
import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.dstu2.composite.TimingDt;
import ca.uhn.fhir.model.dstu2.valueset.TransactionModeEnum;
import ca.uhn.fhir.model.dstu2.valueset.TypeRestfulInteractionEnum;
import ca.uhn.fhir.model.dstu2.valueset.UnknownContentCodeEnum;
import ca.uhn.fhir.model.dstu2.valueset.UseEnum;
import ca.uhn.fhir.model.dstu2.resource.ValueSet;
import ca.uhn.fhir.model.dstu2.valueset.VisionBaseEnum;
import ca.uhn.fhir.model.dstu2.valueset.VisionEyesEnum;
import ca.uhn.fhir.model.dstu2.resource.VisionPrescription;
import ca.uhn.fhir.model.dstu2.valueset.XPathUsageTypeEnum;
import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.dstu2.composite.AgeDt;
import ca.uhn.fhir.model.dstu2.composite.BoundCodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.DurationDt;
import ca.uhn.fhir.model.dstu2.composite.MoneyDt;
import ca.uhn.fhir.model.dstu2.composite.NarrativeDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.composite.SimpleQuantityDt;
import ca.uhn.fhir.model.primitive.Base64BinaryDt;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.BoundCodeDt;
import ca.uhn.fhir.model.primitive.CodeDt;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.DecimalDt;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.primitive.InstantDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.model.primitive.OidDt;
import ca.uhn.fhir.model.primitive.PositiveIntDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.model.primitive.TimeDt;
import ca.uhn.fhir.model.primitive.UnsignedIntDt;
import ca.uhn.fhir.model.primitive.UriDt;


/**
 * HAPI/FHIR <b>ProcessResponse</b> Resource
 * ()
 *
 * <p>
 * <b>Definition:</b>
 * This resource provides processing status, errors and notes from the processing of a resource.
 * </p> 
 *
 * <p>
 * <b>Requirements:</b>
 * 
 * </p> 
 *
 * <p>
 * <b>Profile Definition:</b>
 * <a href="http://hl7.org/fhir/profiles/ProcessResponse">http://hl7.org/fhir/profiles/ProcessResponse</a> 
 * </p>
 *
 */
@ResourceDef(name="ProcessResponse", profile="http://hl7.org/fhir/profiles/ProcessResponse", id="processresponse")
public class ProcessResponse extends ca.uhn.fhir.model.dstu2.resource.BaseResource
    implements  IResource     {

	/**
	 * Search parameter constant for <b>identifier</b>
	 * <p>
	 * Description: <b>The business identifier of the Explanation of Benefit</b><br>
	 * Type: <b>token</b><br>
	 * Path: <b>ProcessResponse.identifier</b><br>
	 * </p>
	 */
	@SearchParamDefinition(name="identifier", path="ProcessResponse.identifier", description="The business identifier of the Explanation of Benefit", type="token"  )
	public static final String SP_IDENTIFIER = "identifier";

	/**
	 * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
	 * <p>
	 * Description: <b>The business identifier of the Explanation of Benefit</b><br>
	 * Type: <b>token</b><br>
	 * Path: <b>ProcessResponse.identifier</b><br>
	 * </p>
	 */
	public static final TokenClientParam IDENTIFIER = new TokenClientParam(SP_IDENTIFIER);

	/**
	 * Search parameter constant for <b>request</b>
	 * <p>
	 * Description: <b>The reference to the claim</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.request</b><br>
	 * </p>
	 */
	@SearchParamDefinition(name="request", path="ProcessResponse.request", description="The reference to the claim", type="reference"  )
	public static final String SP_REQUEST = "request";

	/**
	 * <b>Fluent Client</b> search parameter constant for <b>request</b>
	 * <p>
	 * Description: <b>The reference to the claim</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.request</b><br>
	 * </p>
	 */
	public static final ReferenceClientParam REQUEST = new ReferenceClientParam(SP_REQUEST);

	/**
	 * Search parameter constant for <b>organization</b>
	 * <p>
	 * Description: <b>The organization who generated this resource</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.organization</b><br>
	 * </p>
	 */
	@SearchParamDefinition(name="organization", path="ProcessResponse.organization", description="The organization who generated this resource", type="reference"  )
	public static final String SP_ORGANIZATION = "organization";

	/**
	 * <b>Fluent Client</b> search parameter constant for <b>organization</b>
	 * <p>
	 * Description: <b>The organization who generated this resource</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.organization</b><br>
	 * </p>
	 */
	public static final ReferenceClientParam ORGANIZATION = new ReferenceClientParam(SP_ORGANIZATION);

	/**
	 * Search parameter constant for <b>requestprovider</b>
	 * <p>
	 * Description: <b>The Provider who is responsible the request transaction</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.requestProvider</b><br>
	 * </p>
	 */
	@SearchParamDefinition(name="requestprovider", path="ProcessResponse.requestProvider", description="The Provider who is responsible the request transaction", type="reference" , providesMembershipIn={
 @Compartment(name="Patient") 	}
 )
	public static final String SP_REQUESTPROVIDER = "requestprovider";

	/**
	 * <b>Fluent Client</b> search parameter constant for <b>requestprovider</b>
	 * <p>
	 * Description: <b>The Provider who is responsible the request transaction</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.requestProvider</b><br>
	 * </p>
	 */
	public static final ReferenceClientParam REQUESTPROVIDER = new ReferenceClientParam(SP_REQUESTPROVIDER);

	/**
	 * Search parameter constant for <b>requestorganization</b>
	 * <p>
	 * Description: <b>The Organization who is responsible the request transaction</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.requestOrganization</b><br>
	 * </p>
	 */
	@SearchParamDefinition(name="requestorganization", path="ProcessResponse.requestOrganization", description="The Organization who is responsible the request transaction", type="reference"  )
	public static final String SP_REQUESTORGANIZATION = "requestorganization";

	/**
	 * <b>Fluent Client</b> search parameter constant for <b>requestorganization</b>
	 * <p>
	 * Description: <b>The Organization who is responsible the request transaction</b><br>
	 * Type: <b>reference</b><br>
	 * Path: <b>ProcessResponse.requestOrganization</b><br>
	 * </p>
	 */
	public static final ReferenceClientParam REQUESTORGANIZATION = new ReferenceClientParam(SP_REQUESTORGANIZATION);


	/**
	 * Constant for fluent queries to be used to add include statements. Specifies
	 * the path value of "<b>ProcessResponse:organization</b>".
	 */
	public static final Include INCLUDE_ORGANIZATION = new Include("ProcessResponse:organization");

	/**
	 * Constant for fluent queries to be used to add include statements. Specifies
	 * the path value of "<b>ProcessResponse:request</b>".
	 */
	public static final Include INCLUDE_REQUEST = new Include("ProcessResponse:request");

	/**
	 * Constant for fluent queries to be used to add include statements. Specifies
	 * the path value of "<b>ProcessResponse:requestorganization</b>".
	 */
	public static final Include INCLUDE_REQUESTORGANIZATION = new Include("ProcessResponse:requestorganization");

	/**
	 * Constant for fluent queries to be used to add include statements. Specifies
	 * the path value of "<b>ProcessResponse:requestprovider</b>".
	 */
	public static final Include INCLUDE_REQUESTPROVIDER = new Include("ProcessResponse:requestprovider");


	@Child(name="identifier", type=IdentifierDt.class, order=0, min=0, max=Child.MAX_UNLIMITED, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="The Response business identifier"
	)
	private java.util.List<IdentifierDt> myIdentifier;
	
	@Child(name="request", order=1, min=0, max=1, summary=false, modifier=false, type={
		IResource.class	})
	@Description(
		shortDefinition="",
		formalDefinition="Original request resource reference"
	)
	private ResourceReferenceDt myRequest;
	
	@Child(name="outcome", type=CodingDt.class, order=2, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="Transaction status: error, complete, held."
	)
	private CodingDt myOutcome;
	
	@Child(name="disposition", type=StringDt.class, order=3, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="A description of the status of the adjudication or processing."
	)
	private StringDt myDisposition;
	
	@Child(name="ruleset", type=CodingDt.class, order=4, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="The version of the style of resource contents. This should be mapped to the allowable profiles for this and supporting resources."
	)
	private CodingDt myRuleset;
	
	@Child(name="originalRuleset", type=CodingDt.class, order=5, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="The style (standard) and version of the original material which was converted into this resource."
	)
	private CodingDt myOriginalRuleset;
	
	@Child(name="created", type=DateTimeDt.class, order=6, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="The date when the enclosed suite of services were performed or completed"
	)
	private DateTimeDt myCreated;
	
	@Child(name="organization", order=7, min=0, max=1, summary=false, modifier=false, type={
		ca.uhn.fhir.model.dstu2.resource.Organization.class	})
	@Description(
		shortDefinition="",
		formalDefinition="The organization who produced this adjudicated response."
	)
	private ResourceReferenceDt myOrganization;
	
	@Child(name="requestProvider", order=8, min=0, max=1, summary=false, modifier=false, type={
		ca.uhn.fhir.model.dstu2.resource.Practitioner.class	})
	@Description(
		shortDefinition="",
		formalDefinition="The practitioner who is responsible for the services rendered to the patient."
	)
	private ResourceReferenceDt myRequestProvider;
	
	@Child(name="requestOrganization", order=9, min=0, max=1, summary=false, modifier=false, type={
		ca.uhn.fhir.model.dstu2.resource.Organization.class	})
	@Description(
		shortDefinition="",
		formalDefinition="The organization which is responsible for the services rendered to the patient."
	)
	private ResourceReferenceDt myRequestOrganization;
	
	@Child(name="form", type=CodingDt.class, order=10, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="The form to be used for printing the content."
	)
	private CodingDt myForm;
	
	@Child(name="notes", order=11, min=0, max=Child.MAX_UNLIMITED, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="Suite of processing note or additional requirements is the processing has been held."
	)
	private java.util.List<Notes> myNotes;
	
	@Child(name="error", type=CodingDt.class, order=12, min=0, max=Child.MAX_UNLIMITED, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="Processing errors."
	)
	private java.util.List<CodingDt> myError;
	

	@Override
	public boolean isEmpty() {
		return super.isBaseEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(  myIdentifier,  myRequest,  myOutcome,  myDisposition,  myRuleset,  myOriginalRuleset,  myCreated,  myOrganization,  myRequestProvider,  myRequestOrganization,  myForm,  myNotes,  myError);
	}
	
	@Override
	public <T extends IElement> List<T> getAllPopulatedChildElementsOfType(Class<T> theType) {
		return ca.uhn.fhir.util.ElementUtil.allPopulatedChildElements(theType, myIdentifier, myRequest, myOutcome, myDisposition, myRuleset, myOriginalRuleset, myCreated, myOrganization, myRequestProvider, myRequestOrganization, myForm, myNotes, myError);
	}

	/**
	 * Gets the value(s) for <b>identifier</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The Response business identifier
     * </p> 
	 */
	public java.util.List<IdentifierDt> getIdentifier() {  
		if (myIdentifier == null) {
			myIdentifier = new java.util.ArrayList<IdentifierDt>();
		}
		return myIdentifier;
	}

	/**
	 * Sets the value(s) for <b>identifier</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The Response business identifier
     * </p> 
	 */
	public ProcessResponse setIdentifier(java.util.List<IdentifierDt> theValue) {
		myIdentifier = theValue;
		return this;
	}
	
	

	/**
	 * Adds and returns a new value for <b>identifier</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The Response business identifier
     * </p> 
	 */
	public IdentifierDt addIdentifier() {
		IdentifierDt newType = new IdentifierDt();
		getIdentifier().add(newType);
		return newType; 
	}

	/**
	 * Adds a given new value for <b>identifier</b> ()
	 *
	 * <p>
	 * <b>Definition:</b>
	 * The Response business identifier
	 * </p>
	 * @param theValue The identifier to add (must not be <code>null</code>)
	 */
	public ProcessResponse addIdentifier(IdentifierDt theValue) {
		if (theValue == null) {
			throw new NullPointerException("theValue must not be null");
		}
		getIdentifier().add(theValue);
		return this;
	}

	/**
	 * Gets the first repetition for <b>identifier</b> (),
	 * creating it if it does not already exist.
	 *
     * <p>
     * <b>Definition:</b>
     * The Response business identifier
     * </p> 
	 */
	public IdentifierDt getIdentifierFirstRep() {
		if (getIdentifier().isEmpty()) {
			return addIdentifier();
		}
		return getIdentifier().get(0); 
	}
  
	/**
	 * Gets the value(s) for <b>request</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Original request resource reference
     * </p> 
	 */
	public ResourceReferenceDt getRequest() {  
		if (myRequest == null) {
			myRequest = new ResourceReferenceDt();
		}
		return myRequest;
	}

	/**
	 * Sets the value(s) for <b>request</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * Original request resource reference
     * </p> 
	 */
	public ProcessResponse setRequest(ResourceReferenceDt theValue) {
		myRequest = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>outcome</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Transaction status: error, complete, held.
     * </p> 
	 */
	public CodingDt getOutcome() {  
		if (myOutcome == null) {
			myOutcome = new CodingDt();
		}
		return myOutcome;
	}

	/**
	 * Sets the value(s) for <b>outcome</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * Transaction status: error, complete, held.
     * </p> 
	 */
	public ProcessResponse setOutcome(CodingDt theValue) {
		myOutcome = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>disposition</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * A description of the status of the adjudication or processing.
     * </p> 
	 */
	public StringDt getDispositionElement() {  
		if (myDisposition == null) {
			myDisposition = new StringDt();
		}
		return myDisposition;
	}

	
	/**
	 * Gets the value(s) for <b>disposition</b> ().
	 * creating it if it does
	 * not exist. This method may return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * A description of the status of the adjudication or processing.
     * </p> 
	 */
	public String getDisposition() {  
		return getDispositionElement().getValue();
	}

	/**
	 * Sets the value(s) for <b>disposition</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * A description of the status of the adjudication or processing.
     * </p> 
	 */
	public ProcessResponse setDisposition(StringDt theValue) {
		myDisposition = theValue;
		return this;
	}
	
	

 	/**
	 * Sets the value for <b>disposition</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * A description of the status of the adjudication or processing.
     * </p> 
	 */
	public ProcessResponse setDisposition( String theString) {
		myDisposition = new StringDt(theString); 
		return this; 
	}

 
	/**
	 * Gets the value(s) for <b>ruleset</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The version of the style of resource contents. This should be mapped to the allowable profiles for this and supporting resources.
     * </p> 
	 */
	public CodingDt getRuleset() {  
		if (myRuleset == null) {
			myRuleset = new CodingDt();
		}
		return myRuleset;
	}

	/**
	 * Sets the value(s) for <b>ruleset</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The version of the style of resource contents. This should be mapped to the allowable profiles for this and supporting resources.
     * </p> 
	 */
	public ProcessResponse setRuleset(CodingDt theValue) {
		myRuleset = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>originalRuleset</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The style (standard) and version of the original material which was converted into this resource.
     * </p> 
	 */
	public CodingDt getOriginalRuleset() {  
		if (myOriginalRuleset == null) {
			myOriginalRuleset = new CodingDt();
		}
		return myOriginalRuleset;
	}

	/**
	 * Sets the value(s) for <b>originalRuleset</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The style (standard) and version of the original material which was converted into this resource.
     * </p> 
	 */
	public ProcessResponse setOriginalRuleset(CodingDt theValue) {
		myOriginalRuleset = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>created</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The date when the enclosed suite of services were performed or completed
     * </p> 
	 */
	public DateTimeDt getCreatedElement() {  
		if (myCreated == null) {
			myCreated = new DateTimeDt();
		}
		return myCreated;
	}

	
	/**
	 * Gets the value(s) for <b>created</b> ().
	 * creating it if it does
	 * not exist. This method may return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The date when the enclosed suite of services were performed or completed
     * </p> 
	 */
	public Date getCreated() {  
		return getCreatedElement().getValue();
	}

	/**
	 * Sets the value(s) for <b>created</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The date when the enclosed suite of services were performed or completed
     * </p> 
	 */
	public ProcessResponse setCreated(DateTimeDt theValue) {
		myCreated = theValue;
		return this;
	}
	
	

 	/**
	 * Sets the value for <b>created</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The date when the enclosed suite of services were performed or completed
     * </p> 
	 */
	public ProcessResponse setCreated( Date theDate,  TemporalPrecisionEnum thePrecision) {
		myCreated = new DateTimeDt(theDate, thePrecision); 
		return this; 
	}

	/**
	 * Sets the value for <b>created</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The date when the enclosed suite of services were performed or completed
     * </p> 
	 */
	public ProcessResponse setCreatedWithSecondsPrecision( Date theDate) {
		myCreated = new DateTimeDt(theDate); 
		return this; 
	}

 
	/**
	 * Gets the value(s) for <b>organization</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The organization who produced this adjudicated response.
     * </p> 
	 */
	public ResourceReferenceDt getOrganization() {  
		if (myOrganization == null) {
			myOrganization = new ResourceReferenceDt();
		}
		return myOrganization;
	}

	/**
	 * Sets the value(s) for <b>organization</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The organization who produced this adjudicated response.
     * </p> 
	 */
	public ProcessResponse setOrganization(ResourceReferenceDt theValue) {
		myOrganization = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>requestProvider</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The practitioner who is responsible for the services rendered to the patient.
     * </p> 
	 */
	public ResourceReferenceDt getRequestProvider() {  
		if (myRequestProvider == null) {
			myRequestProvider = new ResourceReferenceDt();
		}
		return myRequestProvider;
	}

	/**
	 * Sets the value(s) for <b>requestProvider</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The practitioner who is responsible for the services rendered to the patient.
     * </p> 
	 */
	public ProcessResponse setRequestProvider(ResourceReferenceDt theValue) {
		myRequestProvider = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>requestOrganization</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The organization which is responsible for the services rendered to the patient.
     * </p> 
	 */
	public ResourceReferenceDt getRequestOrganization() {  
		if (myRequestOrganization == null) {
			myRequestOrganization = new ResourceReferenceDt();
		}
		return myRequestOrganization;
	}

	/**
	 * Sets the value(s) for <b>requestOrganization</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The organization which is responsible for the services rendered to the patient.
     * </p> 
	 */
	public ProcessResponse setRequestOrganization(ResourceReferenceDt theValue) {
		myRequestOrganization = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>form</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The form to be used for printing the content.
     * </p> 
	 */
	public CodingDt getForm() {  
		if (myForm == null) {
			myForm = new CodingDt();
		}
		return myForm;
	}

	/**
	 * Sets the value(s) for <b>form</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The form to be used for printing the content.
     * </p> 
	 */
	public ProcessResponse setForm(CodingDt theValue) {
		myForm = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>notes</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Suite of processing note or additional requirements is the processing has been held.
     * </p> 
	 */
	public java.util.List<Notes> getNotes() {  
		if (myNotes == null) {
			myNotes = new java.util.ArrayList<Notes>();
		}
		return myNotes;
	}

	/**
	 * Sets the value(s) for <b>notes</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * Suite of processing note or additional requirements is the processing has been held.
     * </p> 
	 */
	public ProcessResponse setNotes(java.util.List<Notes> theValue) {
		myNotes = theValue;
		return this;
	}
	
	

	/**
	 * Adds and returns a new value for <b>notes</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * Suite of processing note or additional requirements is the processing has been held.
     * </p> 
	 */
	public Notes addNotes() {
		Notes newType = new Notes();
		getNotes().add(newType);
		return newType; 
	}

	/**
	 * Adds a given new value for <b>notes</b> ()
	 *
	 * <p>
	 * <b>Definition:</b>
	 * Suite of processing note or additional requirements is the processing has been held.
	 * </p>
	 * @param theValue The notes to add (must not be <code>null</code>)
	 */
	public ProcessResponse addNotes(Notes theValue) {
		if (theValue == null) {
			throw new NullPointerException("theValue must not be null");
		}
		getNotes().add(theValue);
		return this;
	}

	/**
	 * Gets the first repetition for <b>notes</b> (),
	 * creating it if it does not already exist.
	 *
     * <p>
     * <b>Definition:</b>
     * Suite of processing note or additional requirements is the processing has been held.
     * </p> 
	 */
	public Notes getNotesFirstRep() {
		if (getNotes().isEmpty()) {
			return addNotes();
		}
		return getNotes().get(0); 
	}
  
	/**
	 * Gets the value(s) for <b>error</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * Processing errors.
     * </p> 
	 */
	public java.util.List<CodingDt> getError() {  
		if (myError == null) {
			myError = new java.util.ArrayList<CodingDt>();
		}
		return myError;
	}

	/**
	 * Sets the value(s) for <b>error</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * Processing errors.
     * </p> 
	 */
	public ProcessResponse setError(java.util.List<CodingDt> theValue) {
		myError = theValue;
		return this;
	}
	
	

	/**
	 * Adds and returns a new value for <b>error</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * Processing errors.
     * </p> 
	 */
	public CodingDt addError() {
		CodingDt newType = new CodingDt();
		getError().add(newType);
		return newType; 
	}

	/**
	 * Adds a given new value for <b>error</b> ()
	 *
	 * <p>
	 * <b>Definition:</b>
	 * Processing errors.
	 * </p>
	 * @param theValue The error to add (must not be <code>null</code>)
	 */
	public ProcessResponse addError(CodingDt theValue) {
		if (theValue == null) {
			throw new NullPointerException("theValue must not be null");
		}
		getError().add(theValue);
		return this;
	}

	/**
	 * Gets the first repetition for <b>error</b> (),
	 * creating it if it does not already exist.
	 *
     * <p>
     * <b>Definition:</b>
     * Processing errors.
     * </p> 
	 */
	public CodingDt getErrorFirstRep() {
		if (getError().isEmpty()) {
			return addError();
		}
		return getError().get(0); 
	}
  
	/**
	 * Block class for child element: <b>ProcessResponse.notes</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * Suite of processing note or additional requirements is the processing has been held.
     * </p> 
	 */
	@Block()	
	public static class Notes 
	    extends  BaseIdentifiableElement 	    implements IResourceBlock {
	
	@Child(name="type", type=CodingDt.class, order=0, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="The note purpose: Print/Display."
	)
	@ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/note-type")
	private CodingDt myType;
	
	@Child(name="text", type=StringDt.class, order=1, min=0, max=1, summary=false, modifier=false)	
	@Description(
		shortDefinition="",
		formalDefinition="The note text."
	)
	private StringDt myText;
	

	@Override
	public boolean isEmpty() {
		return super.isBaseEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(  myType,  myText);
	}
	
	@Override
	public <T extends IElement> List<T> getAllPopulatedChildElementsOfType(Class<T> theType) {
		return ca.uhn.fhir.util.ElementUtil.allPopulatedChildElements(theType, myType, myText);
	}

	/**
	 * Gets the value(s) for <b>type</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The note purpose: Print/Display.
     * </p> 
	 */
	public CodingDt getType() {  
		if (myType == null) {
			myType = new CodingDt();
		}
		return myType;
	}

	/**
	 * Sets the value(s) for <b>type</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The note purpose: Print/Display.
     * </p> 
	 */
	public Notes setType(CodingDt theValue) {
		myType = theValue;
		return this;
	}
	
	

  
	/**
	 * Gets the value(s) for <b>text</b> ().
	 * creating it if it does
	 * not exist. Will not return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The note text.
     * </p> 
	 */
	public StringDt getTextElement() {  
		if (myText == null) {
			myText = new StringDt();
		}
		return myText;
	}

	
	/**
	 * Gets the value(s) for <b>text</b> ().
	 * creating it if it does
	 * not exist. This method may return <code>null</code>.
	 *
     * <p>
     * <b>Definition:</b>
     * The note text.
     * </p> 
	 */
	public String getText() {  
		return getTextElement().getValue();
	}

	/**
	 * Sets the value(s) for <b>text</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The note text.
     * </p> 
	 */
	public Notes setText(StringDt theValue) {
		myText = theValue;
		return this;
	}
	
	

 	/**
	 * Sets the value for <b>text</b> ()
	 *
     * <p>
     * <b>Definition:</b>
     * The note text.
     * </p> 
	 */
	public Notes setText( String theString) {
		myText = new StringDt(theString); 
		return this; 
	}

 


	}




    @Override
    public String getResourceName() {
        return "ProcessResponse";
    }
    
    public ca.uhn.fhir.context.FhirVersionEnum getStructureFhirVersionEnum() {
    	return ca.uhn.fhir.context.FhirVersionEnum.DSTU2;
    }


}
