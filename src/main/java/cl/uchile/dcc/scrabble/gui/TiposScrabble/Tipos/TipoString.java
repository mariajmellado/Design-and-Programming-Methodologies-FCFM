package cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNumeroFloat;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNumeroInt;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoString;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.AbstractTipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;

import java.util.Objects;
import java.util.Random;

/**
 * Clase que hereda de la clase abstracta AbstractTipos.
 * Implementa el tipo string de Scrabble.
 * Sobreescribe métodos de la clase abstracta que permiten un retorno
 * válido (no TipoNulo) de una transformacion u operacion que lo insmiscuye.
 * @autor: María Jesús Mellado Tenorio.
 */
public class TipoString extends AbstractTipo{
    private String arg;
    /**
     * Constructor de la clase TipoString.
     * Establece su único atributo de tipo String de Java.
     */
    public TipoString(String argumento) {
        this.arg = argumento;
    }
    /**
     * Método que retorna el valor que contiene este objeto.
     */
    public String getArg() {
        return this.arg;
    }
    /**
     * Método que permite que otro tipo pueda ser sumado a un TipoString pero no al revés.
     */
    @Override
    public ITipo Suma(ITipo tipo) { return tipo.esSumadoPorString(this);}
    /**
     * Método que sobreescribe el metodo toString de object para poder hacer uso de el en TipoString.
     */
    @Override
    public String toString(){ return String.valueOf(this.getArg()); }
    /**
     * Método que sobreescribe el metodo hashCode de object para poder usarlo en TipoString.
     */
    @Override
    public int hashCode() { return Objects.hash(TipoString.class); }
    /**
     * Método que sobreescribe el metodo equals de object para poder hacer uso de el en TipoString.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoString) {
            var variable = (TipoString) obj;
            return variable.getArg().equals(this.getArg());}
        return false;}
    /**
     * Método que sobreescribe el de INodo para obtener este TipoString.
     */
    @Override
    public ITipo getValor() { return this;}
    /**
     * Método que sobreescribe el de AbstractTipo para comparar dos TipoString.
     */
    public ITipo compararConString(TipoString String){
        if(this.getArg().length() > String.getArg().length()){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(-1);
        }else if(this.getArg().length() == String.getArg().length() ){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(0);
        }else{
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(1);
        }
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un TipoString pueda aceptar un cambio.
     */
    @Override
    public ITipo aceptaCambio() {
        // h es por poner algun valor, pero la verdad es que da lo mismo el caracter, el largo
        // es lo importante.
        return FabricaTipoString.getFabricaTipoString().crear(this.getArg()+"h");
        /* A continuación, el caso a<b de la comparacion. Como esto es a efectos del testing, usar lo de arriba
        o lo de abajo es análogo. Se usa el de arriba sin pérdida de generalidad.*/
        // return FabricaTipoString.getFabricaTipoString().crear(this.getArg().removeEnd());
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un ITipo pueda o no ser comparado con un TipoString.
     * Implementa Double Dispatch.
     */
    @Override
    public ITipo compararCon(ITipo Tipo) {
        return Tipo.compararConString(this);
    }
}