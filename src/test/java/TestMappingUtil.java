import com.sahapwnz.tennisscoreapp.dto.MatchScoreDTO;
import com.sahapwnz.tennisscoreapp.dto.PlayerScoreDTO;
import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.util.MappingUtil;
import org.junit.jupiter.api.Test;

public class TestMappingUtil {
    static private PlayerScoreDTO playerDTO = new PlayerScoreDTO(1L);
    static private PlayerScoreDTO player2DTO = new PlayerScoreDTO(5L);
    static private Player playerEntity = new Player(3L, "Vasy");
    static private MatchScoreDTO matchScoreDTO = new MatchScoreDTO(playerDTO, player2DTO);
    public static Player testPlayer1 = Player.builder().name("TEST").build();
    public static Player testPlayer2 = Player.builder().name("TEST2").build();
    public static Match testMatch1 = Match.builder().player1(testPlayer1).player2(testPlayer2).winnerPlayer(testPlayer1).build();

    @Test
    public void testMappingPlayer() {
        System.out.println(MappingUtil.convertToDTO(playerEntity));
        System.out.println(MappingUtil.convertToEntityPlayer(playerDTO));
    }

    @Test
    public void testMappingMatch() {
        playerDTO.setName("Player1");
        playerDTO.setSet(2);
        player2DTO.setName("Player2");
        System.out.println(MappingUtil.convertToEntityMatch(matchScoreDTO));

    }
}
