package com.review.kafka;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Message implements Serializable {
    private Integer id;
    private String content;
    private Long time;
}
