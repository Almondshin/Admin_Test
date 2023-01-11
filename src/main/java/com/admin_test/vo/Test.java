package com.admin_test.vo;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private int fundcode;
    private String fundname;
    private String contents;
    private String reword;
}
