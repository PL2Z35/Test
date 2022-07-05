package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia de datos que representa una historia.
 * 
 * @author : Cristian Plazas
 * @since : 6/27/2022
 */
@Getter
@Setter
public class HistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private long transitAgentId;
    private int highwayId;
    private String date;
}
