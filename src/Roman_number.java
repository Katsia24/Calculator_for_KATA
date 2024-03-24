enum Roman_number {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);
    int arab;
    Roman_number(int arab){
        this.arab = arab;
    }
    public static String roman(int arab1) {
//        if( arab1 <= 0) { // обрабатывается в main
//            throw new IllegalArgumentException();
//        }
        StringBuilder buf = new StringBuilder();
        final Roman_number[] values = Roman_number.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (arab1 >= values[i].arab) {
                buf.append(values[i]);
                arab1 -= values[i].arab;
            }
        }
        return buf.toString();
    }
//    public static int romanToArab (String rom) {
//            }
//        return arab;
//    }

    public static String getRom(int arab) {
        return roman(arab);
    }

    public int getArab() {
        return arab;
    }
}
