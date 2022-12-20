package com.example.springrestboothw.api;

import com.example.springrestboothw.dto.requests.CompanyRequest;
import com.example.springrestboothw.dto.responses.CompanyResponse;
import com.example.springrestboothw.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/companies")
    public List<CompanyResponse>getAllCompany(){
        return companyService.getAllCompanies();
    }

    @PostMapping("/saveCompany")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest){
        return companyService.saveCompany(companyRequest);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable("id")Long id){
        companyService.deleteById(id);
        return "Company with id:" + id +" successfully deleted!!";
    }

    @PutMapping("/updateCompany/{id}")
    public String updateCompany(@PathVariable("id")Long id,@RequestBody CompanyRequest companyRequest){
        companyService.update(id,companyRequest);
        return "Company with id:" + id +" successfully updated!!";
    }

    @GetMapping("/getCompanyById/{companyId}")
    public CompanyResponse getById(@PathVariable("companyId")Long id){
        return companyService.getById(id);
    }
}
