
public class InterThread implements Runnable{
int queue=0;
	/**
	 * @param args
	 */
    public synchronized void produce()
    {
         try{
        	 while(true)
        	 {
        		 queue++;
        		 System.out.println("Inside producers "+queue);
        		 if(queue==10)
        		 {
        			 wait();
        		 }
             }
         }
         catch(Exception e){
        	 e.printStackTrace();
         }
    }
    public synchronized void consume()
    {
         try{
        	 while(true)
        	 {
        		 queue--;
        		 System.out.println("Inside consumers "+queue);
        		 if(queue==1)
        		 {
        			 notify();
        			 wait();
        		 }
             }
         }
         catch(Exception e){
        	 e.printStackTrace();
         }
    }

	public void run() {
		// TODO Auto-generated method stub
		produce();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterThread p=new InterThread();
		InterThread c=new InterThread();
	    Thread t1=new Thread(p);
	    Thread t2=new Thread(c);
	    t1.start();
	    t2.start();
	}
}
