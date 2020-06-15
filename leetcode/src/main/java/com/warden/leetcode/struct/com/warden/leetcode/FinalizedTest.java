package com.warden.leetcode.struct.com.warden.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

public class FinalizedTest {
	public static void main(String[] args) {
		final FinalizedTest finalizedTest = new FinalizedTest();
		for (int i = 0; i < 8; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						TFutureTask future = finalizedTest.submit();
					}
				}
			}).start();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.gc();
				}
			}
		}).start();
	}
	public TFutureTask submit(){
		TExecutorService TExecutorService = Executors.create();
		TExecutorService.execute();
		return null;
	}
}

class TFutureTask {}

//Executors.java，模拟juc的Executors
class Executors {
	/**
	 * 模拟Executors.createSingleExecutor
	 * @return
	 */
	public static TExecutorService create(){
		return new FinalizableDelegatedTExecutorService(new TThreadPoolExecutor());
	}

	static class FinalizableDelegatedTExecutorService extends DelegatedTExecutorService {

		FinalizableDelegatedTExecutorService(TExecutorService executor) {
			super(executor);
		}

		/**
		 * 析构函数中执行shutdown，修改线程池状态
		 * @throws Throwable
		 */
		@Override
		protected void finalize() throws Throwable {
			super.shutdown();
		}
	}

	static class DelegatedTExecutorService implements TExecutorService {

		protected TExecutorService e;

		public DelegatedTExecutorService(TExecutorService executor) {
			this.e = executor;
		}

		@Override
		public void execute() {
			e.execute();
		}

		@Override
		public void shutdown() {
			e.shutdown();
		}
	}
}

//TThreadPoolExecutor.java，模拟juc的ThreadPoolExecutor
class TThreadPoolExecutor implements TExecutorService {

	/**
	 * 线程池状态，false：未关闭，true已关闭
	 */
	private AtomicBoolean ctl = new AtomicBoolean();

	@Override
	public void execute() {
		//启动一个新线程，模拟ThreadPoolExecutor.execute
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//模拟ThreadPoolExecutor，启动新建线程后，循环检查线程池状态，验证是否会在finalize中shutdown
		//如果线程池被提前shutdown，则抛出异常
		for (int i = 0; i < 1_000_000; i++) {
			if(ctl.get()){
				throw new RuntimeException("reject!!!["+ctl.get()+"]");
			}
		}
	}

	@Override
	public void shutdown() {
		ctl.compareAndSet(false,true);
	}
}

interface TExecutorService {
	void execute();
	void shutdown();
}
