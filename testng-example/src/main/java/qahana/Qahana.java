package qahana;

public class Qahana {

    public int aghotel(int amount, String currency) throws Exception {
        if (amount < 10000) {
            throw new Exception("Amount is too small");
        }

        return amount/10;
    }
}
