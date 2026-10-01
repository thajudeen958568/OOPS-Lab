import java.util.Random;
class Even implements Runnable {
 public int x;
 public Even(int x) {
 this.x = x;
 }
 public void run() {
 System.out.println("New Thread " + x +
 " is EVEN and Square of " + x +
 " is: " + (x * x));
 }
}
class Odd implements Runnable {
 public int x;
 public Odd(int x) {
 this.x = x;
 }
 public void run() {
 System.out.println("New Thread " + x +
 " is ODD and Cube of " + x +
 " is: " + (x * x * x));
 }
}
class A extends Thread {
 public void run() {
 int num;
 Random r = new Random();
 try {
 for (int i = 0; i < 5; i++) {
 num = r.nextInt(100);
 System.out.println("Main Thread and Generated Number is " + num);
 if (num % 2 == 0) {
 Thread t1 = new Thread(new Even(num));
 t1.start();
 } else {
 Thread t2 = new Thread(new Odd(num));
 t2.start();
 }
 Thread.sleep(1000);
 System.out.println();
 }
 } catch (Exception ex) {
 System.out.println(ex.getMessage());
 }
 }
}
public class ThreadProgram {
 public static void main(String[] args) {
 A a = new A();
 a.start();
 }
}

Output:

Main Thread and Generated Number is 24
New Thread 24 is EVEN and Square of 24 is: 576
Main Thread and Generated Number is 17
New Thread 17 is ODD and Cube of 17 is: 4913
Main Thread and Generated Number is 42
New Thread 42 is EVEN and Square of 42 is: 1764
Main Thread and Generated Number is 9
New Thread 9 is ODD and Cube of 9 is: 729
Main Thread and Generated Number is 65
New Thread 65 is ODD and Cube of 65 is: 274625
