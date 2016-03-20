package edu.gatech.i3l.fhir.jpa.providers;

/**
 * Mark Benjamin 02/03/16.
 */
import java.util.*;

// import org.apache.commons.lang3.StringUtils;

// import ca.uhn.fhir.jpa.provider.JpaResourceProviderDstu2;
import edu.gatech.i3l.fhir.jpa.dao.SearchParameterMap;
// import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.model.api.annotation.*;
// import ca.uhn.fhir.model.dstu2.composite.*;
import ca.uhn.fhir.model.dstu2.resource.*; //
import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.param.*;
import ca.uhn.fhir.rest.api.SortSpec;
// import ca.uhn.fhir.model.dstu.resource.Binary;
// import ca.uhn.fhir.model.dstu2.resource.Bundle;
// import ca.uhn.fhir.model.api.Bundle;

public class ImmunizationRecommendationResourceProvider extends
        JpaResourceProviderDstu2<ImmunizationRecommendation>
{

    @Override
    public Class<ImmunizationRecommendation> getResourceType() {
        return ImmunizationRecommendation.class;
    }

    @Search()
    public ca.uhn.fhir.rest.server.IBundleProvider search(
            javax.servlet.http.HttpServletRequest theServletRequest,

            ca.uhn.fhir.rest.method.RequestDetails theRequestDetails,

            @Description(shortDefinition="The resource identity")
            @OptionalParam(name="_id")
            StringAndListParam theId,

            @Description(shortDefinition="The resource language")
            @OptionalParam(name="_language")
            StringAndListParam theResourceLanguage,

            @Description(shortDefinition="Search the contents of the resource's data using a fulltext search")
            @OptionalParam(name=ca.uhn.fhir.rest.server.Constants.PARAM_CONTENT)
            StringAndListParam theFtContent,

            @Description(shortDefinition="Search the contents of the resource's narrative using a fulltext search")
            @OptionalParam(name=ca.uhn.fhir.rest.server.Constants.PARAM_TEXT)
            StringAndListParam theFtText,

            @Description(shortDefinition="Search for resources which have the given tag")
            @OptionalParam(name=ca.uhn.fhir.rest.server.Constants.PARAM_TAG)
            TokenAndListParam theSearchForTag,

            @Description(shortDefinition="Search for resources which have the given security labels")
            @OptionalParam(name=ca.uhn.fhir.rest.server.Constants.PARAM_SECURITY)
            TokenAndListParam theSearchForSecurity,

            @Description(shortDefinition="Search for resources which have the given profile")
            @OptionalParam(name=ca.uhn.fhir.rest.server.Constants.PARAM_PROFILE)
            UriAndListParam theSearchForProfile,


            @Description(shortDefinition="")
            @OptionalParam(name="vaccine-type")
            TokenAndListParam theVaccine_type,

            @Description(shortDefinition="")
            @OptionalParam(name="identifier")
            TokenAndListParam theIdentifier,

            @Description(shortDefinition="")
            @OptionalParam(name="date")
            DateRangeParam theDate,

            @Description(shortDefinition="")
            @OptionalParam(name="dose-number")
            NumberAndListParam theDose_number,

            @Description(shortDefinition="")
            @OptionalParam(name="status")
            TokenAndListParam theStatus,

            @Description(shortDefinition="")
            @OptionalParam(name="dose-sequence")
            NumberAndListParam theDose_sequence,

            @Description(shortDefinition="")
            @OptionalParam(name="support", targetTypes={  Immunization.class   } )
            ReferenceAndListParam theSupport,

            @Description(shortDefinition="")
            @OptionalParam(name="information", targetTypes={  Observation.class ,   AllergyIntolerance.class   } )
            ReferenceAndListParam theInformation,

            @Description(shortDefinition="")
            @OptionalParam(name="patient", targetTypes={  Patient.class   } )
            ReferenceAndListParam thePatient,

            @IncludeParam(reverse=true)
            Set<Include> theRevIncludes,
            @Description(shortDefinition="Only return resources which were last updated as specified by the given range")
            @OptionalParam(name="_lastUpdated")
            DateRangeParam theLastUpdated,

            @IncludeParam(allow= {
                    "ImmunizationRecommendation:information" , 					"ImmunizationRecommendation:patient" , 					"ImmunizationRecommendation:support" , 						"ImmunizationRecommendation:information" , 					"ImmunizationRecommendation:patient" , 					"ImmunizationRecommendation:support" , 						"ImmunizationRecommendation:information" , 					"ImmunizationRecommendation:patient" , 					"ImmunizationRecommendation:support" 					, "*"
            })
            Set<Include> theIncludes,

            @Sort
            SortSpec theSort,

            @ca.uhn.fhir.rest.annotation.Count
            Integer theCount
    ) {
        startRequest(theServletRequest);
        try {
            SearchParameterMap paramMap = new SearchParameterMap();
            paramMap.add("_id", theId);
            paramMap.add("_language", theResourceLanguage);
            paramMap.add(ca.uhn.fhir.rest.server.Constants.PARAM_CONTENT, theFtContent);
            paramMap.add(ca.uhn.fhir.rest.server.Constants.PARAM_TEXT, theFtText);
            paramMap.add(ca.uhn.fhir.rest.server.Constants.PARAM_TAG, theSearchForTag);
            paramMap.add(ca.uhn.fhir.rest.server.Constants.PARAM_SECURITY, theSearchForSecurity);
            paramMap.add(ca.uhn.fhir.rest.server.Constants.PARAM_PROFILE, theSearchForProfile);
            paramMap.add("vaccine-type", theVaccine_type);
            paramMap.add("identifier", theIdentifier);
            paramMap.add("date", theDate);
            paramMap.add("dose-number", theDose_number);
            paramMap.add("status", theStatus);
            paramMap.add("dose-sequence", theDose_sequence);
            paramMap.add("support", theSupport);
            paramMap.add("information", theInformation);
            paramMap.add("patient", thePatient);
            paramMap.setRevIncludes(theRevIncludes);
            paramMap.setLastUpdated(theLastUpdated);
            paramMap.setIncludes(theIncludes);
            paramMap.setSort(theSort);
            paramMap.setCount(theCount);
            // paramMap.setRequestDetails(theRequestDetails);

            ca.uhn.fhir.rest.server.IBundleProvider retVal = getDao().search(paramMap);
            return retVal;
        } finally {
            endRequest(theServletRequest);
        }
    }

}
