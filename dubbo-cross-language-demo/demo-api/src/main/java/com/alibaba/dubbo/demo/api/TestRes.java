package com.alibaba.dubbo.demo.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestRes implements Serializable {

    private static final long serialVersionUID = 5942267842130734181L;

    private String content;
}
