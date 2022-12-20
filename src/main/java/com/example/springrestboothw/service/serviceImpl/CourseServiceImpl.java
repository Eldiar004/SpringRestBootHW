package com.example.springrestboothw.service.serviceImpl;
import com.example.springrestboothw.converter.requestConverter.CourseRequestConverter;
import com.example.springrestboothw.converter.responseConverter.CourseResponseConverter;
import com.example.springrestboothw.dto.requests.CourseRequest;
import com.example.springrestboothw.dto.responses.CourseResponse;
import com.example.springrestboothw.entities.Company;
import com.example.springrestboothw.entities.Course;
import com.example.springrestboothw.repository.CompanyRepository;
import com.example.springrestboothw.repository.CourseRepository;
import com.example.springrestboothw.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CompanyRepository companyRepository;
    private final CourseRequestConverter courseRequestConverter;
    private final CourseResponseConverter courseResponseConverter;


    public CourseResponse saveCourseByCompanyId(Long companyId, CourseRequest courseRequest){
        Company company = companyRepository.findById(companyId).get();
        Course course = courseRequestConverter.convertRequestToCourse(courseRequest);
        course.setCompany(company);
        company.addCourse(course);
        repository.save(course);
        return courseResponseConverter.viewResponse(course);
    }
    public void deleteCourseById(Long id){
        repository.deleteById(id);
    }

    public List<CourseResponse> getAllCourses(){
        List<Course> courses = repository.findAll();
        return courseResponseConverter.viewAllCourseResponses(courses);
    }

    public CourseResponse updateCourse(Long courseId, CourseRequest courseRequest){
        Course course = repository.findById(courseId).get();
        courseRequestConverter.update(course,courseRequest);
        repository.save(course);
        return courseResponseConverter.viewResponse(course);
    }

    public List<Course> getAllCourseByCompanyId(Long id){
        return repository.getALLCoursesByCompanyId(id);
    }

    @Override
    public CourseResponse getById(Long id) {
        Course course = repository.findById(id).get();
        return courseResponseConverter.viewResponse(course);
    }
}

