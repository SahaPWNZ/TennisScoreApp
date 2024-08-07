import com.sahapwnz.tennisscoreapp.dao.MatchDAO;
import com.sahapwnz.tennisscoreapp.dao.PlayerDAO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.TestDataImporter;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDataBaseRunner {
    private static final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Player.class)
            .addAnnotatedClass(Match.class)
            .configure("hibernate-test.cfg.xml")
            .buildSessionFactory();
    private static final MatchDAO matchDAO = new MatchDAO(sessionFactory);
    private static final PlayerDAO playerDAO = new PlayerDAO(sessionFactory);

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
    public void testMatchDAOfindALL() {
        Long numberOfMatches;
        try(Session session = sessionFactory.openSession()){
            numberOfMatches =  (Long)session.createQuery("select count(*) from Match").uniqueResult();
        }
        List<Match> allMatches = matchDAO.findAll();
        assertEquals(allMatches.size(), numberOfMatches);
    }
    @Test
    public void testMatchDAOfindById_Success(){
        assertEquals(matchDAO.findById(1L).orElseThrow(), TestDataImporter.testMatch1);
    }
    @Test
    public void testMatchDAOfindById_NotFound(){
        assertEquals(matchDAO.findById(100L), Optional.empty());
    }

    @Test
    public void testMatchDAOsave(){
        Match match = Match.builder().player1(TestDataImporter.testPlayer1).player2(TestDataImporter.testPlayer2).winnerPlayer(TestDataImporter.testPlayer2).build();
        assertEquals(matchDAO.save(match), match);
    }

    @Test
    public void testMatchDAOdelete(){
        matchDAO.delete(1L);
        assertEquals(matchDAO.findById(1L), Optional.empty());
    }
    @Test
    public void testMatchDAOdelete_NotFound(){
        matchDAO.delete(100L);
        assertEquals(matchDAO.findById(100L), Optional.empty());
    }



    @Test
    public void testOutAllMatchInConsoleDAO() {
        for (Match match : matchDAO.findAll()) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Player1: " + match.getPlayer1());
            System.out.println("Player2: " + match.getPlayer2());
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testPlayerDAOfindALL() {
        Long numberOfPlayers;
        try(Session session = sessionFactory.openSession()){
            numberOfPlayers =  (Long)session.createQuery("select count(*) from Player").uniqueResult();
        }
        List<Player> allPlayers = playerDAO.findAll();
        assertEquals(allPlayers.size(), numberOfPlayers);
    }
    @Test
    public void testPlayerDAOfindById_Success(){
        assertEquals(playerDAO.findById(1L).orElseThrow(), TestDataImporter.testPlayer1);
    }
    @Test
    public void testPlayerDAOfindById_NotFound(){
        assertEquals(playerDAO.findById(100L), Optional.empty());
    }

    @Test
    public void testPlayerDAOsave_Success(){
        Player player = Player.builder().name("SAVE_SUCCESS").build();
        assertEquals(playerDAO.save(player), player);
    }
    @Test
    public void testPlayerDAOsave_Exception(){
        Player player = Player.builder().name("TEST").build();
        assertThrows(ConstraintViolationException.class, ()->
                playerDAO.save(player));

    }

    @Test
    public void testPlayerDAOdelete(){
        playerDAO.delete(5L);
        assertEquals(playerDAO.findById(5L), Optional.empty());
    }
    @Test
    public void testPlayerDAOdelete_NotFound(){
        playerDAO.delete(100L);
        assertEquals(playerDAO.findById(100L), Optional.empty());
    }
}
