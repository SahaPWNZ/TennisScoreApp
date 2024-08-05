import com.sahapwnz.tennisscoreapp.dao.MatchDAO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.TestDataImporter;


import java.util.List;

public class testDataBaseRunner {
    private static final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Player.class)
            .addAnnotatedClass(Match.class)
            .configure("hibernate-test.cfg.xml")
            .buildSessionFactory();
//    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @BeforeAll
    public static void initDB() {
        TestDataImporter.importData(sessionFactory);
    }

    @AfterAll
    public static void finish() {
        sessionFactory.close();
    }

    @Test
    public void testConnectionDB() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            System.out.println(session.get(Player.class, 1));
            System.out.println(session.get(Match.class, 1));
//            List<Match> matches2 = session.createQuery("select m from Match m", Match.class).list();
//            List<Match> matches = session.createQuery("from Match", Match.class).list();
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Match> criteriaQuery = cb.createQuery(Match.class);
//            Root<Match> root = criteriaQuery.from(Match.class);
//            criteriaQuery.select(root);
//            List<Match> result = session.createQuery(criteriaQuery).getResultList();

//            for (Match match : matches2) {
//                System.out.println("Match ID: " + match.getId());
//                System.out.println("Player1: " + match.getPlayer1());
//                System.out.println("Player1: " + match.getPlayer2());
//                System.out.println("-----------------------");
//            }
//            session.getTransaction().commit();
        }

    }

    @Test
    public void testDao() {
        var matchDAO = new MatchDAO(sessionFactory);
        for (Match match : matchDAO.findAll()) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Player1: " + match.getPlayer1());
            System.out.println("Player2: " + match.getPlayer2());
            System.out.println("-----------------------");
        }
        System.out.println(matchDAO.findById(1L));
//        matchDAO.delete(1l);
        System.out.println("после удаления матча с айди = 1" + matchDAO.findById(1l));
    }
    @Test
    public void testRemoveDAO(){
        var matchDAO = new MatchDAO(sessionFactory);
        matchDAO.delete(1L);
        System.out.println("после удаления матча с айди = 1" + matchDAO.findById(1l));
    }
}
