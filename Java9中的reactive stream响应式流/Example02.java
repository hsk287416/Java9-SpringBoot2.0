package pack01;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;

/**
 * 发布/过滤器/订阅模式
 */
public class Example02 {
    public static void main(String[] args) throws InterruptedException {
        // 1. 定义发布者，发布的数据类型是Integer
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        // 2. 创建一个过滤器，它用于将Integer转换成String
        MyProcessor processor = new MyProcessor();

        // 3. 发布者和过滤器建立订阅关系
        publisher.subscribe(processor);

        // 4. 创建订阅者
        Subscriber<String> subscriber = new Subscriber<>() {
            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                System.out.println("接收到一个item：" + item);
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("MyProcessor关闭了订阅");
            }
        };

        // 5. 发布者和订阅者建立订阅关系
        processor.subscribe(subscriber);

        // 6. 生产数据并发布
        publisher.submit(1);
        publisher.submit(2);
        publisher.submit(3);

        // 7. 结束后关闭发布者（此处应该放在finally中）
        publisher.close();
        Thread.currentThread().join(1000);
    }
}
