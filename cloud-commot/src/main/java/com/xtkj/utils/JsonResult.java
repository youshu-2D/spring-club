package com.xtkj.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonResult<T> {

    private T t;
    private int code;
    private String msg;

}
