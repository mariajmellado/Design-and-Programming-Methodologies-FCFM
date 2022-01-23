package cl.uchile.dcc.scrabble.gui.TiposScrabble.Tipos;

import cl.uchile.dcc.scrabble.gui.AST.INodo;
import cl.uchile.dcc.scrabble.gui.FabricaITipo.*;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.AbstractNumero;
import cl.uchile.dcc.scrabble.gui.TiposScrabble.ITipo;

import java.util.Objects;
import java.util.Random;

/**
 * Clase que hereda de la clase abstracta AbstractTipos.
 * Implementa el tipo numero float de Scrabble.
 * Sobreescribe métodos de la clase abstracta que permiten un retorno
 * válido (no TipoNulo) de una transformacion u operacion que lo insmiscuye.
 * @autor: María Jesús Mellado Tenorio.
 */
public class TipoNumeroFloat extends AbstractNumero{
    private double arg;
    /**
     * Constructor de la clase TipoNumeroFloat.
     * Establece su único atributo que es de tipo double de Java.
     */
    public TipoNumeroFloat(double argumento) {this.arg = argumento;}
    /**
     * Método que retorna el valor que contiene el objeto TipoNumeroFloat.
     */
    public double getArg() { return this.arg;}
    /**
     * Método que sobreescribe el metodo hashCode() de object para poder ser implementado por TipoNumeroFloat.
     */
    @Override
    public int hashCode() {
        return Objects.hash(TipoNumeroFloat.class);
    }
    /**
     * Método que sobreescribe el metodo equals de object para poder ser implementado por TipoNumeroInt.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoNumeroFloat) {
            var variable = (TipoNumeroFloat) obj;
            return variable.getArg() == this.getArg();}
        return false;}
    /**
     * Método que sobreescribe el metodo toString() de object para poder ser implementado por TipoNumeroInt.
     */
    @Override
    public String toString() {
        return  String.valueOf(this.getArg());
    }
    // Transformaciones
    /**
     * Método que transforma TipoNumeroFloat a TipoNumeroFloat de Scrabble.
     */
    @Override
    public TipoNumeroFloat aTipoNumeroFloat(){
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(this.getArg());
    }
    // Operaciones de segunda instancia.
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de un TipoNumeroInt con TipoNumeroFloat.
     * @return
     */
    @Override
    public ITipo esSumadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(entero.aTipoNumeroFloat().getArg() + this.getArg()); }
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de un TipoNumeroInt con TipoNumeroFloat.
     */
    @Override
    public ITipo esRestadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(entero.aTipoNumeroFloat().getArg() - this.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion de un TipoNumeroInt con TipoNumeroFloat.
     */
    @Override
    public ITipo esMultiplicadoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(entero.aTipoNumeroFloat().getArg() * this.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la division de un TipoNumeroInt con TipoNumeroFloat.
     */
    @Override
    public ITipo esDivididoConInt(TipoNumeroInt entero) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(entero.aTipoNumeroFloat().getArg() / this.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la suma dos TipoNumeroFloat.
     */
    @Override
    public ITipo esSumadoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(Float.getArg() + this.getArg()); }
    /**
     * Método que sobreescribe el de ITipo para retornar la resta dos TipoNumeroFloat.
     */
    @Override
    public ITipo esRestadoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(Float.getArg() - this.getArg());
    }
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicacion dos TipoNumeroFloat.
     */
    @Override
    public ITipo esMultiplicadoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(Float.getArg() * this.getArg()); }
    /**
     * Método que sobreescribe el de ITipo para retornar la division de dos TipoNumeroFloat.
     */
    @Override
    public ITipo esDivididoConFloat(TipoNumeroFloat Float) {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(Float.getArg() / this.getArg());}
    /**
     * Método que sobreescribe el de ITipo para retornar la suma de un TipoNumeroFloat con un ITipo.
     */
    @Override
    public ITipo Suma(ITipo numero) { return numero.esSumadoConFloat(this); }
    /**
     * Método que sobreescribe el de ITipo para retornar la resta de un TipoNumeroFloat con un ITipo.
     */
    @Override
    public ITipo Resta(ITipo numero) {
        return numero.esRestadoConFloat(this);
    }
    /**
     * Método que sobreescribe el de ITipo para retornar la multiplicación de un TipoNumeroFloat con un ITipo.
     */
    @Override
    public ITipo Multiplica(ITipo numero) { return numero.esMultiplicadoConFloat(this); }
    /**
     * Método que sobreescribe el de ITipo para retornar la division de un TipoNumeroFloat con un ITipo.
     */
    @Override
    public ITipo Divide(ITipo numero) {return numero.esDivididoConFloat(this);}
    /**
     * Método que sobreescribe el de ITipo para retornar la negacion de TipoNumeroFloat.
     */
    @Override
    public ITipo Negacion() {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(-this.getArg());
    }
    /**
     * Método que sobreescribe el de INodo para obtener este TipoNumeroFloat.
     */
    @Override
    public ITipo getValor() {return this;}
    /**
     * Método que sobreescribe el de AbstractTipo para comparar dos TipoNumeroFloat.
     */
    public ITipo compararConFloat(TipoNumeroFloat Float){
        if(this.getArg() > Float.getArg()){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(-1);
        }else if(this.getArg() == Float.getArg() ){
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(0);
        }else{
            return FabricaTipoNumeroInt.getFabricaTipoInt().crear(1);
        }
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un TipoNumeroFloat pueda aceptar un cambio.
     */
    @Override
    public ITipo aceptaCambio() {
        return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(this.getArg() + 1.0);
        /* A continuación, el caso a<b de la comparacion. Como esto es a efectos del testing, usar lo de arriba
        o lo de abajo es análogo. Se usa el de arriba sin pérdida de generalidad.*/
        // return FabricaTipoNumeroFloat.getFabricaTipoFloat().crear(this.getArg() - 1.0);
    }
    /**
     * Método que sobreescribe el de AbstractTipo para que un ITipo pueda o no ser comparado con un TipoNumeroFloat.
     * Implementa Double Dispatch.
     */
    @Override
    public ITipo compararCon(ITipo Tipo){
        return Tipo.compararConFloat(this);
    }
}