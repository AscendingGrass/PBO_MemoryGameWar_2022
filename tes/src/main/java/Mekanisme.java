public class Mekanisme {
    public Mekanisme(){
        // PENTING YA CLASS INI PERLU BANGET CLASS NAMANYA MEKANISME JANGAN DI DELETE
        Interface d = new Interface() {
            @Override
            public void apasih(String apasih) {
                System.out.println(apasih);
            }

            @Override
            public String gimana(int arsa) {
                return "" + arsa;
            }
        };
        d.apasih("Haloo");
        System.out.println(d.gimana(123));
    }
}

