package br.com.catolicapb.messenger.dto;

import lombok.Data;

@Data
public class ScheduleRequestDTO {

    private Long vetId;

    private Long petId;

    private String dateSchedule;

    private String scheduleShift;

    private String scheduleStatus;
}
