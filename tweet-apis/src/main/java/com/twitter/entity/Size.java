package com.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {

    private Dimension width;

    private Dimension thumb;

    private Dimension small;

    private Dimension large;
}
