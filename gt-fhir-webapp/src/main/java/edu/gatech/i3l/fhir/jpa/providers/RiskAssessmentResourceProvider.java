package edu.gatech.i3l.fhir.jpa.providers;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

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

public class RiskAssessmentResourceProvider extends
        JpaResourceProviderDstu2<RiskAssessment>
{

    @Override
    public Class<RiskAssessment> getResourceType() {
        return RiskAssessment.class;
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
            @OptionalParam(name="identifier")
            TokenAndListParam theIdentifier,

            @Description(shortDefinition="")
            @OptionalParam(name="date")
            DateRangeParam theDate,

            @Description(shortDefinition="")
            @OptionalParam(name="encounter", targetTypes={  Encounter.class   } )
            ReferenceAndListParam theEncounter,

            @Description(shortDefinition="")
            @OptionalParam(name="performer", targetTypes={  Practitioner.class ,   Device.class   } )
            ReferenceAndListParam thePerformer,

            @Description(shortDefinition="")
            @OptionalParam(name="subject", targetTypes={  Patient.class ,   Group.class   } )
            ReferenceAndListParam theSubject,

            @Description(shortDefinition="")
            @OptionalParam(name="condition", targetTypes={  Condition.class   } )
            ReferenceAndListParam theCondition,

            @Description(shortDefinition="")
            @OptionalParam(name="method")
            TokenAndListParam theMethod,

            @Description(shortDefinition="")
            @OptionalParam(name="patient", targetTypes={  Patient.class ,   Group.class   } )
            ReferenceAndListParam thePatient,

            @IncludeParam(reverse=true)
            Set<Include> theRevIncludes,
            @Description(shortDefinition="Only return resources which were last updated as specified by the given range")
            @OptionalParam(name="_lastUpdated")
            DateRangeParam theLastUpdated,

            @IncludeParam(allow= {
                    "RiskAssessment:condition" , 					"RiskAssessment:encounter" , 					"RiskAssessment:patient" , 					"RiskAssessment:performer" , 					"RiskAssessment:subject" , 						"RiskAssessment:condition" , 					"RiskAssessment:encounter" , 					"RiskAssessment:patient" , 					"RiskAssessment:performer" , 					"RiskAssessment:subject" , 						"RiskAssessment:condition" , 					"RiskAssessment:encounter" , 					"RiskAssessment:patient" , 					"RiskAssessment:performer" , 					"RiskAssessment:subject" , 						"RiskAssessment:condition" , 					"RiskAssessment:encounter" , 					"RiskAssessment:patient" , 					"RiskAssessment:performer" , 					"RiskAssessment:subject" , 						"RiskAssessment:condition" , 					"RiskAssessment:encounter" , 					"RiskAssessment:patient" , 					"RiskAssessment:performer" , 					"RiskAssessment:subject" 					, "*"
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
            paramMap.add("identifier", theIdentifier);
            paramMap.add("date", theDate);
            paramMap.add("encounter", theEncounter);
            paramMap.add("performer", thePerformer);
            paramMap.add("subject", theSubject);
            paramMap.add("condition", theCondition);
            paramMap.add("method", theMethod);
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