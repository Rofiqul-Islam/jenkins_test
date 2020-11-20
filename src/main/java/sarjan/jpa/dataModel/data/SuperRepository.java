package sarjan.jpa.dataModel.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sarjan.jpa.dataModel.model.App;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Sarjan Kabir
 */
@Repository

public interface SuperRepository extends JpaRepository<App,Long> {
//    @PersistenceContext
//    private EntityManager entityManager;
    List<App> findAll();


    List<App> findByStatus(App.Status status);

    /**
     * Populates the database
     */
//    public void populate(){
////Good heroes
//        App app1 = new App();
//        app1.setName("Good Hero1");
//        app1.setRace("Race1");
//        app1.setStrength((float)100);
//        app1.setSide(app1.stateGood());
//
//        entityManager.persist(app1);
//        App app2 = new App();
//        app2.setName("Good Hero2");
//        app2.setRace("Race1");
//        app2.setStrength((float)200);
//        app2.setSide(app2.stateGood());
//        entityManager.persist(app2);
//
//        App app3 = new App();
//        app3.setName("Bilbo Aster");
//        app3.setRace("Race1");
//        app3.setStrength((float)20);
//        app3.setSide(app3.stateGood());
//        entityManager.persist(app3);
//
//        App app4 = new App();
//        app4.setName("Bilbo Coucher");
//        app4.setRace("Race1");
//        app4.setStrength((float)50);
//        app4.setSide(app4.stateGood());
//        entityManager.persist(app4);
//
//
//        App app5 = new App();
//        app5.setName("Good Hero5");
//        app5.setRace("Race1");
//        app5.setStrength((float)150);
//        app5.setSide(app5.stateGood());
//        entityManager.persist(app5);
//
////Bad Heroes
//        App badhero1 = new App();
//        badhero1.setName("Bad Hero1");
//        badhero1.setRace("Race2");
//        badhero1.setStrength((float)100);
//        badhero1.setSide(badhero1.stateDark());
//        entityManager.persist(badhero1);
//
//        App badhero2 = new App();
//        badhero2.setName("Bad Hero2");
//        badhero2.setRace("Race2");
//        badhero2.setStrength((float)200);
//        badhero2.setSide(badhero2.stateDark());
//        entityManager.persist(badhero2);
//
//        App badhero3 = new App();
//        badhero3.setName("Bad Hero3");
//        badhero3.setRace("Race2");
//        badhero3.setStrength((float)20);
//        badhero3.setSide(badhero3.stateDark());
//        entityManager.persist(badhero3);
//
//        App badhero4 = new App();
//        badhero4.setName("Bad Hero4");
//        badhero4.setRace("Race2");
//        badhero4.setStrength((float)50);
//        badhero4.setSide(badhero4.stateDark());
//        entityManager.persist(badhero4);
//
//
//        App badhero5 = new App();
//        badhero5.setName("Bad Hero5");
//        badhero5.setRace("Race2");
//        badhero5.setStrength((float)150);
//        badhero5.setSide(badhero5.stateDark());
//        entityManager.persist(badhero5);
//
//    }
//    public List<App> getHeroes(){
//        return entityManager.createQuery("SELECT h FROM Hero h ").getResultList();
//    }
//    public App getHeroByID(Long id){
//
//        return (App)entityManager.createNamedQuery("App.findHeroesById").setParameter("id",id).getResultList().get(0);
//    }
//    public List<App> getHeroByName(String name, String orderBy){
//
//        return entityManager.createNamedQuery("App.findHeroesByName").setParameter("name",name).getResultList();
//    }
//    public void delete(App app){
//        System.out.println(app);
//        entityManager.remove(app);
//    }


}
