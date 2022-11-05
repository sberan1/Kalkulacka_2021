/**
 *
 * Tato třída provádí vlastní výpočty kalkulátoru. Třída má tři skupiny metod:
 * a) pomocí metody getHodnotaKZobrazeni grafická třída zjištuje co má zobrazit na
 *    displayi,
 * b) metody cislice, plus, minus, rovnaSe a vymaz se volají při stisknutí příslušné
 *    klávesy na kalkulačce,
 * c) metody getAutor a getVerze jsou informační
 * 
 * Třída není dokončena - úkolem studentů je tuto třídu dokončit, tj. navrhnout datové
 * atributy instancí třídy a dokončit obsah metod.
 *
 * @author     Lubos Pavlicek
 * @version    1.0 (31 July 2004)
 */
public class Kalkulator 
{

    private int hodnotaKZobrazeni;
    private int prvniOperand;
    private int operator;
    private boolean noveCislo;
    private final int ZADNA_OPERACE = 0;
    private final int OPERACE_PLUS = 1;
    private final int OPERACE_MINUS = 2;
    private final int OPERACE_ROVNASE = 3;
    private int posledniOperator;
    private int posledniVysledek;
    private int posledniScitanec;
  
    /**
     *  konstruktor třídy
     */
    public Kalkulator () {
        noveCislo = false;
    }

    /**
     * Metoda vrací hodnotu, která se má zobrazit na displayi kalkulacky. Tato metoda
     * se obvykle volá po zavolání metody odpovídající stisku tlačítka.
     * 
     * @return   hodnota k zobrazení
     */
 
    public int getHodnotaKZobrazeni() {
        return hodnotaKZobrazeni;
    }

    /**
     * metoda se volá při stisknutí tlačítka s číslicí na kalkulačce. Parametrem
     * je hodnota na stisknuté klávese.
     * 
     * @param hodnota    hodnota na stisknutém tlačítku, hodnota je v rozsahu
     *                   od 0 do 9
     */
    public void cislice(int hodnota) {
        if (noveCislo) {
            hodnotaKZobrazeni = hodnota;
            noveCislo = false;
        }
        else {
            // 4. Zkuste ošetřit přetečení rozsahu čísla int, tj. aby po dosažení velikosti čísla int nebylo možno
            // vkládat další číslice.
            if (hodnotaKZobrazeni <= 214748364 && hodnota <= 7)
            {
            this.hodnotaKZobrazeni = this.hodnotaKZobrazeni *10 + hodnota;
            }
            else {

            }
        }
    }

    /**
     * metoda se volá při stisknutí tlačítka "+" (plus) na kalkulačce
     */
    public void plus() {
        vypocet();
        prvniOperand = hodnotaKZobrazeni;
        operator = OPERACE_PLUS;
        hodnotaKZobrazeni = 0;
        noveCislo = true;

    }

    /**
     * metoda se volá při stisknutí tlačítka "-" (minus) na kalkulačce
     */
    public void minus() {
        vypocet();
        prvniOperand = hodnotaKZobrazeni;
        operator = OPERACE_MINUS;
        hodnotaKZobrazeni = 0;
        noveCislo = true;

    }

    /**
     * metoda se volá při stisknutí tlačítka "=" (rovná se) na kalkulačce
     */
    public void rovnaSe() {
        //Kalkulačka ve Windows v následující situaci vypočte 70 (první operand použije i jako druhý operand). 35+=
            if (hodnotaKZobrazeni == 0){
                posledniScitanec = hodnotaKZobrazeni;
                hodnotaKZobrazeni = prvniOperand;
                vypocet();
                posledniOperator = operator;
                operator = ZADNA_OPERACE;
                noveCislo = true;
                posledniVysledek = hodnotaKZobrazeni;

            }
            //Upravte kód třídy Kalkulator tak, aby se při opakovaném stisku klávesy rovná se zopakovala poslední operace. Např. v následující kombinaci by se měla zobrazit hodnota 39:35 + 2 = =
            else if (operator == ZADNA_OPERACE && hodnotaKZobrazeni == posledniVysledek) {
                operator = posledniOperator;
                prvniOperand = posledniScitanec;
                vypocet();
                posledniOperator = operator;
                operator = ZADNA_OPERACE;
                noveCislo = true;
                posledniVysledek = hodnotaKZobrazeni;

            }
            else {
                posledniScitanec = hodnotaKZobrazeni;
                vypocet();
                posledniOperator = operator;
                operator = ZADNA_OPERACE;
                noveCislo = true;
                posledniVysledek = hodnotaKZobrazeni;
            }

    }

    /**
     * 5. Předělejte vnořené příkazy if na příkaz switch v metodě vypocet().
     */
    public void vypocet(){

        switch (operator){
            case OPERACE_PLUS:
                hodnotaKZobrazeni = prvniOperand + hodnotaKZobrazeni;
                break;
            case OPERACE_MINUS:
                hodnotaKZobrazeni = prvniOperand - hodnotaKZobrazeni;
                break;
            case ZADNA_OPERACE:
                prvniOperand = hodnotaKZobrazeni;
                break;
        }

    }
    
    /**
     * metoda se volá při stisknutí tlačítka "C" (clear) na kalkulačce
     */
    public void vymaz() {
	  hodnotaKZobrazeni = 0;
    }

    /**
     * metoda vrací jméno autora, např. "autor: Jan Novák"
     * 
     * @return   řetězec se jménem autora
     */    
    public String getAutor() {
        return "Stepan Beran";
    }
    
    /**
     * metoda vrací označení verze, např. "verze 1.0.3"
     * 
     * @return   řetězec s verzí programu
     */
    public String getVerze() {
        return "1.1";
    }
    
}
