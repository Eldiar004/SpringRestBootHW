package com.example.springrestboothw.service.serviceImpl;

import com.example.springrestboothw.converter.requestConverter.GroupRequestConverter;
import com.example.springrestboothw.converter.responseConverter.GroupResponseConverter;
import com.example.springrestboothw.dto.requests.GroupRequest;
import com.example.springrestboothw.dto.responses.GroupResponse;
import com.example.springrestboothw.entities.Course;
import com.example.springrestboothw.entities.Group;
import com.example.springrestboothw.repository.CourseRepository;
import com.example.springrestboothw.repository.GroupRepository;
import com.example.springrestboothw.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final CourseRepository courseRepository;
    private final GroupRequestConverter groupRequestConverter;
    private final GroupResponseConverter groupResponseConverter;

    public GroupResponse saveGroup(Long courseId, GroupRequest groupRequest){
        Course course = courseRepository.findById(courseId).get();
        Group group = groupRequestConverter.convertRequestToGroup(groupRequest);
        repository.save(group);
        return groupResponseConverter.viewResponse(group);
    }

    public void deleteGroupById(Long id){
        repository.deleteById(id);
    }

    public List<GroupResponse> getAllGroup(){
        List<Group> groups = repository.findAll();
        return groupResponseConverter.viewAllGroupResponse(groups);
    }

//    public List<Group> getAllGroupByCourseId(Long courseId){
//        Course course = courseRepository.findById(courseId).get();
//        List<Group> groups= course.getGroups();
//        return groups;
//    }

    public void assignGroup(Long courseId,Long groupId){
        Course course = courseRepository.findById(courseId).get();
        Group group = repository.findById(groupId).get();
        group.addCourse(course);
        course.addGroup(group);
        repository.save(group);
    }

    @Override
    public GroupResponse getById(Long id) {
        Group group = repository.findById(id).get();
        return groupResponseConverter.viewResponse(group);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = repository.findById(id).get();
        groupRequestConverter.updateGroup(group,groupRequest);
        repository.save(group);
        return groupResponseConverter.viewResponse(group);
    }
}