package com.exadel.core.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ManualCard {

    final protected static String RESOURCE_TYPE="dashboard/components/card";

    private String topic;

    private String article;

    private String link;

    private Date pubDate;

}
