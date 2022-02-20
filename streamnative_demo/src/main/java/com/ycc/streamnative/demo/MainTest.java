package com.ycc.streamnative.demo;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author ycc
 * @date 2022/2/20
 * @desc
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();


        env.execute();
    }

}
