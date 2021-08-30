public class Dansk extends Dialog{
    @Override
    public String welcome() {
        return "hej og velkommen";
    }

    @Override
    public String quit() {
        return "tryk q for at stoppe";
    }

    @Override
    public String selectObject() {
        return "skriv navnet paa typen af det objekt du vil undersoege";
    }
}
