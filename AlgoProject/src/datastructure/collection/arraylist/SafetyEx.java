package datastructure.collection.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SafetyEx {

	public static void main(String[] args) {
		// Arraylist에 값을 insert 작업을 스레드를 이용해서 병렬로 진행
		//1000개의 값을 arraylist에 스레드 이용 동시 저장
		List<Integer> list = new ArrayList();
		int threadCount =1000;
		
		/*
		 * 스레드 풀 생성(32개의 스레드 미리 생성) 
		 * 스레드를 요청하면 할당 전 스레드를 할당 -> 바로작업
		 * 스레드 풀에 할당 스레드가 없으면 대기
		 * 
		 * 
		 * */
		ExecutorService ececutorService = Executors.newFixedThreadPool(32);
		
		for(int i=0;i<threadCount; i++) {
			final int value =i;
			executorService.submit(()->{
				list.add(value);
			}
			);
		}
		 
		executorService.shutdown();
		executorService.awaitTermination(5,TimeUnit.SECONDS);
		
		System.out.println("목표 크기 :" +  threadCount);
		System.out.println("실제 리스트 크기 : " + list.size());
	}catch(Exception e) {
		e.printStackTrace();
	}

}
