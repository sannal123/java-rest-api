package com.codesick.restApiDemo.controller;

import com.codesick.restApiDemo.entity.restApiEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restapi")
public class restApiDemoController {
    private Map<Long, restApiEntity> restEntries =  new HashMap<>();

    @GetMapping
    public List<restApiEntity> getAll(){
        return new ArrayList<>(restEntries.values());
    }
    @PostMapping
    public boolean createEnties(@RequestBody restApiEntity myEntrie){
        restEntries.put(myEntrie.getId(), myEntrie);
        return true;
    }
    @GetMapping("id/{myId}")
    public restApiEntity getEntriesByID (@PathVariable Long myId){
        return restEntries.get(myId);
    }
    @DeleteMapping("/id/{myId}")
    public restApiEntity getEntriesById(@PathVariable Long myId){
        return restEntries.remove(myId);
    }
    @PutMapping("/id/{id}")
    public restApiEntity getEntriesById(@PathVariable Long id,@RequestBody restApiEntity myEntrie){
        return restEntries.put(id, myEntrie);
    }
}
