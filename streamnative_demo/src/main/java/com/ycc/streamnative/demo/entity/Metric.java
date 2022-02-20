package com.ycc.streamnative.demo.entity;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author ycc
 * @desc
 */
public class Metric {

    private Map<String, String> tags;
    private Map<String, BigDecimal> metrics;
    private long eventTime;
    public String getTag(String name) {
        return tags.get(name);
    }
    public BigDecimal getMetric(String name) {
        return metrics.get(name);
    }

}
