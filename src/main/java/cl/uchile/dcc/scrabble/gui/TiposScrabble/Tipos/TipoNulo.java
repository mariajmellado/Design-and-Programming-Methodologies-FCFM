package cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.AbstractTipo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;
import java.util.Objects;

/**
 * Clase que hereda de la clase abstracta AbstractTipos para
 * permitir la implementación de "Null Pattern".
 * No tiene constructor porque no recibe parámetros a partir del cual
 * construirse porque NO es un tipo de Scrabble.
 @autor: María Jesús Mellado Tenorio.
 */
public class TipoNulo extends AbstractTipo {
    /**
     * Método que sobreescribe el metodo hashCode() de object para poder ser implementado
     * por TipoNulo.
     */
    @Override
    public int hashCode(){
        return Objects.hash(TipoNulo.class);
    }
    /**
     * Método que sobreescribe el metodo equals de object para poder ser implementado por TipoNulo.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoNulo) {
            var variable = (TipoNulo) obj;
            return variable.getArg() == this.getArg();
        } return false; }
    /**
     * Método que sobreescribe el de INodo para obtener este TipoNulo.
     */
    @Override
    public ITipo getValor() {
        return this;
    }
    /**
     * Método que retorna el valor que contiene este objeto.
     */
    public Object getArg() {
        return null;
    }
    /**
     * Método que sobreescribe el de ITipos porque como TipoNulo no es uno de Scrabble, no puede
     * ser sumado con un TipoString.
     */
    @Override
    public ITipo esSumadoPorString(TipoString string) {
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Método que sobreescribe el de ITipos porque como TipoNulo no es uno de Scrabble, no puede
     * ser transformado a un TipoString.
     */
    @Override
    public ITipo aTipoString(){
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }

}
