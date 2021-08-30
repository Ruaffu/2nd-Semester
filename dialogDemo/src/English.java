public class English extends Dialog{
    @Override
    public String welcome() {
        return "hi welcome";
    }

    @Override
    public String quit() {
        return "press q to stop";
    }

    @Override
    public String selectObject() {
        return "enter the name of the type of object you want to analyse";
    }
}
