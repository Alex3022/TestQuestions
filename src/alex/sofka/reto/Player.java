package alex.sofka.reto;

public class Player {

    private String nickname;
    private String points;

    public Player(String nickname, String points) {
        this.nickname = nickname;
        this.points = points;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
