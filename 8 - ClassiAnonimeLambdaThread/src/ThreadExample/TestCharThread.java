package ThreadExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCharThread extends Thread{

    private Logger log = LoggerFactory.getLogger(TestCharThread.class);

    @Override
    public void run() {
        char[] arr = {'a','b','c','d','e','f','g','h','i','l'};
        for (int i = 0; i < arr.length; i++) {
            try {
                log.info("Char: " + arr[i]);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
