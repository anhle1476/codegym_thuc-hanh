public class TennisGame {

    public static final int SCORE_LOVE = 0;
    public static final int SCORE_15 = 1;
    public static final int SCORE_30 = 2;
    public static final int SCORE_40 = 3;

    private static int player1Score;
    private static int player2Score;

    public static String getScore(String player1Name, String player2Name, int _player1Score, int _player2Score) {
        updatePlayersScore(_player1Score, _player2Score);
        return (isDraw()) ? getDrawScoreName() : (isWin()) ? getWinScore() : getPlayingScore();
    }

    private static void updatePlayersScore(int _player1Score, int _player2Score) {
        player1Score = _player1Score;
        player2Score = _player2Score;
    }

    private static boolean isDraw() {
        return player1Score == player2Score;
    }

    private static String getDrawScoreName() {
        String scoreName = getScoreName(player1Score);
        return scoreName.equals("") ? "Deuce" : scoreName + "-All";
    }

    private static boolean isWin() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private static String getWinScore() {
        int minusResult = player1Score - player2Score;
        return (minusResult == 1)
                ? "Advantage player1"
                : (minusResult == -1)
                ? "Advantage player2"
                : (minusResult >= 2)
                ? "Win for player1"
                : "Win for player2";
    }

    private static String getPlayingScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score.append("-");
                tempScore = player2Score;
            }

            score.append(getScoreName(tempScore));
        }
        return score.toString();
    }

    private static String getScoreName(int score) {
        switch (score) {
            case SCORE_LOVE:
                return "Love";
            case SCORE_15:
                return "Fifteen";
            case SCORE_30:
                return "Thirty";
            case SCORE_40:
                return "Forty";
            default:
                return "";
        }
    }
}
