Service中onRebind方法被调用，只要符合两个必要条件就行

    （1）服务中onUnBind方法返回值为true

    （2）服务对象被解绑后没有被销毁，之后再次被绑定

通过startForeground让服务变成前台服务并显示通知，这时必须要setSmallIcon，否则会显示默认的通知，不显示自定义通知！！！

Service和Thread的关系

不少Android初学者都可能会有这样的疑惑，Service和Thread到底有什么关系呢？什么时候应该用Service，什么时候又应该用Thread？
答案可能会有点让你吃惊，因为Service和Thread之间没有任何关系！

之所以有不少人会把它们联系起来，主要就是因为Service的后台概念。
Thread我们大家都知道，是用于开启一个子线程，在这里去执行一些耗时操作就不会阻塞主线程的运行。
而Service我们最初理解的时候，总会觉得它是用来处理一些后台任务的，一些比较耗时的操作也可以放在这里运行，这就会让人产生混淆了。
但是，如果我告诉你Service其实是运行在主线程里的，你还会觉得它和Thread有什么关系吗？让我们看一下这个残酷的事实吧。