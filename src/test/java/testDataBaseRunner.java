import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

public class testDataBaseRunner {
    @Test
    public void testConnectionDB() {
        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            var player = Player.builder()
                            .name("Vasiliy")
                                    .build();
            session.persist(player);
            var player1 = session.get(Player.class, 1);
            System.out.println(player1);
            session.getTransaction().commit();
        }
    }
}
