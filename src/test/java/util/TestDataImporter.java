package util;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestDataImporter {
    public static Player testPlayer1 = Player.builder().name("TEST").build();
    public static Player testPlayer2 = Player.builder().name("TEST2").build();
    public static Match testMatch1 = Match.builder().player1(testPlayer1).player2(testPlayer2).winnerPlayer(testPlayer1).build();
    public static void importData(SessionFactory sessionFactory) {
        @Cleanup Session session = sessionFactory.openSession();
        session.beginTransaction();

        var testPlayer3 = Player.builder().name("Vlad").build();
        var testPlayer4 = Player.builder().name("Nikita").build();
        var testPlayer5 = Player.builder().name("DELETE_PLAYER").build();

        session.persist(testPlayer1);
        session.persist(testPlayer2);
        session.persist(testPlayer3);
        session.persist(testPlayer4);
        session.persist(testPlayer5);


        var testMatch2 = Match.builder().player1(testPlayer1).player2(testPlayer4).winnerPlayer(testPlayer4).build();
        var testMatch3 = Match.builder().player1(testPlayer2).player2(testPlayer4).winnerPlayer(testPlayer4).build();
        var testMatch4 = Match.builder().player1(testPlayer3).player2(testPlayer2).winnerPlayer(testPlayer3).build();
        var testMatch5 = Match.builder().player1(testPlayer4).player2(testPlayer3).winnerPlayer(testPlayer3).build();
        session.persist(testMatch1);
        session.persist(testMatch2);
        session.persist(testMatch3);
        session.persist(testMatch4);
        session.persist(testMatch5);

        session.getTransaction().commit();

    }
}
