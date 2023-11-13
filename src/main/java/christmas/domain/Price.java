package christmas.domain;

public class Price {
    Integer price;

    public Price(Integer price) {
        this.price = price;
    }

    public String convertToOutputType() {
        String toConvertedPrice = String.valueOf(price);
        StringBuilder toParsedPrice = new StringBuilder();

        for(int i = toConvertedPrice.length() - 1; i >= 0; i--) {
            toParsedPrice.append(toConvertedPrice.charAt(i));
            if (i >= 1 && (toConvertedPrice.length() - i) % 3 == 0) {
                toParsedPrice.append(",");
            }
        }
        return toParsedPrice.reverse().toString();
    }
}
