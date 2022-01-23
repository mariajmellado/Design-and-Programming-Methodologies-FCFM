package cl.uchile.dcc.scrabble.gui.TiposScrabble;
/**
 * Clase que unifica métodos que son utilizados por las clases hijas de
 * AbstractNumero, esto es, TipoNumero Float, TipoNumeroInt y TipoNumeroBinario,
 * para permitir alguna transformación y operacion entre ellos.
 * @autor: María Jesús Mellado Tenorio.
 */
public abstract class AbstractNumero extends AbstractTipo{
    /**
     * Método que transforma un bit de un binario que es String de Java a int de Java.
     */
    public int bitToInt(char bit) {return bit == '0' ? 0 : 1;}
    /**
     * Método que traduce un String de Java que representa un numero binario positivo a un entero de Java.
     */
    public int BinarioPositivoaInt(String binario){
        int w = 0;
        for (int i = binario.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binario.charAt(i));
        } return w;}
    /**
     * Método que traduce un String de Java que representa un numero binario negativo a un entero de Java.
     */
    public int BinarioNegativoaInt(String binario) {
        int n = binario.length() - 1;
        int w = -bitToInt(binario.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binario.charAt(i) == '1' ? 1 : 0);
        } return w;}
    /**
     * Método que traduce un String de Java que representa un numero binario positivo
     * a un String de Java que represente el complemento de dos de tal binario.
     */
    protected String ComplementodeDos(String binario) {
        int marcador = 0;
        String ayuda = new String();
        String complemento = new String();
        for(int i = (binario.length()-1); i >=0; i--){
            if(binario.charAt(i)=='1' && marcador ==0){
                marcador = 1;
                ayuda += '1';
            } else if (binario.charAt(i)=='0' && marcador == 0){
                ayuda += '0';
            } else if((binario.charAt(i)=='0' || binario.charAt(i)=='1') && marcador == 1){
                if(binario.charAt(i)=='1'){
                    ayuda += '0';
                } else {
                    ayuda += '1';}
            }
        }
        for(int i = (ayuda.length()-1); i>= 0; i--) {
            complemento += ayuda.charAt(i);
        }
        return complemento;
    }
    /**
     * Método que traduce un entero de Java que representa un numero binario positivo
     * a un String de Java.
     */
    protected String PositivoaBinario(int entero){
        String var_binaria_1 = new String();
        String var_binaria_2 = new String();
        int entero_2 = entero;
        boolean k = true;
        while (k){
            if((entero_2/2)==0) {
                k = false; }
            if(entero_2%2==0){
                var_binaria_1 += '0';
            } else {
                var_binaria_1 += '1'; }
            entero_2 = entero_2/2;   }
        var_binaria_2 += '0';
        for(int i = (var_binaria_1.length()-1); i>= 0; i--) {
            var_binaria_2 += var_binaria_1.charAt(i); }
        return var_binaria_2;}
}

