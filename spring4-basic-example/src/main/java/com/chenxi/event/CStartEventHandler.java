package com.chenxi.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * Created by chenxi on 2017/4/5.
 *
 * @author chenxi
 */
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent>{

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("ContextStartedEvent Received");
    }
}
