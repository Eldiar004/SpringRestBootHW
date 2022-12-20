package com.example.springrestboothw.api;

import com.example.springrestboothw.dto.requests.GroupRequest;
import com.example.springrestboothw.dto.responses.GroupResponse;
import com.example.springrestboothw.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {
    
    private final GroupService groupService;

    @GetMapping("/groups")
    public List<GroupResponse> getAllGroup(){
        return groupService.getAllGroup();
    }

    @PostMapping("/saveGroup/{courseId}")
    public GroupResponse saveGroupByCourseId(@PathVariable("courseId")Long id, @RequestBody GroupRequest groupRequest){
        return groupService.saveGroup(id,groupRequest);
    }

    @PutMapping("/updateGroup/{groupId}")
    public GroupResponse updateGroup(@PathVariable Long groupId,@RequestBody GroupRequest groupRequest){
        return groupService.updateGroup(groupId,groupRequest);
    }

    @DeleteMapping("/deleteGroup/{groupId}")
    public String deleteGroup(@PathVariable Long groupId){
        groupService.deleteGroupById(groupId);
        return "Group successfully deleted!";
    }
    
    @GetMapping("/getById/{groupId}")
    public GroupResponse getById(@PathVariable Long groupId){
        return groupService.getById(groupId);
    }

    @PutMapping("{groupId}/assignGroup/{courseId}")
    public String assignGroup(@PathVariable Long groupId,@PathVariable Long courseId) {
        groupService.assignGroup(courseId,groupId);
        return "Group successfully assigned!";
    }
}
