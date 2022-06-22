package com.lwch.survey.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProcessStatus {
	
    private String id;

    private String status;

    private String formkey;

    private String name;

    private String number;

    private String procinstid;

}