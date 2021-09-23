public class Main {

    public static void main(String[] args) {
	// write your code here

        String s = "hej";

        String s1 = new String("palle");

        String s2 = "hej";

        System.out.println("vaerdien af s er :"+s.hashCode());

        System.out.println("vaerdien af s er :"+s2.hashCode());

        s = "jeg elsker kage";
        System.out.println("veardien af s er :"+s.hashCode());

        Object [] objects = {new Kronhjort(), new Bil(), new Flodhest(), new Hund()};

        for(Object object : objects){
            if (object instanceof Flodhest){
                ((Flodhest) object).hopIvandet();
            }
            if (object instanceof Bil){
                ((Bil) object).koer();
            }
            if (object instanceof Kronhjort){
                ((Kronhjort) object).broel();
            }
            if (object instanceof Hund){
                ((Hund) object).goer();
            }

        }

        Command [] commands = {new Kronhjort(), new Bil(), new Flodhest(), new Hund()};
        for(Command command : commands){
            command.exe();
        }


    }
}
