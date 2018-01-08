package com.alibaba.dubbo.demo.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NameReq implements Serializable {

    private static final long serialVersionUID = 4495298420794425183L;

    private String name;
}
