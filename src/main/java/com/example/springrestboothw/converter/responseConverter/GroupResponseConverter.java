package com.example.springrestboothw.converter.responseConverter;

import com.example.springrestboothw.dto.requests.GroupRequest;
import com.example.springrestboothw.dto.responses.GroupResponse;
import com.example.springrestboothw.entities.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GroupResponseConverter {

    public GroupResponse viewResponse(Group group){
        if (group == null) {
            return null;
        }
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setImage(group.getImage());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setId(group.getId());
        return groupResponse;
    }
    public List<GroupResponse> viewAllGroupResponse(List<Group>groups){
        List<GroupResponse> groupResponses = new ArrayList<>();
        for (Group group:groups) {
            groupResponses.add(viewResponse(group));
        }
        return groupResponses;
    }
}
