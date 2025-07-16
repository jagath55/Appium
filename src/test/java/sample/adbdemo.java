package sample;

import java.io.IOException;

import org.testng.annotations.Test;

public class adbdemo extends parent {
    
    @Test
    
    public void adbtest () throws IOException, InterruptedException {
    	ProcessBuilder pb = new ProcessBuilder("adb", "reboot");
        Process process = pb.start();
        int exitCode = process.waitFor();
        System.out.println("ADB exited with code: " + exitCode);
       

}}
