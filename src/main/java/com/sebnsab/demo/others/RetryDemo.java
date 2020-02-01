package com.sebnsab.demo.others;

import com.sebnsab.demo.model.DemoException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryDemo {

    @Retryable(maxAttempts=3,value=Exception.class,backoff=@Backoff(delay = 2000,multiplier=2))
    public void methodToRetry(String input) {
        System.out.println("method retrying");
        throw new DemoException("blah blah");
    }

    @Recover
    public void recover2(DemoException d, String input) {
        System.out.println("Recovering2");
        System.out.println(input);
    }
}
