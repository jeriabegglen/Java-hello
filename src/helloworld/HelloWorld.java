
package helloworld;

import static kiss.API.*;

public class HelloWorld {
    void testrun(){
        outExpect("Hello World!");
        run();
        outClose();
    }
    
    
    void run(){
        println("Hello World!");
    }   
}
