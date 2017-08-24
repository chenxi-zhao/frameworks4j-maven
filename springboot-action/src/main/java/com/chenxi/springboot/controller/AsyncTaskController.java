package com.chenxi.springboot.controller;

import com.chenxi.springboot.service.impl.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Created by chenxi on 2017/8/23.
 *
 * @author chenxi
 */
@RestController
@RequestMapping("/asynctask")
public class AsyncTaskController {
    private AsyncTaskService asyncTaskService;

    @Autowired
    public void setAsyncTaskService(AsyncTaskService asyncTaskService) {
        this.asyncTaskService = asyncTaskService;
    }

    @GetMapping("/dotask")
    public String doTask() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTaskService.doTaskOne();
        Future<String> task2 = asyncTaskService.doTaskTwo();
        Future<String> task3 = asyncTaskService.doTaskThree();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        return "任务全部完成，总耗时：" + (end - start) + "毫秒";
    }
}
