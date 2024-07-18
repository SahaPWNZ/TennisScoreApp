import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.TestDataImporter;

public class testDataBaseRunner {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @BeforeAll
    public static void initDB(){
        TestDataImporter.importData(sessionFactory);
    }
    @AfterAll
    public static void finish(){
        sessionFactory.close();
    }
    @Test
    public void testConnectionDB() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            System.out.println(session.get(Player.class, 1));
            System.out.println(session.get(Match.class, 1));
            session.getTransaction().commit();
        }
    }
}
