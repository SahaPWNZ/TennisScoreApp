import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;
import com.sahapwnz.tennisscoreapp.service.MatchScoreCalculationService;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestService {

    static private MatchScoreCalculationService calculationService = new MatchScoreCalculationService();
    static private PlayerScoreDTO player1 = new PlayerScoreDTO(1L);
    static private PlayerScoreDTO player2 = new PlayerScoreDTO(2L);
    static private MatchScoreDTO matchScoreDTO = new MatchScoreDTO(player1, player2);

    public void printTennisScore() {
        System.out.println("Player1: set = " + player1.getSet() + " game = " + player1.getGame() + " points = " + player1.getPoint());
        System.out.println("Player2: set = " + player2.getSet() + " game = " + player2.getGame() + " points = " + player2.getPoint());
        System.out.println("--------------------------------------------------");
    }

    @Test
//@Order(1)
    public void checkMatchScoreCalculationService1() {
        calculationService.winOnePoint(matchScoreDTO, 1L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 2L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 1L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 1L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 2L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 2L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 2L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 1L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 2L);
        printTennisScore();
        calculationService.winOnePoint(matchScoreDTO, 2L);
        printTennisScore();

        for (int i = 0; i < 20; i++) {
            calculationService.winOnePoint(matchScoreDTO, 1L);
            printTennisScore();
            calculationService.winOnePoint(matchScoreDTO, 2L);
            printTennisScore();
            calculationService.winOnePoint(matchScoreDTO, 2L);
            printTennisScore();
        }
    }
}
