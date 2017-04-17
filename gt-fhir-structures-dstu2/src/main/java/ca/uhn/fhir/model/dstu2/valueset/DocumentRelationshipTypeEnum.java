
package ca.uhn.fhir.model.dstu2.valueset;

import ca.uhn.fhir.model.api.*;
import java.util.HashMap;
import java.util.Map;

public enum DocumentRelationshipTypeEnum {

	/**
	 * Display: <b>Replaces</b><br>
	 * Code Value: <b>replaces</b>
	 *
	 * This document logically replaces or supersedes the target document.
	 */
	REPLACES("replaces", "http://hl7.org/fhir/document-relationship-type"),
	
	/**
	 * Display: <b>Transforms</b><br>
	 * Code Value: <b>transforms</b>
	 *
	 * This document was generated by transforming the target document (e.g. format or language conversion).
	 */
	TRANSFORMS("transforms", "http://hl7.org/fhir/document-relationship-type"),
	
	/**
	 * Display: <b>Signs</b><br>
	 * Code Value: <b>signs</b>
	 *
	 * This document is a signature of the target document.
	 */
	SIGNS("signs", "http://hl7.org/fhir/document-relationship-type"),
	
	/**
	 * Display: <b>Appends</b><br>
	 * Code Value: <b>appends</b>
	 *
	 * This document adds additional information to the target document.
	 */
	APPENDS("appends", "http://hl7.org/fhir/document-relationship-type"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * 
	 */
	public static final String VALUESET_IDENTIFIER = "";

	/**
	 * Name for this Value Set:
	 * DocumentRelationshipType
	 */
	public static final String VALUESET_NAME = "DocumentRelationshipType";

	private static Map<String, DocumentRelationshipTypeEnum> CODE_TO_ENUM = new HashMap<String, DocumentRelationshipTypeEnum>();
	private static Map<String, Map<String, DocumentRelationshipTypeEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, DocumentRelationshipTypeEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (DocumentRelationshipTypeEnum next : DocumentRelationshipTypeEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, DocumentRelationshipTypeEnum>());
			}
			SYSTEM_TO_CODE_TO_ENUM.get(next.getSystem()).put(next.getCode(), next);			
		}
	}
	
	/**
	 * Returns the code associated with this enumerated value
	 */
	public String getCode() {
		return myCode;
	}
	
	/**
	 * Returns the code system associated with this enumerated value
	 */
	public String getSystem() {
		return mySystem;
	}
	
	/**
	 * Returns the enumerated value associated with this code
	 */
	public static DocumentRelationshipTypeEnum forCode(String theCode) {
		DocumentRelationshipTypeEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<DocumentRelationshipTypeEnum> VALUESET_BINDER = new IValueSetEnumBinder<DocumentRelationshipTypeEnum>() {
		@Override
		public String toCodeString(DocumentRelationshipTypeEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(DocumentRelationshipTypeEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public DocumentRelationshipTypeEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public DocumentRelationshipTypeEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, DocumentRelationshipTypeEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	DocumentRelationshipTypeEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
