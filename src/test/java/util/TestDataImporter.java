package util;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestDataImporter {
    public static void importData(SessionFactory sessionFactory) {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();
        var player1 = Player.builder().name("TEST").build();
        var player2 = Player.builder().name("TEST2").build();
        var player3 = Player.builder().name("Vlad").build();
        var player4 = Player.builder().name("Nikita").build();

        session.persist(player1);
        session.persist(player2);
        session.persist(player3);
        session.persist(player4);

        var match1 = Match.builder().player1(player1).player2(player2).winnerPlayer(player1).build();
        var match2 = Match.builder().player1(player1).player2(player4).winnerPlayer(player4).build();
        var match3 = Match.builder().player1(player2).player2(player4).winnerPlayer(player4).build();
        var match4 = Match.builder().player1(player3).player2(player2).winnerPlayer(player3).build();
        session.persist(match1);
        session.persist(match2);
        session.persist(match3);
        session.persist(match4);

        session.getTransaction().commit();

    }
}
