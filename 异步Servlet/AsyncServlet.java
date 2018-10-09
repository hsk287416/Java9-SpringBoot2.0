package controller;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 开启异步Servlet，需要在@WebServlet注解中添加一些设置
 */
@WebServlet(name = "AsyncServlet", value = "/async", loadOnStartup = 1, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long startTimestamp = System.currentTimeMillis();

        // 1.开启异步
        AsyncContext asyncContext = request.startAsync();

        // 2.异步执行业务代码
        CompletableFuture.runAsync(() -> doSomething(asyncContext));

        long endTimestamp = System.currentTimeMillis();
        System.out.println("异步处理，耗时：" + (endTimestamp - startTimestamp) + "毫秒");
    }

    private void doSomething(AsyncContext asyncContext) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ServletResponse response = asyncContext.getResponse();
        try (PrintWriter writer = response.getWriter()) {
            writer.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 业务代码处理完毕，通知结束
        asyncContext.complete();
    }
}
