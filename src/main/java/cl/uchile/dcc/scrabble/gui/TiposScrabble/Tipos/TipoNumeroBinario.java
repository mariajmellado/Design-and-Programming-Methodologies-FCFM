package cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.*;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.AbstractNumero;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

/**
 * Clase que hereda de la clase abstracta AbstractTipos.
 * Implementa el tipo binario de Scrabble.
 * Sobreescribe métodos de la clase abstracta que permiten un retorno
 * válido (no TipoNulo) de una transformacion u operacion que lo insmiscuye.
 * @autor: María Jesús Mellado Tenorio.
 */
public class TipoNumeroBinario extends AbstractNumero{
    private String arg;
    /**
     * Constructor de la clase TipoNumeroBinario. Establece su único atributo que es de tipo string de Java.
     */
    public TipoNumeroBinario(String argumento) {
        this.arg = argumento;
    }
    /**
     * Método que retorna el valor que contiene el objeto TipoNumeroBinario.
     */
    public String getArg() {return this.arg;}
    /**
     * Método que sobreescribe el metodo hashCode() de object para poder ser implementado por TipoNumeroBinario.
     */
    @Override
    public int hashCode () {
        return Objects.hash(TipoNumeroBinario.class);
    }
    /**
     * Método que sobreescribe el metodo equals de object para poder ser implementado por TipoNumeroInt.
     */
    @Override
    public boolean equals (Object obj){
        if (obj instanceof TipoNumeroBinario) {
            var variable = (TipoNumeroBinario) obj;
            return variable.getArg().equals(getArg());
        } return false; }
    /**
     * Método que sobreescribe el metodo toString() de object para poder ser implementado por TipoNumeroBinario.
     */
    @Override
    public String toString() {
        return  String.valueOf(this.getArg());
    }
    // Transformaciones.
    /**
     * Método que transforma TipoNumeroBinario a TipoNumeroBinario de Scrabble.
     */
    @Override
    public TipoNumeroBinario aTipoNumeroBinario() {
            return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.toString());
        }
    /**
     * Método que transforma TipoNumeroBinario a TipoNumeroInt de Scrabble.
     */
    @Override
    public TipoNumeroInt aTipoNumeroInt() {
            String binary = this.toString();
            if (bitToInt(binary.charAt(0)) == 0) {
                return FabricaTipoNumeroInt.getFabricaTipoInt().crear(BinarioPositivoaInt(binary));
            } else { return FabricaTipoNumeroInt.getFabricaTipoInt().crear(BinarioNegativoaInt(binary));}}
    /**
     * Método que transforma TipoNumeroBinario a TipoNumeroFloat de Scrabble.
     */
    @Override
    public TipoNumeroFloat aTipoNumeroFloat(){
            return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(this.aTipoNumeroInt().aTipoNumeroFloat().getArg());}
    // Operaciones de segunda instancia.
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de dos TipoNumeroBinario.
     */
    @Override
    public ITipo esSumadoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt resultado = FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.aTipoNumeroInt().getArg()
                +binario.aTipoNumeroInt().getArg());
        return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(resultado.aTipoNumeroBinario().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de dos TipoNumeroBinario.
     */
    @Override
    public ITipo esRestadoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt resultado = FabricaTipoNumeroInt.getFabricaTipoInt().crear(binario.aTipoNumeroInt().getArg()-
                this.aTipoNumeroInt().getArg());
        return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(resultado.aTipoNumeroBinario().getArg()); }
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de dos TipoNumeroBinario.
     */
    @Override
    public ITipo esMultiplicadoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt resultado = FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.aTipoNumeroInt().getArg() *
                binario.aTipoNumeroInt().getArg());
        return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(resultado.aTipoNumeroBinario().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la division de dos TipoNumeroBinario.
     */
    @Override
    public ITipo esDivididoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt resultado = FabricaTipoNumeroInt.getFabricaTipoInt().crear(binario.aTipoNumeroInt().getArg()/
                this.aTipoNumeroInt().getArg());
        return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(resultado.aTipoNumeroBinario().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de un TipoNumeroInt con un TipoNumeroBinario.
     */
    @Override
    public ITipo esSumadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.aTipoNumeroInt().getArg() + entero.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de un TipoNumeroInt con un TipoNumeroBinario.
     */
    @Override
    public ITipo esRestadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(entero.getArg()-this.aTipoNumeroInt().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de un TipoNumeroInt con un TipoNumeroBinario.
     */
    @Override
    public ITipo esMultiplicadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.aTipoNumeroInt().getArg()*entero.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la division de un TipoNumeroInt con un TipoNumeroBinario.
     */
    @Override
    public ITipo esDivididoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(entero.getArg()/this.aTipoNumeroInt().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de un TipoNumeroFloat con un TipoNumeroBinario.
     */
    @Override
    public ITipo esSumadoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(this.aTipoNumeroFloat().getArg() + Float.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de un TipoNumeroFloat con un TipoNumeroBinario.
     */
    @Override
    public ITipo esRestadoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(Float.getArg() - this.aTipoNumeroFloat().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de un TipoNumeroFloat con un TipoNumeroBinario.
     */
    @Override
    public ITipo esMultiplicadoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(Float.getArg() * this.aTipoNumeroFloat().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la division de un TipoNumeroFloat con un TipoNumeroBinario.
     */
    @Override
    public ITipo esDivididoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(Float.getArg() / this.aTipoNumeroFloat().getArg());}
    /**
     * Método que retorna la suma de un TipoNumeroBinario con un ITipo.
     */
    @Override
    public ITipo Suma(ITipo valor) {
        return valor.esSumadoConBinario(this);
    }
    /**
     * Método que retorna la resta de un TipoNumeroBinario con un ITipo.
     */
    @Override
    public ITipo Resta(ITipo valor){
        return  valor.esRestadoConBinario(this);
    }
    /**
     * Método que retorna la multiplicación de un TipoNumeroBinario con un ITipo.
     */
    @Override
    public ITipo Multiplica(ITipo valor){
        return  valor.esMultiplicadoConBinario(this);
    }
    /**
     * Método que retorna la división de un TipoNumeroBinario con un ITipo.
     */
    @Override
    public ITipo Divide(ITipo valor){
            return valor.esDivididoConBinario(this);
    }
    /**
     * Método que sobreescribe al de ITipo para retornar "y lógico" entre un TipoNumeroBinario con un ITipo.
     */
    @Override
    public ITipo ConjuncionLogica(ITipo Tipo) {
        return Tipo.esYLogicoConBinario(this);
    }
    /**
     * Método que sobreescribe al de ITipo para retornar "o lógico" entre un TipoNumeroBinario con un ITipo.
     */
    @Override
    public ITipo DisyuncionLogica(ITipo Tipo) {
        return Tipo.esOLogicoConBinario(this);
    }
    /**
     * Método que sobreescribe al de ITipo para retornar el "y lógico" entre dos TipoNumeroBinario.
     */
    @Override
    public ITipo esYLogicoConBinario(TipoNumeroBinario binario) {
        var variable = (TipoNumeroBinario) binario;
        StringBuilder cadena_0 = new StringBuilder();
        StringBuilder cadena = new StringBuilder();
        TipoNumeroBinario variable_corta;
        TipoNumeroBinario variable_corta_0;
        TipoNumeroBinario variable_larga;
        if (variable.getArg().length() != this.getArg().length()) {
            if (variable.getArg().length() > this.getArg().length()) {
                variable_larga = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(variable.getArg());
                variable_corta_0 = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg());
            } else {
                variable_larga = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg());
                variable_corta_0 = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(variable.getArg());
            }
            int diferencia = variable_larga.getArg().length() - variable_corta_0.getArg().length();
            if(variable_corta_0.getArg().charAt(0) == '0'){
                for (int i = 0; i < diferencia; i++) {
                    cadena_0.append("0");
                }
            } else {
                for (int i = 0; i < diferencia; i++) {
                    cadena_0.append("1");
                }
            }
            cadena_0.append(variable_corta_0.getArg());
            variable_corta = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena_0.toString());
        } else {
            variable_larga = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg());
            variable_corta = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(variable.getArg());
        }
        for (int i = 0; i < variable_larga.getArg().length(); i++) {
            if (variable_larga.getArg().charAt(i) == '0' || variable_corta.getArg().charAt(i) == '0') {
                cadena.append('0');
            } else {
                cadena.append('1');
            }}return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena.toString());}
    /**
     * Método que sobreescribe al de ITipo para retornar el "y lógico" entre un TipoBoolean y un TipoNumeroBinario.
     */
    @Override
    public ITipo esYLogicoConBoolean(TipoBoolean bool) {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < this.getArg().length(); i++) {
            if (this.getArg().charAt(i) == '0') {
                cadena.append('0');
            } else {
                if(bool.getArg()){
                    cadena.append('1');
                }else{
                    cadena.append('0');
                }
            }} return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena.toString()); }
    /**
     * Método que sobreescribe al de ITipo para retornar el "o lógico" entre dos TipoNumeroBinario.
     */
    @Override
    public ITipo esOLogicoConBinario(TipoNumeroBinario binario) {
        var variable = (TipoNumeroBinario) binario;
        StringBuilder cadena_0 = new StringBuilder();
        String cadena = "";
        TipoNumeroBinario variable_larga;
        TipoNumeroBinario variable_corta_0;
        TipoNumeroBinario variable_corta;
        if (variable.getArg().length() != this.getArg().length()) {
            if (variable.getArg().length() > this.getArg().length()) {
                variable_larga = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(variable.getArg());
                variable_corta_0 = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg());
            } else {
                variable_larga = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg());
                variable_corta_0 = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(variable.getArg());
            }
            int diferencia = variable_larga.getArg().length() - variable_corta_0.getArg().length();
            if(variable_corta_0.getArg().charAt(0) == '0'){
                for (int i = 0; i < diferencia; i++) {
                    cadena_0.append("0");
                }
            } else {
                for (int i = 0; i < diferencia; i++) {
                    cadena_0.append("1");
                }
            }
            cadena_0.append(variable_corta_0.getArg());
            variable_corta = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena_0.toString());
        } else {
            variable_larga = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg());
            variable_corta = FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(variable.getArg());
        }
        for (int i = 0; i < variable_larga.getArg().length(); i++) {
            if (variable_larga.getArg().charAt(i) == '0' && variable_corta.getArg().charAt(i) == '0') {
                cadena += '0';
            } else {
                cadena += '1';
            }
        } return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena);}
    /**
     * Método que sobreescribe al de ITipo para retornar el "o lógico" entre un TipoBoolean y un TipoNumeroBinario.
     */
    @Override
    public ITipo esOLogicoConBoolean(TipoBoolean bool) {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < this.getArg().length(); i++) {
            if (this.getArg().charAt(i) == '0') {
                if(bool.getArg()){ cadena.append('1');}
                else{
                    cadena.append('0');}
            } else { cadena.append('1');}
        } return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena.toString());}
    /**
     * Método que sobreescribe al de ITipo para retornar la negación de TipoBinario.
     */
    @Override
    public ITipo Negacion(){
            StringBuilder cadena = new StringBuilder(new String(""));
            for (int i = 0; i < this.getArg().length(); i++) {
                if (this.getArg().charAt(i) == '0') { cadena.append('1');}
                else { cadena.append('0');}
            }return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena.toString());}

    /**
     * Método que sobreescribe el de INodo para obtener este TipoNumeroBinario.
     */
    @Override
    public ITipo getValor() { return this;}
    /**
     * Método que sobreescribe el de AbstractTipo para comparar dos TipoNumeroBinario.
     */
    public ITipo compararConBinario(TipoNumeroBinario Binario){
        if(this.getArg().length() > Binario.getArg().length()){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(-1);
        }else if(this.getArg().length() == Binario.getArg().length() ){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(0);
        }else{
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(1);
        }
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un TipoNumeroBinario pueda aceptar un cambio.
     */
    @Override
    public ITipo aceptaCambio() {
        // 0 es por poner algun valor, pero la verdad es que da lo mismo el caracter, el largo
        // es lo importante.
        return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg()+"0");
        /* A continuación, el caso a<b de la comparacion. Como esto es a efectos del testing, usar lo de arriba
        o lo de abajo es análogo. Se usa el de arriba sin pérdida de generalidad.*/
        // return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(this.getArg().removeEnd());
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un ITipo pueda o no ser comparado con un TipoNumeroBinario.
     * Implementa Double Dispatch.
     */
    @Override
    public ITipo compararCon(ITipo Tipo){
        return Tipo.compararConBinario(this);
    }

}
