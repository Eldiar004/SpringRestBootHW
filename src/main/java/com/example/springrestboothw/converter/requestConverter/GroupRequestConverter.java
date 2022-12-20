package com.example.springrestboothw.converter.requestConverter;

import com.example.springrestboothw.dto.requests.GroupRequest;
import com.example.springrestboothw.entities.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupRequestConverter {

    public Group convertRequestToGroup(GroupRequest groupRequest){
        if (groupRequest == null) {
            return null;
        }
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setImage(groupRequest.getImage());
        group.setDateOfStart(groupRequest.getDateOfStart());
        return group;
    }
    public void updateGroup(Group group,GroupRequest groupRequest){
        group.setGroupName(groupRequest.getGroupName());
        group.setImage(groupRequest.getImage());
        group.setDateOfStart(groupRequest.getDateOfStart());
    }
}
