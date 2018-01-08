package com.alibaba.dubbo.demo.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DepartmentReq implements Serializable {

    private static final long serialVersionUID = 1104199821455680223L;

    private String department;
}
