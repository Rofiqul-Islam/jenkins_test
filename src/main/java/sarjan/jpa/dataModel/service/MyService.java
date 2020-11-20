package sarjan.jpa.dataModel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sarjan.jpa.dataModel.data.SuperRepository;
import sarjan.jpa.dataModel.model.App;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Sarjan Kabir
 */

@Service
@Transactional
public class MyService {

    @Autowired
    private SuperRepository superRepository;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Populates the database
     */
    public void populate(){
//Good heroes
        App app1 = new App();
        app1.setName("Sarah");
        app1.setAge(50);
        app1.setEmail("sarah@gmail.com");
        app1.setGender("Female");
        app1.setPassword("hello123");
        app1.setStatus(app1.getPendingStatus());


        entityManager.persist(app1);


    }
        public List<App> getApps(){
        return superRepository.findAll();

    }
    public List<App> getAcceptedApps(){
        return superRepository.findByStatus(App.Status.ACCEPTED);
    }

    public App apply(App applicant){
        System.out.println("accepted: " + getAcceptedApps());
        if(getAcceptedApps().size()<200){
            App validatedApp= validateStatus(applicant);
            App noteForApp = setNoteForInvited(validatedApp);
            System.out.println(noteForApp);
            return  superRepository.save(noteForApp);

        }

            applicant.setStatus(applicant.getPendingStatus());
            return superRepository.save((applicant));

    }

    public App validateStatus(App app){
        if (app.getPassword().length()>9){
            System.out.println("Password must be more than 9 characters.");
            app.setStatus(app.getAcceptedStatus());
        }
        if (app.getGender().equals("Female")){
            if (app.getAge()>57){
                System.out.println(app.getGender());
                System.out.println("Female applicant's age must be less than 57");
                app.setStatus(app.getDeclinedStatus());
            }
            app.setStatus(app.getInvitedStatus());


        }
        if(app.getGender().equals("Male")){
            if (app.getAge()>54){
                System.out.println("Male applicant's age must be less than 55");
                app.setStatus(app.getDeclinedStatus());
            }
        }


        return app;
    }

    public App setNoteForInvited(App app){
        if(app.getStatus()==app.getInvitedStatus()){
            app.setNote("Special Note: You have been invited for an interview. Here are the details: BlaBla...");
        }
        return app;
    }
}
