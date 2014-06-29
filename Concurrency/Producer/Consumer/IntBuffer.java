
public class IntBuffer {
	private int index;
	private int[] buffer = new int[8];
	public  synchronized void add(int num){
		while(index == buffer.length-1){
			try{
				wait();
			}
			catch(InterruptedException ex){

			}
		}
		buffer[index++] = num;
		notifyAll();	

	}
	public synchronized int remove(){
		while(index == 0){
			try{
				wait();
			}
			catch(InterruptedException ex){

			}
		}
		int ret =	buffer[--index];
		notifyAll();
		return ret;
	}

	public static void main(String[] args) {
		IntBuffer buffer = new IntBuffer();
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		producer.start();
		consumer.start();
	}
}

