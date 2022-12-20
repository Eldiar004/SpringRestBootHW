package com.example.springrestboothw.converter.requestConverter;
import com.example.springrestboothw.dto.requests.CompanyRequest;
import com.example.springrestboothw.entities.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyRequestConverter {

    public Company convertRequestToCompany(CompanyRequest companyRequest){
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }
    public void update(Company company,CompanyRequest companyRequest){
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }
}
