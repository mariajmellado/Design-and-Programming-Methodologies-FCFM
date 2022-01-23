package cl.uchile.dcc.scrabble.gui.TiposScrabble;
import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos.*;

/**
 * Interfaz que posibilita las transformaciones de y operaciones entre los
 * Tipos Scrabble que la implementan.
 * Extiende de INodo porque es representa el "Nodo Hoja" de un AST.
 * @autor: María Jesús Mellado Tenorio.
 */
public interface ITipo extends INodo{
    /**
     * Método que permite la suma entre dos ITipos.
     */
    ITipo Suma(ITipo Tipo);
    /**
     * Método que permite la resta entre dos ITipos.
     */
    ITipo Resta(ITipo Tipo);
    /**
     * Método que permite la multiplicación entre dos ITipos.
     */
    ITipo Multiplica(ITipo Tipo);
    /**
     * Método que permite la división entre dos ITipos.
     */
    ITipo Divide(ITipo Tipo);
    /**
     * Método que permite la negación de un ITipo.
     */
    ITipo Negacion();
    /**
     * Método que permite hacer "y lógico" entre dos ITipos.
     */
    ITipo ConjuncionLogica(ITipo Tipo);
    /**
     * Método que permite hacer "o lógico" entre dos ITipos.
     */
    ITipo DisyuncionLogica(ITipo Tipo);
    /**
     * Método que permite sumar a un TipoString, un ITipo.
     */
    ITipo esSumadoPorString(TipoString string);
    /**
     * Método que permite sumarle un TipoNumeroInt a un ITipo.
     */
    ITipo esSumadoConInt(TipoNumeroInt entero);
    /**
     * Método que permite restarle un TipoNumeroInt a un ITipo.
     */
    ITipo esRestadoConInt(TipoNumeroInt entero);
    /**
     * Método que permite multiplicarle un TipoNumeroInt a un ITipo.
     */
    ITipo esMultiplicadoConInt(TipoNumeroInt entero);
    /**
     * Método que permite dividirle un TipoNumeroInt a un ITipo.
     */
    ITipo esDivididoConInt(TipoNumeroInt entero);
    /**
     * Método que permite sumarle un TipoNumeroFloat a un ITipo.
     */
    ITipo esSumadoConFloat(TipoNumeroFloat Float);
    /**
     * Método que permite restarle un TipoNumeroFloat a un ITipo.
     */
    ITipo esRestadoConFloat(TipoNumeroFloat Float);
    /**
     * Método que permite multiplicarle un TipoNumeroFloat a un ITipo.
     */
    ITipo esMultiplicadoConFloat(TipoNumeroFloat Float);
    /**
     * Método que permite dividirle un TipoNumeroFloat a un ITipo.
     */
    ITipo esDivididoConFloat(TipoNumeroFloat Float);
    /**
     * Método que permite sumarle un TipoNumeroBinario a un ITipo.
     */
    ITipo esSumadoConBinario(TipoNumeroBinario Binario);
    /**
     * Método que permite restarle a un TipoNumeroBinario a un ITipo.
     */
    ITipo esRestadoConBinario(TipoNumeroBinario Binario);
    /**
     * Método que permite multiplicarle un TipoNumeroBinario a un ITipo.
     */
    ITipo esMultiplicadoConBinario(TipoNumeroBinario Binario);
    /**
     * Método que permite dividirle un TipoNumeroBinario a un ITipo.
     */
    ITipo esDivididoConBinario(TipoNumeroBinario Binario);
    /**
     * Método que permite hacer "y lógico" con un TipoBinario, a un ITipo.
     */
    ITipo esYLogicoConBinario(TipoNumeroBinario binario);
    /**
     * Método que permite hacer "y lógico" con un TipoBoolean, a un ITipo.
     */
    ITipo esYLogicoConBoolean(TipoBoolean bool);
    /**
     * Método que permite hacer "o lógico" con un TipoBinario, a un ITipo.
     */
    ITipo esOLogicoConBinario(TipoNumeroBinario binario);
    /**
     * Método que permite hacer "o lógico" con un TipoBoolean, a un ITipo.
     */
    ITipo esOLogicoConBoolean(TipoBoolean bool);
    /**
     * Método que permite transformar un ITipo a un TipoString.
     */
    ITipo aTipoString();
    /**
     * Método que permite transformar un ITipo a un TipoNumeroFloat.
     */
    ITipo aTipoNumeroFloat();
    /**
     * Método que permite transformar un ITipo a un TipoNumeroInt.
     */
    ITipo aTipoNumeroInt();
    /**
     * Método que permite transformar un ITipo a un TipoNumeroBinario.
     */
    ITipo aTipoNumeroBinario();
    /**
     * Método que permite transformar un ITipo a un TipoBoolean.
     */
    ITipo aTipoBoolean();
    /**
     * Método que permite comparar dos ITipos del mismo tipo.
     */
    ITipo compararCon(ITipo Tipo);
    /**
     * Método que permite comparar un ITipo con un TipoNumeroInt.
     */
    ITipo compararConInt(TipoNumeroInt Int);
    /**
     * Método que permite comparar un ITipo con un TipoNumeroFloat.
     */
    ITipo compararConFloat(TipoNumeroFloat Float);
    /**
     * Método que permite comparar un ITipo con un TipoNumeroBinario.
     */
    ITipo compararConBinario(TipoNumeroBinario Binario);
    /**
     * Método que permite comparar un ITipo con un TipoString.
     */
    ITipo compararConString(TipoString String);
    /**
     * Método que permite comparar un ITipo con un TipoBoolean.
     */
    ITipo compararConBoolean(TipoBoolean Boolean);
    /**
     * Método que permite a un ITipo aceptar ser actualizado.
     */
    ITipo aceptaCambio();
}

