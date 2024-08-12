import com.sahapwnz.tennisscoreapp.dao.MatchDAO;
import com.sahapwnz.tennisscoreapp.dao.PlayerDAO;
import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerRequestDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.service.OngoingMatchesService;
import com.sahapwnz.tennisscoreapp.service.PlayerPersistenceService;
import com.sahapwnz.tennisscoreapp.util.MappingUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.TestDataImporter;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAllServices {
    private static final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Player.class)
            .addAnnotatedClass(Match.class)
            .configure("hibernate-test.cfg.xml")
            .buildSessionFactory();
    private static final MatchDAO matchDAO = new MatchDAO(sessionFactory);
    private static final PlayerDAO playerDAO = new PlayerDAO(sessionFactory);
    private static final OngoingMatchesService ongoingMatchesService = new OngoingMatchesService();

    @BeforeAll
    public static void initDB() {
        TestDataImporter.importData(sessionFactory);
    }

    @AfterAll
    public static void finish() {
        sessionFactory.close();
    }


//    public void test1(){
//    PlayerScoreDTO player1 = MappingUtil.convertToDTO(playerDAO.findById(1L).get());
//    PlayerScoreDTO player2 = MappingUtil.convertToDTO(playerDAO.findById(2L).get());
//    UUID uuidNewMatch =  ongoingMatchesService.addNewMatchScoreDTO(player1, player2);
//    System.out.println(uuidNewMatch);
//    MatchScoreDTO matchScoreDTO = ongoingMatchesService.getMatchScoreDTO(uuidNewMatch);
//    matchScoreDTO.getPlayer1().setGame(4);
//    matchScoreDTO.getPlayer2().setPoint(3);
//
//
//    PlayerScoreDTO fakePlayer1 = MappingUtil.convertToDTO(playerDAO.findById(2L).get());
//    PlayerScoreDTO fakePlayer2 = MappingUtil.convertToDTO(playerDAO.findById(1L).get());
//    assertEquals(uuidNewMatch, ongoingMatchesService.addNewMatchScoreDTO(fakePlayer1,fakePlayer2));
//    System.out.println(OngoingMatchesService.mapMatchScore.size());
//}






//    обработчик в new-match
    //приходит 2 playerRequestDTO (Только name)
    //они отправляются в сервис PlayerPersistenceService

//        -где идёт проверка есть ли они в БД или нет, если есть то возвращает модель с БД +
//            если нет, то сохраняет и потом возвращает модель с бд+

//    далее 2 эти модели мапятся в 2 ДТО и передаются в сервис OnGoingMatchesService:+

//        -там создаётся MatchDTO, затем проверка есть ли такой матч в мапе, или нет,+
//            если есть то возвращается он (UUID), если нет то кладём матч в коллекцию и возвращаем его UUID
//редирект на страницу /match-score?uuid=$match_id+
    
//    далее при нажатии на кнопку очка - передаётся MatchScoreDTO и id игрока который получил очко
}
