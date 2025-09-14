package app.decoder;

public class Decoder {
    
    private String string;

    public Decoder(String string) {
        this.string = string;
    }

    public String getOperation() {
        if(this.string.contains("+")) return "\\+";
        if(this.string.contains("-")) return "-";
        if(this.string.contains("*")) return "\\*";
        if(this.string.contains("/")) return "\\/";
        if(this.string.contains("^")) return "\\^";
        if(this.string.contains("%")) return "\\%";
        throw new IllegalArgumentException("Illegal operation");
    }

    public double[] getDigits() {
        String[] s = this.string.split(getOperation());
        if(!isDigit(s[0])) throw new IllegalArgumentException("Illegal argument 1");
        if(!isDigit(s[1])) throw new IllegalArgumentException("Illegal argument 2");
        return new double[] {Double.parseDouble(s[0].trim()), Double.parseDouble(s[1].trim())};
    }

    private static boolean isDigit(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }
}
