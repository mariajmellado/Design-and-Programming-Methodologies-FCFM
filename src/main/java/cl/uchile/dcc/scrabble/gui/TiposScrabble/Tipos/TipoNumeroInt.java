package cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.AbstractNumero;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

/**
 * Clase que hereda de la clase abstracta AbstractTipos.
 * Implementa el tipo numero entero de Scrabble.
 * Sobreescribe métodos de la clase abstracta que permiten un retorno
 * válido (no TipoNulo) de una transformacion u operacion que lo insmiscuye.
 * @autor: María Jesús Mellado Tenorio.
 */
public class TipoNumeroInt extends AbstractNumero{
    private int arg;
    /**
     * Constructor de la clase TipoNumeroInt.
     * Establece su único atributo que es de tipo int de Java.
     */
    public TipoNumeroInt(int argumento) {
        this.arg = argumento;
    }
    /**
     * Método que retorna el valor que contiene este objeto.
     */
    public int getArg() {
        return this.arg;
    }
    /**
     * Método que sobreescribe el metodo hashCode() de object para poder ser implementado por TipoNumeroInt.
     */
    @Override
    public int hashCode() {
        return Objects.hash(TipoNumeroInt.class);
    }
    /**
     * Método que sobreescribe el metodo equals de object para poder ser implementado por TipoNumeroInt.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoNumeroInt) {
            var variable = (TipoNumeroInt) obj;
            return variable.getArg() == this.getArg();
        } return false; }
    /**
     * Método que sobreescribe el metodo toString() de object para poder ser implementado por TipoNumeroInt.
     */
    @Override
    public String toString() {
        return  String.valueOf(this.getArg());
    }
    // Transformaciones.
    /**
     * Método que transforma TipoNumeroInt a TipoNumeroInt de Scrabble.
     */
    @Override
    public TipoNumeroInt aTipoNumeroInt(){
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.getArg());
    }
    /**
     * Método que transforma TipoNumeroInt a TipoNumeroFloat de Scrabble.
     */
    @Override
    public TipoNumeroFloat aTipoNumeroFloat() {
        return new TipoNumeroFloat(this.getArg());
    }
    /**
     * Método que transforma TipoNumeroInt a TipoNumeroBinario de Scrabble.
     */
    @Override
    public TipoNumeroBinario aTipoNumeroBinario() {
        if(this.getArg()<0){return new TipoNumeroBinario(ComplementodeDos(PositivoaBinario(-this.getArg())));
        } else {return new TipoNumeroBinario(PositivoaBinario(this.getArg()));}}

    // Operaciones de segunda instancia.
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de dos TipoNumeroInt.
     */
    @Override
    public ITipo esSumadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.getArg() + entero.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de dos TipoNumeroInt.
     */
    @Override
    public ITipo esRestadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(entero.getArg() - this.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de dos TipoNumeroInt.
     */
    @Override
    public ITipo esMultiplicadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.getArg() * entero.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la division de dos TipoNumeroInt.
     */
    @Override
    public ITipo esDivididoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(entero.getArg()/this.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de un TipoNumeroFloat con TipoNumeroInt.
     */
    @Override
    public ITipo esSumadoConFloat(TipoNumeroFloat Float) {
        return new TipoNumeroFloat( this.aTipoNumeroFloat().getArg() + Float.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de un TipoNumeroFloat con TipoNumeroInt.
     */
    @Override
    public ITipo esRestadoConFloat(TipoNumeroFloat Float) {
        return new TipoNumeroFloat(Float.getArg() - this.aTipoNumeroFloat().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de un TipoNumeroFloat con TipoNumeroInt.
     */
    @Override
    public ITipo esMultiplicadoConFloat(TipoNumeroFloat Float) {
        return new TipoNumeroFloat(Float.getArg() * this.aTipoNumeroFloat().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la division de un TipoNumeroFloat con TipoNumeroInt.
     */
    @Override
    public ITipo esDivididoConFloat(TipoNumeroFloat Float) {
        return new TipoNumeroFloat(Float.getArg() / this.aTipoNumeroFloat().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de un TipoNumeroBinario con TipoNumeroInt.
     */
    @Override
    public ITipo esSumadoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt suma = new TipoNumeroInt(this.getArg() + binario.aTipoNumeroInt().getArg());
        return new TipoNumeroBinario(suma.aTipoNumeroBinario().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de un TipoNumeroBinario con TipoNumeroInt.
     */
    @Override
    public ITipo esRestadoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt resta = new TipoNumeroInt(binario.aTipoNumeroInt().getArg()- this.getArg());
        return new TipoNumeroBinario(resta.aTipoNumeroBinario().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de un TipoNumeroBinario con TipoNumeroInt.
     */
    @Override
    public ITipo esMultiplicadoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt mult = new TipoNumeroInt(this.getArg()*binario.aTipoNumeroInt().getArg());
        return new TipoNumeroBinario(mult.aTipoNumeroBinario().getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la division de un TipoNumeroBinario con TipoNumeroInt.
     */
    @Override
    public ITipo esDivididoConBinario(TipoNumeroBinario binario) {
        TipoNumeroInt div = new TipoNumeroInt(binario.aTipoNumeroInt().getArg()/this.getArg());
        return new TipoNumeroBinario(div.aTipoNumeroBinario().getArg());}
    // Operaciones de primera instancia.
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de un TipoNumeroInt con un ITipo.
     */
    @Override
    public ITipo Suma(ITipo numero) {
        return numero.esSumadoConInt(this);
    }
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de un TipoNumeroInt con un ITipo.
     */
    @Override
    public ITipo Resta(ITipo numero) {
        return numero.esRestadoConInt(this);
    }
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de un TipoNumeroInt con un ITipo.
     */
    @Override
    public ITipo Multiplica(ITipo numero) {
        return numero.esMultiplicadoConInt(this);
    }
    /**
     * Método que sobreescribe el de ITipo para retornar la division de un TipoNumeroInt con un ITipo.
     */
    @Override
    public ITipo Divide(ITipo numero) {
        return numero.esDivididoConInt(this);
    }
    /**
     * Método que sobreescribe el de ITipo para retornar la negacion de TipoNumeroInt.
     */
    @Override
    public ITipo Negacion() {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(-this.getArg());
    }
    /**
     * Método que sobreescribe el de INodo para obtener este TipoNumeroInt.
     */
    @Override
    public ITipo getValor() { return this;}
    /**
     * Método que sobreescribe el de AbstractTipo para comparar dos TipoNumeroInt.
     */
    public TipoNumeroInt compararConInt(TipoNumeroInt Int){
        if(this.getArg() > Int.getArg()){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(-1);
        }else if(this.getArg() == Int.getArg() ){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(0);
        }else{
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(1);
        }
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un TipoNumeroInt pueda aceptar un cambio.
     */
    @Override
    public ITipo aceptaCambio() {
        return FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.getArg()+1);
        /* A continuación, el caso a<b de la comparacion. Como esto es a efectos del testing, usar lo de arriba
        o lo de abajo es análogo. Se usa el de arriba sin pérdida de generalidad.*/
        // return FabricaTipoNumeroInt.getFabricaTipoInt().crear(this.getArg()-1);
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un ITipo pueda o no ser comparado con un TipoNumeroInt.
     * Implementa Double Dispatch.
     */
    @Override
    public ITipo compararCon(ITipo Tipo) {
        return Tipo.compararConInt(this);
    }
}
