package cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoBoolean;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNumeroBinario;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.AbstractTipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;

import java.util.Objects;

/**
 * Clase que hereda de la clase abstracta AbstractTipos.
 * Implementa el tipo boolean de Scrabble.
 @autor: María Jesús Mellado Tenorio.
 */
public class TipoBoolean extends AbstractTipo {
    private final boolean arg;
    /**
     * Constructor de la clase TipoBoolean.
     * Establece su único atributo que es de tipo Boolean de Java.
     * Sobreescribe métodos de la clase abstracta que permiten un retorno
     * válido (no TipoNulo) de una transformacion u operacion que lo insmiscuye.
     */
    public TipoBoolean(boolean argumento) {
        this.arg = argumento;
    }
    /**
     * Método que retorna el valor que contiene este objeto.
     */
    public Boolean getArg() {
        return this.arg;
    }
    /**
     * Método que sobreescribe el metodo hashCode() de object para poder ser implementado por TipoBoolean.
     */
    @Override
    public int hashCode() {
        return Objects.hash(TipoBoolean.class);
    }
    /**
     * Método que sobreescribe el metodo equals de object para poder ser implementado por TipoBoolean.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoBoolean) {
            var variable = (TipoBoolean) obj;
            return variable.getArg().equals(this.getArg());
        }return false;}
    /**
     * Método que sobreescribe el metodo toString() de object para poder ser implementado por TipoBoolean.
     */
    @Override
    public String toString() {
        return  String.valueOf(this.getArg());
    }
    // Transformaciones ---------------------------------------------
    /**
     * Método que transforma TipoBoolean a TipoBoolean de Scrabble.
     */
    @Override
    public TipoBoolean aTipoBoolean(){
        return FabricaTipoBoolean.getFabricaTipoBoolean().crear(this.getArg());
    }
    // Operaciones --------------------------------------------------
    /**
     * Método que sobreescribe al de ITipo para retornar "y lógico" entre objetos ITipo.
     */
    @Override
    public ITipo ConjuncionLogica(ITipo Tipo) {
        return Tipo.esYLogicoConBoolean(this);
    }
    /**
     * Método que sobreescribe al de ITipo para retornar el "o lógico" entre un TipoNumeroBinario y TipoBoolean
     */
    @Override
    public ITipo DisyuncionLogica(ITipo Tipo) {
        return Tipo.esOLogicoConBoolean(this);
    }
    /**
     * Método que sobreescribe al de ITipo para retornar el "y lógico" entre un TipoNumeroBinario y TipoBoolean.
     */
    @Override
    public ITipo esYLogicoConBinario(TipoNumeroBinario binario) {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < binario.getArg().length(); i++) {
            if (binario.getArg().charAt(i) == '0') {
                cadena.append('0');
            } else {
                if(this.getArg()){
                    cadena.append('1');
                }else{
                    cadena.append('0');
                }
            }
        } return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena.toString());}
    /**
     * Método que sobreescribe al de ITipo para retornar el "y lógico" entre dos TipoBoolean.
     */
    @Override
    public ITipo esYLogicoConBoolean(TipoBoolean bool) {
        if (bool.getArg() && this.getArg()) {
            return FabricaTipoBoolean.getFabricaTipoBoolean().crear(true);
        } else { return FabricaTipoBoolean.getFabricaTipoBoolean().crear(false);}}
    /**
     * Método que sobreescribe al de ITipo para retornar el "o lógico" entre un TipoNumeroBinario y TipoBoolean.
     */
    @Override
    public ITipo esOLogicoConBinario(TipoNumeroBinario binario) {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < binario.getArg().length(); i++) {
            if (binario.getArg().charAt(i) == '0') {
                if(this.getArg()){
                    cadena.append('1');
                }else{
                    cadena.append('0');
                }
            } else {
                cadena.append('1');
            }
        } return FabricaTipoNumeroBinario.getFabricaTipoBinario().crear(cadena.toString());
    }
    /**
     * Método que sobreescribe al de ITipo para retornar el "o lógico" entre un dos TipoBoolean.
     */
    @Override
    public ITipo esOLogicoConBoolean(TipoBoolean bool) {
        if (!bool.getArg() && !this.getArg()) {
            return FabricaTipoBoolean.getFabricaTipoBoolean().crear(false);
        } else { return FabricaTipoBoolean.getFabricaTipoBoolean().crear(true);}}
    /**
     * Método que sobreescribe al de ITipo para retornar la negación de TipoBoolean.
     */
    @Override
    public ITipo Negacion(){
        if(this.getArg()){ return FabricaTipoBoolean.getFabricaTipoBoolean().crear(false);}
        else{ return FabricaTipoBoolean.getFabricaTipoBoolean().crear(true); }}
    /**
     * Método que sobreescribe el de INodo para obtener este TipoBoolean.
     */
    @Override
    public ITipo getValor() {
        return this;
    }

    /**
     * Método que sobreescribe el de AbstractTipo para comparar dos TipoBoolean.
     */
    @Override
    public ITipo compararConBoolean(TipoBoolean Boolean){
        if(this.getArg() == false & Boolean.getArg() == true){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(-1);
        }else if(this.getArg() == Boolean.getArg() ){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(0);
        }else{
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(1);
        }
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un TipoBoolean pueda aceptar un cambio.
     */
    @Override
    public ITipo aceptaCambio() {
        if(this.getArg() == false){
            return FabricaTipoBoolean.getFabricaTipoBoolean().crear(true);
        }else{
            return FabricaTipoBoolean.getFabricaTipoBoolean().crear(false);
        }
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un ITipo pueda o no ser comparado con un TipoBoolean.
     * Implementa Double Dispatch.
     */
    @Override
    public ITipo compararCon(ITipo Tipo){
        return Tipo.compararConBoolean(this);
    }

}
