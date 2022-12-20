package com.example.springrestboothw.service;
import com.example.springrestboothw.dto.requests.CompanyRequest;
import com.example.springrestboothw.dto.responses.CompanyResponse;
import com.example.springrestboothw.entities.Company;
import java.util.List;

public interface CompanyService {

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    List<CompanyResponse> getAllCompanies();

    void deleteById(Long id);

    CompanyResponse getById(Long id);

    CompanyResponse update(Long id,CompanyRequest companyRequest);
}
