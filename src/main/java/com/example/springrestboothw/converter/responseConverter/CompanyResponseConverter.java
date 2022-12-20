package com.example.springrestboothw.converter.responseConverter;
import com.example.springrestboothw.dto.responses.CompanyResponse;
import com.example.springrestboothw.entities.Company;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class CompanyResponseConverter {

    public CompanyResponse viewCompanyResponse(Company company){
        if (company == null){
            return null;
        }
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setId(company.getId());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        return companyResponse;
    }
    public List<CompanyResponse> viewAllCompany(List<Company> companies){
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company company:companies) {
            responses.add(viewCompanyResponse(company));
        }
        return responses;
    }
}
