package pack01;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.IntStream;

/**
 * 发布/订阅的基本模式
 */
public class Example01 {
    public static void main(String[] args) throws InterruptedException {
        // 1. 定义发布者，发布的数据类型是Integer
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();

        // 2. 定义订阅者
        Subscriber<Integer> subscriber = new Subscriber<>() {
            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                // 保存订阅关系，需要用它来响应发布者
                this.subscription = subscription;
                //请求1个数据
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                // 接收到1个数据并处理
                System.out.println("接收到数据：" + item);
                // 处理完之后，再请求一个数据
                this.subscription.request(1);

                // 或者已经达到了目标，调用cancel告诉发布者不再接收数据了
                // this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
                // 出错时打印异常，关闭订阅
                throwable.printStackTrace();
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                System.out.println("订阅已经关闭");
            }
        };

        // 3. 发布者和订阅者建立订阅关系
        publisher.subscribe(subscriber);

        // 4. 生产数据并发布
        // 发布者的submit是一个阻塞方法
        // 当发布者的缓冲池的item的数量达到256时，就不会再进行数据生产，而是进入阻塞状态
        // 直到订阅者将数据取走（数量不满256），才会继续进行生产
        IntStream.rangeClosed(1, 1000).forEach(i -> {
            System.out.println("生产了一条数据：" + i);
            publisher.submit(i);
        });

        // 5. 结束后关闭发布者（此处应该放在finally中）
        publisher.close();

        Thread.currentThread().join(1000);
    }
}
