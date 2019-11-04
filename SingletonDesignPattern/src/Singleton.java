
//This is the class which we desire to make as Singleton(i.e., only one instance is available throughout the application)
public class Singleton {
	//This is the instance which will used through out the application
	private static Singleton singleInstance;

	//Constructor is made private so that no other classes can instantiate a Singleton Class
    private Singleton(){
    }

    //This is the static method used to get the instance of the Singleton Class.
    //Here, we check if the singleInstance is null. If it is null, a new instance of Singleton class is created.
    //For making this thread safe, we 

    public static Singleton getInstance() {
    	//Check if the instance is null(object not initialized)
        if (singleInstance == null) { 
        	//This is critical section. Only one thread can access at a time.
        	//Even if two threads perform the above check and reach hear, one thread cannot access the critical section until its free.
            synchronized (Singleton.class) {
            	//This check is required as Instance might have been instantiated by the first thread thread which got early access. 
            	if (singleInstance == null) {
            		//Instantiating SingleTon Class
            		singleInstance = new Singleton();
            	  }
            }
        }
        //Return the instance of Singleton Class.
        return singleInstance;
    }
}
