package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.TrafficPoliceDTO;
import com.example.demo.entity.History;

/**
 * Servicios para el objeto agente de transito.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2020
 */
public interface TrafficPoliceService {
    /*
     * Obtiene una lista de todos los agentes de transito.
     * 
     * @return List<TrafficPoliceDTO> : Lista de objetos de transferencia de los agentes de transito.
     */
    public List<TrafficPoliceDTO> allList();

    /*
     * Guarda un nuevo agente de transito.
     * 
     * @params TrafficPoliceDTO : Objeto de transferencia de datos del agente de transito.
     * @return TrafficPoliceDTO : Objeto que se creo.
     */
    public TrafficPoliceDTO saveTransitAgent(TrafficPoliceDTO trafficPolice);

    /*
     * Obtiene un agente de transito por su identificador.
     * 
     * @params long : Identificador del agente de transito.
     * @return TrafficPoliceDTO : Objeto de transferencia de datos del agente de transito.
     */
    public TrafficPoliceDTO getTransitAgentId(Long id);

    /*
     * Actualiza un agente de transito.
     * 
     * @params TrafficPoliceDTO : Objeto de transferencia de datos del agente de transito.
     * @return TrafficPoliceDTO : Objeto de transferencia del agente que se actualizo.
     */
    public TrafficPoliceDTO updateTransitAgent(TrafficPoliceDTO trafficPolice);

    /*
     * Elimina un agente de transito.
     * 
     * @params long : Identificador del agente de transito.
     * @return boolean : True si se elimino, false si no.
     */
    public boolean deleteTransitAgent(Long id);

    /*
     * Metodo para crear una nueva historia para el agente de transito.
     * 
     * @params History : Objeto de transferencia de datos de la historia.
     * @return History : Objeto que se creo.
     */
    public History addHistory(History history);
}