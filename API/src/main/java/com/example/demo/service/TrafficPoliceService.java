package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TrafficPolice;
import com.example.demo.exception.MyException;

/**
 * Servicios para el objeto agente de transito.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
public interface TrafficPoliceService {
    /*
     * Metodo que obtiene una lista de todos los agentes de transito.
     * 
     * @return List : Lista de objetos del agente de transito.
     */
    public List<TrafficPolice> allList();

    /*
     * Metodo que guarda un nuevo agente de transito.
     * 
     * Guarda los datos del nuevo objeto en la base de datos.
     * Genera una nueva historia.
     * 
     * @params TrafficPolice: Objeto agente de transito.
     * 
     * @return TrafficPolice: Si el agente de transito no existe en la base de
     * datos.
     * 
     * @return null: Si el agente de transito ya existe en la base de datos.\
     * 
     * @return null: Si la via que se desea modificar ya fue asignada 3 veces o si
     * la via tiene un nivel de congestion mayor a 30.
     * 
     * @return null: si la via que se la asignar al agente de transito ya a sido
     * registrada 3 veces o si la via tiene un nivel de congestion mayor a 30.
     */
    public TrafficPolice saveTransitAgent(TrafficPolice trafficPolice);

    /*
     * Metodo que obtiene un agente de transito por su identificador.
     * 
     * @params long : Identificador del agente de transito.
     * 
     * @return TrafficPolice : Si existe un agente de transito con el identificador.
     * 
     * @Throws Exception : Si no existe un agente de transito con el identificador.
     */
    public TrafficPolice getTransitAgentId(Long id) throws MyException;

    /*
     * Metodo que actualiza un agente de transito.
     * 
     * Actualiza cada parametro del agente de transito.
     * Exceptuando el identificador.
     * Crea una nueva historia.
     * 
     * @params TrafficPolice : Objeto tipo agente de transito.
     * 
     * @return TrafficPolice : Si existe el agente de transito.
     * 
     * @return null: Si la via que se desea modificar ya fue asignada 3 veces o si
     * la via tiene un nivel de congestion mayor a 30.
     * 
     * @return null: si no existe el agente de transito.
     */
    public TrafficPolice updateTransitAgent(TrafficPolice trafficPolice);

    /*
     * Metodo que elimina un agente de transito.
     * 
     * Busca el agente de transito por su identificador y lo elimina.
     * 
     * @params long : Identificador del agente de transito.
     * 
     * @throws Exception : Si no existe un agente de transito con el identificador.
     */
    public void deleteTransitAgent(Long id) throws MyException;
}