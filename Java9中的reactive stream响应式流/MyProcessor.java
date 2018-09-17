package pack01;

import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;

/**
 * 过滤器--用于把Integer转换成String
 */
public class MyProcessor extends SubmissionPublisher<String> implements Processor<Integer, String> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("处理器接收到数据：" + item);
        this.submit("数字：" + item.toString());
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("publisher关闭了订阅");
        this.close();
    }
}
