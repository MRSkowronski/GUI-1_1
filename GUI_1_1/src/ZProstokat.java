import java.lang.reflect.Type;

/**
 * Created by Michal on 2015-03-07.
 */
public class ZProstokat {
    public static int specjalnyNumerK;
    public static int specjalnyNumerP;
    private int szer;
    private int wys;
    private char znakŚrodka;
    private char znakBrzegu;
    StringBuilder Bud = new StringBuilder();
    private Type typ;

    public enum Type {
        KWADRAT,
        PROSTOKAT
    }

    public ZProstokat(int szer, int wys, char znakŚrodka, char znakBrzegu) throws  WrongIntegerException{
        if(szer <= 0 || wys <=0){
            throw new WrongIntegerException();
        }
        if (szer == wys){
            typ = Type.KWADRAT;
            specjalnyNumerK++;
        } else {
            typ = Type.PROSTOKAT;
            specjalnyNumerP++;
        }
        this.szer = szer;
        this.wys = wys;
        this.znakŚrodka = znakŚrodka;
        this.znakBrzegu = znakBrzegu;

    }

    public ZProstokat(int szer, char znakŚrodka, char znakBrzegu) throws  WrongIntegerException{
        if(szer <= 0){
            throw new WrongIntegerException();
        }
        typ = Type.KWADRAT;
        specjalnyNumerK++;
        this.szer = szer;
        this.wys = szer;
        this.znakŚrodka = znakŚrodka;
        this.znakBrzegu = znakBrzegu;
    }



    public String toString(){
        if(typ == typ.KWADRAT){
            this.RysujKwadrat();
            return (typ + " (" + specjalnyNumerK + ") rozmiaru " + szer + " x " + wys + ", pole = " + this.pole() + ", obwód = " + this.obwod() + this.Bud);
        }
        else {
            this.RysujKwadrat();
            return (typ + " (" + specjalnyNumerP + ") rozmiaru " + szer + " x " + wys + ", pole = " + this.pole() + ", obwód = " + this.obwod() + this.Bud);
        }
    }

    public int pole(){
        return wys * szer;
    }

    public int obwod(){
        return (wys * 2) + (szer * 2);
    }

    public void RysujKwadrat(){

        Bud.append("\n");
        for(int i = 0; i < wys; i++){
            Bud.append(znakBrzegu);
            if(i == 0 || i == wys-1){
                for(int k = 0; k<szer-2; k++){
                    Bud.append(znakBrzegu);
                }
            }else {
                for (int j = 0; j < szer - 2; j++) {
                    Bud.append(znakŚrodka);
                }
            }
            Bud.append(znakBrzegu);
            Bud.append("\n");
        }

    }

}
