import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;
import com.sahapwnz.tennisscoreapp.service.MatchScoreCalculationService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestService {

    static private final PlayerScoreDTO player1 = new PlayerScoreDTO(1L);
    static private final PlayerScoreDTO player2 = new PlayerScoreDTO(2L);
    static private final MatchScoreDTO matchScoreDTO = new MatchScoreDTO(player1, player2);

    public void printTennisScore() {
        System.out.println("Player1: set = " + player1.getSet() + " game = " + player1.getGame() + " points = " + player1.getPoint());
        System.out.println("Player2: set = " + player2.getSet() + " game = " + player2.getGame() + " points = " + player2.getPoint());
        System.out.println("--------------------------------------------------");
    }

    @BeforeEach
    public void clearAllPlayerPoints() {
        player1.setPoint(0);
        player1.setGame(0);
        player1.setSet(0);
        player2.setPoint(0);
        player2.setGame(0);
        player2.setSet(0);
    }

    @Test
//@Order(1)
    @DisplayName("Игрок первый забирает Победу в сете при стартовом счёте 5-0 по геймам")
    public void checkMatchScoreCalculationService() {
        player1.setPoint(3);
        player1.setGame(5);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 1L);

        assertEquals(player1.getSet(), 1);
    }

    @Test
    @DisplayName("Проверка работы метода тайбрейка при счёте по геймам 6-6 ")
    public void checkTieBreakMatchScoreCalculationService() {

        player1.setGame(6);
        player1.setSet(1);
        player2.setGame(5);
        player2.setPoint(3);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 2L);

        assertEquals(player1.getSet(), 1);
        player1.setPoint(4);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 1L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 1L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 1L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 2L);

        assertEquals(player1.getSet(), 2);
    }

    @Test
    @DisplayName("Проверка подсчёта очков игроков при равенстве очков 4-4")
    public void checkMoreORLessPoints() {
        player1.setPoint(2);
        player2.setPoint(2);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 1L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 2L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 1L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 2L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 1L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 2L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 2L);
        MatchScoreCalculationService.winOnePoint(matchScoreDTO, 2L);

        assertEquals(player2.getGame(), 1);
    }


}
