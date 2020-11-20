package sarjan.jpa.dataModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sarjan.jpa.dataModel.model.App;
import sarjan.jpa.dataModel.data.SuperRepository;
import sarjan.jpa.dataModel.service.MyService;

/**
 * @author Sarjan Kabir
 */
@RequestMapping(value = "/apps")
@RestController
public class MyController {
    private SuperRepository superRepository;

    @Autowired
    private MyService myService;

    //you should generally favour constructor/setter injection over field injection
    @Autowired
    public MyController(SuperRepository superRepository){
        this.superRepository = superRepository;
    }

    //very bad practise - using GET method to insert something to DB
    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public ResponseEntity populate(){
        System.out.println("Here");
        myService.populate();
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/apps", method =  RequestMethod.GET)
    public  ResponseEntity<App> getHeroes(){
        return new ResponseEntity(myService.getApps(),HttpStatus.OK);
    }
    @PostMapping(path="/apply/",consumes = "application/json", produces="application/json")
    @ResponseBody
    public ResponseEntity<App> registerStudent(@RequestBody App applicant) {

        App registeredStudent = myService.apply(applicant);
        return ResponseEntity.ok().body(registeredStudent);
    }

//    @PostMapping(value = "/heroes")
//    public  ResponseEntity<App> getHeroes2(){
//        return new ResponseEntity(superRepository.getHeroes(),HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<App> getHeroById(@PathVariable("id") long id) {
//        System.out.println(id);
//        return new ResponseEntity(superRepository.getHeroByID(id),HttpStatus.OK);
//    }
//    @RequestMapping(value = "/fight", method = RequestMethod.POST)
//    public ResponseEntity<App> getWinner(@RequestParam("heroId1")
//                                                                    long heroId1, @RequestParam("heroId2") long heroId2){
//        System.out.println(heroId1 +heroId2);
//        return new ResponseEntity(fight(heroId1,heroId2),HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ResponseEntity<App> getHeroByName(@RequestParam("name")String name, @RequestParam("orderBy") String orderBy){
//
//        return new ResponseEntity(superRepository.getHeroByName(name,orderBy),HttpStatus.OK);
//    }
//
//
//
//    public App fight(Long heroId1, Long heroId2){
//        App app1 = superRepository.getHeroByID(heroId1);
//        App app2 = superRepository.getHeroByID(heroId2);
//
//        if(app1.getStrength()> app2.getStrength()){
//            superRepository.delete(app2);
//            return app1;
//        }
//        else if(app2.getStrength()> app1.getStrength()) {
//            superRepository.delete(app1);
//            return app2;
//        }
//        else {
//            superRepository.delete(app1);
//            superRepository.delete(app2);
//            return null;
//        }
//
//    }

}
