package com.example.springrestboothw.service.serviceImpl;
import com.example.springrestboothw.converter.requestConverter.CompanyRequestConverter;
import com.example.springrestboothw.converter.responseConverter.CompanyResponseConverter;
import com.example.springrestboothw.dto.requests.CompanyRequest;
import com.example.springrestboothw.dto.responses.CompanyResponse;
import com.example.springrestboothw.entities.Company;
import com.example.springrestboothw.repository.CompanyRepository;
import com.example.springrestboothw.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    private final CompanyRequestConverter companyRequestConverter;
    private final CompanyResponseConverter companyResponseConverter;

    public CompanyResponse saveCompany(CompanyRequest companyRequest){
        Company company = companyRequestConverter.convertRequestToCompany(companyRequest);
        repository.save(company);
        return companyResponseConverter.viewCompanyResponse(company);
    }

    public List<CompanyResponse>getAllCompanies(){
        List<Company> companies = repository.findAll();
        List<CompanyResponse> companyResponses = companyResponseConverter.viewAllCompany(companies);
        return companyResponses;
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public CompanyResponse getById(Long id){
        Company company = repository.findById(id).get();
        return companyResponseConverter.viewCompanyResponse(company);
    }

    public CompanyResponse update(Long id,CompanyRequest companyRequest){
        Company company = repository.findById(id).get();
        companyRequestConverter.update(company,companyRequest);
        repository.save(company);
        return companyResponseConverter.viewCompanyResponse(company);
    }
}
