package com.example.springrestboothw.service;
import com.example.springrestboothw.converter.requestConverter.GroupRequestConverter;
import com.example.springrestboothw.dto.requests.GroupRequest;
import com.example.springrestboothw.dto.responses.GroupResponse;
import com.example.springrestboothw.entities.Group;
import java.util.List;

public interface GroupService {
//    public List<Group> getAllGroupByCourseId(Long courseId);
    GroupResponse saveGroup(Long courseId, GroupRequest groupRequest);
    void deleteGroupById(Long id);
    List<GroupResponse> getAllGroup();
    void assignGroup(Long courseId,Long groupId);
    GroupResponse getById(Long id);
    GroupResponse updateGroup(Long id, GroupRequest groupRequest);
}
