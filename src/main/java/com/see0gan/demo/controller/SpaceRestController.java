//package com.see0gan.demo.controller;
//
//import com.see0gan.space.dto.SpaceAd;
//import com.see0gan.space.entity.Space;
//import com.see0gan.space.repository.HostRepository;
//import com.see0gan.space.repository.SpaceCustomTagRepository;
//import com.see0gan.space.service.SpaceService;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "api/v1/spaces")
//public class SpaceRestController {
//
//    private final SpaceService spaceService;
//    private final HostRepository hostRepository;
//    private final SpaceCustomTagRepository spaceCustomTagRepository;
//
//    public SpaceRestController(SpaceService spaceService, HostRepository hostRepository, SpaceCustomTagRepository spaceCustomTagRepository) {
//        this.spaceService = spaceService;
//        this.hostRepository = hostRepository;
//        this.spaceCustomTagRepository = spaceCustomTagRepository;
//    }
//
//    @GetMapping(path="/ads")
//    public List<SpaceAd> getSpaceAds(){
//
//        return spaceService.getSpaceAds();
//
//    }
//
//
//    @GetMapping
//    public List<Space> getSpace(@RequestParam(required = false) String type){
//
//        if(type==null)
//            return spaceService.getSpaces();
//
//      return spaceService.findSpaceByType(type);
//
//    }
//
//    @GetMapping(path = "{space_id}")
//    public Space getSpace(@PathVariable("space_id") Long spaceId){
//
//       Space space = spaceService.getSpaceById(spaceId);
//
//        return space;
//    }
//
//    //@PreAuthorize("hasRole('ROLE_HOST')")
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addNewSpace(@RequestBody Space space) {
//
//        System.out.println("spaceDto = " + space);
//
//        spaceService.addNewSpace(space);
//
//    }
//
//    //@PreAuthorize("hasRole('ROLE_HOST')")
//    @DeleteMapping(path = "{space_id}")
//
//    public void deleteSpaceById(@PathVariable("space_id") Long spaceId){
//
//        spaceService.deleteSpaceById(spaceId);
//
//    }
//
//    //@PreAuthorize("hasRole('ROLE_HOST')")
//    @PutMapping(path = "{space_id}")
//    public void modifySpaceById(@PathVariable("space_id") Long spaceId,
//                                @RequestBody Space space){
//
//        spaceService.modifySpaceById(spaceId, space);
//
//    }
//
//}
