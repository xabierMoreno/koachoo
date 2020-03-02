package com.app.koachoo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Goal {
    private int id;
    private String name;
}
