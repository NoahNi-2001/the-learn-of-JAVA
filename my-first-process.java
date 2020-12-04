import java.util.*;
import java.lang.*;

class Mythread extends Thread {
	private static int sum=0;
	private static int i=0;
	String s="";
	public void run() {
		while(true) {
			synchronized(s) {
				try {
					if(i<=1000) {
						sum+=i;
						i++;
						System.out.println("this is "+Thread.currentThread().getName()+" and the sum is "+sum);
						Thread.sleep(100);
					}
					else if(i>100) break;
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
		}
	}
}

public class ThreadTest{
	public static void main(String[]args) {
		for(int i=0;i<10;i++) {
			Mythread x = new Mythread();
			x.start();
		}
		System.out.println("the process has been over");
	}
}
