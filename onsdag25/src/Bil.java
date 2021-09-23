public class Bil extends Command{

    public void koer(){
        System.out.println("vroom");
    }

    @Override
    public void exe() {
        koer();
    }
}
