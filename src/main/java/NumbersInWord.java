import java.util.HashMap;

/**
 * Created by Mladjan on 26.3.2014.
 */
public class NumbersInWord {
    private String wordMoney = "";
    private String wordThousand = "";
    private String wordHundred = "";
    private String wordTeen = "";
    private String wordOne = "";
    private static final String dollar = "dollar";
    private static final HashMap<Integer,String> basic = new HashMap<Integer, String>();
        static{
            basic.put(1, "one");
            basic.put(2, "two");
            basic.put(3, "three");
            basic.put(4, "four");
            basic.put(5, "five");
            basic.put(6, "six");
            basic.put(7, "seven");
            basic.put(8, "eight");
            basic.put(9, "nine");
            basic.put(10, "teen");
            basic.put(11, "eleven ");
            basic.put(12, "twelve ");
            basic.put(13, "thirteen ");
            basic.put(14, "fourteen ");
            basic.put(15, "fifteen ");
            basic.put(16, "sixteen ");
            basic.put(17, "seventeen ");
            basic.put(18, "eighteen ");
            basic.put(19, "nineteen ");
            basic.put(20, "twenty");
            basic.put(30, "thirty");
            basic.put(40, "forty");
            basic.put(50, "fifty");
            basic.put(60, "sixty");
            basic.put(70, "seventy");
            basic.put(80, "eighty");
            basic.put(90, "ninety");
            basic.put(100, "hundred");
            basic.put(1000, "thousand");
        }
    public String convert(int money) throws MoneyOutOfBoundException{
        wordMoney = getDecimal(money);
        return wordMoney;
    }

    private String getDecimal(int money) throws MoneyOutOfBoundException{
        if(money > 9999) {
           throw new MoneyOutOfBoundException("Money are out of bound, you need to enter money less than 10000");
        }
        if (money > 10 && money < 20) {
            return basic.get(money).concat(dollar);
        }
        int one = money % 10;
        money = money / 10;
        int teen = money % 10;
        money = money /10;
        int hundred = money % 10;
        int thousand = money / 10;
        return generateWordMoney(one, teen, hundred, thousand);
    }
    private String generateWordMoney(int one, int teen, int hundred, int thousand) {
        String space = " ";
        if (thousand > 0) {
            wordThousand = basic.get(thousand).concat(space).concat(basic.get(1000).concat(space));
        }
        if (hundred > 0){
            wordHundred = basic.get(hundred).concat(space).concat(basic.get(100).concat(space));
        }
        if (teen > 0) {
            wordTeen = basic.get(teen*10).concat(space);
        }
        if (one > 0) {
            wordOne = basic.get(one).concat(space);
        }
        wordMoney = wordThousand.concat(wordHundred).concat(wordTeen).concat(wordOne).concat(dollar);
        return wordMoney;
    }

    public class MoneyOutOfBoundException extends Exception {
        private MoneyOutOfBoundException(String message) {
            super(message);
        }
    }
}
