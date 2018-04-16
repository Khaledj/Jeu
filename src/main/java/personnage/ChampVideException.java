package personnage;

public class ChampVideException extends Exception{

    public ChampVideException() {
        System.out.println("Le champ ne peut être vide, vous aurez un nom par défault");
    }
}
