package com.alibaba.dubbo.demo.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class TestReq implements Serializable {

    private static final long serialVersionUID = 3773482484642552219L;

    private String content;
}
