package cl.uchile.dcc.scrabble.gui.TiposScrabble;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoNulo;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.FabricaTipoString;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;

/**
 * Clase que unifica las tranformaciones y operaciones posibles entre
 * los tipos de Scrabble poque corresponden a sus clases hijas.
 * Sobreescribe todos los métodos de la interfaz ITipos retornando un TipoNulo.
 * Retornan TipoNulo pues cada clase hija Tipo Scrabble se encargará de responder
 * si existe un "retorno", es decir, un ITIpo no TipoNulo como resultado de una
 * transformación u operación que está permitida. Por lo que, un resultado TipoNulo,
 * es sinónimo de transformacionu operacion no permitida o de "no retorno".
 * Los unicos métodos que no retornan TipoNulo son aTipoString y esSumadoporString,
 * porque, son * las unicas transformaciones y operaciones que todos los tipos Scrabble
 * validan en común.
 * @autor: María Jesús Mellado Tenorio.
 */
public abstract class AbstractTipo implements ITipo {
    /**
    * Metodo que sobreescribe el método Suma de la interfaz ITipo.
    **/
    @Override
    public ITipo Suma(ITipo Tipo){return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método Resta de la interfaz ITipo.
     **/
    @Override
    public ITipo Resta(ITipo Tipo){return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método Multiplica de la interfaz ITipo.
     **/
    @Override
    public ITipo Multiplica(ITipo Tipo){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método Divide de la interfaz ITipo.
     **/
    @Override
    public ITipo Divide(ITipo Tipo){return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método Negacion de la interfaz ITipo.
     **/
    @Override
    public ITipo Negacion(){return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esSumadoPorString de la interfaz ITipo.
     **/
    @Override
    public ITipo esSumadoPorString(TipoString string) {
        return FabricaTipoString.getFabricaTipoString().crear(string + this.toString());
    }
    /**
     * Metodo que sobreescribe el método esSumadoConInt de la interfaz ITipo.
     **/
    @Override
    public ITipo esSumadoConInt(TipoNumeroInt entero){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esRestadoConInt de la interfaz ITipo.
     **/
    @Override
    public ITipo esRestadoConInt(TipoNumeroInt entero){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esMultiplicadoConInt de la interfaz ITipo.
     **/
    @Override
    public ITipo esMultiplicadoConInt(TipoNumeroInt entero){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esDivididoConInt de la interfaz ITipo.
     **/
    @Override
    public ITipo esDivididoConInt(TipoNumeroInt entero){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esSumadoConFloat de la interfaz ITipo.
     **/
    @Override
    public ITipo esSumadoConFloat(TipoNumeroFloat Float){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esRestadoConFloat de la interfaz ITipo.
     **/
    @Override
    public ITipo esRestadoConFloat(TipoNumeroFloat Float){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esMultiplicadoConFloat de la interfaz ITipo.
     **/
    @Override
    public ITipo esMultiplicadoConFloat(TipoNumeroFloat Float){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esDivididoConFloat de la interfaz ITipo.
     **/
    @Override
    public ITipo esDivididoConFloat(TipoNumeroFloat Float){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esSumadoConBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo esSumadoConBinario(TipoNumeroBinario Binario){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esRestadoConBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo esRestadoConBinario(TipoNumeroBinario Binario){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esMultiplicadoConBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo esMultiplicadoConBinario(TipoNumeroBinario Binario){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esDivididoConBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo esDivididoConBinario(TipoNumeroBinario Binario){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esYLogicoConBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo esYLogicoConBinario(TipoNumeroBinario binario){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esYLogicoConBoolean de la interfaz ITipo.
     **/
    @Override
    public ITipo esYLogicoConBoolean(TipoBoolean bool){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esOLogicoConBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo esOLogicoConBinario(TipoNumeroBinario binario){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método esOLogicoConBoolean de la interfaz ITipo.
     **/
    @Override
    public ITipo esOLogicoConBoolean(TipoBoolean bool){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método ConjuncionLogica de la interfaz ITipo.
     **/
    @Override
    public ITipo ConjuncionLogica(ITipo Tipo){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método DisyuncionLogica de la interfaz ITipo.
     **/
    @Override
    public ITipo DisyuncionLogica(ITipo Tipo){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    // Transformaciones
    /**
     * Metodo que sobreescribe el método aTipoString de la interfaz ITipo.
     **/
    @Override
    public ITipo aTipoString(){
        return FabricaTipoString.getFabricaTipoString().crear(this.toString());
    }
    /**
     * Metodo que sobreescribe el método aTipoNumeroFloat de la interfaz ITipo.
     **/
    @Override
    public ITipo aTipoNumeroFloat(){ return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método aTipoNumeroInt de la interfaz ITipo.
     **/
    @Override
    public ITipo aTipoNumeroInt(){return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método aTipoNumeroBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo aTipoNumeroBinario(){return FabricaTipoNulo.getFabricaTipoNulo().crear();}
    /**
     * Metodo que sobreescribe el método aTipoBoolean de la interfaz ITipo.
     **/
    @Override
    public ITipo aTipoBoolean(){
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Metodo que sobreescribe el método compararConInt de la interfaz ITipo.
     **/
    @Override
    public ITipo compararConInt(TipoNumeroInt Int){
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Metodo que sobreescribe el método compararConFloat de la interfaz ITipo.
     **/
    @Override
    public ITipo compararConFloat(TipoNumeroFloat Float){
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Metodo que sobreescribe el método compararConBinario de la interfaz ITipo.
     **/
    @Override
    public ITipo compararConBinario(TipoNumeroBinario Binario){
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Metodo que sobreescribe el método compararConString de la interfaz ITipo.
     **/
    @Override
    public ITipo compararConString(TipoString String){
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Metodo que sobreescribe el método compararConBoolean de la interfaz ITipo.
     **/
    @Override
    public ITipo compararConBoolean(TipoBoolean Boolean){
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Metodo que sobreescribe el método compararCon de la interfaz ITipo.
     **/
    @Override
    public ITipo compararCon(ITipo Tipo) {
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
    /**
     * Metodo que sobreescribe el método aceptaCambio de la interfaz ITipo.
     **/
    @Override
    public ITipo aceptaCambio() {
        return FabricaTipoNulo.getFabricaTipoNulo().crear();
    }
}