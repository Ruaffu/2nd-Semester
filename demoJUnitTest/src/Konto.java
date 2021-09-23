public class Konto
{


    private String navn;
    private int saldo;

    public Konto(String navn, int saldo) {
        this.navn = navn;
        this.saldo = saldo;
    }

    public String getNavn() {
        return navn;
    }

    public int getSaldo(){
        return saldo;
    }

    public int deposit(int i) {
        if (i > 0) {
            saldo += i;
        }
        return saldo;
    }

    public int withdraw(int i) {
        if (i < saldo && i > 0){
            saldo -= i;
        }
        return saldo;
    }
}
