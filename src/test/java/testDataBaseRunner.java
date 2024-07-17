import com.sahapwnz.tennisscoreapp.entity.Match;
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
            var player1 = Player.builder()
                    .name("Vasiliy")
                    .build();
            var player2 = Player.builder()
                    .name("Sany")
                    .build();
            session.persist(player1);
            session.persist(player2);
            var match = Match.builder()
                    .player1(player1)
                    .player2(player2)
                    .winnerPlayer(player1)
                    .build();
            session.persist(match);
            System.out.println(match);
            System.out.println(player1);
            System.out.println(player2);
            session.getTransaction().commit();
        }
    }
}
